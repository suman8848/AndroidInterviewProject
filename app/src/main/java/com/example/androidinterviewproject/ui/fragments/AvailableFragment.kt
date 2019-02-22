package com.example.androidinterviewproject.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.androidinterviewproject.R
import com.example.androidinterviewproject.base.BaseFragment
import com.example.androidinterviewproject.di.components.DaggerViewPagerFragmentComponents
import com.example.androidinterviewproject.di.modules.ViewPagerFragmentsModule
import com.example.androidinterviewproject.mvp.model.Coupon
import com.example.androidinterviewproject.mvp.model.ListOfCoupons
import com.example.androidinterviewproject.mvp.presenters.ViewPagerFragmentPresenter
import com.example.androidinterviewproject.mvp.view.ViewPagerFragmentView
import com.example.androidinterviewproject.ui.adapters.RecyclerViewAdapter
import com.google.gson.Gson
import java.io.IOException
import java.nio.charset.Charset
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


 class AvailableFragment : BaseFragment, ViewPagerFragmentView {

    var mRecyclerView: RecyclerView? = null
    private var adapter: RecyclerViewAdapter? = null
    private var totalCoupons: TextView? = null
    private var mListener: SendMessage? = null

     constructor(){}

     var availableViewFragment: ViewPagerFragmentPresenter? = null
         @Inject set

    override fun getContentView(): Int {
        return R.layout.available_fragment
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is SendMessage) {
            mListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement SendMessage Interface")
        }
    }

    override fun onViewReadyFragment(savedInstanceState: Bundle?, view: View, intent: Intent) {
        super.onViewReadyFragment(savedInstanceState, view, intent)
        totalCoupons = view.findViewById(R.id.total_coupons)
        mRecyclerView = view.findViewById(R.id.available_recycler)
        mRecyclerView!!.setHasFixedSize(true)
        mRecyclerView!!.setItemViewCacheSize(20)
        mRecyclerView!!.setLayoutManager(
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        )
       availableViewFragment!!.loadJSONFromAsset()
    }

    override fun onLoadDataSuccess(listOfCouponsPost: List<ListOfCoupons>) {
        val size = listOfCouponsPost!!.size


        var list: MutableList<ListOfCoupons>?= ArrayList<ListOfCoupons>() as MutableList<ListOfCoupons>?

        adapter = RecyclerViewAdapter(
            activity,
            "",
            listOfCouponsPost
        ) { item ->
            list!!.add(item)
            mListener!!.sendData(list)
        }
        mRecyclerView!!.setAdapter(adapter)
        mRecyclerView!!.setNestedScrollingEnabled(false)
        adapter!!.notifyDataSetChanged()
        totalCoupons!!.setText(getString(R.string.total, size))
    }

    internal interface SendMessage {
        fun sendData(listOfCoupons: MutableList<ListOfCoupons>)
        fun updateViewPager()
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }


    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun resolveDaggerDependency() {
        super.resolveDaggerDependency()
        DaggerViewPagerFragmentComponents.builder()
            .applicationComponent(getApplicationComponent())
            .viewPagerFragmentsModule(ViewPagerFragmentsModule(this))
            .build()
            .inject(this)
    }

}