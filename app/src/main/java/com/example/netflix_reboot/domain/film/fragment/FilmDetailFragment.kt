package com.example.netflix_reboot.domain.film.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import com.example.netflix_reboot.R
import com.example.netflix_reboot.domain.film.view_model.FilmViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_film_detail.*


class FilmDetailFragment : Fragment() {
    val filmViewModel by activityViewModels<FilmViewModel>()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getString("position")?:""
        filmViewModel.getFilmByID(id)
        filmViewModel.film.observe(viewLifecycleOwner, Observer {
            duration_film_detail.text = it.duration
            synopsis_film_detail.text = it.synopsis
            Picasso.get().load(it.imageUrl).into(image_film_detail)
        })
    }


}