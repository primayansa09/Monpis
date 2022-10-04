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

public class ATMFragment extends Fragment implements View.OnClickListener {

    public static final String KODE_UKER3 = "kode_uker3";

    private RadioGroup rdGroup1, rdGroup2, rdGroup3, rdGroup4, rdGroup5, rdGroup6, rdGroup7, rdGroup8, rdGroup9, rdGroup10,
            rdGroup11, rdGroup12, rdGroup13, rdGroup14, rdGroup15, rdGroup16, rdGroup17, rdGroup18, rdGroup19, rdGroup20,
            rdGroup21, rdGroup22, rdGroup23, rdGroup24, rdGroup25, rdGroup26;

    private RadioButton rdButton1, rdButton2, rdButton3, rdButton4, rdButton5, rdButton6, rdButton7, rdButton8, rdButton9, rdButton10,
            rdButton11, rdButton12, rdButton13, rdButton14, rdButton15, rdButton16, rdButton17, rdButton18, rdButton19, rdButton20, rdButton21,
            rdButton22, rdButton23, rdButton24, rdButton25, rdButton26;

    private RadioButton mStandar1, mStandar2, mStandar3, mStandar4, mStandar5, mStandar6, mStandar7, mStandar8, mStandar9, mStandar10, mStandar11,
            mStandar12, mStandar13, mStandar14, mStandar15, mStandar16, mStandar17, mStandar18, mStandar19, mStandar20, mStandar21, mStandar22, mStandar23, mStandar24, mStandar25, mStandar26;

    private String encodeImageString1, encodeImageString2, encodeImageString3, encodeImageString4, encodeImageString5, encodeImageString6, encodeImageString7,
            encodeImageString8, encodeImageString9, encodeImageString10, encodeImageString11, encodeImageString12, encodeImageString13, encodeImageString14, encodeImageString15, encodeImageString16,
            encodeImageString17, encodeImageString18, encodeImageString19, encodeImageString20, encodeImageString21, encodeImageString22, encodeImageString23, encodeImageString24,
            encodeImageString25, encodeImageString26;

    private ImageView cAtmKc1, cAtmKc2, cAtmKc3, cAtmKc4, cAtmKc5, cAtmKc6, cAtmKc7, cAtmKc8, cAtmKc9, cAtmKc10,
            cAtmKc11, cAtmKc12, cAtmKc13, cAtmKc14, cAtmKc15, cAtmKc16, cAtmKc17, cAtmKc18, cAtmKc19, cAtmKc20,
            cAtmKc21, cAtmKc22, cAtmKc23, cAtmKc24, cAtmKc25, cAtmKc26;

    private ImageView imgAtmKc1, imgAtmKc2, imgAtmKc3, imgAtmKc4, imgAtmKc5, imgAtmKc6, imgAtmKc7, imgAtmKc8, imgAtmKc9, imgAtmKc10,
            imgAtmKc11, imgAtmKc12, imgAtmKc13, imgAtmKc14, imgAtmKc15, imgAtmKc16, imgAtmKc17, imgAtmKc18, imgAtmKc19, imgAtmKc20,
            imgAtmKc21, imgAtmKc22, imgAtmKc23, imgAtmKc24, imgAtmKc25, imgAtmKc26;

    private TextView kodeUker, mHasil;
    private Button btnSave;
    private ProgressDialog progressDialog;

    private static final int REQUEST_CODE_CAMERA = 0;
    private static final int REQUEST_CODE_CAMERA1 = 1;
    private static final int REQUEST_CODE_CAMERA2 = 2;
    private static final int REQUEST_CODE_CAMERA3 = 3;
    private static final int REQUEST_CODE_CAMERA4 = 4;
    private static final int REQUEST_CODE_CAMERA5 = 5;
    private static final int REQUEST_CODE_CAMERA6 = 6;
    private static final int REQUEST_CODE_CAMERA7 = 7;
    private static final int REQUEST_CODE_CAMERA8 = 8;
    private static final int REQUEST_CODE_CAMERA9 = 9;
    private static final int REQUEST_CODE_CAMERA10 = 10;
    private static final int REQUEST_CODE_CAMERA11 = 11;
    private static final int REQUEST_CODE_CAMERA12 = 12;
    private static final int REQUEST_CODE_CAMERA13 = 13;
    private static final int REQUEST_CODE_CAMERA14 = 14;
    private static final int REQUEST_CODE_CAMERA15 = 15;
    private static final int REQUEST_CODE_CAMERA16 = 16;
    private static final int REQUEST_CODE_CAMERA17 = 17;
    private static final int REQUEST_CODE_CAMERA18 = 18;
    private static final int REQUEST_CODE_CAMERA19 = 19;
    private static final int REQUEST_CODE_CAMERA20 = 20;
    private static final int REQUEST_CODE_CAMERA21 = 21;
    private static final int REQUEST_CODE_CAMERA22 = 22;
    private static final int REQUEST_CODE_CAMERA23 = 23;
    private static final int REQUEST_CODE_CAMERA24 = 24;
    private static final int REQUEST_CODE_CAMERA25 = 25;

