package com.boreneoux.submissionmoviebeginnerandroid

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.boreneoux.submissionmoviebeginnerandroid.data.model.Movie
import com.boreneoux.submissionmoviebeginnerandroid.databinding.ActivityDetailMovieBinding
import com.bumptech.glide.Glide

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var binding: ActivityDetailMovieBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_MOVIE, Movie::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_MOVIE)
        }

        movie?.let {
            binding.apply {
                Glide.with(this@DetailMovieActivity)
                    .load(movie.Images[0])
                    .into(imgMoviePhoto)
                tvMovieTitle.text = movie.Title
                tvMovieYear.text = movie.Year
                tvMovieRate.text = movie.Rated
                tvMovieGenre.text = movie.Genre
                tvMoviePlot.text = movie.Plot
                tvMovieDuration.text = movie.Runtime
                detailMovieProduction.tvMovieActors.text = movie.Actors
                detailMovieProduction.tvMovieDirector.text = movie.Director
                detailMovieProduction.tvMovieWriter.text = movie.Writer
                movieImdbRating.tvImdbRating.text = movie.imdbRating
            }
        }

        binding.actionShare.setOnClickListener{
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Movie Recommendation")
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "Check out this Movie! Title: ${binding.tvMovieTitle.text} ${binding.tvMovieYear.text}, It's About ${binding.tvMoviePlot.text}")
            startActivity(Intent.createChooser(sharingIntent, "Share Using"))
        }

    }

}
