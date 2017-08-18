package weimin.clickthroughimageviewdemo;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.weimin.clickthroughimageview.CTImageView;

public class MainActivity extends AppCompatActivity {


    CTImageView customImageViewFront, customImageViewBack;
    private int screenWidth, screenHeight;
    final int [] bambiLocation = new int[2];
    final int [] foxLocation = new int[2];
    final int [] cLocation = new int[2];
    View rootView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenWidth = metrics.widthPixels;
        screenHeight = metrics.heightPixels;
        cLocation[0] = (int) (screenWidth * 0.5);
        cLocation[1] = (int) (screenHeight * 0.5);
        rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        //Remove the listener before proceeding
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        } else {
                            rootView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        }

                        // measure your views here
                        getViewLocation(customImageViewBack, bambiLocation, metrics, 0);
                        getViewLocation(customImageViewFront, foxLocation, metrics, 0);
                    }
                }
        );

        customImageViewFront =
                (CTImageView) findViewById(R.id.civ_deadpool);
        customImageViewFront.setName("customImageViewFront");
        customImageViewBack =
                (CTImageView) findViewById(R.id.civ_bambi);
        customImageViewBack.setName("customImageViewBack");

        customImageViewFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("CustomImageViewFront", "on Click");
                customImageViewFront.animate()
                        .scaleX(3)
                        .scaleY(3)
                        .alpha(1f)
                        .x(cLocation[0]-customImageViewFront.getWidth()/2)
                        .y(cLocation[1])
                        .setDuration(2000)
                        .start();

                customImageViewBack.animate()
                        .scaleX(1)
                        .scaleY(1)
                        .alpha(0.4f)
                        .x(bambiLocation[0])
                        .y(bambiLocation[1])
                        .setDuration(2000)
                        .start();

            }
        });


        customImageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("CustomImageViewBack", "on Click");

                customImageViewBack.animate()
                        .scaleX(3)
                        .scaleY(3)
                        .alpha(1f)
                        .x(cLocation[0]-customImageViewBack.getWidth()/2)
                        .y(cLocation[1])
                        .setDuration(2000)
                        .start();

                customImageViewFront.animate()
                        .alpha(0.4f)
                        .scaleX(1)
                        .scaleY(1)
                        .x(foxLocation[0])
                        .y(foxLocation[1])
                        .setDuration(2000)
                        .start();
            }
        });

    }


    private void getViewLocation(CTImageView customImageViewBack, int[] bambiLocation,
            DisplayMetrics metrics, int finalI) {
        Rect offsetViewBounds = new Rect();
        //returns the visible bounds
        customImageViewBack.getDrawingRect(offsetViewBounds);
        // calculates the relative coordinates to the parent
        ((ViewGroup)rootView).offsetDescendantRectToMyCoords(customImageViewBack, offsetViewBounds);

        bambiLocation[1] = offsetViewBounds.top;
        bambiLocation[0] = offsetViewBounds.left - metrics.widthPixels * finalI;

    }

}
