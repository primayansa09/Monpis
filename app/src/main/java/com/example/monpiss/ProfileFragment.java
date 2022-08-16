package com.example.monpiss;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;


public class ProfileFragment extends Fragment implements View.OnClickListener {

    private AlphaAnimation animButton = new AlphaAnimation(1F, 0.8F);
    SessiionManager sessiionManager;
    private RelativeLayout btnAbout;
    private LinearLayout btnExit;


    public ProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView mFullname = view.findViewById(R.id.tv_fullname);
        TextView mName = view.findViewById(R.id.name);
        TextView mJabatan = view.findViewById(R.id.jabatan);
        TextView mUnitkerja = view.findViewById(R.id.unitkerja);
        TextView mEmail = view.findViewById(R.id.email);
        btnExit = view.findViewById(R.id.exit);
        btnExit.setOnClickListener(this);

        sessiionManager = new SessiionManager(getContext());
        HashMap<String, String> user = sessiionManager.getUserDetails();
        String fullname = user.get(SessiionManager.pref_name);
        String email = user.get(SessiionManager.pref_email);
        String name = user.get(SessiionManager.pref_fullname);
        String jabatan = user.get(SessiionManager.pref_jabatan);
        String unitkerja = user.get(SessiionManager.pref_unitkerja);

        mFullname.setText(fullname);
        mEmail.setText(email);
        mName.setText(name);
        mJabatan.setText(jabatan);
        mUnitkerja.setText(unitkerja);


        btnAbout = view.findViewById(R.id.lyt_about);
        btnAbout.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lyt_about:
                Intent mAbout = new Intent(getContext(), ActivityAbout.class);
                v.startAnimation(animButton);
                startActivity(mAbout);
                break;
            case R.id.exit:
                showAlertDialog();
                v.startAnimation(animButton);
                break;
        }
    }

    private void showAlertDialog() {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.alert_dialog);

        LinearLayout btnIya = dialog.findViewById(R.id.btn_ok);
        LinearLayout btnTidak = dialog.findViewById(R.id.btn_cancel);

        btnIya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessiionManager.logout();
                v.startAnimation(animButton);
                getActivity().finish();
            }
        });

        btnTidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}