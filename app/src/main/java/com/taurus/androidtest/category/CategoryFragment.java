package com.taurus.androidtest.category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.taurus.androidtest.R;
import com.taurus.androidtest.baseadapter.RecyclerAdapter;
import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.category.adapter.delegate.CategoryAdapterDelegate;
import com.taurus.androidtest.category.adapter.model.CategoryUIModel;
import com.taurus.androidtest.core.BaseFragment;
import com.taurus.androidtest.listener.OnItemClickListener;
import com.taurus.androidtest.util.databasehandler.CategoryDatabaseModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CategoryFragment extends BaseFragment<CategoryView, CategoryPresenter>
        implements CategoryView, OnItemClickListener {

    private static final String EXTRA_CATEGORY = "category";

    @BindView(R.id.categoryRecyclerView)
    RecyclerView categoryRecyclerView;

    @BindView(R.id.emptyView)
    NestedScrollView emptyView;

    private List<CategoryDatabaseModel> categories;

    private RecyclerAdapter categoryListAdapter;

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

        getBundleFromArgs();

        if (categories != null && !categories.isEmpty()) {

            List<GenericItem> categoryList = new ArrayList<>(CategoryUIModel.createList(categories));

            categoryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            categoryListAdapter = RecyclerAdapter.with(new CategoryAdapterDelegate(this));
            categoryRecyclerView.setAdapter(categoryListAdapter);
            categoryListAdapter.swapItems(categoryList);

        }
    }

    private void getBundleFromArgs() {

        Bundle args = getArguments();
        if (args == null) return;
        categories = args.getParcelableArrayList(CategoryFragment.EXTRA_CATEGORY);

    }

    @Override
    public void showEmptyView() {
        emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyView() {
        emptyView.setVisibility(View.GONE);
    }


    @Override
    public void onItemClick(int position) {

    }

}
