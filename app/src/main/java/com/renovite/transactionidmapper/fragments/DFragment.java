package com.renovite.transactionidmapper.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.renovite.transactionidmapper.R;
import com.renovite.transactionidmapper.activities.AppController;
import com.renovite.transactionidmapper.interfaces.DlgInterface;
import com.renovite.transactionidmapper.receviers.TransactionReceiver;
import com.renovite.transactionidmapper.utils.Constants;
import com.renovite.transactionidmapper.utils.Utils;

import java.math.BigDecimal;

import co.poynt.api.model.Business;
import co.poynt.api.model.Transaction;

/**
 * Created by sushil.kumar on 22-12-2017.
 */

public class DFragment extends DialogFragment implements View.OnClickListener {

    TextView transaction_id, transaction_type, amount, titlemessage;
    TextInputLayout phoneWrapper, facebookWrapper;
    EditText facebookId, phone;
    RelativeLayout update_button_bottom, cancel_button_bottom;
    LinearLayout reward_section;
    CoordinatorLayout main_dialog_laoyut;
    ImageView imageView_close;
    Transaction transaction;
    PopupWindow mPopupWindow;
    private DlgInterface mListener;

    public static DFragment newInstance(Transaction num) {
        DFragment f = new DFragment();

        f.setCancelable(false);

        Bundle args = new Bundle();
        args.putParcelable(Constants.TRANSACTION_ITEM, num);
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        View rootView = inflater.inflate(R.layout.customer_id_mapper_dialog, container,
                false);
        transaction_id = rootView.findViewById(R.id.transaction_id);
        transaction_type = rootView.findViewById(R.id.trasaction_type);
        amount = rootView.findViewById(R.id.amount);
        facebookId = rootView.findViewById(R.id.facebookId);
        phone = rootView.findViewById(R.id.phone);
        update_button_bottom = rootView.findViewById(R.id.update_button_bottom);
        cancel_button_bottom = rootView.findViewById(R.id.cancel_button_bottom);
        reward_section = rootView.findViewById(R.id.reward_section);
        titlemessage = rootView.findViewById(R.id.titlemessage);

        main_dialog_laoyut = rootView.findViewById(R.id.main_dialog_laoyut);
        phoneWrapper = rootView.findViewById(R.id.phoneWrapper);
        facebookWrapper = rootView.findViewById(R.id.facebookWrapper);
        imageView_close = rootView.findViewById(R.id.imageView_close);
        imageView_close.setOnClickListener(this);
        update_button_bottom.setOnClickListener(this);
        cancel_button_bottom.setOnClickListener(this);


        getDialog().setTitle("Transaction Mapper");

        if (bundle != null) {
            transaction = bundle.getParcelable(Constants.TRANSACTION_ITEM);

            setTransactionValues(transaction);
        }

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        mListener = (DlgInterface) activity;
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        mListener = null;
        super.onDetach();
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow()
                .getAttributes().windowAnimations = R.style.DialogAnimation;

        return dialog;
    }

    @Override
    public void onClick(View view) {
        if (view == imageView_close || view == cancel_button_bottom)
            mListener.dismiss();
        else {
            if (view == update_button_bottom) {

                if (mPopupWindow != null) {
                    mPopupWindow.dismiss();
                    mPopupWindow = null;
                }


                if (phone.getText().toString().isEmpty() || phone.getText().length() < 7) {
                    if (mPopupWindow == null) {
                        mPopupWindow = Utils.createPopUpWindow(view.getContext(), main_dialog_laoyut);
                        if (phone.getText().length() > 0 && phone.getText().length() < 7) {
                            TextView message = mPopupWindow.getContentView().findViewById(R.id.tv);
                            message.setText(Constants.MESSAGE);

                        }


                        View close = mPopupWindow.getContentView().findViewById(R.id.close);
                        if (Build.VERSION.SDK_INT >= 21) {
                            mPopupWindow.setElevation(5.0f);
                        }
                        close.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                mPopupWindow.dismiss();
                                mPopupWindow = null;
                            }
                        });
                        mPopupWindow.showAsDropDown(titlemessage);
                    }


                } else {
                    if (mPopupWindow != null)
                        mPopupWindow.dismiss();

                    AppController.getInstance().setPhoneNumber(phone.getText().toString());


                    TransactionReceiver r = new TransactionReceiver();
                    r.getBusinessDetails(getContext(), AppController.getInstance().getTransaction());
                    mListener.update();

                }
            }
        }

    }




    public void setTransactionValues(Transaction transaction) {
        String txnIdString = "#" + transaction.getId().toString().substring(0, transaction.getId().toString().indexOf("-"));
        transaction_id.setText("Trans ID " + txnIdString);
        transaction_type.setText(transaction.getAction().name());
        amount.setText("Amount : " + Utils.getCurrencySymbol(transaction.getAmounts().getCurrency()) + " " + Utils.appendDecimal(transaction.getAmounts().getTransactionAmount()));

    }
}