package com.example.booksshoe.representation.ListScreen

import android.annotation.SuppressLint
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.BottomAppBarDefaults.ContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("RememberReturnType")
@Composable
fun TypeNote(onSelected: () -> Unit) {
    var selected  by remember{ mutableStateOf(false) }
    val listType= listOf("ALL","MAN","WOMAN","KID","OTHER")

    LazyRow(modifier = Modifier.fillMaxWidth(), contentPadding = ContentPadding) {
        items(listType) { item ->
            ItemSelect(item,onSelected)

        }

    }}
@Composable
private fun ItemSelect(item: String,onSelect: () -> Unit) {
    var selected  by remember{ mutableStateOf(false) }
    Box(
        modifier = Modifier
            .clickable {
                onSelect()
            }
            .padding(5.dp)
            .border(
                BorderStroke(
                    2.dp,
                    brush = Brush.verticalGradient(
                        if (selected) listOf(
                            Color.Magenta,
                            Color.White
                        ) else listOf(Color.LightGray, Color.White)
                    )
                ), shape = RoundedCornerShape(20.dp)
            )
    ) {
        Crossfade(targetState = selected) {
            if (it) {
                Text(text = item,
                    modifier = Modifier
                        .clickable {
                            selected = !selected

                        }
                        .background(
                            brush = Brush.verticalGradient(listOf(Color.Transparent, Color.White)),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(10.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 18.sp)
            } else

            {
                Text(text = item,
                    modifier = Modifier
                        .clickable {
                            selected = !selected
                        }

                        .padding(10.dp),
                    textAlign = TextAlign.Center,
                    color = Color.LightGray,
                    fontSize = 18.sp)

            }


        }
    }
}