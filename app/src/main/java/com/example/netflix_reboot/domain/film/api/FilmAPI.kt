package com.example.netflix_reboot.domain.film.api

import com.example.netflix_reboot.domain.film.model.Film
import com.example.netflix_reboot.response_data.ResponseData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FilmAPI {
    @GET("film/{id}")
    fun getFilmByID(@Path("id") id: String): Call<ResponseData>

    @POST("film")
    fun createFilm(@Body film: Film): Call<ResponseData>

    @GET("film")
    fun getAllData():Call<ResponseData>
}