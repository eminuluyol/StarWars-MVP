package com.taurus.androidtest.core;

import android.app.Application;

import com.taurus.androidtest.core.injection.Injector;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Injector.getInstance().createApplicationScope(this);

    }
}
