package com.taurus.androidtest.categorydetail.character;

import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.core.BaseView;

import java.util.List;

public interface CharacterDetailView extends BaseView {

    void showEmptyView();

    void hideEmptyView();

    void showGetCharacterDataSuccess(List<GenericItem> detailList);

    void showError();
}
