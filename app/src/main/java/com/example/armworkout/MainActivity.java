package com.example.armworkout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.armworkout.Activity.Day1_Activity;
import com.example.armworkout.Activity.Day2_Activity;
import com.example.armworkout.Activity.Day3_Activity;
import com.example.armworkout.Activity.Day4_Activity;
import com.example.armworkout.Activity.Day6_Activity;
import com.example.armworkout.Activity.Day7_Activity;
import com.example.armworkout.Activity.Day8_Activity;
import com.example.armworkout.Activity.Day9_Activity;
import com.example.armworkout.ViewpagerAdapter.ViewPagerAdapter2;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.tmall.ultraviewpager.UltraViewPager;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    LinearLayout btn_day_1, btn_day_2,btn_day3;
    LinearLayout    btn_day4, btn_day6, btn_day7, btn_day8, btn_day9;
    ImageView lock_1,lock_2,lock_3,lock_4,lock_6, lock_7, lock_8, lock_9;
    TextView tv_text_1,tv_text_2, tv_text_3,tv_text_4,tv_text_6, tv_text_7, tv_text_8, tv_text_9;
    int i = 0;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initToollbar();
        NativeLoader();
        InterTastital_ad();
        btn_day_2 = findViewById(R.id.btn_day_2);
        btn_day_1 = findViewById(R.id.btn_day_1);
        btn_day3 = findViewById(R.id.btn_card_3);
        btn_day4 = findViewById(R.id.btn_day_4);
        btn_day6 = findViewById(R.id.btn_day_6);
        btn_day7 = findViewById(R.id.btn_day_7);
        btn_day8 = findViewById(R.id.btn_day_8);
        btn_day9 = findViewById(R.id.btn_day_9);

        lock_1 = findViewById(R.id.img_lock_1);
        lock_2 = findViewById(R.id.img_lock_2);
        lock_3 = findViewById(R.id.img_lock_3);
        lock_4 = findViewById(R.id.img_lock_4);
        lock_6 = findViewById(R.id.img_lock_6);
        lock_7 = findViewById(R.id.img_lock_7);
        lock_8 = findViewById(R.id.img_lock_8);
        lock_9 = findViewById(R.id.img_lock_9);

        tv_text_1 = findViewById(R.id.tV_text_1);
        tv_text_2 = findViewById(R.id.tV_text_2);
        tv_text_3 = findViewById(R.id.tV_text_3);
        tv_text_4 = findViewById(R.id.tV_text_4);
        tv_text_6 = findViewById(R.id.tV_text_6);
        tv_text_7 = findViewById(R.id.tV_text_7);
        tv_text_8 = findViewById(R.id.tV_text_8);
        tv_text_9 = findViewById(R.id.tV_text_9);

        btn_day_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (i ==1)
                        {
                            Toast.makeText(MainActivity.this, "please double click...!", Toast.LENGTH_SHORT).show();
                        }
                        else if (i == 2)
                        {
                            if (mInterstitialAd.isLoaded()){
                                mInterstitialAd.show();
                                mInterstitialAd.setAdListener(new AdListener(){
                                    @Override
                                    public void onAdClosed() {
                                        super.onAdClosed();
                                        Intent intent = new Intent(getApplicationContext(), Day1_Activity.class);
                                        startActivity(intent);

                                    }
                                });
                            }
                            else {
                                Intent intent = new Intent(getApplicationContext(), Day1_Activity.class);
                                startActivity(intent);
                            }
                         //   lock_1.setVisibility(View.GONE);
                           // tv_text_1.setVisibility(View.VISIBLE);


                        }
                        i = 0;
                    }
                },500);



            }
        });
        btn_day_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (i ==1)
                        {
                            Toast.makeText(MainActivity.this, "please double click...!", Toast.LENGTH_SHORT).show();
                        }
                        else if (i == 2)
                        {
                            if (mInterstitialAd.isLoaded()){
                                mInterstitialAd.show();
                                mInterstitialAd.setAdListener(new AdListener(){
                                    @Override
                                    public void onAdClosed() {
                                        super.onAdClosed();
                                        Intent intent = new Intent(getApplicationContext(), Day2_Activity.class);
                                        startActivity(intent);

                                    }
                                });
                            }
                            else {
                                Intent intent = new Intent(getApplicationContext(), Day2_Activity.class);
                                startActivity(intent);
                            }
                       //    lock_2.setVisibility(View.GONE);
                        //   tv_text_2.setVisibility(View.VISIBLE);
                          /* Intent intent = new Intent(getApplicationContext(), Day2_Activity.class);
                           startActivity(intent);*/

                        }
                        i = 0;
                    }
                },500);

            }
        });
          btn_day3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (i ==1)
                        {
                            Toast.makeText(MainActivity.this, "please double click...!", Toast.LENGTH_SHORT).show();
                        }
                        else if (i == 2)
                        {
                            if (mInterstitialAd.isLoaded()){
                                mInterstitialAd.show();
                                mInterstitialAd.setAdListener(new AdListener(){
                                    @Override
                                    public void onAdClosed() {
                                        super.onAdClosed();
                                        Intent intent = new Intent(getApplicationContext(), Day3_Activity.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                            else {
                                Intent intent = new Intent(getApplicationContext(), Day3_Activity.class);
                                startActivity(intent);
                            }
                        //   lock_3.setVisibility(View.GONE);
                         //  tv_text_3.setVisibility(View.VISIBLE);


                        }
                        i = 0;
                    }
                },500);

            }
        });
        btn_day4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (i ==1)
                        {
                            Toast.makeText(MainActivity.this, "please double click...!", Toast.LENGTH_SHORT).show();
                        }
                        else if (i == 2)
                        {
                            if (mInterstitialAd.isLoaded()){
                                mInterstitialAd.show();
                                mInterstitialAd.setAdListener(new AdListener(){
                                    @Override
                                    public void onAdClosed() {
                                        super.onAdClosed();
                                        Intent intent = new Intent(getApplicationContext(), Day4_Activity.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                            else {
                                Intent intent = new Intent(getApplicationContext(), Day4_Activity.class);
                                startActivity(intent);
                            }
                         //   lock_4.setVisibility(View.GONE);
                          //  tv_text_4.setVisibility(View.VISIBLE);
                            /*Intent intent = new Intent(getApplicationContext(), Day4_Activity.class);
                            startActivity(intent);*/

                        }
                        i = 0;
                    }
                },500);

            }
        });
        btn_day6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (i ==1)
                        {
                            Toast.makeText(MainActivity.this, "please double click...!", Toast.LENGTH_SHORT).show();
                        }
                        else if (i == 2)
                        {
                            if (mInterstitialAd.isLoaded()){
                                mInterstitialAd.show();
                                mInterstitialAd.setAdListener(new AdListener(){
                                    @Override
                                    public void onAdClosed() {
                                        super.onAdClosed();
                                        Intent intent = new Intent(getApplicationContext(), Day6_Activity.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                            else {
                                Intent intent = new Intent(getApplicationContext(), Day6_Activity.class);
                                startActivity(intent);
                            }
                          //  lock_6.setVisibility(View.GONE);
                          //  tv_text_6.setVisibility(View.VISIBLE);
                            /*Intent intent = new Intent(getApplicationContext(), Day6_Activity.class);
                            startActivity(intent);*/

                        }
                        i = 0;
                    }
                },500);

            }
        });
        btn_day7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (i ==1)
                        {
                            Toast.makeText(MainActivity.this, "please double click...!", Toast.LENGTH_SHORT).show();
                        }
                        else if (i == 2)
                        {
                            if (mInterstitialAd.isLoaded()){
                                mInterstitialAd.show();
                                mInterstitialAd.setAdListener(new AdListener(){
                                    @Override
                                    public void onAdClosed() {
                                        super.onAdClosed();
                                        Intent intent = new Intent(getApplicationContext(), Day7_Activity.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                            else {
                                Intent intent = new Intent(getApplicationContext(), Day7_Activity.class);
                                startActivity(intent);
                            }
                          //  lock_7.setVisibility(View.GONE);
                         //   tv_text_7.setVisibility(View.VISIBLE);


                        }
                        i = 0;
                    }
                },500);

            }
        });
       btn_day8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (i ==1)
                        {
                            Toast.makeText(MainActivity.this, "please double click...!", Toast.LENGTH_SHORT).show();
                        }
                        else if (i == 2)
                        {
                            if (mInterstitialAd.isLoaded()){
                                mInterstitialAd.show();
                                mInterstitialAd.setAdListener(new AdListener(){
                                    @Override
                                    public void onAdClosed() {
                                        super.onAdClosed();
                                        Intent intent = new Intent(getApplicationContext(), Day8_Activity.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                            else {
                                Intent intent = new Intent(getApplicationContext(), Day8_Activity.class);
                                startActivity(intent);
                            }
                           // lock_8.setVisibility(View.GONE);
                          //  tv_text_8.setVisibility(View.VISIBLE);


                        }
                        i = 0;
                    }
                },500);

            }
        });
       btn_day9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (i ==1)
                        {
                            Toast.makeText(MainActivity.this, "please double click...!", Toast.LENGTH_SHORT).show();
                        }
                        else if (i == 2)
                        {
                            if (mInterstitialAd.isLoaded()){
                                mInterstitialAd.show();
                                mInterstitialAd.setAdListener(new AdListener(){
                                    @Override
                                    public void onAdClosed() {
                                        super.onAdClosed();
                                        Intent intent = new Intent(getApplicationContext(), Day9_Activity.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                            else {
                                Intent intent = new Intent(getApplicationContext(), Day9_Activity.class);
                                startActivity(intent);
                            }
                           // lock_9.setVisibility(View.GONE);
                          //  tv_text_9.setVisibility(View.VISIBLE);
                           /* Intent intent = new Intent(getApplicationContext(), Day9_Activity.class);
                            startActivity(intent);*/

                        }
                        i = 0;
                    }
                },500);

            }
        });


        auto_image_slider();


    }

    private void InterTastital_ad() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstial_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
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
    private void auto_image_slider() {
        UltraViewPager ultraViewPager = (UltraViewPager)findViewById(R.id.ultra_viewpager);
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
//initialize UltraPagerAdapter，and add child view to UltraViewPager
        PagerAdapter adapter = new ViewPagerAdapter2(getApplicationContext());
        ultraViewPager.setAdapter(adapter);

//initialize built-in indicator
        ultraViewPager.initIndicator();
//set style of indicators
        ultraViewPager.getIndicator()
                .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                .setFocusColor(Color.GREEN)
                .setNormalColor(Color.WHITE)
                .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics()));
