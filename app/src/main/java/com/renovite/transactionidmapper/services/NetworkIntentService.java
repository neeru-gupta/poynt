package com.renovite.transactionidmapper.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.renovite.transactionidmapper.database.DbShareprefence;
import com.renovite.transactionidmapper.utils.Constants;
import com.renovite.transactionidmapper.utils.Utils;

import java.net.HttpURLConnection;
import java.util.Map;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class NetworkIntentService extends IntentService {
    private static final String TAG = "NetworkSvc";

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
        Log.d(TAG,"*** Inside calling of the API");

        Log.d(TAG,"*** Completed calling of the API");
    }



    private void addHeader(HttpURLConnection urlConnection) {
        for (Map.Entry<String, String> entry : DbShareprefence.getInstance().getHeaders(this.getApplicationContext()).entrySet()) {
            if(entry.getKey().equalsIgnoreCase(Constants.KEY_AUTHORIZATION))
                      urlConnection. setRequestProperty(entry.getKey(), "Bearer "+entry.getValue());
            else
                urlConnection.setRequestProperty(entry.getKey(), entry.getValue());
         }
    }

}
