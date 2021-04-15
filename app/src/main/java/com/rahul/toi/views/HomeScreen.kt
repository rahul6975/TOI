package com.rahul.toi.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.view.Menu
import android.view.MenuItem
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
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
import com.rahul.toi.fragments.Brief_Fragment
import com.rahul.toi.fragments.CityFragment
import com.rahul.toi.fragments.MyFeed_Fragment
import com.rahul.toi.fragments.TOI_PlusFragment.TOI_PlusFragment
import com.rahul.toi.fragments.homeFragment.HomeFragment
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.toolbar_layout.*


class HomeScreen : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)


        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.nav_view)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> Toast.makeText(
                    applicationContext,
                    "home clicked",
                    Toast.LENGTH_SHORT
                ).show()

            }
            true
        }

//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.homeFragment,
//                R.id.brief_Fragment,
//                R.id.cityFragment,
//                R.id.myFeed_Fragment,
//                R.id.TOI_PlusFragment
//            )
//        )

        setHomescreenFragment()
        init()
    }

    private fun init() {
        bottomNavigationView.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.cityFragmentNav -> {
                    val cityFragment = CityFragment()
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.flHomescreen, cityFragment, "cityFrag")
                        .addToBackStack("cityFrag")
                        .commit()
                    imgLogo.setImageResource(R.drawable.mumbai_city_logo)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.TOI_PlusFragmentNav -> {
                    val toiPlusfragment = TOI_PlusFragment()
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.flHomescreen, toiPlusfragment, "toi_plus")
                        .addToBackStack("toi_plus").commit()
                    imgLogo.setImageResource(R.drawable.ic_toi_plus_logo)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.brief_FragmentNav -> {
                    val brief_Fragment = Brief_Fragment()
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(
                        R.id.flHomescreen, brief_Fragment,
                        "brief"
                    ).addToBackStack("brief").commit()
                    imgLogo.setImageResource(R.drawable.briefs_logo)

                    return@setOnNavigationItemSelectedListener true
                }
                R.id.myFeed_FragmentNav -> {
                    val myfeedFragment = MyFeed_Fragment()
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(
                        R.id.flHomescreen,
                        myfeedFragment,
                        "myFeed"
                    ).addToBackStack("myFeed").commit()
                    imgLogo.setImageResource(R.drawable.my_feeds_logo)

                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
    }

    private fun setHomescreenFragment() {
        val transaction = fragmentManager.beginTransaction()
        val homescreenFragement = HomeFragment()
        transaction.add(R.id.flHomescreen, homescreenFragement, "homescreen")
            .addToBackStack("homeScreen").commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toobar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.toolBar_Notification -> Toast.makeText(
                this,
                "clicked on Notification",
                Toast.LENGTH_LONG
            ).show()
            R.id.toolbar_changeLanguage -> Toast.makeText(
                this,
                "clicked on changeLanguage",
                Toast.LENGTH_LONG
            ).show()
            R.id.toolbar_setting -> Toast.makeText(
                this,
                "clicked on Notification",
                Toast.LENGTH_LONG
            ).show()
            R.id.toolbar_search -> Toast.makeText(
                this,
                "clicked on Notification",
                Toast.LENGTH_LONG
            ).show()
        }
        return true
    }

}