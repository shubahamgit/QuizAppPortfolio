package com.portfolio.quizapp.presentation.create_quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.window.PopupProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.portfolio.quizapp.R
import com.portfolio.quizapp.presentation.create_quiz.components.AppButton
import com.portfolio.quizapp.presentation.create_quiz.components.QuizFormText

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun CreateQuiz(
    viewmodel: CreateQuizViewModel = viewModel()
) {

    val state by viewmodel.uiState.collectAsState()

    Scaffold { innerPadding ->

        val constraints = createQuizCompactLayout()

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            constraintSet = constraints
        ) {
            Box(
                modifier = Modifier
                    .layoutId("topAppBar")
                    .fillMaxSize()
                    .background(colorResource(R.color.dark_blue)),
            )

            Button(
                modifier = Modifier.layoutId("back"),
                onClick = {},
                shape = RoundedCornerShape(16.dp),
                elevation = ButtonDefaults.buttonElevation(10.dp),
                contentPadding = PaddingValues(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.light_dark_blue),
                ),
                content = @Composable {
                    Icon(
                        painter = painterResource(R.drawable.arrow_back_ios_new_24dp),
                        contentDescription = "back",
                        tint = colorResource(R.color.white)
                    )
                }
            )

            Text(
                modifier = Modifier.layoutId("title"),
                text = "Create Quiz",
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontFamily = FontFamily(Font(R.font.nunito_sans_bold)),
                color = colorResource(R.color.white),
                maxLines = 1
            )

            Box(
                modifier = Modifier
                    .layoutId("modal")
                    .fillMaxSize()
                    .shadow(elevation = 10.dp, shape = RoundedCornerShape(20.dp), clip = true)
                    .background(colorResource(R.color.white))
            ) {
                ConstraintLayout(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val (id, name, type, noq, time, submit) = createRefs()

                    val topGuideLine = createGuidelineFromTop(0.07f)
                    val idGuideline = createGuidelineFromTop(0.12f)
                    val startGuideLine = createGuidelineFromStart(0.05f)
                    val endGuideLine = createGuidelineFromEnd(0.05f)
                    val bottomGuideLine = createGuidelineFromBottom(0.12f)

                    ConstraintLayout (
                        modifier = Modifier.constrainAs(id) {
                            width = Dimension.fillToConstraints
                            height = Dimension.fillToConstraints

                            top.linkTo(topGuideLine)
                            start.linkTo(startGuideLine)
                            end.linkTo(endGuideLine)
                            bottom.linkTo(idGuideline)
                        }
                    ) {
                        val (quizId, quizPassword, quizIdField, quizIdText, quizPasswordField, quizPasswordText, edit) = createRefs()

                        val middleGuideLine = createGuidelineFromStart(0.4f)
                        val endGuideLine = createGuidelineFromEnd(0.2f)
                        val topGuideLine = createGuidelineFromTop(0.05f)


                        QuizFormText(
                            text = "Quiz ID:",
                            modifier = Modifier.constrainAs(quizId) {
                                width = Dimension.fillToConstraints
                                height = Dimension.wrapContent

                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(middleGuideLine)
                                bottom.linkTo(topGuideLine)

                                verticalBias = 1f
                                horizontalBias = 0.0f
                            }
                        )

                        if(state.isEditable) {
                            OutlinedTextField(
                                value = state.quizID,
                                onValueChange = {},
                                singleLine = true,
                                modifier = Modifier
                                    .constrainAs(quizIdField) {
                                        width = Dimension.fillToConstraints
                                        height = Dimension.fillToConstraints

                                        top.linkTo(quizId.top)
                                        start.linkTo(middleGuideLine)
                                        end.linkTo(endGuideLine)
                                        bottom.linkTo(quizId.bottom)

                                        horizontalBias = 0.0f
                                    }

                            )

                            OutlinedTextField(
                                value = "",
                                onValueChange = {},
                                singleLine = true,
                                modifier = Modifier.constrainAs(quizPasswordField) {
                                    width = Dimension.fillToConstraints
                                    height = Dimension.fillToConstraints

                                    top.linkTo(quizPassword.top)
                                    start.linkTo(middleGuideLine)
                                    end.linkTo(endGuideLine)
                                    bottom.linkTo(quizPassword.bottom)

                                    horizontalBias = 0.0f
                                }

                            )

                        }


                        else {
                            Text(
                                text = state.quizID,
                                fontFamily = FontFamily(Font(R.font.nunito_sans)),
                                fontWeight = FontWeight.W600,
                                style = MaterialTheme.typography.titleSmall,
                                color = colorResource(R.color.dark_grey),
                                maxLines = 1,
                                modifier = Modifier.constrainAs(quizIdText) {
                                    width = Dimension.fillToConstraints
                                    height = Dimension.wrapContent

                                    top.linkTo(quizId.top)
                                    start.linkTo(middleGuideLine)
                                    end.linkTo(endGuideLine)
                                    bottom.linkTo(quizId.bottom)

                                    horizontalBias = 0.0f
                                }
                            )

                            Text(
                                text = state.quizPassword,
                                fontFamily = FontFamily(Font(R.font.nunito_sans)),
                                fontWeight = FontWeight.W600,
                                style = MaterialTheme.typography.titleSmall,
                                color = colorResource(R.color.dark_grey),
                                maxLines = 1,
                                modifier = Modifier.constrainAs(quizPasswordText) {
                                    width = Dimension.fillToConstraints
                                    height = Dimension.wrapContent

                                    top.linkTo(quizPassword.top)
                                    start.linkTo(middleGuideLine)
                                    end.linkTo(endGuideLine)
                                    bottom.linkTo(quizPassword.bottom)

                                    horizontalBias = 0.0f
                                }
                            )
                        }

                        QuizFormText(
                            text = "Quiz Password:",
                            modifier = Modifier.constrainAs(quizPassword) {
                                width = Dimension.fillToConstraints
                                height = Dimension.wrapContent

                                top.linkTo(topGuideLine)
                                start.linkTo(parent.start)
                                end.linkTo(middleGuideLine)
                                bottom.linkTo(parent.bottom)

                                verticalBias = 1f
                                horizontalBias = 0.0f
                            }
                        )


                        IconButton (
                            onClick = { viewmodel.isEditableToggle() },
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = if (state.isEditable) colorResource(R.color.light_dark_blue) else colorResource(
                                    R.color.dark_grey
                                ),
                                contentColor = colorResource(R.color.white)
                            ),
                            modifier = Modifier
                                .padding(0.dp)
                                .constrainAs(edit) {
                                    width = Dimension.wrapContent
                                    height = Dimension.wrapContent

                                    top.linkTo(quizId.top)
                                    start.linkTo(endGuideLine)
                                    end.linkTo(parent.end)
                                    bottom.linkTo(quizPassword.bottom)

                                    verticalBias = 0.5f
                                    horizontalBias = 1f
                                },
                            content = @Composable {
                                Icon(
                                    painter = painterResource(R.drawable.edit_24dp),
                                    contentDescription = "edit"
                                )
                            }
                        )
                    }

                    var expanded by remember { mutableStateOf(false) }

                    Column(
                        modifier = Modifier.constrainAs(name) {
                            width = Dimension.fillToConstraints
                            height = Dimension.wrapContent

                            top.linkTo(idGuideline)
                            start.linkTo(startGuideLine)
                            end.linkTo(endGuideLine)
                            bottom.linkTo(bottomGuideLine)

                            verticalBias = 0.05f
                            horizontalBias = 0.0f
                        },
                        verticalArrangement = Arrangement.spacedBy(10.dp)

                    ) {
                        QuizFormText(text = "Quiz Name")

                        OutlinedTextField(
                            value = "Data Communication module 1",
                            onValueChange = {},
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent
                            ),
                            textStyle = TextStyle(
                                color = colorResource(R.color.dark_grey),
                                fontFamily = FontFamily(Font(R.font.nunito_sans)),
                                fontWeight = FontWeight.SemiBold
                            ),
                            trailingIcon = @Composable {
                                IconButton(
                                    onClick = {},

                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.cancel_24dp),
                                        contentDescription = "cancel",
                                        tint = colorResource(R.color.dark_grey),
                                        modifier = Modifier.size(20.dp)
                                    )

                                }

                            },
                            modifier = Modifier
                                .fillMaxWidth()
                        )

                    }


                    Column(
                        modifier = Modifier.constrainAs(type) {
                            width = Dimension.fillToConstraints
                            height = Dimension.wrapContent

                            top.linkTo(name.bottom)
                            start.linkTo(startGuideLine)
                            end.linkTo(endGuideLine)
                            bottom.linkTo(bottomGuideLine)

                            verticalBias = 0.05f
                            horizontalBias = 0.0f
                        },
                        verticalArrangement = Arrangement.spacedBy(10.dp)

                    ) {
                       QuizFormText( text = "Question Type")

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            properties = PopupProperties(
                                dismissOnBackPress = true,
                                dismissOnClickOutside = true
                            )
                        ) {


                        }
                    }

                    Column(
                        modifier = Modifier.constrainAs(noq) {
                            width = Dimension.fillToConstraints
                            height = Dimension.wrapContent

                            top.linkTo(type.bottom)
                            start.linkTo(startGuideLine)
                            end.linkTo(endGuideLine)
                            bottom.linkTo(parent.bottom)

                            verticalBias = 0.05f
                            horizontalBias = 0.0f
                        },
                        verticalArrangement = Arrangement.spacedBy(10.dp)

                    ) {
                        QuizFormText(text = "Number of Questions")

                        OutlinedTextField(
                            value = "15",
                            onValueChange = {},
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent
                            ),
                            textStyle = TextStyle(
                                color = colorResource(R.color.dark_grey),
                                fontFamily = FontFamily(Font(R.font.nunito_sans)),
                                fontWeight = FontWeight.SemiBold
                            ),
                            trailingIcon = @Composable {
                                IconButton(
                                    onClick = {},

                                    ) {
                                    Icon(
                                        painter = painterResource(R.drawable.cancel_24dp),
                                        contentDescription = "cancel",
                                        tint = colorResource(R.color.dark_grey),
                                        modifier = Modifier.size(20.dp)
                                    )

                                }

                            },
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }

                    Column(
                        modifier = Modifier.constrainAs(time) {
                            width = Dimension.fillToConstraints
                            height = Dimension.wrapContent

                            top.linkTo(noq.bottom)
                            start.linkTo(startGuideLine)
                            end.linkTo(endGuideLine)
                            bottom.linkTo(parent.bottom)

                            verticalBias = 0.05f
                            horizontalBias = 0.0f
                        },
                        verticalArrangement = Arrangement.spacedBy(10.dp)

                    ) {
                        QuizFormText(
                            text = "Quiz Duration",
                        )

                        OutlinedTextField(
                            value = "15",
                            onValueChange = {},
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent
                            ),
                            textStyle = TextStyle(
                                color = colorResource(R.color.dark_grey),
                                fontFamily = FontFamily(Font(R.font.nunito_sans)),
                                fontWeight = FontWeight.SemiBold
                            ),
                            trailingIcon = @Composable {
                                IconButton(
                                    onClick = {},
                                    ) {
                                    Icon(
                                        painter = painterResource(R.drawable.cancel_24dp),
                                        contentDescription = "cancel",
                                        tint = colorResource(R.color.dark_grey),
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }

                    AppButton(
                        modifier = Modifier
                            .constrainAs(submit) {
                                width = Dimension.fillToConstraints
                                height = Dimension.wrapContent

                                top.linkTo(bottomGuideLine)
                                start.linkTo(startGuideLine)
                                end.linkTo(endGuideLine)
                                bottom.linkTo(parent.bottom)

                                verticalBias = 0.0f
                            },
                        onClick = {},
                        text = "Continue"
                    )
                }
            }
        }
    }
}



