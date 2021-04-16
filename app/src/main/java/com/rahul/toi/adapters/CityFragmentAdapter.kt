package com.rahul.toi.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rahul.toi.fragments.cityFragment.*
import com.rahul.toi.fragments.homeFragment.*

class CityFragmentAdapter(supportFragmentAdapter: FragmentManager) : FragmentPagerAdapter(

    supportFragmentAdapter,
    FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> {
                city_Mumbai_Fragment()
            }
            1 -> {
                city_Kolkate_Fragment()
            }
            2 -> {
                city_Delhi_Fragment()
            }
            3 -> {
                city_Chennai_Fragment()
            }
            4 -> {
                city_bangalore_Fragment()
            }
            else -> {
                city_Mumbai_Fragment()
            }
        }

    }

    override fun getCount(): Int {
        return 5
    }

    override fun getPageTitle(position: Int): CharSequence? {

        when (position) {
            0 -> {
                return "Mumbai"
            }
            1 -> {
                return "Kolkata"
            }
            2 -> {
                return "Delhi"
            }
            3 -> {
                return "Chennai"
            }
            4 -> {
                return "Bangalore"
            }


        }

        return super.getPageTitle(position)
    }
}