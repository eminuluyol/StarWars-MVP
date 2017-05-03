package com.taurus.androidtest.core.injection;

import com.taurus.androidtest.core.NoOpPresenter;
import com.taurus.androidtest.splash.SplashPresenter;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(NoOpPresenter noOpPresenter);

    void inject(SplashPresenter splashPresenter);

}
