package com.taurus.androidtest.network;

import com.taurus.androidtest.network.model.BaseRequest;
import com.taurus.androidtest.network.model.category.Category;
import com.taurus.androidtest.network.model.character.Character;
import com.taurus.androidtest.network.model.movie.Movie;
import com.taurus.androidtest.network.model.planet.Planet;

import java.util.List;

import io.reactivex.Observable;

public interface StarWarsApi {

    Observable<List<Category>> getStarWarsCategories();

    Observable<List<Movie>> getStarWarsMovies(BaseRequest request);

    Observable<List<Planet>> getStarWarsPlanets(BaseRequest request);

    Observable<List<Character>> getStarWarsCharacters(BaseRequest request);

}
