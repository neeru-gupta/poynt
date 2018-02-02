package com.renovite.transactionidmapper.utils;

/**
 * Created by sushil.kumar on 03-01-2018.
 */

public interface Constants extends WSConstants {
    String KEY_TRANSACTION_ID = "transid";

    String TRANSACTION_ITEM = "transaction_item";
    String KEY_TRANSACTION ="transaction" ;
    String JSON_DATA = "json_data";
    String HTTP_METHOD ="POST" ;
    String KEY_HOST_URL = "key_host_url";

    String KEY_CONTENT_TYPE = "Content-Type";
    String KEY_AUTHORIZATION ="Authorization" ;
    String KEY_RETAILER_REF ="Retailer-Ref" ;
    java.lang.String DATE_FORMAT ="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" ;
    String OTHER = "other";
    String CARD  = "card";
    String CASH = "cash";
    boolean SHOW_MERCHANT_DIALOG  = true;
    String MESSAGE ="Mobile no should not be less than 7 digits!" ;
}
