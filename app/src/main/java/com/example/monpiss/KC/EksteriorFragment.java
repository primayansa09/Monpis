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


public class EksteriorFragment extends Fragment implements View.OnClickListener {

    public static final String KODE_UKER2 = "kode_uker2";

    private RadioGroup rdGroup1, rdGroup2, rdGroup3, rdGroup4, rdGroup5, rdGroup6, rdGroup7, rdGroup8, rdGroup9, rdGroup10,
            rdGroup11, rdGroup12, rdGroup13, rdGroup14, rdGroup15, rdGroup16, rdGroup17;

    private RadioButton rdButton1, rdButton2, rdButton3, rdButton4, rdButton5, rdButton6, rdButton7, rdButton8, rdButton9,
            rdButton10, rdButton11, rdButton12, rdButton13, rdButton14, rdButton15, rdButton16, rdButton17;

    private RadioButton mStandar1, mStandar2, mStandar3, mStandar4, mStandar5, mStandar6, mStandar7, mStandar8, mStandar9, mStandar10,
            mStandar11, mStandar12, mStandar13, mStandar14, mStandar15, mStandar16, mStandar17;

    private String encodeImageString1, encodeImageString2, encodeImageString3, encodeimageString4, encodeImageString5, encodeImageString6, encodeImageString7,
            encodeImageString8, encodeImageString9, encodeImageString10, encodeImageString11, encodeImageString12, encodeImageString13, encodeImageString14, encodeImageString15, encodeImageString16, encodeimageString17 ;

    private ImageView cEkstKC1, cEkstKC2, cEkstKC3, cEkstKC4, cEkstKC5, cEkstKC6, cEkstKC7, cEkstKC8, cEkstKC9, cEkstKc10,
            cEkstKC11, cEkstKC12, cEkstKC13, cEkstKC14, cEkstKC15, cEkstKc16, cEkstKC17;

    private ImageView imgEkstKC1, imgEkstKC2, imgEkstKC3, imgEkstKC4, imgEkstKC5, imgEkstKC6, imgEkstKC7, imgEkstKC8,
            imgEkstKC9, imgEkstKC10, imgEkstKC11,imgEkstKC12, imgEkstKC13,imgEkstKC14, imgEkstKC15, imgEkstKC16, imgEkstKC17;


    private TextView kodeuker, mHasil;
    private Button btnSave;
    private ProgressDialog progressDialog;

    public static final int REQUEST_CODE_CAMERA = 0;
    public static final int REQUEST_CODE_CAMERA1 = 1;
    public static final int REQUEST_CODE_CAMERA2 = 2;
    public static final int REQUEST_CODE_CAMERA3 = 3;
    public static final int REQUEST_CODE_CAMERA4 = 4;
    public static final int REQUEST_CODE_CAMERA5 = 5;
    public static final int REQUEST_CODE_CAMERA6 = 6;
    public static final int REQUEST_CODE_CAMERA7 = 7;
    public static final int REQUEST_CODE_CAMERA8 = 8;
    public static final int REQUEST_CODE_CAMERA9 = 9;
    public static final int REQUEST_CODE_CAMERA10 = 10;
    public static final int REQUEST_CODE_CAMERA11 = 11;
    public static final int REQUEST_CODE_CAMERA12 = 12;
    public static final int REQUEST_CODE_CAMERA13 = 13;
    public static final int REQUEST_CODE_CAMERA14 = 14;
    public static final int REQUEST_CODE_CAMERA15 = 15;
    public static final int REQUEST_CODE_CAMERA16 = 16;

