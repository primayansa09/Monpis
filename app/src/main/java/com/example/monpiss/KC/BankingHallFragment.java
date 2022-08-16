package com.example.monpiss.KC;

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

public class BankingHallFragment extends Fragment implements View.OnClickListener {

    public static final String KODE_UKER4 = "kode_uker4";

    private TextView kodeUker;
    private Button btnSave;
    private ProgressDialog progressDialog;
    private RadioGroup rdGroup1, rdGroup2, rdGroup3, rdGroup4, rdGroup5, rdGroup6, rdGroup7, rdGroup8, rdGroup9, rdGroup10,
            rdGroup11, rdGroup12, rdGroup13, rdGroup14, rdGroup15, rdGroup16, rdGroup17, rdGroup18, rdGroup19, rdGroup20,
            rdGroup21, rdGroup22, rdGroup23, rdGroup24, rdGroup25, rdGroup26, rdGroup27, rdGroup28, rdGroup29, rdGroup30,
            rdGroup31, rdGroup32, rdGroup33, rdGroup34, rdGroup35, rdGroup36, rdGroup37, rdGroup38, rdGroup39, rdGroup40,
            rdGroup41, rdGroup42, rdGroup43, rdGroup44;

    private RadioButton rdButton1, rdButton2, rdButton3, rdButton4, rdButton5, rdButton6, rdButton7, rdButton8, rdButton9, rdButton10, rdButton11, rdButton12, rdButton13, rdButton14, rdButton15, rdButton16, rdButton17, rdButton18, rdButton19, rdButton20, rdButton21,
            rdButton22, rdButton23, rdButton24, rdButton25, rdButton26, rdButton27, rdButton28, rdButton29, rdButton30, rdButton31, rdButton32, rdButton33, rdButton34, rdButton35, rdButton36, rdButton37, rdButton38, rdButton39, rdButton40, rdButton41, rdButton42, rdButton43, rdButton44;

    private ImageView cHallKC1, cHallKC2, cHallKC3, cHallKC4, cHallKC5, cHallKC6, cHallKC7, cHallKC8, cHallKC9, cHallKC10, cHallKC11, cHallKC12, cHallKC13, cHallKC14, cHallKC15, cHallKC16, cHallKC17,
            cHallKC18, cHallKC19, cHallKC20, cHallKC21, cHallKC22, cHallKC23, cHallKC24, cHallKC25, cHallKC26, cHallKC27, cHallKC28, cHallKC29, cHallKC30, cHallKC31, cHallKC32, cHallKC33, cHallKC34, cHallKC35,
            cHallKC36, cHallKC37, cHallKC38, cHallKC39, cHallKC40, cHallKC41, cHallKC42, cHallKC43, cHallKC44;

    private ImageView imgHallKC1, imgHallKC2, imgHallKC3, imgHallKC4, imgHallKC5, imgHallKC6, imgHallKC7, imgHallKC8, imgHallKC9, imgHallKC10, imgHallKC11, imgHallKC12, imgHallKC13, imgHallKC14, imgHallKC15, imgHallKC16,
            imgHallKC17, imgHallKC18, imgHallKC19, imgHallKC20, imgHallKC21, imgHallKC22, imgHallKC23, imgHallKC24, imgHallKC25, imgHallKC26, imgHallKC27, imgHallKC28, imgHallKC29, imgHallK30, imgHallKC31, imgHallKC32,
            imgHallKC33, imgHallKC34, imgHallKC35, imgHallKC36, imgHallKC37, imgHallKC38, imgHallKC39, imgHallKC40, imgHallKC41, imgHallKC42, imgHallKC43, imgHallKC44;

    private String encodeImageString1, encodeImageString2, encodeImageString3, encodeImageString4, encodeImageString5, encodeImageString6, encodeImageString7, encodeImageString8, encodeImageString9, encodeImageString10,
            encodeImageString11, encodeImageString12, encodeImageString13, encodeImageString14, encodeImageString15, encodeImageString16, encodeImageString17, encodeImageString18,encodeImageString19, encodeImageString20, encodeImageString21,
            encodeImageString22, encodeImageString23, encodeImageString24, encodeImageString25, encodeImageString26, encodeImageString27, encodeImageString28, encodeImageString29, encodeImageString30, encodeImageString31, encodeImageString32,
            encodeImageString33, encodeImageString34, encodeImageString35, encodeImageString36, encodeImageString37, encodeImageString38, encodeImageString39, encodeImageString40, encodeImageString41, encodeImageString42, encodeImageString43, encodeImageString44;


    private static final int REQUEST_CODE_CAMERA1 = 1; private static final int REQUEST_CODE_CAMERA12 = 12; private static final int REQUEST_CODE_CAMERA23 = 23;
    private static final int REQUEST_CODE_CAMERA2 = 2; private static final int REQUEST_CODE_CAMERA13 = 13; private static final int REQUEST_CODE_CAMERA24 = 24;
    private static final int REQUEST_CODE_CAMERA3 = 3; private static final int REQUEST_CODE_CAMERA14 = 14; private static final int REQUEST_CODE_CAMERA25 = 25;
    private static final int REQUEST_CODE_CAMERA4 = 4; private static final int REQUEST_CODE_CAMERA15 = 15; private static final int REQUEST_CODE_CAMERA26 = 26;
    private static final int REQUEST_CODE_CAMERA5 = 5; private static final int REQUEST_CODE_CAMERA16 = 16; private static final int REQUEST_CODE_CAMERA27 = 27;
    private static final int REQUEST_CODE_CAMERA6 = 6; private static final int REQUEST_CODE_CAMERA17 = 17; private static final int REQUEST_CODE_CAMERA28 = 28;
    private static final int REQUEST_CODE_CAMERA7 = 7; private static final int REQUEST_CODE_CAMERA18 = 18; private static final int REQUEST_CODE_CAMERA29 = 29;
    private static final int REQUEST_CODE_CAMERA8 = 8; private static final int REQUEST_CODE_CAMERA19 = 19; private static final int REQUEST_CODE_CAMERA30 = 30;
    private static final int REQUEST_CODE_CAMERA9 = 9; private static final int REQUEST_CODE_CAMERA20 = 20; private static final int REQUEST_CODE_CAMERA31 = 31;
    private static final int REQUEST_CODE_CAMERA10 = 10; private static final int REQUEST_CODE_CAMERA21 = 21; private static final int REQUEST_CODE_CAMERA32 = 32;
    private static final int REQUEST_CODE_CAMERA11 = 11; private static final int REQUEST_CODE_CAMERA22 = 22; private static final int REQUEST_CODE_CAMERA33 = 33;