    public ATMFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ATMFragment newInstance(String param1, String param2) {
        ATMFragment fragment = new ATMFragment();
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
        View view = inflater.inflate(R.layout.fragment_a_t_m, container, false);

            cAtmKc1 = view.findViewById(R.id.camera_atm1);  cAtmKc11 = view.findViewById(R.id.camera_atm11);  cAtmKc21 = view.findViewById(R.id.camera_atm21);
            cAtmKc2 = view.findViewById(R.id.camera_atm2);  cAtmKc12 = view.findViewById(R.id.camera_atm12);  cAtmKc22 = view.findViewById(R.id.camera_atm22);
            cAtmKc3 = view.findViewById(R.id.camera_atm3);  cAtmKc13 = view.findViewById(R.id.camera_atm13);  cAtmKc23 = view.findViewById(R.id.camera_atm23);
            cAtmKc4 = view.findViewById(R.id.camera_atm4);  cAtmKc14 = view.findViewById(R.id.camera_atm14);  cAtmKc24 = view.findViewById(R.id.camera_atm24);
            cAtmKc5 = view.findViewById(R.id.camera_atm5);  cAtmKc15 = view.findViewById(R.id.camera_atm15);  cAtmKc25 = view.findViewById(R.id.camera_atm25);
            cAtmKc6 = view.findViewById(R.id.camera_atm6);  cAtmKc16 = view.findViewById(R.id.camera_atm16);  cAtmKc26 = view.findViewById(R.id.camera_atm26);
            cAtmKc7 = view.findViewById(R.id.camera_atm7);  cAtmKc17 = view.findViewById(R.id.camera_atm17);
            cAtmKc8 = view.findViewById(R.id.camera_atm8);  cAtmKc18 = view.findViewById(R.id.camera_atm18);
            cAtmKc9 = view.findViewById(R.id.camera_atm9);  cAtmKc19 = view.findViewById(R.id.camera_atm19);
            cAtmKc10 = view.findViewById(R.id.camera_atm10); cAtmKc20 = view.findViewById(R.id.camera_atm20);

            imgAtmKc1 = view.findViewById(R.id.img_atm1);  imgAtmKc11 = view.findViewById(R.id.img_atm11);   imgAtmKc21 = view.findViewById(R.id.img_atm21);
            imgAtmKc2 = view.findViewById(R.id.img_atm2);  imgAtmKc12 = view.findViewById(R.id.img_atm12);   imgAtmKc22 = view.findViewById(R.id.img_atm22);
            imgAtmKc3 = view.findViewById(R.id.img_atm3);  imgAtmKc13 = view.findViewById(R.id.img_atm13);   imgAtmKc23 = view.findViewById(R.id.img_atm23);
            imgAtmKc4 = view.findViewById(R.id.img_atm4);  imgAtmKc14 = view.findViewById(R.id.img_atm14);   imgAtmKc24 = view.findViewById(R.id.img_atm24);
            imgAtmKc5 = view.findViewById(R.id.img_atm5);  imgAtmKc15 = view.findViewById(R.id.img_atm15);   imgAtmKc25 = view.findViewById(R.id.img_atm25);
            imgAtmKc6 = view.findViewById(R.id.img_atm6);  imgAtmKc16 = view.findViewById(R.id.img_atm16);   imgAtmKc26 = view.findViewById(R.id.img_atm26);
            imgAtmKc7 = view.findViewById(R.id.img_atm7);  imgAtmKc17 = view.findViewById(R.id.img_atm17);
            imgAtmKc8 = view.findViewById(R.id.img_atm8);  imgAtmKc18 = view.findViewById(R.id.img_atm18);
            imgAtmKc9 = view.findViewById(R.id.img_atm9);  imgAtmKc19 = view.findViewById(R.id.img_atm19);
            imgAtmKc10 = view.findViewById(R.id.img_atm10); imgAtmKc20 = view.findViewById(R.id.img_atm20);

            rdGroup1 = view.findViewById(R.id.rg_Atm1); rdGroup11 = view.findViewById(R.id.rg_Atm11); rdGroup21 = view.findViewById(R.id.rg_Atm21);
            rdGroup2 = view.findViewById(R.id.rg_Atm2); rdGroup12 = view.findViewById(R.id.rg_Atm12); rdGroup22 = view.findViewById(R.id.rg_Atm22);
            rdGroup3 = view.findViewById(R.id.rg_Atm3); rdGroup13 = view.findViewById(R.id.rg_Atm13); rdGroup23 = view.findViewById(R.id.rg_Atm23);
            rdGroup4 = view.findViewById(R.id.rg_Atm4); rdGroup14 = view.findViewById(R.id.rg_Atm14); rdGroup24 = view.findViewById(R.id.rg_Atm24);
            rdGroup5 = view.findViewById(R.id.rg_Atm5); rdGroup15 = view.findViewById(R.id.rg_Atm15); rdGroup25 = view.findViewById(R.id.rg_Atm25);
            rdGroup6 = view.findViewById(R.id.rg_Atm6); rdGroup16 = view.findViewById(R.id.rg_Atm16); rdGroup26 = view.findViewById(R.id.rg_Atm26);
            rdGroup7 = view.findViewById(R.id.rg_Atm7); rdGroup17 = view.findViewById(R.id.rg_Atm17);
            rdGroup8 = view.findViewById(R.id.rg_Atm8); rdGroup18 = view.findViewById(R.id.rg_Atm18);
            rdGroup9 = view.findViewById(R.id.rg_Atm9); rdGroup19 = view.findViewById(R.id.rg_Atm19);
            rdGroup10 = view.findViewById(R.id.rg_Atm10); rdGroup20 = view.findViewById(R.id.rg_Atm20);

            mStandar1 = view.findViewById(R.id.rb_standarAtm1); mStandar11 = view.findViewById(R.id.rb_standarAtm11); mStandar21 = view.findViewById(R.id.rb_standarAtm21);
            mStandar2 = view.findViewById(R.id.rb_standarAtm2); mStandar12 = view.findViewById(R.id.rb_standarAtm12); mStandar22 = view.findViewById(R.id.rb_standarAtm22);
            mStandar3 = view.findViewById(R.id.rb_standarAtm3); mStandar13 = view.findViewById(R.id.rb_standarAtm13); mStandar23 = view.findViewById(R.id.rb_standarAtm23);
            mStandar4 = view.findViewById(R.id.rb_standarAtm4); mStandar14 = view.findViewById(R.id.rb_standarAtm14); mStandar24 = view.findViewById(R.id.rb_standarAtm24);
            mStandar5 = view.findViewById(R.id.rb_standarAtm5); mStandar15 = view.findViewById(R.id.rb_standarAtm15); mStandar25 = view.findViewById(R.id.rb_standarAtm25);
            mStandar6 = view.findViewById(R.id.rb_standarAtm6); mStandar16 = view.findViewById(R.id.rb_standarAtm16); mStandar26 = view.findViewById(R.id.rb_standarAtm26);
            mStandar7 = view.findViewById(R.id.rb_standarAtm7); mStandar17 = view.findViewById(R.id.rb_standarAtm17);
            mStandar8 = view.findViewById(R.id.rb_standarAtm8); mStandar18 = view.findViewById(R.id.rb_standarAtm18);
            mStandar9 = view.findViewById(R.id.rb_standarAtm9); mStandar19 = view.findViewById(R.id.rb_standarAtm19);
            mStandar10 = view.findViewById(R.id.rb_standarAtm10); mStandar20 = view.findViewById(R.id.rb_standarAtm20);

        cAtmKc1.setOnClickListener(this);  cAtmKc11.setOnClickListener(this); cAtmKc21.setOnClickListener(this);
        cAtmKc2.setOnClickListener(this);  cAtmKc12.setOnClickListener(this); cAtmKc22.setOnClickListener(this);
        cAtmKc3.setOnClickListener(this);  cAtmKc13.setOnClickListener(this); cAtmKc23.setOnClickListener(this);
        cAtmKc4.setOnClickListener(this);  cAtmKc14.setOnClickListener(this); cAtmKc24.setOnClickListener(this);
        cAtmKc5.setOnClickListener(this);  cAtmKc15.setOnClickListener(this); cAtmKc25.setOnClickListener(this);
        cAtmKc6.setOnClickListener(this);  cAtmKc16.setOnClickListener(this); cAtmKc26.setOnClickListener(this);
        cAtmKc7.setOnClickListener(this);  cAtmKc17.setOnClickListener(this);
        cAtmKc8.setOnClickListener(this);  cAtmKc18.setOnClickListener(this);
        cAtmKc9.setOnClickListener(this);  cAtmKc19.setOnClickListener(this);
        cAtmKc10.setOnClickListener(this); cAtmKc20.setOnClickListener(this);

        kodeUker = view.findViewById(R.id.name3);
        mHasil = view.findViewById(R.id.hasil_monitoring);
        KC data = getActivity().getIntent().getParcelableExtra(KODE_UKER3);
        String name = data.getKCname();
        kodeUker.setText(name);

        progressDialog = new ProgressDialog(ATMFragment.this.getContext());
        btnSave = view.findViewById(R.id.btn_saveAtmKC);
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
                rdButton18 = getActivity().findViewById(checkedId);
            }
        });
        rdGroup19.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton19 = getActivity().findViewById(checkedId);
            }
        });
        rdGroup20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton20 = getActivity().findViewById(checkedId);
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

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.camera_atm1:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto1, REQUEST_CODE_CAMERA);
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
            case R.id.camera_atm2:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto2, REQUEST_CODE_CAMERA1);
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
            case R.id.camera_atm3:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto3, REQUEST_CODE_CAMERA2);
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
            case R.id.camera_atm4:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mphoto4 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mphoto4, REQUEST_CODE_CAMERA3);
                           }

                           @Override
                           public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                           }

                           @Override
                           public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                           }
                       }).check();
                break;
            case R.id.camera_atm5:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto5 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto5, REQUEST_CODE_CAMERA4);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                            }
                        }).check();
                break;
            case R.id.camera_atm6:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto6 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto6, REQUEST_CODE_CAMERA5);
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
            case R.id.camera_atm7:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto7 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto7,REQUEST_CODE_CAMERA6);
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
            case R.id.camera_atm8:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto8 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto8, REQUEST_CODE_CAMERA7);
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
            case R.id.camera_atm9:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mphoto9 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mphoto9, REQUEST_CODE_CAMERA8);
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
            case R.id.camera_atm10:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto10 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto10, REQUEST_CODE_CAMERA9);
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
            case R.id.camera_atm11:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto11 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto11,REQUEST_CODE_CAMERA10);
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
            case R.id.camera_atm12:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto12 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto12, REQUEST_CODE_CAMERA11);
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
            case R.id.camera_atm13:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto13 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto13, REQUEST_CODE_CAMERA12);
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
            case R.id.camera_atm14:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto14 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto14, REQUEST_CODE_CAMERA13);
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
            case R.id.camera_atm15:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto15 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto15, REQUEST_CODE_CAMERA14);
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
            case R.id.camera_atm16:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto16 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto16, REQUEST_CODE_CAMERA15);
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
            case R.id.camera_atm17:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mphoto17 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mphoto17, REQUEST_CODE_CAMERA16);
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
            case R.id.camera_atm18:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto18 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto18, REQUEST_CODE_CAMERA17);
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
            case R.id.camera_atm19:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mphoto19 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mphoto19, REQUEST_CODE_CAMERA18);
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
            case R.id.camera_atm20:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto20 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto20, REQUEST_CODE_CAMERA19);
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
            case R.id.camera_atm21:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto21 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto21, REQUEST_CODE_CAMERA20);
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
            case R.id.camera_atm22:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mphoto22 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mphoto22, REQUEST_CODE_CAMERA21);
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
            case R.id.camera_atm23:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto23 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto23, REQUEST_CODE_CAMERA22);
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
            case R.id.camera_atm24:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto24 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto24, REQUEST_CODE_CAMERA23);
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
            case R.id.camera_atm25:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mphoto25 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mphoto25, REQUEST_CODE_CAMERA24);
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
            case R.id.camera_atm26:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mphoto26 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mphoto26, REQUEST_CODE_CAMERA25);
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
            case R.id.btn_saveAtmKC:

                if (rdButton1 == mStandar1 && rdButton2 == mStandar2 && rdButton3 == mStandar3 && rdButton4 == mStandar4 && rdButton5 == mStandar5 && rdButton6 == mStandar6 && rdButton7 == mStandar7 &&
                    rdButton8 == mStandar8 && rdButton9 == mStandar9 && rdButton10 == mStandar10 && rdButton11 == mStandar11 && rdButton12 == mStandar12 && rdButton13 == mStandar13 && rdButton14 == mStandar14 &&
                    rdButton15 == mStandar15 && rdButton16 == mStandar16 && rdButton17 == mStandar17 && rdButton18 == mStandar18 && rdButton19 == mStandar19 && rdButton20 == mStandar20 &&
                    rdButton21 == mStandar21 && rdButton22 == mStandar22 && rdButton23 == mStandar23 && rdButton24 == mStandar24 && rdButton25 == mStandar25 && rdButton26 == mStandar26){
                    mHasil.setText("100%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 == mStandar3 && rdButton4 == mStandar4 && rdButton5 == mStandar5 && rdButton6 == mStandar6 && rdButton7 == mStandar7 &&
                        rdButton8 == mStandar8 && rdButton9 == mStandar9 && rdButton10 == mStandar10 && rdButton11 == mStandar11 && rdButton12 == mStandar12 && rdButton13 == mStandar13 && rdButton14 == mStandar14 &&
                        rdButton15 == mStandar15 && rdButton16 == mStandar16 && rdButton17 == mStandar17 && rdButton18 == mStandar18 && rdButton19 == mStandar19 && rdButton20 == mStandar20 &&
                        rdButton21 == mStandar21 && rdButton22 == mStandar22 && rdButton23 == mStandar23 && rdButton24 == mStandar24 && rdButton25 == mStandar25 && rdButton26 == mStandar26){
                    mHasil.setText("95%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 == mStandar5 && rdButton6 == mStandar6 && rdButton7 == mStandar7 &&
                        rdButton8 == mStandar8 && rdButton9 == mStandar9 && rdButton10 == mStandar10 && rdButton11 == mStandar11 && rdButton12 == mStandar12 && rdButton13 == mStandar13 && rdButton14 == mStandar14 &&
                        rdButton15 == mStandar15 && rdButton16 == mStandar16 && rdButton17 == mStandar17 && rdButton18 == mStandar18 && rdButton19 == mStandar19 && rdButton20 == mStandar20 &&
                        rdButton21 == mStandar21 && rdButton22 == mStandar22 && rdButton23 == mStandar23 && rdButton24 == mStandar24 && rdButton25 == mStandar25 && rdButton26 == mStandar26){
                    mHasil.setText("90%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 && rdButton7 == mStandar7 &&
                        rdButton8 == mStandar8 && rdButton9 == mStandar9 && rdButton10 == mStandar10 && rdButton11 == mStandar11 && rdButton12 == mStandar12 && rdButton13 == mStandar13 && rdButton14 == mStandar14 &&
                        rdButton15 == mStandar15 && rdButton16 == mStandar16 && rdButton17 == mStandar17 && rdButton18 == mStandar18 && rdButton19 == mStandar19 && rdButton20 == mStandar20 &&
                        rdButton21 == mStandar21 && rdButton22 == mStandar22 && rdButton23 == mStandar23 && rdButton24 == mStandar24 && rdButton25 == mStandar25 && rdButton26 == mStandar26){
                    mHasil.setText("85%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 && rdButton7 != mStandar7 &&
                        rdButton8 != mStandar8 && rdButton9 == mStandar9 && rdButton10 == mStandar10 && rdButton11 == mStandar11 && rdButton12 == mStandar12 && rdButton13 == mStandar13 && rdButton14 == mStandar14 &&
                        rdButton15 == mStandar15 && rdButton16 == mStandar16 && rdButton17 == mStandar17 && rdButton18 == mStandar18 && rdButton19 == mStandar19 && rdButton20 == mStandar20 &&
                        rdButton21 == mStandar21 && rdButton22 == mStandar22 && rdButton23 == mStandar23 && rdButton24 == mStandar24 && rdButton25 == mStandar25 && rdButton26 == mStandar26){
                    mHasil.setText("80%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 && rdButton7 != mStandar7 &&
                        rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 != mStandar10 && rdButton11 == mStandar11 && rdButton12 == mStandar12 && rdButton13 == mStandar13 && rdButton14 == mStandar14 &&
                        rdButton15 == mStandar15 && rdButton16 == mStandar16 && rdButton17 == mStandar17 && rdButton18 == mStandar18 && rdButton19 == mStandar19 && rdButton20 == mStandar20 &&
                        rdButton21 == mStandar21 && rdButton22 == mStandar22 && rdButton23 == mStandar23 && rdButton24 == mStandar24 && rdButton25 == mStandar25 && rdButton26 == mStandar26){
                    mHasil.setText("75");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 && rdButton7 != mStandar7 &&
                        rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 != mStandar10 && rdButton11 != mStandar11 && rdButton12 != mStandar12 && rdButton13 == mStandar13 && rdButton14 == mStandar14 &&
                        rdButton15 == mStandar15 && rdButton16 == mStandar16 && rdButton17 == mStandar17 && rdButton18 == mStandar18 && rdButton19 == mStandar19 && rdButton20 == mStandar20 &&
                        rdButton21 == mStandar21 && rdButton22 == mStandar22 && rdButton23 == mStandar23 && rdButton24 == mStandar24 && rdButton25 == mStandar25 && rdButton26 == mStandar26){
                    mHasil.setText("70%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 && rdButton7 != mStandar7 &&
                        rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 != mStandar10 && rdButton11 != mStandar11 && rdButton12 != mStandar12 && rdButton13 != mStandar13 && rdButton14 != mStandar14 &&
                        rdButton15 == mStandar15 && rdButton16 == mStandar16 && rdButton17 == mStandar17 && rdButton18 == mStandar18 && rdButton19 == mStandar19 && rdButton20 == mStandar20 &&
                        rdButton21 == mStandar21 && rdButton22 == mStandar22 && rdButton23 == mStandar23 && rdButton24 == mStandar24 && rdButton25 == mStandar25 && rdButton26 == mStandar26){
                    mHasil.setText("65%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 && rdButton7 != mStandar7 &&
                        rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 != mStandar10 && rdButton11 != mStandar11 && rdButton12 != mStandar12 && rdButton13 != mStandar13 && rdButton14 != mStandar14 &&
                        rdButton15 != mStandar15 && rdButton16 != mStandar16 && rdButton17 == mStandar17 && rdButton18 == mStandar18 && rdButton19 == mStandar19 && rdButton20 == mStandar20 &&
                        rdButton21 == mStandar21 && rdButton22 == mStandar22 && rdButton23 == mStandar23 && rdButton24 == mStandar24 && rdButton25 == mStandar25 && rdButton26 == mStandar26){
                    mHasil.setText("60%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 && rdButton7 != mStandar7 &&
                        rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 != mStandar10 && rdButton11 != mStandar11 && rdButton12 != mStandar12 && rdButton13 != mStandar13 && rdButton14 != mStandar14 &&
                        rdButton15 != mStandar15 && rdButton16 != mStandar16 && rdButton17 != mStandar17 && rdButton18 != mStandar18 && rdButton19 == mStandar19 && rdButton20 == mStandar20 &&
                        rdButton21 == mStandar21 && rdButton22 == mStandar22 && rdButton23 == mStandar23 && rdButton24 == mStandar24 && rdButton25 == mStandar25 && rdButton26 == mStandar26){
                    mHasil.setText("55%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 && rdButton7 != mStandar7 &&
                        rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 != mStandar10 && rdButton11 != mStandar11 && rdButton12 != mStandar12 && rdButton13 != mStandar13 && rdButton14 != mStandar14 &&
                        rdButton15 != mStandar15 && rdButton16 != mStandar16 && rdButton17 != mStandar17 && rdButton18 != mStandar18 && rdButton19 != mStandar19 && rdButton20 != mStandar20 &&
                        rdButton21 == mStandar21 && rdButton22 == mStandar22 && rdButton23 == mStandar23 && rdButton24 == mStandar24 && rdButton25 == mStandar25 && rdButton26 == mStandar26){
                    mHasil.setText("50%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 && rdButton7 != mStandar7 &&
                        rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 != mStandar10 && rdButton11 != mStandar11 && rdButton12 != mStandar12 && rdButton13 != mStandar13 && rdButton14 != mStandar14 &&
                        rdButton15 != mStandar15 && rdButton16 != mStandar16 && rdButton17 != mStandar17 && rdButton18 != mStandar18 && rdButton19 != mStandar19 && rdButton20 != mStandar20 &&
                        rdButton21 != mStandar21 && rdButton22 == mStandar22 && rdButton23 == mStandar23 && rdButton24 == mStandar24 && rdButton25 == mStandar25 && rdButton26 == mStandar26){
                    mHasil.setText("45%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 && rdButton7 != mStandar7 &&
                        rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 != mStandar10 && rdButton11 != mStandar11 && rdButton12 != mStandar12 && rdButton13 != mStandar13 && rdButton14 != mStandar14 &&
                        rdButton15 != mStandar15 && rdButton16 != mStandar16 && rdButton17 != mStandar17 && rdButton18 != mStandar18 && rdButton19 != mStandar19 && rdButton20 != mStandar20 &&
                        rdButton21 != mStandar21 && rdButton22 != mStandar22 && rdButton23 == mStandar23 && rdButton24 == mStandar24 && rdButton25 == mStandar25 && rdButton26 == mStandar26){
                    mHasil.setText("40%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 && rdButton7 != mStandar7 &&
                        rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 != mStandar10 && rdButton11 != mStandar11 && rdButton12 != mStandar12 && rdButton13 != mStandar13 && rdButton14 != mStandar14 &&
                        rdButton15 != mStandar15 && rdButton16 != mStandar16 && rdButton17 != mStandar17 && rdButton18 != mStandar18 && rdButton19 != mStandar19 && rdButton20 != mStandar20 &&
                        rdButton21 != mStandar21 && rdButton22 != mStandar22 && rdButton23 != mStandar23 && rdButton24 == mStandar24 && rdButton25 == mStandar25 && rdButton26 == mStandar26){
                    mHasil.setText("35%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 && rdButton7 != mStandar7 &&
                        rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 != mStandar10 && rdButton11 != mStandar11 && rdButton12 != mStandar12 && rdButton13 != mStandar13 && rdButton14 != mStandar14 &&
                        rdButton15 != mStandar15 && rdButton16 != mStandar16 && rdButton17 != mStandar17 && rdButton18 != mStandar18 && rdButton19 != mStandar19 && rdButton20 != mStandar20 &&
                        rdButton21 != mStandar21 && rdButton22 != mStandar22 && rdButton23 != mStandar23 && rdButton24 != mStandar24 && rdButton25 == mStandar25 && rdButton26 == mStandar26){
                    mHasil.setText("30%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 && rdButton7 != mStandar7 &&
                        rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 != mStandar10 && rdButton11 != mStandar11 && rdButton12 != mStandar12 && rdButton13 != mStandar13 && rdButton14 != mStandar14 &&
                        rdButton15 != mStandar15 && rdButton16 != mStandar16 && rdButton17 != mStandar17 && rdButton18 != mStandar18 && rdButton19 != mStandar19 && rdButton20 != mStandar20 &&
                        rdButton21 != mStandar21 && rdButton22 != mStandar22 && rdButton23 != mStandar23 && rdButton24 != mStandar24 && rdButton25 != mStandar25 && rdButton26 == mStandar26){
                    mHasil.setText("20%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 && rdButton7 != mStandar7 &&
                        rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 != mStandar10 && rdButton11 != mStandar11 && rdButton12 != mStandar12 && rdButton13 != mStandar13 && rdButton14 != mStandar14 &&
                        rdButton15 != mStandar15 && rdButton16 != mStandar16 && rdButton17 != mStandar17 && rdButton18 != mStandar18 && rdButton19 != mStandar19 && rdButton20 != mStandar20 &&
                        rdButton21 != mStandar21 && rdButton22 != mStandar22 && rdButton23 != mStandar23 && rdButton24 != mStandar24 && rdButton25 != mStandar25 && rdButton26 != mStandar26){
                    mHasil.setText("0%");
                }else {
                    mHasil.setText("");
                }

                uploadImage();
                btnSave.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_item));
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_CODE_CAMERA == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap1 = (Bitmap) data.getExtras().get("data");
            imgAtmKc1.setImageBitmap(bitmap1);
            ImageToString1(getResizeBitmap(bitmap1, 512));
        }

        if (REQUEST_CODE_CAMERA1 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap2 = (Bitmap) data.getExtras().get("data");
            imgAtmKc2.setImageBitmap(bitmap2);
            ImageToString2(getResizeBitmap(bitmap2, 512));
        }

        if (REQUEST_CODE_CAMERA2 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap3 = (Bitmap) data.getExtras().get("data");
            imgAtmKc3.setImageBitmap(bitmap3);
            ImageToString3(getResizeBitmap(bitmap3, 512));
        }

        if (REQUEST_CODE_CAMERA3 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap4 = (Bitmap) data.getExtras().get("data");
            imgAtmKc4.setImageBitmap(bitmap4);
            ImageToString4(getResizeBitmap(bitmap4, 512));
        }

        if (REQUEST_CODE_CAMERA4 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap5 = (Bitmap) data.getExtras().get("data");
            imgAtmKc5.setImageBitmap(bitmap5);
            ImageToString5(getResizeBitmap(bitmap5, 512));
        }

        if (REQUEST_CODE_CAMERA5 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap6 = (Bitmap) data.getExtras().get("data");
            imgAtmKc6.setImageBitmap(bitmap6);
            ImageToString6(getResizeBitmap(bitmap6, 512));
        }

        if (REQUEST_CODE_CAMERA6 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap7 = (Bitmap) data.getExtras().get("data");
            imgAtmKc7.setImageBitmap(bitmap7);
            ImageToString7(getResizeBitmap(bitmap7, 512));
        }

        if (REQUEST_CODE_CAMERA7 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap8 = (Bitmap) data.getExtras().get("data");
            imgAtmKc8.setImageBitmap(bitmap8);
            ImageToString8(getResizeBitmap(bitmap8, 512));
        }

        if (REQUEST_CODE_CAMERA8 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap9 = (Bitmap) data.getExtras().get("data");
            imgAtmKc9.setImageBitmap(bitmap9);
            ImageToString9(getResizeBitmap(bitmap9, 512));
        }

        if (REQUEST_CODE_CAMERA9 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap10 = (Bitmap) data.getExtras().get("data");
            imgAtmKc10.setImageBitmap(bitmap10);
            ImageToString10(getResizeBitmap(bitmap10, 512));
        }

        if (REQUEST_CODE_CAMERA10 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap11 = (Bitmap) data.getExtras().get("data");
            imgAtmKc11.setImageBitmap(bitmap11);
            ImageToString11(getResizeBitmap(bitmap11, 512));
        }

        if (REQUEST_CODE_CAMERA11 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap12 = (Bitmap) data.getExtras().get("data");
            imgAtmKc12.setImageBitmap(bitmap12);
            ImageToString12(getResizeBitmap(bitmap12, 512));
        }

        if (REQUEST_CODE_CAMERA12 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap13 = (Bitmap) data.getExtras().get("data");
            imgAtmKc13.setImageBitmap(bitmap13);
            ImageToString13(getResizeBitmap(bitmap13, 512));
        }

        if (REQUEST_CODE_CAMERA13 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap14 = (Bitmap) data.getExtras().get("data");
            imgAtmKc14.setImageBitmap(bitmap14);
            ImageToString14(getResizeBitmap(bitmap14, 512));
        }

        if (REQUEST_CODE_CAMERA14 == requestCode && resultCode == Activity.RESULT_OK ){
            Bitmap bitmap15 = (Bitmap) data.getExtras().get("data");
            imgAtmKc15.setImageBitmap(bitmap15);
            ImageToString15(getResizeBitmap(bitmap15, 512));
        }

        if (REQUEST_CODE_CAMERA15 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap16 = (Bitmap) data.getExtras().get("data");
            imgAtmKc16.setImageBitmap(bitmap16);
            ImageToString16(getResizeBitmap(bitmap16, 512));
        }

        if (REQUEST_CODE_CAMERA16 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap17 = (Bitmap) data.getExtras().get("data");
            imgAtmKc17.setImageBitmap(bitmap17);
            ImageToString17(getResizeBitmap(bitmap17, 512));
        }

        if (REQUEST_CODE_CAMERA17 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap18 = (Bitmap) data.getExtras().get("data");
            imgAtmKc18.setImageBitmap(bitmap18);
            ImageToString18(getResizeBitmap(bitmap18, 512));
        }

        if (REQUEST_CODE_CAMERA18 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap19 = (Bitmap) data.getExtras().get("data");
            imgAtmKc19.setImageBitmap(bitmap19);
            ImageToString19(getResizeBitmap(bitmap19, 512));
        }

        if (REQUEST_CODE_CAMERA19 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap20 = (Bitmap) data.getExtras().get("data");
            imgAtmKc20.setImageBitmap(bitmap20);
            ImageToString20(getResizeBitmap(bitmap20, 512));
        }

        if (REQUEST_CODE_CAMERA20 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap21 = (Bitmap) data.getExtras().get("data");
            imgAtmKc21.setImageBitmap(bitmap21);
            ImageToString21(getResizeBitmap(bitmap21, 512));
        }

        if (REQUEST_CODE_CAMERA21 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap22 = (Bitmap) data.getExtras().get("data");
            imgAtmKc22.setImageBitmap(bitmap22);
            ImageToString22(getResizeBitmap(bitmap22, 512));
        }

        if (REQUEST_CODE_CAMERA22 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap23 = (Bitmap) data.getExtras().get("data");
            imgAtmKc23.setImageBitmap(bitmap23);
            ImageToString23(getResizeBitmap(bitmap23, 512));
        }

        if (REQUEST_CODE_CAMERA23 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap24 = (Bitmap) data.getExtras().get("data");
            imgAtmKc24.setImageBitmap(bitmap24);
            ImageToString24(getResizeBitmap(bitmap24, 512));
        }

        if (REQUEST_CODE_CAMERA24 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap25 = (Bitmap) data.getExtras().get("data");
            imgAtmKc25.setImageBitmap(bitmap25);
            ImageToString25(getResizeBitmap(bitmap25, 512));
        }

        if (REQUEST_CODE_CAMERA25 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap26 = (Bitmap) data.getExtras().get("data");
            imgAtmKc26.setImageBitmap(bitmap26);
            ImageToString26(getResizeBitmap(bitmap26, 512));
        }
    }

    private Bitmap getResizeBitmap(Bitmap image, int maxSize){
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

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString1 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString2(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString2 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString3(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString3 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString4(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString4 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString5(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString5 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString6(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString6 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString7(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString7 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString8(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString8 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString9(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString9 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString10(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString10 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString11(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString11 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString12(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString12 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString13(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString13 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString14(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString14 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString15(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString15 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString16(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString16 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString17(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString17 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString18(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString18 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString19(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString19 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString20(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString20 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString21(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString21 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString22(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString22 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString23(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString23 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString24(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString24 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString25(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString25 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }
    private void ImageToString26(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString26 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);

    }

    private void uploadImage(){
        if (checkNetworkConnection()){
            progressDialog.show();
            progressDialog.setMessage("Loading...");
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_IMAGE_ATM_KC_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            imgAtmKc1.setImageResource(R.drawable.ic_check); imgAtmKc11.setImageResource(R.drawable.ic_check);
                            imgAtmKc2.setImageResource(R.drawable.ic_check); imgAtmKc12.setImageResource(R.drawable.ic_check);
                            imgAtmKc3.setImageResource(R.drawable.ic_check); imgAtmKc13.setImageResource(R.drawable.ic_check);
                            imgAtmKc4.setImageResource(R.drawable.ic_check); imgAtmKc14.setImageResource(R.drawable.ic_check);
                            imgAtmKc5.setImageResource(R.drawable.ic_check); imgAtmKc15.setImageResource(R.drawable.ic_check);
                            imgAtmKc6.setImageResource(R.drawable.ic_check); imgAtmKc16.setImageResource(R.drawable.ic_check);
                            imgAtmKc7.setImageResource(R.drawable.ic_check); imgAtmKc17.setImageResource(R.drawable.ic_check);
                            imgAtmKc8.setImageResource(R.drawable.ic_check); imgAtmKc18.setImageResource(R.drawable.ic_check);
                            imgAtmKc9.setImageResource(R.drawable.ic_check); imgAtmKc19.setImageResource(R.drawable.ic_check);
                            imgAtmKc10.setImageResource(R.drawable.ic_check); imgAtmKc20.setImageResource(R.drawable.ic_check);

                            imgAtmKc21.setImageResource(R.drawable.ic_check);
                            imgAtmKc22.setImageResource(R.drawable.ic_check);
                            imgAtmKc23.setImageResource(R.drawable.ic_check);
                            imgAtmKc24.setImageResource(R.drawable.ic_check);
                            imgAtmKc25.setImageResource(R.drawable.ic_check);
                            imgAtmKc26.setImageResource(R.drawable.ic_check);
                            kodeUker.setText("");

                            Toast toast = Toast.makeText(getContext(), "Upload sukses", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
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
                    params.put("upload5", encodeImageString5);
                }else{
                    params.put("", encodeImageString5);
                }
                if (encodeImageString6 != null){
                    params.put("upload6", encodeImageString6);
                }else {
                    params.put("", encodeImageString6);
                }
                if (encodeImageString7 != null){
                    params.put("upload7", encodeImageString7);
                }else{
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
                }else{
                    params.put("", encodeImageString12);
                }
                if (encodeImageString13 != null){
                    params.put("upload13", encodeImageString13);
                }else {
                    params.put("", encodeImageString13);
                }
                if (encodeImageString14 != null){
                    params.put("upload14", encodeImageString14);
                }else{
                    params.put("", encodeImageString14);
                }
                if (encodeImageString15 != null){
                    params.put("upload15", encodeImageString15);
                }else {
                    params.put("", encodeImageString15);
                }
                if (encodeImageString16 != null){
                    params.put("upload16", encodeImageString16);
                }else{
                    params.put("", encodeImageString16);
                }
                if (encodeImageString17 != null){
                    params.put("upload17", encodeImageString17);
                }else{
                    params.put("", encodeImageString17);
                }
                if (encodeImageString18 != null){
                    params.put("upload18", encodeImageString18);
                }else{
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

                if (mHasil != null){
                    params.put("hasil", mHasil.getText().toString());
                }else {
                    params.put("", mHasil.toString());
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
                    encodeImageString7 == null || encodeImageString8 == null || encodeImageString9 == null || encodeImageString10 == null || encodeImageString11 == null ||
                    encodeImageString12 == null || encodeImageString13 == null || encodeImageString14 == null || encodeImageString15 == null || encodeImageString16 == null || encodeImageString17 == null ||
                    encodeImageString18 == null || encodeImageString19 == null || encodeImageString20 == null || encodeImageString21 == null || encodeImageString22 == null || encodeImageString23 == null ||
                    encodeImageString24 == null || encodeImageString25 == null || encodeImageString26 == null){

                        Toast toast = Toast.makeText(getContext(), "Foto harus diisi" , Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0,0);
                        toast.show();
                    }

                    if (rdButton1 == null || rdButton2 == null || rdButton3 == null || rdButton4 == null || rdButton5 == null || rdButton6 == null || rdButton7 == null || rdButton8 == null || rdButton9 == null ||
                        rdButton10 == null || rdButton11 == null || rdButton12 == null || rdButton13 == null || rdButton14 == null || rdButton15 == null || rdButton16 == null || rdButton17 == null || rdButton18 == null ||
                        rdButton19 == null || rdButton20 == null || rdButton21 == null || rdButton22 == null || rdButton23 == null || rdButton24 == null || rdButton25 == null || rdButton26 == null){

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