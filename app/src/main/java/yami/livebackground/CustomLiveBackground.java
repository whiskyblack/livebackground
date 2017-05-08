package yami.livebackground;

import android.content.Context;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.View;

import sky.night.nature.background.CurrentBackground;
import sky.night.nature.effect.dandelion.Dandelion;
import sky.night.nature.effect.firefly.FireFly;
import sky.night.nature.effect.moonlight.MoonLight;
import sky.night.nature.effect.rain.Rain;
import sky.night.nature.effect.sunlight.SunLight;

import static yami.livebackground.CustomActivity.dandelion;
import static yami.livebackground.CustomActivity.firefly;
import static yami.livebackground.CustomActivity.moonlight;
import static yami.livebackground.CustomActivity.rain;
import static yami.livebackground.CustomActivity.sunlight;

/**
 * Created by Nguyen Trung on 5/8/2017.
 */

public class CustomLiveBackground extends View {
    CurrentBackground background;
    MoonLight moonLight;
    FireFly fireFly;
    SunLight sunLight;
    Rain r;
    Dandelion dan;

    public CustomLiveBackground(Context context, DisplayMetrics metrics) {
        super(context);
        // My background
        background = new CurrentBackground(context, metrics, "bg0.jpg", "bg1.jpg", "bg2.jpg", "bg3.jpg");
        // My firefly
        fireFly = new FireFly(context, metrics, "firefly.png");
        fireFly.create(10);
        // Demo
        moonLight = new MoonLight(context, metrics, null);
        moonLight.create(5);
        // Demo
        dan = new Dandelion(context, metrics, null);
        dan.create(5);
        // Demo
        sunLight = new SunLight(context, metrics, null);
        sunLight.create(5);
        // Demo
        r = new Rain(context, metrics, null);
        r.create(25);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(background.bitmapCurrent(canvas.getWidth(), canvas.getHeight()), 0, 0, null);
        if (firefly)
            fireFly.start();
        else if (fireFly.isRunning())
            fireFly.stop();
        if (dandelion)
            dan.start();
        else if (dan.isRunning())
            dan.stop();
        if (rain)
            r.start();
        else if (r.isRunning())
            r.stop();
        if (moonlight)
            moonLight.start();
        else if (moonLight.isRunning())
            moonLight.stop();
        if (sunlight)
            sunLight.start();
        else if (sunLight.isRunning())
            sunLight.stop();
        sunLight.draw(canvas);
        r.draw(canvas);
        dan.draw(canvas);
        fireFly.draw(canvas);
        moonLight.draw(canvas);
        invalidate();
    }
}
