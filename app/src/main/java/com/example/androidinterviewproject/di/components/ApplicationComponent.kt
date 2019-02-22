package com.example.androidinterviewproject.di.components

import android.content.Context
import com.example.androidinterviewproject.di.modules.ApplicationModule
import dagger.Component
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    @NotNull
    fun exposeContext(): Context?=null
}