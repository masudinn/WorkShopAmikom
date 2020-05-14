package com.masudinn.wsamikom.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.masudinn.wsamikom.Model.Mahasiswa
import com.masudinn.wsamikom.R
import kotlinx.android.synthetic.main.item.view.*
import kotlinx.android.synthetic.main.item_movie.view.*


class Myadapter (private val callback:(Mahasiswa) -> Unit):BaseAdapter(){
    private val listMhs = mutableListOf<Mahasiswa>()

    fun addData(data : List<Mahasiswa>){
        listMhs.addAll(data)
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val v = LayoutInflater.from(parent!!.context).inflate(R.layout.item,parent,false)
        v.nama.text = listMhs[position].nama
        v.nim.text = listMhs[position].nim
        v.kelas.text = listMhs[position].kelas
        Glide.with(v).load(listMhs[position].img).into(v.imageitem)
        v.setOnClickListener{(callback(listMhs[position]))}
        return v
    }

    override fun getItem(position: Int): Any {
        return listMhs[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return listMhs.size
    }

}