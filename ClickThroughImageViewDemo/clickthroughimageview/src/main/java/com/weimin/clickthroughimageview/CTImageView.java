package com.weimin.clickthroughimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by weiminding on 8/11/17.
 */

public class CTImageView extends android.support.v7.widget.AppCompatImageView{

    private String name;
    private int keyingColor;
    private int a,r,g,b;

    public CTImageView(Context context) {
        super(context);
    }

    public CTImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getKeyingColor(context, attrs);
    }

    public CTImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getKeyingColor(context, attrs);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    private void getKeyingColor(Context context, @Nullable AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CTImageView);
        keyingColor = ta.getColor(R.styleable.CTImageView_keyingcolor, 0);
        Log.e("CTImage", " after parse " + Color.alpha(keyingColor)+","+Color.red(keyingColor)+","
        +Color.green(keyingColor)+","+Color.blue(keyingColor));
        a=Color.alpha(keyingColor);
        r=Color.red(keyingColor);
        g=Color.green(keyingColor);
        b=Color.blue(keyingColor);
        ta.recycle();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(MotionEventCompat.getActionMasked(event))
        {
            case MotionEvent.ACTION_DOWN:
                Matrix inverse = new Matrix();
                getImageMatrix().invert(inverse);
                float[] touchPoint = new float[] {event.getX(), event.getY()};
                inverse.mapPoints(touchPoint);
                int x = Integer.valueOf((int)touchPoint[0]);
                int y = Integer.valueOf((int)touchPoint[1]);
                if(null != getDrawable()) {
                    Bitmap bitmap = ((BitmapDrawable) getDrawable()).getBitmap();
                    int pixel = bitmap.getPixel(x, y);
                    int red = Color.red(pixel);
                    int blue = Color.blue(pixel);
                    int green = Color.green(pixel);
                    int alpha = Color.alpha(pixel);
                    //Log.e(getName(), "color " + alpha +","+ red + "," + green + "," + blue);
                    if (a == alpha && r == red && g == green && b == blue) {
                        // not consume and it will pass to parent
                        return false;
                    } else {
                        bringToFront();
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(event);
    }





}
