package com.taurus.androidtest.network.retrofit;

import com.taurus.androidtest.network.model.Category;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIRestEndpoints {

    @GET("/categories")
    Observable<List<Category>> getStarWarsCategories(
    );
}
