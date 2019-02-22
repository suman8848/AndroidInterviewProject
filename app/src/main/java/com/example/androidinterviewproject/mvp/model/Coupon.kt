package com.example.androidinterviewproject.mvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Coupon {
    @SerializedName("couponCount")
    @Expose
     var couponCount: String? = null

    @SerializedName("availableCouponCount")
    @Expose
     var availableCouponCount: String? = null

    @SerializedName("listOfCoupons")
    @Expose
    var content: List<ListOfCoupons>? = null

    @SerializedName("responseCode")
    @Expose
    private var responseCode: String? = null

    @SerializedName("responseMessage")
    @Expose
    private var responseMessage: String? = null

    @SerializedName("hasSpecialOffers")
    @Expose
    private var hasSpecialOffers: String? = null

}