package com.xenia.englishusingflashcards.presentation.category_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xenia.englishusingflashcards.R

@Composable
fun CategoryListItem(image: String, categoryName: String, percent: Float) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 20.dp,
                end = 20.dp,
                bottom = 10.dp
            )
            .clip(RoundedCornerShape(25.dp))
            .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(25.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.Start) {
            Image(painter = painterResource(id = R.drawable.test_compressed), contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .weight(0.5f)
            )
            Column (modifier = Modifier
                .padding(start = 20.dp, top = 15.dp, end = 10.dp)
                .weight(1.4f)) {
                Text(
                    modifier = Modifier.padding(bottom = 2.dp),
                    text = categoryName,
                    fontSize = 20.sp
                )

                SetProgressBar(percent.toInt())
            }
            IconButton(onClick = {

            },
                modifier = Modifier
                    .size(50.dp)
                    .fillMaxHeight()
                    .align(Alignment.CenterVertically)
                    .clip(RoundedCornerShape(25.dp))
                    .weight(0.3f)
            ) {
                Icon(imageVector = Icons.Filled.Edit, contentDescription = "Edit"
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}