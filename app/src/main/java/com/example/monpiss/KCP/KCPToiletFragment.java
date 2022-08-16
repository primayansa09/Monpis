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


public class KCPToiletFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String KODE_UKER11 = "kode_uker11";

    // TODO: Rename and change types of parameters
    private RadioGroup rdGroup1, rdGroup2, rdGroup3, rdGroup4, rdGroup5, rdGroup6, rdGroup7, rdGroup8, rdGroup9;
    private RadioButton rdButton1, rdButton2, rdButton3, rdButton4, rdButton5, rdButton6, rdButton7, rdButton8, rdButton9;
    private ProgressDialog progressDialog;
    private Button btnSave;
    private TextView kodeUker;
    private String mParam2, encodeImageString1, encodeImageString2, encodeImageString3, encodeImageString4, encodeImageString5, encodeImageString6, encodeImageString7,
            encodeImageString8, encodeImageString9;
    private ImageView cToiletKcp1, cToiletKcp2, cToiletKcp3, cToiletKcp4, cToiletKcp5, cToiletKcp6, cToiletKcp7, cToiletKcp8, cToiletKcp9,
                imgToiletKcp1, imgToiletKcp2, imgToiletKcp3, imgToiletKcp4, imgToiletKcp5, imgToiletKcp6, imgToiletKcp7, imgToiletKcp8,imgToiletKcp9;

    private static final int REQUEST_CODE_CAMERA = 0;
    private static final int REQUEST_CODE_CAMERA1 = 1;
    private static final int REQUEST_CODE_CAMERA2 = 2;
    private static final int REQUEST_CODE_CAMERA3 = 3;
    private static final int REQUEST_CODE_CAMERA4 = 4;
    private static final int REQUEST_CODE_CAMERA5 = 5;
    private static final int REQUEST_CODE_CAMERA6 = 6;
    private static final int REQUEST_CODE_CAMERA7 = 7;
    private static final int REQUEST_CODE_CAMERA8 = 8;

    public KCPToiletFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static KCPToiletFragment newInstance(String param1, String param2) {
        KCPToiletFragment fragment = new KCPToiletFragment();
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
        View view = inflater.inflate(R.layout.fragment_kcp_toilet, container, false);
        cToiletKcp1 = view.findViewById(R.id.camera_toiletKCP1);
        cToiletKcp2 = view.findViewById(R.id.camera_toiletKCP2);
        cToiletKcp3 = view.findViewById(R.id.camera_toiletKCP3);
        cToiletKcp4 = view.findViewById(R.id.camera_toiletKCP4);
        cToiletKcp5 = view.findViewById(R.id.camera_toiletKCP5);
        cToiletKcp6 = view.findViewById(R.id.camera_toiletKCP6);
        cToiletKcp7 = view.findViewById(R.id.camera_toiletKCP7);
        cToiletKcp8 = view.findViewById(R.id.camera_toiletKCP8);
        cToiletKcp9 = view.findViewById(R.id.camera_toiletKCP9);

        rdGroup1 = view.findViewById(R.id.btn_pilihToiletKCP1);
        rdGroup2 = view.findViewById(R.id.btn_pilihToiletKCP2);
        rdGroup3 = view.findViewById(R.id.btn_pilihToiletKCP3);
        rdGroup4 = view.findViewById(R.id.btn_pilihToiletKCP4);
        rdGroup5 = view.findViewById(R.id.btn_pilihToiletKCP5);
        rdGroup6 = view.findViewById(R.id.btn_pilihToiletKCP6);
        rdGroup7 = view.findViewById(R.id.btn_pilihToiletKCP7);
        rdGroup8 = view.findViewById(R.id.btn_pilihToiletKCP8);
        rdGroup9 = view.findViewById(R.id.btn_pilihToiletKCP9);

        imgToiletKcp1 = view.findViewById(R.id.img_toiletKCP1);
        imgToiletKcp2 = view.findViewById(R.id.img_toiletKCP2);
        imgToiletKcp3 = view.findViewById(R.id.img_toiletKCP3);
        imgToiletKcp4 = view.findViewById(R.id.img_toiletKCP4);
        imgToiletKcp5 = view.findViewById(R.id.img_toiletKCP5);
        imgToiletKcp6 = view.findViewById(R.id.img_toiletKCP6);
        imgToiletKcp7 = view.findViewById(R.id.img_toiletKCP7);
        imgToiletKcp8 = view.findViewById(R.id.img_toiletKCP8);
        imgToiletKcp9 = view.findViewById(R.id.img_toiletKCP9);

        progressDialog = new ProgressDialog(KCPToiletFragment.this.getContext());
        btnSave = view.findViewById(R.id.btn_saveToiletKCP);

        kodeUker = view.findViewById(R.id.name11);
        KCP data = getActivity().getIntent().getParcelableExtra(KODE_UKER11);
        String name = data.getNameKCP();
        kodeUker.setText(name);

        cToiletKcp1.setOnClickListener(this);
        cToiletKcp2.setOnClickListener(this);
        cToiletKcp3.setOnClickListener(this);
        cToiletKcp4.setOnClickListener(this);
        cToiletKcp5.setOnClickListener(this);
        cToiletKcp6.setOnClickListener(this);
        cToiletKcp7.setOnClickListener(this);
        cToiletKcp8.setOnClickListener(this);
        cToiletKcp9.setOnClickListener(this);
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
            case R.id.camera_toiletKCP1:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mToiletkcp1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mToiletkcp1, REQUEST_CODE_CAMERA);
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
            case R.id.camera_toiletKCP2:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mToiletkcp2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mToiletkcp2, REQUEST_CODE_CAMERA1);
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
            case R.id.camera_toiletKCP3:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mToiletKcp3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mToiletKcp3, REQUEST_CODE_CAMERA2);
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
            case R.id.camera_toiletKCP4:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mToiletkcp4 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mToiletkcp4, REQUEST_CODE_CAMERA3);
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
            case R.id.camera_toiletKCP5:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mToiletKcp5 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mToiletKcp5, REQUEST_CODE_CAMERA4);
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
            case R.id.camera_toiletKCP6:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mToiletKcp6 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mToiletKcp6, REQUEST_CODE_CAMERA5);
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
            case R.id.camera_toiletKCP7:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mToiletKcp7 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mToiletKcp7, REQUEST_CODE_CAMERA6);
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
            case R.id.camera_toiletKCP8:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mToiletKcp8 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mToiletKcp8, REQUEST_CODE_CAMERA7);
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
            case R.id.camera_toiletKCP9:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mToiletKcp9 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mToiletKcp9, REQUEST_CODE_CAMERA8);
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
            case R.id.btn_saveToiletKCP:
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
            imgToiletKcp1.setImageBitmap(bitmap1);
            ImageToString1(getResizeBitmap(bitmap1, 512));
        }

        if (REQUEST_CODE_CAMERA1 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap2 = (Bitmap) data.getExtras().get("data");
            imgToiletKcp2.setImageBitmap(bitmap2);
            ImageToString2(getResizeBitmap(bitmap2, 512));
        }

        if (REQUEST_CODE_CAMERA2 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap3 = (Bitmap) data.getExtras().get("data");
            imgToiletKcp3.setImageBitmap(bitmap3);
            ImageToString3(getResizeBitmap(bitmap3, 512));
        }

        if (REQUEST_CODE_CAMERA3 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap4 = (Bitmap) data.getExtras().get("data");
            imgToiletKcp4.setImageBitmap(bitmap4);
            ImageToString4(getResizeBitmap(bitmap4, 512));
        }

        if (REQUEST_CODE_CAMERA4 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap5 = (Bitmap) data.getExtras().get("data");
            imgToiletKcp5.setImageBitmap(bitmap5);
            ImageToString5(getResizeBitmap(bitmap5, 512));
        }

        if (REQUEST_CODE_CAMERA5 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap6 = (Bitmap) data.getExtras().get("data");
            imgToiletKcp6.setImageBitmap(bitmap6);
            ImageToString6(getResizeBitmap(bitmap6, 512));
        }

        if (REQUEST_CODE_CAMERA6 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap7 = (Bitmap) data.getExtras().get("data");
            imgToiletKcp7.setImageBitmap(bitmap7);
            ImageToString7(getResizeBitmap(bitmap7, 512));
        }

        if (REQUEST_CODE_CAMERA7 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap8 = (Bitmap) data.getExtras().get("data");
            imgToiletKcp8.setImageBitmap(bitmap8);
            ImageToString8(getResizeBitmap(bitmap8, 512));
        }

        if (REQUEST_CODE_CAMERA8 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap9 = (Bitmap) data.getExtras().get("data");
            imgToiletKcp9.setImageBitmap(bitmap9);
            ImageToString9(getResizeBitmap(bitmap9, 512));
        }
    }

    private Bitmap getResizeBitmap(Bitmap image, int maxSize){
        int widht = image.getWidth();
        int height = image.getHeight();

        float bitmapRotasi = (float) widht / (float) height;
        if (bitmapRotasi > 1){
            widht = maxSize;
            height = (int) (widht / bitmapRotasi);
        }else{
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
    private void UploadImage(){
        if (ChecknetworkConnection()){
            progressDialog.show();
            progressDialog.setMessage("Loading...");
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_IMAGE_TOILET_KCP_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            imgToiletKcp1.setImageResource(R.drawable.ic_check);
                            imgToiletKcp2.setImageResource(R.drawable.ic_check);
                            imgToiletKcp3.setImageResource(R.drawable.ic_check);
                            imgToiletKcp4.setImageResource(R.drawable.ic_check);
                            imgToiletKcp5.setImageResource(R.drawable.ic_check);
                            imgToiletKcp6.setImageResource(R.drawable.ic_check);
                            imgToiletKcp7.setImageResource(R.drawable.ic_check);
                            imgToiletKcp8.setImageResource(R.drawable.ic_check);
                            imgToiletKcp9.setImageResource(R.drawable.ic_check);

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
                            Toast toast = Toast.makeText(getContext(), "Upload gagal", Toast.LENGTH_SHORT);
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
                    if (encodeImageString1 == null || encodeImageString2 == null || encodeImageString3 == null || encodeImageString4 == null ||
                    encodeImageString5 == null || encodeImageString6 == null || encodeImageString7 == null || encodeImageString8 == null || encodeImageString9 == null){
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
    public boolean ChecknetworkConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}