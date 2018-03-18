package com.renovite.transactionidmapper.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.renovite.transactionidmapper.database.DbShareprefence;
import com.renovite.transactionidmapper.model.demo.MultipleResources;
import com.renovite.transactionidmapper.utils.Constants;
import com.renovite.transactionidmapper.utils.UnsafeOkHttpClient;
import com.renovite.transactionidmapper.utils.Utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.renovite.transactionidmapper.utils.Utils.readStream;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class NetworkIntentService extends IntentService {
    private APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);


    public NetworkIntentService() {
        super("NetworkIntentService");
        setIntentRedelivery(true);

    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            if(Utils.isNetworkConnected(this))
              // processRequest(intent.getStringExtra(Constants.JSON_DATA));
                processRequest(intent.getStringExtra(Constants.JSON_DATA));
        }
        processRequest("{\"data\":\"hello\"}");
    }

    private  void processRequest(String json) {
        Log.d("RUNTIME","*** Inside calling of the API");
        APIClient.getClient();
        Log.d("RUNTIME*** Client: ", String.valueOf(APIClient.getClient()));

        /**
         GET List Resources
         **/
        Call<MultipleResources> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<MultipleResources>() {
            @Override
            public void onResponse(Call<MultipleResources> call, Response<MultipleResources> response) {


                Log.d("TAG",response.code()+"");

                String displayResponse = "";

                MultipleResources resource = response.body();
                Integer text = resource.page;
                Integer total = resource.total;
                Integer totalPages = resource.totalPages;
                List<MultipleResources.Datum> datumList = resource.data;

                displayResponse += text + " Page\n" + total + " Total\n" + totalPages + " Total Pages\n";

                for (MultipleResources.Datum datum : datumList) {
                    displayResponse += datum.id + " " + datum.name + " " + datum.pantoneValue + " " + datum.year + "\n";
                }

                Log.d("TAG",displayResponse);

            }

            @Override
            public void onFailure(Call<MultipleResources> call, Throwable t)
            {
                t.printStackTrace();
                call.cancel();
            }
        });


        System.out.println("*** Completed the call");
    }



    private void addHeader(HttpURLConnection urlConnection) {
        for (Map.Entry<String, String> entry : DbShareprefence.getInstance().getHeaders(this.getApplicationContext()).entrySet()) {
            if(entry.getKey().equalsIgnoreCase(Constants.KEY_AUTHORIZATION))
                      urlConnection. setRequestProperty(entry.getKey(), "Bearer "+entry.getValue());
            else
                urlConnection.setRequestProperty(entry.getKey(), entry.getValue());
         }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */

}
