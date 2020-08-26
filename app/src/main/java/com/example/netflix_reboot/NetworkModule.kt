package com.example.netflix_reboot

import com.example.netflix_reboot.config.retrofit.RetrofitBuilder
import com.example.netflix_reboot.domain.film.api.FilmAPI
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {
    @Provides
    fun provideFilmAPI(): FilmAPI{
        return  RetrofitBuilder.createRetrofit().create(FilmAPI::class.java)
    }
}