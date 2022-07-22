package com.nirwal.desimart.ui.composable


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.nirwal.desimart.R
import com.nirwal.desimart.model.CategoryItem

@Preview(showBackground = true)
@Composable
fun CategoryPage() {
    Column {
        CategoryHeader()
        Text(
            modifier = Modifier.padding(16.dp),
            text = "All Categories"
        )

        CategoryListsView()

    }



}

@Composable
fun CategoryHeader(){
    TopAppBar(
        title = {
            Text(
                text = "Categories",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
                },
        backgroundColor = Color.White,
        elevation = 4.dp,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryListsView() {
    val categoryItems = listOf(
        CategoryItem(
            name = "Pooja Need Samagri",
            imageResource =  R.drawable.item_apple,
            productCount = 10
        ),
        CategoryItem(
            name = "Baby Product",
            imageResource =  R.drawable.ic_meat,
            productCount = 5
        ),
        CategoryItem(
            name = "Dals & Pulses",
            imageResource =  R.drawable.ic_meat,
            productCount = 21
        ),


    )


//    LazyVerticalGrid(
//        //cells = GridCells.Adaptive(150.dp),
//        contentPadding = PaddingValues(16.dp),
//    ) {
//        items(categoryItems){ item ->
//            CategoryItemView(item = item)
//        }
//    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CategoryItemView(item: CategoryItem) {


    Card (
        Modifier
            .fillMaxSize().height(200.dp)
            .padding(8.dp)){
        ConstraintLayout(modifier = Modifier.fillMaxSize()){
            val (image,text) = createRefs()
            Image(
                modifier = Modifier.fillMaxSize()
                    .constrainAs(image){
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                painter = painterResource(id = R.drawable.promotion),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )

            Text(modifier = Modifier.fillMaxHeight(.3f)
                .fillMaxWidth()
                .constrainAs(text){
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                }
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color(0x9A000000)
                        )
                    )
                ),
                color = Color.White,
                textAlign = TextAlign.Center,
                style=MaterialTheme.typography.h6,
                text = item.name
            )
        }


    }
}

