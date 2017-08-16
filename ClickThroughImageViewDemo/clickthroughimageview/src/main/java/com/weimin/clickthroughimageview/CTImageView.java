package com.weimin.clickthroughimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by weiminding on 8/11/17.
 */

public class CTImageView extends android.support.v7.widget.AppCompatImageView{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public CTImageView(Context context) {
        super(context);
    }

    public CTImageView(Context context,
            @Nullable AttributeSet attrs) {
        super(context, attrs);
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
                    int r = Color.red(pixel);
                    int b = Color.blue(pixel);
                    int g = Color.green(pixel);
                    int a = Color.alpha(pixel);
                    //Log.e(getName(), "color " + a+","+r + "," + g + "," + b);
                    if (a<255) {
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
