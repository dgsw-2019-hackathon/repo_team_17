package com.example.hackathon.viewmodel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

public class WriteViewModel extends BaseViewModel {

    public final MutableLiveData<String> value = new MutableLiveData<>();

    public WriteViewModel(Context context) {
        super(context);
    }
}
