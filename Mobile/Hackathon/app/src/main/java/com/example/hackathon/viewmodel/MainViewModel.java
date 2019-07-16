package com.example.hackathon.viewmodel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends BaseViewModel {

    public final MutableLiveData<String> number = new MutableLiveData<>();

    public MainViewModel(Context context) {
        super(context);
    }
}
