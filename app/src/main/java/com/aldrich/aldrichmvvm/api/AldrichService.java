package com.aldrich.aldrichmvvm.api;


import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Liang_Lu on 2017/9/1.
 */

public interface AldrichService {

    @GET("/data/{params}/101010100.html")
    Flowable<Map> Test(@Path("params") String params);
}
