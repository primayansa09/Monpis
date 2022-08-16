package com.example.monpiss;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import java.util.HashMap;


public class SessiionManager {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;
    int mode = 0;

    public static final String pref_fullname = "crudfullname";
    public static final String pref_name = "crudname";
    public static final String pref_email = "crudemail";
    public static final String pref_jabatan = "crudjabatan";
    public static final String pref_unitkerja = "crudunitkeja";
    public static final String pref_login = "login";

    public SessiionManager(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(pref_name, mode);
        editor = preferences.edit();
    }

    public void creatSession(String name, String username,String email, String jabatan ,String unitkerja){
        editor.putBoolean(pref_login, true);
        editor.putString(pref_name, username);
        editor.putString(pref_fullname, name);
        editor.putString(pref_email, email);
        editor.putString(pref_jabatan, jabatan);
        editor.putString(pref_unitkerja, unitkerja);
        editor.apply();
    }

    public void cekLogin(){
        if (!this.pref_login()){
            Intent i = new Intent(context, ActivityLogin.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }else {
            Intent i = new Intent(context, ActivityHome.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }

    private boolean pref_login(){
        return preferences.getBoolean(pref_login, false);
    }

    public void logout(){
        editor.clear();
        editor.commit();
        Intent i = new Intent(context, ActivityLogin.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(pref_fullname, preferences.getString(pref_fullname, null));
        user.put(pref_email, preferences.getString(pref_email, null));
        user.put(pref_name, preferences.getString(pref_name, null));
        user.put(pref_jabatan, preferences.getString(pref_jabatan, null));
        user.put(pref_unitkerja, preferences.getString(pref_unitkerja, null));
        return user;
    }
}
