package com.taurus.androidtest.category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.taurus.androidtest.R;
import com.taurus.androidtest.core.BaseFragment;
import com.taurus.androidtest.util.databasehandler.CategoryDatabaseModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends BaseFragment<CategoryView, CategoryPresenter> implements CategoryView {

    private static final String EXTRA_CATEGORY = "category";
    private List<CategoryDatabaseModel> categories;

    public static CategoryFragment newInstance(List<CategoryDatabaseModel> categories) {

        Bundle args = new Bundle();
        args.putParcelableArrayList(CategoryFragment.EXTRA_CATEGORY, (ArrayList<CategoryDatabaseModel>) categories);

        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_category;
    }

    @NonNull
    @Override
    public CategoryPresenter createPresenter() {
        return new CategoryPresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        showProgress();

        getBundleFromArgs();

        if(categories != null && !categories.isEmpty()) {

            categories.size();

        }
    }

    private void getBundleFromArgs(){

        Bundle args = getArguments();
        if (args == null) return;
        categories = args.getParcelableArrayList(CategoryFragment.EXTRA_CATEGORY);
    }
}
