package com.taurus.androidtest.core.injection;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);
}
