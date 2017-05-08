package yami.livebackground;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;

public class CustomActivity extends AppCompatActivity {
    DisplayMetrics metrics;
    RelativeLayout layout;
    CustomLiveBackground background;
    public static boolean firefly=false, rain=false, dandelion=false, moonlight=false, sunlight=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        layout= (RelativeLayout) findViewById(R.id.layout);
        metrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        background=new CustomLiveBackground(this,metrics);
        layout.addView(background, 0);
    }

    public void firefly(View view) {
        if (!firefly)
            firefly=true;
        else
            firefly=false;
    }

    public void rain(View view) {
        if (!rain)
            rain=true;
        else
            rain=false;
    }

    public void dandelion(View view) {
        if (!dandelion)
            dandelion=true;
        else
            dandelion=false;
    }

    public void sunlight(View view) {
        if (!sunlight)
            sunlight=true;
        else
            sunlight=false;
    }

    public void moonlight(View view) {
        if (!moonlight)
            moonlight=true;
        else
            moonlight=false;
    }

    public void demo(View view) {
        startActivity(new Intent(CustomActivity.this, DemoActivity.class));
        finish();
    }
}
