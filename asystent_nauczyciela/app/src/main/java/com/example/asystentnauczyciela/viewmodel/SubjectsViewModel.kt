package com.example.asystentnauczyciela.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.asystentnauczyciela.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubjectsViewModel (application: Application): AndroidViewModel(application) {
    val getAll: LiveData<List<Subject>>
    private val subjectsRepository: SubjectsRepository

    init {
        val appDao = AppDatabase.getInstance(application).subjectDao()
        subjectsRepository = SubjectsRepository(appDao)
        getAll = subjectsRepository.getAll
    }

    fun insert(subject: Subject){
        viewModelScope.launch(Dispatchers.IO) {
            subjectsRepository.insert(subject)
        }
    }
    fun delete(subject: Subject)
    {
        viewModelScope.launch(Dispatchers.IO) {
            subjectsRepository.delete(subject)
        }
    }

    fun update(subject: Subject) {
        viewModelScope.launch(Dispatchers.IO) {
            subjectsRepository.update(subject)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            subjectsRepository.deleteAll()
        }
    }
}