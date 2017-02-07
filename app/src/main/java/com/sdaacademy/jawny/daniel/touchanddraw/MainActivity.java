package com.sdaacademy.jawny.daniel.touchanddraw;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showAlertDialog();
    }

    private void showAlertDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setMessage("Cześć, jestem AlertDialog")
                .setCancelable(false)
                .setPositiveButton("Super",this)
                .create();
        alertDialog.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case AlertDialog.BUTTON_POSITIVE:
                dialog.dismiss();
                break;
            case AlertDialog.BUTTON_NEGATIVE:
                break;
            case AlertDialog.BUTTON_NEUTRAL:
                break;
        }
    }
}