//set the alignment
        ultraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
//construct built-in indicator, and add it to  UltraViewPager
        ultraViewPager.getIndicator().build();

//set an infinite loop
        ultraViewPager.setInfiniteLoop(true);
//enable auto-scroll mode
        ultraViewPager.setAutoScroll(2000);
    }

    private void initToollbar() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        int toolbar_item_color = ResourcesCompat.getColor(getResources(),R.color.blue,null);
        toolbar.setTitleTextColor(toolbar_item_color);
        toolbar.setSubtitleTextColor(toolbar_item_color);
        getSupportActionBar().setTitle("Arm Workout");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
    }

    public void btn_coffe(View view) {

        final   AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.custom_adapter_alerdiyalog,null);


        CardView btn_more_app = mView.findViewById(R.id.btn_more_apps);
        CardView btn_share_apps = mView.findViewById(R.id.btn_share_apps);
        CardView btn_rate_apps = mView.findViewById(R.id.btn_rate_apps);


        alertdialog.setView(mView);
        final  AlertDialog dialog = alertdialog.create();
        dialog.setCanceledOnTouchOutside(true);

        btn_more_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "More  Apps Loading.... ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/developer?id=StarApps.me")));
            }
        });
        btn_share_apps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent localIntent = new Intent("android.intent.action.SEND");
                localIntent.setType("text/plain");
                localIntent.putExtra("android.intent.extra.TEXT", "Enjoy This Apps https://play.google.com/store/apps/details?id="+getPackageName());
                startActivity(Intent.createChooser(localIntent, "Share This App Using"));
            }
        });
        btn_rate_apps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Rate This App", Toast.LENGTH_SHORT).show();
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));            }
        });

        dialog.show();

    }
}
