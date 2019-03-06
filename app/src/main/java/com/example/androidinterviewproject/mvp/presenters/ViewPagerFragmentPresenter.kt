package com.example.androidinterviewproject.mvp.presenters

import android.content.Context
import android.support.v4.app.FragmentActivity
import com.example.androidinterviewproject.R
import com.example.androidinterviewproject.base.BasePresenter
import com.example.androidinterviewproject.mvp.model.Coupon
import com.example.androidinterviewproject.mvp.model.ListOfCoupons
import com.example.androidinterviewproject.mvp.view.ViewPagerFragmentView
import com.example.androidinterviewproject.ui.adapters.RecyclerViewAdapter
import com.example.androidinterviewproject.ui.fragments.AvailableFragment
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import java.util.*
import javax.inject.Inject

class ViewPagerFragmentPresenter @Inject constructor(context: Context?) : BasePresenter<ViewPagerFragmentView>() {

    var context: Context? = context

    open fun loadJSONFromAsset() {
        var json: String? = null
        try {
            val inputStream = context!!.assets.open("coupon.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val charset: Charset = Charsets.UTF_8
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()

        }
        var posts: List<Coupon>
        posts = Arrays.asList(Gson().fromJson(json, Coupon::class.java)).toList()
        getView().onLoadDataSuccess(posts.get(0).content!!)
    }

}