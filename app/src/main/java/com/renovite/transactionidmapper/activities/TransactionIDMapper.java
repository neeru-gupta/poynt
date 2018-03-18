package com.renovite.transactionidmapper.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.renovite.transactionidmapper.R;
import com.renovite.transactionidmapper.database.DbShareprefence;
import com.renovite.transactionidmapper.fragments.DFragment;
import com.renovite.transactionidmapper.interfaces.DlgInterface;
import com.renovite.transactionidmapper.model.demo.MultipleResources;
import com.renovite.transactionidmapper.services.APIClient;
import com.renovite.transactionidmapper.services.APIInterface;
import com.renovite.transactionidmapper.services.NetworkIntentService;
import com.renovite.transactionidmapper.utils.Constants;
import com.renovite.transactionidmapper.utils.GitHubService;
import com.renovite.transactionidmapper.utils.TextViewUndoRedo;
import com.renovite.transactionidmapper.utils.UnsafeOkHttpClient;

import org.json.JSONObject;


import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

import co.poynt.api.model.Transaction;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class TransactionIDMapper extends AppCompatActivity implements DlgInterface, View.OnClickListener {
    private final static String TAG = " TransactionIDMapper ";
    FragmentManager fm = getSupportFragmentManager();
    DFragment dFragment;
    android.support.v7.widget.SwitchCompat tButton;
    TextViewUndoRedo mTextViewHostUrl;
    TextViewUndoRedo mTextViewRetailerRef;
    TextViewUndoRedo mTextViewAuthorizationKey;


    TextInputLayout hosturlWrapper, retailerRefWrapper, contentTypeWrapper, authorizationWrapper;
    EditText url, edit_retailer_ref, edit_content_type, edit_authorization;
    FloatingActionButton fab;
    Button button_accesiblity;
    CoordinatorLayout coordiante_layout;
    Snackbar snackbar;
    private APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Log.d("TransactionIDMapper", "The onCreate() event");
        Log.d("ANDROID: ", String.valueOf(android.os.Build.VERSION.SDK_INT));



        new AsyncTask<Void, Void, Void>() {


            @Override
            protected Void doInBackground(Void... voids) {

                OkHttpClient client = UnsafeOkHttpClient.getHttpClient();
                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .build();

                Log.d("RESTCALL:", retrofit.toString());
                MediaType JSON = MediaType.parse("application/json; charset=utf-8");
                RequestBody body = RequestBody.create(JSON, "{'message':'hello, world'}");
                Request request = new Request.Builder()
                        .url("https://apigateway.poc.wrsops.net")
                        //.url("https://api.staging.onemarketnetwork.com/")
                        //.url("https://api.sandbox.onemarketnetwork.com/")
                        //.url("https://api.onemarketnetwork.com/")
                        //.url("https://account.onemarketnetwork.com")
                        //.url("https://account.poc.wrsops.net")
                        //.url("https://admin.poc.wrsops.net/")
                        //.url("https://account.staging.onemarketnetwork.com")
                        //.url("https://account.sandbox.onemarketnetwork.com")
                        //.url("https://onemarketnetwork.com")
                        //.url("https://api.sandbox.ewaypayments.com/gateway/Xml/XmlPaymentRequestHandler.ashx")
                        .post(body)
                        .build();
                Log.d("AsyncTask-HTTPS", "Request : " + request.toString());
                Log.d("AsyncTask-HTTPS", "Request headers: " + request.headers());

                okhttp3.Response response = null;


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

                    }

                    @Override
                    public void onFailure(Call<MultipleResources> call, Throwable t) {
                        call.cancel();
                    }
                });
                try {
                    response = client.newCall(request).execute();
                    String responseString = response.body().string();
                    Log.d("AsyncTask-HTTPS", "responseString: " + responseString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
                    sslContext.init(null, null, null);
                    String[] protocols = sslContext.getSupportedSSLParameters().getProtocols();
                    for (String protocol : protocols) {
                        Log.d("***TEST", "Context supported protocol: " + protocol);
                    }

                    SSLEngine engine = sslContext.createSSLEngine();
                    String[] supportedProtocols = engine.getSupportedProtocols();
                    for (String protocol : supportedProtocols) {
                        Log.d("***TEST", "Engine supported protocol: " + protocol);
                    }
                } catch (KeyManagementException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }


                return null;
            }
        }.execute();


        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("action.triggerservice"));
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        if (getIntent().hasExtra(Constants.KEY_TRANSACTION)) {
            setTheme(R.style.ThemeNoActionBar);


        } else {
            setTheme(R.style.AppTheme);
        }
        setContentView(R.layout.main_layout);

        edit_authorization = (EditText) findViewById(R.id.edit_authorization);
        url = (EditText) findViewById(R.id.url);
        edit_retailer_ref = (EditText) findViewById(R.id.edit_retailer_ref);

        mTextViewHostUrl = new TextViewUndoRedo();
        mTextViewHostUrl.AddTextChangeListener(url);

        button_accesiblity = (Button) findViewById(R.id.button_accesiblity);
        edit_content_type = (EditText) findViewById(R.id.edit_content_type);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        coordiante_layout = (CoordinatorLayout) findViewById(R.id.coordiante_layout);
        fab.setOnClickListener(this);
        button_accesiblity.setOnClickListener(this);
        //Intents.ACTION_PAYMENT_CANCELED
        edit_authorization.setText(DbShareprefence.getInstance().getHeaders(getApplicationContext()).get(Constants.KEY_AUTHORIZATION));
        edit_content_type.setText(DbShareprefence.getInstance().getHeaders(getApplicationContext()).get(Constants.KEY_CONTENT_TYPE));
        edit_retailer_ref.setText(DbShareprefence.getInstance().getHeaders(getApplicationContext()).get(Constants.KEY_RETAILER_REF));
        url.setText(DbShareprefence.getInstance().getHostURL(getApplicationContext()));


        enable_disablefields(false);

        hosturlWrapper = (TextInputLayout) findViewById(R.id.hosturlWrapper);
        retailerRefWrapper = (TextInputLayout) findViewById(R.id.retailerRefWrapper);
        contentTypeWrapper = (TextInputLayout) findViewById(R.id.contentTypeWrapper);
        authorizationWrapper = (TextInputLayout) findViewById(R.id.authorizationWrapper);


        if (getIntent().hasExtra(Constants.KEY_TRANSACTION)) {

            ((TextView) findViewById(R.id.textView)).setVisibility(View.GONE);
            coordiante_layout.setVisibility(View.GONE);
            ((LinearLayout) findViewById(R.id.rl)).setBackground(null);
            ((LinearLayout) findViewById(R.id.rl)).setBackgroundColor(getResources().getColor(R.color.transulcent));
            showDialogFragment((Transaction) getIntent().getParcelableExtra(Constants.KEY_TRANSACTION));

        } else {

            setTheme(R.style.AppTheme);
            getSupportActionBar().setTitle("LiveReceipts Configuration");
        }


    }


    private void enable_disablefields(boolean flag) {
        edit_authorization.setEnabled(flag);
        edit_content_type.setEnabled(flag);
        url.setEnabled(flag);
        edit_retailer_ref.setEnabled(flag);


    }

    private void showDialogFragment(Transaction transaction) {

        dFragment = DFragment.newInstance(transaction);
        dFragment.show(fm, "Dialog Fragment");
    }

    @Override
    public void dismiss() {

        if (dFragment != null)
            dFragment.dismiss();

        finish();

    }

    @Override
    public void update(JSONObject jsonObject) {

    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    public void update(String string) {
        if (dFragment != null)
            dFragment.dismiss();
        Intent i = new Intent();
        i.setClass(this, NetworkIntentService.class);
        i.putExtra(Constants.JSON_DATA, string);
        startService(i);
        Log.i("****", "Calling the inetent");

        finish();


    }

    @Override
    public void update() {
        if (dFragment != null)
            dFragment.dismiss();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        tButton = (SwitchCompat) menu.findItem(R.id.myswitch)
                .getActionView().findViewById(R.id.actionbar_service_toggle);
        tButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {

                    enable_disablefields(true);
                    Toast.makeText(getApplication(), "ON", Toast.LENGTH_SHORT).show();
                } else {

                    enable_disablefields(false);
                    Toast.makeText(getApplication(), "OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return true;
    }

    @Override
    public void onClick(View view) {
        Log.d("TransactionIDMapper", "EVENT CLICK CALLED!*********");


        Log.d("RUNTIME", "*** Inside calling of the API");
        APIClient.getClient();

        Call<MultipleResources> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<MultipleResources>() {
            @Override
            public void onResponse(Call<MultipleResources> call, Response<MultipleResources> response) {

                Log.d("TAG", response.code() + "");
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
                Log.d("TAG", displayResponse);
            }

            @Override
            public void onFailure(Call<MultipleResources> call, Throwable t) {
                Log.d("API Call failed ", String.valueOf(t.getLocalizedMessage()));
                t.printStackTrace();
                call.cancel();
            }
        });

        if (view == fab) {
            Log.d("VIEW**: ", String.valueOf(fab));
            if (Patterns.WEB_URL.matcher(url.getText().toString()).matches() == false) {
                hosturlWrapper.setError("Invalid Host Url !");
            } else if (edit_retailer_ref.getText().toString().isEmpty()) {
                retailerRefWrapper.setError("Please Enter Retailer-Ref !");
            } else if (edit_content_type.getText().toString().isEmpty()) {
                contentTypeWrapper.setError("Please Enter Content-Type !");
            } else if (edit_authorization.getText().toString().isEmpty()) {
                authorizationWrapper.setError("Please Enter Authorization Key !");
            } else {
                enable_disablefields(false);
                showMessage();

                DbShareprefence.getInstance().setHostURL(url.getText().toString().trim(), getApplicationContext());
                DbShareprefence.getInstance().setContent_Type(edit_content_type.getText().toString().trim(), getApplicationContext());
                DbShareprefence.getInstance().setAuthorization(edit_authorization.getText().toString().trim(), getApplicationContext());
                DbShareprefence.getInstance().setRetailerRef(edit_retailer_ref.getText().toString().trim(), getApplicationContext());
                Log.d("VIEW**: ", "Calling Network Service");

                finish();


            }
        }

    }

    /**
     * Called when the activity is about to become visible.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TransactionIDMapper", "The onStart() event");
    }


    /**
     * Called when another activity is taking focus.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TransactionIDMapper", "The onPause() event");
    }

    /**
     * Called when the activity is no longer visible.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TransactionIDMapper", "The onStop() event");
    }

    /**
     * Called just before the activity is destroyed.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TransactionIDMapper", "The onDestroy() event");
    }


    void showMessage() {
        snackbar = Snackbar
                .make(coordiante_layout, "Parameters Saved Successfully .", Snackbar.LENGTH_LONG)
                .setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });

        snackbar.show();
    }

}
