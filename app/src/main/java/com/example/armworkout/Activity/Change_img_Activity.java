package com.example.armworkout.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.armworkout.R;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;

import java.util.Locale;


public class Change_img_Activity extends AppCompatActivity {

    AnimationDrawable frameAnimation;
    ImageView image_change;
    CardView btn_chagne;
    int current_image;
    int [] images = {R.drawable.anim5,R.drawable.anim1,R.drawable.anim2,
                     R.drawable.anim2,R.drawable.anim4,R.drawable.anim6,R.drawable.anim1,R.drawable.anim7};
    TextView tv_next, tv_go,tv_times;
    ProgressBar prog_timer;
    int secondRemaining = 0;
    int timestoshow = 0;

    CountDownTimer   timer = new CountDownTimer(30000,2500) {
        @Override
        public void onTick(long millisUntilFinished) {

            secondRemaining ++;
            timestoshow ++;
            count(Integer.toString(timestoshow) );
            tv_times.setText("Total "+Integer.toString(timestoshow) + " Times");
            prog_timer.setProgress(0 + secondRemaining);


            if (secondRemaining==12 ||secondRemaining==24 ||secondRemaining==36||secondRemaining==48 ||secondRemaining==60
            ||secondRemaining==84 ||secondRemaining==96|| secondRemaining==108||secondRemaining==120||secondRemaining==132 ||secondRemaining==144
            ){
                timestoshow=0;
                count("this is only 12 Times total PLease continue...... do it up to 30 times ");

            }
            if (secondRemaining>prog_timer.getMax()){

                Toast.makeText(Change_img_Activity.this, "pog test", Toast.LENGTH_LONG).show();

            }



        }

        @Override
        public void onFinish() {

            ///speak to next
            frameAnimation.stop();
            initializeTextToSpeech_next();

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn_chagne.setVisibility(View.VISIBLE);
                }
            },1000);

        }
    };
    ///speak system from here
    private TextToSpeech myTTS;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_img_);


        NativeLoader();
        InterTastital_ad();
       /* tv_times = (TextView)findViewById(R.id.tv_timer);
        prog_timer = (ProgressBar)findViewById(R.id.prog_time);*/
        image_change = findViewById(R.id.image_viewpager);

        btn_chagne = findViewById(R.id.btn_change);
      /*  btn_stop = findViewById(R.id.btn_stop);
        btn_push = findViewById(R.id.btn_push);
*/
        tv_go = findViewById(R.id.tv_go_text);
        tv_next = findViewById(R.id.tv_next_text);

        image_change = findViewById(R.id.image_viewpager);
        btn_chagne = findViewById(R.id.btn_change);

        tv_go = findViewById(R.id.tv_go_text);
        tv_next = findViewById(R.id.tv_next_text);
        tv_times = (TextView)findViewById(R.id.tv_timer);
        prog_timer = (ProgressBar)findViewById(R.id.prog_time);



        setOnclicked();
        initializeTextToSpeech();


    }
    private void setOnclicked() {

        btn_chagne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_image++;
                current_image = current_image % images.length;
                image_change.setBackgroundResource(images[current_image]);
                image_change.post(new Runnable() {
                    @Override
                    public void run() {
                        frameAnimation =
                                (AnimationDrawable) image_change.getBackground();
                        frameAnimation.start();

                        tv_go.setVisibility(View.INVISIBLE);
                        tv_next.setVisibility(View.VISIBLE);
                        /*circularViewWithTimer.startTimer();*/
                        //  timer.start();
                        timer.start();
                        btn_chagne.setVisibility(View.INVISIBLE);
                        myTTS.stop();

                    }
                });
            }
        });

    }
    private void initializeTextToSpeech() {

        myTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (myTTS.getEngines().size()==0){
                    Toast.makeText(Change_img_Activity.this,"The are no TTs device on your device",Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    myTTS.setLanguage(Locale.US);
                    speak("hello,are you ready to workout,,?");
                }
            }
        });
    }
    private void initializeTextToSpeech_next() {

        myTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (myTTS.getEngines().size()==0){
                    Toast.makeText(Change_img_Activity.this,"The are no TTs device on your device",Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    myTTS.setLanguage(Locale.US);
                    speak("it is done,now take some rest.After that, press the next button");
                }
            }
        });
    }

    public  void count(String count){


        if (myTTS.getEngines().size()==0){
            Toast.makeText(Change_img_Activity.this,"The are no TTs device on your device",Toast.LENGTH_SHORT).show();
            finish();
        }else{
            myTTS.setLanguage(Locale.US);
            speak(count);
        }
    }

    private void speak(String message) {

        if(Build.VERSION.SDK_INT>=21){

            myTTS.speak(message,TextToSpeech.QUEUE_FLUSH,null,null);
        }else{
            myTTS.speak(message,TextToSpeech.QUEUE_FLUSH,null);
        }

    }
    private void NativeLoader() {

        AdLoader.Builder builder = new AdLoader.Builder(
                this, getString(R.string.native_id));

        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                TemplateView template = findViewById(R.id.my_template);
                template.setNativeAd(unifiedNativeAd);

               /* TemplateView templateView_big  = findViewById(R.id.my_template_big);
                templateView_big.setNativeAd(unifiedNativeAd);*/
            }
        });

        AdLoader adLoader = builder.build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }
    private void InterTastital_ad() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstial_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }




}
