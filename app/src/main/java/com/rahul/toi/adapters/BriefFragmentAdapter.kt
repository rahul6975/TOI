package com.rahul.toi.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rahul.toi.fragments.BriefsFragment.*
import com.rahul.toi.fragments.homeFragment.*

class BriefFragmentAdapter(supportFragmentAdapter: FragmentManager):FragmentPagerAdapter(
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
            4 -> {
                brief__tv_Fragmnet()
            }
            5 -> {
                brief_lifestyle_Fragment()
            }
            6 -> {
                brief_gadgets_Fragment()
            }
            7 -> {
                brief_world_Fragment()
            }
            8 -> {
                brief_business_Fragment()
            }
            else -> {
                brief_Featured_Fragment()
            }
        }







    }

    override fun getPageTitle(position: Int): CharSequence? {

        when(position){
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
            4 -> {
                return "TV"
            }
            5 -> {
                return "LIFESTYLE"
            }
            6 -> {
                return "GADGETS"
            }
            7 -> {
                return "WORLD"
            }
            8 -> {
                return "BUSINESS"
            }

        }
        return super.getPageTitle(position)
    }

    override fun getCount(): Int {
        return 9


    }
}