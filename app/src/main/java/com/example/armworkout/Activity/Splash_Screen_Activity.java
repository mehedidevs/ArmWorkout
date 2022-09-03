package com.example.armworkout.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.agrawalsuneet.dotsloader.loaders.LazyLoader;
import com.example.armworkout.MainActivity;
import com.example.armworkout.R;

import java.util.Locale;

public class Splash_Screen_Activity extends AppCompatActivity {


    LazyLoader lazyLoader;
    private TextToSpeech myTTS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen_);
        initializeTextToSpeech();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            //  myTTS.stop();
                finish();
            }
        },5000);
       lazyLoader = findViewById(R.id.myLoader_progress);
        LazyLoader loader = new LazyLoader(this, 30, 20, ContextCompat.getColor(this, R.color.loader_selected),
                ContextCompat.getColor(this, R.color.loader_selected),
                ContextCompat.getColor(this, R.color.loader_selected));
        loader.setAnimDuration(500);
        loader.setFirstDelayDuration(100);
        loader.setSecondDelayDuration(200);
        loader.setInterpolator(new LinearInterpolator());

        lazyLoader.addView(loader);

    }

    private void initializeTextToSpeech() {

        myTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (myTTS.getEngines().size()==0){
                    Toast.makeText(Splash_Screen_Activity.this,"The are no TTs device on your device",Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    myTTS.setLanguage(Locale.ENGLISH);
                    speak(" Welcome back  to our virtual zim app ! Hoping  you will enjoy your time  through our app   ");
                }
            }
        });
    }
    private void speak(String message) {

        if(Build.VERSION.SDK_INT>=21){

            myTTS.speak(message,TextToSpeech.QUEUE_FLUSH,null,null);
        }else{
            myTTS.speak(message,TextToSpeech.QUEUE_FLUSH,null);
        }

    }
}
