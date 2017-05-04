package com.taurus.androidtest.categorydetail.planet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.taurus.androidtest.R;
import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.core.BaseSimpleFragment;

import java.util.ArrayList;
import java.util.List;

public class PlanetDetailFragment extends BaseSimpleFragment {

    private static final String EXTRA_CATEGORY_DETAIL = "category_detail";

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

    }

    private void getBundleFromArgs() {

        Bundle args = getArguments();

        if (args == null) return;
        detailList = args.getParcelableArrayList(PlanetDetailFragment.EXTRA_CATEGORY_DETAIL);

    }

}
