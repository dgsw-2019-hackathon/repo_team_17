package com.example.hackathon.model;

import com.google.gson.annotations.SerializedName;

public class Login {

    private String token;

    @SerializedName("refresh_token")
    private String refreshToken;

    private Member member;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
