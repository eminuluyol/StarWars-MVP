package com.taurus.androidtest.category;

import com.taurus.androidtest.core.BasePresenter;
import com.taurus.androidtest.core.injection.Injector;

public class CategoryPresenter extends BasePresenter<CategoryView> {

    CategoryPresenter() {
        Injector.getInstance().getActivityComponent().inject(this);
    }
}