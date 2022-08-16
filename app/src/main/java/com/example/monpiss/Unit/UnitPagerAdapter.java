package com.example.monpiss.Unit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class UnitPagerAdapter extends FragmentStateAdapter {
    public UnitPagerAdapter(AppCompatActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new UnitParkirFragment();
                break;
            case 1:
                fragment = new UnitEksteriorFragment();
                break;
            case 2:
                fragment = new UnitATMFragment();
                break;
            case 3:
                fragment = new UnitBangkingHall();
                break;
            case 4:
                fragment = new UnitToiletFragment();
                break;
            case 5:
                fragment = new UnitKerjaArsipPantry();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
