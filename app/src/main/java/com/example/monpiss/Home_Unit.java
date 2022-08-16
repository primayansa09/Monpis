package com.example.monpiss;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;

import com.example.monpiss.Unit.DataUnit;
import com.example.monpiss.Unit.Unit;
import com.example.monpiss.Unit.UnitAdapter;

import java.util.ArrayList;

public class Home_Unit extends AppCompatActivity {
    private RecyclerView rvUnit;
    private UnitAdapter unitAdapter;
    private ArrayList<Unit> list = new ArrayList<>();
    private AlphaAnimation animButton = new AlphaAnimation(1F, 0.8F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_unit);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Unit");
        }

        rvUnit = findViewById(R.id.rv_unit);
        rvUnit.setHasFixedSize(true);

        list.addAll(DataUnit.getListData());
        showListUnit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);

        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Nama Unit");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                unitAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void showListUnit() {
        rvUnit.setLayoutManager(new LinearLayoutManager(this));
        unitAdapter = new UnitAdapter(list);
        rvUnit.setAdapter(unitAdapter);
    }
}