package com.example.flixster

import org.json.JSONArray
import org.json.JSONObject

data class Movie(
    val title: String,
    val overview: String,
    val posterPath: String
) {
    companion object {
        private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/"

        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()) {
                val movieJson: JSONObject = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        title = movieJson.getString("title"),
                        overview = movieJson.getString("overview"),
                        posterPath = IMAGE_BASE_URL + movieJson.getString("poster_path")
                    )
                )
            }
            return movies
        }
    }
}
