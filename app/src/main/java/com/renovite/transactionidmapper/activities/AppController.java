package com.renovite.transactionidmapper.activities;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.android.volley.RequestQueue;
import com.renovite.transactionidmapper.model.ProductOrder;


import java.util.HashMap;

import co.poynt.api.model.Catalog;
import co.poynt.api.model.Customer;
import co.poynt.api.model.Order;
import co.poynt.api.model.OrderItem;
import co.poynt.api.model.Product;
import co.poynt.api.model.Store;
import co.poynt.api.model.Transaction;
import co.poynt.os.model.Intents;
import co.poynt.os.model.SecondScreenLabels;
import co.poynt.os.services.v1.IPoyntAccessoryManagerListener;
import co.poynt.os.services.v1.IPoyntBusinessReadListener;
import co.poynt.os.services.v1.IPoyntBusinessService;
import co.poynt.os.services.v1.IPoyntCheckCardListener;
import co.poynt.os.services.v1.IPoyntCustomerService;
import co.poynt.os.services.v1.IPoyntInAppBillingServiceListener;
import co.poynt.os.services.v1.IPoyntOrderService;
import co.poynt.os.services.v1.IPoyntOrderServiceListener;
import co.poynt.os.services.v1.IPoyntProductCatalogListener;
import co.poynt.os.services.v1.IPoyntProductCatalogWithProductListener;
import co.poynt.os.services.v1.IPoyntProductCategoriesListener;
import co.poynt.os.services.v1.IPoyntProductService;
import co.poynt.os.services.v1.IPoyntSearchService;
import co.poynt.os.services.v1.IPoyntSecondScreenPhoneEntryListener;
import co.poynt.os.services.v1.IPoyntSecondScreenService;
import co.poynt.os.services.v1.IPoyntSessionService;
import co.poynt.os.services.v1.IPoyntTerminalDiscoveryListener;
import co.poynt.os.services.v1.IPoyntTransactionService;

/**
 * Created by sushil.kumar on 12-01-2018.
 */

public class AppController extends Application implements ServiceConnection {
    public static final String TAG = AppController.class
            .getSimpleName();
    private static AppController mInstance;
    public IPoyntTransactionService iPoyntTransactionService;
    public IPoyntOrderService iPoyntOrderService;
    public IPoyntCustomerService iPoyntCustomerService;
    public IPoyntBusinessService iPoyntBusinessService;
    public IPoyntSecondScreenService secondScreenService;
    public IPoyntProductService iPoyntProductService;
    public IPoyntSessionService iPoyntSessionService;
    public HashMap<String, ProductOrder> orderItem_Product_HashMap = new HashMap();
    private Customer customer;
    private String userName;
    private Catalog catalog;
    private Store store;
    private Product product;
    private Order order;
    private Transaction transaction;
    private String phoneNumber = null;

    private ServiceConnection secondScreenServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            secondScreenService = IPoyntSecondScreenService.Stub.asInterface(iBinder);


        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            secondScreenService = null;
        }
    };

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public static Context getContext() {
        return getContext();
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getUserName() {
        if (userName == null)
            return "";
        else
            return userName;


    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Store getStore() {
        return store;
    }


    public void setStore(Store store) {
        this.store = store;
    }

    public void clearAll() {
        customer = null;
        order = null;
        transaction = null;
        phoneNumber = null;
        store = null;
        product = null;

    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        bindSessionService();
        bindTransactionService();
        bindOrderService();
        bindCustomerService();
        bindSecondScreenService();
        bindBusinessReadService();
        bindProductService();
    }

    public void bindTransactionService() {
        if (iPoyntTransactionService == null)
            bindService(Intents.getComponentIntent(Intents.COMPONENT_POYNT_TRANSACTION_SERVICE),
                    this, Context.BIND_AUTO_CREATE);
    }

    public void bindOrderService() {
        if (iPoyntOrderService == null)
            bindService(Intents.getComponentIntent(Intents.COMPONENT_POYNT_ORDER_SERVICE),
                    this, Context.BIND_AUTO_CREATE);
    }

    public void bindCustomerService() {
        if (iPoyntCustomerService == null)
            bindService(Intents.getComponentIntent(Intents.COMPONENT_POYNT_CUSTOMER_SERVICE),
                    this, Context.BIND_AUTO_CREATE);
    }

    public void bindSecondScreenService() {
        bindService(Intents.getComponentIntent(Intents.COMPONENT_POYNT_SECOND_SCREEN_SERVICE),
                secondScreenServiceConnection, BIND_AUTO_CREATE);
    }

    public void bindBusinessReadService() {
        bindService(Intents.getComponentIntent(Intents.COMPONENT_POYNT_BUSINESS_SERVICE),
                this, BIND_AUTO_CREATE);
    }

    public void bindProductService() {
        if (iPoyntProductService == null)
            bindService(Intents.getComponentIntent(Intents.COMPONENT_POYNT_PRODUCT_SERVICE),
                    this, Context.BIND_AUTO_CREATE);
    }

    public void bindSessionService() {
        if (iPoyntSessionService == null)
            bindService(Intents.getComponentIntent(Intents.COMPONENT_POYNT_SESSION_SERVICE),
                    this, Context.BIND_AUTO_CREATE);
    }

    private void showWelcomeScreen() {
        try {
            secondScreenService.displayWelcome(null, null, null);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {


        if (componentName.equals(Intents.COMPONENT_POYNT_CUSTOMER_SERVICE)) {
            iPoyntCustomerService = IPoyntCustomerService.Stub.asInterface(iBinder);
        } else if (componentName.equals(Intents.COMPONENT_POYNT_ORDER_SERVICE)) {
            iPoyntOrderService = IPoyntOrderService.Stub.asInterface(iBinder);
        } else if (componentName.equals(Intents.COMPONENT_POYNT_BUSINESS_SERVICE)) {
            iPoyntBusinessService = IPoyntBusinessService.Stub.asInterface(iBinder);
        } else if (componentName.equals(Intents.COMPONENT_POYNT_TRANSACTION_SERVICE)) {
            iPoyntTransactionService = IPoyntTransactionService.Stub.asInterface(iBinder);
        } else if (componentName.equals(Intents.COMPONENT_POYNT_PRODUCT_SERVICE)) {
            iPoyntProductService = IPoyntProductService.Stub.asInterface(iBinder);
        } else if (componentName.equals(Intents.COMPONENT_POYNT_SESSION_SERVICE)) {
            iPoyntSessionService = IPoyntSessionService.Stub.asInterface(iBinder);
        }

    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        if (componentName.equals(Intents.COMPONENT_POYNT_CUSTOMER_SERVICE)) {
            iPoyntCustomerService = null;
        } else if (componentName.equals(Intents.COMPONENT_POYNT_ORDER_SERVICE)) {
            iPoyntOrderService = null;
        } else if (componentName.equals(Intents.COMPONENT_POYNT_BUSINESS_SERVICE)) {
            iPoyntBusinessService = null;
        } else if (componentName.equals(Intents.COMPONENT_POYNT_TRANSACTION_SERVICE)) {
            iPoyntTransactionService = null;
        } else if (componentName.equals(Intents.COMPONENT_POYNT_PRODUCT_SERVICE)) {
            iPoyntProductService = null;
        } else if (componentName.equals(Intents.COMPONENT_POYNT_SESSION_SERVICE)) {
            iPoyntSessionService = null;
        }

    }


}
