package com.renovite.transactionidmapper.services;

import com.renovite.transactionidmapper.model.demo.MultipleResources;
import com.renovite.transactionidmapper.model.demo.User;
import com.renovite.transactionidmapper.model.demo.UserList;
import com.renovite.transactionidmapper.model.order.RetailOrder;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {
    //oauth2/token
    //

    @POST("/retailer/orders")
    Call<RetailOrder> sendRetaileOrder();

    @POST("/oauth2/token")
    Call<User> getToken(@Body User user);

    @GET("/api/unknown")
    Call<MultipleResources> doGetListResources();

    @POST("/api/users")
    Call<User> createUser(@Body User user);

    @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") String page);

    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
}