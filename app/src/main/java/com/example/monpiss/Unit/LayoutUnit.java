package com.example.monpiss.Unit;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.monpiss.ActivityHome;
import com.example.monpiss.Home_Unit;
import com.example.monpiss.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.prefs.BackingStoreException;

public class LayoutUnit extends AppCompatActivity implements View.OnClickListener {

    public static final String NAME_UNIT = "name_unit";
    private AlphaAnimation animButton = new AlphaAnimation(1F, 0.8F);
    private ImageView btnBack;

    @StringRes
    public static final int[] TAB_TITLE = new int[]{
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
        setContentView(R.layout.activity_layout_unit);

        UnitPagerAdapter unitPagerAdapter = new UnitPagerAdapter(this);
        ViewPager2 viewPager2 = findViewById(R.id.viewpager_unit);
        viewPager2.setAdapter(unitPagerAdapter);
        viewPager2.setOffscreenPageLimit(1);
        TabLayout tabLayout = findViewById(R.id.tablayout_unit);
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText(getResources().getString(TAB_TITLE[position]))).attach();

        TextView nameUnit = findViewById(R.id.name_unit);

        btnBack = findViewById(R.id.back_unit);
        btnBack.setOnClickListener(this);

        Unit text = getIntent().getParcelableExtra(NAME_UNIT);
        String name = text.getNameUnit();

      nameUnit.setText(name);

    }

    @Override
    public void onBackPressed() {

        Dialog dialog = new Dialog(LayoutUnit.this);
        dialog.setContentView(R.layout.alert_dialog);

        LinearLayout btnOk = dialog.findViewById(R.id.btn_ok);
        LinearLayout btnCancel = dialog.findViewById(R.id.btn_cancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutUnit.this.finish();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_unit:
                showAlertDialog();
                break;
        }
    }

    private void showAlertDialog() {
        Dialog dialog = new Dialog(LayoutUnit.this);
        dialog.setContentView(R.layout.alert_dialog);

        LinearLayout btnOk = dialog.findViewById(R.id.btn_ok);
        LinearLayout btnCancel = dialog.findViewById(R.id.btn_cancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutUnit.this.finish();
                v.startAnimation(animButton);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}