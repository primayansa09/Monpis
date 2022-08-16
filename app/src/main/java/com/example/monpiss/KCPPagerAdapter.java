package com.example.monpiss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.monpiss.KCP.KCPAtmFragment;
import com.example.monpiss.KCP.KCPBankingHall;
import com.example.monpiss.KCP.KCPEksteriorFragment;
import com.example.monpiss.KCP.KCPKerjaArsipPantry;
import com.example.monpiss.KCP.KCPParkirFragment;
import com.example.monpiss.KCP.KCPToiletFragment;

public class KCPPagerAdapter extends FragmentStateAdapter {
    public KCPPagerAdapter(AppCompatActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int i) {
        Fragment fragment = null;
        switch (i){
            case 0:
                fragment = new KCPParkirFragment();
                break;
            case 1:
                fragment = new KCPEksteriorFragment();
                break;
            case 2:
                fragment = new KCPAtmFragment();
                break;
            case 3:
                fragment = new KCPBankingHall();
                break;
            case 4:
                fragment = new KCPToiletFragment();
                break;
            case 5:
                fragment = new KCPKerjaArsipPantry();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
