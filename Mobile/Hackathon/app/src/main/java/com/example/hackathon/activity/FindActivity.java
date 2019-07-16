package com.example.hackathon.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.hackathon.R;
import com.example.hackathon.databinding.FindActivityBinding;
import com.example.hackathon.viewmodel.FindViewModel;

public class FindActivity extends BaseActivity<FindActivityBinding, FindViewModel> {

    @Override
    protected int layoutId() {
        return R.layout.find_activity;
    }

    @Override
    protected Class viewModel() {
        return FindViewModel.class;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        viewModel.value.setValue(intent.getStringExtra("barcode"));
    }
}
