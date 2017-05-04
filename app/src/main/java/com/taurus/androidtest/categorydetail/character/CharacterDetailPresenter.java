package com.taurus.androidtest.categorydetail.character;

import com.taurus.androidtest.core.BasePresenter;
import com.taurus.androidtest.core.injection.Injector;

public class CharacterDetailPresenter extends BasePresenter<CharacterDetailView> {

    CharacterDetailPresenter() {
        Injector.getInstance().getActivityComponent().inject(this);
    }
}
