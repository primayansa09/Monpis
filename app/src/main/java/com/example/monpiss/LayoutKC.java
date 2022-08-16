package com.example.monpiss;


import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.monpiss.KC.KC;
import com.example.monpiss.KC.KCPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class LayoutKC extends AppCompatActivity implements View.OnClickListener {

    public static final String NAME_KC = "name_kc";
    public TextView textKc;
    private ImageView btnback, imgFile;
    private AlphaAnimation animButton = new AlphaAnimation(1F, 0.8F);

    @StringRes
    private final int[]TAB_TITLE = new int[]{
            R.string.parking,
            R.string.eksterior,
            R.string.kondisi_atm,
            R.string.banking_hall,
            R.string.toilet,
            R.string.ruang_arsip
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_kc);

        btnback = findViewById(R.id.back_kc);
        btnback.setOnClickListener(this);

        KCPagerAdapter kcPagerAdapter = new KCPagerAdapter(this);
        ViewPager2 viewPager2 = findViewById(R.id.viewpager_kc);
        viewPager2.setAdapter(kcPagerAdapter);
        viewPager2.setOffscreenPageLimit(1);
        TabLayout tabLayout = findViewById(R.id.tablayout_kc);
        new TabLayoutMediator(tabLayout, viewPager2,
                ((tab, position) -> tab.setText(getResources().getString(TAB_TITLE[position])))).attach();

         textKc = findViewById(R.id.name_kc);

        KC data = getIntent().getParcelableExtra(NAME_KC);
        String name = data.getKCname();

        textKc.setText(name);
    }

    @Override
    public void onBackPressed() {
        Dialog dialog = new Dialog(LayoutKC.this);
        dialog.setContentView(R.layout.alert_dialog);

        LinearLayout btnIya = dialog.findViewById(R.id.btn_ok);
        LinearLayout btnTidak = dialog.findViewById(R.id.btn_cancel);

        btnIya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutKC.this.finish();
                v.startAnimation(animButton);
            }
        });

        btnTidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                v.startAnimation(animButton);
            }
        });
        dialog.show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_kc:
                showAlertDialog();
                break;
        }
    }

    private void showAlertDialog() {
        Dialog dialog = new Dialog(LayoutKC.this);
        dialog.setContentView(R.layout.alert_dialog);

        LinearLayout btnOk = dialog.findViewById(R.id.btn_ok);
        LinearLayout btnCancel = dialog.findViewById(R.id.btn_cancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutKC.this.finish();
                v.startAnimation(animButton);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                v.startAnimation(animButton);
            }
        });
        dialog.show();
    }
}