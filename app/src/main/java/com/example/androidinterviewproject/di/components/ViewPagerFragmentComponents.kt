package com.example.androidinterviewproject.di.components

import com.example.androidinterviewproject.di.modules.ViewPagerFragmentsModule
import com.example.androidinterviewproject.di.scope.PerActivity
import com.example.androidinterviewproject.ui.fragments.AvailableFragment
import com.example.androidinterviewproject.ui.fragments.ClippedFragment
import dagger.Component


/*
components helps to satisfy the objects required for class to with help of inject method
 */
@PerActivity
@Component(modules = [ViewPagerFragmentsModule::class], dependencies = [ApplicationComponent::class])
open interface ViewPagerFragmentComponents {
    fun inject(availableFragment: AvailableFragment)
}