package com.renovite.transactionidmapper.receviers;
/**
 * Created by sushil.kumar on 18-12-2017.
 */

import android.accounts.Account;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import com.renovite.transactionidmapper.activities.AppController;
import com.renovite.transactionidmapper.activities.TransactionIDMapper;
import com.renovite.transactionidmapper.utils.Constants;
import com.renovite.transactionidmapper.utils.Utils;

import java.util.List;
import java.util.UUID;


import co.poynt.api.model.Business;
import co.poynt.api.model.Catalog;
import co.poynt.api.model.CatalogWithProduct;
import co.poynt.api.model.Category;
import co.poynt.api.model.Code;
import co.poynt.api.model.Customer;
import co.poynt.api.model.FundingSourceType;
import co.poynt.api.model.Order;
import co.poynt.api.model.Transaction;
import co.poynt.api.model.TransactionReference;
import co.poynt.api.model.TransactionReferenceType;
import co.poynt.api.model.TransactionStatus;
import co.poynt.os.contentproviders.orders.transactions.TransactionsColumns;
import co.poynt.os.model.Intents;
import co.poynt.os.model.PoyntError;
import co.poynt.os.model.SecondScreenLabels;
import co.poynt.os.services.v1.IPoyntActivationService;
import co.poynt.os.services.v1.IPoyntBusinessReadListener;
import co.poynt.os.services.v1.IPoyntCapabilityManager;
import co.poynt.os.services.v1.IPoyntCustomerReadListener;
import co.poynt.os.services.v1.IPoyntDiscoveryListener;
import co.poynt.os.services.v1.IPoyntOrderServiceListener;
import co.poynt.os.services.v1.IPoyntProductCatalogListener;
import co.poynt.os.services.v1.IPoyntSecondScreenPhoneEntryListener;
import co.poynt.os.services.v1.IPoyntSessionServiceListener;
import co.poynt.os.services.v1.IPoyntTerminalDiscoveryListener;
import co.poynt.os.services.v1.IPoyntTransactionService;
import co.poynt.os.services.v1.IPoyntTransactionServiceListener;

public class TransactionReceiver extends BroadcastReceiver {
    private static final String TAG = TransactionReceiver.class.getSimpleName();

    private final long NOT_FOUND = -1;
    private Context context;
    private int checkCounter = -1;
    private String transaction_id;
    private String sortOrder = TransactionsColumns.CREATEDAT + " DESC";
    private IPoyntTransactionService iPoyntTransactionService = null;
    private IPoyntCustomerReadListener iPoyntCustomerServiceListener = new IPoyntCustomerReadListener.Stub() {


        @Override
        public void onResponse(Customer customer, PoyntError poyntError) throws RemoteException {

            if (poyntError == null && customer != null) {

                Utils.getOrderJsonMapped(AppController.getInstance().getOrder(), AppController.getInstance().getTransaction(), customer, AppController.getInstance().getPhoneNumber(), AppController.getInstance().getStore(), context);

                //AppController.getInstance().iPoyntBusinessService.getBusiness(iPoyntBusinessListner);


            }

        }
    };

    private void getCatalogDetails() {

        try {
            // AppController.getInstance().iPoyntProductService.getProductBySku(sku, iPoyntProductServiceListener);
            AppController.getInstance().iPoyntProductService.getRegisterCatalog(new IPoyntProductCatalogListener.Stub() {
                @Override
                public void onResponse(Catalog catalog, PoyntError poyntError) throws RemoteException {

                    if (catalog != null && poyntError == null) {

                        AppController.getInstance().setCatalog(catalog);
                        getAccountDetails();
                    } else {
                        getAccountDetails();
                    }
                }


            });
        } catch (RemoteException e) {
            getAccountDetails();
            return;
        }


    }


