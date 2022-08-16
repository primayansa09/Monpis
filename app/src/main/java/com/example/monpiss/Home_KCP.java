package com.example.monpiss;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.EditorInfo;
import com.example.monpiss.KCP.DataKCP;
import com.example.monpiss.KCP.KCP;
import com.example.monpiss.KCP.KCPAdapter;

import java.util.ArrayList;

public class Home_KCP extends AppCompatActivity {
    private RecyclerView rvKCP;
    private KCPAdapter kcpAdapter;
    private AlphaAnimation animButton = new AlphaAnimation(1F, 0.8F);
    private ArrayList<KCP> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_kcp);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("KCP");
        }

        rvKCP = findViewById(R.id.rv_kcp);
        rvKCP.setHasFixedSize(true);

        list.addAll(DataKCP.getListData());
        showListKCP();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu,menu);

        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Nama KCP");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                kcpAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void showListKCP() {
        rvKCP.setLayoutManager(new LinearLayoutManager(this));
        kcpAdapter = new KCPAdapter(list);
        rvKCP.setAdapter(kcpAdapter);
    }

}