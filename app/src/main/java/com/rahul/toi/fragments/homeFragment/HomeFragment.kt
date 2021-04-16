package com.rahul.toi.fragments.homeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rahul.toi.R
import com.rahul.toi.adapters.HomeFragmentAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager_of_HomeFragment.adapter =
            HomeFragmentAdapter(requireActivity().supportFragmentManager)
        tabLayout_homeFragment.setupWithViewPager(viewPager_of_HomeFragment)
    }
}