package com.taurus.androidtest.baseadapter;

import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate;
import com.taurus.androidtest.baseadapter.viewholder.BaseViewHolder;
import com.taurus.androidtest.listener.OnItemClickListener;

public abstract class BaseAdapterDelegate<I extends T, T, VH extends BaseViewHolder>
        extends AbsListItemAdapterDelegate<I, T, VH> {

    private OnItemClickListener onItemClickListener;

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
