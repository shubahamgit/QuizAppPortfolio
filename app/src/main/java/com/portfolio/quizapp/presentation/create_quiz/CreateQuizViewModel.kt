package com.portfolio.quizapp.presentation.create_quiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateQuizViewModel @Inject constructor(): ViewModel() {
    private val _uiState = MutableStateFlow(CreateQuizUiStates(
        isEditable = false,
        quizID = "#123",
        quizPassword = "*********"
    ))
    val uiState: StateFlow<CreateQuizUiStates> = _uiState.asStateFlow()

    fun onEvent(event: CreateQuizEvents) {

        when(event) {
            is CreateQuizEvents.OnQuizIDUpdated -> {
                viewModelScope.launch {

                }

            }
        }
    }

    fun isEditableToggle() {
        _uiState.value = uiState.value.copy(
            isEditable = !_uiState.value.isEditable
        )
    }
}
