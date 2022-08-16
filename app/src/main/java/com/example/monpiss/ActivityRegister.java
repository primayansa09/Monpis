package com.example.monpiss;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.monpiss.Database.DbContract;
import com.example.monpiss.Database.VolleyConnection;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ActivityRegister extends AppCompatActivity implements View.OnClickListener {

    private EditText mName,mUsername, mEmail, mPassword, mConfirmPass,
            mJabatan, mUnitKerja;
    private LinearLayout btnRegister;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mName = findViewById(R.id.edt_fullnameRegis);
        mUsername = findViewById(R.id.edt_usernameRegis);
        mEmail = findViewById(R.id.edt_emailRegis);
        mJabatan = findViewById(R.id.edt_jabatanRegis);
        mUnitKerja = findViewById(R.id.edt_unitRegis);
        mPassword = findViewById(R.id.edt_passwordRegis);
        mConfirmPass = findViewById(R.id.edt_confrimpassword);
        btnRegister = findViewById(R.id.btn_register);
        progressBar = findViewById(R.id.progress_regis);

        btnRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
                if (v.getId() == R.id.btn_register){
                    String sName = mName.getText().toString().trim();
                    String sUsername = mUsername.getText().toString().trim();
                    String sEmail = mEmail.getText().toString().trim();
                    String sJabatan = mJabatan.getText().toString().trim();
                    String sunitKerja = mUnitKerja.getText().toString().trim();
                    String sPassword = mPassword.getText().toString().trim();
                    String sConfPass = mConfirmPass.getText().toString().trim();

                    btnRegister.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_item));

                    if (sPassword.equals(sConfPass) && !sPassword.equals("")){
                        CreateDataToServe(sName, sUsername, sEmail, sJabatan, sunitKerja,sPassword);
                        Intent toLogin = new Intent(this, ActivityLogin.class);
                        startActivity(toLogin);
                        finish();
                        onStop();
                    }else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Password tidak cocok", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,0,0);
                        toast.show();
                    }
                }
                break;
        }

    }

    public void CreateDataToServe(String sName, final String username, final String email, String jabatan, String unitkerja, final String password){
        if (checkNetworkConnection()){
            progressBar.setVisibility(View.VISIBLE);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_REGISTER_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String resp = jsonObject.getString("server_response");
                                if (resp.equals("[{\"status\":\"OK\"}]")){
                                    Toast toast = Toast.makeText(getApplicationContext(), "Register berhasil", Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0,0);
                                    toast.show();
                                }else {
                                    Toast toast = Toast.makeText(getApplicationContext(), resp , Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0,0);
                                    toast.show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

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
                    params.put("name", sName);
                    params.put("username", username);
                    params.put("email", email);
                    params.put("jabatan", jabatan);
                    params.put("unit_kerja", unitkerja);
                    params.put("password", password);
                    return params;
                }
            };

            VolleyConnection.getInstance(ActivityRegister.this).addToRequestQue(stringRequest);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }, 2000);
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), "Tidak ada koneksi internet", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0,0);
            toast.show();
        }
    }

    public boolean checkNetworkConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

}