package com.example.netflix_reboot.domain.film.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.netflix_reboot.R
import com.example.netflix_reboot.domain.film.recycle_view.FilmRecycleAdapter
import com.example.netflix_reboot.domain.film.view_model.FilmViewModel
import kotlinx.android.synthetic.main.fragment_film.*

class FilmFragment : Fragment() {
    private val filmViewModel by activityViewModels<FilmViewModel>()
    private lateinit var filmRecycleAdapter: FilmRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        film_list_recycle_view.layoutManager = LinearLayoutManager(activity)
        filmViewModel.getAllFilm()
        filmViewModel.allFilm.observe(viewLifecycleOwner, Observer {
            filmRecycleAdapter = FilmRecycleAdapter(it, activity)
            film_list_recycle_view.adapter = filmRecycleAdapter
        })

    }

}