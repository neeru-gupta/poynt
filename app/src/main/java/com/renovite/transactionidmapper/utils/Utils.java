package com.renovite.transactionidmapper.utils;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.math.MathUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.google.gson.Gson;
import com.renovite.transactionidmapper.R;
import com.renovite.transactionidmapper.activities.AppController;
import com.renovite.transactionidmapper.model.Amount;
import com.renovite.transactionidmapper.model.BillingAddress;
import com.renovite.transactionidmapper.model.Card;
import com.renovite.transactionidmapper.model.Cash;
import com.renovite.transactionidmapper.model.DeliveryEvent;
import com.renovite.transactionidmapper.model.Destination;
import com.renovite.transactionidmapper.model.DiscountAmount;
import com.renovite.transactionidmapper.model.DiscountAmount_;
import com.renovite.transactionidmapper.model.ImageUrl;
import com.renovite.transactionidmapper.model.ItemDiscount;
import com.renovite.transactionidmapper.model.Localization;
import com.renovite.transactionidmapper.model.LogoUrl;
import com.renovite.transactionidmapper.model.Optin;
import com.renovite.transactionidmapper.model.OrderItem;
import com.renovite.transactionidmapper.model.OrderProperties;
import com.renovite.transactionidmapper.model.Origin;
import com.renovite.transactionidmapper.model.Other;
import com.renovite.transactionidmapper.model.PaymentMethod;
import com.renovite.transactionidmapper.model.PaymentMethod_Amount;
import com.renovite.transactionidmapper.model.Product;
import com.renovite.transactionidmapper.model.ProductIdentifier;
import com.renovite.transactionidmapper.model.ProductOrder;
import com.renovite.transactionidmapper.model.Quantity;
import com.renovite.transactionidmapper.model.Shipment;
import com.renovite.transactionidmapper.model.ShipmentItem;
import com.renovite.transactionidmapper.model.Store;
import com.renovite.transactionidmapper.model.Store_Address;
import com.renovite.transactionidmapper.model.SubTotal;
import com.renovite.transactionidmapper.model.Total;
import com.renovite.transactionidmapper.model.Total_;
import com.renovite.transactionidmapper.model.TrackingUrl;
import com.renovite.transactionidmapper.model.UnitAmount;
import com.renovite.transactionidmapper.model.Url;
import com.renovite.transactionidmapper.model.UserIdentification;
import com.renovite.transactionidmapper.services.NetworkIntentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;

import co.poynt.api.model.Catalog;
import co.poynt.api.model.Customer;
import co.poynt.api.model.Delivery;
import co.poynt.api.model.Discount;
import co.poynt.api.model.Email;
import co.poynt.api.model.EmailType;
import co.poynt.api.model.FundingSourceType;
import co.poynt.api.model.Order;
import co.poynt.api.model.OrderItemTax;
import co.poynt.api.model.Phone;
import co.poynt.api.model.PhoneType;
import co.poynt.api.model.Transaction;
import co.poynt.api.model.UnitOfMeasure;
import co.poynt.os.model.PoyntError;
import co.poynt.os.services.v1.IPoyntProductCatalogListener;
import co.poynt.os.services.v1.IPoyntProductListener;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by sushil.kumar on 11-01-2018.
 */

public class Utils {
    public static SortedMap<Currency, Locale> currencyLocaleMap;
    public static Context mcontext;
    static int Counter = 0;
    static int size = 0;
    private static IPoyntProductListener iPoyntProductServiceListener = new IPoyntProductListener.Stub() {


        @Override
        public void onResponse(co.poynt.api.model.Product product, PoyntError poyntError) throws RemoteException {

            if (poyntError == null && product != null) {

                AppController.getInstance().setProduct(product);

                OrderItem orderItem = AppController.getInstance().orderItem_Product_HashMap.get(product.getSku()).getOrder().getOrderItems().get(Counter);
                orderItem.getProduct().setCategory(getCategory(product.getId()));
                ImageUrl imageUrl = new ImageUrl();
                if (product.getImageUrl().size() > 0)
                    imageUrl.setHref(getAttributeValueReplaceNull2Empty(product.getImageUrl().get(0)));
                else
                    imageUrl.setHref("");

               ProductIdentifier productIdentifier = new ProductIdentifier();

                productIdentifier.setGtin12(getAttributeValueReplaceNull2Empty(product.getPlu()));
                productIdentifier.setGtin8(getAttributeValueReplaceNull2Empty(product.getUpc()));
                productIdentifier.setGtin13(getAttributeValueReplaceNull2Empty(product.getEan()));
                productIdentifier.setGtin14(getAttributeValueReplaceNull2Empty(product.getAsin()));


                List<String> brands = new ArrayList<>();
                brands.add(getAttributeValueReplaceNull2Empty(product.getBrand()));

                orderItem.getProduct().setDescription(getAttributeValueReplaceNull2Empty(product.getDescription()));
                LogoUrl logoUrl = new LogoUrl();
                logoUrl.setHref("");
                Url url = new Url();
                url.setHref("");



                Counter = Counter + 1;
                if (size == Counter) {
                    ProductOrder productOrder = AppController.getInstance().orderItem_Product_HashMap.get(product.getSku());
                    getJson(productOrder, mcontext);
                    return;
                }

            } else {
                Counter = Counter + 1;
                if (size == Counter) {
                    ProductOrder productOrder = AppController.getInstance().orderItem_Product_HashMap.get(product.getSku());
                    getJson(productOrder, mcontext);
                    return;

                }

            }


        }
    };

