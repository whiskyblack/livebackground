package yami.livebackground;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;

public class DemoActivity extends AppCompatActivity {
    DisplayMetrics metrics;
    RelativeLayout layout;
    LiveBackground background;
    public static boolean firefly=false, rain=false, dandelion=false, moonlight=false, sunlight=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        layout= (RelativeLayout) findViewById(R.id.layout);
        metrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        background=new LiveBackground(this,metrics);
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

    public void custom(View view) {
        startActivity(new Intent(DemoActivity.this,CustomActivity.class));
        finish();
    }
}
