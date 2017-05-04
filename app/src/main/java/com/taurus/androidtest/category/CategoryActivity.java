package com.taurus.androidtest.category;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.taurus.androidtest.R;
import com.taurus.androidtest.core.BaseFragment;
import com.taurus.androidtest.core.BaseSimpleActivity;
import com.taurus.androidtest.util.databasehandler.model.CategoryDatabaseModel;

import java.util.ArrayList;
import java.util.List;


public class CategoryActivity extends BaseSimpleActivity {

    private static final String EXTRA_CATEGORY = "category";
    private List<CategoryDatabaseModel> categories;

    public static Intent newIntent(Context context, List<CategoryDatabaseModel> categories) {

        Intent intent = new Intent(context, CategoryActivity.class);
        intent.putParcelableArrayListExtra(CategoryActivity.EXTRA_CATEGORY, new ArrayList<>(categories));

        return intent;
    }

    @Nullable
    @Override
    protected BaseFragment getContainedFragment() {
        return CategoryFragment.newInstance(categories);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getBundleArguments();
        super.onCreate(savedInstanceState);

        setTitle(R.string.category_title);

    }

    private void getBundleArguments() {

        Intent extras = getIntent();

        if (extras != null) {
            categories = extras.getParcelableArrayListExtra(CategoryActivity.EXTRA_CATEGORY);
           }

    }

}
