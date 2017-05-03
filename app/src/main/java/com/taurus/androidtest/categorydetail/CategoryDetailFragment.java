package com.taurus.androidtest.categorydetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.taurus.androidtest.R;
import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.core.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class CategoryDetailFragment extends BaseFragment<CategoryDetailView, CategoryDetailPresenter>
        implements CategoryDetailView {

    private static final String EXTRA_CATEGORY_DETAIL = "category_detail";
    private static final String EXTRA_CATEGORY_TYPE = "category_type";

    private List<GenericItem> detailList;
    private int categoryType;

    public static CategoryDetailFragment newInstance(List<GenericItem> detailList, int categoryType) {

        Bundle args = new Bundle();
        args.putParcelableArrayList(CategoryDetailFragment.EXTRA_CATEGORY_DETAIL, (ArrayList<GenericItem>) detailList);
        args.putInt(CategoryDetailFragment.EXTRA_CATEGORY_TYPE, categoryType);

        CategoryDetailFragment fragment = new CategoryDetailFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_category_detail;
    }

    @Override
    public CategoryDetailPresenter createPresenter() {
        return new CategoryDetailPresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getBundleFromArgs();

    }

    private void getBundleFromArgs() {

        Bundle args = getArguments();
        if (args == null) return;
        detailList = args.getParcelableArrayList(CategoryDetailFragment.EXTRA_CATEGORY_DETAIL);
        categoryType = args.getInt(CategoryDetailFragment.EXTRA_CATEGORY_TYPE, 0);

    }

}
