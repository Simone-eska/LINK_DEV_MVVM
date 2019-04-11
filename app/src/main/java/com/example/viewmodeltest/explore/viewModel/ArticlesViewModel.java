package com.example.viewmodeltest.explore.viewModel;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.viewmodeltest.base.BaseViewModel;
import com.example.viewmodeltest.explore.api.ArticlesApiFactory;
import com.example.viewmodeltest.explore.model.ArticlesResponse;

import io.reactivex.Observable;

public class ArticlesViewModel extends BaseViewModel<ArticlesResponse> {

    public ArticlesViewModel(@NonNull Application application) {
        super(application);
    }

    protected Observable<ArticlesResponse> callFirstApi(){
        return new ArticlesApiFactory().initiate().fetchModels("articles",SOURCE,API_KEY);
    }
}