    private static final int REQUEST_CODE_CAMERA34 = 34; private static final int REQUEST_CODE_CAMERA42 = 42;
    private static final int REQUEST_CODE_CAMERA35 = 35; private static final int REQUEST_CODE_CAMERA43 = 43;
    private static final int REQUEST_CODE_CAMERA36 = 36; private static final int REQUEST_CODE_CAMERA44 = 44;
    private static final int REQUEST_CODE_CAMERA37 = 37;
    private static final int REQUEST_CODE_CAMERA38 = 38;
    private static final int REQUEST_CODE_CAMERA39 = 39;
    private static final int REQUEST_CODE_CAMERA40 = 40;
    private static final int REQUEST_CODE_CAMERA41 = 41;

    public BankingHallFragment() {
    }

    //public static BankingHallFragment newInstance(String param1, String param2) {
      //  BankingHallFragment fragment = new BankingHallFragment();
       // Bundle args = new Bundle();
       // fragment.setArguments(args);
       // return fragment;
   // }

  //  @Override
    //public void onCreate(Bundle savedInstanceState) {
      //  super.onCreate(savedInstanceState);
       // if (getArguments() != null) {
        //}
    //}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_banking_hall, container, false);


        cHallKC1 = view.findViewById(R.id.camera_hall1); cHallKC16 = view.findViewById(R.id.camera_hall16); cHallKC31 = view.findViewById(R.id.camera_hall31);
        cHallKC2 = view.findViewById(R.id.camera_hall2); cHallKC17 = view.findViewById(R.id.camera_hall17); cHallKC32 = view.findViewById(R.id.camera_hall32);
        cHallKC3 = view.findViewById(R.id.camera_hall3); cHallKC18 = view.findViewById(R.id.camera_hall18); cHallKC33 = view.findViewById(R.id.camera_hall33);
        cHallKC4 = view.findViewById(R.id.camera_hall4); cHallKC19 = view.findViewById(R.id.camera_hall19); cHallKC34 = view.findViewById(R.id.camera_hall34);
        cHallKC5 = view.findViewById(R.id.camera_hall5); cHallKC20 = view.findViewById(R.id.camera_hall20); cHallKC35 = view.findViewById(R.id.camera_hall35);
        cHallKC6 = view.findViewById(R.id.camera_hall6); cHallKC21 = view.findViewById(R.id.camera_hall21); cHallKC36 = view.findViewById(R.id.camera_hall36);
        cHallKC7 = view.findViewById(R.id.camera_hall7); cHallKC22 = view.findViewById(R.id.camera_hall22); cHallKC37 = view.findViewById(R.id.camera_hall37);
        cHallKC8 = view.findViewById(R.id.camera_hall8); cHallKC23 = view.findViewById(R.id.camera_hall23); cHallKC38 = view.findViewById(R.id.camera_hall38);
        cHallKC9 = view.findViewById(R.id.camera_hall9); cHallKC24 = view.findViewById(R.id.camera_hall24); cHallKC39 = view.findViewById(R.id.camera_hall39);
        cHallKC10 = view.findViewById(R.id.camera_hall10); cHallKC25 = view.findViewById(R.id.camera_hall25); cHallKC40 = view.findViewById(R.id.camera_hall40);
        cHallKC11 = view.findViewById(R.id.camera_hall11); cHallKC26 = view.findViewById(R.id.camera_hall26); cHallKC41 = view.findViewById(R.id.camera_hall41);
        cHallKC12 = view.findViewById(R.id.camera_hall12); cHallKC27 = view.findViewById(R.id.camera_hall27); cHallKC42 = view.findViewById(R.id.camera_hall42);
        cHallKC13 = view.findViewById(R.id.camera_hall13); cHallKC28 = view.findViewById(R.id.camera_hall28); cHallKC43 = view.findViewById(R.id.camera_hall43);
        cHallKC14 = view.findViewById(R.id.camera_hall14); cHallKC29 = view.findViewById(R.id.camera_hall29); cHallKC44 = view.findViewById(R.id.camera_hall44);
        cHallKC15 = view.findViewById(R.id.camera_hall15); cHallKC30 = view.findViewById(R.id.camera_hall30);

