package com.portfolio.quizapp.presentation.home.components


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.portfolio.quizapp.R

@Preview
@Composable
fun ListCards(
    modifier: Modifier = Modifier,
    startColor: Color = colorResource(R.color.blue_grey_400),
    endColor: Color = colorResource(R.color.blue_grey_600),
    graphicsColor: Color = colorResource(R.color.blue_grey_300),
    titleString: String = "Create",
    subtitleString: String = "Quiz",
    arrowColor: Color = colorResource(R.color.blue_grey_600),
    onCardClick: () -> Unit = {}
    )
{
    ConstraintLayout(
        modifier = modifier
            .clickable(onClick = onCardClick)
            .defaultMinSize(
            minWidth = 150.dp,
            minHeight = 180.dp
        )
    ) {
        val (card,title, subTitle, button) = createRefs()

        val topGuideline = createGuidelineFromTop(0.1f)
        val startGuideline = createGuidelineFromStart(0.1f)
        val endGuideline = createGuidelineFromEnd(0.05f)
        val bottomGuideline = createGuidelineFromBottom(0.1f)


        val circleColor = Color(0xFFFF8A65)


        Card(
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 10.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent,
                contentColor = colorResource(R.color.white)
            ),
            modifier = Modifier
                .constrainAs(card) {
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints

                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            },
            content = @Composable {
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf<Color>(
                                    startColor,
                                    endColor
                                ),
                                start = Offset(0f, 0f),
                                end = Offset.Infinite
                            )
                        )
                ) {

                    val (circle, wave) = createRefs()

                    Canvas(
                        modifier = Modifier
                            .constrainAs(circle) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)

                                verticalBias = 0.05f
                                horizontalBias = 0.05f

                            },
                        onDraw = {
                            drawCircle(
                                color = graphicsColor.copy(0.6f),
                                radius = 120f,
                            )

                        }
                    )


                    Icon(
                        modifier = Modifier
                            .size(110.dp)
                            .offset(x = 10.dp, y = 10.dp)
                            .constrainAs(wave) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)

                                horizontalBias = 1f
                                verticalBias = 1f
                        },
                        painter = painterResource(R.drawable.card_graphic_74dp),
                        contentDescription = null,
                        tint = graphicsColor.copy(alpha = 0.6f)
                    )
                }
            }
        )


        Text(
            text = titleString,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontFamily = FontFamily(Font(R.font.nunito_sans_bold)),
            color = colorResource(R.color.white),
            modifier = Modifier
                .constrainAs(title) {
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent

                    top.linkTo(topGuideline)
                    start.linkTo(startGuideline)
                    end.linkTo(endGuideline)
                    bottom.linkTo(bottomGuideline)


                    verticalBias = 0.0f
                    horizontalBias = 0.0f
                }
        )

        Text(
            text = subtitleString,
            fontSize = MaterialTheme.typography.displayMedium.fontSize,
            fontFamily = FontFamily(Font(R.font.nunito_sans_bold)),
            color = colorResource(R.color.white),
            modifier = Modifier
                .constrainAs(subTitle) {
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent

                    top.linkTo(title.bottom)
                    start.linkTo(startGuideline)
                    end.linkTo(endGuideline)
                    bottom.linkTo(bottomGuideline)


                    verticalBias = 0.0f
                    horizontalBias = 0.0f
                }
        )

        Button(
            onClick = {},
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.white),
            ),

            content = @Composable {
                Icon(
                    painter = painterResource(R.drawable.arrow_right_alt_24dp),
                    contentDescription = null,
                    tint = arrowColor,
                )
            },
            modifier = Modifier
                .constrainAs(button) {
                    height = Dimension.wrapContent

                    top.linkTo(subTitle.bottom)
                    start.linkTo(startGuideline)
                    end.linkTo(endGuideline)
                    bottom.linkTo(bottomGuideline)


                    verticalBias = 1.0f
                    horizontalBias = 0.0f
                }
        )


    }
}
