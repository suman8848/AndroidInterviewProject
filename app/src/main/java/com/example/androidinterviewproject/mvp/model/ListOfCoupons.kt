package com.example.androidinterviewproject.mvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ListOfCoupons {
    @SerializedName("isSuggested")
    @Expose
    private var isSuggested: Boolean? = null
    @SerializedName("isClipped")
    @Expose
    private var isClipped: Boolean? = null
    @SerializedName("isAutoClipped")
    @Expose
    private var isAutoClipped: Boolean? = null
    @SerializedName("isHidden")
    @Expose
    private var isHidden: Boolean? = null
    @SerializedName("couponInclusionGroupTag")
    @Expose
    private var couponInclusionGroupTag: String? = null
    @SerializedName("couponExpirationGroupTag")
    @Expose
    private var couponExpirationGroupTag: String? = null
    @SerializedName("isSpecialOffer")
    @Expose
    private var isSpecialOffer: Boolean? = null
    @SerializedName("redemptionDate")
    @Expose
    private var redemptionDate: Any? = null
    @SerializedName("meijerOfferId")
    @Expose
    private var meijerOfferId: Int? = null
    @SerializedName("title")
    @Expose
    private var title: String? = null
    @SerializedName("description")
    @Expose
    private var description: String? = null
    @SerializedName("category")
    @Expose
    private var category: Category? = null
    @SerializedName("tags")
    @Expose
    private var tags: List<String>? = null
    @SerializedName("hatText")
    @Expose
    private var hatText: Any? = null
    @SerializedName("hatColor")
    @Expose
    private var hatColor: Int? = null
    @SerializedName("borderColor")
    @Expose
    private var borderColor: Int? = null
    @SerializedName("isMeijerBuck")
    @Expose
    private var isMeijerBuck: Boolean? = null
    @SerializedName("showLargeImage")
    @Expose
    private var showLargeImage: Boolean? = null
    @SerializedName("imageURL")
    @Expose
    private var imageURL: String? = null
    @SerializedName("largeImageURL")
    @Expose
    private var largeImageURL: String? = null
    @SerializedName("termsAndConditions")
    @Expose
    private var termsAndConditions: String? = null
    @SerializedName("redemptionStartDate")
    @Expose
    private var redemptionStartDate: String? = null
    @SerializedName("redemptionEndDate")
    @Expose
    private var redemptionEndDate: String? = null
    @SerializedName("manufacturerCoupon")
    @Expose
    private var manufacturerCoupon: Boolean? = null
    @SerializedName("offerClassId")
    @Expose
    private var offerClassId: Int? = null
    @SerializedName("rewardProgramId")
    @Expose
    private var rewardProgramId: Int? = null

    fun getIsSuggested(): Boolean? {
        return isSuggested
    }

    fun setIsSuggested(isSuggested: Boolean?) {
        this.isSuggested = isSuggested
    }

    fun getIsClipped(): Boolean? {
        return isClipped
    }

    fun setIsClipped(isClipped: Boolean?) {
        this.isClipped = isClipped
    }

    fun getIsAutoClipped(): Boolean? {
        return isAutoClipped
    }

    fun setIsAutoClipped(isAutoClipped: Boolean?) {
        this.isAutoClipped = isAutoClipped
    }

    fun getIsHidden(): Boolean? {
        return isHidden
    }

    fun setIsHidden(isHidden: Boolean?) {
        this.isHidden = isHidden
    }

    fun getCouponInclusionGroupTag(): String? {
        return couponInclusionGroupTag
    }

    fun setCouponInclusionGroupTag(couponInclusionGroupTag: String) {
        this.couponInclusionGroupTag = couponInclusionGroupTag
    }

    fun getCouponExpirationGroupTag(): String? {
        return couponExpirationGroupTag
    }

    fun setCouponExpirationGroupTag(couponExpirationGroupTag: String) {
        this.couponExpirationGroupTag = couponExpirationGroupTag
    }

    fun getIsSpecialOffer(): Boolean? {
        return isSpecialOffer
    }

    fun setIsSpecialOffer(isSpecialOffer: Boolean?) {
        this.isSpecialOffer = isSpecialOffer
    }

    fun getRedemptionDate(): Any? {
        return redemptionDate
    }

    fun setRedemptionDate(redemptionDate: Any) {
        this.redemptionDate = redemptionDate
    }

    fun getMeijerOfferId(): Int? {
        return meijerOfferId
    }

    fun setMeijerOfferId(meijerOfferId: Int?) {
        this.meijerOfferId = meijerOfferId
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String) {
        this.description = description
    }

    fun getCategory(): Category? {
        return category
    }

    fun setCategory(category: Category) {
        this.category = category
    }

    fun getTags(): List<String>? {
        return tags
    }

    fun setTags(tags: List<String>) {
        this.tags = tags
    }

    fun getHatText(): Any? {
        return hatText
    }

    fun setHatText(hatText: Any) {
        this.hatText = hatText
    }

    fun getHatColor(): Int? {
        return hatColor
    }

    fun setHatColor(hatColor: Int?) {
        this.hatColor = hatColor
    }

    fun getBorderColor(): Int? {
        return borderColor
    }

    fun setBorderColor(borderColor: Int?) {
        this.borderColor = borderColor
    }

    fun getIsMeijerBuck(): Boolean? {
        return isMeijerBuck
    }

    fun setIsMeijerBuck(isMeijerBuck: Boolean?) {
        this.isMeijerBuck = isMeijerBuck
    }

    fun getShowLargeImage(): Boolean? {
        return showLargeImage
    }

    fun setShowLargeImage(showLargeImage: Boolean?) {
        this.showLargeImage = showLargeImage
    }

    fun getImageURL(): String? {
        return imageURL
    }

    fun setImageURL(imageURL: String) {
        this.imageURL = imageURL
    }

    fun getLargeImageURL(): String? {
        return largeImageURL
    }

    fun setLargeImageURL(largeImageURL: String) {
        this.largeImageURL = largeImageURL
    }

    fun getTermsAndConditions(): String? {
        return termsAndConditions
    }

    fun setTermsAndConditions(termsAndConditions: String) {
        this.termsAndConditions = termsAndConditions
    }

    fun getRedemptionStartDate(): String? {
        return redemptionStartDate
    }

    fun setRedemptionStartDate(redemptionStartDate: String) {
        this.redemptionStartDate = redemptionStartDate
    }

    fun getRedemptionEndDate(): String? {
        return redemptionEndDate
    }

    fun setRedemptionEndDate(redemptionEndDate: String) {
        this.redemptionEndDate = redemptionEndDate
    }

    fun getManufacturerCoupon(): Boolean? {
        return manufacturerCoupon
    }

    fun setManufacturerCoupon(manufacturerCoupon: Boolean?) {
        this.manufacturerCoupon = manufacturerCoupon
    }

    fun getOfferClassId(): Int? {
        return offerClassId
    }

    fun setOfferClassId(offerClassId: Int?) {
        this.offerClassId = offerClassId
    }

    fun getRewardProgramId(): Int? {
        return rewardProgramId
    }

    fun setRewardProgramId(rewardProgramId: Int?) {
        this.rewardProgramId = rewardProgramId
    }
}