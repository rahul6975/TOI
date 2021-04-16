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
                home_IPL_2021_Fragment()
            }
            3 -> {
                home_GadgetsNow_Fragment()
            }
            4 -> {
                home_trending_Fragment()
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
                return "COVID-19"
            }
            2 -> {
                return "IPL 2021"
            }
            3 -> {
                return "TECHNOLOGY"
            }
            4 -> {
                return "ENTERTAINMENT"
            }
        }
        return super.getPageTitle(position)
    }

    override fun getCount(): Int {
        return 5;
    }
}

