package com.example.netflix_reboot.domain.film.repository

import androidx.lifecycle.MutableLiveData
import com.example.netflix_reboot.domain.film.api.FilmAPI
import com.example.netflix_reboot.domain.film.model.Film
import com.example.netflix_reboot.response_data.ResponseData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmRepository(val filmApi: FilmAPI) {
    val film: MutableLiveData<Film> = MutableLiveData<Film>()
    val filmList: MutableLiveData<List<Film>> = MutableLiveData<List<Film>>()
    fun getFilmByID(id: String) {
        filmApi.getFilmByID(id).enqueue(object : Callback<ResponseData> {
            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                val responseData = response.body()

                if (responseData?.status == "200") {
                    val res = responseData.result
                    val gson = Gson()
                    film.value = gson.fromJson(gson.toJson(res), Film::class.java)
                } else {
                    film.value = Film("", "", "", "", "")
                    println("[ERROR] Data not found")
                }
            }

        })
    }
    fun getAllFilm(){
        filmApi.getAllData().enqueue(object : Callback<ResponseData>{
            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                val responseData = response.body()

                if (responseData?.status == "200"){
                    val res = responseData.result
                    val gson = Gson()
                    filmList.value = gson.fromJson(gson.toJson(res), Array<Film>::class.java).toList()

                }
            }

        })
    }
    fun createFilm(film: Film) {
        filmApi.createFilm(film).enqueue(object : Callback<ResponseData> {
            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                val responseData = response.body()

                if (responseData?.status == "OK"){

                }
            }
        })
    }
}