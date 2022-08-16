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
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;


public class UnitToiletFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String KODE_UKER17 = "kode_uker17";

    // TODO: Rename and change types of parameters
    private RadioGroup rdGroup1, rdGroup2, rdGroup3, rdGroup4, rdGroup5, rdGroup6, rdGroup7, rdGroup8, rdGroup9;
    private RadioButton rdButton1, rdButton2, rdButton3, rdButton4, rdButton5, rdButton6, rdButton7, rdButton8, rdButton9;
    private ProgressDialog progressDialog;
    private Button btnSave;
    private TextView kodeUker;
    private String mParam2, encodeImageString1, encodeImageString2, encodeImageString3, encodeImageString4, encodeImageString5, encodeImageString6, encodeImageString7, encodeImageString8, encodeImageString9;
    private ImageView cToiletUnit1, cToiletUnit2, cToiletUnit3, cToiletUnit4, cToiletUnit5, cToiletUnit6, cToiletUnit7, cToiletUnit8, cToiletUnit9,
            imgToiletUnit1, imgToiletUnit2, imgToiletUnit3, imgToiletUnit4, imgToiletUnit5, imgToiletUnit6, imgToiletUnit7, imgToiletUnit8, imgToiletUnit9;

    private static final int CODE_CAMERA = 0;
    private static final int CODE_CAMERA1 = 1;
    private static final int CODE_CAMERA2 = 2;
    private static final int CODE_CAMERA3 = 3;
    private static final int CODE_CAMERA4 = 4;
    private static final int CODE_CAMERA5 = 5;
    private static final int CODE_CAMERA6 = 6;
    private static final int CODE_CAMERA7 = 7;
    private static final int CODE_CAMERA8 = 8;

    public UnitToiletFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static UnitToiletFragment newInstance(String param1, String param2) {
        UnitToiletFragment fragment = new UnitToiletFragment();
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
        View view = inflater.inflate(R.layout.fragment_unit_toilet, container, false);

        cToiletUnit1 = view.findViewById(R.id.camera_toiletUnit1);
        cToiletUnit2 = view.findViewById(R.id.camera_toiletUnit2);
        cToiletUnit3 = view.findViewById(R.id.camera_toiletUnit3);
        cToiletUnit4 = view.findViewById(R.id.camera_toiletUnit4);
        cToiletUnit5 = view.findViewById(R.id.camera_toiletUnit5);
        cToiletUnit6 = view.findViewById(R.id.camera_toiletUnit6);
        cToiletUnit7 = view.findViewById(R.id.camera_toiletUnit7);
        cToiletUnit8 = view.findViewById(R.id.camera_toiletUnit8);
        cToiletUnit9 = view.findViewById(R.id.camera_toiletUnit9);

        rdGroup1 = view.findViewById(R.id.btn_pilihToiletUnit1);
        rdGroup2 = view.findViewById(R.id.btn_pilihToiletUnit2);
        rdGroup3 = view.findViewById(R.id.btn_pilihToiletUnit3);
        rdGroup4 = view.findViewById(R.id.btn_pilihToiletUnit4);
        rdGroup5 = view.findViewById(R.id.btn_pilihToiletUnit5);
        rdGroup6 = view.findViewById(R.id.btn_pilihToiletUnit6);
        rdGroup7 = view.findViewById(R.id.btn_pilihToiletUnit7);
        rdGroup8 = view.findViewById(R.id.btn_pilihToiletUnit8);
        rdGroup9 = view.findViewById(R.id.btn_pilihToiletUnit9);

        imgToiletUnit1 = view.findViewById(R.id.img_toiletUnit1);
        imgToiletUnit2 = view.findViewById(R.id.img_toiletUnit2);
        imgToiletUnit3 = view.findViewById(R.id.img_toiletUnit3);
        imgToiletUnit4 = view.findViewById(R.id.img_toiletUnit4);
        imgToiletUnit5 = view.findViewById(R.id.img_toiletUnit5);
        imgToiletUnit6 = view.findViewById(R.id.img_toiletUnit6);
        imgToiletUnit7 = view.findViewById(R.id.img_toiletUnit7);
        imgToiletUnit8 = view.findViewById(R.id.img_toiletUnit8);
        imgToiletUnit9 = view.findViewById(R.id.img_toiletUnit9);

        progressDialog = new ProgressDialog(UnitToiletFragment.this.getContext());
        btnSave = view.findViewById(R.id.btn_saveToiletUnit);

        kodeUker = view.findViewById(R.id.name17);
        Unit data = getActivity().getIntent().getParcelableExtra(KODE_UKER17);
        String name = data.getNameUnit();
        kodeUker.setText(name);

        cToiletUnit1.setOnClickListener(this);
        cToiletUnit2.setOnClickListener(this);
        cToiletUnit3.setOnClickListener(this);
        cToiletUnit4.setOnClickListener(this);
        cToiletUnit5.setOnClickListener(this);
        cToiletUnit6.setOnClickListener(this);
        cToiletUnit7.setOnClickListener(this);
        cToiletUnit8.setOnClickListener(this);
        cToiletUnit9.setOnClickListener(this);
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

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.camera_toiletUnit1:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mToiletUnit1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mToiletUnit1, CODE_CAMERA);
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
            case R.id.camera_toiletUnit2:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mToiletUnit2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mToiletUnit2, CODE_CAMERA1);
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
            case R.id.camera_toiletUnit3:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mToiletUnit3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mToiletUnit3, CODE_CAMERA2);
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
            case R.id.camera_toiletUnit4:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mToiletunit4 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mToiletunit4, CODE_CAMERA3);
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
            case R.id.camera_toiletUnit5:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mToiletUnit5 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mToiletUnit5, CODE_CAMERA4);
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
            case R.id.camera_toiletUnit6:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mToiletUnit6 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mToiletUnit6, CODE_CAMERA5);
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
            case R.id.camera_toiletUnit7:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mToiletunit7 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mToiletunit7, CODE_CAMERA6);
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
            case R.id.camera_toiletUnit8:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mToiletUnit8 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mToiletUnit8, CODE_CAMERA7);
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
            case R.id.camera_toiletUnit9:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mToiletUnit9 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mToiletUnit9, CODE_CAMERA8);
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
            case R.id.btn_saveToiletUnit:
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
            imgToiletUnit1.setImageBitmap(bitmap1);
            ImageToString1(getResizeBitmap(bitmap1, 512));
        }

        if (CODE_CAMERA1 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap2 = (Bitmap) data.getExtras().get("data");
            imgToiletUnit2.setImageBitmap(bitmap2);
            ImageToString2(getResizeBitmap(bitmap2, 512));
        }

        if (CODE_CAMERA2 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap3 = (Bitmap) data.getExtras().get("data");
            imgToiletUnit3.setImageBitmap(bitmap3);
            ImageToStirng3(getResizeBitmap(bitmap3, 512));
        }

        if (CODE_CAMERA3 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap4 = (Bitmap) data.getExtras().get("data");
            imgToiletUnit4.setImageBitmap(bitmap4);
            ImageToString4(getResizeBitmap(bitmap4, 512));
        }

        if (CODE_CAMERA4 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap5 = (Bitmap) data.getExtras().get("data");
            imgToiletUnit5.setImageBitmap(bitmap5);
            ImageToString5(getResizeBitmap(bitmap5, 512));
        }

        if (CODE_CAMERA5 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap6 = (Bitmap) data.getExtras().get("data");
            imgToiletUnit6.setImageBitmap(bitmap6);
            ImageToString6(getResizeBitmap(bitmap6, 512));
        }

        if (CODE_CAMERA6 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap7 = (Bitmap) data.getExtras().get("data");
            imgToiletUnit7.setImageBitmap(bitmap7);
            ImageToString7(getResizeBitmap(bitmap7, 512));
        }

        if (CODE_CAMERA7 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap8 = (Bitmap) data.getExtras().get("data");
            imgToiletUnit8.setImageBitmap(bitmap8);
            ImageToStrinh8(getResizeBitmap(bitmap8, 512));
        }

        if (CODE_CAMERA8 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap9 = (Bitmap) data.getExtras().get("data");
            imgToiletUnit9.setImageBitmap(bitmap9);
            ImageToString9(getResizeBitmap(bitmap9, 512));
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

        return Bitmap.createScaledBitmap(image, width, height,true);
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
    private void ImageToStirng3(Bitmap bitmap){
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
    private void ImageToStrinh8(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString8 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void  ImageToString9(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString9 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void uploadImage(){
        if (CheckNetworkConnectiion()){
            progressDialog.show();
            progressDialog.setMessage("Loading...");
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_IMAGE_TOILET_UNIT_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            imgToiletUnit1.setImageResource(R.drawable.ic_check);
                            imgToiletUnit2.setImageResource(R.drawable.ic_check);
                            imgToiletUnit3.setImageResource(R.drawable.ic_check);
                            imgToiletUnit4.setImageResource(R.drawable.ic_check);
                            imgToiletUnit5.setImageResource(R.drawable.ic_check);
                            imgToiletUnit6.setImageResource(R.drawable.ic_check);
                            imgToiletUnit7.setImageResource(R.drawable.ic_check);
                            imgToiletUnit8.setImageResource(R.drawable.ic_check);
                            imgToiletUnit9.setImageResource(R.drawable.ic_check);

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

                if (rdButton1 != null){
                    params.put("stnd1", rdButton1.getText().toString());
                }else {
                    params.put("", rdButton1.toString());
                }
                if (rdButton2 != null){
                    params.put("stnd2", rdButton2.getText().toString());
                }else {
                    params.put("", rdButton3.toString());
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
                    if (encodeImageString1 == null || encodeImageString2 == null || encodeImageString3 == null || encodeImageString4 == null || encodeImageString5 == null ||
                    encodeImageString6 == null || encodeImageString7 == null || encodeImageString8 == null || encodeImageString9 == null){
                        Toast toast = Toast.makeText(getContext(), "Foto harus diisi", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                    }

                    if (rdButton1 == null || rdButton2 == null || rdButton3 == null || rdButton4 == null || rdButton5 == null || rdButton6 == null ||
                    rdButton7 == null || rdButton8 == null || rdButton9 == null){
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
    public boolean CheckNetworkConnectiion(){
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}