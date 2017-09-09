package com.aldrich.aldrichmvvm.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.aldrich.aldrichmvvm.R;
import com.aldrich.aldrichmvvm.databinding.ActivityMainBinding;
import com.aldrich.aldrichmvvm.view.base.BaseActivity;
import com.aldrich.aldrichmvvm.viewmodel.activity.VMTest;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setModel(new VMTest(this));
        binding.setViewModel((VMTest) mModel);
    }

}
