package weimin.clickthroughimageviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.weimin.clickthroughimageview.CTImageView;

public class MainActivity extends AppCompatActivity {


    CTImageView customImageViewFront, customImageViewBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customImageViewFront =
                (CTImageView) findViewById(R.id.civ_poster);
        customImageViewFront.setName("customImageViewFront");
        customImageViewBack =
                (CTImageView) findViewById(R.id.civ_poster_back);
        customImageViewBack.setName("customImageViewBack");

        customImageViewFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("CustomImageViewFront", "on Click");
                customImageViewFront.setAlpha(1f);
                customImageViewFront.animate()
                        .scaleX(2)
                        .scaleY(2)
                        .x(customImageViewFront.getWidth())
                        .y(customImageViewFront.getHeight()/2)
                        .setDuration(2000)
                        .start();

                customImageViewBack.setAlpha(0.3f);
                customImageViewBack.animate()
                        .scaleX(1)
                        .scaleY(1)
                        .x(0)
                        .y(0)
                        .setDuration(2000)
                        .start();


            }
        });


        customImageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("CustomImageViewBack", "on Click");

                customImageViewBack.setAlpha(1f);
                customImageViewBack.animate()
                        .scaleX(2)
                        .scaleY(2)
                        .x(customImageViewBack.getWidth()/3)
                        .y(customImageViewBack.getHeight()/3)
                        .setDuration(2000)
                        .start();


                customImageViewFront.setAlpha(0.3f);
                customImageViewFront.animate()
                        .scaleX(1)
                        .scaleY(1)
                        .x(0)
                        .y(0)
                        .setDuration(2000)
                        .start();
            }
        });

    }
}
