package com.example.androidinterviewproject.di.modules

import com.example.androidinterviewproject.di.scope.PerActivity
import com.example.androidinterviewproject.mvp.view.ViewPagerFragmentView
import dagger.Module
import dagger.Provides

@Module
open class ViewPagerFragmentsModule {
    internal var viewPagerFragmentView: ViewPagerFragmentView? = null

     constructor(viewPagerFragmentView: ViewPagerFragmentView) {
        this.viewPagerFragmentView = viewPagerFragmentView
    }

    @Provides
    @PerActivity
    fun providesExploreFragmentView(): ViewPagerFragmentView {
        return viewPagerFragmentView!!
    }
}