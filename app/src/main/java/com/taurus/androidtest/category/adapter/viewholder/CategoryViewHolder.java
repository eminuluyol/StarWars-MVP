package com.taurus.androidtest.category.adapter.viewholder;

import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.TextView;

import com.taurus.androidtest.R;
import com.taurus.androidtest.baseadapter.viewholder.BaseViewHolder;
import com.taurus.androidtest.category.adapter.model.CategoryUIModel;
import com.taurus.androidtest.listener.OnItemClickListener;

import butterknife.BindView;

public class CategoryViewHolder extends BaseViewHolder {

    @BindView(R.id.categoryTextViewCategoryName)
    TextView textViewCategoryName;

    private OnItemClickListener listener;

    public CategoryViewHolder(@NonNull ViewGroup parentView, int layoutId, OnItemClickListener listener) {
        super(parentView, layoutId);

        this.listener = listener;

    }

    public void bind(CategoryUIModel categoryUIModel) {

        textViewCategoryName.setText(categoryUIModel.getCategoryName());

    }

}
