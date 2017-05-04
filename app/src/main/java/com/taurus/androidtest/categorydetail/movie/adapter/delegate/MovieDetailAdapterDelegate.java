package com.taurus.androidtest.categorydetail.movie.adapter.delegate;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.taurus.androidtest.R;
import com.taurus.androidtest.baseadapter.BaseAdapterDelegate;
import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.categorydetail.movie.adapter.model.MovieUIModel;
import com.taurus.androidtest.categorydetail.movie.adapter.viewholder.MovieDetailViewHolder;

import java.util.List;

public class MovieDetailAdapterDelegate extends BaseAdapterDelegate<MovieUIModel, GenericItem, MovieDetailViewHolder> {

    @Override
    protected boolean isForViewType(@NonNull GenericItem item, @NonNull List<GenericItem> items, int position) {
        return item instanceof MovieUIModel;
    }

    @NonNull
    @Override
    protected MovieDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new MovieDetailViewHolder(parent, R.layout.list_item_movie);
    }

    @Override
    protected void onBindViewHolder(@NonNull MovieUIModel item, @NonNull MovieDetailViewHolder viewHolder, @NonNull List<Object> payloads) {
        viewHolder.bind(item);
    }
}
