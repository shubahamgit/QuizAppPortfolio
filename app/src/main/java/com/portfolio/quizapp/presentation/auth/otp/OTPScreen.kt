package com.portfolio.quizapp.presentation.auth.otp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
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
import com.portfolio.quizapp.R

@Preview(showBackground = true)
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun OTPScreen(

) {
    val constraints = otpCompactLayout()

    ConstraintLayout(
        modifier = Modifier.fillMaxSize(),
        constraintSet = constraints
    ) {

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
                        text = "OTP Verification",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.nunito_sans)),
                        color = colorResource(R.color.white),
                        modifier = Modifier
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
            modifier = Modifier.layoutId("otp"),
            text = "OTP",
            style = MaterialTheme.typography.titleLarge,
            color = colorResource(R.color.black),
            fontWeight = FontWeight.ExtraBold
        )

        Row(
            modifier = Modifier.layoutId("otpTextField"),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(8) { index ->
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.weight(1f),
                    textStyle = MaterialTheme.typography.bodyMedium,
                    shape = RoundedCornerShape(10.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = colorResource(R.color.white),
                        focusedContainerColor = colorResource(R.color.white),
                        disabledContainerColor = colorResource(R.color.dark_grey),
                        unfocusedIndicatorColor = colorResource(R.color.dark_grey),
                        focusedIndicatorColor = colorResource(R.color.dark_grey),
                    )
                )
            }
        }

        Row(
            modifier = Modifier.layoutId("resendOTP"),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(
                modifier = Modifier.padding(end = 20.dp),
                onClick = {},
                content = @Composable {
                    Text(
                        text = "Resend OTP",
                        style = MaterialTheme.typography.titleMedium,
                        color = colorResource(R.color.purple_500),
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            )

            CircularProgressIndicator(
                modifier = Modifier.size(20.dp)
            )
        }

        Row(
            modifier = Modifier.layoutId("buttons"),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {},
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.dark_blue),
                    contentColor = colorResource(R.color.white),
                    disabledContentColor = colorResource(R.color.dark_grey),
                    disabledContainerColor = colorResource(R.color.white)
                ),
                contentPadding = PaddingValues(vertical = 15.dp, horizontal = 60.dp),
                content = @Composable {
                    Text(
                        text = "Back",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            )

            Button(
                onClick = {},
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.dark_blue),
                    contentColor = colorResource(R.color.white),
                    disabledContentColor = colorResource(R.color.dark_grey),
                    disabledContainerColor = colorResource(R.color.white)
                ),
                contentPadding = PaddingValues(vertical = 15.dp, horizontal = 60.dp),
                content = @Composable {
                    Text(
                        text = "Submit",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            )
        }
    }
}

@Composable
fun otpCompactLayout() = ConstraintSet {
    val topAppBar = createRefFor("topAppBarUser")
    val subBoxDesign1 = createRefFor("subBoxDesign1")
    val subBoxDesign2 = createRefFor("subBoxDesign2")
    val otp = createRefFor("otp")
    val otpTextField = createRefFor("otpTextField")
    val resendOTP = createRefFor("resendOTP")
    val buttons = createRefFor("buttons")

    val startGuideline = createGuidelineFromStart(0.05f)
    val endGuideline = createGuidelineFromEnd(0.05f)
    val bottomGuideline = createGuidelineFromBottom(0.15f)


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

    constrain(otp) {
        width = Dimension.wrapContent
        height = Dimension.wrapContent

        top.linkTo(subBoxDesign2.bottom)
        start.linkTo(startGuideline)
        end.linkTo(parent.end)
        bottom.linkTo(parent.bottom)

        verticalBias = 0.05f
        horizontalBias = 0.0f
    }

    constrain(otpTextField) {
        width = Dimension.fillToConstraints
        height = Dimension.wrapContent

        top.linkTo(otp.bottom)
        start.linkTo(startGuideline)
        end.linkTo(endGuideline)
        bottom.linkTo(parent.bottom)

        verticalBias = 0.05f
    }

    constrain(resendOTP) {
        width = Dimension.fillToConstraints
        height = Dimension.wrapContent

        top.linkTo(otpTextField.bottom)
        start.linkTo(startGuideline)
        end.linkTo(endGuideline)
        bottom.linkTo(parent.bottom)

        verticalBias = 0.05f
    }



    constrain(buttons) {
        width = Dimension.fillToConstraints
        height = Dimension.wrapContent

        top.linkTo(bottomGuideline)
        start.linkTo(startGuideline)
        end.linkTo(endGuideline)
        bottom.linkTo(parent.bottom)
    }


}