    static {
        currencyLocaleMap = new TreeMap<Currency, Locale>(new Comparator<Currency>() {
            public int compare(Currency c1, Currency c2) {
                return c1.getCurrencyCode().compareTo(c2.getCurrencyCode());
            }
        });
        for (Locale locale : Locale.getAvailableLocales()) {
            try {
                Currency currency = Currency.getInstance(locale);
                currencyLocaleMap.put(currency, locale);
            } catch (Exception e) {
            }
        }
    }

    public static ArrayList<String> getCategory(String shortCode) {
        ArrayList<String> arrayList = new ArrayList();
        Catalog catalog = AppController.getInstance().getCatalog();
        if (catalog != null)
            if (catalog.getCategories() != null)
                if (catalog.getCategories().size() > 0)
                    for (int i = 0; i < catalog.getCategories().size(); i++) {
                        for (int j = 0; j < catalog.getCategories().get(i).getProducts().size(); j++) {
                            if (catalog.getCategories().get(i).getProducts().get(j).getId().equalsIgnoreCase(shortCode)) {
                                arrayList.add(catalog.getCategories().get(i).getName());
                            }
                        }

                    }
        return arrayList;
    }

    public static String getCurrencySymbol(String currencyCode) {
        Currency currency = Currency.getInstance(currencyCode);
        System.out.println(currencyCode + ":-" + currency.getSymbol(currencyLocaleMap.get(currency)));
        return currency.getSymbol(currencyLocaleMap.get(currency));
    }

    public static PopupWindow createPopUpWindow(Context mContext, ViewGroup viewGroup) {
        PopupWindow mPopupWindow;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

        View customView = inflater.inflate(R.layout.popup_layout, null);

        mPopupWindow = new PopupWindow(
                customView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );


        return mPopupWindow;
    }

    public static BigDecimal appendDecimal(long integral) {

        int x = 2; // Or 2, or whatever
        BigDecimal unscaled = new BigDecimal(integral);
        BigDecimal scaled = unscaled.scaleByPowerOfTen(-x);
        return scaled;
    }

    public static boolean isNetworkConnected(Context context) {

        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static String replaceAllAlpha(String value) {
        return value.replaceAll("[^0-9]", "");
    }

    public static String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }

    private static String getStoreTimeZoneOffset(String timeZoneParam) {

        TimeZone tz = TimeZone.getTimeZone(timeZoneParam);
        Calendar cal = GregorianCalendar.getInstance(tz);
        int offsetInMillis = tz.getOffset(cal.getTimeInMillis());


        String offset = String.format("%02d:%02d", Math.abs(offsetInMillis / 3600000), Math.abs((offsetInMillis / 60000) % 60));
        offset = (offsetInMillis >= 0 ? "+" : "-") + offset;
        System.out.println("Offset value:" +
                offset);
        return offset;
    }

    public static String getLocale() {
        Locale defaultLocale = Resources.getSystem().getConfiguration().locale;

        return defaultLocale.toString();


    }

