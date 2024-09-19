package com.example.roomdatabaseemployee.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class Users(
    val `data`: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)