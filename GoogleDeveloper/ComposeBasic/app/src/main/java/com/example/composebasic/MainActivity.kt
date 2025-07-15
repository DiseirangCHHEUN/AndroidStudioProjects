package com.example.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.composebasic.ui.theme.ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBasicTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    Article(
                        stringResource(R.string.jetpack_compose_tutorial),
                        stringResource(R.string.jetpack_compose_tutorial_subtitle),
                        stringResource(R.string.jetpack_compose_tutorial_content)
                    )
                }
            }
        }
    }
}
@Composable
fun ArticleImage(image : Painter){
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Fit,
        )
}
@Composable
fun Article(title : String,subTitle : String,content : String) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column (
        verticalArrangement = Arrangement.Top,
    ){
        ArticleImage(image)
        Text(
            text = title,
            modifier = Modifier
                .padding(16.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            subTitle,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    ),
            textAlign = TextAlign.Justify,
            )
        Text(
            content,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicTheme {
        Article(
            stringResource(R.string.jetpack_compose_tutorial),
            stringResource(R.string.jetpack_compose_tutorial_subtitle),
            stringResource(R.string.jetpack_compose_tutorial_content)
        )
    }
}