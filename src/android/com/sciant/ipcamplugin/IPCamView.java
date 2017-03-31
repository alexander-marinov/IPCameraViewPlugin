package com.sciant.ipcamplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class IPCamView extends CordovaPlugin {
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (action.equals("play")) {
                String host = args.getString(0);
                String port = args.getString(1);
                String user = args.getString(2);
                String pass = args.getString(3);
                Context context = cordova.getActivity().getApplicationContext();
                String className = "com.sciant.ipcamplugin.IPCamPlayer";
                Intent intent = new Intent(context,Class.forName(className));
                intent.putExtra("host", host);
                intent.putExtra("port", port);
                intent.putExtra("user", user);
                intent.putExtra("pass", pass);
                cordova.startActivityForResult(this,intent,1);
                callbackContext.success();
                return true;
            }
            callbackContext.error("Invalid action");
            return false;
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Handle a result here if one set in the Activity class started
        System.out.println("Activity Result: " + resultCode); //-1 is RESULT_OK
        if (resultCode== Activity.RESULT_OK) {
            System.out.println("All good!");
        }
    }
}