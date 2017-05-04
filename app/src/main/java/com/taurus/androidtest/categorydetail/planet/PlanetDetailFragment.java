package com.taurus.androidtest.categorydetail.planet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.taurus.androidtest.R;
import com.taurus.androidtest.baseadapter.RecyclerAdapter;
import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.categorydetail.planet.adapter.delegate.PlanetDetailAdapterDelegate;
import com.taurus.androidtest.core.BaseSimpleFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class PlanetDetailFragment extends BaseSimpleFragment {

    private static final String EXTRA_CATEGORY_DETAIL = "category_detail";

    @BindView(R.id.planetRecyclerView)
    RecyclerView planetsRecyclerView;

    @BindView(R.id.emptyView)
    NestedScrollView emptyView;

    private List<GenericItem> detailList;

    public static PlanetDetailFragment newInstance(List<GenericItem> detailList) {

        Bundle args = new Bundle();
        args.putParcelableArrayList(PlanetDetailFragment.EXTRA_CATEGORY_DETAIL, (ArrayList<GenericItem>) detailList);

        PlanetDetailFragment fragment = new PlanetDetailFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_planet_detail;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getBundleFromArgs();

        if(detailList.size() > 0 && detailList != null) {

            planetsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            RecyclerAdapter planetsListAdapter = RecyclerAdapter.with(new PlanetDetailAdapterDelegate());
            planetsRecyclerView.setAdapter(planetsListAdapter);
            planetsListAdapter.swapItems(detailList);

        } else {

            emptyView.setVisibility(View.VISIBLE);

        }

    }

    private void getBundleFromArgs() {

        Bundle args = getArguments();

        if (args == null) return;
        detailList = args.getParcelableArrayList(PlanetDetailFragment.EXTRA_CATEGORY_DETAIL);

    }

}
