package com.renovite.transactionidmapper.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sushil.kumar on 10-01-2018.
 */

public interface WSConstants {


    String URL = "http://192.168.100.137:8121/orders/";
   // String URL = "https://f57f7591.ngrok.io/orders/";
    public static Map<String, String> HEADERS = new HashMap<String, String>() {{
        put("Retailer-Ref", " GAP_USA");
        put("Content-Type", " application/json");
        put("Authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIiLCJpYXQiOjE1MDk3NDUyMDYsImV4cCI6MzgxMzQyODQwNiwiYXVkIjoicG9sYXJpcyIsInN1YiI6IiIsInNjb3BlIjoicmV0YWlsZXIub3JkZXJzLnJlYWQgcmV0YWlsZXIub3JkZXJzLndyaXRlIHJldGFpbGVyLnVzZXJzLnJlYWQgcmV0YWlsZXIudXNlcnMud3JpdGUiLCJjbGllbnRfaWQiOiIyN2U2MjAyMi0zZDUyLTQ3YjEtYmI2YS1jOGY2NmY4NmI2MTYifQ.SNwFMIwOGBL68NjHj1pNwWIzWT5R5VPXCrR7xRmhxZM");

    }};

    String KEY_REQUEST_URL = "request_url";


}
