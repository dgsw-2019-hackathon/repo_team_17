package com.example.hackathon.model;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;

public class Token extends ContextWrapper {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private Context context;

    public Token(Context context) {
        super(context);
        this.context = context;

        sharedPreferences = getSharedPreferences("hackathon",MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    private String token;

    @SerializedName("refresh_token")
    private String refreshToken;

    public void setToken(String token) {

        editor.putString("token", token);

        editor.commit();
    }

    public String getToken() {

        token = sharedPreferences.getString("token","");

        return token;

    }

    public void setRefreshToken(String refreshToken) {

        editor.putString("refreshToken", refreshToken);

        editor.commit();
    }

    public String getRefreshToken() {

        refreshToken = sharedPreferences.getString("refreshToken","");

        return refreshToken;

    }
}
