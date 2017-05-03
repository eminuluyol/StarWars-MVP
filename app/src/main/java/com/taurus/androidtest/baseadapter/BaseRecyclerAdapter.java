package com.taurus.androidtest.baseadapter;

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter;
import com.taurus.androidtest.baseadapter.model.GenericItem;

import java.util.List;

public class BaseRecyclerAdapter extends ListDelegationAdapter<List<GenericItem>> {


    public GenericItem getItem(int position) {

        if (getItemCount() > position) {
            return items.get(position);
        }

        return null;
    }
}