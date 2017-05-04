package com.taurus.androidtest.core.injection;

import com.taurus.androidtest.category.CategoryPresenter;
import com.taurus.androidtest.categorydetail.character.CharacterDetailPresenter;
import com.taurus.androidtest.core.NoOpPresenter;
import com.taurus.androidtest.splash.SplashPresenter;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(NoOpPresenter noOpPresenter);

    void inject(SplashPresenter splashPresenter);

    void inject(CategoryPresenter categoryPresenter);

    void inject(CharacterDetailPresenter categoryDetailPresenter);

}
