package com.portfolio.quizapp.presentation.home.components

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable

fun <T> LazyListScope.itemsInPairsIndexed(
    items: List<T>,
    itemContent: @Composable (index: Int, item1: T, item2: T?) -> Unit
) {
    val pairCount = (items.size + 1) / 2
    items(pairCount) { pairIndex ->
        val firstIndex = pairIndex * 2
        val secondIndex = firstIndex + 1

        val item1 = items[firstIndex]
        val item2 = items.getOrNull(secondIndex)

        itemContent(firstIndex, item1, item2)
    }
}
