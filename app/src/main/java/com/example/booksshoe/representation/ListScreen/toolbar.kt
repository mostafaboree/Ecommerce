package com.example.booksshoe.representation.ListScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eCommerce.R



@Composable
fun ToolBar(name: String, massage: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp), verticalAlignment =Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.electronic), contentDescription = "",
            modifier = Modifier
                .clip(CircleShape)
                .size(50.dp)
                .border(1.dp, color = Color.DarkGray, CircleShape)
        )
        Column(Modifier.padding(start = 5.dp)) {
            Text(
                text = massage,

                fontSize = 10.sp,
            )
            Text(text = "$name!",
                    fontWeight = FontWeight.Bold,
                fontSize = 20.sp)
        }}

        Icon(imageVector = Icons.Outlined.Notifications, contentDescription = " ",
            modifier = Modifier.background(Color.LightGray, CircleShape).size(40.dp).padding(5.dp))

    }
}