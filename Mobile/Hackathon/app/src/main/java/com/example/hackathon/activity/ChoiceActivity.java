package com.example.hackathon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.hackathon.R;
import com.example.hackathon.databinding.ChoiceActivityBinding;
import com.example.hackathon.viewmodel.ChoiceViewModel;

public class ChoiceActivity extends BaseActivity<ChoiceActivityBinding, ChoiceViewModel> {

    @Override
    protected int layoutId() {
        return R.layout.choice_activity;
    }

    @Override
    protected Class viewModel() {
        return ChoiceViewModel.class;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        viewModel.value.setValue(intent.getStringExtra("value"));

        viewModel.check.setValue(true);

        checkManage(true);

        viewModel.check.observe(this, check -> {
            checkManage(check);
        });

        clickEvent();
    }

    private void checkManage(Boolean check) {

        if (check) {
            binding.write.setVisibility(View.VISIBLE);
        }
        else {
            binding.read.setVisibility(View.INVISIBLE);
        }
    }

    private void clickEvent() {

        binding.back.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        binding.go.setOnClickListener(v -> {
            Intent intent = new Intent(this,WriteActivity.class);
            intent.putExtra("type",viewModel.check.getValue());
            intent.putExtra("value",viewModel.value.getValue());
            startActivity(intent);
        });
    }
}
