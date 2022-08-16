package com.example.monpiss.KC;

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
import com.example.monpiss.R;

import java.util.ArrayList;;

public class Home_KC extends AppCompatActivity {
    private RecyclerView rvKC;
    private KCAdapter kcAdapter;
    private ArrayList<KC> list = new ArrayList<>();
    private AlphaAnimation animButton = new AlphaAnimation(1F, 0.8F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_kc);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("KC");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        rvKC = findViewById(R.id.rv_kc);
        rvKC.setHasFixedSize(true);

        list.addAll(DataKC.getListData());
        showRecyclerList();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);

        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Nama KC");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                kcAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void showRecyclerList() {
        rvKC.setLayoutManager(new LinearLayoutManager(this));
        kcAdapter = new KCAdapter(list);
        rvKC.setAdapter(kcAdapter);
    }

}