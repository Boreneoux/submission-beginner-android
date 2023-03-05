package com.boreneoux.submissionmoviebeginnerandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.boreneoux.submissionmoviebeginnerandroid.data.MovieData
import com.boreneoux.submissionmoviebeginnerandroid.data.model.Movie
import com.boreneoux.submissionmoviebeginnerandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieData: MovieData


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieData = MovieData(this)
        showMovieList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                navigateToAbout()
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun showMovieList() {
        binding.rvMovies.apply {
            adapter = ListMovieAdapter(onItemClick = { navigateToDetailMovie(it) }).apply {
                setMovies(movieData.movies)
            }
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }

    private fun navigateToDetailMovie(movie: Movie) {
        val detailMovieIntent = Intent(this@MainActivity, DetailMovieActivity::class.java)
        detailMovieIntent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie)
        startActivity(detailMovieIntent)
    }

    private fun navigateToAbout() {
        val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(aboutIntent)
    }
}