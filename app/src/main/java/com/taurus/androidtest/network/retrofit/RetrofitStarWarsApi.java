package com.taurus.androidtest.network.retrofit;

import com.taurus.androidtest.network.StarWarsApi;
import com.taurus.androidtest.network.model.BaseRequest;
import com.taurus.androidtest.network.model.category.Category;
import com.taurus.androidtest.network.model.character.Character;
import com.taurus.androidtest.network.model.movie.Movie;
import com.taurus.androidtest.network.model.planet.Planet;

import java.util.List;

import io.reactivex.Observable;

public class RetrofitStarWarsApi implements StarWarsApi {

    @Override
    public Observable<List<Category>> getStarWarsCategories() {

        APIRestEndpoints endpoints = APIRestClient.getInstanceRx().create(APIRestEndpoints.class);
        return endpoints.getStarWarsCategories();

    }

    @Override
    public Observable<List<Movie>> getStarWarsMovies() {

        APIRestEndpoints endpoints = APIRestClient.getInstanceRx().create(APIRestEndpoints.class);
        return endpoints.getStarWarsMovies();

    }

    @Override
    public Observable<List<Planet>> getStarWarsPlanets() {

        APIRestEndpoints endpoints = APIRestClient.getInstanceRx().create(APIRestEndpoints.class);
        return endpoints.getStarWarsPlanets();

    }

    @Override
    public Observable<List<Character>> getStarWarsCharacters() {

        APIRestEndpoints endpoints = APIRestClient.getInstanceRx().create(APIRestEndpoints.class);
        return endpoints.getStarWarsCharacters();

    }
}
