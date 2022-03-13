package com.example.asystentnauczyciela.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.asystentnauczyciela.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class StudentsViewModel (application: Application): AndroidViewModel(application) {

    val getAll: LiveData<List<Student>>
    private val studentsRepository: StudentsRepository

    init {
        val appDao = AppDatabase.getInstance(application).studentDao()
        studentsRepository = StudentsRepository(appDao)
        getAll = studentsRepository.getAll
    }

    fun insert(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            studentsRepository.insert(student)
        }
    }

    fun delete(student: Student)
    {
        viewModelScope.launch(Dispatchers.IO) {
            studentsRepository.delete(student)
        }
    }

    fun update(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            studentsRepository.update(student)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            studentsRepository.deleteAll()
        }
    }
}

