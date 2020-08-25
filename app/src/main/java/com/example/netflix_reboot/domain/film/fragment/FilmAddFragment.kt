package com.example.netflix_reboot.domain.film.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.netflix_reboot.container.AppContainer
import com.example.netflix_reboot.MyApplication
import com.example.netflix_reboot.R
import com.example.netflix_reboot.domain.film.model.Film
import kotlinx.android.synthetic.main.fragment_film_add.*


class FilmAddFragment : Fragment() {

//    private val filmViewModel by activityViewModels<FilmViewModel>()
    lateinit var appContainer: AppContainer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContainer = (activity?.application as MyApplication).appContainer
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_submit_film.setOnClickListener{
            val newFilm = Film(title = input_film_title.text.toString()
                , duration = input_film_duration.text.toString()
                , imageUrl = input_image_url.text.toString()
                , synopsis = input_film_synopsis.text.toString())
            appContainer.filmViewModel.createFilm(newFilm)
            Navigation.findNavController(view).navigate(R.id.action_filmAddFragment_pop)
        }
    }

}