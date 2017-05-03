package com.taurus.androidtest.network;

import com.taurus.androidtest.network.retrofit.model.category.Category;

import java.util.List;

import io.reactivex.Observable;

public interface StarWarsApi {

    Observable<List<Category>> getStarWarsCategories();
}
