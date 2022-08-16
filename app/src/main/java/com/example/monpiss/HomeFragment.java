package com.example.monpiss;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import com.example.monpiss.KC.Home_KC;


public class HomeFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private AlphaAnimation animButton = new AlphaAnimation(1F, 0.8F);
    private LinearLayout mbtnKC, mbtnKCP, mbtnUnit;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mbtnKC = view.findViewById(R.id.btn_kc);
        mbtnKCP = view.findViewById(R.id.btn_kcp);
        mbtnUnit = view.findViewById(R.id.btn_unit);

        mbtnKC.setOnClickListener(this);
        mbtnKCP.setOnClickListener(this);
        mbtnUnit.setOnClickListener(this);

        return  view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_kc:
                Intent mKC = new Intent(getActivity(), Home_KC.class);
                v.startAnimation(animButton);
                startActivity(mKC);
                break;
            case R.id.btn_kcp:
                Intent mKCP = new Intent(getActivity(), Home_KCP.class);
                v.startAnimation(animButton);
                startActivity(mKCP);
                break;
            case R.id.btn_unit:
                Intent mUnit = new Intent(getActivity(), Home_Unit.class);
                v.startAnimation(animButton);
                startActivity(mUnit);
                break;
        }
    }
}