package com.taurus.androidtest.network.retrofit;

import com.taurus.androidtest.network.model.category.Category;
import com.taurus.androidtest.network.model.character.Character;
import com.taurus.androidtest.network.model.movie.Movie;
import com.taurus.androidtest.network.model.planet.Planet;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIRestEndpoints {

    @GET("/categories")
    Observable<List<Category>> getStarWarsCategories(
    );

    @GET("/list/{type}")
    Observable<List<Movie>> getStarWarsMovies(
            @Path("type") int type
    );

    @GET("/list/{type}")
    Observable<List<Planet>> getStarWarsPlanets(
            @Path("type") int type
    );

    @GET("/list/{type}")
    Observable<List<Character>> getStarWarsCharacters(
            @Path("type") int type
    );
}
