package com.example.netflix_reboot

import com.example.netflix_reboot.activity.MainActivity
import com.example.netflix_reboot.domain.film.fragment.FilmAddFragment
import com.example.netflix_reboot.domain.film.fragment.FilmDetailFragment
import com.example.netflix_reboot.domain.film.fragment.FilmFragment
import dagger.Component

@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(filmFragment: FilmFragment)
    fun inject(filmAddFragment: FilmAddFragment)
    fun inject(filmDetailFragment: FilmDetailFragment)
}