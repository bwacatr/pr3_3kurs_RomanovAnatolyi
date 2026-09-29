package com.bignerdranch.android.prakt17_3_romanov

import androidx.room.TypeConverter
import java.util.Date
import java.util.UUID

class CrimeTypeConverters {
    @TypeConverter
    fun fromDate(date: Date?): Long? = date?.time

    @TypeConverter
    fun toDate(millisSinceEpoch: Long?): Date? =
        millisSinceEpoch?.let { Date(it) }


    @TypeConverter
    fun fromUUID(uuid: UUID?): String? = uuid?.toString()

    @TypeConverter
    fun toUUID(value: String?): UUID? =
        value?.let { UUID.fromString(it) }
}