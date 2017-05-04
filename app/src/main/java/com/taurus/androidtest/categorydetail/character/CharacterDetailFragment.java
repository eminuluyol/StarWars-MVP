package com.taurus.androidtest.categorydetail.character;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.taurus.androidtest.R;
import com.taurus.androidtest.baseadapter.RecyclerAdapter;
import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.categorydetail.character.adapter.delegate.CharacterDetailAdapterDelegate;
import com.taurus.androidtest.core.BaseFragment;
import com.taurus.androidtest.customview.EndlessRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CharacterDetailFragment extends BaseFragment<CharacterDetailView, CharacterDetailPresenter>
        implements CharacterDetailView, EndlessRecyclerView.OnEndReachedListener {

    private static final String EXTRA_CATEGORY_DETAIL = "category_detail";

    @BindView(R.id.characterRecyclerView)
    EndlessRecyclerView charactersRecyclerView;

    @BindView(R.id.emptyView)
    NestedScrollView emptyView;

    private List<GenericItem> detailList;
    private RecyclerAdapter charactersListAdapter;

    public static CharacterDetailFragment newInstance(List<GenericItem> detailList) {

        Bundle args = new Bundle();
        args.putParcelableArrayList(CharacterDetailFragment.EXTRA_CATEGORY_DETAIL, (ArrayList<GenericItem>) detailList);

        CharacterDetailFragment fragment = new CharacterDetailFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_character_detail;
    }

    @NonNull
    @Override
    public CharacterDetailPresenter createPresenter() {
        return new CharacterDetailPresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getBundleFromArgs();

        if(detailList.size() > 0 && detailList != null) {

            charactersRecyclerView.setOnEndReachedListener(this);
            charactersRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            charactersListAdapter = RecyclerAdapter.with(new CharacterDetailAdapterDelegate());
            charactersRecyclerView.setAdapter(charactersListAdapter);
            charactersListAdapter.swapItems(detailList);
            charactersRecyclerView.setLoading(false);

        }

    }

    private void getBundleFromArgs() {

        Bundle args = getArguments();

        if (args == null) return;
        detailList = args.getParcelableArrayList(CharacterDetailFragment.EXTRA_CATEGORY_DETAIL);

    }

    @Override
    public void showEmptyView() {
        emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyView() {
        emptyView.setVisibility(View.GONE);
    }

    @Override
    public void showGetCharacterDataSuccess(List<GenericItem> detailList) {

        charactersRecyclerView.setLoading(false);
        charactersListAdapter.addAll(detailList);

    }

    @Override
    public void onEndReached() {

        charactersRecyclerView.setLoading(true);
        getPresenter().onCharacterListRequested();

    }
}
