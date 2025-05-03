package com.portfolio.quizapp.presentation.auth.register


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.portfolio.quizapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = viewModel()
) {

    Scaffold(

    ) { innerPadding ->

        val constants = registerCompactLayout()


        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            constraintSet = constants
        ) {

            val state by viewModel.state.collectAsState(RegisterUiStates())

            TopAppBar(
                modifier = Modifier
                    .layoutId("topAppBarUser")
                    .clip(RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp)),
                title = @Composable {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(25.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.quizai_topbar_theme),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth(0.4f)
                        )

                        Text(
                            text = "User Authentication",
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily(Font(R.font.nunito_sans)),
                            color = colorResource(R.color.white),
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.dark_blue)
                ),
                windowInsets = WindowInsets.ime
            )

            Box(
                modifier = Modifier
                    .layoutId("subBoxDesign1")
                    .clip(RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp))
                    .alpha(0.9f)
                    .background(colorResource(R.color.dark_blue))

            )

            Box(
                modifier = Modifier
                    .layoutId("subBoxDesign2")
                    .clip(RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp))
                    .alpha(0.8f)
                    .background(colorResource(R.color.dark_blue))
                ,
            )

            Text(
                modifier = Modifier.layoutId("phoneNumberText"),
                text = "Phone Number",
                style = MaterialTheme.typography.titleMedium,
                color = colorResource(R.color.black),
                fontWeight = FontWeight.ExtraBold
            )

            OutlinedTextField(
                modifier = Modifier
                    .layoutId("phoneNumberTextField"),
                value = "",
                onValueChange = {},
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.call_24dp),
                        contentDescription = null,
                        tint = colorResource(R.color.dark_grey)
                    )
                },
                textStyle = MaterialTheme.typography.bodyMedium,
                placeholder = @Composable {
                    Text(
                        text = "*********",
                        textAlign = TextAlign.Center
                    )
                },

                )

            Button(
                modifier = Modifier
                    .layoutId("continueButton"),
                onClick = {},
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(vertical = 15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.dark_blue),
                    contentColor = colorResource(R.color.white),
                    disabledContentColor = colorResource(R.color.dark_grey),
                    disabledContainerColor = colorResource(R.color.white)
                ),
                content = @Composable {
                    Text(
                        text = "Continue",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold,
                    )
                }
            )
        }


    }


}

@Composable
fun registerCompactLayout() = ConstraintSet {
    val topAppBar = createRefFor("topAppBarUser")
    val subBoxDesign1 = createRefFor("subBoxDesign1")
    val subBoxDesign2 = createRefFor("subBoxDesign2")
    val phoneNumberText = createRefFor("phoneNumberText")
    val phoneNumberTextField = createRefFor("phoneNumberTextField")
    val continueButton = createRefFor("continueButton")

    val startGuideline = createGuidelineFromStart(0.05f)
    val endGuideline = createGuidelineFromEnd(0.05f)
    val bottomGuideline = createGuidelineFromBottom(0.1f)

    constrain(topAppBar) {
        width = Dimension.fillToConstraints
        height = Dimension.percent(0.2f)

        top.linkTo(parent.top)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        bottom.linkTo(parent.bottom)

        verticalBias = 0.0f
    }

    constrain(subBoxDesign1) {
        width = Dimension.percent(0.78f)
        height = Dimension.percent(0.02f)

        top.linkTo(topAppBar.bottom)
        start.linkTo(topAppBar.start)
        end.linkTo(topAppBar.end)
        bottom.linkTo(parent.bottom)

        verticalBias = 0.0f
    }

    constrain(subBoxDesign2) {
        width = Dimension.percent(0.7f)
        height = Dimension.percent(0.02f)

        top.linkTo(subBoxDesign1.bottom)
        start.linkTo(subBoxDesign1.start)
        end.linkTo(subBoxDesign1.end)
        bottom.linkTo(parent.bottom)

        verticalBias = 0.0f
    }



    constrain(phoneNumberText) {
        width = Dimension.wrapContent
        height = Dimension.wrapContent

        top.linkTo(subBoxDesign2.bottom)
        start.linkTo(startGuideline)
        end.linkTo(parent.end)
        bottom.linkTo(parent.bottom)

        verticalBias = 0.05f
        horizontalBias = 0.0f
    }


    constrain(phoneNumberTextField) {
        width = Dimension.fillToConstraints
        height = Dimension.wrapContent

        top.linkTo(phoneNumberText.bottom)
        start.linkTo(phoneNumberText.start)
        end.linkTo(endGuideline)
        bottom.linkTo(parent.bottom)

        verticalBias = 0.02f
        horizontalBias = 0.1f
    }

    constrain(continueButton) {
        width = Dimension.fillToConstraints
        height = Dimension.wrapContent

        top.linkTo(bottomGuideline)
        start.linkTo(startGuideline)
        end.linkTo(endGuideline)
        bottom.linkTo(parent.bottom)

        verticalBias = 0.0f

    }




}


