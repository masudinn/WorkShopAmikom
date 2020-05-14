package com.masudinn.wsamikom.network

import com.masudinn.wsamikom.Model.MovieResponse
import com.masudinn.wsamikom.Model.movie
import retrofit2.Call
import retrofit2.http.GET

interface iMovie {
    @GET("now_playing?api_key=280af572647b3e8153b144e478ba7a36")
    fun getMovies() : Call<MovieResponse>
}
