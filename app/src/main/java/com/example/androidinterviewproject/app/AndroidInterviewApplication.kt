package com.example.androidinterviewproject.app

import android.app.Application
import com.example.androidinterviewproject.di.components.ApplicationComponent
import com.example.androidinterviewproject.di.components.DaggerApplicationComponent
import com.example.androidinterviewproject.di.modules.ApplicationModule

/*
Application class for application scope
 */
class AndroidInterviewApplication : Application() {

    private var mApplicationComponent: ApplicationComponent? = null
    override fun onCreate() {
        super.onCreate()
        initializeApplicationComponent()
    }

    private fun initializeApplicationComponent() {

        mApplicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    fun getmApplicationComponent(): ApplicationComponent {
        return mApplicationComponent!!
    }


}