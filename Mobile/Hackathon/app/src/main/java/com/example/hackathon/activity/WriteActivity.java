package com.example.hackathon.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.hackathon.R;
import com.example.hackathon.databinding.WriteActivityBinding;
import com.example.hackathon.viewmodel.WriteViewModel;

public class WriteActivity extends BaseActivity<WriteActivityBinding, WriteViewModel> {

    @Override
    protected int layoutId() {
        return R.layout.choice_activity;
    }

    @Override
    protected Class viewModel() {
        return WriteViewModel.class;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        viewModel.value.setValue(intent.getStringExtra("value"));
    }
}
