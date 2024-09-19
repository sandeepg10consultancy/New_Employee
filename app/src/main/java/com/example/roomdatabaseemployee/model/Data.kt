package com.example.roomdatabaseemployee.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    val avatar: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString()
    ) {
    }

    companion object : Parceler<Data> {

        override fun Data.write(parcel: Parcel, flags: Int) {
            parcel.writeString(avatar)
            parcel.writeString(email)
            parcel.writeString(first_name)
            parcel.writeInt(id)
            parcel.writeString(last_name)
        }

        override fun create(parcel: Parcel): Data {
            return Data(parcel)
        }
    }
}