@Composable
fun createQuizCompactLayout() = ConstraintSet {
    val topAppBar = createRefFor("topAppBar")
    val back = createRefFor("back")
    val title = createRefFor("title")
    val modal = createRefFor("modal")

    val topGuideLine = createGuidelineFromTop(0.02f)
    val modalGuideline = createGuidelineFromTop(0.12f)
    val topAppBarGuideline = createGuidelineFromTop(0.2f)
    val startGuideLine = createGuidelineFromStart(0.05f)
    val endGuideLine = createGuidelineFromEnd(0.05f)
    val bottomGuideLine = createGuidelineFromBottom(0.05f)

    constrain(topAppBar) {
        width = Dimension.fillToConstraints
        height = Dimension.fillToConstraints
        
        top.linkTo(parent.top)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        bottom.linkTo(topAppBarGuideline)

        verticalBias = 0.5f
        horizontalBias = 0.5f
    }

    constrain(back) {
        width = Dimension.wrapContent
        height = Dimension.wrapContent

        top.linkTo(topGuideLine)
        start.linkTo(startGuideLine)
        end.linkTo(endGuideLine)
        bottom.linkTo(modalGuideline)

        verticalBias = 0.0f
        horizontalBias = 0.0f
    }

    constrain(title) {
        width = Dimension.wrapContent
        height = Dimension.wrapContent

        top.linkTo(back.top)
        start.linkTo(startGuideLine)
        end.linkTo(endGuideLine)
        bottom.linkTo(back.bottom)

        verticalBias = 0.5f
        horizontalBias = 0.5f
    }

    constrain(modal) {
        width = Dimension.fillToConstraints
        height = Dimension.fillToConstraints

        top.linkTo(modalGuideline)
        start.linkTo(startGuideLine)
        end.linkTo(endGuideLine)
        bottom.linkTo(bottomGuideLine)
    }

}

