package com.example.viewmodeltest.explore.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewmodeltest.R;
import com.example.viewmodeltest.articleDetails.view.DetailsActivity;
import com.example.viewmodeltest.base.BaseActivity;
import com.example.viewmodeltest.base.BaseFragment;
import com.example.viewmodeltest.base.BaseViewModel;
import com.example.viewmodeltest.explore.ItemClickListener;
import com.example.viewmodeltest.explore.adapters.ExploreRecyclerAdapter;
import com.example.viewmodeltest.explore.model.Article;
import com.example.viewmodeltest.explore.model.ArticlesResponse;
import com.example.viewmodeltest.explore.viewModel.ArticlesViewModel;

public class ExploreFragment extends BaseFragment<ArticlesResponse> implements ItemClickListener<Article> {

    ExploreRecyclerAdapter exploreRecyclerAdapter;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_explore, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        exploreRecyclerAdapter=new ExploreRecyclerAdapter(
                this,getContext(),getString(R.string.by));
        recyclerView = view.findViewById(R.id.article_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(exploreRecyclerAdapter);
    }

    @Override
    protected BaseViewModel<ArticlesResponse> getViewModel() {
        return  ViewModelProviders.of(this).get(ArticlesViewModel.class) ;
    }

    @Override
    protected boolean showLoadingOnCreate() {
        return true;
    }

    @Override
    public void onChanged(@Nullable ArticlesResponse articlesResponse) {
        if(articlesResponse!=null&&articlesResponse.getStatus()!=null)
            ((BaseActivity)(getActivity())).onError(articlesResponse.getStatus());
        else hideLoadingDialog();
        if(exploreRecyclerAdapter!=null&&articlesResponse!=null)
            exploreRecyclerAdapter.setArticleList(articlesResponse.getArticles());
    }

    @Override
    public void onClickListener(Article item) {
        Intent intent= new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("articleItem",item);
        intent.putExtra("a","b");
        startActivity(intent);
    }
}
