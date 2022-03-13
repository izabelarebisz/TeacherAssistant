package com.example.asystentnauczyciela

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.asystentnauczyciela.view.fragmentStart
import com.example.asystentnauczyciela.view.fragmentStudenci
import com.example.asystentnauczyciela.view.fragmentZajecia
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

/*    private val st = fragmentStart()
    private val std = fragmentStudenci()
    private val za = fragmentZajecia()*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = Navigation.findNavController(this,R.id.fragmentFrame)
        val bottom_nav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottom_nav.setupWithNavController(navController)
    }


}