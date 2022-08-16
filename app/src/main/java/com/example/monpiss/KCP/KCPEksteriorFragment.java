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

public class KCPEksteriorFragment extends Fragment implements View.OnClickListener {

    public static final String KODE_UKER9 = "kode_uker9";

    private RadioGroup rdGroup1, rdGroup2, rdGroup3, rdGroup4, rdGroup5, rdGroup6, rdGroup7, rdGroup8, rdGroup9, rdGroup10,
            rdGroup11, rdGroup12, rdGroup13, rdGroup14, rdGroup15, rdGroup16, rdGroup17;
    private RadioButton rdButton1, rdButton2, rdButton3, rdButton4, rdButton5, rdButton6, rdButton7, rdButton8, rdButton9, rdButton10,
            rdButton11, rdButton12, rdButton13, rdButton14, rdButton15, rdButton16, rdButton17;
    private ProgressDialog progressDialog;
    private Button btnSave;
    private TextView kodeUker;
    private String encodeImageString1, encodeImageString2, encodeImageString3, encodeImageString4, encodeImageString5, encodeImageString6, encodeImageString7,
            encodeImageString8, encodeImageString9, encodeImageString10, encodeImageString11, encodeImageString12, encodeImageString13, encodeImageString14, encodeImageString15, encodeImageString16, encodeImageString17;
    private ImageView cEkstKCP1, cEkstKCP2, cEkstKCP3, cEkstKCP4, cEkstKCP5, cEkstKCP6, cEkstKCP7, cEkstKCP8, cEkstKCP9,
            cEkstKCP10, cEkstKCP11, cEkstKCP12, cEkstKCP13, cEkstKCP14, cEkstKCP15, cEkstKCP16, cEkstKCP17;

    private ImageView imgEkstKCP1, imgEkstKCP2, imgEkstKCP3, imgEkstKCP4, imgEkstKCP5, imgEkstKCP6, imgEkstKCP7, imgEkstKCP8,
            imgEkstKCP9, imgEkstKCP10, imgEkstKCP11,imgEkstKCP12, imgEkstKCP13,imgEkstKCP14, imgEkstKCP15, imgEkstKCP16, imgEkstKCP17;

    private static final int CODE_CAMERA = 0; private static final int CODE_CAMERA11 = 11;
    private static final int CODE_CAMERA1 = 1; private static final int CODE_CAMERA12 = 12;
    private static final int CODE_CAMERA2 = 2; private static final int CODE_CAMERA13 = 13;
    private static final int CODE_CAMERA3 = 3; private static final int CODE_CAMERA14 = 14;
    private static final int CODE_CAMERA4 = 4; private static final int CODE_CAMERA15 = 15;
    private static final int CODE_CAMERA5 = 5; private static final int CODE_CAMERA16 = 16;
    private static final int CODE_CAMERA6 = 6;
    private static final int CODE_CAMERA7 = 7;
    private static final int CODE_CAMERA8 = 8;
    private static final int CODE_CAMERA9 = 9;
    private static final int CODE_CAMERA10 = 10;

