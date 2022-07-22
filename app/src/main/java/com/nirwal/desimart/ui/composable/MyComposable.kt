package com.nirwal.desimart.ui.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.Modifier.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nirwal.desimart.R

@Composable
fun MyTopAppBar(title:String){
    TopAppBar(
        title = { Text(text = title) },
        backgroundColor = Color.White,
        elevation = 4.dp,
    )
}

@Composable
fun AddRemoveItemBtnGrp(modifier: Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {  },
            modifier = Modifier
                .then(Modifier.size(16.dp))
                .border(1.dp, MaterialTheme.colors.primary, shape = CircleShape)
        ) {
            Icon(Icons.Default.Add, contentDescription = "content description", tint = MaterialTheme.colors.primary)
        }
        Text(text ="11111", fontWeight = FontWeight.Bold)

        IconButton(onClick = {  },
            modifier = Modifier
                .then(Modifier.size(16.dp))
                .border(1.dp, MaterialTheme.colors.primary, shape = CircleShape)
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_remove_24), contentDescription = "content description", tint = MaterialTheme.colors.primary)
        }

    }
}