    public static void getOrderJsonMapped(Order poyntOrder, Transaction transaction, Customer poyntcustomer, String phoneNumber, co.poynt.api.model.Store store, Context context) {


        ProductOrder productOrder = new ProductOrder();

        Localization localization = new Localization();
        localization.setTimezone(getStoreTimeZoneOffset(store.getTimezone()));
        localization.setLocale(getLocale());
        UserIdentification userIdentification = new UserIdentification();
        userIdentification.setIsGuest(true);
        userIdentification.setRetailerUserRef(AppController.getInstance().getPhoneNumber());



        SubTotal subTotal = new SubTotal();
        Total_ total_ = new Total_();


        mcontext = context;
        size = 0;
        Counter = 0;
        if (poyntOrder == null)
            poyntOrder = new Order();

        if (poyntcustomer == null)
            poyntcustomer = new Customer();


        com.renovite.transactionidmapper.model.Customer customer = new com.renovite.transactionidmapper.model.Customer();
        productOrder.setOrder(new com.renovite.transactionidmapper.model.Order());
        productOrder.getOrder().setLocalization(localization);
        productOrder.getOrder().setUserIdentification(userIdentification);
        productOrder.getOrder().setSubTotal(subTotal);
        productOrder.getOrder().setTotal(total_);


        productOrder.getOrder().setStatus(Constants.ORDER_STATUS);
        productOrder.getOrder().setCustomer(new com.renovite.transactionidmapper.model.Customer());
        List<PaymentMethod> paymentMethodsAList = new ArrayList<>();
        PaymentMethod paymentMethod = new PaymentMethod();
        Card card = new Card();



        PaymentMethod_Amount amount = new PaymentMethod_Amount();
        if (poyntOrder != null) {

            if (poyntOrder.getAmounts() != null)
                if (poyntOrder.getAmounts().getNetTotal() != null) {
                    amount.setQuantity(Utils.appendDecimal(poyntOrder.getAmounts().getNetTotal()));

                    amount.setCurrency(transaction.getAmounts().getCurrency());
                    paymentMethod.setAmount(amount);
                }
            if (poyntOrder.getAmounts() != null) {
                if (poyntOrder.getAmounts().getSubTotal() != null) {
                    productOrder.getOrder().getSubTotal().setCurrency(transaction.getAmounts().getCurrency());
                    productOrder.getOrder().getSubTotal().setQuantity(Utils.appendDecimal(poyntOrder.getAmounts().getSubTotal()));
                } else {
                    productOrder.getOrder().getSubTotal().setCurrency(transaction.getAmounts().getCurrency());
                    productOrder.getOrder().getSubTotal().setQuantity(Utils.appendDecimal(poyntOrder.getAmounts().getNetTotal()));
                }
                if (poyntOrder.getAmounts().getNetTotal() != null) {
                    productOrder.getOrder().getTotal().setCurrency(transaction.getAmounts().getCurrency());
                    productOrder.getOrder().getTotal().setQuantity(Utils.appendDecimal(poyntOrder.getAmounts().getNetTotal()));
                }
            } else {
                productOrder.getOrder().getSubTotal().setCurrency(transaction.getAmounts().getCurrency());
                productOrder.getOrder().getSubTotal().setQuantity(Utils.appendDecimal(transaction.getAmounts().getTransactionAmount()));
                productOrder.getOrder().getTotal().setCurrency(transaction.getAmounts().getCurrency());
                productOrder.getOrder().getTotal().setQuantity(Utils.appendDecimal(transaction.getAmounts().getTransactionAmount()+transaction.getAmounts().getTipAmount()));

            }
        } else {
            productOrder.getOrder().getSubTotal().setCurrency(transaction.getAmounts().getCurrency());
            productOrder.getOrder().getSubTotal().setQuantity(Utils.appendDecimal(transaction.getAmounts().getTransactionAmount()));
            productOrder.getOrder().getTotal().setCurrency(transaction.getAmounts().getCurrency());
            productOrder.getOrder().getTotal().setQuantity(Utils.appendDecimal(transaction.getAmounts().getTransactionAmount()+transaction.getAmounts().getTipAmount()));
        }


        if (transaction.getFundingSource().getCard() != null) {
            paymentMethod.setCard(card);
            if (poyntOrder != null)
                if (poyntOrder.getOrderNumber() != null)
                    paymentMethod.getCard().setPurchaseOrderNumber(poyntOrder.getOrderNumber());

            paymentMethod.getCard().setAuthCode(getAttributeValueReplaceNull2Empty(transaction.getProcessorResponse().getApprovalCode()));
            paymentMethod.getCard().setPaymentNetworkToken(getAttributeValueReplaceNull2Empty(transaction.getProcessorResponse().getCardToken()));
            paymentMethod.getCard().setIssuer(getAttributeValueReplaceNull2Empty(transaction.getFundingSource().getCard().getIssuer()));
            paymentMethod.getCard().setLastFour(getAttributeValueReplaceNull2Empty(transaction.getFundingSource().getCard().getNumberLast4()));
            paymentMethod.getCard().setCardType(getAttributeValueReplaceNull2Empty(transaction.getFundingSource().getCard().getType().toString()));
            paymentMethod.getCard().setExpirationDate(

                    getAttributeValueReplaceNull2Empty(String.valueOf(transaction.getFundingSource().getCard().getExpirationMonth()))
                            + getAttributeValueReplaceNull2Empty(String.valueOf((Math.abs(transaction.getFundingSource().getCard().getExpirationYear()) % 100))));
            paymentMethod.setPaymentMethod(Constants.CARD.toLowerCase());
            paymentMethod.setPaymentMethodType(Constants.CARD.toUpperCase());
        }
        if (transaction.getFundingSource().getType().equals(FundingSourceType.CASH)) {
            Cash cash = new Cash();
            if (poyntOrder != null)
                if (poyntOrder.getOrderNumber() != null)
                    cash.setPurchaseOrderNumber(poyntOrder.getOrderNumber());

            paymentMethod.setCash(cash);
            paymentMethod.setPaymentMethod(Constants.CASH.toLowerCase());
            paymentMethod.setPaymentMethodType(Constants.CASH.toUpperCase());

        }
        if (transaction.getFundingSource().getType().equals(FundingSourceType.CUSTOM_FUNDING_SOURCE) || transaction.getFundingSource().getType().equals(FundingSourceType.CHEQUE)) {
            Other other = new Other();
            if (poyntOrder != null)
                if (poyntOrder.getOrderNumber() != null)
                    other.setPurchaseOrderNumber(poyntOrder.getOrderNumber());

            paymentMethod.setOther(other);
            paymentMethod.setPaymentMethod(Constants.OTHER.toLowerCase());
            paymentMethod.setPaymentMethodType(Constants.OTHER.toUpperCase());
        }


        paymentMethodsAList.add(paymentMethod);


        productOrder.getOrder().setPaymentMethods(paymentMethodsAList);


        productOrder.getOrder().setOrderRef(getAttributeValueReplaceNull2Empty(String.valueOf(transaction.getId())));
        if (poyntcustomer != null) {
            productOrder.getOrder().getCustomer().setEmail(getAttributeValueReplaceNull2Empty(getEmail(poyntcustomer.getEmails())));
            productOrder.getOrder().getCustomer().setFirstName(getAttributeValueReplaceNull2Empty(poyntcustomer.getFirstName()));
            productOrder.getOrder().getCustomer().setLastName(getAttributeValueReplaceNull2Empty(poyntcustomer.getLastName()));

            productOrder.getOrder().getCustomer().setMiddleName(getAttributeValueReplaceNull2Empty(poyntcustomer.getMiddleName()));

            if (phoneNumber != null) {
                List<String> phones = new ArrayList<>();
                phones.add(phoneNumber);
                productOrder.getOrder().getCustomer().setPhoneNumbers(phones);
            } else
                productOrder.getOrder().getCustomer().setPhoneNumbers(getPhones(poyntcustomer.getPhones()));
        } else {
            productOrder.getOrder().getCustomer().setEmail("");
            productOrder.getOrder().getCustomer().setFirstName("");
            productOrder.getOrder().getCustomer().setLastName("");
            productOrder.getOrder().getCustomer().setMiddleName("");
            productOrder.getOrder().getCustomer().setTitle("");
            List<String> phones = new ArrayList<>();
            phones.add(phoneNumber);
            productOrder.getOrder().getCustomer().setPhoneNumbers(phones);


        }


        size = 0;
        if (poyntOrder != null) {

           productOrder.getOrder().setOrderItems(getOrderItems(poyntOrder.getItems(), transaction));
            appendDefaultModel(productOrder, transaction, store);
            size = productOrder.getOrder().getOrderItems().size();

            if (size > 0) {

                for (int i = 0; i < productOrder.getOrder().getOrderItems().size(); i++) {

                    AppController.getInstance().orderItem_Product_HashMap.put(productOrder.getOrder().getOrderItems().get(i).getProduct().getSku(), productOrder);
                    pushProductDetails(poyntOrder.getItems().get(i).getSku());


                }
            } else {
                getJson(productOrder, mcontext);
            }


            return;
        } else {

            getJson(productOrder, mcontext);
        }

    }

