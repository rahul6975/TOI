package com.rahul.toi.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rahul.toi.R
import com.rahul.toi.fragments.CityFragment

class HomeScreen : AppCompatActivity() {

    val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        setHomescreenFragment()
    }

    private fun setHomescreenFragment() {
        val transaction = fragmentManager.beginTransaction()
        val homescreenFragement = CityFragment()
        transaction.add(R.id.flHomescreen, homescreenFragement, "homescreen").commit()
    }
}