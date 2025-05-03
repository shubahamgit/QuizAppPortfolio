package com.portfolio.quizapp.presentation.home

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class HomeViewModel {

    private val _state = MutableStateFlow(HomeUiStates())
    val state: StateFlow<HomeUiStates> = _state.asStateFlow()


    fun onEvent(event: HomeUiEvents) {
        when(event) {
            is HomeUiEvents.OnCardClick -> {

            }
        }

    }
}