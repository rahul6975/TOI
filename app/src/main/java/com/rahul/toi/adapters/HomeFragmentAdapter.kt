package com.rahul.toi.adapters

import android.icu.text.CaseMap
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HomeFragmentAdapter(supportFragmentAdapter: FragmentManager):FragmentPagerAdapter(supportFragmentAdapter,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val mFragment= ArrayList<Fragment>()
    private val mFragmentTitle=ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return mFragment[position]


    }

    override fun getCount(): Int {
        return mFragment.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitle[position]
    }

    fun addFragment(fragment: Fragment,title:String)
    {
        mFragment.add(fragment)
        mFragmentTitle.add(title)


    }
}

