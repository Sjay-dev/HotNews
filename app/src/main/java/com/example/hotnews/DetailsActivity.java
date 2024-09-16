package com.example.hotnews;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotnews.Models.NewsHeadLines;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
        NewsHeadLines headLines;

        TextView title , author , time , detail , content;
        ImageView imgNews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        title = findViewById(R.id.txtDetailTitle);
        author = findViewById(R.id.txtDetailAuthor);
        time = findViewById(R.id.txtDetailTime);
        detail = findViewById(R.id.txtDetailDeatils);
        content = findViewById(R.id.txtDetailContent);
        imgNews = findViewById(R.id.imgDetailNews);
        headLines = (NewsHeadLines) getIntent().getSerializableExtra("data");


            title.setText(headLines.getTitle());
            author.setText(headLines.getAuthor());
            time.setText(headLines.getPublishedAt());
            detail.setText(headLines.getDescription());
                content.setText(headLines.getContent());
            Picasso.get().load(headLines.getUrlToImage()).into(imgNews);
    }
}