        rdGroup1 = view.findViewById(R.id.rg_pilihHall1); rdGroup16 = view.findViewById(R.id.rg_pilihHall16); rdGroup31 = view.findViewById(R.id.rg_pilihHall31);
        rdGroup2 = view.findViewById(R.id.rg_pilihHall2); rdGroup17 = view.findViewById(R.id.rg_pilihHall17); rdGroup32 = view.findViewById(R.id.rg_pilihHall32);
        rdGroup3 = view.findViewById(R.id.rg_pilihHall3); rdGroup18 = view.findViewById(R.id.rg_pilihHall18); rdGroup33 = view.findViewById(R.id.rg_pilihHall33);
        rdGroup4 = view.findViewById(R.id.rg_pilihHall4); rdGroup19 = view.findViewById(R.id.rg_pilihHall19); rdGroup34 = view.findViewById(R.id.rg_pilihHall34);
        rdGroup5 = view.findViewById(R.id.rg_pilihHall5); rdGroup20 = view.findViewById(R.id.rg_pilihHall20); rdGroup35 = view.findViewById(R.id.rg_pilihHall35);
        rdGroup6 = view.findViewById(R.id.rg_pilihHall6); rdGroup21 = view.findViewById(R.id.rg_pilihHall21); rdGroup36 = view.findViewById(R.id.rg_pilihHall36);
        rdGroup7 = view.findViewById(R.id.rg_pilihHall7); rdGroup22 = view.findViewById(R.id.rg_pilihHall22); rdGroup37 = view.findViewById(R.id.rg_pilihHall37);
        rdGroup8 = view.findViewById(R.id.rg_pilihHall8); rdGroup23 = view.findViewById(R.id.rg_pilihHall23); rdGroup38 = view.findViewById(R.id.rg_pilihHall38);
        rdGroup9 = view.findViewById(R.id.rg_pilihHall9); rdGroup24 = view.findViewById(R.id.rg_pilihHall24); rdGroup39 = view.findViewById(R.id.rg_pilihHall39);
        rdGroup10 = view.findViewById(R.id.rg_pilihHall10); rdGroup25 = view.findViewById(R.id.rg_pilihHall25); rdGroup40 = view.findViewById(R.id.rg_pilihHall40);
        rdGroup11 = view.findViewById(R.id.rg_pilihHall11); rdGroup26 = view.findViewById(R.id.rg_pilihHall26); rdGroup41 = view.findViewById(R.id.rg_pilihHall41);
        rdGroup12 = view.findViewById(R.id.rg_pilihHall12); rdGroup27 = view.findViewById(R.id.rg_pilihHall27); rdGroup42 = view.findViewById(R.id.rg_pilihHall42);
        rdGroup13 = view.findViewById(R.id.rg_pilihHall13); rdGroup28 = view.findViewById(R.id.rg_pilihHall28); rdGroup43 = view.findViewById(R.id.rg_pilihHall43);
        rdGroup14 = view.findViewById(R.id.rg_pilihHall14); rdGroup29 = view.findViewById(R.id.rg_pilihHall29); rdGroup44 = view.findViewById(R.id.rg_pilihHall44);
        rdGroup15 = view.findViewById(R.id.rg_pilihHall15); rdGroup30 = view.findViewById(R.id.rg_pilihHall30);

        imgHallKC1 = view.findViewById(R.id.img_hall1); imgHallKC11 = view.findViewById(R.id.img_hall11); imgHallKC21 = view.findViewById(R.id.img_hall21);
        imgHallKC2 = view.findViewById(R.id.img_hall2); imgHallKC12 = view.findViewById(R.id.img_hall12); imgHallKC22 = view.findViewById(R.id.img_hall22);
        imgHallKC3 = view.findViewById(R.id.img_hall3); imgHallKC13 = view.findViewById(R.id.img_hall13); imgHallKC23 = view.findViewById(R.id.img_hall23);
        imgHallKC4 = view.findViewById(R.id.img_hall4); imgHallKC14 = view.findViewById(R.id.img_hall14); imgHallKC24 = view.findViewById(R.id.img_hall24);
        imgHallKC5 = view.findViewById(R.id.img_hall5); imgHallKC15 = view.findViewById(R.id.img_hall15); imgHallKC25 = view.findViewById(R.id.img_hall25);
        imgHallKC6 = view.findViewById(R.id.img_hall6); imgHallKC16 = view.findViewById(R.id.img_hall16); imgHallKC26 = view.findViewById(R.id.img_hall26);
        imgHallKC7 = view.findViewById(R.id.img_hall7); imgHallKC17 = view.findViewById(R.id.img_hall17); imgHallKC27 = view.findViewById(R.id.img_hall27);
        imgHallKC8 = view.findViewById(R.id.img_hall8); imgHallKC18 = view.findViewById(R.id.img_hall18); imgHallKC28 = view.findViewById(R.id.img_hall28);
        imgHallKC9 = view.findViewById(R.id.img_hall9); imgHallKC19 = view.findViewById(R.id.img_hall19); imgHallKC29 = view.findViewById(R.id.img_hall29);
        imgHallKC10 = view.findViewById(R.id.img_hall10); imgHallKC20 = view.findViewById(R.id.img_hall20); imgHallK30 = view.findViewById(R.id.img_hall30);

        imgHallKC31 = view.findViewById(R.id.img_hall31); imgHallKC41 = view.findViewById(R.id.img_hall41);
        imgHallKC32 = view.findViewById(R.id.img_hall32); imgHallKC42 = view.findViewById(R.id.img_hall42);
        imgHallKC33 = view.findViewById(R.id.img_hall33); imgHallKC43 = view.findViewById(R.id.img_hall43);
        imgHallKC34 = view.findViewById(R.id.img_hall34); imgHallKC44 = view.findViewById(R.id.img_hall44);
        imgHallKC35 = view.findViewById(R.id.img_hall35);
        imgHallKC36 = view.findViewById(R.id.img_hall36);
        imgHallKC37 = view.findViewById(R.id.img_hall37);
        imgHallKC38 = view.findViewById(R.id.img_hall38);
        imgHallKC39 = view.findViewById(R.id.img_hall39);
        imgHallKC40 = view.findViewById(R.id.img_hall40);


