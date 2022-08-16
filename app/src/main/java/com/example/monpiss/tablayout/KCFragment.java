package com.example.monpiss.tablayout;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.monpiss.KC.KC;
import com.example.monpiss.R;
import java.util.List;

public class KCFragment extends Fragment {

    private static final String ARG_KC = "kc";

    private String mKC;
    private RecyclerView rvKC;
    public List<KC> listkc ;

    public KCFragment() {
        // Required empty public constructor
    }

    public static KCFragment newInstance(String kc) {
        KCFragment fragment = new KCFragment();
        Bundle args = new Bundle();
        args.putString(ARG_KC, kc);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mKC = getArguments().getString(ARG_KC);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kc, container, false);

        return view;
    }
}