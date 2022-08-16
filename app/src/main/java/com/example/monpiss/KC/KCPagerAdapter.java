package com.example.monpiss.KC;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class KCPagerAdapter extends FragmentStateAdapter {
    public KCPagerAdapter(AppCompatActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new ParkirFragment();
                break;
            case 1:
                fragment = new EksteriorFragment();
                break;
            case 2:
                fragment = new ATMFragment();
                break;
            case 3:
                fragment = new BankingHallFragment();
                break;
            case 4:
                fragment = new ToiletFragment();
                break;
            case 5:
                fragment = new ArsipPantryKerjaFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
