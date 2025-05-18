package com.example.recyclerviewexchangerate.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExchangeRate(
    val flag: Int,
    val country: String,
    val buy: String,
    val sell: String
): Parcelable
