package com.portfolio.quizapp.presentation.create_quiz

sealed class CreateQuizEvents() {
    data class OnQuizIDUpdated(val quizID: String, val quizPassword: String): CreateQuizEvents()
}