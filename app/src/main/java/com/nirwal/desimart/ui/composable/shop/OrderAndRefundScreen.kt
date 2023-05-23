package com.nirwal.desimart.composable.shop

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch


@Preview(showBackground = true)
@Composable
fun OrderAndRefundScreenPreview() {
    OrderAndRefundScreen()
}

@Composable
fun OrderAndRefundScreen() {
    val tabs = listOf(
        TabRowItem(title = "Orders", null){
            OrderScreen()
        },
        TabRowItem(title = "Refunds", null){
            RefundScreen()
        }
    )
    MyTabLayout(tabItemList = tabs )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyTabLayout(tabItemList:List<TabRowItem>) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        tabItemList.size
    }

    val tabModifier = Modifier

    Column {
        TabRow(modifier = tabModifier, selectedTabIndex = pagerState.currentPage) {
            tabItemList.forEachIndexed { index, tabRowItem ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                    },
                    text = {
                        Text(text = tabRowItem.title)
                    },
                    //icon = {tabRowItem.icon?.let { Icon(imageVector = it, contentDescription = tabRowItem.title ) }}
                )
            }
        }

        HorizontalPager(
            state = pagerState,
        ) {
            tabItemList[pagerState.currentPage].screen()
        }
    }


}

data class TabRowItem(
    val title: String,
    val icon: ImageVector?,
    val screen: @Composable () -> Unit,
)
