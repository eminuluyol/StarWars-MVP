package com.taurus.androidtest.util;

import android.app.Activity;

import com.taurus.androidtest.core.injection.ActivityScope;


@ActivityScope
public class Navigator {

    private final Activity activity;

    public Navigator(Activity activity) {
        this.activity = activity;
    }

}
