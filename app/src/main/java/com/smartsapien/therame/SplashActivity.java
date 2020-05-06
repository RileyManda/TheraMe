package com.smartsapien.therame;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

import de.hdodenhof.circleimageview.CircleImageView;

public class SplashActivity extends AwesomeSplash {
    private static int SPLASH_SCREEN_TIME_OUT=2000;

    CircleImageView mylogo;

//    public void setMylogo(CircleImageView mylogo) {
//        mylogo.setImageResource(R.drawable.therame);
//        this.mylogo = mylogo;
//    }

    @Override
    public void initSplash(ConfigSplash configSplash) {
        configSplash.setBackgroundColor(R.color.colorPrimary); //colors.xml
        configSplash.setAnimCircularRevealDuration(2000); //int// ms
        configSplash.setRevealFlagX(Flags.REVEAL_LEFT);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_TOP); //or Flags.REVEAL_TOP
        //Customize Logo
        configSplash.setLogoSplash(R.mipmap.ic_launcher_round); //drawable
        configSplash.setAnimLogoSplashDuration(2000); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.FadeIn);
       //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)

        //Customize Path
        // configSplash.setPathSplash(SyncStateContract.Constants.DROID_LOGO); //set path String
        configSplash.setOriginalHeight(400); //in relation to your svg (path) resource
        configSplash.setOriginalWidth(400); //in relation to your svg (path) resource
        configSplash.setAnimPathStrokeDrawingDuration(3000);
        configSplash.setPathSplashStrokeSize(5); //I advise value be <5
        configSplash.setPathSplashStrokeColor(R.color.colorAccent); //any color you want form colors.xml
        configSplash.setAnimPathFillingDuration(3000);
        configSplash.setPathSplashFillColor(R.color.colorPrimaryDark); //path object filling color


        // Title
        configSplash.setTitleSplash("TheraMe"); //change your app name here
        configSplash.setTitleTextColor(R.color.white);
        configSplash.setTitleTextSize(30f); //float value
        configSplash.setAnimTitleDuration(3000);
       // configSplash.setAnimTitleTechnique(Techniques.FlipInX);
        configSplash.setAnimTitleTechnique(Techniques.BounceIn);
//        configSplash.setTitleFont("fonts/Pacifico.ttf"); //provide string to your font located in assets/fonts/

    }

    @Override
    public void animationsFinished() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goHome = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(goHome);
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);
        Toast.makeText(SplashActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
    }
}
