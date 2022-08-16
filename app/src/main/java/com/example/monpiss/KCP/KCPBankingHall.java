package com.example.monpiss.KCP;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.monpiss.Database.DbContract;
import com.example.monpiss.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;


public class KCPBankingHall extends Fragment implements View.OnClickListener {

    public static final String KODE_UKER10 = "kode_uker";

    private RadioGroup rdGroup1, rdGroup2, rdGroup3, rdGroup4, rdGroup5, rdGroup6, rdGroup7, rdGroup8, rdGroup9, rdGroup10,
            rdGroup11, rdGroup12, rdGroup13, rdGroup14, rdGroup15, rdGroup16, rdGroup17, rdGroup18, rdGroup19, rdGroup20,
            rdGroup21, rdGroup22, rdGroup23, rdGroup24, rdGroup25, rdGroup26, rdGroup27, rdGroup28, rdGroup29, rdGroup30,
            rdGroup31, rdGroup32, rdGroup33, rdGroup34, rdGroup35, rdGroup36, rdGroup37, rdGroup38, rdGroup39, rdGroup40,
            rdGroup41, rdGroup42, rdGroup43, rdGroup44;

    private RadioButton rdButton1, rdButton2, rdButton3, rdButton4, rdButton5, rdButton6, rdButton7, rdButton8, rdButton9, rdButton10,
            rdButton11, rdButton12, rdButton13, rdButton14, rdButton15, rdButton16, rdButton17, rdButton18, rdButton19, rdButton20, rdButton21,
            rdButton22, rdButton23, rdButton24, rdButton25, rdButton26, rdButton27, rdButton28, rdButton29, rdButton30, rdButton31, rdButton32,
            rdButton33, rdButton34, rdButton35, rdButton36, rdButton37, rdButton38, rdButton39, rdButton40, rdButton41, rdButton42, rdButton43, rdButton44;
    private ProgressDialog progressDialog;
    private Button btnSave;
    private TextView kodeUker;
    private String encodeImageString1, encodeImageString2, encodeImageString3, encodeImageString4, encodeImageString5, encodeImageString6, encodeImageString7, encodeImageString8, encodeImageString9, encodeImageString10,
            encodeImageString11, encodeImageString12, encodeImageString13, encodeImageString14,encodeImageString15, encodeImageString16, encodeImageString17, encodeImageString18, encodeImageString19, encodeImageString20,
            encodeImageString21, encodeImageString22, encodeImageString23, encodeImageString24, encodeImageString25, encodeImageString26, encodeImageString27, encodeImageString28, encodeImageString29, encodeImageString30,
            encodeImageString31, encodeImageString32, encodeImageString33, encodeImageString34, encodeImageString35, encodeImageString36, encodeImageString37, encodeImageString38, encodeImageString39, encodeImageString40,
            encodeImageString41, encodeImageString42, encodeImageString43, encodeImageString44;

    private ImageView cHallKCP1, cHallKCP2, cHallKCP3, cHallKCP4, cHallKCP5, cHallKCP6, cHallKCP7, cHallKCP8, cHallKCP9, cHallKCP10, cHallKCP11, cHallKCP12, cHallKCP13, cHallKCP14, cHallKCP15, cHallKCP16, cHallKCP17,
            cHallKCP18, cHallKCP19, cHallKCP20, cHallKCP21, cHallKCP22, cHallKCP23, cHallKCP24, cHallKCP25, cHallKCP26, cHallKCP27, cHallKCP28, cHallKCP29, cHallKCP30, cHallKCP31, cHallKCP32, cHallKCP33, cHallKCP34, cHallKCP35,
            cHallKCP36, cHallKCP37, cHallKCP38, cHallKCP39, cHallKCP40, cHallKCP41, cHallKCP42, cHallKCP43, cHallKCP44;

    private ImageView imgHallKCp1, imgHallKCp2, imgHallKCp3, imgHallKCp4, imgHallKCp5, imgHallKCp6, imgHallKCp7, imgHallKCp8, imgHallKCp9, imgHallKCp10, imgHallKCp11, imgHallKCp12, imgHallKCp13, imgHallKCp14, imgHallKCp15, imgHallKCp16,
            imgHallKCp17, imgHallKCp18, imgHallKCp19, imgHallKCp20, imgHallKCp21, imgHallKCp22, imgHallKCp23, imgHallKCp24, imgHallKCp25, imgHallKCp26, imgHallKCp27, imgHallKCp28, imgHallKCp29, imgHallKCp30, imgHallKCp31, imgHallKCp32,
            imgHallKCp33, imgHallKCp34, imgHallKCp35, imgHallKCp36, imgHallKCp37, imgHallKCp38, imgHallKCp39, imgHallKCp40, imgHallKCp41, imgHallKCp42, imgHallKCp43, imgHallKCp44;

    private static final int CODE_CAMERA = 0; private static final int CODE_CAMERA21 = 21; private static final int CODE_CAMERA42 = 42;
    private static final int CODE_CAMERA1 = 1; private static final int CODE_CAMERA22 = 22; private static final int CODE_CAMERA43 = 43;
    private static final int CODE_CAMERA2 = 2; private static final int CODE_CAMERA23 = 23;
    private static final int CODE_CAMERA3 = 3; private static final int CODE_CAMERA24 = 24;
    private static final int CODE_CAMERA4 = 4; private static final int CODE_CAMERA25 = 25;
    private static final int CODE_CAMERA5 = 5; private static final int CODE_CAMERA26 = 26;
    private static final int CODE_CAMERA6 = 6; private static final int CODE_CAMERA27 = 27;
    private static final int CODE_CAMERA7 = 7; private static final int CODE_CAMERA28 = 28;
    private static final int CODE_CAMERA8 = 8; private static final int CODE_CAMERA29 = 29;
    private static final int CODE_CAMERA9 = 9; private static final int CODE_CAMERA30 = 30;
    private static final int CODE_CAMERA10 = 10; private static final int CODE_CAMERA31 = 31;
    private static final int CODE_CAMERA11 = 11; private static final int CODE_CAMERA32 = 32;
    private static final int CODE_CAMERA12 = 12; private static final int CODE_CAMERA33 = 33;
    private static final int CODE_CAMERA13 = 13; private static final int CODE_CAMERA34 = 34;
    private static final int CODE_CAMERA14 = 14; private static final int CODE_CAMERA35 = 35;
    private static final int CODE_CAMERA15 = 15; private static final int CODE_CAMERA36 = 36;
    private static final int CODE_CAMERA16 = 16; private static final int CODE_CAMERA37 = 37;
    private static final int CODE_CAMERA17 = 17; private static final int CODE_CAMERA38 = 38;
    private static final int CODE_CAMERA18 = 18; private static final int CODE_CAMERA39 = 39;
    private static final int CODE_CAMERA19 = 19; private static final int CODE_CAMERA40 = 40;
    private static final int CODE_CAMERA20 = 20; private static final int CODE_CAMERA41 = 41;


    public KCPBankingHall() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static KCPBankingHall newInstance(String param1, String param2) {
        KCPBankingHall fragment = new KCPBankingHall();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kcp_banking_hall, container, false);

        btnSave = view.findViewById(R.id.btn_saveHallKCP);
        progressDialog = new ProgressDialog(KCPBankingHall.this.getContext());
        kodeUker = view.findViewById(R.id.name10);
        KCP data = getActivity().getIntent().getParcelableExtra(KODE_UKER10);
        String name = data.getNameKCP();
        kodeUker.setText(name);

