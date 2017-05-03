package com.taurus.androidtest.core;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.taurus.androidtest.network.StarWarsApi;
import com.taurus.androidtest.util.Navigator;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<V extends BaseView> extends MvpBasePresenter<V> {

    @Inject
    Navigator navigator;

    @Inject
    StarWarsApi api;

    protected CompositeDisposable compositeDisposable;

    public BasePresenter(){
        compositeDisposable = new CompositeDisposable();
    }

    public Navigator getNavigator() {
        return navigator;
    }

    public StarWarsApi getApi() {
        return api;
    }

    public void clearCompositeDisposable() {

        if (compositeDisposable != null) {

            compositeDisposable.clear();
        }
    }

}
