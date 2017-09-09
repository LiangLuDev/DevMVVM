package com.aldrich.aldrichmvvm.interfaces;

/**
 * Created by Liang_Lu on 2017/9/8.
 */

public interface AldrichCallBack<T> {

    void onSuccess(T t);

    void onFail(String reason);
}
