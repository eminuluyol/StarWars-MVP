package com.taurus.androidtest.category.adapter.delegate;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.taurus.androidtest.R;
import com.taurus.androidtest.baseadapter.BaseAdapterDelegate;
import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.category.adapter.model.CategoryUIModel;
import com.taurus.androidtest.category.adapter.viewholder.CategoryViewHolder;
import com.taurus.androidtest.listener.OnItemClickListener;

import java.util.List;

public class CategoryAdapterDelegate extends BaseAdapterDelegate<CategoryUIModel, GenericItem, CategoryViewHolder> {

    public CategoryAdapterDelegate(OnItemClickListener itemClickListener) {
        setOnItemClickListener(itemClickListener);
    }

    @Override
    protected boolean isForViewType(@NonNull GenericItem item, @NonNull List<GenericItem> items, int position) {
        return item instanceof CategoryUIModel;
    }

    @NonNull
    @Override
    protected CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new CategoryViewHolder(parent, R.layout.list_item_category, getOnItemClickListener());
    }

    @Override
    protected void onBindViewHolder(@NonNull CategoryUIModel item, @NonNull CategoryViewHolder viewHolder, @NonNull List<Object> payloads) {
        viewHolder.bind(item);
    }
}
