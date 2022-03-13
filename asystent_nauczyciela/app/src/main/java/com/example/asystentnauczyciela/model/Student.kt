package com.example.asystentnauczyciela.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "students_table")
data class Student (
    @PrimaryKey(autoGenerate = true)
    val user_id: Int,
    val imie: String,
    val nazwisko: String): Parcelable

