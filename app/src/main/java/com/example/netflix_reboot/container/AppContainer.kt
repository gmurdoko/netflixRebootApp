package com.example.netflix_reboot.container

import com.example.netflix_reboot.config.retrofit.RetrofitBuilder
import com.example.netflix_reboot.domain.film.api.FilmAPI
import com.example.netflix_reboot.domain.film.repository.FilmRepository
import com.example.netflix_reboot.domain.film.view_model.FilmViewModel

class AppContainer {
//    private val filmApi = RetrofitBuilder.createRetrofit().create(FilmAPI::class.java)
//    private val filmRepository: FilmRepository = FilmRepository(filmApi)
//    val filmViewModelFactory : FilmViewModelFactory =
//        FilmViewModelFactory(filmRepository)
//    val filmViewModel : FilmViewModel = filmViewModelFactory.create()

}

class FilmViewModelFactory(val filmRepository: FilmRepository):
    Factory<FilmViewModel> {
    override fun create(): FilmViewModel {
        return FilmViewModel(filmRepository)
    }

}

interface Factory<T>{
    fun create(): T
}