package com.example.bottomnav.data

import android.media.Image
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
@Entity(tableName = "events")
data class NewEvent(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val type: String,
    val image: Image,
    val date: LocalDate

)