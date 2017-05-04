package com.taurus.androidtest.categorydetail.planet.adapter.delegate;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.taurus.androidtest.R;
import com.taurus.androidtest.baseadapter.BaseAdapterDelegate;
import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.categorydetail.planet.adapter.viewholder.PlanetDetailViewHolder;
import com.taurus.androidtest.categorydetail.planet.adapter.model.PlanetUIModel;

import java.util.List;

public class PlanetDetailAdapterDelegate extends BaseAdapterDelegate<PlanetUIModel, GenericItem, PlanetDetailViewHolder> {

    @Override
    protected boolean isForViewType(@NonNull GenericItem item, @NonNull List<GenericItem> items, int position) {
        return item instanceof PlanetUIModel;
    }

    @NonNull
    @Override
    protected PlanetDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new PlanetDetailViewHolder(parent, R.layout.list_item_planet);
    }

    @Override
    protected void onBindViewHolder(@NonNull PlanetUIModel item, @NonNull PlanetDetailViewHolder viewHolder, @NonNull List<Object> payloads) {

    }
}
