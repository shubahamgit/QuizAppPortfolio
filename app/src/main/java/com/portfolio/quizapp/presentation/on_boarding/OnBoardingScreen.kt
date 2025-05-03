package com.portfolio.quizapp.presentation.on_boarding

import android.content.res.Configuration
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import com.portfolio.quizapp.R
import kotlinx.coroutines.launch


@Preview(showBackground = true)
@Composable
fun OnBoardingScreen(

) {
    Scaffold(

    ) { innerPadding ->

        val orientation = LocalConfiguration.current.orientation
        val constraints = if(orientation == Configuration.ORIENTATION_PORTRAIT) onBoardingCompactLayout() else onBoardingCompactLayout()
        val pages = PageList.entries

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            constraintSet = constraints
        ) {

            Column(
                modifier = Modifier
                    .layoutId("topAppBar")
                    .fillMaxHeight(0.5f)
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 60.dp,
                            bottomEnd = 60.dp,
                            topStart = 0.dp,
                            topEnd = 0.dp
                        )
                    )
                    .background(colorResource(R.color.dark_blue)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Icon(
                    modifier = Modifier.fillMaxSize(0.4f),
                    painter = painterResource(R.drawable.topappbarcircle),
                    contentDescription = null,
                    tint = colorResource(R.color.purple_blue)
                )
            }

            val pagerState = rememberPagerState(pageCount = { pages.size })

            HorizontalPager(
                modifier = Modifier.layoutId("slides"),
                state = pagerState,
                verticalAlignment = Alignment.CenterVertically
            ) { pageIndex ->

                val page = pages[pageIndex]

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = page.title,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily(Font(R.font.nunito_sans)),
                        style = MaterialTheme.typography.headlineMedium,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        modifier = Modifier.fillMaxWidth(0.8f),
                        text = page.line,
                        fontFamily = FontFamily(Font(R.font.nunito_sans)),
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center
                    )
                }
            }


            Row(
                modifier = Modifier.layoutId("indicator"),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                repeat(pages.size) { index ->
                    Box(
                        modifier = Modifier
                            .width(if (pagerState.currentPage == index) 36.dp else 18.dp)
                            .height(if (pagerState.currentPage == index) 12.dp else 12.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(
                                if (pagerState.currentPage == index) colorResource(R.color.dark_blue) else colorResource(
                                    R.color.dark_grey
                                )
                            ),
                    )
                }
            }

            val scope = rememberCoroutineScope()

            val buttonState by remember {
                derivedStateOf {
                    when (pagerState.currentPage) {
                        0 -> ButtonState(nextButtonText = ">")
                        1 -> ButtonState(nextButtonText = ">")
                        else -> ButtonState( nextButtonText = "Get Started")
                    }
                }
            }

            val buttonLeftPadding by animateDpAsState(
                targetValue = if(pagerState.currentPage == 2) 25.dp else 0.dp,
                animationSpec = tween(durationMillis = 300)
            )


            ConstraintLayout(
                modifier = Modifier
                    .layoutId("buttons")
                    .fillMaxWidth(),
            ) {

                val (btn1, btn2) = createRefs()
                val middleGuideline = createGuidelineFromStart(0.5f)
                val endGuideline = createGuidelineFromEnd(0.05f)
                val startGuideline = createGuidelineFromStart(0.05f)

                Button(
                    modifier = Modifier
                        .constrainAs(btn1) {
                            width = Dimension.wrapContent
                            height = Dimension.wrapContent

                            top.linkTo(parent.top)
                            start.linkTo(startGuideline)
                            end.linkTo(middleGuideline)
                            bottom.linkTo(parent.bottom)

                            horizontalBias = 0.0f
                        },
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.white),
                        contentColor = colorResource(R.color.dark_grey),
                        disabledContainerColor = colorResource(R.color.white),
                        disabledContentColor = colorResource(R.color.dark_grey)
                    ),
                    content = @Composable {
                        Text(
                            text = "Skip",
                            fontFamily = FontFamily(Font(R.font.nunito_sans)),
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.ExtraBold,
                            color = colorResource(R.color.dark_grey)
                        )
                    }
                )

                Button(
                    modifier = Modifier
                        .constrainAs(btn2) {
                            width = Dimension.wrapContent
                            height = Dimension.wrapContent

                            top.linkTo(parent.top)
                            start.linkTo(middleGuideline)
                            end.linkTo(endGuideline)
                            bottom.linkTo(parent.bottom)

                            horizontalBias = 1.0f
                        },
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(
                        start = buttonLeftPadding,
                        end = buttonLeftPadding,
                        top = 10.dp,
                        bottom = 10.dp
                    ),
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.dark_blue),
                        disabledContainerColor = colorResource(R.color.dark_blue),
                    ),
                    content = @Composable {
                        Text(
                            text = buttonState.nextButtonText,
                            fontFamily = FontFamily(Font(R.font.nunito_sans)),
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.white)

                        )
                    }
                )
            }
        }


    }

}

@Composable
fun onBoardingCompactLayout() = ConstraintSet {
    val topAppBar = createRefFor("topAppBar")
    val slides = createRefFor("slides")
    val indicators = createRefFor("indicator")
    val buttons = createRefFor("buttons")

    val middleGuideLine = createGuidelineFromTop(0.5f)
    val bottomGuideLine = createGuidelineFromBottom(0.1f)
    val topGuideLine = createGuidelineFromTop(0.0f)

    constrain(topAppBar) {
        width = Dimension.fillToConstraints
        height = Dimension.wrapContent


        top.linkTo(topGuideLine)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        bottom.linkTo(middleGuideLine)

        verticalBias = 0.0f
        horizontalBias = 0.5f
    }

    constrain(slides) {
        width = Dimension.wrapContent
        height = Dimension.wrapContent

        top.linkTo(middleGuideLine)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        bottom.linkTo(bottomGuideLine)

        verticalBias = 0.1f
    }

    constrain(indicators) {
        width = Dimension.wrapContent
        height = Dimension.wrapContent

        top.linkTo(slides.bottom)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        bottom.linkTo(bottomGuideLine)

        verticalBias = 0.3f
    }

    constrain(buttons) {
        width = Dimension.fillToConstraints
        height = Dimension.wrapContent

        top.linkTo(bottomGuideLine)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        bottom.linkTo(parent.bottom)
        
        verticalBias = 0.0f
    }

}

