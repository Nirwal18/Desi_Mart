package com.nirwal.desimart.ui.composable.shop

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nirwal.desimart.R
import com.nirwal.desimart.model.CategoryItem

@Preview(showBackground = true)
@Composable
fun CategoryScreen() {
    Column(modifier = Modifier.fillMaxSize()){
        CategoryHeader()
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .background(Color.LightGray),
            text = "All Categories"
        )
        CategoryListsView()
    }
}

@Composable
fun CategoryHeader(){
    TopAppBar(
        title = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription =null )
            }
            Text(
                text = "Categories",
                modifier = Modifier.fillMaxWidth(),
            )
                },
        backgroundColor = Color.White,
        elevation = 4.dp,
    )
}

@Composable
fun CategoryListsView() {
    val categoryItems = listOf(
        CategoryItem(
            name = "Groceries",
            imageResource =  R.drawable.item_apple,
            productCount = 10
        ),
        CategoryItem(
            name = "Premium Fruits",
            imageResource =  R.drawable.ic_meat,
            productCount = 5
        ),
        CategoryItem(
            name = "Home & Kitchen",
            imageResource =  R.drawable.ic_meat,
            productCount = 21
        ),

        CategoryItem(
            name = "Fashion",
            imageResource =  R.drawable.ic_meat,
            productCount = 21
        ),

        CategoryItem(
            name = "Electronics",
            imageResource =  R.drawable.ic_meat,
            productCount = 21
        )


    )


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(categoryItems.size){ it ->
            CategoryItemView(title = categoryItems[it].name, iconUrl = "", onExpand = {})
        }
    }
}

@Composable
fun CategoryItemView(title:String, iconUrl:String,onExpand:()->Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(72.dp),
            painter = painterResource(id = R.drawable.promotion),
            contentDescription = null
        )
        Text(modifier = Modifier
            .weight(1f)
            .padding(start = 16.dp),
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.KeyboardArrowDown , contentDescription = null)
        }
    }
    Spacer(modifier = Modifier
        .padding(start = 16.dp, end = 16.dp)
        .fillMaxWidth()
        .height(1.dp)
        .background(Color.Black.copy(alpha = 0.2f))
    )
    ExpandableView(answerText = "heloofsjh\nadsd\nsdddsd\n", isExpanded = true)
}

@Composable
fun ExpandableView(answerText: String, isExpanded: Boolean) {
    // Opening Animation
    val expandTransition = remember {
        expandVertically(
            expandFrom = Alignment.Top,
            animationSpec = tween(300)
        ) + fadeIn(
            animationSpec = tween(300)
        )
    }

    // Closing Animation
    val collapseTransition = remember {
        shrinkVertically(
            shrinkTowards = Alignment.Top,
            animationSpec = tween(300)
        ) + fadeOut(
            animationSpec = tween(300)
        )
    }

    AnimatedVisibility(
        visible = isExpanded,
        enter = expandTransition,
        exit = collapseTransition
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .padding(15.dp)
        ) {
            Text(
                text = answerText,
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ExpandableViewPreview() {
    ExpandableView("Answer", true)
}