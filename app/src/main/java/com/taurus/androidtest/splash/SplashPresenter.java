package com.taurus.androidtest.splash;

import android.util.Log;

import com.taurus.androidtest.core.BasePresenter;
import com.taurus.androidtest.core.injection.Injector;
import com.taurus.androidtest.network.retrofit.model.category.Category;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SplashPresenter extends BasePresenter<SplashView> {

    SplashPresenter() {
        Injector.getInstance().getActivityComponent().inject(this);
    }

    void onCategoryListRequested() {

        compositeDisposable.add(getApi().getStarWarsCategories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError));

    }

    private void handleResponse(List<Category> categories) {


    }

    private void handleError(Throwable throwable) {
    }
}
