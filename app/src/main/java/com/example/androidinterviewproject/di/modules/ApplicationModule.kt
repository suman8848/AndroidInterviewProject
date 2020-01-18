package com.example.androidinterviewproject.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton

/*
Modules contains objects
 */
@Module
open class ApplicationModule {
    private var mContext: Context? = null

    constructor(context: Context) {
        this.mContext = context
    }


    @Provides
    @Singleton
    internal fun provideContext(): Context? {
        return mContext
    }
}