        cHallKCP1 = view.findViewById(R.id.camera_hall_kcp1); cHallKCP22 = view.findViewById(R.id.camera_hall_kcp22); cHallKCP43 = view.findViewById(R.id.camera_hall_kcp43);
        cHallKCP2 = view.findViewById(R.id.camera_hall_kcp2); cHallKCP23 = view.findViewById(R.id.camera_hall_kcp23); cHallKCP44 = view.findViewById(R.id.camera_hall_kcp44);
        cHallKCP3 = view.findViewById(R.id.camera_hall_kcp3); cHallKCP24 = view.findViewById(R.id.camera_hall_kcp24);
        cHallKCP4 = view.findViewById(R.id.camera_hall_kcp4); cHallKCP25 = view.findViewById(R.id.camera_hall_kcp25);
        cHallKCP5 = view.findViewById(R.id.camera_hall_kcp5); cHallKCP26 = view.findViewById(R.id.camera_hall_kcp26);
        cHallKCP6 = view.findViewById(R.id.camera_hall_kcp6); cHallKCP27 = view.findViewById(R.id.camera_hall_kcp27);
        cHallKCP7 = view.findViewById(R.id.camera_hall_kcp7); cHallKCP28 = view.findViewById(R.id.camera_hall_kcp28);
        cHallKCP8 = view.findViewById(R.id.camera_hall_kcp8); cHallKCP29 = view.findViewById(R.id.camera_hall_kcp29);
        cHallKCP9 = view.findViewById(R.id.camera_hall_kcp9); cHallKCP30 = view.findViewById(R.id.camera_hall_kcp30);
        cHallKCP10 = view.findViewById(R.id.camera_hall_kcp10); cHallKCP31 = view.findViewById(R.id.camera_hall_kcp31);
        cHallKCP11 = view.findViewById(R.id.camera_hall_kcp11); cHallKCP32 = view.findViewById(R.id.camera_hall_kcp32);
        cHallKCP12 = view.findViewById(R.id.camera_hall_kcp12); cHallKCP33 = view.findViewById(R.id.camera_hall_kcp33);
        cHallKCP13 = view.findViewById(R.id.camera_hall_kcp13); cHallKCP34 = view.findViewById(R.id.camera_hall_kcp34);
        cHallKCP14 = view.findViewById(R.id.camera_hall_kcp14); cHallKCP35 = view.findViewById(R.id.camera_hall_kcp35);
        cHallKCP15 = view.findViewById(R.id.camera_hall_kcp15); cHallKCP36 = view.findViewById(R.id.camera_hall_kcp36);
        cHallKCP16 = view.findViewById(R.id.camera_hall_kcp16); cHallKCP37 = view.findViewById(R.id.camera_hall_kcp37);
        cHallKCP17 = view.findViewById(R.id.camera_hall_kcp17); cHallKCP38 = view.findViewById(R.id.camera_hall_kcp38);
        cHallKCP18 = view.findViewById(R.id.camera_hall_kcp18); cHallKCP39 = view.findViewById(R.id.camera_hall_kcp39);
        cHallKCP19 = view.findViewById(R.id.camera_hall_kcp19); cHallKCP40 = view.findViewById(R.id.camera_hall_kcp40);
        cHallKCP20 = view.findViewById(R.id.camera_hall_kcp20); cHallKCP41 = view.findViewById(R.id.camera_hall_kcp41);
        cHallKCP21 = view.findViewById(R.id.camera_hall_kcp21); cHallKCP42 = view.findViewById(R.id.camera_hall_kcp42);


        imgHallKCp1 = view.findViewById(R.id.img_hall_kcp1); imgHallKCp21 = view.findViewById(R.id.img_hall_kcp21); imgHallKCp41 = view.findViewById(R.id.img_hall_kcp41);
        imgHallKCp2 = view.findViewById(R.id.img_hall_kcp2); imgHallKCp22 = view.findViewById(R.id.img_hall_kcp22); imgHallKCp42 = view.findViewById(R.id.img_hall_kcp42);
        imgHallKCp3 = view.findViewById(R.id.img_hall_kcp3); imgHallKCp23 = view.findViewById(R.id.img_hall_kcp23); imgHallKCp43 = view.findViewById(R.id.img_hall_kcp43);
        imgHallKCp4 = view.findViewById(R.id.img_hall_kcp4); imgHallKCp24 = view.findViewById(R.id.img_hall_kcp24); imgHallKCp44 = view.findViewById(R.id.img_hall_kcp44);
        imgHallKCp5 = view.findViewById(R.id.img_hall_kcp5); imgHallKCp25 = view.findViewById(R.id.img_hall_kcp25);
        imgHallKCp6 = view.findViewById(R.id.img_hall_kcp6); imgHallKCp26 = view.findViewById(R.id.img_hall_kcp26);
        imgHallKCp7 = view.findViewById(R.id.img_hall_kcp7); imgHallKCp27 = view.findViewById(R.id.img_hall_kcp27);
        imgHallKCp8 = view.findViewById(R.id.img_hall_kcp8); imgHallKCp28 = view.findViewById(R.id.img_hall_kcp28);
        imgHallKCp9 = view.findViewById(R.id.img_hall_kcp9); imgHallKCp29 = view.findViewById(R.id.img_hall_kcp29);
        imgHallKCp10 = view.findViewById(R.id.img_hall_kcp10); imgHallKCp30 = view.findViewById(R.id.img_hall_kcp30);
        imgHallKCp11 = view.findViewById(R.id.img_hall_kcp11); imgHallKCp31 = view.findViewById(R.id.img_hall_kcp31);
        imgHallKCp12 = view.findViewById(R.id.img_hall_kcp12); imgHallKCp32 = view.findViewById(R.id.img_hall_kcp32);
        imgHallKCp13 = view.findViewById(R.id.img_hall_kcp13); imgHallKCp33 = view.findViewById(R.id.img_hall_kcp33);
        imgHallKCp14 = view.findViewById(R.id.img_hall_kcp14); imgHallKCp34 = view.findViewById(R.id.img_hall_kcp34);
        imgHallKCp15 = view.findViewById(R.id.img_hall_kcp15); imgHallKCp35 = view.findViewById(R.id.img_hall_kcp35);
        imgHallKCp16 = view.findViewById(R.id.img_hall_kcp16); imgHallKCp36 = view.findViewById(R.id.img_hall_kcp36);
        imgHallKCp17 = view.findViewById(R.id.img_hall_kcp17); imgHallKCp37 = view.findViewById(R.id.img_hall_kcp37);
        imgHallKCp18 = view.findViewById(R.id.img_hall_kcp18); imgHallKCp38 = view.findViewById(R.id.img_hall_kcp38);
        imgHallKCp19 = view.findViewById(R.id.img_hall_kcp19); imgHallKCp39 = view.findViewById(R.id.img_hall_kcp39);
        imgHallKCp20 = view.findViewById(R.id.img_hall_kcp20); imgHallKCp40 = view.findViewById(R.id.img_hall_kcp40);

