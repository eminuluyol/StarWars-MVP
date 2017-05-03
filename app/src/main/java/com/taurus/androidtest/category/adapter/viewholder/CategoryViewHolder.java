package com.taurus.androidtest.category.adapter.viewholder;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.taurus.androidtest.baseadapter.viewholder.BaseViewHolder;
import com.taurus.androidtest.category.adapter.model.CategoryUIModel;
import com.taurus.androidtest.listener.OnItemClickListener;

public class CategoryViewHolder extends BaseViewHolder {

    private OnItemClickListener listener;

    public CategoryViewHolder(@NonNull ViewGroup parentView, int layoutId, OnItemClickListener listener) {
        super(parentView, layoutId);

        this.listener = listener;

    }

    public void bind(CategoryUIModel categoryUIModel) {



    }

}
