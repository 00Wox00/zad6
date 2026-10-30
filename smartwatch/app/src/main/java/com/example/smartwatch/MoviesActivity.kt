package com.example.smartwatch

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class MoviesActivity : AppCompatActivity() {

    private val apiKey = "fe6af98e"
    private val titles = arrayOf("The Witcher", "Jessica Jones", "The Magicians")

    private val movies = ArrayList<Movie>()
    private val adapter = MovieAdapter(movies)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        val rvMovies = findViewById<RecyclerView>(R.id.rvMovies)
        rvMovies.layoutManager = LinearLayoutManager(this)
        rvMovies.adapter = adapter

        for (i in 0 until titles.size) {
            movies.add(Movie(titles[i], ""))
        }
        adapter.notifyItemRangeInserted(0, titles.size)

        for (i in 0 until titles.size) {
            loadMovie(i)
        }
    }

    private fun loadMovie(index: Int) {
        val url = "https://www.omdbapi.com/?apikey=" + apiKey + "&t=" + Uri.encode(titles[index])
        val queue = Volley.newRequestQueue(this)

        val request = StringRequest(
            Request.Method.GET,
            url,
            object : Response.Listener<String> {
                override fun onResponse(response: String) {
                    val gson = Gson()
                    val data = gson.fromJson(response, MovieResponse::class.java)
                    if (data.response == "True") {
                        val title = data.title ?: titles[index]
                        val poster = data.poster ?: ""
                        movies[index] = Movie(title, poster)
                        adapter.notifyItemChanged(index)
                    }
                }
            },
            object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError) {
                    Toast.makeText(this@MoviesActivity, "Ошибка загрузки: " + titles[index], Toast.LENGTH_SHORT).show()
                }
            }
        )
        queue.add(request)
    }
}
