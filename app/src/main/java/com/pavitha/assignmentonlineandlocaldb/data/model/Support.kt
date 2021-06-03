package com.pavitha.assignmentonlineandlocaldb.data.model


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

data class Support(
    @SerializedName("text")
    val text: String,
    @SerializedName("url")
    val url: String
)