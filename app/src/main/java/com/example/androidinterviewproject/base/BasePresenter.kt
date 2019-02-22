package com.example.androidinterviewproject.base

import android.support.annotation.VisibleForTesting
import com.example.androidinterviewproject.mvp.view.BaseView
import javax.inject.Inject

/*
Base Presenter for all presenters
 */

open class BasePresenter<V : BaseView> {

    var mView: V? = null
        @Inject set

     protected fun getView(): V {
        return mView!!
    }

    @VisibleForTesting
    fun setView(exploreFragmentView: V) {
        this.mView = exploreFragmentView
    }

}