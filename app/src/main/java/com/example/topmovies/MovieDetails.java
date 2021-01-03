package com.example.topmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        //Destination view
        //receives elements from source view

        Bundle b = getIntent().getExtras();
        //why "movie"?
        Movie m = (Movie) b.getSerializable("movie");

        //Connecting xml components to code
        ImageView shdw = findViewById(R.id.shadowImg);
        ImageView img = findViewById(R.id.img);
        TextView name = findViewById(R.id.mname);
        TextView genre = findViewById(R.id.genre);

        //Binding
        shdw.setImageResource(m.getImg());
        img.setImageResource(m.getImg());
        name.setText(m.getName());
        genre.setText(m.getGenre());




    }
}