package com.WR.wrabbit_test.db

import androidx.room.TypeConverter
import com.WR.wrabbit_test.model.Address
import com.WR.wrabbit_test.model.Company
import com.WR.wrabbit_test.model.EmployeeResponseItem

class Converters {

    @TypeConverter
    fun fromSource(source: Company):String{

        return source.name
    }

    @TypeConverter
    fun toSource(name:String,id :Int): Company {
        return Company(name,name,name)
    }
}