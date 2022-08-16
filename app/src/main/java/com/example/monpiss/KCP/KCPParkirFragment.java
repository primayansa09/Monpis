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
import android.widget.ProgressBar;
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
import com.example.monpiss.KC.KC;
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


public class KCPParkirFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String KODE_UKER7 = "kode_uker7";

    private RadioGroup rdGroup1, rdGroup2, rdGroup3;
    private RadioButton rdButton1, rdButton2, rdButton3;
    private ProgressDialog progressDialog;
    private Button btnSave;
    private TextView kodeUker;
    private String mParam1;
    private String mParam2, encodeImageString1, encodeImageString2, encodeImageString3;
    private ImageView btnCamera1, imgParkirKcp1, btnCamera2, imgParkirKcp2, btnCamera3, imgParkirKcp3;
    private static final int REQUEST_CODE_CAMERA = 0;
    private static final int REQUEST_CODE_CAMERA1 = 1;
    private static final int REQUEST_CODE_CAMERA2 = 2;

    public KCPParkirFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static KCPParkirFragment newInstance(String param1, String param2) {
        KCPParkirFragment fragment = new KCPParkirFragment();
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
        View view = inflater.inflate(R.layout.fragment_kcp_parkir, container, false);

        btnCamera1 = view.findViewById(R.id.camera_parkir_kcp1);
        btnCamera2 = view.findViewById(R.id.camera_parkir_kcp2);
        btnCamera3 = view.findViewById(R.id.camera_parkir_kcp3);

        rdGroup1 = view.findViewById(R.id.btn_pilihParkirKcp1);
        rdGroup2 = view.findViewById(R.id.btn_pilihParkirKcp2);
        rdGroup3 = view.findViewById(R.id.btn_pilihParkirKcp3);

        imgParkirKcp1 = view.findViewById(R.id.img_parkir_kcp1);
        imgParkirKcp2 = view.findViewById(R.id.img_parkir_kcp2);
        imgParkirKcp3 = view.findViewById(R.id.img_parkir_kcp3);
        progressDialog = new ProgressDialog(KCPParkirFragment.this.getContext());
        btnSave = view.findViewById(R.id.btn_saveParkirKCP);

        kodeUker = view.findViewById(R.id.name7);
        KCP data = getActivity().getIntent().getParcelableExtra(KODE_UKER7);
        String name = data.getNameKCP();
        kodeUker.setText(name);

        btnSave.setOnClickListener(this);
        btnCamera1.setOnClickListener(this);
        btnCamera2.setOnClickListener(this);
        btnCamera3.setOnClickListener(this);

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

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.camera_parkir_kcp1:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mCamera, REQUEST_CODE_CAMERA);
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
            case R.id.camera_parkir_kcp2:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mCamera1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mCamera1, REQUEST_CODE_CAMERA1);
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
            case R.id.camera_parkir_kcp3:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mCamera2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mCamera2, REQUEST_CODE_CAMERA2);
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
            case R.id.btn_saveParkirKCP:
                UploadImage();
                btnSave.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_item));
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_CODE_CAMERA == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgParkirKcp1.setImageBitmap(bitmap);
            ImageToString1(getResizeBitmap(bitmap, 512));
        }

        if (REQUEST_CODE_CAMERA1 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap1 = (Bitmap) data.getExtras().get("data");
            imgParkirKcp2.setImageBitmap(bitmap1);
            ImageToString2(getResizeBitmap(bitmap1, 512));
        }

        if (REQUEST_CODE_CAMERA2 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap2 = (Bitmap) data.getExtras().get("data");
            imgParkirKcp3.setImageBitmap(bitmap2);
            ImageToString3(getResizeBitmap(bitmap2, 512));
        }
    }

    private Bitmap getResizeBitmap(Bitmap image , int maxSize){
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
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString3 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void UploadImage(){
        if (CheckNetworkConnection()){
            progressDialog.show();
            progressDialog.setMessage("Loading...");
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_IMAGE_PARKIR_KCP_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                                imgParkirKcp1.setImageResource(R.drawable.ic_check);
                                imgParkirKcp2.setImageResource(R.drawable.ic_check);
                                imgParkirKcp3.setImageResource(R.drawable.ic_check);
                                rdButton1.setChecked(false);
                                rdButton2.setChecked(false);
                                rdButton3.setChecked(false);
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
                    if (encodeImageString1 == null || encodeImageString2 == null || encodeImageString3 == null){
                        Toast toast = Toast.makeText(getContext(), "Foto harus diisi", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                    }

                    if (rdButton1 == null || rdButton2 == null || rdButton3 == null){
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