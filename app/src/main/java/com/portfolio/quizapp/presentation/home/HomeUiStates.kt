package com.portfolio.quizapp.presentation.home

import com.portfolio.quizapp.presentation.home.utils.CardListName
import com.portfolio.quizapp.presentation.home.utils.QuizTypes

data class HomeUiStates(
    val cardList: List<CardListName> = CardListName.entries,
    val quizTypeList: List<QuizTypes> = QuizTypes.entries,
    val isLoading: Boolean = false,
    val error: String = ""
)
