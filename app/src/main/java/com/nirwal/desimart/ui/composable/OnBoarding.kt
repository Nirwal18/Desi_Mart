package com.nirwal.desimart.ui.composable

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.ButtonDefaults.outlinedButtonColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.nirwal.desimart.MyDataStore
import com.nirwal.desimart.model.OnBoardingData
import com.nirwal.desimart.model.onBoardingDataItems
import com.nirwal.desimart.ui.navigation.MyNavGraph
import com.nirwal.desimart.ui.theme.BottomCardShape
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun OnBoardingDataPreview() {
    OnBoardingPage(rememberNavController())
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPage(navController:NavHostController){
    val dataStore = MyDataStore(LocalContext.current)
    val scope = rememberCoroutineScope()
   Surface(modifier = Modifier.fillMaxSize()) {
       val items = onBoardingDataItems()
       val pagerState = rememberPagerState(initialPage = 0)

       OnBoardingPager(
           items = items,
           pagerState = pagerState,
           modifier = Modifier.fillMaxWidth(),
           onFinish = {
               scope.launch {
                   dataStore.saveBoolean("is_first_time",false)
               }
               navController.popBackStack()
               navController.navigate(MyNavGraph.MainScreen.route)
           }
       )
   }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPager(
    items: ArrayList<OnBoardingData>,
    pagerState: PagerState,
    modifier: Modifier,
    onFinish: () -> Unit
) {

    Box(modifier = modifier){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(
                state= pagerState,
                count = items.size
            ) {
                page ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(items[page].backgroundColor),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Image(
                        modifier = Modifier.fillMaxWidth(),
                        painter = painterResource(id = items[page].image),
                        contentDescription = "",
                        contentScale = ContentScale.FillWidth
                    )
                }

            }

            
            

        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            Card(
                backgroundColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(340.dp),
                elevation = 0.dp,
                shape = BottomCardShape.large
            ){
                Box{
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        PagerIndicator(items = items, currentPage = pagerState.currentPage)
                        Text(
                            text = items[pagerState.currentPage].title,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp, end = 30.dp),
                            color = items[pagerState.currentPage].mainColor,
                            textAlign = TextAlign.Right,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Text(
                            text = items[pagerState.currentPage].desc,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp, start = 30.dp, end = 30.dp),
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.ExtraLight
                        )
                        
                    }

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(30.dp)
                    ){
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            val scope = rememberCoroutineScope()

                            if (pagerState.currentPage!=2){

                                TextButton(onClick = {
                                        scope.launch {
                                            pagerState.scrollToPage(2)
                                        }
                                }) {
                                    Text(
                                        text = "Skip Now",
                                        color = Color(0xFF292D32),
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 14.sp,
                                        textAlign = TextAlign.Right
                                    )
                                }


                                OutlinedButton(
                                    onClick = {
                                        scope.launch {
                                            pagerState.scrollToPage(pagerState.currentPage+1)
                                        }

                                    },
                                    border = BorderStroke(14.dp,items[pagerState.currentPage].mainColor),
                                    shape = RoundedCornerShape(50),
                                    colors = outlinedButtonColors(
                                        contentColor = items[pagerState.currentPage].mainColor
                                    ),
                                    modifier = Modifier.size(65.dp)
                                ) {
                                    Icon( imageVector = Icons.Default.KeyboardArrowRight,
                                        contentDescription = "",
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            }
                            else{
                                Button(
                                    onClick = {onFinish()},
                                    colors= buttonColors(
                                        backgroundColor = items[pagerState.currentPage].mainColor
                                    ),
                                    contentPadding = PaddingValues(vertical = 12.dp),
                                    elevation = ButtonDefaults.elevation(
                                        defaultElevation = 0.dp
                                    ),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = "Get Started",
                                        color = Color.White,
                                        fontSize = 16.sp
                                    )
                                }
                            }

                        }
                    }
                }
            }
        }
    }

}


@Composable
fun PagerIndicator(items: List<OnBoardingData>, currentPage: Int) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top= 20.dp)
    ){
        repeat(items.size){
            Indicator(
                isSelected = it == currentPage,
                color = items[it].mainColor
            )
        }
    }
}

@Composable
fun Indicator(isSelected :Boolean, color :Color) {
    val width = animateDpAsState(targetValue = if(isSelected) 40.dp else 10.dp)

    Box(
        modifier = Modifier
            .padding(4.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(if (isSelected) color else Color.Gray.copy(alpha = .5f))

    )
}





