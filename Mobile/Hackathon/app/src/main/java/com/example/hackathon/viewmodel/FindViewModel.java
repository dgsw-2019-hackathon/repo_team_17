package com.example.hackathon.viewmodel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

public class FindViewModel extends BaseViewModel {

    public final MutableLiveData<String> value = new MutableLiveData<>();

    public FindViewModel(Context context) {
        super(context);
    }

    public void find() {

    }
}
