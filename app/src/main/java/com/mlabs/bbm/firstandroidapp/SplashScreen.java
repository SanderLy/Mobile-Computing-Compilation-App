package com.mlabs.bbm.firstandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by benjarmanalili on 16/07/2016.
 */
public class SplashScreen extends Activity{
    ImageView imgdarkblue, imgpalette;
    Animation zoom_in,fade_in;
    TextView txtPalette;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        imgdarkblue = (ImageView) findViewById(R.id.imgdarkblue);
        imgpalette = (ImageView)findViewById(R.id.imgPalette);
        txtPalette = (TextView)findViewById(R.id.txtPalette);
        zoom_in = AnimationUtils.loadAnimation(getBaseContext(),R.anim.zoom_in);
        fade_in = AnimationUtils.loadAnimation(getBaseContext(),R.anim.fade_in);
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    imgdarkblue.startAnimation(zoom_in);
                    zoom_in.cancel();
                    txtPalette.setAnimation(fade_in);
                    imgpalette.startAnimation(fade_in);
                    sleep(2000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally{
                    Intent intent = new Intent(SplashScreen.this,login.class );
                    startActivity(intent);
                }
            }
        };
            timerThread.start();
    }

    @Override
    protected  void onPause(){
        super.onPause();
        finish();
    }
}
