package com.taurus.androidtest.categorydetail.character;

import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.categorydetail.character.adapter.model.CharacterUIModel;
import com.taurus.androidtest.core.BasePresenter;
import com.taurus.androidtest.core.injection.Injector;
import com.taurus.androidtest.network.model.BaseRequest;
import com.taurus.androidtest.network.model.character.CharacterWrapper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CharacterDetailPresenter extends BasePresenter<CharacterDetailView> {

    private int PAGE_NUMBER = 2;
    private boolean hasNext = true;

    CharacterDetailPresenter() {
        Injector.getInstance().getActivityComponent().inject(this);
    }

    void onCharacterListRequested() {

        if(hasNext) {

            BaseRequest request = new BaseRequest(PAGE_NUMBER);

            getView().showProgress();

            compositeDisposable.add(getApi().getStarWarsCharacters(request)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleCharacterResponse, this::handleError));

        }

    }

    private void handleCharacterResponse(CharacterWrapper characterWrapper) {


        PAGE_NUMBER++;

        if(isViewAttached()) {

            getView().dismissProgress();

        }

        if(characterWrapper.getResults().size() > 0) {

            hasNext = characterWrapper.hasNext();
            List<GenericItem> detailList = new ArrayList<>(CharacterUIModel.createList(characterWrapper));

            getView().showGetCharacterDataSuccess(detailList);

        }


    }

    private void handleError(Throwable throwable) {

        getView().showError();

    }
}
