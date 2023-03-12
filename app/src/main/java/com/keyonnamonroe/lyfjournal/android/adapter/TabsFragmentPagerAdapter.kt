package com.keyonnamonroe.lyfjournal.android.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Constructor
 *
 * @property fragments List<Fragment> List of fragments.
 * @param fragment Base class for activities that want to use the support-based Fragments.
 * @constructor
 */
class TabsFragmentPagerAdapter(
    fragment: FragmentActivity,
    private val fragments: List<Fragment> = mutableListOf()
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}
