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
import android.os.Parcelable;
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
import com.example.monpiss.ActivityFileKC;
import com.example.monpiss.Database.DbContract;
import com.example.monpiss.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ParkirFragment extends Fragment implements View.OnClickListener {

    public static final String KODE_UKER1 = "kode_uker1";

    private String encodeImageString1, encodeImageString2, encodeImageString3;
    private RadioButton rdButton1, rdButton2, rdButton3;
    private RadioButton mStandar1, mStandar2, mStandar3, mTidakStandar1, mTidakStandar2, mTidakStandar3;
    private RadioGroup rdGroup1, rdGroup2, rdGroup3;
    private Button btnSave;
    private ImageView btnCamera1, imgParkirKc1, btnCamera2, imgParkirKc2, btnCamera3, imgParkirKc3;
    private ProgressDialog progressDialog;
    private TextView kodeUker, mHasil;
    public static final int REQUEST_CODE_CAMERA = 0;
    public static final int REQUEST_CODE_CAMERA1 = 1;
    public static final int REQUEST_CODE_CAMERA2 = 2;


    public ParkirFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ParkirFragment newInstance(String param1, String param2) {
        ParkirFragment fragment = new ParkirFragment();
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
        View view = inflater.inflate(R.layout.fragment_parkir, container, false);


        btnCamera1 = view.findViewById(R.id.camera_parkir1);
        btnCamera2 = view.findViewById(R.id.camera_parkir2);
        btnCamera3 = view.findViewById(R.id.camera_parkir3);
        rdGroup1 = view.findViewById(R.id.rg_pilihParkir1);
        rdGroup2 = view.findViewById(R.id.rg_pilihParkir2);
        rdGroup3 = view.findViewById(R.id.rg_pilihParkir3);
        mStandar1 = view.findViewById(R.id.rb_standarParkir1);
        mStandar2 = view.findViewById(R.id.rb_standarParkir2);
        mStandar3 = view.findViewById(R.id.rb_standarParkir3);
        mTidakStandar1 = view.findViewById(R.id.rb_tidakStandarparkir1);
        mTidakStandar2 = view.findViewById(R.id.rb_tidakStandarparkir2);
        mTidakStandar3 = view.findViewById(R.id.rb_tidakStandarparkir3);
        mHasil = view.findViewById(R.id.hasil_monitoring);

        imgParkirKc1 = view.findViewById(R.id.img_parkir1);
        imgParkirKc2 = view.findViewById(R.id.img_parkir2);
        imgParkirKc3 = view.findViewById(R.id.img_parkir3);

        progressDialog = new ProgressDialog(ParkirFragment.this.getContext());
        btnSave = view.findViewById(R.id.btn_saveParkirKC);

        kodeUker = view.findViewById(R.id.name1);
        KC data = getActivity().getIntent().getParcelableExtra(KODE_UKER1);
        String name = data.getKCname();

        kodeUker.setText(name);


        btnCamera1.setOnClickListener(this);
        btnCamera2.setOnClickListener(this);
        btnCamera3.setOnClickListener(this);
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

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.camera_parkir1:
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
            case R.id.camera_parkir2:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent photo2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(photo2, REQUEST_CODE_CAMERA1);
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
            case R.id.camera_parkir3:
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
            case R.id.btn_saveParkirKC:

                if (rdButton1 == mStandar1 && rdButton2 == mStandar2 && rdButton3 == mStandar3){
                    mHasil.setText("100%");
                }else if (rdButton1 == mTidakStandar1 && rdButton2 == mStandar2 && rdButton3 == mStandar3){
                    mHasil.setText("70%");
                }else if (rdButton1 == mStandar1 && rdButton2 == mTidakStandar2 && rdButton3 == mStandar3){
                    mHasil.setText("70%");
                }else if (rdButton1 == mStandar1 && rdButton2 == mStandar2 && rdButton3 == mTidakStandar3){
                    mHasil.setText("70%");
                }else if (rdButton1 == mStandar1 && rdButton2 == mTidakStandar2 && rdButton3 == mTidakStandar3){
                    mHasil.setText("40%");
                }else if (rdButton1 == mTidakStandar1 && rdButton2 == mStandar2 && rdButton3 == mTidakStandar3){
                    mHasil.setText("40%");
                }else if (rdButton1 == mTidakStandar1 && rdButton2 == mTidakStandar2 && rdButton3 == mStandar3){
                    mHasil.setText("40%");
                }else if (rdButton1 == mTidakStandar1 && rdButton2 == mTidakStandar2 && rdButton3 == mTidakStandar3){
                    mHasil.setText("0%");
                } else {
                    mHasil.setText("");
                }

                uploadImage();

                btnSave.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_item));
                break;

        }
    }

    private void sendData() {
        int radioId1 = rdGroup1.getCheckedRadioButtonId();
        int radioId2 = rdGroup2.getCheckedRadioButtonId();
        int radioId3 = rdGroup3.getCheckedRadioButtonId();

        rdButton1 = getView().findViewById(radioId1);
        rdButton2 = getView().findViewById(radioId2);
        rdButton3 = getView().findViewById(radioId3);

        Intent send = new Intent(getContext(), ActivityFileKC.class);
        send.putExtra(ActivityFileKC.KODE_CABANG, kodeUker.getText().toString());
        send.putExtra(ActivityFileKC.KODE_DATA1, rdButton1.getText());
        send.putExtra(ActivityFileKC.KODE_DATA2, rdButton2.getText());
        send.putExtra(ActivityFileKC.KODE_DATA3, rdButton3.getText());
        send.putExtra(ActivityFileKC.KODE_HASIL, mHasil.getText().toString());
        send.putExtra(ActivityFileKC.KODE_IMAGE1, imgParkirKc1.getAdjustViewBounds());
        send.putExtra(ActivityFileKC.KODE_IMAGE2, imgParkirKc2.toString());
        send.putExtra(ActivityFileKC.KODE_IMAGE3, imgParkirKc3.getAdjustViewBounds());
        startActivity(send);
    }



    @Override
    public void onActivityResult(int requestCode,int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

                if (REQUEST_CODE_CAMERA == requestCode && resultCode == Activity.RESULT_OK )
                {
                    Bitmap bitmap1 = (Bitmap) data.getExtras().get("data");
                    imgParkirKc1.setImageBitmap(bitmap1);
                    encodeBitmapImage1(getResizedBitmap(bitmap1, 512));
                }


                if (REQUEST_CODE_CAMERA1 == requestCode && resultCode == Activity.RESULT_OK)
                {
                    Bitmap bitmap2 = (Bitmap) data.getExtras().get("data");
                    imgParkirKc2.setImageBitmap(bitmap2);
                    encodeBitmapImage2(getResizedBitmap(bitmap2, 512));

                }

                if (REQUEST_CODE_CAMERA2 == requestCode && resultCode == Activity.RESULT_OK )
                {
                    Bitmap bitmap3 = (Bitmap) data.getExtras().get("data");
                    imgParkirKc3.setImageBitmap(bitmap3);
                    encodeBitmapImage3(getResizedBitmap(bitmap3, 512));
                }

    }

    public Bitmap getResizedBitmap(Bitmap image, int maxSize){

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

    private void encodeBitmapImage1(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] bytesimage = byteArrayOutputStream.toByteArray();
         encodeImageString1 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);

    }

    private void encodeBitmapImage2(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString2 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);

    }

    private void encodeBitmapImage3(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString3 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);

    }

    private void uploadImage(){
        if (checkNetworkConnection()) {
            progressDialog.show();
            progressDialog.setMessage("Loading...");
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_IMAGE_PARKIR_KC_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            imgParkirKc1.setImageResource(R.drawable.ic_check);
                            imgParkirKc2.setImageResource(R.drawable.ic_check);
                            imgParkirKc3.setImageResource(R.drawable.ic_check);
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
            }) {
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
                    }else{
                        params.put("", encodeImageString2);
                    }

                    if (encodeImageString3 != null){
                        params.put("upload3", encodeImageString3);
                    }else{
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
                    if (encodeImageString1 == null || encodeImageString2 == null || encodeImageString3 == null){
                        Toast toast = Toast.makeText(getContext(), "Foto harus di isi", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                    }else if (rdButton1 == null || rdButton2 == null || rdButton3 == null){
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