package com.rahul.toi.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rahul.toi.fragments.SavedStories_Photos_Fragment
import com.rahul.toi.fragments.SavedStories_newsFragment

class SavedStoriesAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {

        when (position) {
            0 -> {
                return SavedStories_newsFragment()
            }
            1 -> {
                return SavedStories_Photos_Fragment()
            }
            else -> {
                return SavedStories_newsFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position)
        {
            0->{
                return "NEWS"
            }
            1->{
                return "PHOTOS"
            }
        }
        return super.getPageTitle(position)
    }

    override fun getCount(): Int {
        return 2
    }
}