package com.example.hotnews;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView Title , Source;
    ImageView headline;

    CardView cardView;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        Title = itemView.findViewById(R.id.txtTitle);
        Source = itemView.findViewById(R.id.txtSource);
        headline = itemView.findViewById(R.id.imgHeadLine);
        cardView = itemView.findViewById(R.id.mainContainer);


    }
}
