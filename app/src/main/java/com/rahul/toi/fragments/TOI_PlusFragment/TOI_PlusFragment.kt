package com.rahul.toi.fragments.TOI_PlusFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rahul.toi.R
import com.rahul.toi.adapters.HomeFragmentAdapter
import com.rahul.toi.adapters.TOIFragmentAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_t_o_i__plus.*


class TOI_PlusFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_t_o_i__plus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager_of_TOI_PLUS_Fragment.adapter =
            TOIFragmentAdapter(requireActivity().supportFragmentManager)
        tabLayout_TOI_PLUS_Fragment.setupWithViewPager(viewPager_of_TOI_PLUS_Fragment)
    }


}