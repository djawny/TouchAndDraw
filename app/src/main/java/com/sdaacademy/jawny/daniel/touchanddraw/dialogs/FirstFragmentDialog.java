package com.sdaacademy.jawny.daniel.touchanddraw.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sdaacademy.jawny.daniel.touchanddraw.R;
import com.sdaacademy.jawny.daniel.touchanddraw.views.PaintView;


public class FirstFragmentDialog extends DialogFragment {

    public interface OnDismissListener {
        void onDismiss();
    }

    private OnDismissListener onDismissListener;
    private PaintView paintView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container);
        paintView = (PaintView) view.findViewById(R.id.paintView);
        return view;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);

        if (onDismissListener != null)
            onDismissListener.onDismiss();
    }
}