    public KCPEksteriorFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static KCPEksteriorFragment newInstance(String param1, String param2) {
        KCPEksteriorFragment fragment = new KCPEksteriorFragment();
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
        View view = inflater.inflate(R.layout.fragment_kcp_eksterior, container, false);

        cEkstKCP1 = view.findViewById(R.id.camera_ekst_kcp1);
        cEkstKCP2 = view.findViewById(R.id.camera_ekst_kcp2);
        cEkstKCP3 = view.findViewById(R.id.camera_ekst_kcp3);
        cEkstKCP4 = view.findViewById(R.id.camera_ekst_kcp4);
        cEkstKCP5 = view.findViewById(R.id.camera_ekst_kcp5);
        cEkstKCP6 = view.findViewById(R.id.camera_ekst_kcp6);
        cEkstKCP7 = view.findViewById(R.id.camera_ekst_kcp7);
        cEkstKCP8 = view.findViewById(R.id.camera_ekst_kcp8);
        cEkstKCP9 = view.findViewById(R.id.camera_ekst_kcp9);
        cEkstKCP10 = view.findViewById(R.id.camera_ekst_kcp10);
        cEkstKCP11 = view.findViewById(R.id.camera_ekst_kcp11);
        cEkstKCP12 = view.findViewById(R.id.camera_ekst_kcp12);
        cEkstKCP13 = view.findViewById(R.id.camera_ekst_kcp13);
        cEkstKCP14 = view.findViewById(R.id.camera_ekst_kcp14);
        cEkstKCP15 = view.findViewById(R.id.camera_ekst_kcp15);
        cEkstKCP16 = view.findViewById(R.id.camera_ekst_kcp16);
        cEkstKCP17 = view.findViewById(R.id.camera_ekst_kcp17);

        imgEkstKCP1 = view.findViewById(R.id.img_ekst_kcp1);
        imgEkstKCP2 = view.findViewById(R.id.img_ekst_kcp2);
        imgEkstKCP3 = view.findViewById(R.id.img_ekst_kcp3);
        imgEkstKCP4 = view.findViewById(R.id.img_ekst_kcp4);
        imgEkstKCP5 = view.findViewById(R.id.img_ekst_kcp5);
        imgEkstKCP6 = view.findViewById(R.id.img_ekst_kcp6);
        imgEkstKCP7 = view.findViewById(R.id.img_ekst_kcp7);
        imgEkstKCP8 = view.findViewById(R.id.img_ekst_kcp8);
        imgEkstKCP9 = view.findViewById(R.id.img_ekst_kcp9);
        imgEkstKCP10 = view.findViewById(R.id.img_ekst_kcp10);
        imgEkstKCP11 = view.findViewById(R.id.img_ekst_kcp11);
        imgEkstKCP12 = view.findViewById(R.id.img_ekst_kcp12);
        imgEkstKCP13 = view.findViewById(R.id.img_ekst_kcp13);
        imgEkstKCP14 = view.findViewById(R.id.img_ekst_kcp14);
        imgEkstKCP15 = view.findViewById(R.id.img_ekst_kcp15);
        imgEkstKCP16 = view.findViewById(R.id.img_ekst_kcp16);
        imgEkstKCP17 = view.findViewById(R.id.img_ekst_kcp17);

        rdGroup1 = view.findViewById(R.id.btn_pilihEkstKCP1);
        rdGroup2 = view.findViewById(R.id.btn_pilihEkstKCP2);
        rdGroup3 = view.findViewById(R.id.btn_pilihEkstKCP3);
        rdGroup4 = view.findViewById(R.id.btn_pilihEkstKCP4);
        rdGroup5 = view.findViewById(R.id.btn_pilihEkstKCP5);
        rdGroup6 = view.findViewById(R.id.btn_pilihEkstKCP6);
        rdGroup7 = view.findViewById(R.id.btn_pilihEkstKCP7);
        rdGroup8 = view.findViewById(R.id.btn_pilihEkstKCP8);
        rdGroup9 = view.findViewById(R.id.btn_pilihEkstKCP9);
        rdGroup10 = view.findViewById(R.id.btn_pilihEkstKCP10);
        rdGroup11 = view.findViewById(R.id.btn_pilihEkstKCP11);
        rdGroup12 = view.findViewById(R.id.btn_pilihEkstKCP12);
        rdGroup13 = view.findViewById(R.id.btn_pilihEkstKCP13);
        rdGroup14 = view.findViewById(R.id.btn_pilihEkstKCP14);
        rdGroup15 = view.findViewById(R.id.btn_pilihEkstKCP15);
        rdGroup16 = view.findViewById(R.id.btn_pilihEkstKCP16);
        rdGroup17 = view.findViewById(R.id.btn_pilihEkstKCP17);

        btnSave = view.findViewById(R.id.btn_saveEkstKCP);
        progressDialog = new ProgressDialog(KCPEksteriorFragment.this.getContext());
        kodeUker = view.findViewById(R.id.name9);
        KCP data = getActivity().getIntent().getParcelableExtra(KODE_UKER9);
        String name = data.getNameKCP();
        kodeUker.setText(name);


        cEkstKCP1.setOnClickListener(this);
        cEkstKCP2.setOnClickListener(this);
        cEkstKCP3.setOnClickListener(this);
        cEkstKCP4.setOnClickListener(this);
        cEkstKCP5.setOnClickListener(this);
        cEkstKCP6.setOnClickListener(this);
        cEkstKCP7.setOnClickListener(this);
        cEkstKCP8.setOnClickListener(this);
        cEkstKCP9.setOnClickListener(this);
        cEkstKCP10.setOnClickListener(this);
        cEkstKCP11.setOnClickListener(this);
        cEkstKCP12.setOnClickListener(this);
        cEkstKCP13.setOnClickListener(this);
        cEkstKCP14.setOnClickListener(this);
        cEkstKCP15.setOnClickListener(this);
        cEkstKCP16.setOnClickListener(this);
        cEkstKCP17.setOnClickListener(this);
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

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.camera_ekst_kcp1:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstKcp1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstKcp1, CODE_CAMERA);
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
            case R.id.camera_ekst_kcp2:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstKcp2 =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstKcp2, CODE_CAMERA1);
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
            case R.id.camera_ekst_kcp3:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mEkstKcp3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mEkstKcp3, CODE_CAMERA2);
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
            case R.id.camera_ekst_kcp4:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstKcp4 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstKcp4, CODE_CAMERA3);
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
            case R.id.camera_ekst_kcp5:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstKcp5 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstKcp5, CODE_CAMERA4);
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
            case R.id.camera_ekst_kcp6:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mEkstKcp6 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mEkstKcp6, CODE_CAMERA5);
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
            case R.id.camera_ekst_kcp7:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstKcp7 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstKcp7, CODE_CAMERA6);
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
            case R.id.camera_ekst_kcp8:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstKcp8 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstKcp8, CODE_CAMERA7);
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
            case R.id.camera_ekst_kcp9:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstKcp9 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstKcp9, CODE_CAMERA8);
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
            case R.id.camera_ekst_kcp10:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstKcp10 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstKcp10, CODE_CAMERA9);
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
            case R.id.camera_ekst_kcp11:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstKcp11 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstKcp11, CODE_CAMERA10);
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
            case R.id.camera_ekst_kcp12:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstKcp12 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstKcp12, CODE_CAMERA11);
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
            case R.id.camera_ekst_kcp13:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstKcp13 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstKcp13, CODE_CAMERA12);
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
            case R.id.camera_ekst_kcp14:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstKcp14 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstKcp14, CODE_CAMERA13);
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
            case R.id.camera_ekst_kcp15:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstKcp15 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstKcp15, CODE_CAMERA14);
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
            case R.id.camera_ekst_kcp16:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstKcp16 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstKcp16, CODE_CAMERA15);
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
            case R.id.camera_ekst_kcp17:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstKcp17 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstKcp17, CODE_CAMERA16);
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
            case R.id.btn_saveEkstKCP:
                UploadImage();
                btnSave.startAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.anim_item));
                break;
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (CODE_CAMERA == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap1 = (Bitmap) data.getExtras().get("data");
            imgEkstKCP1.setImageBitmap(bitmap1);
            ImageToString1(getResizebitmap(bitmap1, 512));
        }

        if (CODE_CAMERA1 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap2 = (Bitmap) data.getExtras().get("data");
            imgEkstKCP2.setImageBitmap(bitmap2);
            ImageToString2(getResizebitmap(bitmap2, 512));
        }

        if (CODE_CAMERA2 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap3 = (Bitmap) data.getExtras().get("data");
            imgEkstKCP3.setImageBitmap(bitmap3);
            ImageToString3(getResizebitmap(bitmap3, 512));
        }

        if (CODE_CAMERA3 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap4 = (Bitmap) data.getExtras().get("data");
            imgEkstKCP4.setImageBitmap(bitmap4);
            ImageToString4(getResizebitmap(bitmap4, 512));
        }

        if (CODE_CAMERA4 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap5 = (Bitmap) data.getExtras().get("data");
            imgEkstKCP5.setImageBitmap(bitmap5);
            ImageToString5(getResizebitmap(bitmap5, 512));
        }

        if (CODE_CAMERA5 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap6 = (Bitmap) data.getExtras().get("data");
            imgEkstKCP6.setImageBitmap(bitmap6);
            ImageToString6(getResizebitmap(bitmap6, 512));
        }

        if (CODE_CAMERA6 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap7 = (Bitmap) data.getExtras().get("data");
            imgEkstKCP7.setImageBitmap(bitmap7);
            ImageToString7(getResizebitmap(bitmap7, 512));
        }

        if (CODE_CAMERA7 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap8 = (Bitmap) data.getExtras().get("data");
            imgEkstKCP8.setImageBitmap(bitmap8);
            ImageToString8(getResizebitmap(bitmap8, 512));
        }

        if (CODE_CAMERA8 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap9 = (Bitmap) data.getExtras().get("data");
            imgEkstKCP9.setImageBitmap(bitmap9);
            ImageToString9(getResizebitmap(bitmap9, 512));
        }

        if (CODE_CAMERA9 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap10 = (Bitmap) data.getExtras().get("data");
            imgEkstKCP10.setImageBitmap(bitmap10);
            ImageToString10(getResizebitmap(bitmap10, 512));
        }

        if (CODE_CAMERA10 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap11 = (Bitmap) data.getExtras().get("data");
            imgEkstKCP11.setImageBitmap(bitmap11);
            ImageToString11(getResizebitmap(bitmap11, 512));
        }

        if (CODE_CAMERA11 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap12 = (Bitmap) data.getExtras().get("data");
            imgEkstKCP12.setImageBitmap(bitmap12);
            ImageToString12(getResizebitmap(bitmap12, 512));
        }

        if (CODE_CAMERA12 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap13 = (Bitmap) data.getExtras().get("data");
            imgEkstKCP13.setImageBitmap(bitmap13);
            ImageToString13(getResizebitmap(bitmap13, 512));
        }

        if (CODE_CAMERA13 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap14 = (Bitmap) data.getExtras().get("data");
            imgEkstKCP14.setImageBitmap(bitmap14);
            ImageToString14(getResizebitmap(bitmap14, 512));
        }

        if (CODE_CAMERA14 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap15 = (Bitmap) data.getExtras().get("data");
            imgEkstKCP15.setImageBitmap(bitmap15);
            ImageToString15(getResizebitmap(bitmap15, 512));
        }

        if (CODE_CAMERA15 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap16 = (Bitmap) data.getExtras().get("data");
            imgEkstKCP16.setImageBitmap(bitmap16);
            ImageToString16(getResizebitmap(bitmap16, 512));
        }

        if (CODE_CAMERA16 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap17 = (Bitmap) data.getExtras().get("data");
            imgEkstKCP17.setImageBitmap(bitmap17);
            ImageToString17(getResizebitmap(bitmap17, 512));
        }
    }

    private Bitmap getResizebitmap(Bitmap image, int maxSize){
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
        byte[] bytes = byteArrayOutputStream.toByteArray();
        encodeImageString4 = android.util.Base64.encodeToString(bytes, Base64.DEFAULT);
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

    private void UploadImage(){
        if (CheckNetworkConnection()){
            progressDialog.show();
            progressDialog.setMessage("Loading...");
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_IMAGE_EKST_KCP_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            imgEkstKCP1.setImageResource(R.drawable.ic_check); rdButton1.setChecked(false);
                            imgEkstKCP2.setImageResource(R.drawable.ic_check); rdButton2.setChecked(false);
                            imgEkstKCP3.setImageResource(R.drawable.ic_check); rdButton3.setChecked(false);
                            imgEkstKCP4.setImageResource(R.drawable.ic_check); rdButton4.setChecked(false);
                            imgEkstKCP5.setImageResource(R.drawable.ic_check); rdButton5.setChecked(false);
                            imgEkstKCP6.setImageResource(R.drawable.ic_check); rdButton6.setChecked(false);
                            imgEkstKCP7.setImageResource(R.drawable.ic_check); rdButton7.setChecked(false);
                            imgEkstKCP8.setImageResource(R.drawable.ic_check); rdButton8.setChecked(false);
                            imgEkstKCP9.setImageResource(R.drawable.ic_check); rdButton9.setChecked(false);
                            imgEkstKCP10.setImageResource(R.drawable.ic_check); rdButton10.setChecked(false);
                            imgEkstKCP11.setImageResource(R.drawable.ic_check); rdButton11.setChecked(false);
                            imgEkstKCP12.setImageResource(R.drawable.ic_check); rdButton12.setChecked(false);
                            imgEkstKCP13.setImageResource(R.drawable.ic_check); rdButton13.setChecked(false);
                            imgEkstKCP14.setImageResource(R.drawable.ic_check); rdButton14.setChecked(false);
                            imgEkstKCP15.setImageResource(R.drawable.ic_check); rdButton15.setChecked(false);
                            imgEkstKCP16.setImageResource(R.drawable.ic_check); rdButton16.setChecked(false);
                            imgEkstKCP17.setImageResource(R.drawable.ic_check); rdButton17.setChecked(false);
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
                    }else{
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
                    if (encodeImageString1 == null || encodeImageString2 == null || encodeImageString3 == null || encodeImageString4 == null || encodeImageString5 == null ||
                    encodeImageString6 == null || encodeImageString7 == null || encodeImageString8 == null || encodeImageString9 == null || encodeImageString10 == null ||
                    encodeImageString11 == null || encodeImageString12 == null || encodeImageString13 == null || encodeImageString14 == null || encodeImageString15 == null ||
                    encodeImageString16 == null || encodeImageString17 == null){
                        Toast toast = Toast.makeText(getContext(), "Foto harus diisi", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                    }

                    if (rdButton1 == null || rdButton2 == null || rdButton3 == null || rdButton4 == null || rdButton5 == null || rdButton6 == null || rdButton7 == null || rdButton8 == null ||
                    rdButton9 == null || rdButton10 == null || rdButton11 == null || rdButton12 == null || rdButton13 == null || rdButton14 == null || rdButton15 == null || rdButton16 == null ||
                    rdButton17 == null){
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