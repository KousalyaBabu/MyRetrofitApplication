package com.example.myretrofitapplication.ui

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myretrofitapplication.data.Photo

class PhotoAdapter(private val list:List<Photo>) : RecyclerView.Adapter<PhotoAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(TextView(parent.context))
    }

    override fun getItemCount(): Int =list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setPhoto(list[position])
    }

    class MyViewHolder(private val view: TextView):RecyclerView.ViewHolder(view){
        fun setPhoto(photo: Photo){
            view.text="album ${photo.albumId}, id ${photo.id}, title ${photo.title}, url ${photo.url}, thumbnailUrl ${photo.thumbnailUrl}"
        }
    }
}