    private static void getJson(ProductOrder productOrder, Context context) {
        Gson gson = new Gson();
        String json = gson.toJson(productOrder);
        System.out.println(json);
        Intent i = new Intent();
        i.setClass(context, NetworkIntentService.class);
        i.putExtra(Constants.JSON_DATA, json);
        context.startService(i);

        return;
    }


    private static void appendDefaultModel(ProductOrder productOrder, Transaction transaction, co.poynt.api.model.Store poyntStore) {



        com.renovite.transactionidmapper.model.Delivery delivery = new com.renovite.transactionidmapper.model.Delivery();

        delivery.setCounts(new ArrayList<Integer>());
        delivery.setDeliveryEvents(new ArrayList<DeliveryEvent>());



        List<Optin> optins = new ArrayList<>();

        Optin optin = new Optin();
        optin.setChannel(Constants.OPTIN_CHANNEL);

        optin.setEnabled(true);

        optins.add(optin);
        Store store = new Store();

        store.setName(poyntStore.getDisplayName());

        store.setStoreRef(poyntStore.getId().toString());
        productOrder.getOrder().setStore(store);
        productOrder.getOrder().setOptins(optins);

        productOrder.getOrder().setOrderType(Constants.ORDER_TYPE);

        productOrder.getOrder().setOrderDate(millisecondsToDateTime(transaction.getCreatedAt().getTimeInMillis()));

    }

