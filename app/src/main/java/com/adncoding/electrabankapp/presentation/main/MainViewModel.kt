package com.adncoding.electrabankapp.presentation.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by AidenChang 2024/04/03
 */
class MainViewModel : ViewModel() {
    private val _state = mutableStateOf(MainState())
    val state: State<MainState> = _state

    init {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            delay(1000)
            _state.value = _state.value.copy(isLoading = false)
        }
    }
}