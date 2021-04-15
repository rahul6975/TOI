package com.rahul.toi.fragments.homeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rahul.toi.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)


    }
//
//        val fragmentList = arrayListOf<Fragment>(
//            home_Top_Fragment(),
//            home_TOI_Fragment(),
//            home_Video_Fragment(),
//            home_Photos_Fragment(),
//            home_Live_Tv_Fragment(),
//            home_assembly_election_Fragment(),
//            home_IPL_2021_Fragment(),
//            home_GadgetsNow_Fragment(),
//            home_trending_Fragment(),
//            home_latest_Fragment()
//        )
//
//
//        val adapter=ViewPagerAdapter(
//            fragmentList,requireActivity().supportFragmentManager,lifecycle
//        )
//
//        viewPager.adapter=adapter




    class ViewPagerAdapter(list: ArrayList<Fragment>, fm: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(fm, lifecycle) {

        private val fragmentList = list
        override fun getItemCount(): Int {


            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {

            return fragmentList[position]
        }
    }
}