    public EksteriorFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eksterior, container, false);

        cEkstKC1 = view.findViewById(R.id.camera_ekst1); rdGroup1 = view.findViewById(R.id.rg_pilihEkst1);
        cEkstKC2 = view.findViewById(R.id.camera_ekst2); rdGroup2 = view.findViewById(R.id.rg_pilihEkst2);
        cEkstKC3 = view.findViewById(R.id.camera_ekst3); rdGroup3 = view.findViewById(R.id.rg_pilihEkst3);
        cEkstKC4 = view.findViewById(R.id.camera_ekst4); rdGroup4 = view.findViewById(R.id.rg_pilihEkst4);
        cEkstKC5 = view.findViewById(R.id.camera_ekst5); rdGroup5 = view.findViewById(R.id.rg_pilihEkst5);
        cEkstKC6 = view.findViewById(R.id.camera_ekst6); rdGroup6 = view.findViewById(R.id.rg_pilihEkst6);
        cEkstKC7 = view.findViewById(R.id.camera_ekst7); rdGroup7 = view.findViewById(R.id.rg_pilihEkst7);
        cEkstKC8 = view.findViewById(R.id.camera_ekst8); rdGroup8 = view.findViewById(R.id.rg_pilihEkst8);
        cEkstKC9 = view.findViewById(R.id.camera_ekst9); rdGroup9 = view.findViewById(R.id.rg_pilihEkst9);
        cEkstKc10 = view.findViewById(R.id.camera_ekst10); rdGroup10 = view.findViewById(R.id.rg_pilihEkst10);
        cEkstKC11 = view.findViewById(R.id.camera_ekst11); rdGroup11 = view.findViewById(R.id.rg_pilihEkst11);
        cEkstKC12 = view.findViewById(R.id.camera_ekst12); rdGroup12 = view.findViewById(R.id.rg_pilihEkst12);
        cEkstKC13 = view.findViewById(R.id.camera_ekst13); rdGroup13 = view.findViewById(R.id.rg_pilihEkst13);
        cEkstKC14 = view.findViewById(R.id.camera_ekst14); rdGroup14 = view.findViewById(R.id.rg_pilihEkst14);
        cEkstKC15 = view.findViewById(R.id.camera_ekst15); rdGroup15 = view.findViewById(R.id.rg_pilihEkst15);
        cEkstKc16 = view.findViewById(R.id.camera_ekst16); rdGroup16 = view.findViewById(R.id.rg_pilihEkst16);
        cEkstKC17 = view.findViewById(R.id.camera_ekst17); rdGroup17 = view.findViewById(R.id.rg_pilihEkst17);

        imgEkstKC1 = view.findViewById(R.id.img_ekst1); mStandar1 = view.findViewById(R.id.rb_standarEkst1);
        imgEkstKC2 = view.findViewById(R.id.img_ekst2); mStandar2 = view.findViewById(R.id.rb_standarEkst2);
        imgEkstKC3 = view.findViewById(R.id.img_ekst3); mStandar3 = view.findViewById(R.id.rb_standarEkst3);
        imgEkstKC4 = view.findViewById(R.id.img_ekst4); mStandar4 = view.findViewById(R.id.rb_standarEkst4);
        imgEkstKC5 = view.findViewById(R.id.img_ekst5); mStandar5 = view.findViewById(R.id.rb_standarEkst5);
        imgEkstKC6 = view.findViewById(R.id.img_ekst6); mStandar6 = view.findViewById(R.id.rb_standarEkst6);
        imgEkstKC7 = view.findViewById(R.id.img_ekst7); mStandar7 = view.findViewById(R.id.rb_standarEkst7);
        imgEkstKC8 = view.findViewById(R.id.img_ekst8); mStandar8 = view.findViewById(R.id.rb_standarEkst8);
        imgEkstKC9 = view.findViewById(R.id.img_ekst9); mStandar9 = view.findViewById(R.id.rb_standarEkst9);
        imgEkstKC10 = view.findViewById(R.id.img_ekst10); mStandar10 = view.findViewById(R.id.rb_standarEkst10);
        imgEkstKC11 = view.findViewById(R.id.img_ekst11); mStandar11 = view.findViewById(R.id.rb_standarEkst11);
        imgEkstKC12 = view.findViewById(R.id.img_ekst12); mStandar12 = view.findViewById(R.id.rb_standarEkst12);
        imgEkstKC13 = view.findViewById(R.id.img_ekst13); mStandar13 = view.findViewById(R.id.rb_standarEkst13);
        imgEkstKC14 = view.findViewById(R.id.img_ekst14); mStandar14 = view.findViewById(R.id.rb_standarEkst14);
        imgEkstKC15 = view.findViewById(R.id.img_ekst15); mStandar15 = view.findViewById(R.id.rb_standarEkst15);
        imgEkstKC16 = view.findViewById(R.id.img_ekst16); mStandar16 = view.findViewById(R.id.rb_standarEkst16);
        imgEkstKC17 = view.findViewById(R.id.img_ekst17); mStandar17 = view.findViewById(R.id.rb_standarEkst17);

        cEkstKC1.setOnClickListener(this);
        cEkstKC2.setOnClickListener(this);
        cEkstKC3.setOnClickListener(this);
        cEkstKC4.setOnClickListener(this);
        cEkstKC5.setOnClickListener(this);
        cEkstKC6.setOnClickListener(this);
        cEkstKC7.setOnClickListener(this);
        cEkstKC8.setOnClickListener(this);
        cEkstKC9.setOnClickListener(this);
        cEkstKc10.setOnClickListener(this);
        cEkstKC11.setOnClickListener(this);
        cEkstKC12.setOnClickListener(this);
        cEkstKC13.setOnClickListener(this);
        cEkstKC14.setOnClickListener(this);
        cEkstKC15.setOnClickListener(this);
        cEkstKc16.setOnClickListener(this);
        cEkstKC17.setOnClickListener(this);

        progressDialog = new ProgressDialog(EksteriorFragment.this.getContext());

        kodeuker = view.findViewById(R.id.name2);
        mHasil = view.findViewById(R.id.hasil_monitoring);
        KC data = getActivity().getIntent().getParcelableExtra(KODE_UKER2);
        String name = data.getKCname();
        kodeuker.setText(name);

        btnSave = view.findViewById(R.id.btn_saveEkstKC);
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
            case R.id.camera_ekst1:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent photo1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                 startActivityForResult(photo1, REQUEST_CODE_CAMERA);
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
            case R.id.camera_ekst2:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent photo1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(photo1, REQUEST_CODE_CAMERA1);
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
            case R.id.camera_ekst3:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent photo2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(photo2, REQUEST_CODE_CAMERA2);
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
            case R.id.camera_ekst4:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent photo3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(photo3, REQUEST_CODE_CAMERA3);
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
            case R.id.camera_ekst5:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent photo4 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(photo4, REQUEST_CODE_CAMERA4);
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
            case R.id.camera_ekst6:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent photo5 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(photo5, REQUEST_CODE_CAMERA5);
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
            case R.id.camera_ekst7:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent photo6 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(photo6, REQUEST_CODE_CAMERA6);
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
            case R.id.camera_ekst8:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent photo7 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(photo7,REQUEST_CODE_CAMERA7);
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
            case R.id.camera_ekst9:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent photo8 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(photo8,REQUEST_CODE_CAMERA8);
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
            case R.id.camera_ekst10:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent photo9 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(photo9,REQUEST_CODE_CAMERA9);
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
            case R.id.camera_ekst11:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent photo10 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(photo10,REQUEST_CODE_CAMERA10);
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
            case R.id.camera_ekst12:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent photo11 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(photo11,REQUEST_CODE_CAMERA11);
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
            case R.id.camera_ekst13:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent photo12 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(photo12,REQUEST_CODE_CAMERA12);
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
            case R.id.camera_ekst14:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent photo13 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(photo13,REQUEST_CODE_CAMERA13);
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
            case R.id.camera_ekst15:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent photo14 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(photo14,REQUEST_CODE_CAMERA14);
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
            case R.id.camera_ekst16:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent photo15 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(photo15,REQUEST_CODE_CAMERA15);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                            }
                        }).check();
                break;
            case R.id.camera_ekst17:
                    Dexter.withContext(getContext().getApplicationContext())
                            .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                            .withListener(new PermissionListener() {
                                @Override
                                public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                    Intent photo16 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                    startActivityForResult(photo16,REQUEST_CODE_CAMERA16);
                                }

                                @Override
                                public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                                }

                                @Override
                                public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                                }
                            }).check();
                break;
            case R.id.btn_saveEkstKC:

                if (rdButton1 == mStandar1 && rdButton2 == mStandar2 && rdButton3 == mStandar3 && rdButton4 == mStandar4 && rdButton5 == mStandar5 && rdButton6 == mStandar6 &&
                    rdButton7 == mStandar7 && rdButton8 == mStandar8 && rdButton9 == mStandar9 && rdButton10 == mStandar10 && rdButton11 == mStandar11 && rdButton12 == mStandar12 &&
                    rdButton13 == mStandar13 && rdButton14 == mStandar14 && rdButton15 == mStandar15 && rdButton16 == mStandar16 && rdButton17 == mStandar17){
                    mHasil.setText("100%");
                }else if (rdButton1 == mStandar1 && rdButton2 != mStandar2  && rdButton3 == mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 == mStandar6 &&
                    rdButton7 == mStandar7 && rdButton8 == mStandar8 && rdButton9 == mStandar9 && rdButton10 == mStandar10 && rdButton11 == mStandar11 && rdButton13 == mStandar13 &&
                    rdButton14 == mStandar14 && rdButton15 == mStandar15 && rdButton16 == mStandar16 && rdButton17 == mStandar17){
                    mHasil.setText("90%");
                }else if (rdButton1 != mStandar1 && rdButton2 == mStandar2 && rdButton3 != mStandar3 && rdButton4 == mStandar4 && rdButton5 != mStandar5 && rdButton6 == mStandar6 &&
                    rdButton7 != mStandar7 && rdButton8 == mStandar8 && rdButton9 == mStandar9 && rdButton10 == mStandar10 && rdButton11 == mStandar11 && rdButton12 == mStandar12 &&
                    rdButton13 == mStandar13 && rdButton14 == mStandar14 && rdButton15 == mStandar15 && rdButton16 == mStandar6 && rdButton17 == mStandar17){
                    mHasil.setText("80%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 == mStandar4 && rdButton5 != mStandar5 && rdButton6 == mStandar6 &&
                        rdButton7 != mStandar7 && rdButton8 == mStandar8 && rdButton9 == mStandar9 && rdButton10 == mStandar10 && rdButton11 == mStandar11 && rdButton12 == mStandar12 &&
                        rdButton13 == mStandar13 && rdButton14 == mStandar14 && rdButton15 == mStandar15 && rdButton16 == mStandar6 && rdButton17 == mStandar17){
                    mHasil.setText("75%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 == mStandar4 && rdButton5 != mStandar5 && rdButton6 == mStandar6 &&
                        rdButton7 != mStandar7 && rdButton8 == mStandar8 && rdButton9 == mStandar9 && rdButton10 == mStandar10 && rdButton11 == mStandar11 && rdButton12 == mStandar12 &&
                        rdButton13 == mStandar13 && rdButton14 != mStandar14 && rdButton15 == mStandar15 && rdButton16 == mStandar6 && rdButton17 == mStandar17){
                    mHasil.setText("70%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 == mStandar6 &&
                        rdButton7 != mStandar7 && rdButton8 != mStandar8 && rdButton9 == mStandar9 && rdButton10 == mStandar10 && rdButton11 == mStandar11 && rdButton12 == mStandar12 &&
                        rdButton13 == mStandar13 && rdButton14 != mStandar14 && rdButton15 == mStandar15 && rdButton16 == mStandar6 && rdButton17 == mStandar17){
                    mHasil.setText("60%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 == mStandar6 &&
                        rdButton7 != mStandar7 && rdButton8 != mStandar8 && rdButton9 == mStandar9 && rdButton10 == mStandar10 && rdButton11 == mStandar11 && rdButton12 == mStandar12 &&
                        rdButton13 != mStandar13 && rdButton14 != mStandar14 && rdButton15 == mStandar15 && rdButton16 == mStandar6 && rdButton17 == mStandar17){
                    mHasil.setText("55%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 == mStandar6 &&
                        rdButton7 != mStandar7 && rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 == mStandar10 && rdButton11 == mStandar11 && rdButton12 == mStandar12 &&
                        rdButton13 != mStandar13 && rdButton14 != mStandar14 && rdButton15 == mStandar15 && rdButton16 == mStandar6 && rdButton17 == mStandar17){
                    mHasil.setText("50%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 &&
                        rdButton7 != mStandar7 && rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 == mStandar10 && rdButton11 == mStandar11 && rdButton12 == mStandar12 &&
                        rdButton13 != mStandar13 && rdButton14 != mStandar14 && rdButton15 == mStandar15 && rdButton16 == mStandar6 && rdButton17 == mStandar17){
                    mHasil.setText("45%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 &&
                        rdButton7 != mStandar7 && rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 != mStandar10 && rdButton11 == mStandar11 && rdButton12 == mStandar12 &&
                        rdButton13 != mStandar13 && rdButton14 != mStandar14 && rdButton15 == mStandar15 && rdButton16 == mStandar6 && rdButton17 == mStandar17){
                    mHasil.setText("40%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 &&
                        rdButton7 != mStandar7 && rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 != mStandar10 && rdButton11 != mStandar11 && rdButton12 == mStandar12 &&
                        rdButton13 != mStandar13 && rdButton14 != mStandar14 && rdButton15 == mStandar15 && rdButton16 == mStandar6 && rdButton17 == mStandar17){
                    mHasil.setText("35%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 &&
                        rdButton7 != mStandar7 && rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 != mStandar10 && rdButton11 != mStandar11 && rdButton12 != mStandar12 &&
                        rdButton13 != mStandar13 && rdButton14 != mStandar14 && rdButton15 == mStandar15 && rdButton16 == mStandar6 && rdButton17 == mStandar17){
                    mHasil.setText("30%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 &&
                        rdButton7 != mStandar7 && rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 != mStandar10 && rdButton11 != mStandar11 && rdButton12 != mStandar12 &&
                        rdButton13 != mStandar13 && rdButton14 != mStandar14 && rdButton15 != mStandar15 && rdButton16 == mStandar6 && rdButton17 == mStandar17){
                    mHasil.setText("20%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 &&
                        rdButton7 != mStandar7 && rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 != mStandar10 && rdButton11 != mStandar11 && rdButton12 != mStandar12 &&
                        rdButton13 != mStandar13 && rdButton14 != mStandar14 && rdButton15 != mStandar15 && rdButton16 != mStandar6 && rdButton17 == mStandar17){
                    mHasil.setText("10%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 &&
                        rdButton7 != mStandar7 && rdButton8 != mStandar8 && rdButton9 != mStandar9 && rdButton10 != mStandar10 && rdButton11 != mStandar11 && rdButton12 != mStandar12 &&
                        rdButton13 != mStandar13 && rdButton14 != mStandar14 && rdButton15 != mStandar15 && rdButton16 != mStandar6 && rdButton17 != mStandar17){
                    mHasil.setText("0%");
                }
                else {
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
            imgEkstKC1.setImageBitmap(bitmap1);
            ImageToString1(getResizeBitmap(bitmap1, 512));
        }

        if (REQUEST_CODE_CAMERA1 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap2 = (Bitmap) data.getExtras().get("data");
            imgEkstKC2.setImageBitmap(bitmap2);
            ImageToString2(getResizeBitmap(bitmap2, 512));
        }

        if (REQUEST_CODE_CAMERA2 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap3 = (Bitmap) data.getExtras().get("data");
            imgEkstKC3.setImageBitmap(bitmap3);
            ImageToString3(getResizeBitmap(bitmap3, 512));
        }

        if (REQUEST_CODE_CAMERA3 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap4 = (Bitmap) data.getExtras().get("data");
            imgEkstKC4.setImageBitmap(bitmap4);
            ImageToString4(getResizeBitmap(bitmap4, 512));
        }

        if (REQUEST_CODE_CAMERA4 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap5 = (Bitmap) data.getExtras().get("data");
            imgEkstKC5.setImageBitmap(bitmap5);
            ImageToString5(getResizeBitmap(bitmap5, 512));
        }

        if (REQUEST_CODE_CAMERA5 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap6 = (Bitmap) data.getExtras().get("data");
            imgEkstKC6.setImageBitmap(bitmap6);
            ImageToString6(getResizeBitmap(bitmap6, 512));
        }

        if (REQUEST_CODE_CAMERA6 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap7 = (Bitmap) data.getExtras().get("data");
            imgEkstKC7.setImageBitmap(bitmap7);
            ImageToString7(getResizeBitmap(bitmap7, 512));
        }

        if (REQUEST_CODE_CAMERA7 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap8 = (Bitmap) data.getExtras().get("data");
            imgEkstKC8.setImageBitmap(bitmap8);
            ImageToString8(getResizeBitmap(bitmap8, 512));
        }

        if (REQUEST_CODE_CAMERA8 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap9 = (Bitmap) data.getExtras().get("data");
            imgEkstKC9.setImageBitmap(bitmap9);
            ImageToString9(getResizeBitmap(bitmap9, 512));
        }

        if (REQUEST_CODE_CAMERA9 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap10 = (Bitmap) data.getExtras().get("data");
            imgEkstKC10.setImageBitmap(bitmap10);
            ImageToString10(getResizeBitmap(bitmap10, 512));
        }

        if (REQUEST_CODE_CAMERA10 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap11 = (Bitmap) data.getExtras().get("data");
            imgEkstKC11.setImageBitmap(bitmap11);
            ImageToString11(getResizeBitmap(bitmap11, 512));
        }

        if (REQUEST_CODE_CAMERA11 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap12 = (Bitmap) data.getExtras().get("data");
            imgEkstKC12.setImageBitmap(bitmap12);
            ImageToString12(getResizeBitmap(bitmap12, 512));
        }

        if (REQUEST_CODE_CAMERA12 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap13 = (Bitmap) data.getExtras().get("data");
            imgEkstKC13.setImageBitmap(bitmap13);
            ImageToString13(getResizeBitmap(bitmap13, 512));
        }

        if (REQUEST_CODE_CAMERA13 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap14 = (Bitmap) data.getExtras().get("data");
            imgEkstKC14.setImageBitmap(bitmap14);
            ImageToString14(getResizeBitmap(bitmap14, 512));
        }

        if (REQUEST_CODE_CAMERA14 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap15 = (Bitmap) data.getExtras().get("data");
            imgEkstKC15.setImageBitmap(bitmap15);
            ImageToString15(getResizeBitmap(bitmap15, 512));
        }

        if (REQUEST_CODE_CAMERA15 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap16 = (Bitmap) data.getExtras().get("data");
            imgEkstKC16.setImageBitmap(bitmap16);
            ImageToString16(getResizeBitmap(bitmap16, 512));
        }

        if (REQUEST_CODE_CAMERA16 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap17 = (Bitmap) data.getExtras().get("data");
            imgEkstKC17.setImageBitmap(bitmap17);
            ImageToString17(getResizeBitmap(bitmap17, 512));
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

        byte[] byteImage = byteArrayOutputStream.toByteArray();
        encodeImageString1 = android.util.Base64.encodeToString(byteImage, Base64.DEFAULT);
    }
    private void ImageToString2(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteImage = byteArrayOutputStream.toByteArray();
        encodeImageString2 = android.util.Base64.encodeToString(byteImage, Base64.DEFAULT);
    }
    private void ImageToString3(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteImage = byteArrayOutputStream.toByteArray();
        encodeImageString3 = android.util.Base64.encodeToString(byteImage, Base64.DEFAULT);
    }
    private void ImageToString4(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteImage = byteArrayOutputStream.toByteArray();
        encodeimageString4 = android.util.Base64.encodeToString(byteImage, Base64.DEFAULT);
    }
    private void ImageToString5(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteImage = byteArrayOutputStream.toByteArray();
        encodeImageString5 = android.util.Base64.encodeToString(byteImage, Base64.DEFAULT);
    }
    private void ImageToString6(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteImage = byteArrayOutputStream.toByteArray();
        encodeImageString6 = android.util.Base64.encodeToString(byteImage, Base64.DEFAULT);
    }
    private void ImageToString7(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteImage = byteArrayOutputStream.toByteArray();
        encodeImageString7 = android.util.Base64.encodeToString(byteImage, Base64.DEFAULT);
    }
    private void ImageToString8(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteImage = byteArrayOutputStream.toByteArray();
        encodeImageString8 = android.util.Base64.encodeToString(byteImage, Base64.DEFAULT);
    }
    private void ImageToString9(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteImage = byteArrayOutputStream.toByteArray();
        encodeImageString9 = android.util.Base64.encodeToString(byteImage, Base64.DEFAULT);
    }
    private void ImageToString10(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteImage = byteArrayOutputStream.toByteArray();
        encodeImageString10 = android.util.Base64.encodeToString(byteImage, Base64.DEFAULT);
    }
    private void ImageToString11(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteImage = byteArrayOutputStream.toByteArray();
        encodeImageString11 = android.util.Base64.encodeToString(byteImage, Base64.DEFAULT);
    }
    private void ImageToString12(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteImage = byteArrayOutputStream.toByteArray();
        encodeImageString12 = android.util.Base64.encodeToString(byteImage, Base64.DEFAULT);
    }
    private void ImageToString13(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteImage = byteArrayOutputStream.toByteArray();
        encodeImageString13 = android.util.Base64.encodeToString(byteImage, Base64.DEFAULT);
    }
    private void ImageToString14(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteImage = byteArrayOutputStream.toByteArray();
        encodeImageString14 = android.util.Base64.encodeToString(byteImage, Base64.DEFAULT);
    }
    private void ImageToString15(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteImage = byteArrayOutputStream.toByteArray();
        encodeImageString15 = android.util.Base64.encodeToString(byteImage, Base64.DEFAULT);
    }
    private void ImageToString16(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteImage = byteArrayOutputStream.toByteArray();
        encodeImageString16 = android.util.Base64.encodeToString(byteImage, Base64.DEFAULT);
    }
    private void ImageToString17(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] byteImage = byteArrayOutputStream.toByteArray();
        encodeimageString17 = android.util.Base64.encodeToString(byteImage, Base64.DEFAULT);
    }

    private void uploadImage(){
        if (CheckNetworkConnection()){
            progressDialog.show();
            progressDialog.setMessage("Loading...");
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_IMAGE_EKST_KC_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            imgEkstKC1.setImageResource(R.drawable.ic_check); imgEkstKC11.setImageResource(R.drawable.ic_check);
                            imgEkstKC2.setImageResource(R.drawable.ic_check); imgEkstKC12.setImageResource(R.drawable.ic_check);
                            imgEkstKC3.setImageResource(R.drawable.ic_check); imgEkstKC13.setImageResource(R.drawable.ic_check);
                            imgEkstKC4.setImageResource(R.drawable.ic_check); imgEkstKC14.setImageResource(R.drawable.ic_check);
                            imgEkstKC5.setImageResource(R.drawable.ic_check); imgEkstKC15.setImageResource(R.drawable.ic_check);
                            imgEkstKC6.setImageResource(R.drawable.ic_check); imgEkstKC16.setImageResource(R.drawable.ic_check);
                            imgEkstKC7.setImageResource(R.drawable.ic_check); imgEkstKC17.setImageResource(R.drawable.ic_check);
                            imgEkstKC8.setImageResource(R.drawable.ic_check);
                            imgEkstKC9.setImageResource(R.drawable.ic_check);
                            imgEkstKC10.setImageResource(R.drawable.ic_check);

                            rdButton1.setChecked(false); rdButton6.setChecked(false); rdButton11.setChecked(false); rdButton16.setChecked(false);
                            rdButton2.setChecked(false); rdButton7.setChecked(false); rdButton12.setChecked(false); rdButton17.setChecked(false);
                            rdButton3.setChecked(false); rdButton8.setChecked(false); rdButton13.setChecked(false);
                            rdButton4.setChecked(false); rdButton9.setChecked(false); rdButton14.setChecked(false);
                            rdButton5.setChecked(false); rdButton10.setChecked(false); rdButton15.setChecked(false);
                            kodeuker.setText("");
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

                    if (encodeimageString4 != null){
                        params.put("upload4", encodeimageString4);
                    }else {
                        params.put("", encodeimageString4);
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

                    if (encodeimageString17 != null){
                        params.put("upload17", encodeimageString17);
                    }else {
                        params.put("", encodeimageString17);
                    }

                    if (rdButton1 != null){
                        params.put("stnd1", rdButton1.getText().toString());
                    }else {
                        params.put("", rdButton1.toString());
                    }

                    if(rdButton2 != null){
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
                        params.put("", rdButton14.toString());
                    }

                    if (rdButton14 != null){
                        params.put("stnd14", rdButton14.getText().toString());
                    }else {
                        params.put("", rdButton14.toString());
                    }

                    if(rdButton15 != null){
                        params.put("stnd15", rdButton15.getText().toString());
                    }else {
                        params.put("", rdButton15.toString());
                    }

                    if (rdButton16 != null){
                        params.put("stnd16", rdButton16.getText().toString());

                    }else{
                        params.put("", rdButton16.toString());
                    }

                    if (rdButton17 != null){
                        params.put("stnd17", rdButton17.getText().toString());
                    }else {
                        params.put("", rdButton17.toString());
                    }

                    if (mHasil != null){
                        params.put("hasil", mHasil.getText().toString());
                    }else {
                        params.put("hasil", mHasil.toString());
                    }
                    params.put("kode", kodeuker.getText().toString());
                    return params;

                }
            };

            RequestQueue queue = Volley.newRequestQueue(getContext().getApplicationContext());
            queue.add(stringRequest);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressDialog.cancel();

                    if (encodeImageString1 == null || encodeImageString2 == null || encodeImageString3 == null || encodeimageString4 == null || encodeImageString5 == null ||
                    encodeImageString6 == null || encodeImageString7 == null || encodeImageString8 == null || encodeImageString9 == null || encodeImageString10 == null ||
                    encodeImageString11 == null || encodeImageString12 == null || encodeImageString13 == null || encodeImageString14 == null || encodeImageString15 == null ||
                    encodeImageString16 == null || encodeimageString17 == null){

                        Toast toast = Toast.makeText(getContext(), "Foto harus diisi", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                    }
                    if (rdButton1 == null || rdButton2 == null || rdButton3 == null || rdButton4 == null || rdButton5 == null || rdButton6 == null ||
                    rdButton7 == null || rdButton8 == null || rdButton9 == null || rdButton10 == null || rdButton11 == null || rdButton12 == null || rdButton13 == null ||
                    rdButton14 == null || rdButton15 == null || rdButton16 == null || rdButton17 == null){

                        Toast toast = Toast.makeText(getContext(), "Pilih Standar/Tidak standar", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                    }

                }
            }, 2000);
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