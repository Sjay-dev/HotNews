package com.example.hotnews;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hotnews.Models.NewsApiResponse;
import com.example.hotnews.Models.NewsHeadLines;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener , View.OnClickListener {
    RecyclerView recyclerView;
    CustomAdapter adapter;

    ProgressDialog dialog;

    Button  business, entertainment  , general  ,health ,  science ,  sport ,  technology;

    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            business = findViewById(R.id.btnBusiness);
            business.setOnClickListener(this);

            entertainment = findViewById(R.id.btnEntertainment);
            entertainment.setOnClickListener(this);

            general = findViewById(R.id.btnGeneral);
            general.setOnClickListener(this);

            health = findViewById(R.id.btnHealth);
            health.setOnClickListener(this);

            science = findViewById(R.id.btnScience);
            science.setOnClickListener(this);

            sport = findViewById(R.id.btnSports);
            sport.setOnClickListener(this);

            technology = findViewById(R.id.btnTechnology);
            technology.setOnClickListener(this);

            searchView =findViewById(R.id.SearchView);

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    dialog.setTitle("Fetching news on" + query);
                    dialog.show();
                    RequestManager manager = new RequestManager(MainActivity.this);
                    manager.getNewsHeadlines(listner , "general" , query);
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });

       dialog = new ProgressDialog(this);
       dialog.setTitle("Fetching news...");
       dialog.show();



        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listner , "general" , null);
    }

    private final OnFetchDataListner<NewsApiResponse> listner = new OnFetchDataListner<NewsApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadLines> list, String message) {
            if(list.isEmpty()){
                Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_SHORT).show();
            }

            else{
                showNews(list);
                dialog.dismiss();
            }

        }

        @Override
        public void onError(String name) {
            Toast.makeText(MainActivity.this, "An Error occurred", Toast.LENGTH_SHORT).show();
        }
    };

    private void showNews(List<NewsHeadLines> list) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this , 1));
        adapter = new CustomAdapter(this , list , this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onNewsClicked(NewsHeadLines headLines) {
            startActivity(new Intent(this , DetailsActivity.class)
                    .putExtra("data" , headLines));
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String category = button.getText().toString();
        dialog.setTitle("Fetching news...");
        dialog.show();
        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listner , category , null);
    }
}