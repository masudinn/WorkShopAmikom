package com.masudinn.wsamikom.Adapter

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masudinn.wsamikom.Model.movie
import com.masudinn.wsamikom.R
import com.masudinn.wsamikom.network.api
import kotlinx.android.synthetic.main.item_movie.view.*

class Adaptermovie: RecyclerView.Adapter<Adaptermovie.ViewHolder>() {
    private val listMovie = mutableListOf<movie>()
    class ViewHolder (itemView:ViewGroup) :RecyclerView.ViewHolder(itemView) {
        fun bind(movie: movie){
            itemView.judul.text = movie.tittle
            itemView.overview.text = movie.overview
            itemView.tanggal.text = movie.release_date

            val imageUrl = api.IMAGE+movie.poster_Path
            Glide.with(itemView).load(imageUrl).centerCrop().into(itemView.imgitem)

            itemView.setOnClickListener{

            }
        }
    }

    private val lisMovie= mutableListOf<movie>()

    fun addData(data : List<movie>){
        lisMovie.addAll(data)
        notifyDataSetChanged()
    }

    //membuat object dari class yang ada didalamnya
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_movie,parent,false) as ViewGroup)

    override fun getItemCount(): Int =lisMovie.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lisMovie[position])
    }
}