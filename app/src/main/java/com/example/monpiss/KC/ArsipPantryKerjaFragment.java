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


public class ArsipPantryKerjaFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String KODE_UKER6 = "kode_uker6";

    // TODO: Rename and change types of parameters
    private RadioGroup rdGroup1, rdGroup2, rdGroup3, rdGroup4, rdGroup5, rdGroup6, rdGroup7, rdGroup8, rdGroup9, rdGroup10,
                    rdGroup11, rdGroup12, rdGroup13, rdGroup14;
    private RadioButton rdButton1, rdButton2, rdButton3, rdButton4, rdButton5, rdButton6, rdButton7, rdButton8, rdButton9,
            rdButton10, rdButton11, rdButton12, rdButton13, rdButton14;
    private String mParam1;
    private String mParam2, encodeBitmapString1, encodeBitmapString2, encodeBitmapString3, encodeBitmapString4, encodeBitmapString5,
            encodeBitmapString6, encodeBitmapString7, encodeBitmapString8, encodeBitmapString9, encodeBitmapString10, encodeBitmapString11, encodeBitmapString12,
            encodeBitmapString13, encodeBitmapString14;
    private Button btnSave;
    private TextView kodeUker;
    private ProgressDialog progressDialog;
    private ImageView cRuang1, cRuang2, cRuang3, cRuang4, cRuang5, cRuang6, cRuang7, cRuang8, cRuang9, cRuang10, cRuang11,
            cRuang12, cRuang13, cRuang14;

    private ImageView imgRuang1, imgRuang2, imgRuang3, imgRuang4, imgRuang5, imgRuang6, imgRuang7, imgRuang8, imgRuang9, imgRuang10,
            imgRuang11, imgRuang12, imgRuang13, imgRuang14;

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

    public ArsipPantryKerjaFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ArsipPantryKerjaFragment newInstance(String param1, String param2) {
        ArsipPantryKerjaFragment fragment = new ArsipPantryKerjaFragment();
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
        View view = inflater.inflate(R.layout.fragment_arsip_pantry_kerja, container, false);
        cRuang1 = view.findViewById(R.id.camera_ruang1);
        cRuang2 = view.findViewById(R.id.camera_ruang2);
        cRuang3 = view.findViewById(R.id.camera_ruang3);
        cRuang4 = view.findViewById(R.id.camera_ruang4);
        cRuang5 = view.findViewById(R.id.camera_ruang5);
        cRuang6 = view.findViewById(R.id.camera_ruang6);
        cRuang7 = view.findViewById(R.id.camera_ruang7);
        cRuang8 = view.findViewById(R.id.camera_ruang8);
        cRuang9 = view.findViewById(R.id.camera_ruang9);
        cRuang10 = view.findViewById(R.id.camera_ruang10);
        cRuang11 = view.findViewById(R.id.camera_ruang11);
        cRuang12 = view.findViewById(R.id.camera_ruang12);
        cRuang13 = view.findViewById(R.id.camera_ruang13);
        cRuang14 = view.findViewById(R.id.camera_ruang14);

        rdGroup1 = view.findViewById(R.id.btn_pilihruang1);
        rdGroup2 = view.findViewById(R.id.btn_pilihruang2);
        rdGroup3 = view.findViewById(R.id.btn_pilihruang3);
        rdGroup4 = view.findViewById(R.id.btn_pilihruang4);
        rdGroup5 = view.findViewById(R.id.btn_pilihruang5);
        rdGroup6 = view.findViewById(R.id.btn_pilihruang6);
        rdGroup7 = view.findViewById(R.id.btn_pilihruang7);
        rdGroup8 = view.findViewById(R.id.btn_pilihruang8);
        rdGroup9 = view.findViewById(R.id.btn_pilihruang9);
        rdGroup10 = view.findViewById(R.id.btn_pilihruang10);
        rdGroup11 = view.findViewById(R.id.btn_pilihruang11);
        rdGroup12 = view.findViewById(R.id.btn_pilihruang12);
        rdGroup13 = view.findViewById(R.id.btn_pilihruang13);
        rdGroup14 = view.findViewById(R.id.btn_pilihruang14);

        imgRuang1 = view.findViewById(R.id.img_ruang1);
        imgRuang2 = view.findViewById(R.id.img_ruang2);
        imgRuang3 = view.findViewById(R.id.img_ruang3);
        imgRuang4 = view.findViewById(R.id.img_ruang4);
        imgRuang5 = view.findViewById(R.id.img_ruang5);
        imgRuang6 = view.findViewById(R.id.img_ruang6);
        imgRuang7 = view.findViewById(R.id.img_ruang7);
        imgRuang8 = view.findViewById(R.id.img_ruang8);
        imgRuang9 = view.findViewById(R.id.img_ruang9);
        imgRuang10 = view.findViewById(R.id.img_ruang10);
        imgRuang11 = view.findViewById(R.id.img_ruang11);
        imgRuang12 = view.findViewById(R.id.img_ruang12);
        imgRuang13 = view.findViewById(R.id.img_ruang13);
        imgRuang14 = view.findViewById(R.id.img_ruang14);

        progressDialog = new ProgressDialog(ArsipPantryKerjaFragment.this.getContext());
        btnSave = view.findViewById(R.id.btn_saveRuangKC);
        btnSave.setOnClickListener(this);

        kodeUker = view.findViewById(R.id.name6);
        KC data = getActivity().getIntent().getParcelableExtra(KODE_UKER6);
        String name = data.getKCname();
        kodeUker.setText(name);

        cRuang1.setOnClickListener(this);
        cRuang2.setOnClickListener(this);
        cRuang3.setOnClickListener(this);
        cRuang4.setOnClickListener(this);
        cRuang5.setOnClickListener(this);
        cRuang6.setOnClickListener(this);
        cRuang7.setOnClickListener(this);
        cRuang8.setOnClickListener(this);
        cRuang8.setOnClickListener(this);
        cRuang9.setOnClickListener(this);
        cRuang10.setOnClickListener(this);
        cRuang11.setOnClickListener(this);
        cRuang12.setOnClickListener(this);
        cRuang13.setOnClickListener(this);
        cRuang14.setOnClickListener(this);

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
        switch (v.getId()){
            case R.id.camera_ruang1:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto, REQUEST_CODE_CAMERA);
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
            case R.id.camera_ruang2:
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
            case R.id.camera_ruang3:
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
            case R.id.camera_ruang4:
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
            case R.id.camera_ruang5:
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
            case R.id.camera_ruang6:
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
            case R.id.camera_ruang7:
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
            case R.id.camera_ruang8:
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
            case R.id.camera_ruang9:
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
            case R.id.camera_ruang10:
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
            case R.id.camera_ruang11:
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
            case R.id.camera_ruang12:
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
            case R.id.camera_ruang13:
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
            case R.id.camera_ruang14:
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
            case R.id.btn_saveRuangKC:
                UploadImage();
                btnSave.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_item));
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_CODE_CAMERA == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap1 = (Bitmap) data.getExtras().get("data");
            imgRuang1.setImageBitmap(bitmap1);
            ImageToString1(getRisizeBitmap(bitmap1, 512));

        }

        if (REQUEST_CODE_CAMERA1 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap2 = (Bitmap) data.getExtras().get("data");
            imgRuang2.setImageBitmap(bitmap2);
            ImageToString2(getRisizeBitmap(bitmap2, 512));
        }

        if (REQUEST_CODE_CAMERA2 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap3 = (Bitmap) data.getExtras().get("data");
            imgRuang3.setImageBitmap(bitmap3);
            ImageToString3(getRisizeBitmap(bitmap3, 512));
        }

        if (REQUEST_CODE_CAMERA3 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap4 = (Bitmap) data.getExtras().get("data");
            imgRuang4.setImageBitmap(bitmap4);
            ImageToString4(getRisizeBitmap(bitmap4, 512));
        }

        if (REQUEST_CODE_CAMERA4 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap5 = (Bitmap) data.getExtras().get("data");
            imgRuang5.setImageBitmap(bitmap5);
            ImageToString5(getRisizeBitmap(bitmap5, 512));
        }

        if (REQUEST_CODE_CAMERA5 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap6 = (Bitmap) data.getExtras().get("data");
            imgRuang6.setImageBitmap(bitmap6);
            ImageToString6(getRisizeBitmap(bitmap6, 512));
        }

        if (REQUEST_CODE_CAMERA6 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap7 = (Bitmap) data.getExtras().get("data");
            imgRuang7.setImageBitmap(bitmap7);
            ImageToString7(getRisizeBitmap(bitmap7, 512));
        }

        if (REQUEST_CODE_CAMERA7 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap8 = (Bitmap) data.getExtras().get("data");
            imgRuang8.setImageBitmap(bitmap8);
            ImageToString8(getRisizeBitmap(bitmap8, 512));
        }

        if (REQUEST_CODE_CAMERA8 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap9 = (Bitmap) data.getExtras().get("data");
            imgRuang9.setImageBitmap(bitmap9);
            ImageToString9(getRisizeBitmap(bitmap9, 512));
        }

        if (REQUEST_CODE_CAMERA9 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap10 = (Bitmap) data.getExtras().get("data");
            imgRuang10.setImageBitmap(bitmap10);
            ImageToString10(getRisizeBitmap(bitmap10, 512));
        }

        if (REQUEST_CODE_CAMERA10 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap11 = (Bitmap) data.getExtras().get("data");
            imgRuang11.setImageBitmap(bitmap11);
            ImageToString11(getRisizeBitmap(bitmap11, 512));
        }

        if (REQUEST_CODE_CAMERA11 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap12 = (Bitmap) data.getExtras().get("data");
            imgRuang12.setImageBitmap(bitmap12);
            ImageToString12(getRisizeBitmap(bitmap12, 512));
        }

        if (REQUEST_CODE_CAMERA12 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap13 = (Bitmap) data.getExtras().get("data");
            imgRuang13.setImageBitmap(bitmap13);
            ImageToString13(getRisizeBitmap(bitmap13, 512));
        }

        if (REQUEST_CODE_CAMERA13 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap14 = (Bitmap) data.getExtras().get("data");
            imgRuang14.setImageBitmap(bitmap14);
            ImageToString14(getRisizeBitmap(bitmap14, 512));
        }
    }

    private Bitmap getRisizeBitmap(Bitmap image, int maxSize){
        int widht = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) widht / (float) height;
        if (bitmapRatio > 1){
            widht = maxSize;
            height = (int) (widht / bitmapRatio);
        }else {
            height = maxSize;
            widht = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, widht, height, true);
    }

    private void ImageToString1(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeBitmapString1 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString2(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeBitmapString2 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString3(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeBitmapString3 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString4(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeBitmapString4 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString5(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeBitmapString5 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString6(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeBitmapString6 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString7(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeBitmapString7 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString8(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeBitmapString8 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString9(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeBitmapString9 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString10(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeBitmapString10 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString11(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeBitmapString11 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString12(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeBitmapString12 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString13(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeBitmapString13 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString14(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeBitmapString14 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }

    private void UploadImage(){
        if (CheckNetworkConnection()){
            progressDialog.show();
            progressDialog.setMessage("Loading...");
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_IMAGE_RUANG_KC,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            imgRuang1.setImageResource(R.drawable.ic_check);
                            imgRuang2.setImageResource(R.drawable.ic_check);
                            imgRuang3.setImageResource(R.drawable.ic_check);
                            imgRuang4.setImageResource(R.drawable.ic_check);
                            imgRuang5.setImageResource(R.drawable.ic_check);
                            imgRuang6.setImageResource(R.drawable.ic_check);
                            imgRuang7.setImageResource(R.drawable.ic_check);
                            imgRuang8.setImageResource(R.drawable.ic_check);
                            imgRuang9.setImageResource(R.drawable.ic_check);
                            imgRuang10.setImageResource(R.drawable.ic_check);
                            imgRuang11.setImageResource(R.drawable.ic_check);
                            imgRuang12.setImageResource(R.drawable.ic_check);
                            imgRuang13.setImageResource(R.drawable.ic_check);
                            imgRuang14.setImageResource(R.drawable.ic_check);
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
                            kodeUker.setText("");
                            Toast toast = Toast.makeText(getContext(), "Upload sukses", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,0 ,0);
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
                   if (encodeBitmapString1 != null){
                       params.put("upload1", encodeBitmapString1);
                   }else {
                       params.put("", encodeBitmapString1);
                   }
                   if (encodeBitmapString2 != null){
                       params.put("upload2", encodeBitmapString2);
                   }else {
                       params.put("", encodeBitmapString2);
                   }
                   if (encodeBitmapString3 != null){
                       params.put("upload3", encodeBitmapString3);
                   }else {
                       params.put("", encodeBitmapString3);
                   }
                   if (encodeBitmapString4 != null){
                       params.put("upload4", encodeBitmapString4);
                   }else {
                       params.put("", encodeBitmapString4);
                   }
                   if (encodeBitmapString5 != null){
                       params.put("upload5", encodeBitmapString5);
                   }else {
                       params.put("", encodeBitmapString5);
                   }
                   if (encodeBitmapString6 != null){
                       params.put("upload6", encodeBitmapString6);
                   }else {
                       params.put("", encodeBitmapString6);
                   }
                   if (encodeBitmapString7 != null){
                       params.put("upload7", encodeBitmapString7);
                   }else {
                       params.put("", encodeBitmapString7);
                   }
                   if (encodeBitmapString8 != null){
                       params.put("upload8", encodeBitmapString8);
                   }else {
                       params.put("", encodeBitmapString8);
                   }
                   if (encodeBitmapString9 != null){
                       params.put("upload9", encodeBitmapString9);
                   }else {
                       params.put("", encodeBitmapString9);
                   }
                   if (encodeBitmapString10 != null){
                       params.put("upload10", encodeBitmapString10);
                   }else {
                       params.put("", encodeBitmapString10);
                   }
                   if (encodeBitmapString11 != null){
                       params.put("upload11", encodeBitmapString11);
                   }else {
                       params.put("", encodeBitmapString11);
                   }
                   if (encodeBitmapString12 != null){
                       params.put("upload12", encodeBitmapString12);
                   }else {
                       params.put("", encodeBitmapString12);
                   }
                   if (encodeBitmapString13 != null){
                       params.put("upload13", encodeBitmapString13);
                   }else {
                       params.put("", encodeBitmapString13);
                   }
                   if (encodeBitmapString14 != null){
                       params.put("upload14", encodeBitmapString14);
                   }else {
                       params.put("", encodeBitmapString14);
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
                    if (encodeBitmapString1 == null || encodeBitmapString2 == null || encodeBitmapString3 == null || encodeBitmapString4 == null || encodeBitmapString5 == null ||
                    encodeBitmapString6 == null || encodeBitmapString7 == null || encodeBitmapString8 == null || encodeBitmapString9 == null || encodeBitmapString10 == null ||
                    encodeBitmapString11 == null || encodeBitmapString12 == null || encodeBitmapString13 == null || encodeBitmapString14 == null){

                        Toast toast = Toast.makeText(getContext(), "Foto harus diisi", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0,0);
                    }

                    if (rdButton1 == null || rdButton2 == null || rdButton3 == null || rdButton4 == null || rdButton5 == null || rdButton6 == null || rdButton7 == null ||
                    rdButton8 == null || rdButton9 == null || rdButton10 == null || rdButton11 == null || rdButton12 == null || rdButton13 == null || rdButton14 == null){
                        Toast toast = Toast.makeText(getContext(), "Pilih Standar/Tidak standar", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();
                    }

                }
            }, 3000);
        }else {
            Toast toast = Toast.makeText(getContext(), "Upload gagal", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }
    }

    public boolean CheckNetworkConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}