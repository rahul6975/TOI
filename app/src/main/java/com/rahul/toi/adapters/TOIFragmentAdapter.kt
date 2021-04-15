package com.rahul.toi.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rahul.toi.fragments.TOI_PlusFragment.TOI_All_TOI_Fragment
import com.rahul.toi.fragments.TOI_PlusFragment.TOI_MostSharedFragment
import com.rahul.toi.fragments.TOI_PlusFragment.TOI_Most_CommentedFragment
import com.rahul.toi.fragments.TOI_PlusFragment.TOI_Most_ReadFragment

class TOIFragmentAdapter(supportFragmentAdapter: FragmentManager):FragmentPagerAdapter(  supportFragmentAdapter,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {

        return when(position){
            0->{
                TOI_All_TOI_Fragment()
            }
            1->{
                TOI_Most_CommentedFragment()
            }
            2->{
                TOI_Most_ReadFragment()
            }
            3->{
                TOI_MostSharedFragment()
            }else->{
                TOI_All_TOI_Fragment()
            }
        }


    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position)
        {
            0->{
                return "ALL TOI+ STORIES"
            }
            1->{
                return "MOST COMMENTED"
            }
            2->{

                return "MOST READ"
            }
            3->{
                return "MOST SHARED"
            }
        }
        return super.getPageTitle(position)
    }

    override fun getCount(): Int {
        return 4
    }


}