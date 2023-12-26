package com.xenia.englishusingflashcards.screens.main_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.xenia.englishusingflashcards.R
import com.xenia.englishusingflashcards.navigation.NavigationItem
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource

private val TextColors = listOf(
    Color(0xFF03045E),
    Color(0xFF0077B6),
    Color(0xFF00B4D8),
    Color(0xFF90E0EF),
    Color(0xFFCAF0F8),
)

private val backgroundColors = listOf(
    Color(0xFF03045E),
    Color(0xFF0077B6),
    Color(0xFF00B4D8),
    Color(0xFF90E0EF),
    Color(0xFFCAF0F8),
)


@Composable
fun MainScreen(navController : NavController) {
    val boxSize = with(LocalDensity.current) { 200.dp.toPx() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
//            .background(
//                brush = Brush.linearGradient(
//                    colors = backgroundColors,
//                    start = Offset(0f, 0f), // top left corner
//                    end = Offset(boxSize, boxSize) // bottom right corner
//                )
//            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            IconButton(
                onClick = {

                },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
            }
            Text(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 7.dp),
                text = "Главная",
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier.padding(10.dp),
            text = "Привет!",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 30.sp
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly)
        {
            Card("0", "учить")
            Card("0", "знаю")
            Card("0", "выучено")
        }

        Spacer(modifier = Modifier.height(136.dp))
        ButtonMain(navController, NavigationItem.LearningCard.route, "Настройка уведомлений")
        ButtonMain(navController, NavigationItem.Category.route, "Пополнение папки слов")
        ButtonMain(navController, NavigationItem.LearningCard.route, "Обучение")

        Spacer(modifier = Modifier.height(120.dp))
        Text(
            text = "created by xemura",
            textAlign = TextAlign.Center,
            color = Color.Gray,
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 15.sp
        )
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen(navController = rememberNavController())
}

@Composable
fun ButtonMain(navController: NavController, navigationItemRoute: String, text: String) {
    Button(
        onClick = {
            navController.navigate(navigationItemRoute) {
                popUpTo(NavigationItem.Main.route) {
                    inclusive = true
                }
            }
        },
        Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 10.dp),
        shape = RoundedCornerShape(25.dp),
        border = BorderStroke(1.dp, Color.Black),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(205, 229, 235, 255),
            contentColor = Color.Black)
    ){
        Text(
            text,
            fontSize = 16.sp,
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}
@Composable
fun Card(countWordsText : String, cardText: String) {
    Column {
        Box(modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(25.dp))
            .background(Color.White)
            .height(100.dp)
            .width(100.dp)
        ) {
            IconButton(
                onClick = {

                },
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
            Text(
                countWordsText,
                style = TextStyle(
                    brush = Brush.linearGradient(
                        colors = TextColors,
                        tileMode = TileMode.Mirror
                    ),
                    fontSize = 45.sp,
                    fontFamily = FontFamily(Font(R.font.comfortaa_regular))
                ),
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = cardText,
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 15.sp
        )
    }
}