    private IPoyntOrderServiceListener iPoyntOrderServiceListener = new IPoyntOrderServiceListener.Stub() {
        @Override
        public void orderResponse(Order order, String s, PoyntError poyntError) {

            if (poyntError == null && order != null) {


                try {

                    AppController.getInstance().setOrder(order);

                    AppController.getInstance().iPoyntCustomerService.getCustomer(order.getCustomerUserId(), iPoyntCustomerServiceListener);
                } catch (Exception e) {

                    Utils.getOrderJsonMapped(order, AppController.getInstance().getTransaction(), null, AppController.getInstance().getPhoneNumber(), AppController.getInstance().getStore(), context);
                    return;

                }


            } else {
                Utils.getOrderJsonMapped(null, AppController.getInstance().getTransaction(), null, AppController.getInstance().getPhoneNumber(), AppController.getInstance().getStore(), context);
            }


        }


    };
    private IPoyntBusinessReadListener iPoyntBusinessListner = new IPoyntBusinessReadListener.Stub() {
        @Override
        public void onResponse(Business business, PoyntError poyntError) throws RemoteException {

            if (poyntError == null && business != null) {
                AppController.getInstance().setStore(getStore(business, AppController.getInstance().getTransaction().getContext().getStoreId().toString()));
                getOrderDetails(context, AppController.getInstance().getTransaction());
            } else
                getOrderDetails(context, AppController.getInstance().getTransaction());


        }

    };
    private IPoyntTransactionServiceListener iPoyntTransactionServiceListener = new IPoyntTransactionServiceListener.Stub() {
        @Override
        public void onResponse(Transaction transaction, String s, PoyntError poyntError) {


            if (transaction != null)
                AppController.getInstance().setTransaction(transaction);

            if (transaction == null && poyntError != null) {

                if (poyntError.getApiErrorCode() == Code.TRANSACTION_NOT_FOUND) {
                    final String id = UUID.randomUUID().toString();
                    getTransactionDetails(getTransaction_id(), id);
                    checkCounter = checkCounter + 1;

                }

            } else if (transaction.getFundingSource().getType().equals(FundingSourceType.CREDIT_DEBIT)
                    && (transaction.getStatus().equals(TransactionStatus.CAPTURED) || transaction.getStatus().equals(TransactionStatus.AUTHORIZED))
                    && (transaction.isVoided() == null || transaction.getFundingSource().getCard() != null)
                    && (transaction.getLinks() == null)
                    && (transaction.isActionVoid() == null)) {


                navigateSecondScreen();

                return;

            } else if ((transaction.getFundingSource().getType().equals(FundingSourceType.CASH))
                    && (transaction.getStatus().equals(TransactionStatus.CAPTURED))
                    && ((transaction.isVoided() == null && transaction.getContext().getBusinessType() == null)
                    || (transaction.isVoided() == false && transaction.getContext().getBusinessType() != null))) {


                navigateSecondScreen();

                return;

            } else {

            }

        }

        @Override
        public void onLoginRequired() throws RemoteException {


            AppController.getInstance().clearAll();

        }

        @Override
        public void onLaunchActivity(Intent intent, String s) throws RemoteException {
            Log.d(TAG, "Error");
            AppController.getInstance().clearAll();
        }


    };
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(context, "Mobile No Should not be less than 7 digits", Toast.LENGTH_LONG).show();
        }
    };
    public IPoyntSecondScreenPhoneEntryListener phoneEntryListener =
            new IPoyntSecondScreenPhoneEntryListener.Stub() {
                @Override
                public void onPhoneEntered(String phone) throws RemoteException {

                    if (phone.toString().isEmpty() || Utils.replaceAllAlpha(phone.toString()).length() < 7) {
                        AppController.getInstance().secondScreenService.capturePhoneWithOptions(phone, SecondScreenLabels.DEFAULT, SecondScreenLabels.CONFIRM, null,
                                phoneEntryListener);

                        handler.sendEmptyMessage(0);


                    } else {
                        getBusinessDetails(context, AppController.getInstance().getTransaction());
                        AppController.getInstance().setPhoneNumber(phone);
                        showWelcomeScreen();

                    }
                }

                @Override
                public void onPhoneEntryCanceled() throws RemoteException {

                    AppController.getInstance().setPhoneNumber(null);
                    showWelcomeScreen();

                }
            };


    public TransactionReceiver() {
    }

    private co.poynt.api.model.Store getStore(Business business, String id) {
        co.poynt.api.model.Store store = null;
        if (business.getStores().size() > 0) {
            for (int i = 0; i < business.getStores().size(); i++)
                if (business.getStores().get(i).getId().toString().equals(id)) {
                    store = business.getStores().get(i);
                    if (business.getLegalName() != null)
                        store.setDisplayName(business.getLegalName());


                    return store;
                } else
                    store = null;
        } else
            return null;
        return store;

    }

    private String getTransaction_id() {
        return transaction_id;
    }

    private void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    private void navigateSecondScreen() {

        if (!Constants.SHOW_MERCHANT_DIALOG) {

            try {
                AppController.getInstance().secondScreenService.capturePhoneNumber(SecondScreenLabels.DEFAULT, SecondScreenLabels.CONFIRM,
                        phoneEntryListener);

            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {

            Intent intentLaunch = new Intent(context.getApplicationContext(), TransactionIDMapper.class);
            intentLaunch.putExtra(Constants.KEY_TRANSACTION, AppController.getInstance().getTransaction());
            intentLaunch.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intentLaunch);
        }


    }

    private void showWelcomeScreen() {
        try {
            AppController.getInstance().secondScreenService.displayWelcome(null, null, null);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onReceive(final Context context, Intent intent) {

        String ACTION = intent.getAction();

        this.context = context;

        if (null != ACTION) {

            // CARD FOUND // PRESENT_CARD // look for PIN_ENTRY_REQUIRED //ACTION CARD FOUND

            Log.d(TAG, "ACTION:" + ACTION);


            if (ACTION.equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)) {
                AppController.getInstance().bindTransactionService();
                AppController.getInstance().clearAll();


            } else if (ACTION.equalsIgnoreCase(Intents.ACTION_PAYMENT_CANCELED)) {
                AppController.getInstance().clearAll();

            } else if (ACTION.equalsIgnoreCase(Intents.ACTION_TRANSACTION_COMPLETED)) {

                if (intent.getExtras() != null) {


                    if (intent.getExtras().get(Intents.INTENT_EXTRAS_TRANSACTION_ID) != null) {
                        Log.d(TAG, "Received TRANSACTION_COMPLETED broadcast. Transaction id: " +
                                intent.getExtras().get(Intents.INTENT_EXTRAS_TRANSACTION_ID));
                        String lastTransactionId = intent.getExtras().get(Intents.INTENT_EXTRAS_TRANSACTION_ID).toString();


                        if (lastTransactionId != null) {
                            setTransaction_id(lastTransactionId);

                            getCatalogDetails();

                        } else {
                            AppController.getInstance().clearAll();
                        }


                    } else {
                        AppController.getInstance().clearAll();

                    }
                }
            }
        }

    }

    private IPoyntSessionServiceListener iPoyntSessionServiceListener = new IPoyntSessionServiceListener.Stub() {
        @Override
        public void onResponse(Account account, PoyntError poyntError) {

            if (account != null && poyntError == null) {
                try {

                    AppController.getInstance().setUserName(account.name);
                    getTransactionDetails(getTransaction_id(), UUID.randomUUID().toString());

                } catch (Exception e) {
                    Log.e(TAG, "Error is Here");

                    getTransactionDetails(getTransaction_id(), UUID.randomUUID().toString());
                }
            } else {
                getTransactionDetails(getTransaction_id(), UUID.randomUUID().toString());
            }

        }


    };

    private void getAccountDetails() {
        try {
            AppController.getInstance().iPoyntSessionService.getCurrentUser(iPoyntSessionServiceListener);

        } catch (RemoteException e) {
            Log.e(TAG, "Error is Here");

            return;
        }
    }


    private void getTransactionDetails(final String transaction_id, final String id) {

        try {
            AppController.getInstance().iPoyntTransactionService.getTransaction(transaction_id, id, iPoyntTransactionServiceListener);

        } catch (RemoteException e) {
            Log.e(TAG, "Error is Here");

            return;
        }

    }

    public  void getBusinessDetails(final Context context, Transaction transaction) {

        this.context = context;
        try {

            AppController.getInstance().iPoyntBusinessService.getBusiness(iPoyntBusinessListner);
        } catch (RemoteException e) {
            getOrderDetails(context, transaction);
            return;
        }


    }

    void getOrderDetails(Context context, Transaction transaction) {
        List<TransactionReference> transactionReferenceList = transaction.getReferences();
        if (transactionReferenceList != null)
            if (transactionReferenceList.size() > 0) {

                for (TransactionReference transactionReference : transactionReferenceList) {
                    if (transactionReference.getType().equals(TransactionReferenceType.POYNT_ORDER)) {


                        try {
                            AppController.getInstance().iPoyntOrderService.getOrder(transactionReference.getId(), UUID.randomUUID().toString(), iPoyntOrderServiceListener);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }


                    } else {

                        AppController.getInstance().setOrder(null);
                        AppController.getInstance().setCustomer(null);
                        if(AppController.getInstance().getTransaction().getCustomerUserId()!=null) {
                            try {
                                AppController.getInstance().iPoyntCustomerService.getCustomer(AppController.getInstance().getTransaction().getCustomerUserId(), iPoyntCustomerServiceListener);
                            } catch (RemoteException e) {
                                Utils.getOrderJsonMapped(null, transaction, null, AppController.getInstance().getPhoneNumber(), AppController.getInstance().getStore(), context);

                            }
                        }else {

                            Utils.getOrderJsonMapped(null, transaction, null, AppController.getInstance().getPhoneNumber(), AppController.getInstance().getStore(), context);
                        }
                    }


                }

            } else {


                AppController.getInstance().setOrder(null);
                AppController.getInstance().setCustomer(null);
                Utils.getOrderJsonMapped(null, transaction, null, AppController.getInstance().getPhoneNumber(), AppController.getInstance().getStore(), context);

            }

    }

}
