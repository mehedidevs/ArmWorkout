package com.example.armworkout.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.armworkout.R;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;

public class Day4_Activity extends AppCompatActivity {

    private Toolbar toolbar;
    CardView btn_start_animationIm;
    ImageView animImageView, animImageView2, animImageView3,
            animImageView4,animImageView5,animImageVIew6,animImageView7,animImageView8, animImageView9;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day4_);

        NativeLoader();
        InterTastital_ad();
        animImageView = (ImageView) findViewById(R.id.iv_animation);
        animImageView2 = findViewById(R.id.animation_img2);
        animImageView3 = findViewById(R.id.animation_img3);
        animImageView4 = findViewById(R.id.animation_img4);
        animImageView5 = findViewById(R.id.animation_img5);
        animImageVIew6 = findViewById(R.id.animation_img6);
        animImageView7 = findViewById(R.id.animation_img7);
        animImageView8 = findViewById(R.id.animation_img8);
        animImageView9 = findViewById(R.id.animation_img9);

        animImageView2.setBackgroundResource(R.drawable.anim11); //komore hat
        animImageView.setBackgroundResource(R.drawable.anim1); //push
        animImageView3.setBackgroundResource(R.drawable.anim14);//14
        animImageView4.setBackgroundResource(R.drawable.anim15); ///15
        animImageView5.setBackgroundResource(R.drawable.anim9); //9
        animImageVIew6.setBackgroundResource(R.drawable.anim1); //1
        animImageView7.setBackgroundResource(R.drawable.anim10); //10
        animImageView8.setBackgroundResource(R.drawable.anim7); ///8
        animImageView9.setBackgroundResource(R.drawable.anim7right); ///8

        animImageView.post(new Runnable() {
            @Override
            public void run() {
                AnimationDrawable frameAnimation =
                        (AnimationDrawable) animImageView.getBackground();
                frameAnimation.start();
            }
        });
        animImageView2.post(new Runnable() {
            @Override
            public void run() {
                AnimationDrawable frameAnimation =
                        (AnimationDrawable) animImageView2.getBackground();
                frameAnimation.start();
            }
        });
        animImageView3.post(new Runnable() {
            @Override
            public void run() {
                AnimationDrawable frameAnimation =
                        (AnimationDrawable) animImageView3.getBackground();
                frameAnimation.start();
            }
        });
        animImageView4.post(new Runnable() {
            @Override
            public void run() {
                AnimationDrawable frameAnimation =
                        (AnimationDrawable) animImageView4.getBackground();
                frameAnimation.start();
            }
        });
        animImageView5.post(new Runnable() {
            @Override
            public void run() {
                AnimationDrawable frameAnimation =
                        (AnimationDrawable) animImageView5.getBackground();
                frameAnimation.start();
            }
        });
        animImageVIew6.post(new Runnable() {
            @Override
            public void run() {
                AnimationDrawable frameAnimation =
                        (AnimationDrawable) animImageVIew6.getBackground();
                frameAnimation.start();
            }
        });
        animImageView7.post(new Runnable() {
            @Override
            public void run() {
                AnimationDrawable frameAnimation =
                        (AnimationDrawable) animImageView7.getBackground();
                frameAnimation.start();
            }
        });
        animImageView8.post(new Runnable() {
            @Override
            public void run() {
                AnimationDrawable frameAnimation =
                        (AnimationDrawable) animImageView8.getBackground();
                frameAnimation.start();
            }
        });
        animImageView9.post(new Runnable() {
            @Override
            public void run() {
                AnimationDrawable frameAnimation =
                        (AnimationDrawable) animImageView9.getBackground();
                frameAnimation.start();
            }
        });


        btn_start_animationIm = findViewById(R.id.btn_start_animationIm);
        btn_start_animationIm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd.isLoaded()){
                    mInterstitialAd.show();
                    mInterstitialAd.setAdListener(new AdListener(){
                        @Override
                        public void onAdClosed() {
                            super.onAdClosed();
                            Intent intent = new Intent(getApplicationContext(),Change_day4_Activity.class);
                            startActivity(intent);
                        }
                    });
                }
                else {
                    Intent intent = new Intent(getApplicationContext(),Change_day4_Activity.class);
                    startActivity(intent);
                }

            }
        });

        initToollbar();
    }
    private void initToollbar() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        int toolbar_item_color = ResourcesCompat.getColor(getResources(),R.color.blue,null);
        toolbar.setTitleTextColor(toolbar_item_color);
        toolbar.setSubtitleTextColor(toolbar_item_color);
        getSupportActionBar().setTitle("Day 4");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home)
        {
            finish();
        }

        return super.onOptionsItemSelected(item);

    }
    private void NativeLoader() {

        AdLoader.Builder builder = new AdLoader.Builder(
                this, getString(R.string.native_id));

        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                TemplateView template = findViewById(R.id.my_template3);
                template.setNativeAd(unifiedNativeAd);

                TemplateView templateView_big  = findViewById(R.id.my_template4);
                templateView_big.setNativeAd(unifiedNativeAd);
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





