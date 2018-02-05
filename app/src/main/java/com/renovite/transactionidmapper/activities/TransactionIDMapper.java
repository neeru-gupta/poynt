package com.renovite.transactionidmapper.activities;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.renovite.transactionidmapper.R;
import com.renovite.transactionidmapper.database.DbShareprefence;
import com.renovite.transactionidmapper.fragments.DFragment;
import com.renovite.transactionidmapper.interfaces.DlgInterface;
import com.renovite.transactionidmapper.services.NetworkIntentService;
import com.renovite.transactionidmapper.utils.Constants;
import com.renovite.transactionidmapper.utils.TextViewUndoRedo;

import org.json.JSONObject;


import co.poynt.api.model.Transaction;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class TransactionIDMapper extends AppCompatActivity implements DlgInterface, View.OnClickListener {

    private final static String TAG = " TransactionIDMapper ";
    FragmentManager fm = getSupportFragmentManager();
    DFragment dFragment;
    android.support.v7.widget.SwitchCompat tButton;
    TextViewUndoRedo mTextViewHostUrl;
    TextViewUndoRedo mTextViewRetailerRef;
    TextViewUndoRedo mTextViewAuthorizationKey;



    TextInputLayout hosturlWrapper, retailerRefWrapper, contentTypeWrapper, authorizationWrapper;
    EditText url, edit_retailer_ref, edit_content_type, edit_authorization;
    FloatingActionButton fab;
    Button button_accesiblity;
    CoordinatorLayout coordiante_layout;
    Snackbar snackbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);



        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("action.triggerservice"));
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        if (getIntent().hasExtra(Constants.KEY_TRANSACTION)) {
            setTheme(R.style.ThemeNoActionBar);


        } else {
            setTheme(R.style.AppTheme);
        }
        setContentView(R.layout.main_layout);

        edit_authorization = (EditText) findViewById(R.id.edit_authorization);
        url = (EditText) findViewById(R.id.url);
        edit_retailer_ref = (EditText) findViewById(R.id.edit_retailer_ref);

        mTextViewHostUrl = new TextViewUndoRedo();
        mTextViewHostUrl.AddTextChangeListener(url);

        button_accesiblity = (Button) findViewById(R.id.button_accesiblity);
        edit_content_type = (EditText) findViewById(R.id.edit_content_type);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        coordiante_layout = (CoordinatorLayout) findViewById(R.id.coordiante_layout);
        fab.setOnClickListener(this);
        button_accesiblity.setOnClickListener(this);
        //Intents.ACTION_PAYMENT_CANCELED
        edit_authorization.setText(DbShareprefence.getInstance().getHeaders(getApplicationContext()).get(Constants.KEY_AUTHORIZATION));
        edit_content_type.setText(DbShareprefence.getInstance().getHeaders(getApplicationContext()).get(Constants.KEY_CONTENT_TYPE));
        edit_retailer_ref.setText(DbShareprefence.getInstance().getHeaders(getApplicationContext()).get(Constants.KEY_RETAILER_REF));
        url.setText(DbShareprefence.getInstance().getHostURL(getApplicationContext()));


        enable_disablefields(false);

        hosturlWrapper = (TextInputLayout) findViewById(R.id.hosturlWrapper);
        retailerRefWrapper = (TextInputLayout) findViewById(R.id.retailerRefWrapper);
        contentTypeWrapper = (TextInputLayout) findViewById(R.id.contentTypeWrapper);
        authorizationWrapper = (TextInputLayout) findViewById(R.id.authorizationWrapper);


        if (getIntent().hasExtra(Constants.KEY_TRANSACTION)) {

            ((TextView) findViewById(R.id.textView)).setVisibility(View.GONE);
            coordiante_layout.setVisibility(View.GONE);
            ((LinearLayout) findViewById(R.id.rl)).setBackground(null);
            ((LinearLayout) findViewById(R.id.rl)).setBackgroundColor(getResources().getColor(R.color.transulcent));
            showDialogFragment((Transaction) getIntent().getParcelableExtra(Constants.KEY_TRANSACTION));

        } else {

            AppController.getInstance().clearAll();
            AppController.getInstance().onCreate();
            setTheme(R.style.AppTheme);
            getSupportActionBar().setTitle("LiveReceipts Configuration");
        }





    }




    private void enable_disablefields(boolean flag) {
        edit_authorization.setEnabled(flag);
        edit_content_type.setEnabled(flag);
        url.setEnabled(flag);
        edit_retailer_ref.setEnabled(flag);


    }

    private void showDialogFragment(Transaction transaction) {

        dFragment = DFragment.newInstance(transaction);
        dFragment.show(fm, "Dialog Fragment");
    }

    @Override
    public void dismiss() {

        if (dFragment != null)
            dFragment.dismiss();

        finish();

    }

    @Override
    public void update(JSONObject jsonObject) {

    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    public void update(String string) {
        if (dFragment != null)
            dFragment.dismiss();
        Intent i = new Intent();
        i.setClass(this, NetworkIntentService.class);
        i.putExtra(Constants.JSON_DATA,string);
        startService(i);

        finish();




    }

    @Override
    public void update() {
        if (dFragment != null)
            dFragment.dismiss();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        tButton = (SwitchCompat) menu.findItem(R.id.myswitch)
                .getActionView().findViewById(R.id.actionbar_service_toggle);
        tButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {

                    enable_disablefields(true);
                    Toast.makeText(getApplication(), "ON", Toast.LENGTH_SHORT).show();
                } else {

                    enable_disablefields(false);
                    Toast.makeText(getApplication(), "OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return true;
    }

    @Override
    public void onClick(View view) {

        if (view == fab) {
            if (Patterns.WEB_URL.matcher(url.getText().toString()).matches() == false) {
                hosturlWrapper.setError("Invalid Host Url !");
            } else if (edit_retailer_ref.getText().toString().isEmpty()) {
                retailerRefWrapper.setError("Please Enter Retailer-Ref !");
            } else if (edit_content_type.getText().toString().isEmpty()) {
                contentTypeWrapper.setError("Please Enter Content-Type !");
            } else if (edit_authorization.getText().toString().isEmpty()) {
                authorizationWrapper.setError("Please Enter Authorization Key !");
            } else {
                enable_disablefields(false);
                showMessage();

                DbShareprefence.getInstance().setHostURL(url.getText().toString().trim(),getApplicationContext());
                DbShareprefence.getInstance().setContent_Type(edit_content_type.getText().toString().trim(),getApplicationContext());
                DbShareprefence.getInstance().setAuthorization(edit_authorization.getText().toString().trim(),getApplicationContext());
                DbShareprefence.getInstance().setRetailerRef(edit_retailer_ref.getText().toString().trim(),getApplicationContext());
                finish();




            }
        }

    }



    void showMessage() {
        snackbar = Snackbar
                .make(coordiante_layout, "Parameters Saved Successfully .", Snackbar.LENGTH_LONG)
                .setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });

        snackbar.show();
    }

}
