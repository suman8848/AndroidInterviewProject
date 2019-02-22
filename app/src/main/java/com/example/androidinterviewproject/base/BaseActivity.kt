package com.example.androidinterviewproject.base

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.annotation.RequiresApi
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife
import com.example.androidinterviewproject.R
import java.util.*


/*
Base Activity for all activities
 */
abstract class BaseActivity : AppCompatActivity() {

    @Nullable
    @BindView(R.id.toolbar)
    lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        ButterKnife.bind(this)
        onViewReady(savedInstanceState, getIntent())
    }

    open protected fun onViewReady(savedInstanceState: Bundle?, intent: Intent) {
        resolveDaggerDependency()
    }

    protected override fun onDestroy() {
        super.onDestroy()
    }

    open protected fun resolveDaggerDependency() {}

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    protected fun setToolbar() {
        setSupportActionBar(mToolbar)
        Objects.requireNonNull<ActionBar>(supportActionBar).setDisplayHomeAsUpEnabled(false)
        mToolbar.setNavigationIcon(R.drawable.ic_hame_icon)

    }


    protected abstract fun getContentView(): Int

}
