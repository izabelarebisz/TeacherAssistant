package com.example.asystentnauczyciela.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "subjects_table")
data class Subject (
    @PrimaryKey(autoGenerate = true)
    val user_id: Int,
    val nazwa: String,
    val dzien_tyg: String,
    val od_kiedy: String,
    val do_kiedy: String): Parcelable
