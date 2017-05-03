package com.taurus.androidtest.categorydetail.adapter.delegate;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.taurus.androidtest.R;
import com.taurus.androidtest.baseadapter.BaseAdapterDelegate;
import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.categorydetail.adapter.model.CharacterUIModel;
import com.taurus.androidtest.categorydetail.adapter.viewholder.CharacterDetailViewHolder;

import java.util.List;

public class CharacterDetailAdapterDelegate extends BaseAdapterDelegate<CharacterUIModel, GenericItem, CharacterDetailViewHolder> {

    @Override
    protected boolean isForViewType(@NonNull GenericItem item, @NonNull List<GenericItem> items, int position) {
        return item instanceof CharacterUIModel;
    }

    @NonNull
    @Override
    protected CharacterDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new CharacterDetailViewHolder(parent, R.layout.list_item_character);
    }

    @Override
    protected void onBindViewHolder(@NonNull CharacterUIModel item, @NonNull CharacterDetailViewHolder viewHolder, @NonNull List<Object> payloads) {

    }
}
