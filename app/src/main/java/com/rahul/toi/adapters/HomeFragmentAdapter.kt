package com.rahul.toi.adapters

import android.icu.text.CaseMap
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rahul.toi.fragments.homeFragment.*

class HomeFragmentAdapter(supportFragmentAdapter: FragmentManager) : FragmentPagerAdapter(
    supportFragmentAdapter,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {




    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                home_Top_Fragment()
            }
            1 -> {
                home_TOI_Fragment()
            }
            2 -> {
                home_Video_Fragment()
            }
            3 -> {
                home_Photos_Fragment()
            }
            4 -> {
                home_Live_Tv_Fragment()
            }
            5 -> {
                home_assembly_election_Fragment()
            }
            6 -> {
                home_IPL_2021_Fragment()
            }
            7 -> {
                home_GadgetsNow_Fragment()
            }
            8 -> {
                home_trending_Fragment()
            }
            9 -> {
                home_latest_Fragment()
            }
            else -> {
                home_Top_Fragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return "TOP"
            }
            1 -> {
                return "TOI+"
            }
            2 -> {
                return "VIDEOS"
            }
            3 -> {
                return "PHOTOS"
            }
            4 -> {
                return "LIVE TV"
            }
            5 -> {
                return "ASSEMBLY ELECTION"
            }
            6 -> {
                return "IPL 2021"
            }
            7 -> {
                return "GADGETSNOW"
            }
            8 -> {
                return "TRENDING"
            }
            9 -> {
                return "LATEST"
            }
        }
        return super.getPageTitle(position)
    }

    override fun getCount(): Int {
        return 9;
    }


}

