package com.reza.newsapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reza.core.data.di.MainDispatcher
import com.reza.core.model.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds


@HiltViewModel
class MainViewModel @Inject constructor(
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->

    }

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
        viewModelScope.launch(mainDispatcher + exceptionHandler) {
            // To simulate a network call
            delay(3.seconds)
            _isLoading.value = false
        }
    }
}

sealed interface MainActivityUiState {
    object Loading : MainActivityUiState
    data class Success(val userData: UserData) : MainActivityUiState
}