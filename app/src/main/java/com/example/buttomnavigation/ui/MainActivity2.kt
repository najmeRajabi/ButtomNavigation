package com.example.buttomnavigation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.buttomnavigation.R
import me.relex.circleindicator.CircleIndicator3


private const val NUM_PAGES = 3

class MainActivity2 : AppCompatActivity()  {

    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        viewPager = findViewById(R.id.viewPager)

        // The pager adapter, which provides the pages to the view pager widget.
        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewPager.adapter = pagerAdapter

        val indicator: CircleIndicator3 =findViewById(R.id.indicator)
        indicator.setViewPager(viewPager)

//        viewPager.registerAdapterDataObserver(indicator.adapterDataObserver)
    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> ListFragment()
                1 -> secondeFragment()
                2 -> ThiredFragment()
                else -> ListFragment()
            }

        }
    }
}