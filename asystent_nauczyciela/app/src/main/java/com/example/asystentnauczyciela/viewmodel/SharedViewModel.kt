package com.example.asystentnauczyciela.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel:ViewModel() {
    private val _currentId = MutableLiveData<Int>()
    val currentId: LiveData<Int> = _currentId

    fun setValue(id: Int){
        _currentId.value=id
    }

    fun whichValue()=_currentId.value
}