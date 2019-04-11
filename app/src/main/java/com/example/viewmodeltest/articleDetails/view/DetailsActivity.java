package com.example.viewmodeltest.articleDetails.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.viewmodeltest.R;
import com.example.viewmodeltest.base.BaseActivity;
import com.example.viewmodeltest.explore.model.Article;
import com.example.viewmodeltest.utils.Utils;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends BaseActivity {
    Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        article = getIntent().getParcelableExtra("articleItem");

        if (article != null) {
            ((TextView) findViewById(R.id.details_description_tv)).setText(article.getDescription());
            ((TextView) findViewById(R.id.details_title_tv)).setText(article.getTitle());
            ((TextView) findViewById(R.id.details_subtitle_tv)).setText((getString(R.string.by) + " " + article.getAuthor()));
            if (article.getPublishedAt() != null)
                ((TextView) findViewById(R.id.details_date_tv)).setText(Utils.getDateFormat(article.getPublishedAt()));
            if (article.getUrlToImage() != null && !article.getUrlToImage().isEmpty()) {
                Picasso.get().load(article.getUrlToImage())
                        .placeholder(R.drawable.placeholder).into(((ImageView) findViewById(R.id.details_img)));
            }
            ((TextView) findViewById(R.id.open_website_btn)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse(article.getUrl());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    protected void performHomeClickAction() {
        finish();
    }
}
