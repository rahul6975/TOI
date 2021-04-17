package com.rahul.toi.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rahul.toi.fragments.BriefsFragment.*
import com.rahul.toi.fragments.homeFragment.*

class BriefFragmentAdapter(supportFragmentAdapter: FragmentManager) : FragmentPagerAdapter(
    supportFragmentAdapter,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> {
                brief_Featured_Fragment()
            }
            1 -> {
                brief_India_Fragment()
            }
            2 -> {
                brief_sports_Fragment()
            }
            3 -> {
                brief_entertainment_Fragment()
            }
            else -> {
                brief_Featured_Fragment()
            }
        }


    }

    override fun getPageTitle(position: Int): CharSequence? {

        when (position) {
            0 -> {
                return "FEATURED"
            }
            1 -> {
                return "INDIA"
            }
            2 -> {
                return "SPORTS"
            }
            3 -> {
                return "ENTERTAINMENT"
            }
        }
        return super.getPageTitle(position)
    }

    override fun getCount(): Int {
        return 4


    }
}