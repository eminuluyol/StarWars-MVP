package com.taurus.androidtest.category;

import com.taurus.androidtest.R;
import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.categorydetail.character.adapter.model.CharacterUIModel;
import com.taurus.androidtest.categorydetail.movie.adapter.model.MovieUIModel;
import com.taurus.androidtest.categorydetail.planet.adapter.model.PlanetUIModel;
import com.taurus.androidtest.core.BasePresenter;
import com.taurus.androidtest.core.injection.Injector;
import com.taurus.androidtest.network.model.BaseRequest;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CategoryPresenter extends BasePresenter<CategoryView> {

    CategoryPresenter() {
        Injector.getInstance().getActivityComponent().inject(this);
    }

    private int categoryType;

    void onShowEmptyViewRequeste() {

        if(isViewAttached()) {
            getView().showEmptyView();
        }

    }

    void onHideEmptyViewRequeste() {

        if(isViewAttached()) {
            getView().hideEmptyView();
        }

    }

    void onMovieListRequested(int categoryType) {

        this.categoryType = categoryType;

        compositeDisposable.add(getApi().getStarWarsMovies()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(MovieUIModel::createList)
                .subscribe(this::handleMovieResponse, this::handleError));

    }

    private void handleMovieResponse(List<MovieUIModel> movieUIModels) {

        if(isViewAttached()) {

            getView().dismissProgress();

        }

        if(movieUIModels.size() > 0) {

            List<GenericItem> detailList = new ArrayList<>(movieUIModels);

            onCategoryDetailRequested(detailList);

        }

    }

    void onPlanetListRequested(int categoryType) {

        this.categoryType = categoryType;

        compositeDisposable.add(getApi().getStarWarsPlanets()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(PlanetUIModel::createList)
                .subscribe(this::handlePlanetResponse, this::handleError));

    }

    private void handlePlanetResponse(List<PlanetUIModel> planetUIModels) {


        if(isViewAttached()) {

            getView().dismissProgress();

        }

        if(planetUIModels.size() > 0) {

            List<GenericItem> detailList = new ArrayList<>(planetUIModels);

            onCategoryDetailRequested(detailList);

        }

    }

    void onCharacterListRequested(int categoryType) {

        BaseRequest request = new BaseRequest(1);

        this.categoryType = categoryType;

        compositeDisposable.add(getApi().getStarWarsCharacters(request)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(CharacterUIModel::createList)
                .subscribe(this::handleCharacterResponse, this::handleError));

    }

    private void handleCharacterResponse(List<CharacterUIModel> characterUIModels) {

        if(isViewAttached()) {

            getView().dismissProgress();

        }

        if(characterUIModels.size() > 0) {

            List<GenericItem> detailList = new ArrayList<>(characterUIModels);

            onCategoryDetailRequested(detailList);

        }

    }

    private void handleError(Throwable throwable) {

        if(isViewAttached()) {

            getView().dismissProgress();
            getView().showEmptyView();

        }

    }

    void onCategoryDetailRequested(List<GenericItem> detailList) {

        getNavigator().toCategoryDetailActivity(detailList, categoryType).withAnimation(R.anim.right_in, R.anim.left_out).navigate();

    }

}
