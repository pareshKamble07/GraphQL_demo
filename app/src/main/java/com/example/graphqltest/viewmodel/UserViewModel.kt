package com.example.graphqltest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graphqltest.repo.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor
    (
    private val repository: UserRepo
) : ViewModel() {

    private val _response = MutableLiveData<String>()
    var response: LiveData<String> = _response

    fun fetchDataResponse() = viewModelScope.launch {
        repository.getUserData().collect { values ->
            _response.value = values
        }
    }


}