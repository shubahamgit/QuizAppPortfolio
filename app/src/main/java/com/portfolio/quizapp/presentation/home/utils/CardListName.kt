package com.portfolio.quizapp.presentation.home.utils

import androidx.annotation.ColorRes
import com.portfolio.quizapp.R

enum class CardListName(
    val title: String,
    val subTitle: String,
    @ColorRes val startColor: Int,
    @ColorRes val endColor: Int,
    @ColorRes val graphicColor: Int,
) {
    A("Resume", "Quiz", R.color.blue_grey_400, R.color.blue_grey_600, R.color.blue_grey_300),
    B("Create", "Quiz", R.color.orange_400, R.color.orange_600, R.color.orange_300),
    C("Join", "Quiz", R.color.light_blue_400, R.color.light_blue_600, R.color.light_blue_300),
    D("Challenge", "Friends", R.color.indigo_400, R.color.indigo_600, R.color.indigo_300),
}