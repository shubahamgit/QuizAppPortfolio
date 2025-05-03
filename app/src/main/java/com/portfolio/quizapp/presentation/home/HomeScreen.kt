package com.portfolio.quizapp.presentation.home


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import com.portfolio.quizapp.R
import com.portfolio.quizapp.presentation.home.components.ListCards
import com.portfolio.quizapp.presentation.home.components.itemsInPairsIndexed
import com.portfolio.quizapp.ui.theme.LightDarkBlue


@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = HomeViewModel()
) {
    val state by viewModel.state.collectAsState(HomeUiStates())

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .size(84.dp)
                    .offset(y = 50.dp),
                onClick = {},
                containerColor = colorResource(R.color.dark_blue),
                shape = CircleShape
            ) {
                Icon(
                    modifier = Modifier.size(40.dp),
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = colorResource(R.color.white)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            BottomAppBar(
                containerColor = colorResource(R.color.dark_blue),
                tonalElevation = 10.dp
            ) {
                ConstraintLayout(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val (home, history, circle, rewards, friends) = createRefs()

                    val startGuideline = createGuidelineFromStart(0.05f)
                    val endGuideline = createGuidelineFromEnd(0.1f)
                    val fabStartGuideline = createGuidelineFromStart(0.37f)
                    val fabEndGuideline = createGuidelineFromEnd(0.32f)


                    IconButton(
                        onClick = {},
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color.Transparent,
                            contentColor = colorResource(R.color.white)
                        ),
                        modifier = Modifier.constrainAs(home) {
                            width = Dimension.wrapContent
                            height = Dimension.wrapContent

                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(startGuideline)
                            end.linkTo(endGuideline)

                            horizontalBias = 0.0f
                            verticalBias = 0.5f
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.home_24dp),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }

                    IconButton(
                        onClick = {},
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color.Transparent,
                            contentColor = colorResource(R.color.grey_400)
                        ),
                        modifier = Modifier.constrainAs(history) {
                            width = Dimension.wrapContent
                            height = Dimension.wrapContent

                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(home.end)
                            end.linkTo(fabStartGuideline)

                            horizontalBias = 0.6f
                            verticalBias = 0.5f
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.history_24dp),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }

                    val colorScheme = MaterialTheme.colorScheme.background

                    Canvas(
                        modifier = Modifier
                            .offset(y = (-50).dp)
                            .constrainAs(circle) {
                                width = Dimension.wrapContent
                                height = Dimension.wrapContent

                                top.linkTo(parent.top)
                                start.linkTo(fabStartGuideline)
                                end.linkTo(fabEndGuideline)
                                bottom.linkTo(parent.bottom)

                                horizontalBias = 0.42f
                            },
                        onDraw = {
                            drawCircle(
                                color = colorScheme,
                                radius = 138f,

                            )

                        }
                    )

                    IconButton(
                        onClick = {},
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color.Transparent,
                            contentColor = colorResource(R.color.grey_400)
                        ),
                        modifier = Modifier.constrainAs(rewards) {
                            width = Dimension.wrapContent
                            height = Dimension.wrapContent

                            start.linkTo(fabEndGuideline)
                            end.linkTo(endGuideline)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)

                            horizontalBias = 0.0f
                            verticalBias = 0.5f
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.rewarded_ads_24dp),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }

                    IconButton(
                        onClick = {},
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color.Transparent,
                            contentColor = colorResource(R.color.grey_400)
                        ),
                        modifier = Modifier.constrainAs(friends) {
                            width = Dimension.wrapContent
                            height = Dimension.wrapContent

                            start.linkTo(rewards.end, 20.dp)
                            end.linkTo(endGuideline)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)

                            horizontalBias = 0.0f
                            verticalBias = 0.5f
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.person_24dp_filled),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }
            }
        }
    ) {
        innerPadding ->

        val constraints = homeScreenCompactLayout()



        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            constraintSet = constraints,

        ) {
            TopAppBar(
                modifier = Modifier
                    .layoutId("topAppBarUser")
                    .clip(RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp)),
                title = @Composable {

                    val initialColor = Color(LightDarkBlue.value)
                    val colorOfCircle = initialColor.copy(alpha = 0.35f)

                    ConstraintLayout(
                        modifier = Modifier.fillMaxSize() 
                    ) {

                        val (firstCircle, secondCircle) = createRefs()

                        Canvas(
                            modifier = Modifier
                                .constrainAs(firstCircle) {
                                    top.linkTo(parent.top)
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                    bottom.linkTo(parent.bottom)

                                    horizontalBias = 0.9f
                                    verticalBias = 0.1f

                                },
                            onDraw = {
                                drawCircle(
                                    color = colorOfCircle,
                                    radius = 300f
                                )
                            }
                        )

                        Canvas(
                            modifier = Modifier
                                .constrainAs(secondCircle) {
                                    top.linkTo(parent.top)
                                    start.linkTo(parent.start)
                                    end.linkTo(firstCircle.start)
                                    bottom.linkTo(parent.bottom)

                                    horizontalBias = 0.38f
                                    verticalBias = 0.6f
                                },
                            onDraw = {
                                drawCircle(
                                    color = colorOfCircle,
                                    radius = 120f
                                )

                            }
                        )

                        Column(
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                IconToggleButton(
                                    modifier = Modifier
                                        .shadow(
                                            elevation = 10.dp,
                                            shape = RoundedCornerShape(10.dp),
                                            clip = true
                                        )
                                        .background(colorResource(R.color.light_dark_blue)),
                                    checked = false,
                                    onCheckedChange = { },
                                ) {
                                    Icon(
                                        painter = if (true) painterResource(R.drawable.grid_view_24dp_filled) else painterResource(
                                            R.drawable.grid_view_24dp
                                        ),
                                        contentDescription = null,
                                        tint = colorResource(R.color.white)
                                    )
                                }

                                IconToggleButton(
                                    modifier = Modifier
                                        .shadow(
                                            elevation = 10.dp,
                                            shape = RoundedCornerShape(10.dp),
                                            clip = true
                                        )
                                        .background(colorResource(R.color.light_dark_blue)),
                                    checked = false,
                                    onCheckedChange = { },
                                ) {
                                    Icon(
                                        painter = if (true) painterResource(R.drawable.notifications_24dp_filled) else painterResource(
                                            R.drawable.notifications_24dp
                                        ),
                                        contentDescription = null,
                                        tint = colorResource(R.color.white)
                                    )
                                }

                            }

                            Text(
                                text = "Welcome Back!",
                                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                                fontFamily = FontFamily(Font(R.font.nunito_sans)),
                                color = colorResource(R.color.white),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 20.dp)
                            )

                            Text(
                                text = "xyz name",
                                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                                fontFamily = FontFamily(Font(R.font.nunito_sans)),
                                fontWeight = FontWeight.Bold,
                                color = colorResource(R.color.white),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 20.dp)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.dark_blue)
                ),
            )



            LazyRow(
                modifier = Modifier
                    .layoutId("userMenu"),
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {

                itemsIndexed(state.cardList) { index, item ->


                    val startIndexPadding = if(index == 0) 20.dp else 0.dp
                    val lastIndexPadding = if(index == state.cardList.lastIndex) 20.dp else 0.dp

                    if(index == 0) {
                        return@itemsIndexed
                    } else {
                        ListCards(
                            titleString = item.title,
                            subtitleString = item.subTitle,
                            startColor = colorResource(item.startColor),
                            endColor = colorResource(item.endColor),
                            arrowColor = colorResource(item.endColor),
                            graphicsColor = colorResource(item.graphicColor),
                            modifier = Modifier
                                .padding(start = startIndexPadding, end = lastIndexPadding)
                        )

                    }

                }
            }

            Row(
                modifier = Modifier
                    .layoutId("quizCategories"),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    text = "Choose Categories",
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                    fontFamily = FontFamily(Font(R.font.nunito_sans_bold)),
                    color = colorResource(R.color.black),
                    modifier = Modifier
                )

                TextButton(
                    onClick = {},
                ) {
                    Text(
                        text = "See All",
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        fontFamily = FontFamily(Font(R.font.nunito_sans_bold)),
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.light_dark_blue),
                        modifier = Modifier
                    )
                }
            }

            LazyColumn (
                modifier = Modifier.layoutId("quizTypes"),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                itemsInPairsIndexed(state.quizTypeList) { index, item1, item2 ->


                    if(index == 0) {
                        Spacer(modifier = Modifier.height(20.dp))
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(40.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        ElevatedCard(
                            modifier = Modifier
                                .width(150.dp)
                                .height(150.dp)
                                .clickable {

                                },
                            shape = RoundedCornerShape(8.dp),
                            elevation = CardDefaults.elevatedCardElevation(10.dp),
                            colors = CardDefaults.elevatedCardColors(
                                containerColor = Color.White
                            )
                        ) {
                            ConstraintLayout(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                val (image, title) = createRefs()
                                val bottomGuideline = createGuidelineFromBottom(0.18f)

                                Text(
                                    text = item1.type.toString(),
                                    modifier = Modifier.constrainAs(title) {
                                        top.linkTo(bottomGuideline)
                                        bottom.linkTo(parent.bottom)
                                        start.linkTo(parent.start)
                                        end.linkTo(parent.end)

                                        verticalBias = 0.0f
                                    },
                                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                                    fontFamily = FontFamily(Font(R.font.nunito_sans_bold)),
                                    textAlign = TextAlign.Center,
                                    color = colorResource(item1.typeColor)
                                )
                            }
                        }

                        if(item2 != null) {
                            ElevatedCard(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(150.dp)
                                    .clickable {

                                    },
                                shape = RoundedCornerShape(8.dp),
                                elevation = CardDefaults.elevatedCardElevation(10.dp),
                                colors = CardDefaults.elevatedCardColors(
                                    containerColor = Color.White
                                )
                            ) {
                                ConstraintLayout(
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    val (image, title) = createRefs()
                                    val bottomGuideline = createGuidelineFromBottom(0.18f)

                                    Text(
                                        text = item2.type.toString(),
                                        modifier = Modifier.constrainAs(title) {
                                            top.linkTo(bottomGuideline)
                                            bottom.linkTo(parent.bottom)
                                            start.linkTo(parent.start)
                                            end.linkTo(parent.end)

                                            verticalBias = 0.0f
                                        },
                                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                                        fontFamily = FontFamily(Font(R.font.nunito_sans_bold)),
                                        textAlign = TextAlign.Center,
                                        color = colorResource(item2.typeColor)
                                    )
                                }
                            }
                        }
                    }

                    if(index == state.quizTypeList.lastIndex) {
                        Spacer(modifier = Modifier.height(60.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun homeScreenCompactLayout() = ConstraintSet {
    val topAppBar = createRefFor("topAppBarUser")
    val userMenu = createRefFor("userMenu")
    val quizCategories = createRefFor("quizCategories")
    val quizTypes = createRefFor("quizTypes")

    val topGuideline = createGuidelineFromTop(0.3f)
    val secondTopGuideline = createGuidelineFromTop(0.17f)
    val thirdTopGuideline = createGuidelineFromTop(0.5f)
    val startGuideline = createGuidelineFromStart(0.05f)
    val endGuideline = createGuidelineFromEnd(0.05f)
    val bottomGuideline = createGuidelineFromBottom(0.0f)


    constrain(topAppBar) {
        width = Dimension.fillToConstraints
        height = Dimension.fillToConstraints

        top.linkTo(parent.top)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        bottom.linkTo(topGuideline)

        verticalBias = 0.0f

    }


    constrain(userMenu) {
        width = Dimension.wrapContent
        height = Dimension.wrapContent

        top.linkTo(secondTopGuideline)
        bottom.linkTo(thirdTopGuideline)
        start.linkTo(parent.start)
        end.linkTo(parent.end)

    }

    constrain(quizCategories) {
        width = Dimension.fillToConstraints
        height = Dimension.wrapContent

        top.linkTo(userMenu.bottom)
        bottom.linkTo(parent.bottom)
        start.linkTo(startGuideline)
        end.linkTo(endGuideline)

        verticalBias = 0.05f
        horizontalBias = 0.0f
    }

    constrain(quizTypes) {
        width = Dimension.fillToConstraints
        height = Dimension.fillToConstraints

        top.linkTo(quizCategories.bottom)
        start.linkTo(startGuideline)
        end.linkTo(endGuideline)
        bottom.linkTo(bottomGuideline)

        verticalBias = 0.0f
    }

}
