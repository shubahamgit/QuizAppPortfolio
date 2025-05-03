package com.portfolio.quizapp.presentation.home.utils

import androidx.annotation.ColorRes
import androidx.compose.ui.graphics.Color
import com.portfolio.quizapp.R



enum class QuizTypes(
    val type: String ? = null,
    @ColorRes val typeColor: Int,
    @ColorRes val iconType: Color = Color.Unspecified,
) {
    A("Science", R.color.teal_200),
    B("Geography", R.color.light_dark_blue),
    C("Sports", R.color.purple_200),
    D("Biology", R.color.teal_200),
    E("Technology", R.color.red_500),
    F("History", R.color.purple_500),
    G("SolarSystem", R.color.indigo_600);
}