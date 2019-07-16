package com.example.hackathon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.hackathon.R;
import com.example.hackathon.databinding.MainActivityBinding;
import com.example.hackathon.viewmodel.MainViewModel;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends BaseActivity<MainActivityBinding, MainViewModel> {

    @Override
    protected int layoutId() {
        return R.layout.main_activity;
    }

    @Override
    protected Class viewModel() {
        return MainViewModel.class;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel.number.observe(this, number -> {
            Intent intent = new Intent(this, ChoiceActivity.class);
            intent.putExtra("value",number);
            startActivity(intent);
        });
        clickEvent();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        Toast.makeText(this,"스캔 완료",Toast.LENGTH_LONG);

        viewModel.number.setValue(result.getContents());
    }

    private void clickEvent() {

        binding.camera.setOnClickListener(v -> new IntentIntegrator(this).initiateScan());
    }
}
