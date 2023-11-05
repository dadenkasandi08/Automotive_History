package com.kasandi.myappsubmission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Brand(
    val name:String?,
    val history: String?,
    val year:String?,
    val founder: String?,
    val owner: String?,
    val photo: String?
):Parcelable
