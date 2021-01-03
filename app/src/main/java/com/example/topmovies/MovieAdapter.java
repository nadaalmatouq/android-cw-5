package com.example.topmovies;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter {


   final LinearLayout ll;
    ArrayList<Movie> movieArray;
    Context context;

    public MovieAdapter(ArrayList<Movie> movieArray, Context context,LinearLayout ll) {
        this.movieArray = movieArray;
        this.context = context;
        this.ll = ll;
    }

    @NonNull
    @Override
    //On create = Once the page is open
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //on create, viewholder connects to the xml view movie_cell_design
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_cell_design,parent,false);


        //we pass this view to viewHolder consrtuctor so that elements of v from movie_cell_design are passed to the consturcter
        ViewHolder vh = new ViewHolder(v);

        return vh; }

    @Override
    //onBind Here is where change elements of view
    ///Binding///
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       ((ViewHolder) holder).rank.setText(movieArray.get(position).getRank()+"");
        ((ViewHolder) holder).year.setText(movieArray.get(position).getYear()+"");
        ((ViewHolder) holder).name.setText(movieArray.get(position).getName());
        ((ViewHolder) holder).img.setImageResource(movieArray.get(position).getImg());

        ((ViewHolder) holder).v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Jumping to movieDetails xml on clicking on each cell
                Intent i = new Intent(context,MovieDetails.class);
                i.putExtra("movie",movieArray.get(position));
                context.startActivity(i);
            }
        });

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        ((ViewHolder) holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.setTitle("Delete");
                builder.setMessage("Are you sure you want to delete?");
                builder.setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Movie deleted = movieArray.get(position);
                        movieArray.remove(position);
                        //to update the view after removing the cell
                        notifyDataSetChanged();

                        Snackbar.make(ll,"Undo Delete?", Snackbar.LENGTH_LONG).setAction("undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                movieArray.add(position, deleted);
                                notifyDataSetChanged();
                            }
                        }).show();

                    }
                });


                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();



            }
        });








    }

    @Override
    public int getItemCount() {
        return movieArray.size();
    }

//In order to access each movie parameters (name,year,elc) we need View holder that takes an input view passed from v

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView img;
        public ImageView delete;
        public TextView name;
        public TextView year;
        public TextView rank;
        //Adding a view
        public View v;



        //constructer
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            //this is not an activity so we use a view v that we passed that is an activity
            img = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name);
            year = itemView.findViewById(R.id.year);
            rank = itemView.findViewById(R.id.rank);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
