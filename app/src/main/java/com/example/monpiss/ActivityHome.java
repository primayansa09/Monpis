package com.example.monpiss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.monpiss.KC.Home_KC;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ActivityHome extends AppCompatActivity {

    private long backPressedTime;

    public BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        bottomNavigationView = findViewById(R.id.nav_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,
                new HomeFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.profile:
                            selectedFragment = new ProfileFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,
                            selectedFragment).commit();

                    return true;
                }
            };


    //double exit

    @Override
    public void onBackPressed() {
        if (bottomNavigationView.getSelectedItemId()==R.id.home)
        { if (backPressedTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
        }else {
            Toast toast = Toast.makeText(getApplicationContext(), "Tekan lagi untuk keluar", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,0 ,0);
            toast.show();
        }
        backPressedTime = System.currentTimeMillis();

        }else {
            bottomNavigationView.setSelectedItemId(R.id.home);
        }
    }
}