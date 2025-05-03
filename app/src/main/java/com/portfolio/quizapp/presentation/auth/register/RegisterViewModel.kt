package com.portfolio.quizapp.presentation.auth.register

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class RegisterViewModel: ViewModel() {
    private val _state = MutableStateFlow(RegisterUiStates())

    val state: StateFlow<RegisterUiStates> = _state.asStateFlow()

    fun onEvent(event: RegisterUiEvents) {
    }
}