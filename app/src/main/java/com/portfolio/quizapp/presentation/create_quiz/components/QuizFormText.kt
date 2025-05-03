package com.portfolio.quizapp.presentation.create_quiz.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.portfolio.quizapp.R

@Composable
fun QuizFormText(
    modifier: Modifier = Modifier,
    text: String = ""
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = MaterialTheme.typography.titleMedium.fontSize,
        fontFamily = FontFamily(Font(R.font.nunito_sans_bold)),
        maxLines = 1,
    )
}