        rdGroup1 = view.findViewById(R.id.btn_pilihHallKcp1); rdGroup16 = view.findViewById(R.id.btn_pilihHallKcp16);
        rdGroup2 = view.findViewById(R.id.btn_pilihHallKcp2); rdGroup17 = view.findViewById(R.id.btn_pilihHallKcp17);
        rdGroup3 = view.findViewById(R.id.btn_pilihHallKcp3); rdGroup18 = view.findViewById(R.id.btn_pilihHallKcp18);
        rdGroup4 = view.findViewById(R.id.btn_pilihHallKcp4); rdGroup19 = view.findViewById(R.id.btn_pilihHallKcp19);
        rdGroup5 = view.findViewById(R.id.btn_pilihHallKcp5); rdGroup20 = view.findViewById(R.id.btn_pilihHallKcp20);
        rdGroup6 = view.findViewById(R.id.btn_pilihHallKcp6); rdGroup21 = view.findViewById(R.id.btn_pilihHallKcp21);
        rdGroup7 = view.findViewById(R.id.btn_pilihHallKcp7); rdGroup22 = view.findViewById(R.id.btn_pilihHallKcp22);
        rdGroup8 = view.findViewById(R.id.btn_pilihHallKcp8); rdGroup23 = view.findViewById(R.id.btn_pilihHallKcp23);
        rdGroup9 = view.findViewById(R.id.btn_pilihHallKcp9); rdGroup24 = view.findViewById(R.id.btn_pilihHallKcp24);
        rdGroup10 = view.findViewById(R.id.btn_pilihHallKcp10); rdGroup25 = view.findViewById(R.id.btn_pilihHallKcp25);
        rdGroup11 = view.findViewById(R.id.btn_pilihHallKcp11); rdGroup26 = view.findViewById(R.id.btn_pilihHallKcp26);
        rdGroup12 = view.findViewById(R.id.btn_pilihHallKcp12); rdGroup27 = view.findViewById(R.id.btn_pilihHallKcp27);
        rdGroup13 = view.findViewById(R.id.btn_pilihHallKcp13); rdGroup28 = view.findViewById(R.id.btn_pilihHallKcp28);
        rdGroup14 = view.findViewById(R.id.btn_pilihHallKcp14); rdGroup29 = view.findViewById(R.id.btn_pilihHallKcp29);
        rdGroup15 = view.findViewById(R.id.btn_pilihHallKcp15); rdGroup30 = view.findViewById(R.id.btn_pilihHallKcp30);

        rdGroup31 = view.findViewById(R.id.btn_pilihHallKcp31); rdGroup41 = view.findViewById(R.id.btn_pilihHallKcp41);
        rdGroup32 = view.findViewById(R.id.btn_pilihHallKcp32); rdGroup42 = view.findViewById(R.id.btn_pilihHallKcp42);
        rdGroup33 = view.findViewById(R.id.btn_pilihHallKcp33); rdGroup43 = view.findViewById(R.id.btn_pilihHallKcp43);
        rdGroup34 = view.findViewById(R.id.btn_pilihHallKcp34); rdGroup44 = view.findViewById(R.id.btn_pilihHallKcp44);
        rdGroup35 = view.findViewById(R.id.btn_pilihHallKcp35);
        rdGroup35 = view.findViewById(R.id.btn_pilihHallKcp35);
        rdGroup36 = view.findViewById(R.id.btn_pilihHallKcp36);
        rdGroup37 = view.findViewById(R.id.btn_pilihHallKcp37);
        rdGroup38 = view.findViewById(R.id.btn_pilihHallKcp38);
        rdGroup39 = view.findViewById(R.id.btn_pilihHallKcp39);
        rdGroup40 = view.findViewById(R.id.btn_pilihHallKcp40);

        cHallKCP1.setOnClickListener(this); cHallKCP21.setOnClickListener(this); cHallKCP39.setOnClickListener(this);
        cHallKCP2.setOnClickListener(this); cHallKCP22.setOnClickListener(this); cHallKCP40.setOnClickListener(this);
        cHallKCP3.setOnClickListener(this); cHallKCP23.setOnClickListener(this); cHallKCP41.setOnClickListener(this);
        cHallKCP4.setOnClickListener(this); cHallKCP24.setOnClickListener(this); cHallKCP42.setOnClickListener(this);
        cHallKCP5.setOnClickListener(this); cHallKCP25.setOnClickListener(this); cHallKCP43.setOnClickListener(this);
        cHallKCP6.setOnClickListener(this); cHallKCP26.setOnClickListener(this); cHallKCP44.setOnClickListener(this);
        cHallKCP7.setOnClickListener(this); cHallKCP27.setOnClickListener(this); btnSave.setOnClickListener(this);
        cHallKCP8.setOnClickListener(this); cHallKCP28.setOnClickListener(this);
        cHallKCP9.setOnClickListener(this); cHallKCP29.setOnClickListener(this);
        cHallKCP10.setOnClickListener(this); cHallKCP30.setOnClickListener(this);
        cHallKCP11.setOnClickListener(this); cHallKCP31.setOnClickListener(this);
        cHallKCP12.setOnClickListener(this); cHallKCP32.setOnClickListener(this);
        cHallKCP13.setOnClickListener(this); cHallKCP33.setOnClickListener(this);
        cHallKCP14.setOnClickListener(this); cHallKCP32.setOnClickListener(this);
        cHallKCP15.setOnClickListener(this); cHallKCP33.setOnClickListener(this);
        cHallKCP16.setOnClickListener(this); cHallKCP34.setOnClickListener(this);
        cHallKCP17.setOnClickListener(this); cHallKCP35.setOnClickListener(this);
        cHallKCP18.setOnClickListener(this); cHallKCP36.setOnClickListener(this);
        cHallKCP19.setOnClickListener(this); cHallKCP37.setOnClickListener(this);
        cHallKCP20.setOnClickListener(this); cHallKCP38.setOnClickListener(this);

        rdGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton1 = getView().findViewById(checkedId);
            }
        });
        rdGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton2 = getView().findViewById(checkedId);
            }
        });
        rdGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton3 = getView().findViewById(checkedId);
            }
        });
        rdGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton4 = getView().findViewById(checkedId);
            }
        });
        rdGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton5 = getView().findViewById(checkedId);
            }
        });
        rdGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton6 = getView().findViewById(checkedId);
            }
        });
        rdGroup7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton7 = getView().findViewById(checkedId);
            }
        });
        rdGroup8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton8 = getView().findViewById(checkedId);
            }
        });
        rdGroup9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton9 = getView().findViewById(checkedId);
            }
        });
        rdGroup10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton10 = getView().findViewById(checkedId);
            }
        });
        rdGroup11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton11 = getView().findViewById(checkedId);
            }
        });
        rdGroup12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton12 = getView().findViewById(checkedId);
            }
        });
        rdGroup13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton13 = getView().findViewById(checkedId);
            }
        });
        rdGroup14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton14 = getView().findViewById(checkedId);
            }
        });
        rdGroup15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton15 = getView().findViewById(checkedId);
            }
        });
        rdGroup16.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton16 = getView().findViewById(checkedId);
            }
        });
        rdGroup17.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton17 = getView().findViewById(checkedId);
            }
        });
        rdGroup18.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton18 = getView().findViewById(checkedId);
            }
        });
        rdGroup19.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton19 = getView().findViewById(checkedId);
            }
        });
        rdGroup20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton20 = getView().findViewById(checkedId);
            }
        });
        rdGroup21.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton21 = getView().findViewById(checkedId);
            }
        });
        rdGroup22.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton22 = getView().findViewById(checkedId);
            }
        });
        rdGroup23.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton23 = getView().findViewById(checkedId);
            }
        });
        rdGroup24.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton24 = getView().findViewById(checkedId);
            }
        });
        rdGroup25.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton25 = getView().findViewById(checkedId);
            }
        });
        rdGroup26.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton26 = getView().findViewById(checkedId);
            }
        });
        rdGroup27.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton27 = getView().findViewById(checkedId);
            }
        });
        rdGroup28.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton28 = getView().findViewById(checkedId);
            }
        });
        rdGroup29.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton29 = getView().findViewById(checkedId);
            }
        });
        rdGroup30.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton30 = getView().findViewById(checkedId);
            }
        });
        rdGroup31.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton31 = getView().findViewById(checkedId);
            }
        });
        rdGroup32.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton32 = getView().findViewById(checkedId);
            }
        });
        rdGroup33.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton33 = getView().findViewById(checkedId);
            }
        });
        rdGroup34.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton34 = getView().findViewById(checkedId);
            }
        });
        rdGroup35.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton35 = getView().findViewById(checkedId);
            }
        });
        rdGroup36.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton36 = getView().findViewById(checkedId);
            }
        });
        rdGroup36.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton36 = getView().findViewById(checkedId);
            }
        });
        rdGroup37.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton37 = getView().findViewById(checkedId);
            }
        });
        rdGroup38.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton38 = getView().findViewById(checkedId);
            }
        });
        rdGroup39.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton39 = getView().findViewById(checkedId);
            }
        });
        rdGroup40.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton40 = getView().findViewById(checkedId);
            }
        });
        rdGroup41.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton41 = getView().findViewById(checkedId);
            }
        });
        rdGroup42.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton42 = getView().findViewById(checkedId);
            }
        });
        rdGroup43.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton43 = getView().findViewById(checkedId);
            }
        });
        rdGroup44.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton44 = getView().findViewById(checkedId);
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.camera_hall_kcp1:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP1, CODE_CAMERA);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp2:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP2, CODE_CAMERA1);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                    permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp3:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP3, CODE_CAMERA2);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                    permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp4:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP4 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP4, CODE_CAMERA3);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp5:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP5 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP5, CODE_CAMERA4);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp6:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP6 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP6, CODE_CAMERA5);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp7:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP7 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP7, CODE_CAMERA6);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp8:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP8 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP8, CODE_CAMERA7);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp9:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP9 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP9, CODE_CAMERA8);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp10:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP10 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP10, CODE_CAMERA9);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp11:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mHallKCP11 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mHallKCP11, CODE_CAMERA10);
                           }

                           @Override
                           public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                           }

                           @Override
                           public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                           }
                       }).check();
                break;
            case R.id.camera_hall_kcp12:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP12 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP12, CODE_CAMERA11);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp13:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP13 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP13, CODE_CAMERA12);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp14:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP14 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP14, CODE_CAMERA13);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp15:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP15 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP15, CODE_CAMERA14);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp16:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP16 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP16, CODE_CAMERA15);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp17:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP17 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP17, CODE_CAMERA16);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp18:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mHallKCP18 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mHallKCP18, CODE_CAMERA17);
                           }

                           @Override
                           public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                           }

                           @Override
                           public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                           }
                       }).check();
                break;
            case R.id.camera_hall_kcp19:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP19 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP19, CODE_CAMERA18);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp20:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP20 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP20, CODE_CAMERA19);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp21:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP21 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP21, CODE_CAMERA20);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp22:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP22 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP22, CODE_CAMERA21);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp23:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP23 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP23, CODE_CAMERA22);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp24:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP24 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP24, CODE_CAMERA23);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp25:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP25 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP25, CODE_CAMERA24);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp26:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mHallKCP26 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mHallKCP26, CODE_CAMERA25);
                           }

                           @Override
                           public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                           }

                           @Override
                           public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                           }
                       }).check();
                break;
            case R.id.camera_hall_kcp27:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP27 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP27, CODE_CAMERA26);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp28:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP28 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP28, CODE_CAMERA27);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp29:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP29 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP29, CODE_CAMERA28);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp30:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP30 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP30, CODE_CAMERA29);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp31:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP31 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP31, CODE_CAMERA30);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp32:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP32 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP32, CODE_CAMERA31);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp33:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP33 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP33, CODE_CAMERA32);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp34:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP34 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP34, CODE_CAMERA33);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp35:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP35 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP35, CODE_CAMERA34);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp36:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP36 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP36, CODE_CAMERA35);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp37:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP37 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP37, CODE_CAMERA36);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp38:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP38 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP38, CODE_CAMERA37);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp39:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP39 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP39, CODE_CAMERA38);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp40:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP40 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP40, CODE_CAMERA39);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp41:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP41 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP41, CODE_CAMERA40);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp42:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP42 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP42, CODE_CAMERA41);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp43:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP43 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP43, CODE_CAMERA42);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                        permissionToken.continuePermissionRequest();
                            }
                        }).check();
                break;
            case R.id.camera_hall_kcp44:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mHallKCP44 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mHallKCP44, CODE_CAMERA43);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                            }
                        }).check();
                break;
            case R.id.btn_saveHallKCP:
                uploadImage();
                btnSave.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_item));
                break;
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (CODE_CAMERA == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap1 = (Bitmap) data.getExtras().get("data");
            imgHallKCp1.setImageBitmap(bitmap1);
            ImageToString1(getResizeBitmap(bitmap1, 512));
        }

        if (CODE_CAMERA1 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap2 = (Bitmap) data.getExtras().get("data");
            imgHallKCp2.setImageBitmap(bitmap2);
            ImageToString2(getResizeBitmap(bitmap2, 512));
        }

        if (CODE_CAMERA2 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap3 = (Bitmap) data.getExtras().get("data");
            imgHallKCp3.setImageBitmap(bitmap3);
            ImageToString3(getResizeBitmap(bitmap3, 512));
        }

        if (CODE_CAMERA3 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap4 = (Bitmap) data.getExtras().get("data");
            imgHallKCp4.setImageBitmap(bitmap4);
            ImageToString4(getResizeBitmap(bitmap4, 512));
        }

        if (CODE_CAMERA4 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap5 = (Bitmap) data.getExtras().get("data");
            imgHallKCp5.setImageBitmap(bitmap5);
            ImageToString5(getResizeBitmap(bitmap5, 512));
        }

        if (CODE_CAMERA5 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap6 = (Bitmap) data.getExtras().get("data");
            imgHallKCp6.setImageBitmap(bitmap6);
            ImageToString6(getResizeBitmap(bitmap6, 512));
        }

        if (CODE_CAMERA6 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap7 = (Bitmap) data.getExtras().get("data");
            imgHallKCp7.setImageBitmap(bitmap7);
            ImageToString7(getResizeBitmap(bitmap7, 512));
        }

        if (CODE_CAMERA7 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap8 = (Bitmap) data.getExtras().get("data");
            imgHallKCp8.setImageBitmap(bitmap8);
            ImageToString8(getResizeBitmap(bitmap8, 512));
        }

        if (CODE_CAMERA8 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap9 = (Bitmap) data.getExtras().get("data");
            imgHallKCp9.setImageBitmap(bitmap9);
            ImageToString9(getResizeBitmap(bitmap9, 512));
        }

        if (CODE_CAMERA9 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap10 = (Bitmap) data.getExtras().get("data");
            imgHallKCp10.setImageBitmap(bitmap10);
            ImageToString10(getResizeBitmap(bitmap10, 512));
        }

        if (CODE_CAMERA10 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap11 = (Bitmap) data.getExtras().get("data");
            imgHallKCp11.setImageBitmap(bitmap11);
            ImageToString11(getResizeBitmap(bitmap11, 512));
        }

        if (CODE_CAMERA11 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap12 = (Bitmap) data.getExtras().get("data");
            imgHallKCp12.setImageBitmap(bitmap12);
            ImageToString12(getResizeBitmap(bitmap12, 512));
        }

        if (CODE_CAMERA12 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap13 = (Bitmap) data.getExtras().get("data");
            imgHallKCp13.setImageBitmap(bitmap13);
            ImageToString13(getResizeBitmap(bitmap13, 512));
        }

        if (CODE_CAMERA13 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap14 = (Bitmap) data.getExtras().get("data");
            imgHallKCp14.setImageBitmap(bitmap14);
            ImageToString14(getResizeBitmap(bitmap14, 512));
        }

        if (CODE_CAMERA14 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap15 = (Bitmap) data.getExtras().get("data");
            imgHallKCp15.setImageBitmap(bitmap15);
            ImageToString15(getResizeBitmap(bitmap15, 512));
        }

        if (CODE_CAMERA15 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap16 = (Bitmap) data.getExtras().get("data");
            imgHallKCp16.setImageBitmap(bitmap16);
            ImageToString16(getResizeBitmap(bitmap16, 512));
        }

        if (CODE_CAMERA16 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap17 = (Bitmap) data.getExtras().get("data");
            imgHallKCp17.setImageBitmap(bitmap17);
            ImageToString17(getResizeBitmap(bitmap17, 512));
        }

        if (CODE_CAMERA17 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap18 = (Bitmap) data.getExtras().get("data");
            imgHallKCp18.setImageBitmap(bitmap18);
            ImageToString18(getResizeBitmap(bitmap18, 512));
        }

        if (CODE_CAMERA18 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap19 = (Bitmap) data.getExtras().get("data");
            imgHallKCp19.setImageBitmap(bitmap19);
            ImageToString19(getResizeBitmap(bitmap19, 512));
        }

        if (CODE_CAMERA19 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap20 = (Bitmap) data.getExtras().get("data");
            imgHallKCp20.setImageBitmap(bitmap20);
            ImageToString20(getResizeBitmap(bitmap20, 512));
        }

        if (CODE_CAMERA20 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap21 = (Bitmap) data.getExtras().get("data");
            imgHallKCp21.setImageBitmap(bitmap21);
            ImageToString21(getResizeBitmap(bitmap21, 512));
        }

        if (CODE_CAMERA21 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap22 = (Bitmap) data.getExtras().get("data");
            imgHallKCp22.setImageBitmap(bitmap22);
            ImageToString22(getResizeBitmap(bitmap22, 512));
        }

        if (CODE_CAMERA22 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap23 = (Bitmap) data.getExtras().get("data");
            imgHallKCp23.setImageBitmap(bitmap23);
            ImageToString23(getResizeBitmap(bitmap23, 512));
        }

        if (CODE_CAMERA23 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap24 = (Bitmap) data.getExtras().get("data");
            imgHallKCp24.setImageBitmap(bitmap24);
            ImageToString24(getResizeBitmap(bitmap24, 512));
        }

        if (CODE_CAMERA24 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap25 = (Bitmap) data.getExtras().get("data");
            imgHallKCp25.setImageBitmap(bitmap25);
            ImageToString25(getResizeBitmap(bitmap25, 512));
        }

        if (CODE_CAMERA25 == requestCode && resultCode ==Activity.RESULT_OK){
            Bitmap bitmap26 = (Bitmap) data.getExtras().get("data");
            imgHallKCp26.setImageBitmap(bitmap26);
            ImageToString26(getResizeBitmap(bitmap26, 512));
        }

        if (CODE_CAMERA26 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap27 = (Bitmap) data.getExtras().get("data");
            imgHallKCp27.setImageBitmap(bitmap27);
            ImageToString27(getResizeBitmap(bitmap27, 512));
        }

        if (CODE_CAMERA27 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap28 = (Bitmap) data.getExtras().get("data");
            imgHallKCp28.setImageBitmap(bitmap28);
            ImageToString28(getResizeBitmap(bitmap28, 512));
        }

        if (CODE_CAMERA28 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap29 = (Bitmap) data.getExtras().get("data");
            imgHallKCp29.setImageBitmap(bitmap29);
            ImageToString29(getResizeBitmap(bitmap29, 512));
        }

        if (CODE_CAMERA29 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap30 = (Bitmap) data.getExtras().get("data");
            imgHallKCp30.setImageBitmap(bitmap30);
            ImageToString30(getResizeBitmap(bitmap30, 512));
        }

        if (CODE_CAMERA30 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap31 = (Bitmap) data.getExtras().get("data");
            imgHallKCp31.setImageBitmap(bitmap31);
            ImageToString31(getResizeBitmap(bitmap31, 512));
        }

        if (CODE_CAMERA31 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap32 = (Bitmap) data.getExtras().get("data");
            imgHallKCp32.setImageBitmap(bitmap32);
            ImageToString32(getResizeBitmap(bitmap32, 512));
        }

        if (CODE_CAMERA32 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap33 = (Bitmap) data.getExtras().get("data");
            imgHallKCp33.setImageBitmap(bitmap33);
            ImageToString33(getResizeBitmap(bitmap33, 512));
        }

        if (CODE_CAMERA33 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap34 = (Bitmap) data.getExtras().get("data");
            imgHallKCp34.setImageBitmap(bitmap34);
            ImageToString34(getResizeBitmap(bitmap34, 512));
        }

        if (CODE_CAMERA34 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap35 = (Bitmap) data.getExtras().get("data");
            imgHallKCp35.setImageBitmap(bitmap35);
            ImageToString35(getResizeBitmap(bitmap35, 512));
        }

        if (CODE_CAMERA35 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap36 = (Bitmap) data.getExtras().get("data");
            imgHallKCp36.setImageBitmap(bitmap36);
            ImageToString36(getResizeBitmap(bitmap36, 512));
        }

        if (CODE_CAMERA36 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap37 = (Bitmap) data.getExtras().get("data");
            imgHallKCp37.setImageBitmap(bitmap37);
            ImageToString37(getResizeBitmap(bitmap37, 512));
        }

        if (CODE_CAMERA37 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap38 = (Bitmap) data.getExtras().get("data");
            imgHallKCp38.setImageBitmap(bitmap38);
            ImageToString38(getResizeBitmap(bitmap38, 512));
        }

        if (CODE_CAMERA38 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap39 = (Bitmap) data.getExtras().get("data");
            imgHallKCp39.setImageBitmap(bitmap39);
            ImageToString39(getResizeBitmap(bitmap39, 512));
        }

        if (CODE_CAMERA39 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap40 = (Bitmap) data.getExtras().get("data");
            imgHallKCp40.setImageBitmap(bitmap40);
            ImageToString40(getResizeBitmap(bitmap40, 512));
        }

        if (CODE_CAMERA40 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap41 = (Bitmap) data.getExtras().get("data");
            imgHallKCp41.setImageBitmap(bitmap41);
            ImageToString41(getResizeBitmap(bitmap41, 512));
        }

        if (CODE_CAMERA41 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap42 = (Bitmap) data.getExtras().get("data");
            imgHallKCp42.setImageBitmap(bitmap42);
            ImageToString42(getResizeBitmap(bitmap42, 512));
        }

        if (CODE_CAMERA42 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap43 = (Bitmap) data.getExtras().get("data");
            imgHallKCp43.setImageBitmap(bitmap43);
            ImageToString43(getResizeBitmap(bitmap43, 512));
        }

        if (CODE_CAMERA43 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap44 = (Bitmap) data.getExtras().get("data");
            imgHallKCp44.setImageBitmap(bitmap44);
            ImageToString44(getResizeBitmap(bitmap44, 512));
        }
    }

    private Bitmap getResizeBitmap(Bitmap image, int maxSize){
        int width = image.getWidth();
        int hegiht = image.getHeight();

        float bitmapRotasi = (float) width / (float) hegiht;
        if (bitmapRotasi > 1){
            width = maxSize;
            hegiht = (int) (width / bitmapRotasi);
        }else {
            hegiht = maxSize;
            width = (int) (hegiht * bitmapRotasi);
        }

        return Bitmap.createScaledBitmap(image, width, hegiht, true);
    }

    private void ImageToString1(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString1 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString2(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString2 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString3(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString3 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString4(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString4 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString5(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString5 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString6(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString6 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString7(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString7 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString8(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString8 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString9(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString9 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString10(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString10 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString11(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString11 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString12(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString12 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString13(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString13 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString14(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString14 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString15(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString15 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString16(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString16 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString17(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString17 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString18(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString18 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString19(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString19 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString20(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString20 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString21(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString21 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString22(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString22 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString23(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString23 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString24(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString24 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString25(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString25 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString26(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString26 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString27(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString27 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString28(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString28 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString29(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString29 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString30(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString30 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString31(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString31 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString32(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString32 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString33(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString33 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString34(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString34 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString35(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString35 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString36(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString36 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString37(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString37 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString38(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString38 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString39(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString39 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString40(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString40 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString41(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString41 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString42(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString42 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString43(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString43 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString44(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString44 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }


    private void uploadImage(){
        if (CheckNetworkConnection()){
            progressDialog.show();
            progressDialog.setMessage("Loading...");
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_IMAGE_BANKING_KCP_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            imgHallKCp1.setImageResource(R.drawable.ic_check); imgHallKCp21.setImageResource(R.drawable.ic_check); imgHallKCp40.setImageResource(R.drawable.ic_check);
                            imgHallKCp2.setImageResource(R.drawable.ic_check); imgHallKCp22.setImageResource(R.drawable.ic_check); imgHallKCp41.setImageResource(R.drawable.ic_check);
                            imgHallKCp3.setImageResource(R.drawable.ic_check); imgHallKCp23.setImageResource(R.drawable.ic_check); imgHallKCp42.setImageResource(R.drawable.ic_check);
                            imgHallKCp4.setImageResource(R.drawable.ic_check); imgHallKCp24.setImageResource(R.drawable.ic_check); imgHallKCp43.setImageResource(R.drawable.ic_check);
                            imgHallKCp5.setImageResource(R.drawable.ic_check); imgHallKCp25.setImageResource(R.drawable.ic_check); imgHallKCp44.setImageResource(R.drawable.ic_check);
                            imgHallKCp6.setImageResource(R.drawable.ic_check); imgHallKCp26.setImageResource(R.drawable.ic_check);
                            imgHallKCp7.setImageResource(R.drawable.ic_check); imgHallKCp27.setImageResource(R.drawable.ic_check);
                            imgHallKCp8.setImageResource(R.drawable.ic_check); imgHallKCp28.setImageResource(R.drawable.ic_check);
                            imgHallKCp9.setImageResource(R.drawable.ic_check); imgHallKCp29.setImageResource(R.drawable.ic_check);
                            imgHallKCp10.setImageResource(R.drawable.ic_check); imgHallKCp30.setImageResource(R.drawable.ic_check);
                            imgHallKCp11.setImageResource(R.drawable.ic_check); imgHallKCp31.setImageResource(R.drawable.ic_check);
                            imgHallKCp12.setImageResource(R.drawable.ic_check); imgHallKCp32.setImageResource(R.drawable.ic_check);
                            imgHallKCp13.setImageResource(R.drawable.ic_check); imgHallKCp32.setImageResource(R.drawable.ic_check);
                            imgHallKCp14.setImageResource(R.drawable.ic_check); imgHallKCp33.setImageResource(R.drawable.ic_check);
                            imgHallKCp15.setImageResource(R.drawable.ic_check); imgHallKCp34.setImageResource(R.drawable.ic_check);
                            imgHallKCp16.setImageResource(R.drawable.ic_check); imgHallKCp35.setImageResource(R.drawable.ic_check);
                            imgHallKCp17.setImageResource(R.drawable.ic_check); imgHallKCp36.setImageResource(R.drawable.ic_check);
                            imgHallKCp18.setImageResource(R.drawable.ic_check); imgHallKCp37.setImageResource(R.drawable.ic_check);
                            imgHallKCp19.setImageResource(R.drawable.ic_check); imgHallKCp38.setImageResource(R.drawable.ic_check);
                            imgHallKCp20.setImageResource(R.drawable.ic_check); imgHallKCp39.setImageResource(R.drawable.ic_check);

                            rdButton1.setChecked(false); rdButton16.setChecked(false); rdButton32.setChecked(false);
                            rdButton2.setChecked(false); rdButton17.setChecked(false); rdButton33.setChecked(false);
                            rdButton3.setChecked(false); rdButton18.setChecked(false); rdButton34.setChecked(false);
                            rdButton4.setChecked(false); rdButton19.setChecked(false); rdButton35.setChecked(false);
                            rdButton5.setChecked(false); rdButton20.setChecked(false); rdButton36.setChecked(false);
                            rdButton5.setChecked(false); rdButton21.setChecked(false); rdButton37.setChecked(false);
                            rdButton6.setChecked(false); rdButton22.setChecked(false); rdButton38.setChecked(false);
                            rdButton7.setChecked(false); rdButton23.setChecked(false); rdButton39.setChecked(false);
                            rdButton8.setChecked(false); rdButton24.setChecked(false); rdButton40.setChecked(false);
                            rdButton9.setChecked(false); rdButton25.setChecked(false); rdButton41.setChecked(false);
                            rdButton10.setChecked(false); rdButton26.setChecked(false); rdButton42.setChecked(false);
                            rdButton11.setChecked(false); rdButton27.setChecked(false); rdButton43.setChecked(false);
                            rdButton12.setChecked(false); rdButton28.setChecked(false); rdButton44.setChecked(false);
                            rdButton13.setChecked(false); rdButton29.setChecked(false);
                            rdButton14.setChecked(false); rdButton30.setChecked(false);
                            rdButton15.setChecked(false); rdButton31.setChecked(false);
                            kodeUker.setText("");
                            Toast toast = Toast.makeText(getContext(), "Upload sukses", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,0,0);
                            toast.show();

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    if (encodeImageString1 != null){
                        params.put("upload1", encodeImageString1);
                    }else {
                        params.put("", encodeImageString1);
                    }

                    if (encodeImageString2 != null){
                        params.put("upload2", encodeImageString2);
                    }else{
                        params.put("", encodeImageString2);
                    }

                    if (encodeImageString3 != null){
                        params.put("upload3", encodeImageString3);
                    }else{
                        params.put("", encodeImageString3);
                    }

                    if (encodeImageString4 != null){
                        params.put("upload4", encodeImageString4);
                    }else {
                        params.put("", encodeImageString4);
                    }

                    if (encodeImageString5 != null){
                        params.put("upload5", encodeImageString5);
                    }else {
                        params.put("", encodeImageString5);
                    }

                    if (encodeImageString6 != null){
                        params.put("upload6", encodeImageString6);
                    }else {
                        params.put("", encodeImageString6);
                    }

                    if (encodeImageString7 != null){
                        params.put("upload7", encodeImageString7);
                    }else {
                        params.put("", encodeImageString7);
                    }

                    if (encodeImageString8 != null){
                        params.put("upload8", encodeImageString8);
                    }else {
                        params.put("", encodeImageString8);
                    }

                    if (encodeImageString9 != null){
                        params.put("upload9", encodeImageString9);
                    }else{
                        params.put("", encodeImageString9);
                    }

                    if (encodeImageString10 != null){
                        params.put("upload10", encodeImageString10);
                    }else {
                        params.put("", encodeImageString10);
                    }

                    if (encodeImageString11 != null){
                        params.put("upload11", encodeImageString11);
                    }else {
                        params.put("", encodeImageString11);
                    }

                    if (encodeImageString12 != null){
                        params.put("upload12", encodeImageString12);
                    }else {
                        params.put("", encodeImageString12);
                    }

                    if (encodeImageString13 != null){
                        params.put("upload13", encodeImageString13);
                    }else{
                        params.put("", encodeImageString13);
                    }

                    if (encodeImageString14 != null){
                        params.put("upload14", encodeImageString14);
                    }else {
                        params.put("", encodeImageString14);
                    }

                    if (encodeImageString15 != null){
                        params.put("upload15", encodeImageString15);
                    }else {
                        params.put("", encodeImageString15);
                    }

                    if (encodeImageString16 != null){
                        params.put("upload16", encodeImageString16);
                    }else {
                        params.put("", encodeImageString16);
                    }

                    if (encodeImageString17 != null){
                        params.put("upload17", encodeImageString17);
                    }else {
                        params.put("", encodeImageString17);
                    }

                    if (encodeImageString18 != null){
                        params.put("upload18", encodeImageString18);
                    }else {
                        params.put("", encodeImageString18);
                    }

                    if (encodeImageString19 != null){
                        params.put("upload19", encodeImageString19);
                    }else {
                        params.put("", encodeImageString19);
                    }

                    if (encodeImageString20 != null){
                        params.put("upload20", encodeImageString20);
                    }else {
                        params.put("", encodeImageString20);
                    }

                    if (encodeImageString21 != null){
                        params.put("upload21", encodeImageString21);
                    }else {
                        params.put("", encodeImageString21);
                    }

                    if (encodeImageString22 != null){
                        params.put("upload22", encodeImageString22);
                    }else {
                        params.put("", encodeImageString22);
                    }

                    if (encodeImageString23 != null){
                        params.put("upload23", encodeImageString23);
                    }else{
                        params.put("", encodeImageString23);
                    }

                    if (encodeImageString24 != null){
                        params.put("upload24", encodeImageString24);
                    }else {
                        params.put("", encodeImageString24);
                    }

                    if (encodeImageString25 != null){
                        params.put("upload25", encodeImageString25);
                    }else {
                        params.put("", encodeImageString26);
                    }

                    if (encodeImageString26 != null){
                        params.put("upload26", encodeImageString26);
                    }else {
                        params.put("", encodeImageString26);
                    }

                    if (encodeImageString27 != null){
                        params.put("upload27", encodeImageString27);
                    }else {
                        params.put("", encodeImageString27);
                    }

                    if (encodeImageString28 != null){
                        params.put("upload28", encodeImageString28);
                    }else {
                        params.put("", encodeImageString28);
                    }

                    if (encodeImageString29 != null){
                        params.put("upload29", encodeImageString29);
                    }else {
                        params.put("", encodeImageString29);
                    }

                    if (encodeImageString30 != null){
                        params.put("upload30", encodeImageString30);
                    }else {
                        params.put("", encodeImageString30);
                    }

                    if (encodeImageString31 != null){
                        params.put("upload31", encodeImageString31);
                    }else {
                        params.put("", encodeImageString31);
                    }

                    if (encodeImageString32 != null){
                        params.put("upload32", encodeImageString32);
                    }else {
                        params.put("", encodeImageString32);
                    }

                    if (encodeImageString33 != null){
                        params.put("upload33", encodeImageString33);
                    }else {
                        params.put("", encodeImageString33);
                    }

                    if (encodeImageString34 != null){
                        params.put("upload34", encodeImageString34);
                    }else {
                        params.put("", encodeImageString34);
                    }

                    if (encodeImageString35 != null){
                        params.put("upload35", encodeImageString35);
                    }else {
                        params.put("", encodeImageString35);
                    }

                    if (encodeImageString36 != null){
                        params.put("upload36", encodeImageString36);
                    }else{
                        params.put("", encodeImageString36);
                    }

                    if (encodeImageString37 != null){
                        params.put("upload37", encodeImageString37);
                    }else {
                        params.put("", encodeImageString37);
                    }

                    if (encodeImageString38 != null){
                        params.put("upload38", encodeImageString38);
                    }else {
                        params.put("", encodeImageString38);
                    }

                    if (encodeImageString39 != null){
                        params.put("upload39", encodeImageString39);
                    }else {
                        params.put("", encodeImageString39);
                    }

                    if (encodeImageString40 != null){
                        params.put("upload40", encodeImageString40);
                    }else {
                        params.put("", encodeImageString40);
                    }

                    if (encodeImageString41 != null){
                        params.put("upload41", encodeImageString41);
                    }else {
                        params.put("", encodeImageString41);
                    }

                    if (encodeImageString42 != null){
                        params.put("upload42", encodeImageString42);
                    }else{
                        params.put("", encodeImageString42);
                    }

                    if (encodeImageString43 != null){
                        params.put("upload43", encodeImageString43);
                    }else {
                        params.put("", encodeImageString43);
                    }

                    if (encodeImageString44 != null){
                        params.put("upload44", encodeImageString44);
                    }else {
                        params.put("", encodeImageString44);
                    }

                    if (rdButton1 != null){
                        params.put("stnd1", rdButton1.getText().toString());
                    }else {
                        params.put("", rdButton1.toString());
                    }
                    if (rdButton2 != null){
                        params.put("stnd2", rdButton2.getText().toString());
                    }else {
                        params.put("", rdButton2.toString());
                    }
                    if (rdButton3 != null){
                        params.put("stnd3", rdButton3.getText().toString());
                    }else {
                        params.put("", rdButton3.toString());
                    }
                    if (rdButton4 != null){
                        params.put("stnd4", rdButton4.getText().toString());
                    }else {
                        params.put("", rdButton4.toString());
                    }
                    if (rdButton5 != null){
                        params.put("stnd5", rdButton5.getText().toString());
                    }else {
                        params.put("", rdButton5.toString());
                    }
                    if (rdButton6 != null){
                        params.put("stnd6", rdButton6.getText().toString());
                    }else {
                        params.put("", rdButton6.toString());
                    }
                    if (rdButton7 != null){
                        params.put("stnd7", rdButton7.getText().toString());
                    }else {
                        params.put("", rdButton7.toString());
                    }
                    if (rdButton8 != null){
                        params.put("stnd8", rdButton8.getText().toString());
                    }else {
                        params.put("", rdButton8.toString());
                    }
                    if (rdButton9 != null){
                        params.put("stnd9", rdButton9.getText().toString());
                    }else {
                        params.put("", rdButton9.toString());
                    }
                    if (rdButton10 != null){
                        params.put("stnd10", rdButton10.getText().toString());
                    }else {
                        params.put("", rdButton10.toString());
                    }
                    if (rdButton11 != null){
                        params.put("stnd11", rdButton11.getText().toString());
                    }else {
                        params.put("", rdButton11.toString());
                    }
                    if (rdButton12 != null){
                        params.put("stnd12", rdButton12.getText().toString());
                    }else {
                        params.put("", rdButton12.toString());
                    }
                    if (rdButton13 != null){
                        params.put("stnd13", rdButton13.getText().toString());
                    }else {
                        params.put("", rdButton13.toString());
                    }
                    if (rdButton14 != null){
                        params.put("stnd14", rdButton14.getText().toString());
                    }else {
                        params.put("", rdButton14.toString());
                    }
                    if (rdButton15 != null){
                        params.put("stnd15", rdButton15.getText().toString());
                    }else {
                        params.put("", rdButton15.toString());
                    }
                    if (rdButton16 != null){
                        params.put("stnd16", rdButton16.getText().toString());
                    }else {
                        params.put("", rdButton16.toString());
                    }
                    if (rdButton17 != null){
                        params.put("stnd17", rdButton17.getText().toString());
                    }else {
                        params.put("", rdButton17.toString());
                    }
                    if (rdButton18 != null){
                        params.put("stnd18", rdButton18.getText().toString());
                    }else {
                        params.put("", rdButton18.toString());
                    }
                    if (rdButton19 != null){
                        params.put("stnd19", rdButton19.getText().toString());
                    }else {
                        params.put("", rdButton19.toString());
                    }
                    if (rdButton20 != null){
                        params.put("stnd20", rdButton20.getText().toString());
                    }else {
                        params.put("", rdButton20.toString());
                    }
                    if (rdButton21 != null){
                        params.put("stnd21", rdButton21.getText().toString());
                    }else {
                        params.put("", rdButton21.toString());
                    }
                    if (rdButton22 != null){
                        params.put("stnd22", rdButton22.getText().toString());
                    }else {
                        params.put("", rdButton22.toString());
                    }
                    if (rdButton23 != null){
                        params.put("stnd23", rdButton23.getText().toString());
                    }else {
                        params.put("", rdButton23.toString());
                    }
                    if (rdButton24 != null){
                        params.put("stnd24", rdButton24.getText().toString());
                    }else {
                        params.put("", rdButton24.toString());
                    }
                    if (rdButton25 != null){
                        params.put("stnd25", rdButton25.getText().toString());
                    }else {
                        params.put("", rdButton25.toString());
                    }
                    if (rdButton26 != null){
                        params.put("stnd26", rdButton26.getText().toString());
                    }else {
                        params.put("", rdButton26.toString());
                    }
                    if (rdButton27 != null){
                        params.put("stnd27", rdButton27.getText().toString());
                    }else {
                        params.put("", rdButton27.toString());
                    }
                    if (rdButton28 != null){
                        params.put("stnd28", rdButton28.getText().toString());
                    }else {
                        params.put("", rdButton28.toString());
                    }
                    if (rdButton29 != null){
                        params.put("stnd29", rdButton29.getText().toString());
                    }else {
                        params.put("", rdButton29.toString());
                    }
                    if (rdButton30 != null){
                        params.put("stnd30", rdButton30.getText().toString());
                    }else {
                        params.put("", rdButton30.toString());
                    }
                    if (rdButton31 != null){
                        params.put("stnd31", rdButton31.getText().toString());
                    }else {
                        params.put("", rdButton31.toString());
                    }
                    if (rdButton32 != null){
                        params.put("stnd32", rdButton32.getText().toString());
                    }else {
                        params.put("", rdButton32.toString());
                    }
                    if (rdButton33 != null){
                        params.put("stnd33", rdButton33.getText().toString());
                    }else {
                        params.put("", rdButton33.toString());
                    }
                    if (rdButton34 != null){
                        params.put("stnd34", rdButton34.getText().toString());
                    }else {
                        params.put("", rdButton34.toString());
                    }
                    if (rdButton35 != null){
                        params.put("stnd35", rdButton35.getText().toString());
                    }else {
                        params.put("", rdButton35.toString());
                    }
                    if (rdButton36 != null){
                        params.put("stnd36", rdButton36.getText().toString());
                    }else {
                        params.put("", rdButton36.toString());
                    }
                    if (rdButton37 != null){
                        params.put("stnd37", rdButton37.getText().toString());
                    }else {
                        params.put("", rdButton37.toString());
                    }
                    if (rdButton38 != null){
                        params.put("stnd38", rdButton38.getText().toString());
                    }else {
                        params.put("", rdButton38.toString());
                    }
                    if (rdButton39 != null){
                        params.put("stnd39", rdButton39.getText().toString());
                    }else {
                        params.put("", rdButton39.toString());
                    }
                    if (rdButton40 != null){
                        params.put("stnd40", rdButton40.getText().toString());
                    }else {
                        params.put("", rdButton40.toString());
                    }
                    if (rdButton41 != null){
                        params.put("stnd41", rdButton41.getText().toString());
                    }else {
                        params.put("", rdButton41.toString());
                    }
                    if (rdButton42 != null){
                        params.put("stnd42", rdButton42.getText().toString());
                    }else {
                        params.put("", rdButton42.toString());
                    }
                    if (rdButton43 != null){
                        params.put("stnd43", rdButton43.getText().toString());
                    }else {
                        params.put("", rdButton43.toString());
                    }
                    if (rdButton44 != null){
                        params.put("stnd44", rdButton44.getText().toString());
                    }else {
                        params.put("", rdButton44.toString());
                    }
                    params.put("kode", kodeUker.getText().toString());
                    return params;
                }
            };
            RequestQueue queue = Volley.newRequestQueue(getContext().getApplicationContext());
            queue.add(stringRequest);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressDialog.cancel();
                    if (encodeImageString1 == null || encodeImageString2 == null || encodeImageString3 == null || encodeImageString4 == null || encodeImageString5 == null || encodeImageString6 == null ||
                    encodeImageString7 == null || encodeImageString8 == null || encodeImageString9 == null || encodeImageString10 == null || encodeImageString11 == null || encodeImageString12 == null ||
                    encodeImageString13 == null || encodeImageString14 == null || encodeImageString15 == null || encodeImageString16 == null || encodeImageString17 == null || encodeImageString18 == null ||
                    encodeImageString19 == null || encodeImageString20 == null || encodeImageString21 == null || encodeImageString22 == null || encodeImageString23 == null || encodeImageString24 == null ||
                    encodeImageString25 == null || encodeImageString26 == null || encodeImageString27 == null || encodeImageString28 == null || encodeImageString29 == null || encodeImageString30 == null ||
                    encodeImageString31 == null || encodeImageString32 == null || encodeImageString33 == null || encodeImageString34 == null || encodeImageString35 == null || encodeImageString36 == null ||
                    encodeImageString37 == null || encodeImageString38 == null || encodeImageString39 == null || encodeImageString40 == null || encodeImageString41 == null || encodeImageString42 == null ||
                    encodeImageString43 == null || encodeImageString44 == null){
                        Toast toast = Toast.makeText(getContext(), "Foto harus diisi", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                    }

                    if (rdButton1 == null || rdButton2 == null || rdButton3 == null || rdButton4 == null || rdButton5 == null || rdButton6 == null || rdButton7 == null || rdButton8 == null || rdButton9 == null ||
                    rdButton10 == null || rdButton11 == null || rdButton12 == null || rdButton13 == null || rdButton14 == null || rdButton15 == null || rdButton16 == null || rdButton17 == null || rdButton18 == null ||
                    rdButton19 == null || rdButton20 == null || rdButton21 == null || rdButton22 == null || rdButton23 == null || rdButton24 == null || rdButton25 == null || rdButton26 == null || rdButton27 == null ||
                    rdButton28 == null || rdButton29 == null || rdButton30 == null || rdButton31 == null || rdButton32 == null || rdButton33 == null || rdButton34 == null || rdButton35 == null || rdButton36 == null ||
                    rdButton37 == null || rdButton38 == null || rdButton39 == null || rdButton40 == null || rdButton41 == null || rdButton42 == null || rdButton43 == null || rdButton44 == null){
                        Toast toast = Toast.makeText(getContext(), "Pilih Standar/Tidak standar", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                    }

                }
            }, 3000);
        }else {
            Toast toast = Toast.makeText(getContext(), "Upload gagal", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,0,0);
            toast.show();
        }
    }

    public boolean CheckNetworkConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}