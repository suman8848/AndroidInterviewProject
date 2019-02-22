package com.example.androidinterviewproject.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.androidinterviewproject.R
import com.example.androidinterviewproject.base.BaseFragment
import com.example.androidinterviewproject.ui.adapters.RecyclerViewAdapter
import android.R.attr.key
import android.content.Context
import com.example.androidinterviewproject.mvp.model.ListOfCoupons


class ClippedFragment : BaseFragment, AvailableFragment.SendMessage {


    var mRecyclerView: RecyclerView? = null
    private var adapter: RecyclerViewAdapter? = null
    private var totalCoupons: TextView? = null

    private var mListener: AvailableFragment.SendMessage? = null

    constructor() {}

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is AvailableFragment.SendMessage) {
            mListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement SendMessage Interface")
        }
    }

    override fun sendData(listOfCoupons: MutableList<ListOfCoupons>) {
        adapter = RecyclerViewAdapter(
            activity,
            "Unclip",
            listOfCoupons
        ) { item ->
            listOfCoupons.remove(item)
            updateViewPager()
            mRecyclerView!!.setAdapter(adapter)
            if(listOfCoupons.size!=0) {
                totalCoupons!!.setText(getString(R.string.total, listOfCoupons.size))
            }else {
                totalCoupons!!.setText(getString(R.string.total_string))
            }
        }
        mRecyclerView!!.setAdapter(adapter)
        mRecyclerView!!.setNestedScrollingEnabled(false)
        adapter!!.notifyDataSetChanged()
        totalCoupons!!.setText(getString(R.string.total, listOfCoupons.size))

    }

    override fun updateViewPager() {
        mListener!!.updateViewPager()
    }

    override fun getContentView(): Int {
        return R.layout.available_fragment
    }

    override fun onViewReadyFragment(savedInstanceState: Bundle?, view: View, intent: Intent) {
        super.onViewReadyFragment(savedInstanceState, view, intent)
        totalCoupons = view.findViewById(R.id.total_coupons);
        mRecyclerView = view.findViewById(R.id.available_recycler);
        mRecyclerView!!.setHasFixedSize(true)
        mRecyclerView!!.setItemViewCacheSize(20)
        mRecyclerView!!.setLayoutManager(
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        )

    }


}
