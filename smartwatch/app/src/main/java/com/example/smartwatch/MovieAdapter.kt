package com.example.smartwatch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MovieAdapter(private val movies: ArrayList<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivPoster: ImageView = itemView.findViewById(R.id.ivPoster)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie = movies[position]
        holder.tvTitle.text = movie.title

        if (movie.poster.isEmpty() || movie.poster == "N/A") {
            holder.ivPoster.setImageResource(R.drawable.placeholder)
        } else {
            Picasso.get()
                .load(movie.poster)
                .placeholder(R.drawable.placeholder)
                .into(holder.ivPoster)
        }

        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(holder.itemView.context, "Воспроизведение: " + movie.title, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}