package com.sciant.ipcamplugin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class IPCamPlayer extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = this.getIntent();
        String host = intent.getStringExtra("host");
        String port = intent.getStringExtra("port");
        String user = intent.getStringExtra("user");
        String pass = intent.getStringExtra("pass");

        String message = "host: " + host + " port: " + port + " user: " + user + " pass: " + pass;

        AlertDialog alertDialog = new AlertDialog.Builder(IPCamPlayer.this).create();
        alertDialog.setTitle("IP Camera Player Plugin");
        alertDialog.setMessage(message);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which)
            {
                finish();
            }
        });
        alertDialog.show();
    }
}
