package com.portfolio.quizapp.presentation.splash

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.portfolio.quizapp.R

@Preview(showBackground = true)
@Preview(showBackground = true, device = "spec:parent=pixel_5,orientation=landscape", )
@Composable
fun SplashScreen() {
    val orientation = LocalConfiguration.current.orientation

    val constraints = if(orientation == Configuration.ORIENTATION_PORTRAIT) splashCompactLayout() else splashOtherLayout()

    ConstraintLayout(
        modifier = Modifier.fillMaxSize(),
        constraintSet = constraints
    ) {
        Image(
            painter = painterResource(id = R.drawable.quizai),
            contentDescription = "Logo",
            modifier = Modifier.layoutId("logo")
        )

        Text(
            modifier = Modifier.layoutId("slogan"),
            text = "Simple, Fun and Interactive",
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontFamily = FontFamily(Font(R.font.nunito_sans_bold)),
            color = colorResource(R.color.green_blue)
        )

        Text(
            modifier = Modifier.layoutId("copyright"),
            text = "Copyright © 2025 Quizai.pvt.ltd",
            fontSize = MaterialTheme.typography.titleSmall.fontSize,
            fontFamily = FontFamily(Font(R.font.nunito_sans)),
            color = colorResource(R.color.green_blue),
        )
    }
}


@Composable
fun splashCompactLayout() = ConstraintSet {
    val logo = createRefFor("logo")
    val slogan = createRefFor("slogan")
    val copyright = createRefFor("copyright")

    val topGuideline = createGuidelineFromTop(0.1f)
    val bottomGuideline = createGuidelineFromBottom(0.1f)

    constrain(logo) {
        width = Dimension.percent(1.1f)
        height = Dimension.wrapContent

        top.linkTo(topGuideline)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        bottom.linkTo(bottomGuideline)

        verticalBias = 0.35f
    }

    constrain(slogan) {
        width = Dimension.wrapContent
        height = Dimension.wrapContent

        top.linkTo(logo.bottom)
        start.linkTo(logo.start)
        end.linkTo(logo.end)
        bottom.linkTo(parent.bottom)

        verticalBias = 0.0f
    }

    constrain(copyright) {
        width = Dimension.wrapContent
        height = Dimension.wrapContent

        top.linkTo(bottomGuideline)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        bottom.linkTo(parent.bottom)

        verticalBias = 0.0f
    }
}


@Composable
fun splashOtherLayout() = ConstraintSet {
    val logo = createRefFor("logo")
    val slogan = createRefFor("slogan")
    val copyright = createRefFor("copyright")

    val topGuideline = createGuidelineFromTop(0.1f)
    val bottomGuideline = createGuidelineFromBottom(0.15f)
    val startGuideline = createGuidelineFromStart(0.1f)
    val endGuideline = createGuidelineFromEnd(0.1f)

    constrain(logo) {
        width = Dimension.percent(1.2f)
        height = Dimension.wrapContent

        top.linkTo(topGuideline)
        start.linkTo(startGuideline)
        end.linkTo(endGuideline)
        bottom.linkTo(bottomGuideline)

        verticalBias = 0.3f
        horizontalBias = 0.5f
    }

    constrain(slogan) {
        width = Dimension.wrapContent
        height = Dimension.wrapContent

        top.linkTo(logo.bottom)
        start.linkTo(logo.start)
        end.linkTo(logo.end)
        bottom.linkTo(bottomGuideline)

        verticalBias = 0.0f
    }

    constrain(copyright) {
        width = Dimension.wrapContent
        height = Dimension.wrapContent

        top.linkTo(bottomGuideline)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        bottom.linkTo(parent.bottom)
    }






}