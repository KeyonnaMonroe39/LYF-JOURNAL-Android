package com.keyonnamonroe.lyfjournal.android.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.keyonnamonroe.lyfjournal.android.adapter.TabsFragmentPagerAdapter
import com.keyonnamonroe.lyfjournal.android.databinding.ActivityMainBinding
import com.keyonnamonroe.lyfjournal.android.fragment.BlogFragment
import com.keyonnamonroe.lyfjournal.android.fragment.HomeFragment
import com.keyonnamonroe.lyfjournal.android.fragment.ListenFragment
import com.keyonnamonroe.lyfjournal.android.fragment.SocialMediaFragment

// Youtube API KEY (KEYONNA) - AIzaSyDuFrELpJ2AiU73kZNEVsoKNOTFhqsqTyU
// Youtube User Id (KEYONNA)- 3VhbXYj81DZyXcWlj0vBvg
// YouTube Channel Id (KEYONNA)- UC3VhbXYj81DZyXcWlj0vBvg
//
// Notes
// 1. No expiry on videos. Display everything
// 2. Add Lyf Tip section
//
// Youtube Jar - Android
// Ref- https://developers.google.com/youtube/android/player/downloads/
//
// Youtube Player- Android
// Ref (official)- https://developers.google.com/youtube/android/player
// Ref- https://blog.kotlin-academy.com/building-a-youtube-player-using-kotlin-b0e4beef302a
// Ref- https://johncodeos.com/how-to-embed-youtube-videos-into-your-android-app-using-kotlin/
class MainActivity : BaseActivity() {

    // view binding and layout widgets
    // this property is only valid between onCreateView and onDestroyView
    private lateinit var binding: ActivityMainBinding

    // pageChangeCallback
    private var onPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            // select tab
            selectTab(position)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }

        // initialize views and handlers
        initializeViews()
        initializeHandlers()
        initializeListeners()
    }

    /**
     * Method is used to initialize views.
     */
    private fun initializeViews() {
        // instantiate views
        // enable or disable user initiated scrolling. This includes touch input
        // (scroll and fling gestures) and accessibility input
        binding.vpFragment.isUserInputEnabled = false

        // set view pager
        setupViewPager()
    }

    /**
     * Method is used to initialize click listeners.
     */
    private fun initializeHandlers() {

    }

    /**
     * Method is used to initialize listeners and callbacks.
     */
    private fun initializeListeners() {
        // OnTabSelectedListener
        binding.tabParent.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                // select tab
                selectTab(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                // do nothing
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // do nothing
            }
        })
        // OnPageChangeListener
        binding.vpFragment.registerOnPageChangeCallback(onPageChangeCallback)
    }

    /**
     * Method is used to change tabs.
     *
     * @param position The position of the tab to change to.
     */
    private fun selectTab(position: Int) {
        binding.tabParent.setScrollPosition(position, 0f, true)
        binding.vpFragment.setCurrentItem(position, true)
    }

    /**
     * Method is used to setup view pager.
     */
    private fun setupViewPager() {
        // populate list of fragments that make up the tabs
        val tabs = listOf<Fragment>(
            HomeFragment(),
            ListenFragment(),
            BlogFragment(),
            SocialMediaFragment()
        )

        // instantiate pager adapter
        val tabsFragmentPagerAdapter = TabsFragmentPagerAdapter(this, tabs)
        // set view pager
        binding.vpFragment.adapter = tabsFragmentPagerAdapter
    }


}
