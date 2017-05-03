package com.taurus.androidtest.core.injection;

import android.app.Application;

import com.taurus.androidtest.network.StarWarsApi;
import com.taurus.androidtest.network.retrofit.RetrofitStarWarsApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public StarWarsApi provideStarWarsApi() {
        return new RetrofitStarWarsApi();
    }

}
