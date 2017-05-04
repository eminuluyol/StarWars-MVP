package com.taurus.androidtest.network.retrofit;

import com.taurus.androidtest.network.model.category.Category;
import com.taurus.androidtest.network.model.character.CharacterWrapper;
import com.taurus.androidtest.network.model.movie.Movie;
import com.taurus.androidtest.network.model.planet.Planet;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIRestEndpoints {

    @GET("/categories")
    Observable<List<Category>> getStarWarsCategories(
    );

    @GET("/list/1")
    Observable<List<Movie>> getStarWarsMovies(

    );

    @GET("/list/2")
    Observable<List<Planet>> getStarWarsPlanets(

    );

    @GET("/list/3/")
    Observable<CharacterWrapper> getStarWarsCharacters(
            @Query("page") int page
    );
}
