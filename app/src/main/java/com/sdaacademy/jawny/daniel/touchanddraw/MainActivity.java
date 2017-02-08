package com.sdaacademy.jawny.daniel.touchanddraw;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.sdaacademy.jawny.daniel.touchanddraw.dialogs.FirstFragmentDialog;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener, FirstFragmentDialog.OnDismissListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        showAlertDialog();
        showDialogFragment();
    }

    private void showDialogFragment() {
        FirstFragmentDialog firstFragmentDialog = new FirstFragmentDialog();
        firstFragmentDialog.setOnDismissListener(this);

        firstFragmentDialog.show(getSupportFragmentManager(), null);
    }

    private void showAlertDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setMessage("Cześć, jestem AlertDialog")
                .setCancelable(false)
                .setPositiveButton("Super", this)
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

    @Override
    public void onDismiss() {
        {
            Toast.makeText(this, "No i super!", Toast.LENGTH_LONG).show();
        }
    }
}