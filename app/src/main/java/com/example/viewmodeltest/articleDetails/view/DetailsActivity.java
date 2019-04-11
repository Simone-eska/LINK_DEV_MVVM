package com.example.viewmodeltest.articleDetails.view;

import android.os.Bundle;
import android.widget.TextView;

import com.example.viewmodeltest.R;
import com.example.viewmodeltest.base.BaseActivity;
import com.example.viewmodeltest.explore.model.Article;
import com.example.viewmodeltest.utils.Utils;

public class DetailsActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Article article = getIntent().getParcelableExtra("articleItem");
        if(article!=null){
            ((TextView)findViewById(R.id.details_description_tv)).setText(article.getDescription());
            ((TextView)findViewById(R.id.details_title_tv)).setText(article.getTitle());
            ((TextView)findViewById(R.id.details_subtitle_tv)).setText((getString(R.string.by)+" "+article.getAuthor()));
            if(article.getPublishedAt()!=null)
            ((TextView)findViewById(R.id.details_date_tv)).setText(Utils.getDateFormat(article.getPublishedAt()));
        }
    }
}
