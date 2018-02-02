package com.renovite.transactionidmapper.activities;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.renovite.transactionidmapper.R;

import co.poynt.os.model.Intents;
import co.poynt.os.model.Payment;
import co.poynt.os.model.SecondScreenLabels;
import co.poynt.os.services.v1.IPoyntSecondScreenPhoneEntryListener;
import co.poynt.os.services.v1.IPoyntSecondScreenService;

public class PhoneCaptureSecondScreen extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppController.getInstance().clearAll();
        AppController.getInstance().onCreate();
        AppController.getInstance().setPhoneNumber(null);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_second_screen_service);
        ((LinearLayout)findViewById(R.id.main_laoyut)).setVisibility(View.GONE);



    }

    private IPoyntSecondScreenService secondScreenService;
    private ServiceConnection secondScreenServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            secondScreenService = IPoyntSecondScreenService.Stub.asInterface(iBinder);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            secondScreenService.capturePhoneNumber(SecondScreenLabels.DEFAULT, SecondScreenLabels.CONFIRM,
                                    phoneEntryListener);

                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                });


        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            secondScreenService = null;
        }
    };

      private IPoyntSecondScreenPhoneEntryListener phoneEntryListener =
            new IPoyntSecondScreenPhoneEntryListener.Stub() {
                @Override
                public void onPhoneEntered(String phone) throws RemoteException {
                    showToast("Captured Phone: " + phone);
                    if (phone.toString().isEmpty() || phone.length() < 7) {
                        secondScreenService.displayMessage("Mobile no should not be less than 7 digits!", null);
                        AppController.getInstance().setPhoneNumber(phone);
                        showWelcomeScreen();
                        finish();
                    }
                    else {
                        AppController.getInstance().setPhoneNumber(phone);
                        showWelcomeScreen();
                        finish();
                    }
                }

                @Override
                public void onPhoneEntryCanceled() throws RemoteException {
                    showToast("User canceled phone entry");
                    AppController.getInstance().setPhoneNumber(null);
                    showWelcomeScreen();
                    finish();
                }
            };
    private void showWelcomeScreen() {
        try {
            secondScreenService.displayWelcome(null, null, null);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        bindService(Intents.getComponentIntent(Intents.COMPONENT_POYNT_SECOND_SCREEN_SERVICE),
                secondScreenServiceConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            secondScreenService.displayWelcome(null, null, null);
        } catch (RemoteException | NullPointerException e) {
            e.printStackTrace();
        }
        unbindService(secondScreenServiceConnection);
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        try {
//            secondScreenService.displayWelcome(null, null, null);
//        } catch (RemoteException | NullPointerException e) {
//            e.printStackTrace();
//        }
//        unbindService(secondScreenServiceConnection);
//    }

    private void showToast(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(PhoneCaptureSecondScreen.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
