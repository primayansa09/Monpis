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

public class UnitATMFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String KODE_UKER15 = "kode_uker15";

    // TODO: Rename and change types of parameters
    private RadioGroup rdGroup1, rdGroup2, rdGroup3, rdGroup4, rdGroup5, rdGroup6, rdGroup7, rdGroup8, rdGroup9, rdGroup10, rdGroup11, rdGroup12,
            rdGroup13, rdGroup14, rdGroup15, rdGroup16, rdGroup17, rdGroup18, rdGroup19, rdGroup20, rdGroup21, rdGroup22, rdGroup23, rdGroup24, rdGroup25, rdGroup26;
    private RadioButton rdButton1, rdButton2, rdButton3, rdButton4, rdButton5, rdButton6, rdButton7, rdButton8, rdButton9, rdButton10, rdButton11, rdButton12, rdButton13,
            rdButton14, rdButton15, rdButton16, rdButton17, rdButton18, rdButton19 ,rdButton20, rdButton21, rdButton22, rdButton23, rdButton24, rdButton25, rdButton26;
    private ProgressDialog progressDialog;
    private Button btnSave;
    private TextView kodeUker;
    private String mParam2, encodeImageString1, encodeImageString2, encodeImageString3, encodeImageString4, encodeImageString5, encodeImageString6, encodeImageString7, encodeImageString8, encodeImageString9,
    encodeImageString10, encodeImageString11, encodeImageString12, encodeImageString13, encodeImageString14, encodeImageString15, encodeImageString16, encodeImageString17, encodeImageString18,
    encodeImageString19, encodeImageString20, encodeImageString21, encodeImageString22, encodeImageString23, encodeImageString24, encodeImageString25, encodeImageString26;
    private ImageView cAtmUnit1, cAtmUnit2, cAtmUnit3, cAtmUnit4, cAtmUnit5, cAtmUnit6, cAtmUnit7, cAtmUnit8, cAtmUnit9, cAtmUnit10,
            cAtmUnit11, cAtmUnit12, cAtmUnit13, cAtmUnit14, cAtmUnit15, cAtmUnit16, cAtmUnit17, cAtmUnit18, cAtmUnit19, cAtmUnit20, cAtmUnit21,
            cAtmUnit22, cAtmUnit23, cAtmUnit24, cAtmUnit25, cAtmUnit26;

    private ImageView imgAtmUnit1, imgAtmUnit2, imgAtmUnit3, imgAtmUnit4, imgAtmUnit5, imgAtmUnit6, imgAtmUnit7, imgAtmUnit8, imgAtmUnit9, imgAtmUnit10,
            imgAtmUnit11, imgAtmUnit12, imgAtmUnit13, imgAtmUnit14, imgAtmUnit15, imgAtmUnit16, imgAtmUnit17, imgAtmUnit18, imgAtmUnit19, imgAtmUnit20, imgAtmUnit21,
            imgAtmUnit22, imgAtmUnit23, imgAtmUnit24, imgAtmUnit25, imgAtmUnit26;

    private static final int CODE_CAMERA = 0; private static final int CODE_CAMERA14 = 14;
    private static final int CODE_CAMERA1 = 1; private static final int CODE_CAMERA15 = 15;
    private static final int CODE_CAMERA2 = 2; private static final int CODE_CAMERA16 = 16;
    private static final int CODE_CAMERA3 = 3; private static final int CODE_CAMERA17 = 17;
    private static final int CODE_CAMERA4 = 4; private static final int CODE_CAMERA18 = 18;
    private static final int CODE_CAMERA5 = 5; private static final int CODE_CAMERA19 = 19;
    private static final int CODE_CAMERA6 = 6; private static final int CODE_CAMERA20 = 20;
    private static final int CODE_CAMERA7 = 7; private static final int CODE_CAMERA21 = 21;
    private static final int CODE_CAMERA8 = 8; private static final int CODE_CAMERA22 = 22;
    private static final int CODE_CAMERA9 = 9; private static final int CODE_CAMERA23 = 23;
    private static final int CODE_CAMERA10 = 10; private static final int CODE_CAMERA24 = 24;
    private static final int CODE_CAMERA11 = 11; private static final int CODE_CAMERA25 = 25;
    private static final int CODE_CAMERA12 = 12;
    private static final int CODE_CAMERA13 = 13;

    public UnitATMFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static UnitATMFragment newInstance(String param1, String param2) {
        UnitATMFragment fragment = new UnitATMFragment();
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
        View view = inflater.inflate(R.layout.fragment_unit_atm, container, false);

        cAtmUnit1 = view.findViewById(R.id.camera_atm_unit1); cAtmUnit17 = view.findViewById(R.id.camera_atm_unit17);
        cAtmUnit2 = view.findViewById(R.id.camera_atm_unit2); cAtmUnit18 = view.findViewById(R.id.camera_atm_unit18);
        cAtmUnit3 = view.findViewById(R.id.camera_atm_unit3); cAtmUnit19 = view.findViewById(R.id.camera_atm_unit19);
        cAtmUnit4 = view.findViewById(R.id.camera_atm_unit4); cAtmUnit20 = view.findViewById(R.id.camera_atm_unit20);
        cAtmUnit5 = view.findViewById(R.id.camera_atm_unit5); cAtmUnit21 = view.findViewById(R.id.camera_atm_unit21);
        cAtmUnit6 = view.findViewById(R.id.camera_atm_unit6); cAtmUnit22 = view.findViewById(R.id.camera_atm_unit22);
        cAtmUnit7 = view.findViewById(R.id.camera_atm_unit7); cAtmUnit23 = view.findViewById(R.id.camera_atm_unit23);
        cAtmUnit8 = view.findViewById(R.id.camera_atm_unit8); cAtmUnit24 = view.findViewById(R.id.camera_atm_unit24);
        cAtmUnit9 = view.findViewById(R.id.camera_atm_unit9); cAtmUnit25 = view.findViewById(R.id.camera_atm_unit25);
        cAtmUnit10 = view.findViewById(R.id.camera_atm_unit10); cAtmUnit26 = view.findViewById(R.id.camera_atm_unit26);
        cAtmUnit11 = view.findViewById(R.id.camera_atm_unit11);
        cAtmUnit12 = view.findViewById(R.id.camera_atm_unit12);
        cAtmUnit13 = view.findViewById(R.id.camera_atm_unit13);
        cAtmUnit14 = view.findViewById(R.id.camera_atm_unit14);
        cAtmUnit15 = view.findViewById(R.id.camera_atm_unit15);
        cAtmUnit16 = view.findViewById(R.id.camera_atm_unit16);

        rdGroup1 = view.findViewById(R.id.btn_pilihAtmUnit1); rdGroup14 = view.findViewById(R.id.btn_pilihAtmUnit14);
        rdGroup2 = view.findViewById(R.id.btn_pilihAtmUnit2); rdGroup15 = view.findViewById(R.id.btn_pilihAtmUnit15);
        rdGroup3 = view.findViewById(R.id.btn_pilihAtmUnit3); rdGroup16 = view.findViewById(R.id.btn_pilihAtmUnit16);
        rdGroup4 = view.findViewById(R.id.btn_pilihAtmUnit4); rdGroup17 = view.findViewById(R.id.btn_pilihAtmUnit17);
        rdGroup5 = view.findViewById(R.id.btn_pilihAtmUnit5); rdGroup18 = view.findViewById(R.id.btn_pilihAtmUnit18);
        rdGroup6 = view.findViewById(R.id.btn_pilihAtmUnit6); rdGroup19 = view.findViewById(R.id.btn_pilihAtmUnit19);
        rdGroup7 = view.findViewById(R.id.btn_pilihAtmUnit7); rdGroup20 = view.findViewById(R.id.btn_pilihAtmUnit20);
        rdGroup8 = view.findViewById(R.id.btn_pilihAtmUnit8); rdGroup21 = view.findViewById(R.id.btn_pilihAtmUnit21);
        rdGroup9 = view.findViewById(R.id.btn_pilihAtmUnit9); rdGroup22 = view.findViewById(R.id.btn_pilihAtmUnit22);
        rdGroup10 = view.findViewById(R.id.btn_pilihAtmUnit10); rdGroup23 = view.findViewById(R.id.btn_pilihAtmUnit23);
        rdGroup11 = view.findViewById(R.id.btn_pilihAtmUnit11); rdGroup24 = view.findViewById(R.id.btn_pilihAtmUnit24);
        rdGroup12 = view.findViewById(R.id.btn_pilihAtmUnit12); rdGroup25 = view.findViewById(R.id.btn_pilihAtmUnit25);
        rdGroup13 = view.findViewById(R.id.btn_pilihAtmUnit13); rdGroup26 = view.findViewById(R.id.btn_pilihAtmUnit26);

        imgAtmUnit1 = view.findViewById(R.id.img_atm_unit1); imgAtmUnit17 = view.findViewById(R.id.img_atm_unit17);
        imgAtmUnit2 = view.findViewById(R.id.img_atm_unit2); imgAtmUnit18 = view.findViewById(R.id.img_atm_unit18);
        imgAtmUnit3 = view.findViewById(R.id.img_atm_unit3); imgAtmUnit19 = view.findViewById(R.id.img_atm_unit19);
        imgAtmUnit4 = view.findViewById(R.id.img_atm_unit4); imgAtmUnit20 = view.findViewById(R.id.img_atm_unit20);
        imgAtmUnit5 = view.findViewById(R.id.img_atm_unit5); imgAtmUnit21 = view.findViewById(R.id.img_atm_unit21);
        imgAtmUnit6 = view.findViewById(R.id.img_atm_unit6); imgAtmUnit22 = view.findViewById(R.id.img_atm_unit22);
        imgAtmUnit7 = view.findViewById(R.id.img_atm_unit7); imgAtmUnit23 = view.findViewById(R.id.img_atm_unit23);
        imgAtmUnit8 = view.findViewById(R.id.img_atm_unit8); imgAtmUnit24 = view.findViewById(R.id.img_atm_unit24);
        imgAtmUnit9 = view.findViewById(R.id.img_atm_unit9); imgAtmUnit25 = view.findViewById(R.id.img_atm_unit25);
        imgAtmUnit10 = view.findViewById(R.id.img_atm_unit10); imgAtmUnit26 = view.findViewById(R.id.img_atm_unit26);
        imgAtmUnit11 = view.findViewById(R.id.img_atm_unit11);
        imgAtmUnit12 = view.findViewById(R.id.img_atm_unit12);
        imgAtmUnit13 = view.findViewById(R.id.img_atm_unit13);
        imgAtmUnit14 = view.findViewById(R.id.img_atm_unit14);
        imgAtmUnit15 = view.findViewById(R.id.img_atm_unit15);
        imgAtmUnit16 = view.findViewById(R.id.img_atm_unit16);

        progressDialog = new ProgressDialog(UnitATMFragment.this.getContext());
        btnSave = view.findViewById(R.id.btn_saveAtmUnit);

        kodeUker = view.findViewById(R.id.name15);
        Unit data = getActivity().getIntent().getParcelableExtra(KODE_UKER15);
        String name = data.getNameUnit();
        kodeUker.setText(name);

        cAtmUnit1.setOnClickListener(this); cAtmUnit21.setOnClickListener(this);
        cAtmUnit2.setOnClickListener(this); cAtmUnit22.setOnClickListener(this);
        cAtmUnit3.setOnClickListener(this); cAtmUnit23.setOnClickListener(this);
        cAtmUnit4.setOnClickListener(this); cAtmUnit24.setOnClickListener(this);
        cAtmUnit5.setOnClickListener(this); cAtmUnit25.setOnClickListener(this);
        cAtmUnit6.setOnClickListener(this); cAtmUnit26.setOnClickListener(this);
        cAtmUnit7.setOnClickListener(this); btnSave.setOnClickListener(this);
        cAtmUnit8.setOnClickListener(this);
        cAtmUnit9.setOnClickListener(this);
        cAtmUnit10.setOnClickListener(this);
        cAtmUnit11.setOnClickListener(this);
        cAtmUnit12.setOnClickListener(this);
        cAtmUnit13.setOnClickListener(this);
        cAtmUnit14.setOnClickListener(this);
        cAtmUnit15.setOnClickListener(this);
        cAtmUnit16.setOnClickListener(this);
        cAtmUnit17.setOnClickListener(this);
        cAtmUnit18.setOnClickListener(this);
        cAtmUnit19.setOnClickListener(this);
        cAtmUnit20.setOnClickListener(this);
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
        rdGroup18.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton18 = getView().findViewById(checkedId);
            }
        });
        rdGroup19.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton19 = getView().findViewById(checkedId);
            }
        });
        rdGroup20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton20 = getView().findViewById(checkedId);
            }
        });
        rdGroup21.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton21 = getView().findViewById(checkedId);
            }
        });
        rdGroup22.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton22 = getView().findViewById(checkedId);
            }
        });
        rdGroup23.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton23 = getView().findViewById(checkedId);
            }
        });
        rdGroup24.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton24 = getView().findViewById(checkedId);
            }
        });
        rdGroup25.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton25 = getView().findViewById(checkedId);
            }
        });
        rdGroup26.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdButton26 = getView().findViewById(checkedId);
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.camera_atm_unit1:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit1, CODE_CAMERA);
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
            case R.id.camera_atm_unit2:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit2, CODE_CAMERA1);
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
            case R.id.camera_atm_unit3:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mAtmUnit3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mAtmUnit3, CODE_CAMERA2);
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
            case R.id.camera_atm_unit4:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit4 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit4, CODE_CAMERA3);
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
            case R.id.camera_atm_unit5:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit5 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit5, CODE_CAMERA4);
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
            case R.id.camera_atm_unit6:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit6 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit6, CODE_CAMERA5);
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
            case R.id.camera_atm_unit7:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit7 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit7, CODE_CAMERA6);
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
            case R.id.camera_atm_unit8:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit8 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit8, CODE_CAMERA7);
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
            case R.id.camera_atm_unit9:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit9 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit9, CODE_CAMERA8);
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
            case R.id.camera_atm_unit10:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit10 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit10, CODE_CAMERA9);
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
            case R.id.camera_atm_unit11:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit11 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit11, CODE_CAMERA10);
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
            case R.id.camera_atm_unit12:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit12 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit12, CODE_CAMERA11);
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
            case R.id.camera_atm_unit13:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mAtmUnit13 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mAtmUnit13, CODE_CAMERA12);
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
            case R.id.camera_atm_unit14:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit14 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit14, CODE_CAMERA13);
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
            case R.id.camera_atm_unit15:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit15 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit15, CODE_CAMERA14);
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
            case R.id.camera_atm_unit16:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit16 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit16, CODE_CAMERA15);
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
            case R.id.camera_atm_unit17:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit17 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit17, CODE_CAMERA16);
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
            case R.id.camera_atm_unit18:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit18 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit18, CODE_CAMERA17);
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
            case R.id.camera_atm_unit19:
               Dexter.withContext(getContext().getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                               Intent mAtmUnit19 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                               startActivityForResult(mAtmUnit19, CODE_CAMERA18);
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
            case R.id.camera_atm_unit20:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit20 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit20, CODE_CAMERA19);
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
            case R.id.camera_atm_unit21:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit21 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit21, CODE_CAMERA20);
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
            case R.id.camera_atm_unit22:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit22 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit22, CODE_CAMERA21);
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
            case R.id.camera_atm_unit23:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit23 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit23, CODE_CAMERA22);
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
            case R.id.camera_atm_unit24:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit24 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit24, CODE_CAMERA23);
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
            case R.id.camera_atm_unit25:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit25 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit25, CODE_CAMERA24);
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
            case R.id.camera_atm_unit26:
                Dexter.withContext(getContext().getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent mAtmUnit26 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(mAtmUnit26, CODE_CAMERA25);
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
            case R.id.btn_saveAtmUnit:
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
            imgAtmUnit1.setImageBitmap(bitmap1);
            ImageToString1(getResizeBitmap(bitmap1, 512));
        }

        if (CODE_CAMERA1 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap2 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit2.setImageBitmap(bitmap2);
            ImageToString2(getResizeBitmap(bitmap2, 512));
        }

        if (CODE_CAMERA2 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap3 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit3.setImageBitmap(bitmap3);
            ImageToString3(getResizeBitmap(bitmap3, 512));
        }

        if (CODE_CAMERA3 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap4 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit4.setImageBitmap(bitmap4);
            ImageToString4(getResizeBitmap(bitmap4, 512));
        }

        if (CODE_CAMERA4 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap5 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit5.setImageBitmap(bitmap5);
            ImageToString5(getResizeBitmap(bitmap5, 512));
        }

        if (CODE_CAMERA5 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap6 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit6.setImageBitmap(bitmap6);
            ImageToString6(getResizeBitmap(bitmap6, 512));
        }

        if (CODE_CAMERA6 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap7 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit7.setImageBitmap(bitmap7);
            ImageToString7(getResizeBitmap(bitmap7, 512));
        }

        if (CODE_CAMERA7 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap8 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit8.setImageBitmap(bitmap8);
            ImageToString8(getResizeBitmap(bitmap8, 512));
        }

        if (CODE_CAMERA8 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap9 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit9.setImageBitmap(bitmap9);
            ImageToString9(getResizeBitmap(bitmap9, 512));
        }

        if (CODE_CAMERA9 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap10 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit10.setImageBitmap(bitmap10);
            ImageToString10(getResizeBitmap(bitmap10, 512));
        }

        if (CODE_CAMERA10 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap11 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit11.setImageBitmap(bitmap11);
            ImageToString11(getResizeBitmap(bitmap11, 512));
        }

        if (CODE_CAMERA11 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap12 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit12.setImageBitmap(bitmap12);
            ImageToString12(getResizeBitmap(bitmap12, 512));
        }

        if (CODE_CAMERA12 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap13 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit13.setImageBitmap(bitmap13);
            ImageToString13(getResizeBitmap(bitmap13, 512));
        }

        if (CODE_CAMERA13 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap14 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit14.setImageBitmap(bitmap14);
            ImageToString14(getResizeBitmap(bitmap14, 512));
        }

        if (CODE_CAMERA14 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap15 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit15.setImageBitmap(bitmap15);
            ImageToString15(getResizeBitmap(bitmap15, 512));
        }

        if (CODE_CAMERA15 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap16 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit16.setImageBitmap(bitmap16);
            ImageToString16(getResizeBitmap(bitmap16, 512));
        }

        if (CODE_CAMERA16 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap17 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit17.setImageBitmap(bitmap17);
            ImageToString17(getResizeBitmap(bitmap17, 512));
        }

        if (CODE_CAMERA17 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap18 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit18.setImageBitmap(bitmap18);
            ImageToString18(getResizeBitmap(bitmap18, 512));
        }

        if (CODE_CAMERA18 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap19 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit19.setImageBitmap(bitmap19);
            ImageToString19(getResizeBitmap(bitmap19, 512));
        }

        if (CODE_CAMERA19 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap20 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit20.setImageBitmap(bitmap20);
            ImageToString20(getResizeBitmap(bitmap20, 512));
        }

        if (CODE_CAMERA20 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap21 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit21.setImageBitmap(bitmap21);
            ImageToString21(getResizeBitmap(bitmap21, 512));
        }

        if (CODE_CAMERA21 ==requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap22 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit22.setImageBitmap(bitmap22);
            ImageToString22(getResizeBitmap(bitmap22, 512));
        }

        if (CODE_CAMERA22 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap23 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit23.setImageBitmap(bitmap23);
            ImageToStrin23(getResizeBitmap(bitmap23, 512));
        }

        if (CODE_CAMERA23 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap24 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit24.setImageBitmap(bitmap24);
            ImageToString24(getResizeBitmap(bitmap24, 512));
        }

        if (CODE_CAMERA24 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap25 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit25.setImageBitmap(bitmap25);
            ImageToString25(getResizeBitmap(bitmap25, 512));
        }

        if (CODE_CAMERA25 == requestCode && resultCode == Activity.RESULT_OK){
            Bitmap bitmap26 = (Bitmap) data.getExtras().get("data");
            imgAtmUnit26.setImageBitmap(bitmap26);
            ImageToString26(getResizeBitmap(bitmap26, 512));
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
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100 , byteArrayOutputStream);
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
    private void ImageToString18(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString18 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString19(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString19 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString20(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString20 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString21(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString21 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString22(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString22 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToStrin23(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString23 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString24(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString24 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString25(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString25 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void ImageToString26(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytesimage = byteArrayOutputStream.toByteArray();
        encodeImageString26 = android.util.Base64.encodeToString(bytesimage, Base64.DEFAULT);
    }
    private void uploadImage(){
        if (CheckNetworkConnection()){
            progressDialog.show();
            progressDialog.setMessage("Loading...");
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_IMAGE_ATM_UNIT_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                        imgAtmUnit1.setImageResource(R.drawable.ic_check); imgAtmUnit17.setImageResource(R.drawable.ic_check);
                        imgAtmUnit2.setImageResource(R.drawable.ic_check); imgAtmUnit18.setImageResource(R.drawable.ic_check);
                        imgAtmUnit3.setImageResource(R.drawable.ic_check); imgAtmUnit19.setImageResource(R.drawable.ic_check);
                        imgAtmUnit4.setImageResource(R.drawable.ic_check); imgAtmUnit20.setImageResource(R.drawable.ic_check);
                        imgAtmUnit5.setImageResource(R.drawable.ic_check); imgAtmUnit21.setImageResource(R.drawable.ic_check);
                        imgAtmUnit6.setImageResource(R.drawable.ic_check); imgAtmUnit22.setImageResource(R.drawable.ic_check);
                        imgAtmUnit7.setImageResource(R.drawable.ic_check); imgAtmUnit23.setImageResource(R.drawable.ic_check);
                        imgAtmUnit8.setImageResource(R.drawable.ic_check); imgAtmUnit24.setImageResource(R.drawable.ic_check);
                        imgAtmUnit9.setImageResource(R.drawable.ic_check); imgAtmUnit25.setImageResource(R.drawable.ic_check);
                        imgAtmUnit10.setImageResource(R.drawable.ic_check); imgAtmUnit26.setImageResource(R.drawable.ic_check);
                        imgAtmUnit11.setImageResource(R.drawable.ic_check);
                        imgAtmUnit12.setImageResource(R.drawable.ic_check);
                        imgAtmUnit13.setImageResource(R.drawable.ic_check);
                        imgAtmUnit14.setImageResource(R.drawable.ic_check);
                        imgAtmUnit15.setImageResource(R.drawable.ic_check);
                        imgAtmUnit16.setImageResource(R.drawable.ic_check);

                        rdButton1.setChecked(false); rdButton11.setChecked(false); rdButton21.setChecked(false);
                        rdButton2.setChecked(false); rdButton12.setChecked(false); rdButton22.setChecked(false);
                        rdButton3.setChecked(false); rdButton13.setChecked(false); rdButton23.setChecked(false);
                        rdButton4.setChecked(false); rdButton14.setChecked(false); rdButton24.setChecked(false);
                        rdButton5.setChecked(false); rdButton15.setChecked(false); rdButton25.setChecked(false);
                        rdButton6.setChecked(false); rdButton16.setChecked(false); rdButton26.setChecked(false);
                        rdButton7.setChecked(false); rdButton17.setChecked(false);
                        rdButton8.setChecked(false); rdButton18.setChecked(false);
                        rdButton9.setChecked(false); rdButton19.setChecked(false);
                        rdButton10.setChecked(false); rdButton20.setChecked(false);
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
                        params.put("", encodeImageString6);
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

                    if (encodeImageString18 != null){
                        params.put("upload18", encodeImageString18);
                    }else {
                        params.put("", encodeImageString18);
                    }

                    if (encodeImageString19 != null){
                        params.put("upload19", encodeImageString19);
                    }else {
                        params.put("", encodeImageString19);
                    }

                    if (encodeImageString20 != null){
                        params.put("upload20", encodeImageString20);
                    }else {
                        params.put("", encodeImageString20);
                    }

                    if (encodeImageString21 != null){
                        params.put("upload21", encodeImageString21);
                    }else {
                        params.put("", encodeImageString21);
                    }

                    if (encodeImageString22 != null){
                        params.put("upload22", encodeImageString22);
                    }else{
                        params.put("", encodeImageString22);
                    }

                    if (encodeImageString23 != null){
                        params.put("upload23", encodeImageString23);
                    }else {
                        params.put("", encodeImageString23);
                    }

                    if (encodeImageString24 != null){
                        params.put("upload24", encodeImageString24);
                    }else {
                        params.put("", encodeImageString24);
                    }

                    if (encodeImageString25 != null){
                        params.put("upload25", encodeImageString25);
                    }else {
                        params.put("", encodeImageString25);
                    }

                    if (encodeImageString26 != null){
                        params.put("upload26", encodeImageString26);
                    }else {
                        params.put("", encodeImageString26);
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

                    if (rdButton18 != null){
                        params.put("stnd18", rdButton18.getText().toString());
                    }else {
                        params.put("", rdButton18.toString());
                    }

                    if (rdButton19 != null){
                        params.put("stnd19", rdButton19.getText().toString());
                    }else {
                        params.put("", rdButton19.toString());
                    }

                    if (rdButton20 != null){
                        params.put("stnd20", rdButton20.getText().toString());
                    }else {
                        params.put("", rdButton20.toString());
                    }

                    if (rdButton21 != null){
                        params.put("stnd21", rdButton21.getText().toString());
                    }else {
                        params.put("", rdButton21.toString());
                    }

                    if (rdButton22 != null){
                        params.put("stnd22", rdButton22.getText().toString());
                    }else {
                        params.put("", rdButton22.toString());
                    }

                    if (rdButton23 != null){
                        params.put("stnd23", rdButton23.getText().toString());
                    }else {
                        params.put("", rdButton23.toString());
                    }

                    if (rdButton24 != null){
                        params.put("stnd24", rdButton24.getText().toString());
                    }else {
                        params.put("", rdButton24.toString());
                    }

                    if (rdButton25 != null){
                        params.put("stnd25", rdButton25.getText().toString());
                    }else {
                        params.put("", rdButton25.toString());
                    }

                    if (rdButton26 != null){
                        params.put("stnd26", rdButton26.getText().toString());
                    }else {
                        params.put("", rdButton26.toString());
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
                 encodeImageString16 == null || encodeImageString17 == null || encodeImageString18 == null || encodeImageString19 == null || encodeImageString20 == null ||
                 encodeImageString21 == null || encodeImageString22 == null || encodeImageString23 == null || encodeImageString24 == null || encodeImageString25 == null || encodeImageString26 == null){
                     Toast toast = Toast.makeText(getContext(), "Foto haris diisi", Toast.LENGTH_SHORT);
                     toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,0,0);
                     toast.show();
                 }

                 if (rdButton1 == null || rdButton2 == null || rdButton3 == null || rdButton4 == null || rdButton5 == null || rdButton6 == null || rdButton7 == null || rdButton8 == null || rdButton9 == null ||
                 rdButton10 == null || rdButton11 == null || rdButton12 == null || rdButton13 == null || rdButton14 == null || rdButton15 == null || rdButton16 == null || rdButton17 == null || rdButton18 == null ||
                 rdButton19 == null || rdButton20 == null || rdButton21 == null || rdButton22 == null || rdButton23 == null || rdButton24 == null || rdButton25 == null || rdButton26 == null){
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