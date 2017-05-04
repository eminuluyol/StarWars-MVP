package com.taurus.androidtest.categorydetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.widget.ImageView;

import com.taurus.androidtest.R;
import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.categorydetail.character.CharacterDetailFragment;
import com.taurus.androidtest.categorydetail.movie.MovieDetailFragment;
import com.taurus.androidtest.categorydetail.planet.PlanetDetailFragment;
import com.taurus.androidtest.core.BaseFragment;
import com.taurus.androidtest.core.BaseSimpleActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CategoryDetailActivity extends BaseSimpleActivity {

    private static final String EXTRA_CATEGORY_DETAIL = "category_detail";
    private static final String EXTRA_CATEGORY_TYPE = "category_type";
    private static final int CATEGORY_MOVIES = 0;
    private static final int CATEGORY_PLANETS = 1;
    private static final int CATEGORY_CHARACTERS = 2;

    @BindView(R.id.categoryDetailImageViewComicHeader)
    ImageView imageViewComicHeader;

    @BindView(R.id.collapse_toolbar)
    CollapsingToolbarLayout collapseToolbar;

    private List<GenericItem> detailList;
    private int categoryType;

    public static Intent newIntent(Context context, List<GenericItem> detailList, int categoryType) {

        Intent intent = new Intent(context, CategoryDetailActivity.class);
        intent.putParcelableArrayListExtra(CategoryDetailActivity.EXTRA_CATEGORY_DETAIL, (ArrayList<GenericItem>) detailList);
        intent.putExtra(CategoryDetailActivity.EXTRA_CATEGORY_TYPE, categoryType);

        return intent;

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_category_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getBundleArgmuments();
        super.onCreate(savedInstanceState);

        setHomeAsUpEnabled(true);

        setupStatusBar();

        collapseToolbar.setTitle("Star Wars");

    }

    @Nullable
    @Override
    protected BaseFragment getContainedFragment() {

        switch (categoryType) {

            case CATEGORY_MOVIES:
                return MovieDetailFragment.newInstance(detailList);
            case CATEGORY_PLANETS:
                return PlanetDetailFragment.newInstance(detailList);
            case CATEGORY_CHARACTERS:
               return  CharacterDetailFragment.newInstance(detailList);

        }

        return null;
    }

    private void getBundleArgmuments() {

        Intent extras = getIntent();

        if (extras != null) {
            detailList = extras.getParcelableArrayListExtra(CategoryDetailActivity.EXTRA_CATEGORY_DETAIL);
            categoryType = extras.getIntExtra(CategoryDetailActivity.EXTRA_CATEGORY_TYPE, -1);
        }

    }

}
