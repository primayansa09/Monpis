
package com.example.monpiss;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.monpiss.Database.DbContract;
import com.example.monpiss.Database.VolleyConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActivityLogin extends AppCompatActivity {

    private LinearLayout btnLogin, btnRegister;
    private EditText edtUsername, edtPassword;
    private ProgressDialog progressDialog;
    private SessiionManager sessiionManager;
    private AlphaAnimation btnClick = new AlphaAnimation(1F, 0.8F);

    ArrayList<HashMap<String, String>> list_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regiter = new Intent(ActivityLogin.this, ActivityRegister.class);
                startActivity(regiter);

                btnRegister.startAnimation(AnimationUtils.
                        loadAnimation(getApplicationContext(), R.anim.anim_item));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                btnLogin.startAnimation(AnimationUtils.
                        loadAnimation(getApplicationContext(), R.anim.anim_item));

                boolean isEmptyFields = false;

                if (TextUtils.isEmpty(username)){
                    isEmptyFields = true;
                }

                if (TextUtils.isEmpty(password)){
                    isEmptyFields = true;
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Username/Password tidak boleh kosong", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL,
                            0 ,0);
                    toast.show();
                }

                if (!isEmptyFields){
                    CheckLogin(username, password);
                }
            }
        });

    }

    private void CheckLogin(final String username, final String password) {
        if (checkNetworkConnection()){
            progressDialog = new ProgressDialog(ActivityLogin.this);
            progressDialog.show();
            progressDialog.setMessage("Sedang Login...");
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.LOGIN,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String success = jsonObject.getString("status");
                                JSONArray jsonArray = jsonObject.getJSONArray("data");

                                    if (success.equals("success")){

                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            JSONObject object = jsonArray.getJSONObject(i);
                                            String name = object.getString("username");
                                            String fullname = object.getString("name");
                                            String email = object.getString("email");
                                            String jabatan = object.getString("jabatan");
                                            String unitkerja = object.getString("unit_kerja");

                                            sessiionManager = new SessiionManager(getApplicationContext());
                                            sessiionManager.creatSession(name, fullname, email,
                                                    jabatan, unitkerja);

                                            Intent intent = new Intent(getApplicationContext(),
                                                    ActivityHome.class);
                                            intent.putExtra("name", fullname);
                                            intent.putExtra("username", name);
                                            intent.putExtra("email", email);
                                            intent.putExtra("jabatan", jabatan);
                                            intent.putExtra("unit_kerja", unitkerja);
                                            startActivity(intent);
                                            finish();

                                            Toast toast = Toast.makeText(getApplicationContext(),
                                                    "Login Sukses", Toast.LENGTH_SHORT);
                                            toast.setGravity(Gravity.CENTER | Gravity.
                                                    CENTER_HORIZONTAL, 0, 0);
                                            toast.show();
                                        }

                            }else {
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            progressDialog.cancel();
                                            Toast toast = Toast.makeText(getApplicationContext(),
                                                    "Username/Password salah", Toast.LENGTH_SHORT);
                                            toast.setGravity(Gravity.CENTER |
                                                    Gravity.CENTER_HORIZONTAL,0 ,0);
                                            toast.show();

                                        }
                                    }, 3000);
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
                    params.put("username", username);
                    params.put("password", password);
                    return  params;
                }
            };

            VolleyConnection.getInstance(ActivityLogin.this).addToRequestQue(stringRequest);

        }else {
            Toast toast = Toast.makeText(getApplicationContext(), "Tidak ada koneksi internet",
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0,0);
            toast.show();
        }
    }

    public boolean checkNetworkConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) this.
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}