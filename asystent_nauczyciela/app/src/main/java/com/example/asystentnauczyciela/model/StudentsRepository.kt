package com.example.asystentnauczyciela.model

import androidx.lifecycle.LiveData

class StudentsRepository (private val appDao: StudentDao) {
    val getAll: LiveData<List<Student>> = appDao.getAll()

    suspend fun insert(student: Student) {
        appDao.insert(student)
    }

    fun update(student: Student){
        appDao.update(student)
    }

    fun delete(student: Student){
        appDao.delete(student)
    }

    fun deleteAll(){
        appDao.deleteAll()
    }
}

