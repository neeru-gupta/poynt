package com.renovite.transactionidmapper.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.renovite.transactionidmapper.database.DbShareprefence;
import com.renovite.transactionidmapper.utils.Constants;
import com.renovite.transactionidmapper.utils.Utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import static com.renovite.transactionidmapper.utils.Utils.readStream;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class NetworkIntentService extends IntentService {


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
    }


    private  void processRequest(String json) {
        try {
            URL obj = new URL(DbShareprefence.getInstance().getHostURL(this.getApplicationContext()));
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod(Constants.HTTP_METHOD);
            addHeader(con);
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            os.close();
            int responseCode = con.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK||responseCode==HttpURLConnection.HTTP_CREATED) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
            } else {
                System.out.println("POST request not worked");
            }
        }catch (IOException e)
        {
            e.printStackTrace();
            return;
        }
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
