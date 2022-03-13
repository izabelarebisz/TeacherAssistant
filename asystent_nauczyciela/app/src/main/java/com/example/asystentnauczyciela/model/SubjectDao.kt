package com.example.asystentnauczyciela.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubjectDao {
    @Insert
    suspend fun insert(subject: Subject)

    @Update
    fun update(subject: Subject)

    @Delete
    fun delete(subject: Subject)

    @Query("DELETE FROM subjects_table")
    fun deleteAll()

    @Query("SELECT * FROM subjects_table")
    fun getAll(): LiveData<List<Subject>>

}