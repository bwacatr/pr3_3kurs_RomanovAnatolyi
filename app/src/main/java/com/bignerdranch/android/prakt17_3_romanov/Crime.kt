package com.bignerdranch.android.prakt17_3_romanov

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity
data class Crime(@PrimaryKey var id: UUID = UUID.randomUUID(),
    var title: String = "",
    var date: Date = Date(),
    var isSolved: Boolean = false,
    var suspect: String = "",
    var suspectPhoneId: String = "")

