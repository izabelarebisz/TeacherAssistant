package com.example.asystentnauczyciela.studentsToSubjects

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "students_to_subjects", primaryKeys = ["user_id","subject_id"])
data class StudentsToSubjects (
    val user_id: Int,
    val subject_id: Int): Parcelable
