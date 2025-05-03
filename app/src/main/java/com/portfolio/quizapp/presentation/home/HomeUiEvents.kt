package com.portfolio.quizapp.presentation.home

import com.portfolio.quizapp.presentation.home.utils.CardListName

sealed class HomeUiEvents {
    data class OnCardClick(val cardListName: CardListName) : HomeUiEvents()
}