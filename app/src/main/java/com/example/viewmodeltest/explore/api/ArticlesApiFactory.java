package com.example.viewmodeltest.explore.api;

import com.example.viewmodeltest.base.BaseApiFactory;

public class ArticlesApiFactory extends BaseApiFactory<ArticlesApiInterface> {
    @Override
    public ArticlesApiInterface initiate() {
        return getInstance().create(ArticlesApiInterface.class);
    }
}
