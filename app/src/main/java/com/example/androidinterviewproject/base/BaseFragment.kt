package com.example.androidinterviewproject.base

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import butterknife.ButterKnife
import com.example.androidinterviewproject.app.AndroidInterviewApplication
import com.example.androidinterviewproject.di.components.ApplicationComponent
import java.util.*

/*
Base Fragment for all Fragments
 */

abstract class BaseFragment : Fragment() {


    private var mProgressDialog: ProgressDialog? = null

    abstract fun getContentView(): Int


    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(getContentView(), container, false)
        ButterKnife.bind(this, view)
        onViewReadyFragment(savedInstanceState, view, Objects.requireNonNull<FragmentActivity>(activity).getIntent())
        return view
    }

    @CallSuper
    open protected fun onViewReadyFragment(savedInstanceState: Bundle?, view: View, intent: Intent) {
        resolveDaggerDependency()
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    protected fun getApplicationComponent(): ApplicationComponent {
        return (Objects.requireNonNull<FragmentActivity>(activity).application as AndroidInterviewApplication).getmApplicationComponent()
    }


    protected fun showDialog(message: String) {
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog(activity)
            mProgressDialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            mProgressDialog!!.setCancelable(false)
        }
        mProgressDialog!!.setMessage(message)
        mProgressDialog!!.show()
    }

    protected fun hideDialog() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.dismiss()
        }
    }

    open protected fun resolveDaggerDependency() {}

    protected fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}
