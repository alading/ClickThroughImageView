package weimin.clickthroughimageviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
                RelativeLayout.LayoutParams layoutParamsFront = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                customImageViewFront.setLayoutParams(layoutParamsFront);
                customImageViewBack.setAlpha(0.3f);
                Toast.makeText(MainActivity.this, "CustomImageViewFront clicked", Toast.LENGTH_SHORT).show();

            }
        });


        customImageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("CustomImageViewBack", "on Click");

                customImageViewBack.setAlpha(1f);
                RelativeLayout.LayoutParams layoutParamsBack = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                customImageViewBack.setLayoutParams(layoutParamsBack);

                customImageViewFront.setAlpha(0.3f);
                Toast.makeText(MainActivity.this, "CustomImageViewBack clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
