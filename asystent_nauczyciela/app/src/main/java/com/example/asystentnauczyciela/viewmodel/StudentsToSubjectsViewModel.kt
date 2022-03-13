package com.example.asystentnauczyciela.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.asystentnauczyciela.model.AppDatabase
import com.example.asystentnauczyciela.model.Student
import com.example.asystentnauczyciela.model.Subject
import com.example.asystentnauczyciela.studentsToSubjects.StudentToSubjectDao

class StudentsToSubjectsViewModel (application: Application): AndroidViewModel(application) {
    private val studentToSubjectDao: StudentToSubjectDao = AppDatabase.getInstance(application).studentToSubjectDao
    var getAll: LiveData<List<Subject>> =  studentToSubjectDao.notWithSubjects(0)

    fun actualizeId (id: Int){
        getAll = studentToSubjectDao.notWithSubjects(id)
    }

}