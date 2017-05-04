package com.taurus.androidtest.categorydetail.movie.adapter.viewholder;

import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.TextView;

import com.taurus.androidtest.R;
import com.taurus.androidtest.baseadapter.viewholder.BaseViewHolder;
import com.taurus.androidtest.categorydetail.movie.adapter.model.MovieUIModel;

import butterknife.BindView;

public class MovieDetailViewHolder extends BaseViewHolder {

    @BindView(R.id.moviesTextViewTitle)
    TextView textViewTitle;

    @BindView(R.id.moviesTextViewDirector)
    TextView textViewDirector;

    @BindView(R.id.moviesTextViewProducer)
    TextView textViewProducer;

    @BindView(R.id.moviesTextViewReleaseDate)
    TextView textViewReleaseDate;

    @BindView(R.id.moviesTextViewOpeningCrawl)
    TextView textViewOpeningCrawl;

    public MovieDetailViewHolder(@NonNull ViewGroup parentView, int layoutId) {
        super(parentView, layoutId);
    }

    public void bind(MovieUIModel item) {

        textViewTitle.setText(item.getTitle());
        textViewDirector.setText(item.getDirector());
        textViewProducer.setText(item.getProducer());
        textViewReleaseDate.setText(item.getReleaseDate());
        textViewOpeningCrawl.setText(item.getOpeningCrawl());

    }
}
