package com.example.monpiss.Unit;

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


public class UnitEksteriorFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String KODE_UKER14 = "kode_uker14";

    // TODO: Rename and change types of parameters
    private RadioGroup rdGroup1, rdGroup2, rdGroup3, rdGroup4, rdGroup5, rdGroup6, rdGroup7, rdGroup8, rdGroup9, rdGroup10, rdGroup11, rdGroup12,
            rdGroup13, rdGroup14, rdGroup15, rdGroup16, rdGroup17;
    private RadioButton rdButton1, rdButton2, rdButton3, rdButton4, rdButton5, rdButton6, rdButton7, rdButton8, rdButton9, rdButton10, rdButton11,rdButton12,
            rdButton13, rdButton14, rdButton15, rdButton16, rdButton17;
    private ProgressDialog progressDialog;
    private Button btnSave;
    private TextView kodeUker;
    private String mParam2, encodeImageString1, encodeImageString2, encodeImageString3, encodeImageString4, encodeImageString5, encodeImageString6, encodeImageString7, encodeImageString8,
    encodeImageString9, encodeimageString10, encodeImageString11, encodeImageString12, encodeImageString13, encodeimageString14, encodeImageString15, encodeImageString16, encodeImageString17 ;
    private ImageView imgEkstUnit1, imgEkstUnit2, imgEkstUnit3, imgEkstUnit4, imgEkstUnit5, imgEkstUnit6, imgEkstUnit7, imgEkstUnit8, imgEkstUnit9,
            imgEkstUnit10, imgEkstUnit11, imgEkstUnit12, imgEkstUnit13, imgEkstUnit14, imgEkstUnit15, imgEkstUnit16, imgEkstUnit17;

    private ImageView cEkstUnit1, cEkstUnit2, cEkstUnit3, cEkstUnit4, cEkstUnit5, cEkstUnit6, cEkstUnit7, cEkstUnit8, cEkstUnit9,
            cEkstUnit10, cEkstUnit11, cEkstUnit12, cEkstUnit13, cEkstUnit14, cEkstUnit15, cEkstUnit16, cEkstUnit17;

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

    public UnitEksteriorFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static UnitEksteriorFragment newInstance(String param1, String param2) {
        UnitEksteriorFragment fragment = new UnitEksteriorFragment();
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
        View view = inflater.inflate(R.layout.fragment_unit_eksterior, container, false);

        cEkstUnit1 = view.findViewById(R.id.camera_ekst_unit1);
        cEkstUnit2 = view.findViewById(R.id.camera_ekst_unit2);
        cEkstUnit3 = view.findViewById(R.id.camera_ekst_unit3);
        cEkstUnit4 = view.findViewById(R.id.camera_ekst_unit4);
        cEkstUnit5 = view.findViewById(R.id.camera_ekst_unit5);
        cEkstUnit6 = view.findViewById(R.id.camera_ekst_unit6);
        cEkstUnit7 = view.findViewById(R.id.camera_ekst_unit7);
        cEkstUnit8 = view.findViewById(R.id.camera_ekst_unit8);
        cEkstUnit9 = view.findViewById(R.id.camera_ekst_unit9);
        cEkstUnit10 = view.findViewById(R.id.camera_ekst_unit10);
        cEkstUnit11 = view.findViewById(R.id.camera_ekst_unit11);
        cEkstUnit12 = view.findViewById(R.id.camera_ekst_unit12);
        cEkstUnit13 = view.findViewById(R.id.camera_ekst_unit13);
        cEkstUnit14 = view.findViewById(R.id.camera_ekst_unit14);
        cEkstUnit15 = view.findViewById(R.id.camera_ekst_unit15);
        cEkstUnit16 = view.findViewById(R.id.camera_ekst_unit16);
        cEkstUnit17 = view.findViewById(R.id.camera_ekst_unit17);

        rdGroup1 = view.findViewById(R.id.btn_pilihEkstUnit1);
        rdGroup2 = view.findViewById(R.id.btn_pilihEkstUnit2);
        rdGroup3 = view.findViewById(R.id.btn_pilihEkstUnit3);
        rdGroup4 = view.findViewById(R.id.btn_pilihEkstUnit4);
        rdGroup5 = view.findViewById(R.id.btn_pilihEkstUnit5);
        rdGroup6 = view.findViewById(R.id.btn_pilihEkstUnit6);
        rdGroup7 = view.findViewById(R.id.btn_pilihEkstUnit7);
        rdGroup8 = view.findViewById(R.id.btn_pilihEkstUnit8);
        rdGroup9 = view.findViewById(R.id.btn_pilihEkstUnit9);
        rdGroup10 = view.findViewById(R.id.btn_pilihEkstUnit10);
        rdGroup11 = view.findViewById(R.id.btn_pilihEkstUnit11);
        rdGroup12 = view.findViewById(R.id.btn_pilihEkstUnit12);
        rdGroup13 = view.findViewById(R.id.btn_pilihEkstUnit13);
        rdGroup14 = view.findViewById(R.id.btn_pilihEkstUnit14);
        rdGroup15 = view.findViewById(R.id.btn_pilihEkstUnit15);
        rdGroup16 = view.findViewById(R.id.btn_pilihEkstUnit16);
        rdGroup17 = view.findViewById(R.id.btn_pilihEkstUnit17);

        imgEkstUnit1 = view.findViewById(R.id.img_ekst_unit1);
        imgEkstUnit2 = view.findViewById(R.id.img_ekst_unit2);
        imgEkstUnit3 = view.findViewById(R.id.img_ekst_unit3);
        imgEkstUnit4 = view.findViewById(R.id.img_ekst_unit4);
        imgEkstUnit5 = view.findViewById(R.id.img_ekst_unit5);
        imgEkstUnit6 = view.findViewById(R.id.img_ekst_unit6);
        imgEkstUnit7 = view.findViewById(R.id.img_ekst_unit7);
        imgEkstUnit8 = view.findViewById(R.id.img_ekst_unit8);
        imgEkstUnit9 = view.findViewById(R.id.img_ekst_unit9);
        imgEkstUnit10 = view.findViewById(R.id.img_ekst_unit10);
        imgEkstUnit11 = view.findViewById(R.id.img_ekst_unit11);
        imgEkstUnit12 = view.findViewById(R.id.img_ekst_unit12);
        imgEkstUnit13 = view.findViewById(R.id.img_ekst_unit13);
        imgEkstUnit14 = view.findViewById(R.id.img_ekst_unit14);
        imgEkstUnit15 = view.findViewById(R.id.img_ekst_unit15);
        imgEkstUnit16 = view.findViewById(R.id.img_ekst_unit16);
        imgEkstUnit17 = view.findViewById(R.id.img_ekst_unit17);

        progressDialog = new ProgressDialog(UnitEksteriorFragment.this.getContext());
        btnSave = view.findViewById(R.id.btn_saveEkstUnit);
        kodeUker = view.findViewById(R.id.name14);
        Unit data = getActivity().getIntent().getParcelableExtra(KODE_UKER14);
        String name = data.getNameUnit();
        kodeUker.setText(name);

        cEkstUnit1.setOnClickListener(this);
        cEkstUnit2.setOnClickListener(this);
        cEkstUnit3.setOnClickListener(this);
        cEkstUnit4.setOnClickListener(this);
        cEkstUnit5.setOnClickListener(this);
        cEkstUnit6.setOnClickListener(this);
        cEkstUnit7.setOnClickListener(this);
        cEkstUnit8.setOnClickListener(this);
        cEkstUnit9.setOnClickListener(this);
        cEkstUnit10.setOnClickListener(this);
        cEkstUnit11.setOnClickListener(this);
        cEkstUnit12.setOnClickListener(this);
        cEkstUnit13.setOnClickListener(this);
        cEkstUnit14.setOnClickListener(this);
        cEkstUnit15.setOnClickListener(this);
        cEkstUnit16.setOnClickListener(this);
        cEkstUnit17.setOnClickListener(this);
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
            case R.id.camera_ekst_unit1:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstUnit1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstUnit1, CODE_CAMERA);
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
            case R.id.camera_ekst_unit2:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mEkstUnit2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mEkstUnit2, CODE_CAMERA1);
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
            case R.id.camera_ekst_unit3:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstUnit3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstUnit3, CODE_CAMERA2);
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
            case R.id.camera_ekst_unit4:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstUnit4 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstUnit4, CODE_CAMERA3);
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
            case R.id.camera_ekst_unit5:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstUnit5 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstUnit5, CODE_CAMERA4);
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
            case R.id.camera_ekst_unit6:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstUnit6 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstUnit6, CODE_CAMERA5);
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
            case R.id.camera_ekst_unit7:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstUnit7 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstUnit7, CODE_CAMERA6);
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
            case R.id.camera_ekst_unit8:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstUnit8 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstUnit8, CODE_CAMERA7);
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
            case R.id.camera_ekst_unit9:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstUnit9 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstUnit9, CODE_CAMERA8);
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
            case R.id.camera_ekst_unit10:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstUnit10 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstUnit10, CODE_CAMERA9);
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
            case R.id.camera_ekst_unit11:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstUnit11 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstUnit11, CODE_CAMERA10);
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
            case R.id.camera_ekst_unit12:
              Dexter.withContext(getContext().getApplicationContext())
                      .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                      .withListener(new PermissionListener() {
                          @Override
                          public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                              Intent mEkstunit12 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                              startActivityForResult(mEkstunit12, CODE_CAMERA11);
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
            case R.id.camera_ekst_unit13:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstUnit13 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstUnit13, CODE_CAMERA12);
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
            case R.id.camera_ekst_unit14:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mEkstunit14 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mEkstunit14, CODE_CAMERA13);
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
            case R.id.camera_ekst_unit15:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstUnit15 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstUnit15, CODE_CAMERA14);
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
            case R.id.camera_ekst_unit16:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mEkstUnit16 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mEkstUnit16, CODE_CAMERA15);
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
            case R.id.camera_ekst_unit17:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mEkstUnit17 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mEkstUnit17, CODE_CAMERA16);
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
            case R.id.btn_saveEkstUnit:
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
            imgEkstUnit1.setImageBitmap(bitmap1);
            ImageToString1(getResizeBitmap(bitmap1, 512));
        }

        if (CODE_CAMERA1 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap2 = (Bitmap) data.getExtras().get("data");
            imgEkstUnit2.setImageBitmap(bitmap2);
            ImageToString2(getResizeBitmap(bitmap2, 512));
        }

        if (CODE_CAMERA2 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap3 = (Bitmap) data.getExtras().get("data");
            imgEkstUnit3.setImageBitmap(bitmap3);
            ImageToString3(getResizeBitmap(bitmap3, 512));
        }

        if (CODE_CAMERA3 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap4 = (Bitmap) data.getExtras().get("data");
            imgEkstUnit4.setImageBitmap(bitmap4);
            ImageToString4(getResizeBitmap(bitmap4, 512));
        }

        if (CODE_CAMERA4 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap5 = (Bitmap) data.getExtras().get("data");
            imgEkstUnit5.setImageBitmap(bitmap5);
            ImageToString5(getResizeBitmap(bitmap5, 512));
        }

        if (CODE_CAMERA5 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap6 = (Bitmap) data.getExtras().get("data");
            imgEkstUnit6.setImageBitmap(bitmap6);
            ImageToString6(getResizeBitmap(bitmap6, 512));
        }

        if (CODE_CAMERA6 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap7 = (Bitmap) data.getExtras().get("data");
            imgEkstUnit7.setImageBitmap(bitmap7);
            ImageToString7(getResizeBitmap(bitmap7, 512));
        }

        if (CODE_CAMERA7 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap8 = (Bitmap) data.getExtras().get("data");
            imgEkstUnit8.setImageBitmap(bitmap8);
            ImageToString8(getResizeBitmap(bitmap8, 512));
        }

        if (CODE_CAMERA8 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap9 = (Bitmap) data.getExtras().get("data");
            imgEkstUnit9.setImageBitmap(bitmap9);
            ImageToString9(getResizeBitmap(bitmap9, 512));
        }

        if (CODE_CAMERA9 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap10 = (Bitmap) data.getExtras().get("data");
            imgEkstUnit10.setImageBitmap(bitmap10);
            ImageToString10(getResizeBitmap(bitmap10, 512));
        }

        if (CODE_CAMERA10 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap11 = (Bitmap) data.getExtras().get("data");
            imgEkstUnit11.setImageBitmap(bitmap11);
            ImageToString11(getResizeBitmap(bitmap11, 512));
        }

        if (CODE_CAMERA11 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap12 = (Bitmap) data.getExtras().get("data");
            imgEkstUnit12.setImageBitmap(bitmap12);
            ImageToString12(getResizeBitmap(bitmap12, 512));
        }

        if (CODE_CAMERA12 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap13 = (Bitmap) data.getExtras().get("data");
            imgEkstUnit13.setImageBitmap(bitmap13);
            ImageToString13(getResizeBitmap(bitmap13, 512));
        }

        if (CODE_CAMERA13 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap14 = (Bitmap) data.getExtras().get("data");
            imgEkstUnit14.setImageBitmap(bitmap14);
            ImageToString14(getResizeBitmap(bitmap14, 512));
        }

        if (CODE_CAMERA14 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap15 = (Bitmap) data.getExtras().get("data");
            imgEkstUnit15.setImageBitmap(bitmap15);
            ImageTostring15(getResizeBitmap(bitmap15, 512));
        }

        if (CODE_CAMERA15 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap16 = (Bitmap) data.getExtras().get("data");
            imgEkstUnit16.setImageBitmap(bitmap16);
            ImageToString16(getResizeBitmap(bitmap16, 512));
        }

        if (CODE_CAMERA16 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap17 = (Bitmap) data.getExtras().get("data");
            imgEkstUnit17.setImageBitmap(bitmap17);
            ImageToString17(getResizeBitmap(bitmap17, 512));
        }
    }

    private Bitmap getResizeBitmap(Bitmap image, int maxSize){
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRotasi = (float) width / (float) height;
        if (bitmapRotasi > 1){
            width = maxSize;
            height = (int) (width / bitmapRotasi);
        }else {
            height = maxSize;
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
    protected void ImageToString8(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString8 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    protected void ImageToString9(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString9 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    protected void ImageToString10(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeimageString10 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
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
        encodeimageString14 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageTostring15(Bitmap bitmap){
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

    private void uploadImage(){
        if (CheckNetworkConnection()){
            progressDialog.show();
            progressDialog.setMessage("Loading...");
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_IMAGE_EKST_UNIT_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            imgEkstUnit1.setImageResource(R.drawable.ic_check);
                            imgEkstUnit2.setImageResource(R.drawable.ic_check);
                            imgEkstUnit3.setImageResource(R.drawable.ic_check);
                            imgEkstUnit4.setImageResource(R.drawable.ic_check);
                            imgEkstUnit5.setImageResource(R.drawable.ic_check);
                            imgEkstUnit6.setImageResource(R.drawable.ic_check);
                            imgEkstUnit7.setImageResource(R.drawable.ic_check);
                            imgEkstUnit8.setImageResource(R.drawable.ic_check);
                            imgEkstUnit9.setImageResource(R.drawable.ic_check);
                            imgEkstUnit10.setImageResource(R.drawable.ic_check);
                            imgEkstUnit11.setImageResource(R.drawable.ic_check);
                            imgEkstUnit12.setImageResource(R.drawable.ic_check);
                            imgEkstUnit13.setImageResource(R.drawable.ic_check);
                            imgEkstUnit14.setImageResource(R.drawable.ic_check);
                            imgEkstUnit15.setImageResource(R.drawable.ic_check);
                            imgEkstUnit16.setImageResource(R.drawable.ic_check);
                            imgEkstUnit17.setImageResource(R.drawable.ic_check);
                            rdButton1.setChecked(false);
                            rdButton2.setChecked(false);
                            rdButton3.setChecked(false);
                            rdButton4.setChecked(false);
                            rdButton5.setChecked(false);
                            rdButton6.setChecked(false);
                            rdButton7.setChecked(false);
                            rdButton8.setChecked(false);
                            rdButton9.setChecked(false);
                            rdButton10.setChecked(false);
                            rdButton11.setChecked(false);
                            rdButton12.setChecked(false);
                            rdButton13.setChecked(false);
                            rdButton14.setChecked(false);
                            rdButton15.setChecked(false);
                            rdButton16.setChecked(false);
                            rdButton17.setChecked(false);
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

                    if (encodeimageString10 != null){
                        params.put("upload10", encodeimageString10);
                    }else {
                        params.put("", encodeimageString10);
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

                    if (encodeimageString14 != null){
                        params.put("upload14", encodeimageString14);
                    }else {
                        params.put("", encodeimageString14);
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
                    }if (rdButton14 != null){
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
                    encodeImageString6 == null || encodeImageString7 == null || encodeImageString8 == null || encodeImageString9 == null || encodeimageString10 == null ||
                    encodeImageString11 == null || encodeImageString12 == null || encodeImageString13 == null || encodeimageString14 == null || encodeImageString15 == null ||
                    encodeImageString16 == null || encodeImageString17 == null){
                        Toast toast = Toast.makeText(getContext(), "Foto harus diisi", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                    }

                    if (rdButton1 == null || rdButton2 == null || rdButton3 == null || rdButton4 == null || rdButton5 == null || rdButton6 == null || rdButton7 == null ||
                    rdButton8 == null || rdButton9 == null || rdButton10 == null || rdButton11 == null || rdButton12 == null || rdButton13 == null || rdButton14 == null || rdButton15 == null ||
                    rdButton16 == null || rdButton17 == null ){
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