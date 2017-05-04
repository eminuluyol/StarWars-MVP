package com.taurus.androidtest.categorydetail.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.taurus.androidtest.R;
import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.core.BaseSimpleFragment;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailFragment extends BaseSimpleFragment {

    private static final String EXTRA_CATEGORY_DETAIL = "category_detail";

    private List<GenericItem> detailList;

    public static MovieDetailFragment newInstance(List<GenericItem> detailList) {

        Bundle args = new Bundle();
        args.putParcelableArrayList(MovieDetailFragment.EXTRA_CATEGORY_DETAIL, (ArrayList<GenericItem>) detailList);

        MovieDetailFragment fragment = new MovieDetailFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_movie_detail;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getBundleFromArgs();

    }

    private void getBundleFromArgs() {

        Bundle args = getArguments();

        if (args == null) return;
        detailList = args.getParcelableArrayList(MovieDetailFragment.EXTRA_CATEGORY_DETAIL);

    }

}
