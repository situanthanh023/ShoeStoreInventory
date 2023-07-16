package com.example.android.shoestoreinventory.model

import android.os.Parcel
import android.os.Parcelable

data class Shoe(val id: String?, val name: String?, val size: Int, val count: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeInt(size)
        parcel.writeInt(count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Shoe> {
        override fun createFromParcel(parcel: Parcel): Shoe {
            return Shoe(parcel)
        }

        override fun newArray(size: Int): Array<Shoe?> {
            return arrayOfNulls(size)
        }
    }
}
