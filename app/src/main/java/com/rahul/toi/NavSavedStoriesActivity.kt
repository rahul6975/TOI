package com.rahul.toi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rahul.toi.adapters.SavedStoriesAdapter
import kotlinx.android.synthetic.main.activity_nav__saved_stories_.*
import kotlinx.android.synthetic.main.fragment_home.*

class NavSavedStoriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav__saved_stories_)

        viewPager_of_SaveStories.adapter = SavedStoriesAdapter(supportFragmentManager)
        tabLayout2.setupWithViewPager(viewPager_of_SaveStories)

    }
}