        cHallKC1.setOnClickListener(this); cHallKC11.setOnClickListener(this); cHallKC21.setOnClickListener(this); cHallKC31.setOnClickListener(this);
        cHallKC2.setOnClickListener(this); cHallKC12.setOnClickListener(this); cHallKC22.setOnClickListener(this); cHallKC32.setOnClickListener(this);
        cHallKC3.setOnClickListener(this); cHallKC13.setOnClickListener(this); cHallKC23.setOnClickListener(this); cHallKC33.setOnClickListener(this);
        cHallKC4.setOnClickListener(this); cHallKC14.setOnClickListener(this); cHallKC24.setOnClickListener(this); cHallKC34.setOnClickListener(this);
        cHallKC5.setOnClickListener(this); cHallKC15.setOnClickListener(this); cHallKC25.setOnClickListener(this); cHallKC35.setOnClickListener(this);
        cHallKC6.setOnClickListener(this); cHallKC16.setOnClickListener(this); cHallKC26.setOnClickListener(this); cHallKC36.setOnClickListener(this);
        cHallKC7.setOnClickListener(this); cHallKC17.setOnClickListener(this); cHallKC27.setOnClickListener(this); cHallKC37.setOnClickListener(this);
        cHallKC8.setOnClickListener(this); cHallKC18.setOnClickListener(this); cHallKC28.setOnClickListener(this); cHallKC38.setOnClickListener(this);
        cHallKC9.setOnClickListener(this); cHallKC19.setOnClickListener(this); cHallKC29.setOnClickListener(this); cHallKC39.setOnClickListener(this);
        cHallKC10.setOnClickListener(this); cHallKC20.setOnClickListener(this); cHallKC30.setOnClickListener(this); cHallKC40.setOnClickListener(this);

        cHallKC41.setOnClickListener(this);
        cHallKC42.setOnClickListener(this);
        cHallKC43.setOnClickListener(this);
        cHallKC44.setOnClickListener(this);

        kodeUker = view.findViewById(R.id.name4);
        KC data = getActivity().getIntent().getParcelableExtra(KODE_UKER4);
        String name = data.getKCname();
        kodeUker.setText(name);

