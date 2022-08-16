package com.example.monpiss.tablayout;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.monpiss.R;


public class KCPFragment extends Fragment {

    private static final String ARG_KCP = "kcp";
    private String mKCP;

    public KCPFragment() {
    }

    public static KCPFragment newInstance(String kcp) {
        KCPFragment fragment = new KCPFragment();
        Bundle args = new Bundle();
        args.putString(ARG_KCP, kcp);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mKCP = getArguments().getString(ARG_KCP);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kcp, container, false);

        return view;
    }
}