package com.taurus.androidtest.splash;

import com.taurus.androidtest.core.BasePresenter;
import com.taurus.androidtest.core.injection.Injector;
import com.taurus.androidtest.util.databasehandler.CategoryDatabaseModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SplashPresenter extends BasePresenter<SplashView> {

    SplashPresenter() {
        Injector.getInstance().getActivityComponent().inject(this);
    }

    void onProgressBarShow() {

        if(isViewAttached()) {

            getView().showLoading();
        }
    }

    void onProgressBarHide() {

        if(isViewAttached()) {

            getView().hideLoading();
        }
    }

    void onCategoryListRequested() {

        compositeDisposable.add(getApi().getStarWarsCategories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(CategoryDatabaseModel::createList)
                .subscribe(this::handleResponse, this::handleError));

    }

    private void handleResponse(List<CategoryDatabaseModel> categories) {

        if(categories.size() > 0) {

            getDatabaseHandler().addAllCategory(categories);

        }

        onCategoryActivityRequested(getDatabaseHandler().getAllCategoriesOrderByName());

    }

    private void handleError(Throwable throwable) {

        onProgressBarHide();
    }

    void onCategoryActivityRequested(List<CategoryDatabaseModel> categories) {

        onProgressBarHide();
        getNavigator().toCategoryActivity(categories).clearBackStack().navigate();

    }
}
