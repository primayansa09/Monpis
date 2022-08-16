package com.example.monpiss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ActivityAbout extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mAbout, mTelepon;
    private ImageView btnBack;
    private AlphaAnimation animButton = new AlphaAnimation(1F, 0.8F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Bantuan");
        }

        mAbout = findViewById(R.id.btn_email);
        mTelepon = findViewById(R.id.btn_telepon);
        btnBack = findViewById(R.id.back_about);
        btnBack.setOnClickListener(this);
        mAbout.setOnClickListener(this);
        mTelepon.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_email:
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("message/rfc822");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"ojljaringankanwil1@gmail.com"});
                startActivity(Intent.createChooser(email, "Send Email"));
                mAbout.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_item));
                break;
            case R.id.btn_telepon:
                String noTlp = "0213840802";
                Intent dialPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + noTlp));
                startActivity(dialPhone);
                mTelepon.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_item));
                break;
            case R.id.back_about:
                ActivityAbout.this.finish();
                v.startAnimation(animButton);
                break;
        }

    }
}