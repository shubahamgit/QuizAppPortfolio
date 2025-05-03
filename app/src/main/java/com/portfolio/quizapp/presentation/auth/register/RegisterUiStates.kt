package com.portfolio.quizapp.presentation.auth.register

data class RegisterUiStates(
    val isRegistered: Boolean = false,
    val isSignedIn: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = "",
)
