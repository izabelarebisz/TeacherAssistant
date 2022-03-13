package com.example.asystentnauczyciela.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {

    @Insert
    suspend fun insert(student: Student)

    @Update
    fun update(student: Student)

    @Delete
    fun delete(student: Student)

    @Query("DELETE FROM students_table")
    fun deleteAll()

    @Query("SELECT * FROM students_table")
    fun getAll(): LiveData<List<Student>>

}



