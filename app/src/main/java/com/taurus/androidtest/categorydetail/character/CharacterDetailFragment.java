package com.taurus.androidtest.categorydetail.character;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.taurus.androidtest.R;
import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.core.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class CharacterDetailFragment extends BaseFragment<CharacterDetailView, CharacterDetailPresenter>
        implements CharacterDetailView {

    private static final String EXTRA_CATEGORY_DETAIL = "category_detail";
    private static final String EXTRA_CATEGORY_TYPE = "category_type";

    private List<GenericItem> detailList;
    private int categoryType;

    public static CharacterDetailFragment newInstance(List<GenericItem> detailList, int categoryType) {

        Bundle args = new Bundle();
        args.putParcelableArrayList(CharacterDetailFragment.EXTRA_CATEGORY_DETAIL, (ArrayList<GenericItem>) detailList);
        args.putInt(CharacterDetailFragment.EXTRA_CATEGORY_TYPE, categoryType);

        CharacterDetailFragment fragment = new CharacterDetailFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_character_detail;
    }

    @Override
    public CharacterDetailPresenter createPresenter() {
        return new CharacterDetailPresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getBundleFromArgs();

    }

    private void getBundleFromArgs() {

        Bundle args = getArguments();
        if (args == null) return;
        detailList = args.getParcelableArrayList(CharacterDetailFragment.EXTRA_CATEGORY_DETAIL);
        categoryType = args.getInt(CharacterDetailFragment.EXTRA_CATEGORY_TYPE, 0);

    }

}
