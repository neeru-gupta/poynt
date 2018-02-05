package com.renovite.transactionidmapper.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.renovite.transactionidmapper.activities.AppController;
import com.renovite.transactionidmapper.utils.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sushil.kumar on 16-01-2018.
 */

public class DbShareprefence {
    private static DbShareprefence ourInstance = null;
    private SharedPreferences mPrefs;

    public static DbShareprefence getInstance() {
        if (ourInstance == null)
            return new DbShareprefence();
        return ourInstance;
    }

    private DbShareprefence() {
    }

    public void setHostURL(String url, Context context) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        mPrefs.edit().putString(Constants.KEY_HOST_URL, url).commit();


    }


    public void setContent_Type(String content_type, Context context) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        mPrefs.edit().putString(Constants.KEY_CONTENT_TYPE, content_type).commit();

    }

    public void setAuthorization(String authorization, Context context) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        mPrefs.edit().putString(Constants.KEY_AUTHORIZATION, authorization).commit();
    }

    public void setRetailerRef(String retailerRef, Context context) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        mPrefs.edit().putString(Constants.KEY_RETAILER_REF, retailerRef).commit();
    }


    public String getHostURL(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.KEY_HOST_URL, Constants.URL);
    }
    public Map<String, String>  getHeaders(Context context) {

        Map<String, String> headers = new HashMap<>();
        headers.put(Constants.KEY_RETAILER_REF,  PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.KEY_RETAILER_REF, "GAP_USA"));
        headers.put(Constants.KEY_CONTENT_TYPE,   PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.KEY_CONTENT_TYPE, "application/json"));
        headers.put(Constants.KEY_AUTHORIZATION,  PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.KEY_AUTHORIZATION, "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIiLCJpYXQiOjE1MDk3NDUyMDYsImV4cCI6MzgxMzQyODQwNiwiYXVkIjoicG9sYXJpcyIsInN1YiI6IiIsInNjb3BlIjoicmV0YWlsZXIub3JkZXJzLnJlYWQgcmV0YWlsZXIub3JkZXJzLndyaXRlIHJldGFpbGVyLnVzZXJzLnJlYWQgcmV0YWlsZXIudXNlcnMud3JpdGUiLCJjbGllbnRfaWQiOiIyN2U2MjAyMi0zZDUyLTQ3YjEtYmI2YS1jOGY2NmY4NmI2MTYifQ.SNwFMIwOGBL68NjHj1pNwWIzWT5R5VPXCrR7xRmhxZM"));
        return headers;
    }


}
