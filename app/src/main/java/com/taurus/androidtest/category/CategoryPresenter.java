package com.taurus.androidtest.category;

import com.taurus.androidtest.core.BasePresenter;
import com.taurus.androidtest.core.injection.Injector;
import com.taurus.androidtest.network.model.character.Character;
import com.taurus.androidtest.network.model.movie.Movie;
import com.taurus.androidtest.network.model.planet.Planet;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CategoryPresenter extends BasePresenter<CategoryView> {

    CategoryPresenter() {
        Injector.getInstance().getActivityComponent().inject(this);
    }

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

    void onMovieListRequested() {

        compositeDisposable.add(getApi().getStarWarsMovies()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleMovieResponse, this::handleError));

    }

    private void handleMovieResponse(List<Movie> movies) {

        getView().dismissProgress();

    }

    void onPlanetListRequested() {

        compositeDisposable.add(getApi().getStarWarsPlanets()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handlePlanetResponse, this::handleError));

    }

    private void handlePlanetResponse(List<Planet> movies) {

        compositeDisposable.add(getApi().getStarWarsPlanets()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handlePlanetResponse, this::handleError));

    }

    void onCharacterListRequested() {

        compositeDisposable.add(getApi().getStarWarsCharacters()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleCharacterResponse, this::handleError));

    }

    private void handleCharacterResponse(List<Character> characters) {

    }

    private void handleError(Throwable throwable) {

        getView().dismissProgress();
        getView().showEmptyView();

    }
}
