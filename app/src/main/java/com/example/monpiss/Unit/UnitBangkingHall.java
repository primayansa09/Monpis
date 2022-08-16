package com.example.monpiss.Unit;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.example.monpiss.Home_Unit;
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

public class UnitBangkingHall extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String KODE_UKER16 = "kode_uker16";

    // TODO: Rename and change types of parameters
    private RadioGroup rdGroup1, rdGroup2, rdGroup3, rdGroup4, rdGroup5, rdGroup6, rdGroup7, rdGroup8, rdGroup9, rdGroup10, rdGroup11, rdGroup12, rdGroup13, rdGroup14, rdGroup15, rdGroup16,
            rdGroup17, rdGroup18, rdGroup19, rdGroup20, rdGroup21, rdGroup22, rdGroup23, rdGroup24, rdGroup25, rdGroup26, rdGroup27, rdGroup28, rdGroup29, rdGroup30, rdGroup31, rdGroup32, rdGroup33,
            rdGroup34, rdGroup35, rdGroup36, rdGroup37, rdGroup38, rdGroup39, rdGroup40, rdGroup41, rdGroup42, rdGroup43, rdGroup44;
    private RadioButton rdButton1, rdButton2, rdButton3, rdButton4, rdButton5, rdButton6, rdButton7, rdButton8, rdButton9, rdButton10, rdButton11, rdButton12, rdButton13, rdButton14, rdButton15, rdButton16,
            rdButton17, rdButton18, rdButton19, rdButton20, rdButton21, rdButton22, rdButton23, rdButton24, rdButton25, rdButton26, rdButton27, rdButton28, rdButton29, rdButton30, rdButton31, rdButton32, rdButton33,
            rdButton34, rdButton35, rdButton36, rdButton37, rdButton38, rdButton39, rdButton40, rdButton41, rdButton42, rdButton43, rdButton44;
    private ProgressDialog progressDialog;
    private Button btnSave;
    private TextView kodeUker;
    private String mParam2, encodeImageString1, encodeImageString2, encodeImageString3, encodeImageString4, encodeImageString5, encodeImageString6, encodeImageString7, encodeImageString8,
    encodeImageString9, encodeImageString10, encodeImageString11, encodeImageString12, encodeImageString13, encodeImageString14, encodeImageString15, encodeImageString16, encodeImageString17,
    encodeImageString18, encodeImageString19, encodeImageString20, encodeImageString21, encodeImageString22, encodeImageString23, encodeImageString24,
    encodeImageString25, encodeImageString26, encodeImageString27, encodeImageString28, encodeImageString29, encodeImageString30, encodeImageString31, encodeImageString32, encodeImageString33,
    encodeImageString34, encodeImageString35, encodeImageString36, encodeImageString37, encodeImageString38, encodeImageString39, encodeImageString40, encodeImageString41, encodeImageString42,
    encodeImageString43, encodeImageString44;
    private ImageView cHallUnit1, cHallUnit2, cHallUnit3, cHallUnit4, cHallUnit5, cHallUnit6, cHallUnit7, cHallUnit8, cHallUnit9, cHallUnit10,
            cHallUnit11, cHallUnit12, cHallUnit13, cHallUnit14, cHallUnit15, cHallUnit16, cHallUnit17, cHallUnit18, cHallUnit19, cHallUnit20, cHallUnit21,
            cHallUnit22, cHallUnit23, cHallUnit24, cHallUnit25, cHallUnit26, cHallUnit27, cHallUnit28, cHallUnit29, cHallUnit30, cHallUnit31, cHallUnit32,
            cHallUnit33, cHallUnit34, cHallUnit35, cHallUnit36, cHallUnit37, cHallUnit38, cHallUnit39, cHallUnit40, cHallUnit41, cHallUnit42, cHallUnit43, cHallUnit44;

    private ImageView imgHallUnit1, imgHallUnit2, imgHallUnit3, imgHallUnit4, imgHallUnit5, imgHallUnit6, imgHallUnit7, imgHallUnit8, imgHallUnit9, imgHallUnit10, imgHallUnit11,
            imgHallUnit12, imgHallUnit13, imgHallUnit14, imgHallUnit15, imgHallUnit16, imgHallUnit17, imgHallUnit18, imgHallUnit19, imgHallUnit20, imgHallUnit21,
            imgHallUnit22, imgHallUnit23, imgHallUnit24, imgHallUnit25, imgHallUnit26, imgHallUnit27, imgHallUnit28, imgHallUnit29, imgHallUnit30, imgHallUnit31,
            imgHallUnit32, imgHallUnit33, imgHallUnit34, imgHallUnit35, imgHallUnit36, imgHallUnit37, imgHallUnit38, imgHallUnit39,
            imgHallUnit40, imgHallUnit41, imgHallUnit42, imgHallUnit43, imgHallUnit44;

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

    public UnitBangkingHall() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static UnitBangkingHall newInstance(String param1, String param2) {
        UnitBangkingHall fragment = new UnitBangkingHall();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_unit_bangking_hall, container, false);

        cHallUnit1 = view.findViewById(R.id.camera_hall_unit1); cHallUnit26 = view.findViewById(R.id.camera_hall_unit26);
        cHallUnit2 = view.findViewById(R.id.camera_hall_unit2); cHallUnit27 = view.findViewById(R.id.camera_hall_unit27);
        cHallUnit3 = view.findViewById(R.id.camera_hall_unit3); cHallUnit28 = view.findViewById(R.id.camera_hall_unit28);
        cHallUnit4 = view.findViewById(R.id.camera_hall_unit4); cHallUnit29 = view.findViewById(R.id.camera_hall_unit29);
        cHallUnit5 = view.findViewById(R.id.camera_hall_unit5); cHallUnit30 = view.findViewById(R.id.camera_hall_unit30);
        cHallUnit6 = view.findViewById(R.id.camera_hall_unit6); cHallUnit31 = view.findViewById(R.id.camera_hall_unit31);
        cHallUnit7 = view.findViewById(R.id.camera_hall_unit7); cHallUnit32 = view.findViewById(R.id.camera_hall_unit32);
        cHallUnit8 = view.findViewById(R.id.camera_hall_unit8); cHallUnit33 = view.findViewById(R.id.camera_hall_unit33);
        cHallUnit9 = view.findViewById(R.id.camera_hall_unit9); cHallUnit34 = view.findViewById(R.id.camera_hall_unit34);
        cHallUnit10 = view.findViewById(R.id.camera_hall_unit10); cHallUnit35 = view.findViewById(R.id.camera_hall_unit35);
        cHallUnit11 = view.findViewById(R.id.camera_hall_unit11); cHallUnit36 = view.findViewById(R.id.camera_hall_unit36);
        cHallUnit12 = view.findViewById(R.id.camera_hall_unit12); cHallUnit37 = view.findViewById(R.id.camera_hall_unit37);
        cHallUnit13 = view.findViewById(R.id.camera_hall_unit13); cHallUnit38 = view.findViewById(R.id.camera_hall_unit38);
        cHallUnit14 = view.findViewById(R.id.camera_hall_unit14); cHallUnit39 = view.findViewById(R.id.camera_hall_unit39);
        cHallUnit15 = view.findViewById(R.id.camera_hall_unit15); cHallUnit40 = view.findViewById(R.id.camera_hall_unit40);
        cHallUnit16 = view.findViewById(R.id.camera_hall_unit16); cHallUnit41 = view.findViewById(R.id.camera_hall_unit41);
        cHallUnit17 = view.findViewById(R.id.camera_hall_unit17); cHallUnit42 = view.findViewById(R.id.camera_hall_unit42);
        cHallUnit18 = view.findViewById(R.id.camera_hall_unit18); cHallUnit43 = view.findViewById(R.id.camera_hall_unit43);
        cHallUnit19 = view.findViewById(R.id.camera_hall_unit19); cHallUnit44 = view.findViewById(R.id.camera_hall_unit44);
        cHallUnit20 = view.findViewById(R.id.camera_hall_unit20);
        cHallUnit21 = view.findViewById(R.id.camera_hall_unit21);
        cHallUnit22 = view.findViewById(R.id.camera_hall_unit22);
        cHallUnit23 = view.findViewById(R.id.camera_hall_unit23);
        cHallUnit24 = view.findViewById(R.id.camera_hall_unit24);
        cHallUnit25 = view.findViewById(R.id.camera_hall_unit25);

        rdGroup1 = view.findViewById(R.id.btn_pilihallUnit1); rdGroup21 = view.findViewById(R.id.btn_pilihallUnit21); rdGroup41 = view.findViewById(R.id.btn_pilihallUnit41);
        rdGroup2 = view.findViewById(R.id.btn_pilihallUnit2); rdGroup22 = view.findViewById(R.id.btn_pilihallUnit22); rdGroup42 = view.findViewById(R.id.btn_pilihallUnit42);
        rdGroup3 = view.findViewById(R.id.btn_pilihallUnit3); rdGroup23 = view.findViewById(R.id.btn_pilihallUnit23); rdGroup43 = view.findViewById(R.id.btn_pilihallUnit43);
        rdGroup4 = view.findViewById(R.id.btn_pilihallUnit4); rdGroup24 = view.findViewById(R.id.btn_pilihallUnit24); rdGroup44 = view.findViewById(R.id.btn_pilihallUnit44);
        rdGroup5 = view.findViewById(R.id.btn_pilihallUnit5); rdGroup25 = view.findViewById(R.id.btn_pilihallUnit25);
        rdGroup6 = view.findViewById(R.id.btn_pilihallUnit6); rdGroup26 = view.findViewById(R.id.btn_pilihallUnit26);
        rdGroup7 = view.findViewById(R.id.btn_pilihallUnit7); rdGroup27 = view.findViewById(R.id.btn_pilihallUnit27);
        rdGroup8 = view.findViewById(R.id.btn_pilihallUnit8); rdGroup28 = view.findViewById(R.id.btn_pilihallUnit28);
        rdGroup9 = view.findViewById(R.id.btn_pilihallUnit9); rdGroup29 = view.findViewById(R.id.btn_pilihallUnit29);
        rdGroup10 = view.findViewById(R.id.btn_pilihallUnit10); rdGroup30 = view.findViewById(R.id.btn_pilihallUnit30);
        rdGroup11 = view.findViewById(R.id.btn_pilihallUnit11); rdGroup31 = view.findViewById(R.id.btn_pilihallUnit31);
        rdGroup12 = view.findViewById(R.id.btn_pilihallUnit12); rdGroup32 = view.findViewById(R.id.btn_pilihallUnit32);
        rdGroup13 = view.findViewById(R.id.btn_pilihallUnit13); rdGroup33 = view.findViewById(R.id.btn_pilihallUnit33);
        rdGroup14 = view.findViewById(R.id.btn_pilihallUnit14); rdGroup34 = view.findViewById(R.id.btn_pilihallUnit34);
        rdGroup15 = view.findViewById(R.id.btn_pilihallUnit15); rdGroup35 = view.findViewById(R.id.btn_pilihallUnit35);
        rdGroup16 = view.findViewById(R.id.btn_pilihallUnit16); rdGroup36 = view.findViewById(R.id.btn_pilihallUnit36);
        rdGroup17 = view.findViewById(R.id.btn_pilihallUnit17); rdGroup37 = view.findViewById(R.id.btn_pilihallUnit37);
        rdGroup18 = view.findViewById(R.id.btn_pilihallUnit18); rdGroup38 = view.findViewById(R.id.btn_pilihallUnit38);
        rdGroup19 = view.findViewById(R.id.btn_pilihallUnit19); rdGroup39 = view.findViewById(R.id.btn_pilihallUnit39);
        rdGroup20 = view.findViewById(R.id.btn_pilihallUnit20); rdGroup40 = view.findViewById(R.id.btn_pilihallUnit40);

        imgHallUnit1 = view.findViewById(R.id.img_hall_unit1); imgHallUnit16 = view.findViewById(R.id.img_hall_unit16); imgHallUnit31 = view.findViewById(R.id.img_hall_unit31);
        imgHallUnit2 = view.findViewById(R.id.img_hall_unit2); imgHallUnit17 = view.findViewById(R.id.img_hall_unit17); imgHallUnit32 = view.findViewById(R.id.img_hall_unit32);
        imgHallUnit3 = view.findViewById(R.id.img_hall_unit3); imgHallUnit18 = view.findViewById(R.id.img_hall_unit18); imgHallUnit33 = view.findViewById(R.id.img_hall_unit33);
        imgHallUnit4 = view.findViewById(R.id.img_hall_unit4); imgHallUnit19 = view.findViewById(R.id.img_hall_unit19); imgHallUnit34 = view.findViewById(R.id.img_hall_unit34);
        imgHallUnit5 = view.findViewById(R.id.img_hall_unit5); imgHallUnit20 = view.findViewById(R.id.img_hall_unit20); imgHallUnit35 = view.findViewById(R.id.img_hall_unit35);
        imgHallUnit6 = view.findViewById(R.id.img_hall_unit6); imgHallUnit21 = view.findViewById(R.id.img_hall_unit21); imgHallUnit36 = view.findViewById(R.id.img_hall_unit36);
        imgHallUnit7 = view.findViewById(R.id.img_hall_unit7); imgHallUnit22 = view.findViewById(R.id.img_hall_unit22); imgHallUnit37 = view.findViewById(R.id.img_hall_unit37);
        imgHallUnit8 = view.findViewById(R.id.img_hall_unit8); imgHallUnit23 = view.findViewById(R.id.img_hall_unit23); imgHallUnit38 = view.findViewById(R.id.img_hall_unit38);
        imgHallUnit9 = view.findViewById(R.id.img_hall_unit9); imgHallUnit24 = view.findViewById(R.id.img_hall_unit24); imgHallUnit39 = view.findViewById(R.id.img_hall_unit39);
        imgHallUnit10 = view.findViewById(R.id.img_hall_unit10); imgHallUnit25= view.findViewById(R.id.img_hall_unit25); imgHallUnit40 = view.findViewById(R.id.img_hall_unit40);
        imgHallUnit11 = view.findViewById(R.id.img_hall_unit11); imgHallUnit26 = view.findViewById(R.id.img_hall_unit26); imgHallUnit41 = view.findViewById(R.id.img_hall_unit41);
        imgHallUnit12 = view.findViewById(R.id.img_hall_unit12); imgHallUnit27 = view.findViewById(R.id.img_hall_unit27); imgHallUnit42 = view.findViewById(R.id.img_hall_unit42);
        imgHallUnit13 = view.findViewById(R.id.img_hall_unit13); imgHallUnit28 = view.findViewById(R.id.img_hall_unit28); imgHallUnit43 = view.findViewById(R.id.img_hall_unit43);
        imgHallUnit14 = view.findViewById(R.id.img_hall_unit14); imgHallUnit29 = view.findViewById(R.id.img_hall_unit29); imgHallUnit44 = view.findViewById(R.id.img_hall_unit44);
        imgHallUnit15 = view.findViewById(R.id.img_hall_unit15); imgHallUnit30 = view.findViewById(R.id.img_hall_unit30);

        progressDialog = new ProgressDialog(UnitBangkingHall.this.getContext());
        btnSave = view.findViewById(R.id.btn_saveHallUnit);

        kodeUker = view.findViewById(R.id.name16);
        Unit data = getActivity().getIntent().getParcelableExtra(KODE_UKER16);
        String name = data.getNameUnit();
        kodeUker.setText(name);

        cHallUnit1.setOnClickListener(this); cHallUnit21.setOnClickListener(this); cHallUnit41.setOnClickListener(this);
        cHallUnit2.setOnClickListener(this); cHallUnit22.setOnClickListener(this); cHallUnit42.setOnClickListener(this);
        cHallUnit3.setOnClickListener(this); cHallUnit23.setOnClickListener(this); cHallUnit43.setOnClickListener(this);
        cHallUnit4.setOnClickListener(this); cHallUnit24.setOnClickListener(this); cHallUnit44.setOnClickListener(this);
        cHallUnit5.setOnClickListener(this); cHallUnit25.setOnClickListener(this); btnSave.setOnClickListener(this);
        cHallUnit6.setOnClickListener(this); cHallUnit26.setOnClickListener(this);
        cHallUnit7.setOnClickListener(this); cHallUnit27.setOnClickListener(this);
        cHallUnit8.setOnClickListener(this); cHallUnit28.setOnClickListener(this);
        cHallUnit9.setOnClickListener(this); cHallUnit29.setOnClickListener(this);
        cHallUnit10.setOnClickListener(this); cHallUnit30.setOnClickListener(this);
        cHallUnit11.setOnClickListener(this); cHallUnit31.setOnClickListener(this);
        cHallUnit12.setOnClickListener(this); cHallUnit32.setOnClickListener(this);
        cHallUnit13.setOnClickListener(this); cHallUnit33.setOnClickListener(this);
        cHallUnit14.setOnClickListener(this); cHallUnit34.setOnClickListener(this);
        cHallUnit15.setOnClickListener(this); cHallUnit35.setOnClickListener(this);
        cHallUnit16.setOnClickListener(this); cHallUnit36.setOnClickListener(this);
        cHallUnit17.setOnClickListener(this); cHallUnit37.setOnClickListener(this);
        cHallUnit18.setOnClickListener(this); cHallUnit38.setOnClickListener(this);
        cHallUnit19.setOnClickListener(this); cHallUnit39.setOnClickListener(this);
        cHallUnit20.setOnClickListener(this); cHallUnit40.setOnClickListener(this);

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
            case R.id.camera_hall_unit1:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall1, CODE_CAMERA);
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
            case R.id.camera_hall_unit2:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall2, CODE_CAMERA1);
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
            case R.id.camera_hall_unit3:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall3, CODE_CAMERA2);
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
            case R.id.camera_hall_unit4:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mCameraHall4 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mCameraHall4, CODE_CAMERA3);
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
            case R.id.camera_hall_unit5:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mCameraHall5 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mCameraHall5, CODE_CAMERA4);
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
            case R.id.camera_hall_unit6:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mCameraHall6 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mCameraHall6, CODE_CAMERA5);
                           }

                           @Override
                           public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                           }

                           @Override
                           public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                           }
                       }).check();
                break;
            case R.id.camera_hall_unit7:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall7 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall7, CODE_CAMERA6);
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
            case R.id.camera_hall_unit8:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall8 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall8, CODE_CAMERA7);
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
            case R.id.camera_hall_unit9:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall9 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall9, CODE_CAMERA8);
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
            case R.id.camera_hall_unit10:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall10 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall10, CODE_CAMERA9);
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
            case R.id.camera_hall_unit11:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mCameraHall11 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mCameraHall11, CODE_CAMERA10);
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
            case R.id.camera_hall_unit12:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCamerahall12 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCamerahall12, CODE_CAMERA11);
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
            case R.id.camera_hall_unit13:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall13 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall13, CODE_CAMERA12);
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
            case R.id.camera_hall_unit14:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall14 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall14, CODE_CAMERA13);
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
            case R.id.camera_hall_unit15:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall15 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall15, CODE_CAMERA14);
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
            case R.id.camera_hall_unit16:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mCameraHall16 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mCameraHall16, CODE_CAMERA15);
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
            case R.id.camera_hall_unit17:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mCameraHall17 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mCameraHall17, CODE_CAMERA16);
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
            case R.id.camera_hall_unit18:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall18 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall18, CODE_CAMERA17);
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
            case R.id.camera_hall_unit19:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall19 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall19, CODE_CAMERA18);
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
            case R.id.camera_hall_unit20:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mCameraHall20 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mCameraHall20, CODE_CAMERA19);
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
            case R.id.camera_hall_unit21:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall21 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall21, CODE_CAMERA20);
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
            case R.id.camera_hall_unit22:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall22 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall22, CODE_CAMERA21);
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
            case R.id.camera_hall_unit23:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall23 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall23, CODE_CAMERA22);
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
            case R.id.camera_hall_unit24:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mCameraHall24 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mCameraHall24, CODE_CAMERA23);
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
            case R.id.camera_hall_unit25:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall25 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall25, CODE_CAMERA24);
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
            case R.id.camera_hall_unit26:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mCameraHall26 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mCameraHall26, CODE_CAMERA25);
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
            case R.id.camera_hall_unit27:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall27 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall27, CODE_CAMERA26);
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
            case R.id.camera_hall_unit28:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mCameraHall28 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mCameraHall28, CODE_CAMERA27);
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
            case R.id.camera_hall_unit29:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall29 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall29, CODE_CAMERA28);
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
            case R.id.camera_hall_unit30:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall30 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall30, CODE_CAMERA29);
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
            case R.id.camera_hall_unit31:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall31 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall31, CODE_CAMERA30);
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
            case R.id.camera_hall_unit32:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mCameraHall32 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mCameraHall32, CODE_CAMERA31);
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
            case R.id.camera_hall_unit33:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall33 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall33, CODE_CAMERA32);
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
            case R.id.camera_hall_unit34:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall34 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall34, CODE_CAMERA33);
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
            case R.id.camera_hall_unit35:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mCameraHall35 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mCameraHall35, CODE_CAMERA34);
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
            case R.id.camera_hall_unit36:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall36 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall36, CODE_CAMERA35);
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
            case R.id.camera_hall_unit37:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mCameraHall37 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mCameraHall37, CODE_CAMERA36);
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
            case R.id.camera_hall_unit38:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mCameraHall38 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mCameraHall38, CODE_CAMERA37);
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
            case R.id.camera_hall_unit39:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall39 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall39, CODE_CAMERA38);
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
            case R.id.camera_hall_unit40:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall40 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall40, CODE_CAMERA39);
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
            case R.id.camera_hall_unit41:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCameraHall41 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCameraHall41, CODE_CAMERA40);
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
            case R.id.camera_hall_unit42:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mCameraHall42 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mCameraHall42, CODE_CAMERA41);
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
            case R.id.camera_hall_unit43:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mCameraHall43 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mCameraHall43, CODE_CAMERA42);
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
            case R.id.camera_hall_unit44:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mCameraHall44 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mCameraHall44, CODE_CAMERA43);
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
            case R.id.btn_saveHallUnit:
                uploadImage();
                btnSave.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.anim_item));
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (CODE_CAMERA == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap1 = (Bitmap) data.getExtras().get("data");
            imgHallUnit1.setImageBitmap(bitmap1);
            ImageToString1(getResizeBitmap(bitmap1, 512));
        }

        if (CODE_CAMERA1 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap2 = (Bitmap) data.getExtras().get("data");
            imgHallUnit2.setImageBitmap(bitmap2);
            ImageToString2(getResizeBitmap(bitmap2, 512));
        }

        if (CODE_CAMERA2 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap3 = (Bitmap) data.getExtras().get("data");
            imgHallUnit3.setImageBitmap(bitmap3);
            ImageToString3(getResizeBitmap(bitmap3, 512));
        }

        if (CODE_CAMERA3 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap4 = (Bitmap) data.getExtras().get("data");
            imgHallUnit4.setImageBitmap(bitmap4);
            ImageToString4(getResizeBitmap(bitmap4, 512));
        }

        if (CODE_CAMERA4 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap5 = (Bitmap) data.getExtras().get("data");
            imgHallUnit5.setImageBitmap(bitmap5);
            ImageToString5(getResizeBitmap(bitmap5, 512));
        }

        if (CODE_CAMERA5 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap6 = (Bitmap) data.getExtras().get("data");
            imgHallUnit6.setImageBitmap(bitmap6);
            ImageToString6(getResizeBitmap(bitmap6, 512));
        }

        if (CODE_CAMERA6 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap7 = (Bitmap) data.getExtras().get("data");
            imgHallUnit7.setImageBitmap(bitmap7);
            ImageToString7(getResizeBitmap(bitmap7, 512));
        }

        if (CODE_CAMERA7 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap8 = (Bitmap) data.getExtras().get("data");
            imgHallUnit8.setImageBitmap(bitmap8);
            ImageToString8(getResizeBitmap(bitmap8, 512));
        }

        if (CODE_CAMERA8 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap9 = (Bitmap) data.getExtras().get("data");
            imgHallUnit9.setImageBitmap(bitmap9);
            ImageToString9(getResizeBitmap(bitmap9, 512));
        }

        if (CODE_CAMERA9 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap10 = (Bitmap) data.getExtras().get("data");
            imgHallUnit10.setImageBitmap(bitmap10);
            ImageToString10(getResizeBitmap(bitmap10, 512));
        }

        if (CODE_CAMERA10 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap11 = (Bitmap) data.getExtras().get("data");
            imgHallUnit11.setImageBitmap(bitmap11);
            ImageToString11(getResizeBitmap(bitmap11, 512));
        }

        if (CODE_CAMERA11 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap12 = (Bitmap) data.getExtras().get("data");
            imgHallUnit12.setImageBitmap(bitmap12);
            ImageToString12(getResizeBitmap(bitmap12, 512));
        }

        if (CODE_CAMERA12 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap13 = (Bitmap) data.getExtras().get("data");
            imgHallUnit13.setImageBitmap(bitmap13);
            ImageToString13(getResizeBitmap(bitmap13, 512));
        }

        if (CODE_CAMERA13 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap14 = (Bitmap) data.getExtras().get("data");
            imgHallUnit14.setImageBitmap(bitmap14);
            ImageToString14(getResizeBitmap(bitmap14, 512));
        }

        if (CODE_CAMERA14 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap15 = (Bitmap) data.getExtras().get("data");
            imgHallUnit15.setImageBitmap(bitmap15);
            ImageToString15(getResizeBitmap(bitmap15, 512));
        }

        if (CODE_CAMERA15 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap16 = (Bitmap) data.getExtras().get("data");
            imgHallUnit16.setImageBitmap(bitmap16);
            ImageToString16(getResizeBitmap(bitmap16, 512));
        }

        if (CODE_CAMERA16 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap17 = (Bitmap) data.getExtras().get("data");
            imgHallUnit17.setImageBitmap(bitmap17);
            ImageToString17(getResizeBitmap(bitmap17, 512));
        }

        if (CODE_CAMERA17 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap18 = (Bitmap) data.getExtras().get("data");
            imgHallUnit18.setImageBitmap(bitmap18);
            ImageToString18(getResizeBitmap(bitmap18, 512));
        }

        if (CODE_CAMERA18 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap19 = (Bitmap) data.getExtras().get("data");
            imgHallUnit19.setImageBitmap(bitmap19);
            ImageToString19(getResizeBitmap(bitmap19, 512));
        }

        if (CODE_CAMERA19 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap20 = (Bitmap) data.getExtras().get("data");
            imgHallUnit20.setImageBitmap(bitmap20);
            ImageToString20(getResizeBitmap(bitmap20, 512));
        }

        if (CODE_CAMERA20 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap21 = (Bitmap) data.getExtras().get("data");
            imgHallUnit21.setImageBitmap(bitmap21);
            ImageToString21(getResizeBitmap(bitmap21, 512));
        }

        if (CODE_CAMERA21 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap22 = (Bitmap) data.getExtras().get("data");
            imgHallUnit22.setImageBitmap(bitmap22);
            ImageToString22(getResizeBitmap(bitmap22, 512));
        }

        if (CODE_CAMERA22 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap23 = (Bitmap) data.getExtras().get("data");
            imgHallUnit23.setImageBitmap(bitmap23);
            ImageToString23(getResizeBitmap(bitmap23, 512));
        }

        if (CODE_CAMERA23 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap24 = (Bitmap) data.getExtras().get("data");
            imgHallUnit24.setImageBitmap(bitmap24);
            ImageToString24(getResizeBitmap(bitmap24, 512));
        }

        if (CODE_CAMERA24 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap25 = (Bitmap) data.getExtras().get("data");
            imgHallUnit25.setImageBitmap(bitmap25);
            ImageToString25(getResizeBitmap(bitmap25, 512));
        }

        if (CODE_CAMERA25 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap26 = (Bitmap) data.getExtras().get("data");
            imgHallUnit26.setImageBitmap(bitmap26);
            ImageToString26(getResizeBitmap(bitmap26, 512));
        }

        if (CODE_CAMERA26 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap27 = (Bitmap) data.getExtras().get("data");
            imgHallUnit27.setImageBitmap(bitmap27);
            ImageToString27(getResizeBitmap(bitmap27, 512));
        }

        if (CODE_CAMERA27 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap28 = (Bitmap) data.getExtras().get("data");
            imgHallUnit28.setImageBitmap(bitmap28);
            ImageToString28(getResizeBitmap(bitmap28, 512));
        }

        if (CODE_CAMERA28 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap29 = (Bitmap) data.getExtras().get("data");
            imgHallUnit29.setImageBitmap(bitmap29);
            ImageToString29(getResizeBitmap(bitmap29, 512));
        }

        if (CODE_CAMERA29 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap30 = (Bitmap) data.getExtras().get("data");
            imgHallUnit30.setImageBitmap(bitmap30);
            ImageToString30(getResizeBitmap(bitmap30, 512));
        }

        if (CODE_CAMERA30 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap31 = (Bitmap) data.getExtras().get("data");
            imgHallUnit31.setImageBitmap(bitmap31);
            ImageToString31(getResizeBitmap(bitmap31, 512));
        }

        if (CODE_CAMERA31 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap32 = (Bitmap) data.getExtras().get("data");
            imgHallUnit32.setImageBitmap(bitmap32);
            ImageToString32(getResizeBitmap(bitmap32, 512));
        }

        if (CODE_CAMERA32 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap33 = (Bitmap) data.getExtras().get("data");
            imgHallUnit33.setImageBitmap(bitmap33);
            ImageToString33(getResizeBitmap(bitmap33, 512));
        }

        if (CODE_CAMERA33 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap34 = (Bitmap) data.getExtras().get("data");
            imgHallUnit34.setImageBitmap(bitmap34);
            ImageToString34(getResizeBitmap(bitmap34, 512));
        }

        if (CODE_CAMERA34 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap35 = (Bitmap) data.getExtras().get("data");
            imgHallUnit35.setImageBitmap(bitmap35);
            ImageToString35(getResizeBitmap(bitmap35, 512));
        }

        if (CODE_CAMERA35 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap36 = (Bitmap) data.getExtras().get("data");
            imgHallUnit36.setImageBitmap(bitmap36);
            ImageToString36(getResizeBitmap(bitmap36, 512));
        }

        if (CODE_CAMERA36 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap37 = (Bitmap) data.getExtras().get("data");
            imgHallUnit37.setImageBitmap(bitmap37);
            ImageToString37(getResizeBitmap(bitmap37, 512));
        }

        if (CODE_CAMERA37 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap38 = (Bitmap) data.getExtras().get("data");
            imgHallUnit38.setImageBitmap(bitmap38);
            ImageToString38(getResizeBitmap(bitmap38, 512));
        }

        if (CODE_CAMERA38 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap39 = (Bitmap) data.getExtras().get("data");
            imgHallUnit39.setImageBitmap(bitmap39);
            ImageToString39(getResizeBitmap(bitmap39, 512));
        }

        if (CODE_CAMERA39 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap40 = (Bitmap) data.getExtras().get("data");
            imgHallUnit40.setImageBitmap(bitmap40);
            ImageToString40(getResizeBitmap(bitmap40, 512));
        }

        if (CODE_CAMERA40 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap41 = (Bitmap) data.getExtras().get("data");
            imgHallUnit41.setImageBitmap(bitmap41);
            ImageToString41(getResizeBitmap(bitmap41, 512));
        }

        if (CODE_CAMERA41 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap42 = (Bitmap) data.getExtras().get("data");
            imgHallUnit42.setImageBitmap(bitmap42);
            ImageToString42(getResizeBitmap(bitmap42, 512));
        }

        if (CODE_CAMERA42 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap43 = (Bitmap) data.getExtras().get("data");
            imgHallUnit43.setImageBitmap(bitmap43);
            ImageToString43(getResizeBitmap(bitmap43, 512));
        }

        if (CODE_CAMERA43 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap44 = (Bitmap) data.getExtras().get("data");
            imgHallUnit44.setImageBitmap(bitmap44);
            ImageToString44(getResizeBitmap(bitmap44, 512));
        }
    }

    private Bitmap getResizeBitmap(Bitmap image , int maxsize){
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRotasi = (float) width / (float) height;
        if (bitmapRotasi > 1){
            width = maxsize;
            height = (int) (width / bitmapRotasi);
        }else {
            height = maxsize;
            width = (int) (height * bitmapRotasi);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
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
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100 , byteArrayOutputStream);
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
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_IMAGE_BANKING_UNIT_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                                imgHallUnit1.setImageResource(R.drawable.ic_check); rdButton1.setChecked(false);
                                imgHallUnit2.setImageResource(R.drawable.ic_check); rdButton2.setChecked(false);
                                imgHallUnit3.setImageResource(R.drawable.ic_check); rdButton3.setChecked(false);
                                imgHallUnit4.setImageResource(R.drawable.ic_check); rdButton4.setChecked(false);
                                imgHallUnit5.setImageResource(R.drawable.ic_check); rdButton5.setChecked(false);
                                imgHallUnit6.setImageResource(R.drawable.ic_check); rdButton6.setChecked(false);
                                imgHallUnit7.setImageResource(R.drawable.ic_check); rdButton7.setChecked(false);
                                imgHallUnit8.setImageResource(R.drawable.ic_check); rdButton8.setChecked(false);
                                imgHallUnit9.setImageResource(R.drawable.ic_check); rdButton9.setChecked(false);
                                imgHallUnit10.setImageResource(R.drawable.ic_check); rdButton10.setChecked(false);
                                imgHallUnit11.setImageResource(R.drawable.ic_check); rdButton11.setChecked(false);
                                imgHallUnit12.setImageResource(R.drawable.ic_check); rdButton12.setChecked(false);
                                imgHallUnit13.setImageResource(R.drawable.ic_check); rdButton13.setChecked(false);
                                imgHallUnit14.setImageResource(R.drawable.ic_check); rdButton14.setChecked(false);
                                imgHallUnit15.setImageResource(R.drawable.ic_check); rdButton15.setChecked(false);
                                imgHallUnit16.setImageResource(R.drawable.ic_check); rdButton16.setChecked(false);
                                imgHallUnit17.setImageResource(R.drawable.ic_check); rdButton17.setChecked(false);
                                imgHallUnit18.setImageResource(R.drawable.ic_check); rdButton18.setChecked(false);
                                imgHallUnit19.setImageResource(R.drawable.ic_check); rdButton19.setChecked(false);
                                imgHallUnit20.setImageResource(R.drawable.ic_check); rdButton20.setChecked(false);
                                imgHallUnit21.setImageResource(R.drawable.ic_check); rdButton21.setChecked(false);
                                imgHallUnit22.setImageResource(R.drawable.ic_check); rdButton22.setChecked(false);
                                imgHallUnit23.setImageResource(R.drawable.ic_check); rdButton23.setChecked(false);
                                imgHallUnit24.setImageResource(R.drawable.ic_check); rdButton24.setChecked(false);
                                imgHallUnit25.setImageResource(R.drawable.ic_check); rdButton25.setChecked(false);
                                imgHallUnit26.setImageResource(R.drawable.ic_check); rdButton26.setChecked(false);
                                imgHallUnit27.setImageResource(R.drawable.ic_check); rdButton27.setChecked(false);
                                imgHallUnit28.setImageResource(R.drawable.ic_check); rdButton28.setChecked(false);
                                imgHallUnit29.setImageResource(R.drawable.ic_check); rdButton29.setChecked(false);
                                imgHallUnit30.setImageResource(R.drawable.ic_check); rdButton30.setChecked(false);
                                imgHallUnit31.setImageResource(R.drawable.ic_check); rdButton31.setChecked(false);
                                imgHallUnit32.setImageResource(R.drawable.ic_check); rdButton32.setChecked(false);
                                imgHallUnit33.setImageResource(R.drawable.ic_check); rdButton33.setChecked(false);
                                imgHallUnit34.setImageResource(R.drawable.ic_check); rdButton34.setChecked(false);
                                imgHallUnit35.setImageResource(R.drawable.ic_check); rdButton35.setChecked(false);
                                imgHallUnit36.setImageResource(R.drawable.ic_check); rdButton36.setChecked(false);
                                imgHallUnit37.setImageResource(R.drawable.ic_check); rdButton37.setChecked(false);
                                imgHallUnit38.setImageResource(R.drawable.ic_check); rdButton38.setChecked(false);
                                imgHallUnit39.setImageResource(R.drawable.ic_check); rdButton39.setChecked(false);
                                imgHallUnit40.setImageResource(R.drawable.ic_check); rdButton40.setChecked(false);
                                imgHallUnit41.setImageResource(R.drawable.ic_check); rdButton41.setChecked(false);
                                imgHallUnit42.setImageResource(R.drawable.ic_check); rdButton42.setChecked(false);
                                imgHallUnit43.setImageResource(R.drawable.ic_check); rdButton43.setChecked(false);
                                imgHallUnit44.setImageResource(R.drawable.ic_check); rdButton44.setChecked(false);
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
                        }else {
                            params.put("", encodeImageString2);
                        }
                        if (encodeImageString3 != null){
                            params.put("upload3", encodeImageString3);
                        }else {
                            params.put("", encodeImageString3);
                        }
                        if (encodeImageString4 != null){
                            params.put("upload4", encodeImageString4);
                        }else {
                            params.put("", encodeImageString4);
                        }
                        if (encodeImageString5 != null){
                            params.put("upload5" , encodeImageString5);
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
                        }else {
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
                            params.put("",encodeImageString11);
                        }
                        if (encodeImageString12 != null){
                            params.put("upload12", encodeImageString12);
                        }else {
                            params.put("", encodeImageString12);
                        }
                        if (encodeImageString13 != null){
                            params.put("upload13", encodeImageString13);
                        }else {
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
                        }else{
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
                        }else {
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
                            params.put("", encodeImageString25);
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
                        }else {
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
                        }else {
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
                            params.put("stnd28", rdButton27.getText().toString());
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
                            params.put("", rdButton30.getText().toString());
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
                    if (encodeImageString1 == null || encodeImageString2 == null || encodeImageString3 == null || encodeImageString4 == null || encodeImageString5 == null || encodeImageString6 == null || encodeImageString7 == null ||
                    encodeImageString8 == null || encodeImageString9 == null || encodeImageString10 == null || encodeImageString11 == null || encodeImageString12 == null || encodeImageString13 == null || encodeImageString14 == null ||
                    encodeImageString15 == null || encodeImageString16 == null || encodeImageString17 == null || encodeImageString18 == null || encodeImageString19 == null || encodeImageString20 == null || encodeImageString21 == null ||
                    encodeImageString22 == null || encodeImageString23 == null || encodeImageString24 == null || encodeImageString25 == null || encodeImageString26 == null || encodeImageString27 == null || encodeImageString28 == null ||
                    encodeImageString29 == null || encodeImageString30 == null || encodeImageString31 == null || encodeImageString32 == null || encodeImageString33 == null || encodeImageString34 == null || encodeImageString35 == null ||
                    encodeImageString36 == null || encodeImageString37 == null || encodeImageString38 == null || encodeImageString39 == null || encodeImageString40 == null || encodeImageString41 == null || encodeImageString42 == null ||
                    encodeImageString42 == null || encodeImageString43 == null || encodeImageString44 == null ){
                        Toast toast = Toast.makeText(getContext(), "Foto harus diisi", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                    }

                    if (rdButton1 == null || rdButton2 == null || rdButton3 == null || rdButton4 == null || rdButton5 == null || rdButton6 == null || rdButton7 == null || rdButton8 == null || rdButton9 == null || rdButton10 == null || rdButton11 == null ||
                    rdButton12 == null || rdButton13 == null || rdButton14 == null || rdButton15 == null || rdButton16 == null || rdButton17 == null || rdButton18 == null || rdButton19 == null || rdButton20 == null || rdButton21 == null || rdButton22 == null ||
                    rdButton23 == null || rdButton24 == null || rdButton25 == null || rdButton26 == null || rdButton27 == null || rdButton28 == null || rdButton29 == null || rdButton30 == null || rdButton31 == null || rdButton32 == null || rdButton33 == null ||
                    rdButton34 == null || rdButton35 == null || rdButton36 == null || rdButton37 == null || rdButton38 == null || rdButton39 == null || rdButton40 == null || rdButton41 == null || rdButton42 == null || rdButton43 == null || rdButton44 == null){
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