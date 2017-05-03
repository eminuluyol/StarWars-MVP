package com.taurus.androidtest.categorydetail;

import android.support.annotation.Nullable;

import com.taurus.androidtest.R;
import com.taurus.androidtest.core.BaseFragment;
import com.taurus.androidtest.core.BaseSimpleActivity;

public class CategoryDetailActivity extends BaseSimpleActivity {


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_category_detail;
    }

    @Nullable
    @Override
    protected BaseFragment getContainedFragment() {
        return null;
    }
}
