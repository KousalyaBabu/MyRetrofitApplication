package com.example.myretrofitapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myretrofitapplication.data.Photo
import com.example.myretrofitapplication.network.RetrofitInstance
import com.example.myretrofitapplication.network.ServiceInterface
import com.example.myretrofitapplication.ui.PhotoAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = RecyclerView(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        setContentView(recyclerView)

        val serviceInterface=RetrofitInstance.retrofitInstance.create(ServiceInterface::class.java)
        serviceInterface.getAllPhotos().enqueue(object :Callback<List<Photo>>{
            override fun onFailure(call: Call<List<Photo>>?, t: Throwable?) {
                println("on failure call = [${call}], t = [${t}]")
            }

            override fun onResponse(call: Call<List<Photo>>?, response: Response<List<Photo>>?) {
                println("on response call = [${call}], response = [${response?.body()}]")
                recyclerView.adapter=PhotoAdapter(response?.body()!!)
            }
        })
    }
}