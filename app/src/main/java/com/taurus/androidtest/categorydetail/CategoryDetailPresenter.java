package com.taurus.androidtest.categorydetail;

import com.taurus.androidtest.core.BasePresenter;
import com.taurus.androidtest.core.injection.Injector;

public class CategoryDetailPresenter extends BasePresenter<CategoryDetailView> {

    CategoryDetailPresenter() {
        Injector.getInstance().getActivityComponent().inject(this);
    }
}
