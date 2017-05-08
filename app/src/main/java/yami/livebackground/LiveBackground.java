package yami.livebackground;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.View;

import sky.night.nature.background.CurrentBackground;
import sky.night.nature.effect.dandelion.Dandelion;
import sky.night.nature.effect.firefly.FireFly;
import sky.night.nature.effect.moonlight.MoonLight;
import sky.night.nature.effect.rain.Rain;
import sky.night.nature.effect.sunlight.SunLight;

import static yami.livebackground.DemoActivity.dandelion;
import static yami.livebackground.DemoActivity.firefly;
import static yami.livebackground.DemoActivity.moonlight;
import static yami.livebackground.DemoActivity.rain;
import static yami.livebackground.DemoActivity.sunlight;

/**
 * Created by Nguyen Trung on 5/7/2017.
 */

public class LiveBackground extends View {
    CurrentBackground background;
    MoonLight moonLight;
    FireFly fireFly;
    SunLight sunLight;
    Rain r;
    Dandelion dan;

    public LiveBackground(Context context, DisplayMetrics metrics) {
        super(context);
        background=new CurrentBackground(context, metrics, null, null, null, null);
//        background=new CurrentBackground(context, metrics, "bg0.jpg", "bg1.jpg", "bg2.jpg", "bg3.jpg");
        fireFly=new FireFly(context, metrics, null);
        fireFly.create(10);
        moonLight=new MoonLight(context, metrics, null);
        moonLight.create(5);
        dan=new Dandelion(context,metrics, null);
        dan.create(5);
        sunLight=new SunLight(context,metrics,null);
        sunLight.create(5);
        r=new Rain(context,metrics,null);
        r.create(25);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(background.bitmapCurrent(canvas.getWidth(), canvas.getHeight()),0,0,null);
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