    public static String getEmail(Map<EmailType, Email> entry) {
        String email = "";
        if (entry != null) {
            if (entry.size() > 0) {
                for (Map.Entry<EmailType, Email> object : entry.entrySet()) {
                    if (object.getValue() != null) {
                        return object.getValue().getEmailAddress();
                    } else
                        email = "";
                }
                return email;
            } else
                return email;
        }
        return email;

    }

    public static List<String> getPhones(Map<PhoneType, Phone> entry) {
        List<String> list = new ArrayList();
        if (entry != null) {
            for (Map.Entry<PhoneType, Phone> object1 : entry.entrySet()) {
                if (object1.getValue() != null)
                    list.add(object1.getValue().getLocalPhoneNumber());
            }
        }
        return list;
    }





    private static String getUnitOfMesure(UnitOfMeasure unitOfMeasure) {
        if (unitOfMeasure.equals(UnitOfMeasure.FOOT)) {
            return Constants.FEET;
        } else if (unitOfMeasure.equals(UnitOfMeasure.POUND) || unitOfMeasure.equals(UnitOfMeasure.INCH) || unitOfMeasure.equals(UnitOfMeasure.GALLON) || unitOfMeasure.equals(UnitOfMeasure.KILOGRAM) || unitOfMeasure.equals(UnitOfMeasure.GRAM) || unitOfMeasure.equals(UnitOfMeasure.LITRE) || unitOfMeasure.equals(UnitOfMeasure.METER) || unitOfMeasure.equals(UnitOfMeasure.MILLIMETER)) {
            return unitOfMeasure.toString() + "S".toString();
        } else
            return Constants.ITEMS;
    }

    private static synchronized List<OrderItem> getOrderItems(List<co.poynt.api.model.OrderItem> orderItems, Transaction transaction) {
        List<OrderItem> list = new ArrayList();
        if (orderItems != null) {
            for (co.poynt.api.model.OrderItem object : orderItems) {
                if (object != null) {
                    AppController.getInstance().setProduct(null);
                    OrderItem orderItem = new OrderItem();
                    orderItem.setOrderItemRef(String.valueOf(object.getId()));
                    Quantity quantity = new Quantity();
                    Product product = new Product();
                    UnitAmount unitAmount = new UnitAmount();
                    Total total = new Total();
                    product.setName(object.getName());
                    product.setDescription(getAttributeValueReplaceNull2Empty(object.getDetails()));
                    product.setSku(object.getSku());
                    quantity.setQuantity(object.getQuantity());
                    quantity.setUnits(getUnitOfMesure(object.getUnitOfMeasure()));
                    orderItem.setQuantity(quantity);
                    unitAmount.setCurrency(transaction.getAmounts().getCurrency());
                    unitAmount.setQuantity(Utils.appendDecimal(object.getUnitPrice()));
                    orderItem.setUnitAmount(unitAmount);
                    total.setCurrency(transaction.getAmounts().getCurrency());
                    float number = object.getQuantity();
                    long aValue = (long) number;
                    total.setQuantity(Utils.appendDecimal(aValue * object.getUnitPrice()));
                    orderItem.setTotal(total);
                    orderItem.setProduct(product);
                    list.add(orderItem);
                }
            }
        }


        return list;

    }

    private static void pushProductDetails(String sku) {

        try {
            AppController.getInstance().iPoyntProductService.getProductBySku(sku, iPoyntProductServiceListener);

        } catch (RemoteException e) {
            return;
        }


    }



    public static String getAttributeValueReplaceNull2Empty(String value) {
        if (value == null)
            return "";
        else return value;
    }

    private static String millisecondsToDateTime(long milliSeconds) {
        SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.US);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return format.format(calendar.getTime());
    }


}

