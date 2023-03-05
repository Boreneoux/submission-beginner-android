package com.boreneoux.submissionmoviebeginnerandroid.data

import android.content.Context
import com.boreneoux.submissionmoviebeginnerandroid.data.model.Movie
import com.boreneoux.submissionmoviebeginnerandroid.helper.parseJsonToList

class MovieData(context: Context) {
    val movies = context.parseJsonToList<Movie>(
        "json/data.json"
    )

}