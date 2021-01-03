package com.example.topmovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Movie> movieList = new ArrayList<>(); //Array of lists

        Movie m1 = new Movie("Taken", 2008 ,"Action", false, R.drawable.taken,1);
        Movie m2 = new Movie("Salt",  2010 , "Action", false, R.drawable.salt,2);
        Movie m3 = new Movie("Toy Story 4",  2019 , "Kids",  true,R.drawable.toystory4,3);
        Movie m4 = new Movie("The Lion King ",  2008 ,  "Kids",  false ,R.drawable.thelionking,4);


        System.out.println("Teseeeet");
        movieList.add(m1);
        movieList.add(m2);
        movieList.add(m3);
        movieList.add(m4);

        System.out.println(m3.getRank());

       //connect recyclerView

        RecyclerView rv = findViewById(R.id.rv);
       //Alligning recyclerview with linear layout  To setup cell size of recycler view
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);





        //using Mikepenz Drawer library

        Toolbar toolbar = findViewById(R.id.toolbar);
        final LinearLayout ll = findViewById(R.id.linearLayout);
        // linking icons with code
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(R.drawable.ic_baseline_home_24);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("profile").withIcon(R.drawable.ic_baseline_person_24);
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withName("Settings");

        Drawer result = new DrawerBuilder().withActivity(this).withToolbar(toolbar).addDrawerItems(item1,item2,new DividerDrawerItem(),item3).build();



        MovieAdapter ma = new MovieAdapter(movieList,MainActivity.this, ll);

        rv.setAdapter(ma);












    }
}