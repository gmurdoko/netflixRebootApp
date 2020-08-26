package com.example.netflix_reboot.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.netflix_reboot.container.AppContainer
import com.example.netflix_reboot.MyApplication
import com.example.netflix_reboot.R
import com.example.netflix_reboot.domain.film.view_model.FilmViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController

    @Inject lateinit var filmViewModel: FilmViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (applicationContext as MyApplication).applicationComponent.inject(this)
        setContentView(R.layout.activity_main)
        navController = (nav_main_host_fragment_container as NavHostFragment).navController
        NavigationUI.setupWithNavController(bottom_navigation, navController)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.showGood -> {
                    navController.navigate(R.id.action_to_filmFragment)
                    true
                }

                R.id.createGood -> {
                    navController.navigate(R.id.action_to_filmAddFragment)
                    true
                }
                else -> {
                    println("MASUK ELSE")
                    false
                }
            }
        }
    }
}