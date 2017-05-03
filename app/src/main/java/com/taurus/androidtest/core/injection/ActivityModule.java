package com.taurus.androidtest.core.injection;

import android.support.v7.app.AppCompatActivity;

import com.taurus.androidtest.util.Navigator;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public AppCompatActivity provideActivity() {
        return activity;
    }

    @Provides
    @ActivityScope
    public Navigator provideNavigator(AppCompatActivity activity) {
        return new Navigator(activity);
    }

}

