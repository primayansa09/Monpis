package com.example.monpiss;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.monpiss.KCP.KCP;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class LayoutKCP extends AppCompatActivity implements View.OnClickListener {

    public static final String NAME_KCP = "name_kcp";
    private AlphaAnimation animation = new AlphaAnimation(1F, 0.8F);
    private ImageView btnBack;

    @StringRes
    private final int[] TAB_TITLE = new int[]{
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
        setContentView(R.layout.activity_layout_kcp);

        btnBack = findViewById(R.id.back_kcp);
        btnBack.setOnClickListener(this);

        KCPPagerAdapter kcpPagerAdapter = new KCPPagerAdapter(this);
        ViewPager2 viewPager2 = findViewById(R.id.viewpager_kcp);
        viewPager2.setOffscreenPageLimit(1);
        viewPager2.setAdapter(kcpPagerAdapter);
        TabLayout tabLayout = findViewById(R.id.tablayout_kcp);
        new TabLayoutMediator(tabLayout, viewPager2,
                ((tab, position) -> tab.setText(getResources().getString(TAB_TITLE[position])))).attach();

        TextView textKCP = findViewById(R.id.name_kcp);

        KCP text = getIntent().getParcelableExtra(NAME_KCP);
        String name = text.getNameKCP();

        textKCP.setText(name);
    }

    @Override
    public void onBackPressed() {
        Dialog dialog = new Dialog(LayoutKCP.this);
        dialog.setContentView(R.layout.alert_dialog);

        LinearLayout btnOk = dialog.findViewById(R.id.btn_ok);
        LinearLayout btnCancel = dialog.findViewById(R.id.btn_cancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutKCP.this.finish();
                v.startAnimation(animation);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                v.startAnimation(animation);
            }
        });
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_kcp:
                showAlertDialog();
                break;
        }
    }

    private void showAlertDialog() {
        Dialog dialog = new Dialog(LayoutKCP.this);
        dialog.setContentView(R.layout.alert_dialog);

        LinearLayout btnOk = dialog.findViewById(R.id.btn_ok);
        LinearLayout btnCancel = dialog.findViewById(R.id.btn_cancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutKCP.this.finish();
                v.startAnimation(animation);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                v.startAnimation(animation);
            }
        });

        dialog.show();
    }
}