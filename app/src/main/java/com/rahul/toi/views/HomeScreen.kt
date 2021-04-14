package com.rahul.toi.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.rahul.toi.R
import com.rahul.toi.fragments.CityFragment
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.toolbar_layout.*


class HomeScreen : AppCompatActivity() {

    val fragmentManager = supportFragmentManager
//
//    private lateinit var navController: NavController
//
//    private lateinit var drawerLayout: DrawerLayout
//
//    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        setHomescreenFragment()
    }

    private fun setHomescreenFragment() {
        val transaction = fragmentManager.beginTransaction()
        val homescreenFragement = CityFragment()
        transaction.add(R.id.flHomescreen, homescreenFragement, "homescreen").commit()
//        setSupportActionBar(toolbar)
//        navController = findNavController(R.id.navHostFragmentContainer)
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.homeFragment,
//                R.id.brief_Fragment,
//                R.id.cityFragment,
//                R.id.myFeed_Fragment,
//                R.id.TOI_PlusFragment
//            )
//        )

//        bottomNavigationView.setupWithNavController(navController)
//        setupActionBarWithNavController(navController, appBarConfiguration)

    }

//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }
//
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//
//        menuInflater.inflate(R.menu.toobar_menu, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        when (item.itemId) {
//            R.id.toolBar_Notification -> Toast.makeText(
//                this,
//                "clicked on Notification",
//                Toast.LENGTH_LONG
//            ).show()
//            R.id.toolbar_changeLanguage -> Toast.makeText(
//                this,
//                "clicked on changeLanguage",
//                Toast.LENGTH_LONG
//            ).show()
//            R.id.toolbar_setting -> Toast.makeText(
//                this,
//                "clicked on Notification",
//                Toast.LENGTH_LONG
//            ).show()
//            R.id.toolbar_search -> Toast.makeText(
//                this,
//                "clicked on Notification",
//                Toast.LENGTH_LONG
//            ).show()
//
//        }
//
//        return true
//    }


}