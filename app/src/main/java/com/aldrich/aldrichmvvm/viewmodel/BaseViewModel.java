package com.aldrich.aldrichmvvm.viewmodel;

import android.content.Context;

import com.aldrich.aldrichmvvm.api.AldrichApi;
import com.aldrich.aldrichmvvm.api.AldrichService;
import com.aldrich.aldrichmvvm.interfaces.AldrichCallBack;
import com.aldrich.aldrichmvvm.utils.LoadingHelper;
import com.aldrich.aldrichmvvm.utils.rxhelper.RxException;
import com.aldrich.aldrichmvvm.utils.rxhelper.RxSchedulers;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;


/**
 * Created by Liang_Lu on 2017/9/1.
 */

public class BaseViewModel<T> {
    Context mContext;

    CompositeDisposable mDisposable = new CompositeDisposable();

    public BaseViewModel(Context mContext) {
        this.mContext = mContext;
    }

    public AldrichService apiService() {
        return AldrichApi.initRetrofit().create(AldrichService.class);
    }

    protected void addRxObservable(Flowable flowable, boolean isLoading, AldrichCallBack<T> back) {
        if (isLoading) {
            LoadingHelper.getInstance().showLoading(mContext);
        }

        flowable
//                .compose(((BaseActivity) mContext).bindToLifecycle())  //RxLifecycle管理生命周期
                .compose(RxSchedulers.io_main())
                .subscribe(new Consumer<T>() {
                    @Override
                    public void accept(T t) throws Exception {
                        //这里网络请求成功返回数据，可以根据后台数据规范可以自定义Consumer处理返回数据
                        //具体自定义可以仿照RxException来写。
                        if (isLoading) {
                            LoadingHelper.getInstance().hideLoading();
                        }
                        back.onSuccess(t);
                    }
                }, new RxException<>(throwable -> {
                    if (isLoading) {
                        LoadingHelper.getInstance().hideLoading();
                    }
                }));
    }

    /**
     * 这里取消订阅，在activity或fragment生命周期结束调用。避免尴尬异常
     * 还有一种方法可以使用RxLifecycle来管理。后面有空用RxLifecycle替换上
     */
    public void onDestroy() {
        if (mDisposable != null) {
            mDisposable.isDisposed();
            mDisposable.clear();
        }
    }


}
