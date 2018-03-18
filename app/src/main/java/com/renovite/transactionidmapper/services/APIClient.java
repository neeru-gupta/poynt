package com.renovite.transactionidmapper.services;

import com.renovite.transactionidmapper.model.order.RetailOrder;

import com.renovite.transactionidmapper.utils.UnsafeOkHttpClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {


        retrofit = new Retrofit.Builder()
                //.baseUrl("https://reqres.in")
                .baseUrl("https://apigateway.poc.wrsops.net/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                //.client(new OkHttpClient.Builder().build())
                //.client(UnsafeOkHttpClient.getHttpClient())
                .build();
        return retrofit;
    }

}