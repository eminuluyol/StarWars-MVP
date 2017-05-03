package com.taurus.androidtest.network.retrofit;

import com.taurus.androidtest.network.StarWarsApi;
import com.taurus.androidtest.network.model.Category;

import java.util.List;

import io.reactivex.Observable;

public class RetrofitStarWarsApi implements StarWarsApi {

    @Override
    public Observable<List<Category>> getStarWarsCategories() {

        APIRestEndpoints endpoints = APIRestClient.getInstanceRx().create(APIRestEndpoints.class);
        return endpoints.getStarWarsCategories();

    }
}
