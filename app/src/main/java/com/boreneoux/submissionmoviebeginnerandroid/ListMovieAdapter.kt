package com.boreneoux.submissionmoviebeginnerandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.boreneoux.submissionmoviebeginnerandroid.data.model.Movie
import com.boreneoux.submissionmoviebeginnerandroid.databinding.ItemRowMovieBinding
import com.bumptech.glide.Glide

class ListMovieAdapter(private val onItemClick: (Movie) -> Unit) :
    RecyclerView.Adapter<ListMovieAdapter.MovieViewHolder>() {

    private val movies = mutableListOf<Movie>()


    class MovieViewHolder(val binding: ItemRowMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie, context: Context, onItemClick: (Movie) -> Unit) {
            Glide.with(context)
                .load(movie.Poster)
                .into(binding.imgItemPhoto)
            binding.tvItemTitle.text = movie.Title
            binding.tvItemDescription.text = movie.Plot
            binding.tvItemYear.text = movie.Year

            binding.movieItemContainer.setOnClickListener {
                onItemClick(movie)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding =
            ItemRowMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, holder.itemView.context, onItemClick)
    }

    fun setMovies(movies: List<Movie>) {
        this.movies.clear()
        this.movies.addAll(movies)
    }

}