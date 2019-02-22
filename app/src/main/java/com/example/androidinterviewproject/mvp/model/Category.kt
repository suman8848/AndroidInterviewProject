package com.example.androidinterviewproject.mvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Category {

    @SerializedName("segmentID")
    @Expose
    private var segmentID: String? = null
    @SerializedName("segmentName")
    @Expose
    private var segmentName: String? = null

    fun getSegmentID(): String? {
        return segmentID
    }

    fun setSegmentID(segmentID: String) {
        this.segmentID = segmentID
    }

    fun getSegmentName(): String? {
        return segmentName
    }

    fun setSegmentName(segmentName: String) {
        this.segmentName = segmentName
    }
}