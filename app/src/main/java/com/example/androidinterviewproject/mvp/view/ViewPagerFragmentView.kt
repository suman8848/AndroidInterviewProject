package com.example.androidinterviewproject.mvp.view

import com.example.androidinterviewproject.mvp.model.ListOfCoupons

/*
View for Fragments
 */
interface ViewPagerFragmentView : BaseView {
    fun onLoadDataSuccess(listOfCouponsPost:List<ListOfCoupons>)
}