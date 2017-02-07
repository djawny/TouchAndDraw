package com.sdaacademy.jawny.daniel.touchanddraw;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setMessage("Cześć, jestem AlertDialog")
                .setCancelable(false)
                .setPositiveButton("Super", null)
                .create();
        alertDialog.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}
