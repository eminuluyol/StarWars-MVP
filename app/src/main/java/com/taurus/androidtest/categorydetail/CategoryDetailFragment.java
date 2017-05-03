package com.taurus.androidtest.categorydetail;

import com.taurus.androidtest.R;
import com.taurus.androidtest.core.BaseFragment;

public class CategoryDetailFragment extends BaseFragment<CategoryDetailView, CategoryDetailPresenter>
        implements CategoryDetailView {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_category_detail;
    }

    @Override
    public CategoryDetailPresenter createPresenter() {
        return null;
    }
}
