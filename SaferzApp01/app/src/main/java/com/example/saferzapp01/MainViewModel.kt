package com.example.saferzmobileapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.saferzapp01.Repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(repository:Repository):ViewModel() {
    val _loading= MutableStateFlow(true)
    val loading=_loading.asStateFlow()
    init {
        viewModelScope.launch {
            delay(3000L)
            _loading.value=false
        }
    }

}