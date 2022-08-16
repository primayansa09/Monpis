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

public class KCPKerjaArsipPantry extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String KODE_UKER12 = "kode_uker12";

    // TODO: Rename and change types of parameters
    private RadioGroup rdGroup1, rdGroup2, rdGroup3, rdGroup4, rdGroup5, rdGroup6, rdGroup7, rdGroup8, rdGroup9, rdGroup10, rdGroup11, rdGroup12, rdGroup13, rdGroup14;
    private RadioButton rdButton1, rdButton2, rdButton3, rdButton4, rdButton5, rdButton6, rdButton7, rdButton8, rdButton9, rdButton10, rdButton11, rdButton12,
            rdButton13, rdButton14;
    private ProgressDialog progressDialog;
    private Button btnSave;
    private TextView kodeUker12;
    private String mParam2, encodeImageString1, encodeImageString2, encodeImageString3, encodeImageString4, encodeImageString5, encodeImageString6, encodeImageString7, encodeImageString8,
            encodeImageString9, encodeImageString10, encodeImageString11, encodeImageString12, encodeImageString13, encodeImageString14;
    private ImageView cRuangKCp1, cRuangKCp2, cRuangKCp3, cRuangKCp4, cRuangKCp5, cRuangKCp6, cRuangKCp7, cRuangKCp8,
            cRuangKCp9, cRuangKCp10, cRuangKCp11, cRuangKCp12, cRuangKCp13, cRuangKCp14;

    private ImageView imgRuangKCP1, imgRuangKCP2, imgRuangKCP3, imgRuangKCP4, imgRuangKCP5, imgRuangKCP6, imgRuangKCP7,
            imgRuangKCP8, imgRuangKCP9, imgRuangKCP10, imgRuangKCP11, imgRuangKCP12, imgRuangKCP13, imgRuangKCP14;

    private static final int CODE_CAMERA = 0;
    private static final int CODE_CAMERA1 = 1;
    private static final int CODE_CAMERA2 = 2;
    private static final int CODE_CAMERA3 = 3;
    private static final int CODE_CAMERA4 = 4;
    private static final int CODE_CAMERA5 = 5;
    private static final int CODE_CAMERA6 = 6;
    private static final int CODE_CAMERA7 = 7;
    private static final int CODE_CAMERA8 = 8;
    private static final int CODE_CAMERA9 = 9;
    private static final int CODE_CAMERA10 = 10;
    private static final int CODE_CAMERA11 = 11;
    private static final int CODE_CAMERA12 = 12;
    private static final int CODE_CAMERA13 = 13;

    public KCPKerjaArsipPantry() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static KCPKerjaArsipPantry newInstance(String param1, String param2) {
        KCPKerjaArsipPantry fragment = new KCPKerjaArsipPantry();
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
        View view = inflater.inflate(R.layout.fragment_kcp_kerja_arsip_pantry, container, false);

        cRuangKCp1 = view.findViewById(R.id.camera_ruangKCP1);
        cRuangKCp2 = view.findViewById(R.id.camera_ruangKCP2);
        cRuangKCp3 = view.findViewById(R.id.camera_ruangKCP3);
        cRuangKCp4 = view.findViewById(R.id.camera_ruangKCP4);
        cRuangKCp5 = view.findViewById(R.id.camera_ruangKCP5);
        cRuangKCp6 = view.findViewById(R.id.camera_ruangKCP6);
        cRuangKCp7 = view.findViewById(R.id.camera_ruangKCP7);
        cRuangKCp8 = view.findViewById(R.id.camera_ruangKCP8);
        cRuangKCp9 = view.findViewById(R.id.camera_ruangKCP9);
        cRuangKCp10 = view.findViewById(R.id.camera_ruangKCP10);
        cRuangKCp11 = view.findViewById(R.id.camera_ruangKCP11);
        cRuangKCp12 = view.findViewById(R.id.camera_ruangKCP12);
        cRuangKCp13 = view.findViewById(R.id.camera_ruangKCP13);
        cRuangKCp14 = view.findViewById(R.id.camera_ruangKCP14);

        rdGroup1 = view.findViewById(R.id.btn_pilihruangKCP1); rdGroup11 = view.findViewById(R.id.btn_pilihruangKCP11);
        rdGroup2 = view.findViewById(R.id.btn_pilihruangKCP2); rdGroup12 = view.findViewById(R.id.btn_pilihruangKCP12);
        rdGroup3 = view.findViewById(R.id.btn_pilihruangKCP3); rdGroup13 = view.findViewById(R.id.btn_pilihruangKCP13);
        rdGroup4 =  view.findViewById(R.id.btn_pilihruangKCP4); rdGroup14 = view.findViewById(R.id.btn_pilihruangKCP14);
        rdGroup5 = view.findViewById(R.id.btn_pilihruangKCP5);
        rdGroup6 = view.findViewById(R.id.btn_pilihruangKCP6);
        rdGroup7 = view.findViewById(R.id.btn_pilihruangKCP7);
        rdGroup8 = view.findViewById(R.id.btn_pilihruangKCP8);
        rdGroup9 = view.findViewById(R.id.btn_pilihruangKCP9);
        rdGroup10 = view.findViewById(R.id.btn_pilihruangKCP10);

        imgRuangKCP1 = view.findViewById(R.id.img_ruangKCP1);
        imgRuangKCP2 = view.findViewById(R.id.img_ruangKCP2);
        imgRuangKCP3 = view.findViewById(R.id.img_ruangKCP3);
        imgRuangKCP4 = view.findViewById(R.id.img_ruangKCP4);
        imgRuangKCP5 = view.findViewById(R.id.img_ruangKCP5);
        imgRuangKCP6 = view.findViewById(R.id.img_ruangKCP6);
        imgRuangKCP7 = view.findViewById(R.id.img_ruangKCP7);
        imgRuangKCP8 = view.findViewById(R.id.img_ruangKCP8);
        imgRuangKCP9 = view.findViewById(R.id.img_ruangKCP9);
        imgRuangKCP10 = view.findViewById(R.id.img_ruangKCP10);
        imgRuangKCP11 = view.findViewById(R.id.img_ruangKCP11);
        imgRuangKCP12 = view.findViewById(R.id.img_ruangKCP12);
        imgRuangKCP13 = view.findViewById(R.id.img_ruangKCP13);
        imgRuangKCP14 = view.findViewById(R.id.img_ruangKCP14);

        progressDialog = new ProgressDialog(KCPKerjaArsipPantry.this.getContext());
        btnSave = view.findViewById(R.id.btn_saveRuangKCP);
        kodeUker12 = view.findViewById(R.id.name12);
        KCP data = getActivity().getIntent().getParcelableExtra(KODE_UKER12);
        String name = data.getNameKCP();
        kodeUker12.setText(name);


        cRuangKCp1.setOnClickListener(this);
        cRuangKCp2.setOnClickListener(this);
        cRuangKCp3.setOnClickListener(this);
        cRuangKCp4.setOnClickListener(this);
        cRuangKCp5.setOnClickListener(this);
        cRuangKCp6.setOnClickListener(this);
        cRuangKCp7.setOnClickListener(this);
        cRuangKCp8.setOnClickListener(this);
        cRuangKCp9.setOnClickListener(this);
        cRuangKCp10.setOnClickListener(this);
        cRuangKCp11.setOnClickListener(this);
        cRuangKCp12.setOnClickListener(this);
        cRuangKCp13.setOnClickListener(this);
        cRuangKCp14.setOnClickListener(this);
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

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.camera_ruangKCP1:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mruangKCp1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mruangKCp1, CODE_CAMERA);
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
            case R.id.camera_ruangKCP2:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mruangKCP2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mruangKCP2, CODE_CAMERA1);
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
            case R.id.camera_ruangKCP3:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mruangKCP3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mruangKCP3, CODE_CAMERA2);
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
            case R.id.camera_ruangKCP4:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mruangKCP4 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mruangKCP4, CODE_CAMERA3);
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
            case R.id.camera_ruangKCP5:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mruangKCP5 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mruangKCP5, CODE_CAMERA4);
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
            case R.id.camera_ruangKCP6:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mruangKCP6 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mruangKCP6, CODE_CAMERA5);
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
            case R.id.camera_ruangKCP7:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mruangKCP7 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mruangKCP7, CODE_CAMERA6);
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
            case R.id.camera_ruangKCP8:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mruangKCP8 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mruangKCP8, CODE_CAMERA7);
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
            case R.id.camera_ruangKCP9:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mruangKCP9 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mruangKCP9, CODE_CAMERA8);
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
            case R.id.camera_ruangKCP10:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mruangKCP10 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mruangKCP10, CODE_CAMERA9);
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
            case R.id.camera_ruangKCP11:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mruangKCP11 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mruangKCP11, CODE_CAMERA10);
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
            case R.id.camera_ruangKCP12:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mruangKCp12 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mruangKCp12, CODE_CAMERA11);
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
            case R.id.camera_ruangKCP13:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mruangKCP13 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mruangKCP13, CODE_CAMERA12);
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
            case R.id.camera_ruangKCP14:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mruangKCP14 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mruangKCP14, CODE_CAMERA13);
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
            case R.id.btn_saveRuangKCP:
                UploadImage();
                btnSave.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_item));
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (CODE_CAMERA == requestCode && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap1 = (Bitmap) data.getExtras().get("data");
            imgRuangKCP1.setImageBitmap(bitmap1);
            ImageToString1(getResizebitmap(bitmap1, 512));
        }

        if (CODE_CAMERA1 == requestCode && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap2 = (Bitmap) data.getExtras().get("data");
            imgRuangKCP2.setImageBitmap(bitmap2);
            ImageToString2(getResizebitmap(bitmap2, 512));
        }

        if (CODE_CAMERA2 == requestCode && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap3 = (Bitmap) data.getExtras().get("data");
            imgRuangKCP3.setImageBitmap(bitmap3);
            ImageToString3(getResizebitmap(bitmap3, 512));
        }

        if (CODE_CAMERA3 == requestCode && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap4 = (Bitmap) data.getExtras().get("data");
            imgRuangKCP4.setImageBitmap(bitmap4);
            ImageToString4(getResizebitmap(bitmap4, 512));
        }

        if (CODE_CAMERA4 == requestCode && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap5 = (Bitmap) data.getExtras().get("data");
            imgRuangKCP5.setImageBitmap(bitmap5);
            ImageToString5(getResizebitmap(bitmap5, 512));
        }

        if (CODE_CAMERA5 == requestCode && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap6 = (Bitmap) data.getExtras().get("data");
            imgRuangKCP6.setImageBitmap(bitmap6);
            ImageToString6(getResizebitmap(bitmap6, 512));
        }

        if (CODE_CAMERA6 == requestCode && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap7 = (Bitmap) data.getExtras().get("data");
            imgRuangKCP7.setImageBitmap(bitmap7);
            ImageToString7(getResizebitmap(bitmap7, 512));
        }

        if (CODE_CAMERA7 == requestCode && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap8 = (Bitmap) data.getExtras().get("data");
            imgRuangKCP8.setImageBitmap(bitmap8);
            ImageToString8(getResizebitmap(bitmap8, 512));
        }

        if (CODE_CAMERA8 == requestCode && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap9 = (Bitmap) data.getExtras().get("data");
            imgRuangKCP9.setImageBitmap(bitmap9);
            ImageToString9(getResizebitmap(bitmap9, 512));
        }

        if (CODE_CAMERA9 == requestCode && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap10 = (Bitmap) data.getExtras().get("data");
            imgRuangKCP10.setImageBitmap(bitmap10);
            ImageToString10(getResizebitmap(bitmap10, 512));
        }

        if (CODE_CAMERA10 == requestCode && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap11 = (Bitmap) data.getExtras().get("data");
            imgRuangKCP11.setImageBitmap(bitmap11);
            ImageToString11(getResizebitmap(bitmap11, 512));
        }

        if (CODE_CAMERA11 == requestCode && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap12 = (Bitmap) data.getExtras().get("data");
            imgRuangKCP12.setImageBitmap(bitmap12);
            ImageToString12(getResizebitmap(bitmap12, 512));
        }

        if (CODE_CAMERA12 == requestCode && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap13 = (Bitmap) data.getExtras().get("data");
            imgRuangKCP13.setImageBitmap(bitmap13);
            ImageToString13(getResizebitmap(bitmap13, 512));
        }

        if (CODE_CAMERA13 == requestCode && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap14 = (Bitmap) data.getExtras().get("data");
            imgRuangKCP14.setImageBitmap(bitmap14);
            ImageToString14(getResizebitmap(bitmap14, 512));
        }
    }

    private Bitmap getResizebitmap(Bitmap image , int maxSize){
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRoatasi = (float) width / (float) height;
        if (bitmapRoatasi > 1){
            width = maxSize;
            height = (int) (width / bitmapRoatasi);
        }else {
            height = maxSize;
            width = (int) (height * bitmapRoatasi);
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
    private void UploadImage(){
        if (CheckNetworkConnection()){
            progressDialog.show();
            progressDialog.setMessage("Loading...");
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_IMAGE_RUANG_KCP_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            imgRuangKCP1.setImageResource(R.drawable.ic_check);
                            imgRuangKCP2.setImageResource(R.drawable.ic_check);
                            imgRuangKCP3.setImageResource(R.drawable.ic_check);
                            imgRuangKCP4.setImageResource(R.drawable.ic_check);
                            imgRuangKCP5.setImageResource(R.drawable.ic_check);
                            imgRuangKCP6.setImageResource(R.drawable.ic_check);
                            imgRuangKCP7.setImageResource(R.drawable.ic_check);
                            imgRuangKCP8.setImageResource(R.drawable.ic_check);
                            imgRuangKCP9.setImageResource(R.drawable.ic_check);
                            imgRuangKCP10.setImageResource(R.drawable.ic_check);
                            imgRuangKCP11.setImageResource(R.drawable.ic_check);
                            imgRuangKCP12.setImageResource(R.drawable.ic_check);
                            imgRuangKCP13.setImageResource(R.drawable.ic_check);
                            imgRuangKCP14.setImageResource(R.drawable.ic_check);
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
                            kodeUker12.setText("");
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
                    }else{
                        params.put("", encodeImageString5);
                    }

                    if (encodeImageString6 != null){
                        params.put("upload6", encodeImageString6);
                    }else {
                        params.put("", encodeImageString7);
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
                    params.put("kode", kodeUker12.getText().toString());
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
                    encodeImageString11 == null || encodeImageString12 == null || encodeImageString13 == null || encodeImageString14 == null){
                        Toast toast = Toast.makeText(getContext(), "Foto harus diisi", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                    }
                    if (rdButton1 == null || rdButton2 == null || rdButton3 == null || rdButton4 == null || rdButton5 == null || rdButton6 == null || rdButton7 == null ||
                    rdButton8 == null || rdButton9 == null || rdButton10 == null || rdButton11 == null || rdButton12 == null || rdButton13 == null || rdButton14 == null){
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
