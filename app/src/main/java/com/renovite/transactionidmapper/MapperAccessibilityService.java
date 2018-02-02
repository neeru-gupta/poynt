package com.renovite.transactionidmapper;


import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.RemoteException;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import com.renovite.transactionidmapper.activities.AppController;
import com.renovite.transactionidmapper.activities.PhoneCaptureSecondScreen;
import com.renovite.transactionidmapper.utils.Utils;

import java.util.List;

import co.poynt.os.model.SecondScreenLabels;

@RequiresApi(api = Build.VERSION_CODES.DONUT)
public class MapperAccessibilityService extends AccessibilityService {

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        System.out.println("onAccessibilityEvent");
        if (event.getEventType() == AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED) {
            System.out.println("notification: " + event.getText());
        }

//        AccessibilityNodeInfo nodeInfo = event.getSource();
//        if (nodeInfo == null) {
//            return;
//        }
//        nodeInfo.refresh();
//
//
//        if (isCashButtonClicked(nodeInfo) || isChargeButtonClicked(nodeInfo)) {
//            AppController.getInstance().setPhoneNumber(null);
//            if (isAmountAvailable(nodeInfo))
//                navigateSecondScreen();
//
//        } else if (isCashRegisteredButtonClicked(nodeInfo) || isChargeRegisteredButtonClicked(nodeInfo)) {
//            AppController.getInstance().setPhoneNumber(null);
//            if (isAmountRegisteredAvailable(nodeInfo))
//                navigateSecondScreen();
//
//        }


    }

    private void navigateSecondScreen() {

//        Intent intentLaunch = new Intent(MapperAccessibilityService.this, PhoneCaptureSecondScreen.class);
//        intentLaunch.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
//        startActivity(intentLaunch);
//        try {
//            AppController.getInstance().secondScreenService.capturePhoneNumber(SecondScreenLabels.DEFAULT, SecondScreenLabels.CONFIRM,
//                    AppController.getInstance().phoneEntryListener);
//
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }


    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private boolean isCashButtonClicked(AccessibilityNodeInfo nodeInfo) {
        if (nodeInfo != null) {
            if (nodeInfo.getText() != null && nodeInfo.getViewIdResourceName() != null && nodeInfo.getClassName() != null) {
                if (nodeInfo.getText().toString().equalsIgnoreCase("CASH") && nodeInfo.getClassName().toString().equalsIgnoreCase("android.widget.Button") && nodeInfo.getViewIdResourceName().equalsIgnoreCase("co.poynt.terminal:id/cancel")) {

                    return true;
                } else
                    return false;
            } else
                return false;
        }
        return false;

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private boolean isCashRegisteredButtonClicked(AccessibilityNodeInfo nodeInfo) {
        if (nodeInfo != null) {
            if (nodeInfo.getText() != null && nodeInfo.getViewIdResourceName() != null && nodeInfo.getClassName() != null) {
                if (nodeInfo.getText().toString().equalsIgnoreCase("CASH") && nodeInfo.getClassName().toString().equalsIgnoreCase("android.widget.TextView") && nodeInfo.getViewIdResourceName().equalsIgnoreCase("co.poynt.register:id/cash_label")) {

                    return true;
                } else
                    return false;
            } else
                return false;
        }
        return false;

    }

    private boolean isChargeRegisteredButtonClicked(AccessibilityNodeInfo nodeInfo) {
        if (nodeInfo != null) {
            if (nodeInfo.getViewIdResourceName() != null && nodeInfo.getClassName() != null) {
                if (nodeInfo.getClassName().toString().equalsIgnoreCase("android.widget.LinearLayout") && nodeInfo.getViewIdResourceName().equalsIgnoreCase("co.poynt.register:id/charge_container")) {

                    return true;
                } else
                    return false;
            } else
                return false;
        }
        return false;

    }


    private boolean isChargeButtonClicked(AccessibilityNodeInfo nodeInfo) {
        if (nodeInfo != null) {
            if (nodeInfo.getText() != null && nodeInfo.getViewIdResourceName() != null && nodeInfo.getClassName() != null) {
                if (nodeInfo.getText().toString().equalsIgnoreCase("CHARGE") && nodeInfo.getClassName().toString().equalsIgnoreCase("android.widget.Button") && nodeInfo.getViewIdResourceName().equalsIgnoreCase("co.poynt.terminal:id/enter")) {

                    return true;
                } else
                    return false;
            } else
                return false;
        }
        return false;

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private boolean isAmountRegisteredAvailable(AccessibilityNodeInfo nodeInfo) {
        boolean isAmountAvailable = false;
        try {
            List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = nodeInfo.getParent().getParent().findAccessibilityNodeInfosByViewId(nodeInfo.getParent().getViewIdResourceName());
            if (findAccessibilityNodeInfosByViewId.size() > 0) {
                for (int i = 0; i < findAccessibilityNodeInfosByViewId.size(); i++) {
                    AccessibilityNodeInfo parent = (AccessibilityNodeInfo) findAccessibilityNodeInfosByViewId.get(i);
                    int childcount = parent.getChildCount();
                    for (int j = 0; j < childcount; j++) {
                        try {
                            AccessibilityNodeInfo child = parent.getChild(j);


                            if ((child.getViewIdResourceName().equalsIgnoreCase("co.poynt.register:id/amount_integer") && child.getClassName().toString().equalsIgnoreCase("android.widget.TextView") && child.getText().toString() != null) || (child.getViewIdResourceName().equalsIgnoreCase("co.poynt.register:id/last_item_total") && child.getClassName().toString().equalsIgnoreCase("android.widget.TextView") && child.getText().toString() != null)) {

                                if (Double.parseDouble(Utils.replaceAllAlpha(child.getText().toString())) > 0)

                                    return true;
                                else
                                    return false;

                            }
                            isAmountAvailable = false;

                        } catch (Exception e) {
                            continue;
                        }
                    }

                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return isAmountAvailable;

    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private boolean isAmountAvailable(AccessibilityNodeInfo nodeInfo) {
        boolean isAmountAvailable = false;
        try {
            List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = nodeInfo.getParent().getParent().findAccessibilityNodeInfosByViewId(nodeInfo.getParent().getViewIdResourceName());
            if (findAccessibilityNodeInfosByViewId.size() > 0) {
                for (int i = 0; i < findAccessibilityNodeInfosByViewId.size(); i++) {
                    AccessibilityNodeInfo parent = (AccessibilityNodeInfo) findAccessibilityNodeInfosByViewId.get(i);
                    int childcount = parent.getChildCount();
                    for (int j = 0; j < childcount; j++) {
                        try {
                            AccessibilityNodeInfo child = parent.getChild(j);
                            if (child.getViewIdResourceName().equalsIgnoreCase("co.poynt.terminal:id/amount") && child.getClassName().toString().equalsIgnoreCase("android.widget.TextView") && child.getText().toString() != null) {

                                if (Double.parseDouble(Utils.replaceAllAlpha(child.getText().toString())) > 0)

                                    return true;
                                else
                                    return false;

                            }
                            isAmountAvailable = false;

                        } catch (Exception e) {
                            continue;
                        }
                    }

                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return isAmountAvailable;

    }


    @RequiresApi(api = Build.VERSION_CODES.DONUT)
    @Override
    protected void onServiceConnected() {
        System.out.println("onServiceConnected");
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.eventTypes = AccessibilityEvent.TYPE_VIEW_HOVER_ENTER | AccessibilityEvent.TYPE_VIEW_HOVER_EXIT | AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED | AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED | AccessibilityEvent.TYPE_VIEW_CLICKED | AccessibilityEvent.TYPE_VIEW_CONTEXT_CLICKED | AccessibilityEvent.CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION | AccessibilityEvent.CONTENT_CHANGE_TYPE_TEXT;

        info.flags = AccessibilityServiceInfo.DEFAULT |
                AccessibilityServiceInfo.FLAG_RETRIEVE_INTERACTIVE_WINDOWS |
                AccessibilityServiceInfo.FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY |

                AccessibilityServiceInfo.FLAG_REPORT_VIEW_IDS;
        info.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        info.notificationTimeout = 100;
        info.feedbackType = AccessibilityEvent.TYPES_ALL_MASK;
        setServiceInfo(info);
    }

    @Override
    public void onInterrupt() {
        System.out.println("onInterrupt");
    }
}