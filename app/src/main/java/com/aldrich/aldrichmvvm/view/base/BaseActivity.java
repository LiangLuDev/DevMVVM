package com.aldrich.aldrichmvvm.view.base;

import android.support.v7.app.AppCompatActivity;

import com.aldrich.aldrichmvvm.viewmodel.BaseViewModel;

/**
 * Created by Liang_Lu on 2017/9/8.
 */

public class BaseActivity extends AppCompatActivity{

    protected BaseViewModel mModel;


    public void setModel(BaseViewModel model) {
        mModel = model;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mModel.onDestroy();
    }
}
