package com.taurus.androidtest.util.navigation;

import android.app.Activity;

import com.taurus.androidtest.category.CategoryActivity;
import com.taurus.androidtest.core.injection.ActivityScope;
import com.taurus.androidtest.util.databasehandler.CategoryDatabaseModel;

import java.util.List;


@ActivityScope
public class Navigator {

    private final Activity activity;

    public Navigator(Activity activity) {
        this.activity = activity;
    }

    public Navigation toCategoryActivity(List<CategoryDatabaseModel> categories) {
        return new Navigation(activity, CategoryActivity.newIntent(activity, categories));
    }
}
