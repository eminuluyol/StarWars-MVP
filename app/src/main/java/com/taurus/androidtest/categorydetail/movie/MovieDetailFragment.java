package com.taurus.androidtest.categorydetail.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.taurus.androidtest.R;
import com.taurus.androidtest.baseadapter.RecyclerAdapter;
import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.categorydetail.movie.adapter.delegate.MovieDetailAdapterDelegate;
import com.taurus.androidtest.core.BaseSimpleFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MovieDetailFragment extends BaseSimpleFragment {

    private static final String EXTRA_CATEGORY_DETAIL = "category_detail";

    @BindView(R.id.movieRecyclerView)
    RecyclerView moviesRecyclerView;

    @BindView(R.id.emptyView)
    NestedScrollView emptyView;

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

        if(detailList.size() > 0 && detailList != null) {

            moviesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            RecyclerAdapter moviesListAdapter = RecyclerAdapter.with(new MovieDetailAdapterDelegate());
            moviesRecyclerView.setAdapter(moviesListAdapter);
            moviesListAdapter.swapItems(detailList);

        } else {

            emptyView.setVisibility(View.VISIBLE);

        }

    }

    private void getBundleFromArgs() {

        Bundle args = getArguments();

        if (args == null) return;
        detailList = args.getParcelableArrayList(MovieDetailFragment.EXTRA_CATEGORY_DETAIL);

    }

}
