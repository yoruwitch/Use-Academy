package com.example.toolbarandnav

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter (
    fragment: FragmentActivity
        ):FragmentStateAdapter(fragment) {

    //counting how many pages there are:::

    override fun getItemCount(): Int {
        return 2
    }

    //creating fragments to use:::

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                FirstPagerFragment()
            }
            else -> {
                SecondPagerFragment()
            }
        }
    }
}