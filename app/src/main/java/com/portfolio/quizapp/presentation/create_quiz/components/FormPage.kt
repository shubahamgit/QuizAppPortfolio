package com.portfolio.quizapp.presentation.create_quiz.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.portfolio.quizapp.R

@Preview(showBackground = true)
@Composable
fun FormPage(

) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (id, name, type, noq, time, submit) = createRefs()

        val topGuideLine = createGuidelineFromTop(0.05f)
        val idGuideline = createGuidelineFromTop(0.15f)
        val startGuideLine = createGuidelineFromStart(0.05f)
        val endGuideLine = createGuidelineFromEnd(0.05f)
        val bottomGuideLine = createGuidelineFromBottom(0.05f)

        ConstraintLayout(
            modifier = Modifier
                .constrainAs(id) {
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints

                    top.linkTo(topGuideLine)
                    start.linkTo(startGuideLine)
                    end.linkTo(endGuideLine)
                    bottom.linkTo(idGuideline)

                    verticalBias = 0.0f
                    horizontalBias = 0.5f
                }
        ) {
            val (id, password, idField, passwordField, edit) = createRefs()

            val middleGuideLine = createGuidelineFromStart(0.3f)
            val endGuideLine = createGuidelineFromEnd(0.1f)

            Text(
                modifier = Modifier.constrainAs(id) {
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent

                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(middleGuideLine)
                    bottom.linkTo(parent.bottom)

                    verticalBias = 0.0f
                    horizontalBias = 0.0f
                },
                text = "Quiz ID:",
                fontFamily = FontFamily(Font(R.font.nunito_sans)),
                style = MaterialTheme.typography.titleLarge
            )




        }

    }


}