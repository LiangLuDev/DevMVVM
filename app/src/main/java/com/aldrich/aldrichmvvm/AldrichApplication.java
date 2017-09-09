package com.aldrich.aldrichmvvm;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

/**
 * Created by Liang_Lu on 2017/9/9.
 */

public class AldrichApplication extends Application {

    private static AldrichApplication app;

    public static Context getAppContext() {
        return app;
    }

    public static Resources getAppResources() {
        return app.getResources();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }
}
