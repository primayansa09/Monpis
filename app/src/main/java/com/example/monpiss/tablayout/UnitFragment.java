package com.example.monpiss.tablayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.UserManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.monpiss.R;
import com.example.monpiss.Unit.DataUnit;
import com.example.monpiss.Unit.Unit;
import com.example.monpiss.Unit.UnitAdapter;

import java.util.ArrayList;
import java.util.List;


public class UnitFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_UNIT = "unit";

    // TODO: Rename and change types of parameters
    private String mUnit;

    public UnitFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static UnitFragment newInstance(String unit) {
        UnitFragment fragment = new UnitFragment();
        Bundle args = new Bundle();
        args.putString(ARG_UNIT, unit);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            mUnit = getArguments().getString(ARG_UNIT);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_unit, container, false);

        return view;
    }





}