package com.aldrich.aldrichmvvm.viewmodel.activity;

import android.content.Context;
import android.view.View;


import com.aldrich.aldrichmvvm.interfaces.AldrichCallBack;
import com.aldrich.aldrichmvvm.utils.ToastUtils;
import com.aldrich.aldrichmvvm.viewmodel.BaseViewModel;

import java.util.Map;

/**
 * Created by Liang_Lu on 2017/9/1.
 */

public class VMTest extends BaseViewModel {

    public VMTest(Context mContext) {
        super(mContext);
    }

    public void vmTest(View view) {
        addRxObservable(apiService()
                .Test("cityinfo"), true, new AldrichCallBack<Map>() {
            @Override
            public void onSuccess(Map map) {
                ToastUtils.show(map.toString());
            }

            @Override
            public void onFail(String reason) {

            }
        });

    }
}
