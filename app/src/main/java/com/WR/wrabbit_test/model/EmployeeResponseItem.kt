package com.WR.wrabbit_test.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "employee"
)
data class EmployeeResponseItem(
    @PrimaryKey()
    var id: Int? = null,
    val email: String?,
    val name: String?,
    val phone: String?,
    val profile_image: String?,
    val username: String?,
    val website: String?,
//    val company: Company,
//    val address: Address,
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<EmployeeResponseItem> {
        override fun createFromParcel(parcel: Parcel): EmployeeResponseItem {
            return EmployeeResponseItem(parcel)
        }

        override fun newArray(size: Int): Array<EmployeeResponseItem?> {
            return arrayOfNulls(size)
        }
    }
}