package com.sdaacademy.jawny.daniel.touchanddraw.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.sdaacademy.jawny.daniel.touchanddraw.R;

import java.util.ArrayList;
import java.util.List;

public class PaintView extends View implements View.OnTouchListener {

    public static final String TAG = PaintView.class.getSimpleName();
    float[] startX;
    float[] startY;
    float[] endX;
    float[] endY;
    List<RectF> lines = new ArrayList<>();
    private int radius;
    private Paint paintLine;
    private Paint paintBackground;

    public PaintView(Context context) {
        super(context);
        init();
    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PaintView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PaintView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        radius = getResources().getDimensionPixelSize(R.dimen.activity_vertical_margin);
        setOnTouchListener(this);
        startX = new float[10];
        startY = new float[10];
        endX = new float[10];
        endY = new float[10];

        paintLine = new Paint();
        paintLine.setStrokeWidth(5);
        paintLine.setColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));

        paintBackground = new Paint();
        paintBackground.setStrokeWidth(5);
        paintBackground.setColor(Color.WHITE);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        int actionIndex = event.getActionIndex();
        float x = event.getX();
        float y = event.getY();
        Log.i(TAG, String.format("x,y = %f%f action= %d actionIndex=%d", x, y, action, actionIndex));

        switch (action) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                startX[actionIndex] = x;
                startY[actionIndex] = y;
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                endX[actionIndex] = x;
                endY[actionIndex] = y;
                lines.add(new RectF(startX[actionIndex],
                        startY[actionIndex],
                        endX[actionIndex],
                        endY[actionIndex]));
                invalidate();
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPaint(paintBackground);
        for (RectF rectF : lines) {
            canvas.drawLine(rectF.left, rectF.top, rectF.right, rectF.bottom, paintLine);
        }
    }
}
