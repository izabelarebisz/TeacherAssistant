package com.example.asystentnauczyciela.studentsToSubjects

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.asystentnauczyciela.model.Subject

@Dao
interface StudentToSubjectDao {
    @Transaction //jeśli wystąpi błąd zapytanie się nie wykona
    @Query("SELECT * FROM subjects_table "+
            "INNER JOIN students_to_subjects ON students_to_subjects.user_id = subjects_table.user_id " +
            "WHERE students_to_subjects.user_id LIKE :id")
    fun withSubjects(id: Int): LiveData<List<Subject>>
    @Transaction
    @Query("SELECT * FROM subjects_table where user_id not in("+
            "SELECT subjects_table.user_id FROM subjects_table "+
            "INNER JOIN students_to_subjects ON students_to_subjects.user_id = subjects_table.user_id " +
            "WHERE students_to_subjects.user_id LIKE :id)")
    fun notWithSubjects(id: Int): LiveData<List<Subject>>

}