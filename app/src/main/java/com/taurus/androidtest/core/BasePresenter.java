package com.taurus.androidtest.core;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.taurus.androidtest.network.StarWarsApi;
import com.taurus.androidtest.util.Navigator;
import com.taurus.androidtest.util.databasehandler.StarWarsDatabaseHandler;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<V extends BaseView> extends MvpBasePresenter<V> {

    @Inject
    Navigator navigator;

    @Inject
    StarWarsApi api;

    @Inject
    StarWarsDatabaseHandler starWarsDatabaseHandler;

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

    public StarWarsDatabaseHandler getDatabaseHandler() {
        return starWarsDatabaseHandler;
    }

    public void clearCompositeDisposable() {

        if (compositeDisposable != null) {

            compositeDisposable.clear();
        }
    }

}
