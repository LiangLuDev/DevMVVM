package com.aldrich.aldrichmvvm.api;

import com.aldrich.aldrichmvvm.BuildConfig;
import com.aldrich.aldrichmvvm.constant.Constant;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Liang_Lu on 2017/8/31.
 */

public class AldrichApi {
    private static Retrofit mRetrofit;

    public static Retrofit initRetrofit() {
        if (mRetrofit == null) {
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().
                    connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS);

            if (BuildConfig.DEBUG) {//debug模式下，开启log日志拦截器
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                httpClientBuilder.addInterceptor(loggingInterceptor);
            }
            mRetrofit = new Retrofit.Builder()
                    .client(httpClientBuilder.build())//httpClientBuilder可自定义，要带上基本参数和header之类的
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constant.BASE_URL)
                    .build();
        }
        return mRetrofit;
    }
}
