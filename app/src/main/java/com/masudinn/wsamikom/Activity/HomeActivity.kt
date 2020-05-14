package com.masudinn.wsamikom.Activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.masudinn.wsamikom.Adapter.Adaptermovie
import com.masudinn.wsamikom.Adapter.Myadapter
import com.masudinn.wsamikom.Model.MovieResponse
import com.masudinn.wsamikom.R
import com.masudinn.wsamikom.network.api
import com.masudinn.wsamikom.network.iMovie
import com.masudinn.wsamikom.util.Data
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity() {
    private lateinit var adaptermovie: Adaptermovie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        adaptermovie = Adaptermovie()
        rv.adapter = adaptermovie
        rv.layoutManager = LinearLayoutManager(this)

        getData()
    }

    private fun getData() {
        Log.d("BASE_URL",api.BASE_URL)
        val iMovie = Retrofit.Builder()
            .baseUrl(api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(iMovie::class.java)

        iMovie.getMovies().enqueue(object : Callback<MovieResponse>{
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(this@HomeActivity,"Request gagal:${t.localizedMessage}",
                Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val body = response.body()
                if(body != null){
                    adaptermovie.addData(body.results)
                }
            }

        })
    }

}
