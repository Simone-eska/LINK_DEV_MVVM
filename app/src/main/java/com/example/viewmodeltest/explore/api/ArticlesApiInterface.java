package com.example.viewmodeltest.explore.api;

import com.example.viewmodeltest.explore.model.ArticlesResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ArticlesApiInterface {
    @GET
    Observable<ArticlesResponse> fetchModels(@Url String url, @Query("source") String source, @Query("apiKey") String key);
}
