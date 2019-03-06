package com.example.androidinterviewproject.ui.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import com.example.androidinterviewproject.R
import com.example.androidinterviewproject.base.BaseActivity
import com.example.androidinterviewproject.mvp.model.ListOfCoupons
import com.example.androidinterviewproject.ui.fragments.AvailableFragment
import com.example.androidinterviewproject.ui.fragments.ClippedFragment
import java.util.*


class MainActivity : BaseActivity(), AvailableFragment.SendMessage {
    override fun updateViewPager() {
        viewPager?.setCurrentItem(0);
    }

    private var myPagerAdapter: ViewPagerAdapter? = null
    var viewPager: ViewPager? = null
    override fun sendData(listOfCoupons: MutableList<ListOfCoupons>) {
        myPagerAdapter?.sendData(listOfCoupons)
        viewPager?.setCurrentItem(1)
    }


    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onViewReady(savedInstanceState: Bundle?, intent: Intent) {
        setToolbar()
        Objects.requireNonNull(supportActionBar)!!.setTitle("Coupons")
//         attach swipe views as fragment

        viewPager = findViewById(R.id.pager)
        myPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        myPagerAdapter?.addFragment(AvailableFragment(), "AVAILABLE")
        myPagerAdapter?.addFragment(ClippedFragment(), "CLIPPED")
        viewPager?.setAdapter(myPagerAdapter)
        viewPager?.setCurrentItem(0)

        val tabLayout: TabLayout = findViewById(R.id.tabs)
        tabLayout.setupWithViewPager(viewPager)
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager),
        AvailableFragment.SendMessage {


        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun sendData(listOfCoupons: MutableList<ListOfCoupons>) {
            val fragment = mFragmentList[1] as ClippedFragment
            fragment?.sendData(listOfCoupons)
        }

        override fun updateViewPager() {
        }

        override fun getItem(position: Int): Fragment {

            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }
    }


}