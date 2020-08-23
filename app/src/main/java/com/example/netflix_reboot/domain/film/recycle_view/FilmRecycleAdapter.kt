package com.example.netflix_reboot.domain.film.recycle_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.netflix_reboot.domain.film.model.Film
import com.example.netflix_reboot.R
import com.squareup.picasso.Picasso


class FilmRecycleAdapter (
    val filmList: List<Film>,
    val getActivity: FragmentActivity?
): RecyclerView.Adapter<FilmViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.film_item_layout, parent,false)
        return FilmViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.id.tag = filmList[position].id
        holder.filmTitle.text = filmList[position].title
        holder.filmDuration.text = filmList[position].duration
        Picasso.get().load(filmList[position].imageUrl).into(holder.imageView)
        val bundle = bundleOf(Pair("position", filmList[position].id))
        holder.itemView.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_to_filmDetailFragment,bundle)
        }
    }

}

class FilmViewHolder(v: View): RecyclerView.ViewHolder(v){
    val id = v.findViewById<ConstraintLayout>(R.id.linearLayout)
    val filmTitle = v.findViewById<TextView>(R.id.title_film_list)
    val filmDuration = v.findViewById<TextView>(R.id.duration_film_list)
    val imageView : ImageView = v.findViewById(R.id.image_film_list)

}