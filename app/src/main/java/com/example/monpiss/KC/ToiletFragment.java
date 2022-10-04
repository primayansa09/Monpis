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

public class ToiletFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String KODE_UKER5 = "kode_uker5";

    // TODO: Rename and change types of parameters
    private RadioGroup rdGroup1, rdGroup2, rdGroup3, rdGroup4, rdGroup5, rdGroup6, rdGroup7, rdGroup8, rdGroup9;
    private RadioButton rdButton1, rdButton2, rdButton3, rdButton4, rdButton5, rdButton6, rdButton7, rdButton8, rdButton9;
    private RadioButton mStandar1, mStandar2, mStandar3, mStandar4, mStandar5, mStandar6, mStandar7, mStandar8, mStandar9;
    private String mParam1;
    private String encodeImageString1, encodeImageString2, encodeImageString3, encodeImageString4, encodeImageString5, encodeImageString6, encodeImageString7, encodeImageString8, encodeImageString9;
    private ProgressDialog progressDialog;
    private Button btnsaveToilet;
    private TextView kodeUker, mHasil;
    private ImageView cToilet1, cToilet2, cToilet3, cToilet4, cToilet5, cToilet6, cToilet7, cToilet8, cToilet9;
    private ImageView imgToilet1, imgToilet2, imgToilet3, imgToilet4, imgToilet5, imgToilet6, imgToilet7, imgToilet8, imgToilet9;

    private static final int REQUEST_CODE_CAMERA = 0;
    private static final int REQUEST_CODE_CAMERA1 = 1;
    private static final int REQUEST_CODE_CAMERA2 = 2;
    private static final int REQUEST_CODE_CAMERA3 = 3;
    private static final int REQUEST_CODE_CAMERA4 = 4;
    private static final int REQUEST_CODE_CAMERA5 = 5;
    private static final int REQUEST_CODE_CAMERA6 = 6;
    private static final int REQUEST_CODE_CAMERA7 = 7;
    private static final int REQUEST_CODE_CAMERA8 = 8;

    public ToiletFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ToiletFragment newInstance(String param1, String param2) {
        ToiletFragment fragment = new ToiletFragment();
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_toilet, container, false);

        cToilet1 = view.findViewById(R.id.camera_toilet1);
        cToilet2 = view.findViewById(R.id.camera_toilet2);
        cToilet3 = view.findViewById(R.id.camera_toilet3);
        cToilet4 = view.findViewById(R.id.camera_toilet4);
        cToilet5 = view.findViewById(R.id.camera_toilet5);
        cToilet6 = view.findViewById(R.id.camera_toilet6);
        cToilet7 = view.findViewById(R.id.camera_toilet7);
        cToilet8 = view.findViewById(R.id.camera_toilet8);
        cToilet9 = view.findViewById(R.id.camera_toilet9);

        rdGroup1 = view.findViewById(R.id.rg_pilihToiletKC1); mStandar1 = view.findViewById(R.id.rb_standar1);
        rdGroup2 = view.findViewById(R.id.rg_pilihToiletKC2); mStandar2 = view.findViewById(R.id.rb_standar2);
        rdGroup3 = view.findViewById(R.id.rg_pilihToiletKC3); mStandar3 = view.findViewById(R.id.rb_standar3);
        rdGroup4 = view.findViewById(R.id.rg_pilihToiletKC4); mStandar4 = view.findViewById(R.id.rb_standar4);
        rdGroup5 = view.findViewById(R.id.rg_pilihToiletKC5); mStandar5 = view.findViewById(R.id.rb_standar5);
        rdGroup6 = view.findViewById(R.id.rg_pilihToiletKC6); mStandar6 = view.findViewById(R.id.rb_standar6);
        rdGroup7 = view.findViewById(R.id.rg_pilihToiletKC7); mStandar7 = view.findViewById(R.id.rb_standar7);
        rdGroup8 = view.findViewById(R.id.rg_pilihToiletKC8); mStandar8 = view.findViewById(R.id.rb_standar8);
        rdGroup9 = view.findViewById(R.id.rg_pilihToiletKC9); mStandar9 = view.findViewById(R.id.rb_standar9);

        imgToilet1 = view.findViewById(R.id.img_toilet1);
        imgToilet2 = view.findViewById(R.id.img_toilet2);
        imgToilet3 = view.findViewById(R.id.img_toilet3);
        imgToilet4 = view.findViewById(R.id.img_toilet4);
        imgToilet5 = view.findViewById(R.id.img_toilet5);
        imgToilet6 = view.findViewById(R.id.img_toilet6);
        imgToilet7 = view.findViewById(R.id.img_toilet7);
        imgToilet8 = view.findViewById(R.id.img_toilet8);
        imgToilet9 = view.findViewById(R.id.img_toilet9);
        progressDialog = new ProgressDialog(ToiletFragment.this.getContext());
        btnsaveToilet = view.findViewById(R.id.btn_saveToiletKC);

        kodeUker = view.findViewById(R.id.name5);
        mHasil = view.findViewById(R.id.hasil_monitoring);
        KC data = getActivity().getIntent().getParcelableExtra(KODE_UKER5);
        String name = data.getKCname();
        kodeUker.setText(name);

        cToilet1.setOnClickListener(this);
        cToilet2.setOnClickListener(this);
        cToilet3.setOnClickListener(this);
        cToilet4.setOnClickListener(this);
        cToilet5.setOnClickListener(this);
        cToilet6.setOnClickListener(this);
        cToilet7.setOnClickListener(this);
        cToilet8.setOnClickListener(this);
        cToilet9.setOnClickListener(this);
        btnsaveToilet.setOnClickListener(this);

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


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.camera_toilet1:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto1, REQUEST_CODE_CAMERA);
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
            case R.id.camera_toilet2:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto2, REQUEST_CODE_CAMERA1);
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
            case R.id.camera_toilet3:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto3, REQUEST_CODE_CAMERA2);
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
            case R.id.camera_toilet4:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto4 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto4, REQUEST_CODE_CAMERA3);
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
            case R.id.camera_toilet5:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mPhoto5 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mPhoto5, REQUEST_CODE_CAMERA4);
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
            case R.id.camera_toilet6:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mPhoto6 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mPhoto6, REQUEST_CODE_CAMERA5);
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
            case R.id.camera_toilet7:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto7 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto7, REQUEST_CODE_CAMERA6);
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
            case R.id.camera_toilet8:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto8 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto8, REQUEST_CODE_CAMERA7);
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
            case R.id.camera_toilet9:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mPhoto9 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mPhoto9, REQUEST_CODE_CAMERA8);
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
            case R.id.btn_saveToiletKC:
                uploadImage();
                btnsaveToilet.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_item));

                if (rdButton1 == mStandar1 && rdButton2 == mStandar2 && rdButton3 == mStandar3 && rdButton4 == mStandar4 && rdButton5 == mStandar5 && rdButton6 == mStandar6 &&
                    rdButton7 == mStandar7 && rdButton8 == mStandar8 && rdButton9 == mStandar9){
                    mHasil.setText("100%");
                }else if (rdButton1 != mStandar1 && rdButton2 == mStandar2 && rdButton3 == mStandar3 && rdButton4 == mStandar4 && rdButton5 == mStandar5 && rdButton6 == mStandar6 &&
                        rdButton7 == mStandar7 && rdButton8 == mStandar8 && rdButton9 == mStandar9){
                    mHasil.setText("90%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 == mStandar3 && rdButton4 == mStandar4 && rdButton5 == mStandar5 && rdButton6 == mStandar6 &&
                        rdButton7 == mStandar7 && rdButton8 == mStandar8 && rdButton9 == mStandar9){
                    mHasil.setText("80%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 == mStandar4 && rdButton5 == mStandar5 && rdButton6 == mStandar6 &&
                        rdButton7 == mStandar7 && rdButton8 == mStandar8 && rdButton9 == mStandar9){
                    mHasil.setText("70%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 == mStandar5 && rdButton6 == mStandar6 &&
                        rdButton7 == mStandar7 && rdButton8 == mStandar8 && rdButton9 == mStandar9){
                    mHasil.setText("60%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 == mStandar6 &&
                        rdButton7 == mStandar7 && rdButton8 == mStandar8 && rdButton9 == mStandar9){
                    mHasil.setText("50%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 &&
                        rdButton7 == mStandar7 && rdButton8 == mStandar8 && rdButton9 == mStandar9){
                    mHasil.setText("40%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 &&
                        rdButton7 != mStandar7 && rdButton8 == mStandar8 && rdButton9 == mStandar9){
                    mHasil.setText("20%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 &&
                        rdButton7 != mStandar7 && rdButton8 != mStandar8 && rdButton9 == mStandar9){
                    mHasil.setText("10%");
                }else if (rdButton1 != mStandar1 && rdButton2 != mStandar2 && rdButton3 != mStandar3 && rdButton4 != mStandar4 && rdButton5 != mStandar5 && rdButton6 != mStandar6 &&
                        rdButton7 != mStandar7 && rdButton8 != mStandar8 && rdButton9 != mStandar9){
                    mHasil.setText("0%");
                }else {
                    mHasil.setText("");
                }
                break;
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (REQUEST_CODE_CAMERA == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap1 = (Bitmap) data.getExtras().get("data");
            imgToilet1.setImageBitmap(bitmap1);
            imageToString1(getResizeBitmap(bitmap1, 512));
        }

        if (REQUEST_CODE_CAMERA1 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap2 = (Bitmap) data.getExtras().get("data");
            imgToilet2.setImageBitmap(bitmap2);
            imageToString2(getResizeBitmap(bitmap2, 512));
        }

        if (REQUEST_CODE_CAMERA2 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap3 = (Bitmap) data.getExtras().get("data");
            imgToilet3.setImageBitmap(bitmap3);
            imageToString3(getResizeBitmap(bitmap3, 512));
        }

        if (REQUEST_CODE_CAMERA3 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap4 = (Bitmap) data.getExtras().get("data");
            imgToilet4.setImageBitmap(bitmap4);
            imageToString4(getResizeBitmap(bitmap4, 512));
        }

        if (REQUEST_CODE_CAMERA4 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap5 = (Bitmap) data.getExtras().get("data");
            imgToilet5.setImageBitmap(bitmap5);
            imageToString5(getResizeBitmap(bitmap5, 512));
        }

        if (REQUEST_CODE_CAMERA5 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap6 = (Bitmap) data.getExtras().get("data");
            imgToilet6.setImageBitmap(bitmap6);
            imageToString6(getResizeBitmap(bitmap6, 512));
        }

        if (REQUEST_CODE_CAMERA6 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap7 = (Bitmap) data.getExtras().get("data");
            imgToilet7.setImageBitmap(bitmap7);
            imageToString7(getResizeBitmap(bitmap7, 512));
        }

        if (REQUEST_CODE_CAMERA7 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap8 = (Bitmap) data.getExtras().get("data");
            imgToilet8.setImageBitmap(bitmap8);
            imageToString8(getResizeBitmap(bitmap8, 512));
        }

        if (REQUEST_CODE_CAMERA8 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap9 = (Bitmap) data.getExtras().get("data");
            imgToilet9.setImageBitmap(bitmap9);
            imageToString9(getResizeBitmap(bitmap9, 512));
        }
    }

    private Bitmap getResizeBitmap(Bitmap image, int maxsize){
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 1){
            width = maxsize;
            height = (int) (width / bitmapRatio);
        }else {
            height = maxsize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }

    private void imageToString1(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString1 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);
    }
    private void imageToString2(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString2 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);
    }
    private void imageToString3(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString3 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);
    }
    private void imageToString4(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString4 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);
    }
    private void imageToString5(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString5 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);
    }
    private void imageToString6(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString6 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);
    }
    private void imageToString7(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString7 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);
    }
    private void imageToString8(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString8 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);
    }
    private void imageToString9(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteimage = byteArrayOutputStream.toByteArray();
        encodeImageString9 = android.util.Base64.encodeToString(byteimage, Base64.DEFAULT);
    }

    private void uploadImage(){
        if (CheckNetworkConnection()){
            progressDialog.show();
            progressDialog.setMessage("Loading...");
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_IMAGE_TOILET_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            imgToilet1.setImageResource(R.drawable.ic_check);
                            imgToilet2.setImageResource(R.drawable.ic_check);
                            imgToilet3.setImageResource(R.drawable.ic_check);
                            imgToilet4.setImageResource(R.drawable.ic_check);
                            imgToilet5.setImageResource(R.drawable.ic_check);
                            imgToilet6.setImageResource(R.drawable.ic_check);
                            imgToilet7.setImageResource(R.drawable.ic_check);
                            imgToilet8.setImageResource(R.drawable.ic_check);
                            imgToilet9.setImageResource(R.drawable.ic_check);

                            rdButton1.setChecked(false);
                            rdButton2.setChecked(false);
                            rdButton3.setChecked(false);
                            rdButton4.setChecked(false);
                            rdButton5.setChecked(false);
                            rdButton6.setChecked(false);
                            rdButton7.setChecked(false);
                            rdButton8.setChecked(false);
                            rdButton9.setChecked(false);
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
                    encodeImageString7 == null || encodeImageString8 == null || encodeImageString9 == null){
                        Toast toast = Toast.makeText(getContext(), "Foto harus diisi", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                    }

                    if (rdButton1 == null || rdButton2 == null || rdButton3 == null || rdButton4 == null || rdButton5 == null || rdButton6 == null || rdButton7 == null ||
                    rdButton8 == null || rdButton9 == null){
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