        progressDialog = new ProgressDialog(BankingHallFragment.this.getContext());
        btnSave = view.findViewById(R.id.btn_saveHallKC);
        btnSave.setOnClickListener(this);

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
            case R.id.camera_hall1:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto1, REQUEST_CODE_CAMERA1);
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
            case R.id.camera_hall2:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto2, REQUEST_CODE_CAMERA2);
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
            case R.id.camera_hall3:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto3, REQUEST_CODE_CAMERA3);
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
            case R.id.camera_hall4:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto4 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto4, REQUEST_CODE_CAMERA4);
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
            case R.id.camera_hall5:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto5 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto5, REQUEST_CODE_CAMERA5);
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
            case R.id.camera_hall6:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mPhoto6 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mPhoto6, REQUEST_CODE_CAMERA6);
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
            case R.id.camera_hall7:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto7 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto7, REQUEST_CODE_CAMERA7);
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
            case R.id.camera_hall8:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto8 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto8, REQUEST_CODE_CAMERA8);
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
            case R.id.camera_hall9:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto9 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto9, REQUEST_CODE_CAMERA9);
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
            case R.id.camera_hall10:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto10 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto10, REQUEST_CODE_CAMERA10);
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
            case R.id.camera_hall11:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto11 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto11, REQUEST_CODE_CAMERA11);
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
            case R.id.camera_hall12:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto12 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto12, REQUEST_CODE_CAMERA12);
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
            case R.id.camera_hall13:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto13 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto13, REQUEST_CODE_CAMERA13);
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
            case R.id.camera_hall14:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto14 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto14, REQUEST_CODE_CAMERA14);
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
            case R.id.camera_hall15:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto15 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto15, REQUEST_CODE_CAMERA15);
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
            case R.id.camera_hall16:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto16 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto16, REQUEST_CODE_CAMERA16);
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
            case R.id.camera_hall17:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto17 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto17, REQUEST_CODE_CAMERA17);
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
            case R.id.camera_hall18:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto18 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto18, REQUEST_CODE_CAMERA18);
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
            case R.id.camera_hall19:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto19 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto19, REQUEST_CODE_CAMERA19);
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
            case R.id.camera_hall20:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto20 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto20, REQUEST_CODE_CAMERA20);
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
            case R.id.camera_hall21:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto21 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto21, REQUEST_CODE_CAMERA21);
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
            case R.id.camera_hall22:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto22 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto22, REQUEST_CODE_CAMERA22);
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
            case R.id.camera_hall23:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto23 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto23, REQUEST_CODE_CAMERA23);
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
            case R.id.camera_hall24:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto24 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto24, REQUEST_CODE_CAMERA24);
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
            case R.id.camera_hall25:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto25 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto25, REQUEST_CODE_CAMERA25);
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
            case R.id.camera_hall26:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mPhoto26 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mPhoto26, REQUEST_CODE_CAMERA26);
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
            case R.id.camera_hall27:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto27 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto27, REQUEST_CODE_CAMERA27);
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
            case R.id.camera_hall28:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto28 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto28, REQUEST_CODE_CAMERA28);
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
            case R.id.camera_hall29:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto29 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto29, REQUEST_CODE_CAMERA29);
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
            case R.id.camera_hall30:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto30 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto30, REQUEST_CODE_CAMERA30);
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
            case R.id.camera_hall31:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto31 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto31, REQUEST_CODE_CAMERA31);
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
            case R.id.camera_hall32:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mPhoto32 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mPhoto32, REQUEST_CODE_CAMERA32);
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
            case R.id.camera_hall33:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mPhoto33 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mPhoto33, REQUEST_CODE_CAMERA33);
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
            case R.id.camera_hall34:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto34 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto34, REQUEST_CODE_CAMERA34);
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
            case R.id.camera_hall35:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto35 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto35, REQUEST_CODE_CAMERA35);
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
            case R.id.camera_hall36:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto36 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto36, REQUEST_CODE_CAMERA36);
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
            case R.id.camera_hall37:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto37 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto37, REQUEST_CODE_CAMERA37);
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
            case R.id.camera_hall38:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mPhoto38 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mPhoto38, REQUEST_CODE_CAMERA38);
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
            case R.id.camera_hall39:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto39 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto39, REQUEST_CODE_CAMERA39);
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
            case R.id.camera_hall40:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto40 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto40, REQUEST_CODE_CAMERA40);
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
            case R.id.camera_hall41:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto41 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto41, REQUEST_CODE_CAMERA41);
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
            case R.id.camera_hall42:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto42 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto42, REQUEST_CODE_CAMERA42);
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
            case R.id.camera_hall43:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto43 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto43, REQUEST_CODE_CAMERA43);
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
            case R.id.camera_hall44:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto44 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto44, REQUEST_CODE_CAMERA44);
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
            case R.id.btn_saveHallKC:
                UploadImage();
                btnSave.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_item));
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_CODE_CAMERA1 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap1 = (Bitmap) data.getExtras().get("data");
            imgHallKC1.setImageBitmap(bitmap1);
            ImageToString1(getResizeBimap(bitmap1, 512));
        }

        if (REQUEST_CODE_CAMERA2 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap2 = (Bitmap) data.getExtras().get("data");
            imgHallKC2.setImageBitmap(bitmap2);
            ImageToString2(getResizeBimap(bitmap2, 512));
        }

        if (REQUEST_CODE_CAMERA3 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap3 = (Bitmap) data.getExtras().get("data");
            imgHallKC3.setImageBitmap(bitmap3);
            ImageToString3(getResizeBimap(bitmap3, 512));
        }

        if (REQUEST_CODE_CAMERA4 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap4 = (Bitmap) data.getExtras().get("data");
            imgHallKC4.setImageBitmap(bitmap4);
            ImageToString4(getResizeBimap(bitmap4, 512));
        }

        if (REQUEST_CODE_CAMERA5 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap5 = (Bitmap) data.getExtras().get("data");
            imgHallKC5.setImageBitmap(bitmap5);
            ImageToString5(getResizeBimap(bitmap5, 512));
        }

        if (REQUEST_CODE_CAMERA6 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap6 = (Bitmap) data.getExtras().get("data");
            imgHallKC5.setImageBitmap(bitmap6);
            ImageToString6(getResizeBimap(bitmap6, 512));
        }

        if (REQUEST_CODE_CAMERA7 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap7 = (Bitmap) data.getExtras().get("data");
            imgHallKC6.setImageBitmap(bitmap7);
            ImageToString7(getResizeBimap(bitmap7, 512));
        }

        if (REQUEST_CODE_CAMERA8 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap8 = (Bitmap) data.getExtras().get("data");
            imgHallKC8.setImageBitmap(bitmap8);
            ImageToString8(getResizeBimap(bitmap8, 512));
        }

        if (REQUEST_CODE_CAMERA9 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap9 = (Bitmap) data.getExtras().get("data");
            imgHallKC9.setImageBitmap(bitmap9);
            ImageToString9(getResizeBimap(bitmap9, 512));
        }

        if (REQUEST_CODE_CAMERA10 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap10 = (Bitmap) data.getExtras().get("data");
            imgHallKC10.setImageBitmap(bitmap10);
            ImageToString10(getResizeBimap(bitmap10, 512));
        }

        if (REQUEST_CODE_CAMERA11 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap11 = (Bitmap) data.getExtras().get("data");
            imgHallKC11.setImageBitmap(bitmap11);
            ImageToString11(getResizeBimap(bitmap11, 512));
        }

        if (REQUEST_CODE_CAMERA12 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap12 = (Bitmap) data.getExtras().get("data");
            imgHallKC12.setImageBitmap(bitmap12);
            ImageToString12(getResizeBimap(bitmap12, 512));
        }

        if (REQUEST_CODE_CAMERA13 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap13 = (Bitmap) data.getExtras().get("data");
            imgHallKC13.setImageBitmap(bitmap13);
            ImageToString13(getResizeBimap(bitmap13, 512));
        }

        if (REQUEST_CODE_CAMERA14 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap14 = (Bitmap) data.getExtras().get("data");
            imgHallKC14.setImageBitmap(bitmap14);
            ImageToString14(getResizeBimap(bitmap14, 512));
        }

        if (REQUEST_CODE_CAMERA15 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap15 = (Bitmap) data.getExtras().get("data");
            imgHallKC15.setImageBitmap(bitmap15);
            ImageToString15(getResizeBimap(bitmap15, 512));
        }

        if (REQUEST_CODE_CAMERA16 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap16 = (Bitmap) data.getExtras().get("data");
            imgHallKC16.setImageBitmap(bitmap16);
            ImageToString16(getResizeBimap(bitmap16, 512));
        }

        if (REQUEST_CODE_CAMERA17 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap17 = (Bitmap) data.getExtras().get("data");
            imgHallKC17.setImageBitmap(bitmap17);
            ImageToString17(getResizeBimap(bitmap17, 512));
        }

        if (REQUEST_CODE_CAMERA18 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap18 = (Bitmap) data.getExtras().get("data");
            imgHallKC18.setImageBitmap(bitmap18);
            ImageToString18(getResizeBimap(bitmap18, 512));
        }

        if (REQUEST_CODE_CAMERA19 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap19 = (Bitmap) data.getExtras().get("data");
            imgHallKC19.setImageBitmap(bitmap19);
            ImageToString19(getResizeBimap(bitmap19, 512));
        }

        if (REQUEST_CODE_CAMERA20 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap20 = (Bitmap) data.getExtras().get("data");
            imgHallKC20.setImageBitmap(bitmap20);
            ImageToString20(getResizeBimap(bitmap20, 512));
        }

        if (REQUEST_CODE_CAMERA21 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap21 = (Bitmap) data.getExtras().get("data");
            imgHallKC21.setImageBitmap(bitmap21);
            ImageToString21(getResizeBimap(bitmap21, 512));
        }

        if (REQUEST_CODE_CAMERA22 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap22 = (Bitmap) data.getExtras().get("data");
            imgHallKC22.setImageBitmap(bitmap22);
            ImageToString22(getResizeBimap(bitmap22, 512));
        }

        if (REQUEST_CODE_CAMERA23 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap23 = (Bitmap) data.getExtras().get("data");
            imgHallKC23.setImageBitmap(bitmap23);
            ImageToString23(getResizeBimap(bitmap23, 512));
        }

        if (REQUEST_CODE_CAMERA24 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap24 = (Bitmap) data.getExtras().get("data");
            imgHallKC24.setImageBitmap(bitmap24);
            ImageToString24(getResizeBimap(bitmap24, 512));
        }

        if (REQUEST_CODE_CAMERA25 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap25 = (Bitmap) data.getExtras().get("data");
            imgHallKC25.setImageBitmap(bitmap25);
            ImageToString25(getResizeBimap(bitmap25, 512));
        }

        if (REQUEST_CODE_CAMERA26 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap26 = (Bitmap) data.getExtras().get("data");
            imgHallKC26.setImageBitmap(bitmap26);
            ImageToString26(getResizeBimap(bitmap26, 512));
        }

        if (REQUEST_CODE_CAMERA27 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap27 = (Bitmap) data.getExtras().get("data");
            imgHallKC27.setImageBitmap(bitmap27);
            ImageToString27(getResizeBimap(bitmap27, 512));
        }

        if (REQUEST_CODE_CAMERA28 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap28 = (Bitmap) data.getExtras().get("data");
            imgHallKC28.setImageBitmap(bitmap28);
            ImageToString28(getResizeBimap(bitmap28, 512));
        }

        if (REQUEST_CODE_CAMERA29 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap29 = (Bitmap) data.getExtras().get("data");
            imgHallKC29.setImageBitmap(bitmap29);
            ImageToString29(getResizeBimap(bitmap29, 512));
        }

        if (REQUEST_CODE_CAMERA30 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap30 = (Bitmap) data.getExtras().get("data");
            imgHallK30.setImageBitmap(bitmap30);
            ImageToString30(getResizeBimap(bitmap30, 512));
        }

        if (REQUEST_CODE_CAMERA31 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap31 = (Bitmap) data.getExtras().get("data");
            imgHallKC31.setImageBitmap(bitmap31);
            ImageToString31(getResizeBimap(bitmap31, 512));
        }

        if (REQUEST_CODE_CAMERA32 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap32 = (Bitmap) data.getExtras().get("data");
            imgHallKC32.setImageBitmap(bitmap32);
            ImageToString32(getResizeBimap(bitmap32, 512));
        }

        if (REQUEST_CODE_CAMERA33 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap33 = (Bitmap) data.getExtras().get("data");
            imgHallKC33.setImageBitmap(bitmap33);
            ImageToString33(getResizeBimap(bitmap33, 512));
        }

        if (REQUEST_CODE_CAMERA34 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap34 = (Bitmap) data.getExtras().get("data");
            imgHallKC34.setImageBitmap(bitmap34);
            ImageToString34(getResizeBimap(bitmap34, 512));
        }

        if (REQUEST_CODE_CAMERA35 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap35 = (Bitmap) data.getExtras().get("data");
            imgHallKC35.setImageBitmap(bitmap35);
            ImageToString35(getResizeBimap(bitmap35, 512));
        }

        if (REQUEST_CODE_CAMERA36 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap36 = (Bitmap) data.getExtras().get("data");
            imgHallKC36.setImageBitmap(bitmap36);
            ImageToString36(getResizeBimap(bitmap36, 512));
        }

        if (REQUEST_CODE_CAMERA37 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap37 = (Bitmap) data.getExtras().get("data");
            imgHallKC37.setImageBitmap(bitmap37);
            ImageToString37(getResizeBimap(bitmap37,512));
        }

        if (REQUEST_CODE_CAMERA38 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap38 = (Bitmap) data.getExtras().get("data");
            imgHallKC38.setImageBitmap(bitmap38);
            ImageToString38(getResizeBimap(bitmap38, 512));
        }

        if (REQUEST_CODE_CAMERA39 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap39 = (Bitmap) data.getExtras().get("data");
            imgHallKC39.setImageBitmap(bitmap39);
            ImageToString39(getResizeBimap(bitmap39, 512));
        }

        if (REQUEST_CODE_CAMERA40 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap40 = (Bitmap) data.getExtras().get("data");
            imgHallKC40.setImageBitmap(bitmap40);
            ImageToString40(getResizeBimap(bitmap40, 512));
        }

        if (REQUEST_CODE_CAMERA41 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap41 = (Bitmap) data.getExtras().get("data");
            imgHallKC41.setImageBitmap(bitmap41);
            ImageToString41(getResizeBimap(bitmap41, 512));
        }

        if (REQUEST_CODE_CAMERA42 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap42 = (Bitmap) data.getExtras().get("data");
            imgHallKC42.setImageBitmap(bitmap42);
            ImageToString42(getResizeBimap(bitmap42, 512));
        }

        if (REQUEST_CODE_CAMERA43 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap43 = (Bitmap) data.getExtras().get("data");
            imgHallKC43.setImageBitmap(bitmap43);
            ImageToString43(getResizeBimap(bitmap43, 512));
        }

        if (REQUEST_CODE_CAMERA44 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap44 = (Bitmap) data.getExtras().get("data");
            imgHallKC44.setImageBitmap(bitmap44);
            ImageToString44(getResizeBimap(bitmap44, 512));
        }
    }

    private Bitmap getResizeBimap(Bitmap image, int maxSize){
        int widht = image.getWidth();
        int height = image.getHeight();

        float bitmapRotasi = (float) widht / (float) height;
        if (bitmapRotasi > 1){
            widht = maxSize;
            height = (int) (widht / bitmapRotasi);
        }else {
            height = maxSize;
            widht = (int) (height * bitmapRotasi);
        }

        return Bitmap.createScaledBitmap(image, widht, height, true);
    }

    private void ImageToString1(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString1 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString2(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString2 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString3(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString3 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString4(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString4 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString5(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString5 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString6(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString6 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString7(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString7 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString8(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString8 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString9(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString9 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString10(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString10 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString11(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString11 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString12(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString12 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString13(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString13 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString14(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString14 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString15(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString15 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString16(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString16 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString17(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString17 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString18(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString18 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString19(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString19 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString20(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString20 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString21(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString21 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString22(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString22 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString23(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString23 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString24(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString24 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString25(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString25 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString26(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString26 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString27(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString27 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString28(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString28 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString29(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString29 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString30(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString30 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString31(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString31 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString32(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString32 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString33(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString33 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString34(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString34 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString35(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString35 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString36(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString36 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString37(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString37 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString38(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString38 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString39(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString39 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString40(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString40 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString41(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString41 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString42(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString42 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString43(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString43 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }
    private void ImageToString44(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimages = byteArrayOutputStream.toByteArray();
        encodeImageString44 = android.util.Base64.encodeToString(bytesimages, Base64.DEFAULT);
    }

    private void UploadImage(){
        if (checkNetworkConnection()){
            progressDialog.show();
            progressDialog.setMessage("Loading...");
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_IMAGE_BANGKING_KC_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            imgHallKC1.setImageResource(R.drawable.ic_check); imgHallKC21.setImageResource(R.drawable.ic_check); imgHallKC41.setImageResource(R.drawable.ic_check);
                            imgHallKC2.setImageResource(R.drawable.ic_check); imgHallKC22.setImageResource(R.drawable.ic_check); imgHallKC42.setImageResource(R.drawable.ic_check);
                            imgHallKC3.setImageResource(R.drawable.ic_check); imgHallKC23.setImageResource(R.drawable.ic_check); imgHallKC43.setImageResource(R.drawable.ic_check);
                            imgHallKC4.setImageResource(R.drawable.ic_check); imgHallKC24.setImageResource(R.drawable.ic_check); imgHallKC44.setImageResource(R.drawable.ic_check);
                            imgHallKC5.setImageResource(R.drawable.ic_check); imgHallKC25.setImageResource(R.drawable.ic_check);
                            imgHallKC6.setImageResource(R.drawable.ic_check); imgHallKC26.setImageResource(R.drawable.ic_check);
                            imgHallKC7.setImageResource(R.drawable.ic_check); imgHallKC27.setImageResource(R.drawable.ic_check);
                            imgHallKC8.setImageResource(R.drawable.ic_check); imgHallKC28.setImageResource(R.drawable.ic_check);
                            imgHallKC9.setImageResource(R.drawable.ic_check); imgHallKC29.setImageResource(R.drawable.ic_check);
                            imgHallKC10.setImageResource(R.drawable.ic_check); imgHallK30.setImageResource(R.drawable.ic_check);
                            imgHallKC11.setImageResource(R.drawable.ic_check); imgHallKC31.setImageResource(R.drawable.ic_check);
                            imgHallKC12.setImageResource(R.drawable.ic_check); imgHallKC32.setImageResource(R.drawable.ic_check);
                            imgHallKC13.setImageResource(R.drawable.ic_check); imgHallKC33.setImageResource(R.drawable.ic_check);
                            imgHallKC14.setImageResource(R.drawable.ic_check); imgHallKC34.setImageResource(R.drawable.ic_check);
                            imgHallKC15.setImageResource(R.drawable.ic_check); imgHallKC35.setImageResource(R.drawable.ic_check);
                            imgHallKC16.setImageResource(R.drawable.ic_check); imgHallKC36.setImageResource(R.drawable.ic_check);
                            imgHallKC17.setImageResource(R.drawable.ic_check); imgHallKC37.setImageResource(R.drawable.ic_check);
                            imgHallKC18.setImageResource(R.drawable.ic_check); imgHallKC37.setImageResource(R.drawable.ic_check);
                            imgHallKC19.setImageResource(R.drawable.ic_check); imgHallKC39.setImageResource(R.drawable.ic_check);
                            imgHallKC20.setImageResource(R.drawable.ic_check); imgHallKC40.setImageResource(R.drawable.ic_check);

                            rdButton1.setChecked(false); rdButton16.setChecked(false); rdButton31.setChecked(false);
                            rdButton2.setChecked(false); rdButton17.setChecked(false); rdButton32.setChecked(false);
                            rdButton3.setChecked(false); rdButton18.setChecked(false); rdButton33.setChecked(false);
                            rdButton4.setChecked(false); rdButton19.setChecked(false); rdButton34.setChecked(false);
                            rdButton5.setChecked(false); rdButton20.setChecked(false); rdButton35.setChecked(false);
                            rdButton6.setChecked(false); rdButton21.setChecked(false); rdButton36.setChecked(false);
                            rdButton7.setChecked(false); rdButton22.setChecked(false); rdButton37.setChecked(false);
                            rdButton8.setChecked(false); rdButton23.setChecked(false); rdButton38.setChecked(false);
                            rdButton9.setChecked(false); rdButton24.setChecked(false); rdButton38.setChecked(false);
                            rdButton10.setChecked(false); rdButton25.setChecked(false); rdButton39.setChecked(false);
                            rdButton11.setChecked(false); rdButton26.setChecked(false); rdButton40.setChecked(false);
                            rdButton12.setChecked(false); rdButton27.setChecked(false); rdButton41.setChecked(false);
                            rdButton13.setChecked(false); rdButton28.setChecked(false); rdButton42.setChecked(false);
                            rdButton14.setChecked(false); rdButton29.setChecked(false); rdButton43.setChecked(false);
                            rdButton15.setChecked(false); rdButton30.setChecked(false); rdButton44.setChecked(false);
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
                    }else {
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
                        params.put("", encodeImageString11);
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
                    }else {
                        params.put("", encodeImageString19);
                    }
                    if (encodeImageString20 != null){
                        params.put("upload20", encodeImageString20);
                    }else{
                        params.put("", encodeImageString20);
                    }
                    if (encodeImageString21 != null){
                        params.put("upload21", encodeImageString21);
                    }else{
                        params.put("", encodeImageString21);
                    }
                    if (encodeImageString22 != null){
                        params.put("upload22", encodeImageString22);
                    }else{
                        params.put("", encodeImageString22);
                    }
                    if (encodeImageString23 != null){
                        params.put("upload23", encodeImageString23);
                    }else{
                        params.put("", encodeImageString23);
                    }
                    if (encodeImageString24 != null){
                        params.put("upload24", encodeImageString24);
                    }else{
                        params.put("", encodeImageString24);
                    }
                    if (encodeImageString25 != null){
                        params.put("upload25", encodeImageString25);
                    }else{
                        params.put("", encodeImageString25);
                    }
                    if (encodeImageString26 != null){
                        params.put("upload26", encodeImageString26);
                    }else{
                        params.put("", encodeImageString26);
                    }
                    if (encodeImageString27 != null){
                        params.put("upload27", encodeImageString27);
                    }else{
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
                        params.put("",encodeImageString29);
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
                    }else{
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
                    }else{
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
                    if (rdButton15 != null) {
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
                        params.put("stnd17", rdButton16.getText().toString());
                    }else {
                        params.put("", rdButton17.toString());
                    }
                    if (rdButton18 != null){
                        params.put("stnd18", rdButton18.getText().toString());
                    }else {
                        params.put("", rdButton18.toString());
                    }
                    if (rdButton19 !=  null){
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
                    encodeImageString7 == null || encodeImageString8 == null || encodeImageString9 == null || encodeImageString10 == null || encodeImageString11 == null || encodeImageString12 == null || encodeImageString13 == null ||
                    encodeImageString14 == null || encodeImageString15 == null || encodeImageString16 == null || encodeImageString17 == null || encodeImageString18 == null || encodeImageString19 == null || encodeImageString20 == null ||
                    encodeImageString21 == null || encodeImageString22 == null || encodeImageString23 == null || encodeImageString24 == null || encodeImageString25 == null || encodeImageString26 == null || encodeImageString27 == null ||
                    encodeImageString28 == null || encodeImageString29 == null || encodeImageString30 == null || encodeImageString31 == null || encodeImageString32 == null || encodeImageString33 == null || encodeImageString34 == null ||
                    encodeImageString35 == null || encodeImageString36 == null || encodeImageString37 == null || encodeImageString38 == null || encodeImageString39 == null || encodeImageString40 == null || encodeImageString41 == null ||
                    encodeImageString42 == null || encodeImageString43 == null || encodeImageString44 == null){
                        Toast toast = Toast.makeText(getContext(), "Foto harus diisi", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                    }

                    if (rdButton1 == null || rdButton2 == null || rdButton3 == null || rdButton4 == null || rdButton5 == null || rdButton6 == null || rdButton7 == null || rdButton8 == null || rdButton9 == null || rdButton10 == null ||
                    rdButton11 == null || rdButton12 == null || rdButton13 == null || rdButton14 == null || rdButton15 == null || rdButton16 == null || rdButton17 == null || rdButton18 == null || rdButton19 == null || rdButton20 == null ||
                    rdButton21 == null || rdButton22 == null || rdButton23 == null || rdButton24 == null || rdButton25 == null || rdButton26 == null || rdButton27 == null || rdButton28 == null || rdButton29 == null || rdButton30 == null ||
                    rdButton31 == null || rdButton32 == null || rdButton33 == null || rdButton34 == null || rdButton35 == null || rdButton36 == null || rdButton37 == null || rdButton38 == null || rdButton39 == null || rdButton40 == null ||
                    rdButton41 == null || rdButton42 == null || rdButton43 == null || rdButton44 == null){

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

    public boolean checkNetworkConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}