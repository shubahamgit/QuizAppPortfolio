package com.portfolio.quizapp.presentation.create_quiz.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.portfolio.quizapp.R

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    text: String = ""
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.textButtonColors(
            containerColor = colorResource(R.color.dark_blue),
            contentColor = colorResource(R.color.white)
        ),
        contentPadding = PaddingValues(14.dp),
        content = @Composable {
            Text(
                text = text,
                fontFamily = FontFamily(Font(R.font.nunito_sans)),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
            )
        }
    )
}