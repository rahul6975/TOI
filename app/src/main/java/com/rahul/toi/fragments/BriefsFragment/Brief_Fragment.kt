package com.rahul.toi.fragments.BriefsFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rahul.toi.R
import com.rahul.toi.adapters.BriefFragmentAdapter
import com.rahul.toi.adapters.HomeFragmentAdapter
import kotlinx.android.synthetic.main.fragment_brief_.*
import kotlinx.android.synthetic.main.fragment_home.*


class Brief_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_brief_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //

        viewPager_of_briefsFragment.adapter =
            BriefFragmentAdapter(childFragmentManager)
        tabLayout_briefFragment.setupWithViewPager(viewPager_of_briefsFragment)
    }


}