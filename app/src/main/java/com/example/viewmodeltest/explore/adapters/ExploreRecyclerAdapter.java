package com.example.viewmodeltest.explore.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.viewmodeltest.R;
import com.example.viewmodeltest.explore.ItemClickListener;
import com.example.viewmodeltest.explore.model.Article;
import com.example.viewmodeltest.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ExploreRecyclerAdapter extends  RecyclerView.Adapter<ExploreRecyclerAdapter.ArticleViewHolder> {

    private List<Article> articleList;
    private ItemClickListener<Article> clickListener;
    private final String by;


    public ExploreRecyclerAdapter( ItemClickListener<Article> clickListener, Context context, String by) {
        this.articleList = new ArrayList<>();
        this.clickListener = clickListener;
        this.by = by+" ";
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList.clear();
        this.articleList.addAll(articleList);
        this.notifyDataSetChanged();
    }


    public class ArticleViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
         TextView titleTextView,subTitleTextView,dateTextView;
         ImageView img;
        ArticleViewHolder(View v) {
            super(v);
            titleTextView = (TextView)v.findViewById(R.id.article_title_tv);
            subTitleTextView = (TextView)v.findViewById(R.id.article_subtitle_tv);
            dateTextView = (TextView)v.findViewById(R.id.article_date_tv);
            img = (ImageView)v.findViewById(R.id.imageView);
        }

        @Override
        public void onClick(View v) {
          if(clickListener!=null)
              clickListener.onClickListener(articleList.get(getAdapterPosition()));
        }
    }
    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ArticleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.article_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder myViewHolder, int i) {
        if(articleList.get(i).getTitle()!=null)
            myViewHolder.titleTextView.setText(articleList.get(i).getTitle());
        if(articleList.get(i).getAuthor()!=null)
            myViewHolder.subTitleTextView.setText((by+articleList.get(i).getAuthor()));
        if(articleList.get(i).getPublishedAt()!=null){
            myViewHolder.dateTextView.setText(Utils.getDateFormat(articleList.get(i).getPublishedAt()));
        }
        if(articleList.get(i).getUrlToImage()!=null||!articleList.get(i).getUrlToImage().isEmpty()){
            Picasso.get().load(articleList.get(i).getUrlToImage())
                    .placeholder(R.drawable.placeholder).into(myViewHolder.img);
        }
    }

    @Override
    public int getItemCount() { return articleList.size(); }
}
