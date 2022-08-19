package com.example.anggarisky.stopwatch;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.example.stopwatch.R;

public class MainActivity extends AppCompatActivity {
    TextView tvSplash, tvSubSplash;
    Button btnget;
    Animation atg, btg1, btg2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSplash = findViewById(R.id.tvSplash);
        tvSubSplash = findViewById(R.id.tvSubSplash);
        btnget = findViewById(R.id.btnget);
        ivSplash = findViewById(R.id.ivSplash);


        //load animations
        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        btg1 = AnimationUtils.loadAnimation(this, R.anim.btg1);
        btg2 = AnimationUtils.loadAnimation(this, R.anim.btg2);

        //passing animations
        ivSplash.startAnimation(atg);
        tvSplash.startAnimation(btngone);
        tvSubSplash.startAnimation(btngone);
        btnget.startAnimation(btg2);

        //passing event
        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, StopWatch.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        //import font
        Typeface MLight = Typeface.createFromAsset(getAsset(), "font/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAsset(), "font/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAsset(), "font/MRegular.ttf");

        //custom font
        tvSplash.setTypeface(MRegular);
        tvSubSplash.setTypeface(MLight);
        btnget.setTypeface(MMedium);

    }
}