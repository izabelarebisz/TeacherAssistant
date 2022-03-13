package com.example.asystentnauczyciela.model

import androidx.lifecycle.LiveData

class SubjectsRepository(private val appDao: SubjectDao) {
    val getAll: LiveData<List<Subject>> = appDao.getAll()

    suspend fun insert(subject: Subject) {
        appDao.insert(subject)
    }

    fun update(subject: Subject){
        appDao.update(subject)
    }

    fun delete(subject: Subject){
        appDao.delete(subject)
    }

    fun deleteAll(){
        appDao.deleteAll()
    }
}

