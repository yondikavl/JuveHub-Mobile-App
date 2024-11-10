package com.yondikavl.juvehub_mobile_app

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
