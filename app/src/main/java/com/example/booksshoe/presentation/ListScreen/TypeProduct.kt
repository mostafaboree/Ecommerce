package com.example.booksshoe.presentation.ListScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.BottomAppBarDefaults.ContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.BookShoe.R
import com.example.booksshoe.data.Category

@SuppressLint("RememberReturnType")
@Composable
fun TypeProduct(listType: List<Category>, onSelected: () -> Unit) {
    var selected  by remember{ mutableStateOf(false) }

    LazyRow(modifier = Modifier.fillMaxWidth(), contentPadding = ContentPadding) {
        items(listType) { item ->

            ItemSelect(item, onSelected)

        }
    }
    }
@Composable
private fun ItemSelect(item:Category,onSelect: () -> Unit) {
    var selected by remember { mutableStateOf(false) }
    Column(verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally
        ,
        modifier = Modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (selected) Color.DarkGray else Color.White,
            )
            .clickable {
                onSelect()
            }
    ) {
        Image(
            painter = painterResource(item.image), contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape)
        )



        Text(
            text = item.name, modifier = Modifier
                .clickable { selected = !selected }
                .padding(horizontal = 20.dp, vertical = 5.dp),
            textAlign = TextAlign.Center, color = if (selected) Color.White else Color.Black
        )


    }
}