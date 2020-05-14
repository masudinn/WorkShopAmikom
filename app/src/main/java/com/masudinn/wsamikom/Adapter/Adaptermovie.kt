package com.masudinn.wsamikom.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masudinn.wsamikom.Model.movie
import com.masudinn.wsamikom.R
import com.masudinn.wsamikom.network.API
import kotlinx.android.synthetic.main.item_movie.view.*

class Adaptermovie: RecyclerView.Adapter<Adaptermovie.ViewHolder>() {
    private val listMovie = mutableListOf<movie>()

    class ViewHolder (itemView: View) :RecyclerView.ViewHolder(itemView) {
        fun bind(movie: movie){
            itemView.judul.text = movie.tittle
            itemView.overview.text = movie.overview
            itemView.tanggal.text = movie.release_date

            val imageUrl = API.IMAGE+movie.poster_Path
            Glide.with(itemView).load(imageUrl).centerCrop().into(itemView.imaagitem)

            itemView.setOnClickListener{

            }
        }
    }
    fun addData(data : List<movie>){
        listMovie.addAll(data)
        notifyDataSetChanged()
    }

    //membuat object dari class yang ada didalamnya
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_movie,parent,false) as ViewGroup)

    override fun getItemCount(): Int =listMovie.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }
}