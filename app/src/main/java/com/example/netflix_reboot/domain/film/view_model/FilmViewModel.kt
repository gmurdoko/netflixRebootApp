package com.example.netflix_reboot.domain.film.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.netflix_reboot.config.retrofit.RetrofitBuilder
import com.example.netflix_reboot.domain.film.api.FilmAPI
import com.example.netflix_reboot.domain.film.model.Film
import com.example.netflix_reboot.domain.film.repository.FilmRepository

class FilmViewModel : ViewModel() {
    private val filmRepository: FilmRepository

    init {
        val filmApi = RetrofitBuilder.createRetrofit().create(FilmAPI::class.java)
        filmRepository = FilmRepository(filmApi)
    }

    val  film: LiveData<Film> = filmRepository.film
    val allFilm : LiveData<List<Film>> = filmRepository.filmList
    fun getFilmByID(id: String){
        filmRepository.getFilmByID(id)
    }
    fun createFilm(film: Film){
        filmRepository.createFilm(film)
    }
    fun getAllFilm(){
        filmRepository.getAllFilm()
    }
}