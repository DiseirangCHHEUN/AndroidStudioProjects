package com.example.taskcompleted

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface (
                Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ){
                ScreenShot(
                    stringResource(R.string.all_tasks_completed),
                    stringResource(R.string.nice_work)
                )
            }
        }
    }
}

@Composable
fun ScreenShot(completedTaskText : String, niceWorkText : String, modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        , modifier = modifier
    ){
        Image(
            painter = painterResource(R.drawable.ic_task_completed),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            )
        Text(
            completedTaskText,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(
                top = 24.dp,
                bottom = 8.dp,
                )
            )
        Text(
            niceWorkText,
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskCompletedPreview() {
    ScreenShot(
        "All tasks completed",
        "Nice work!"
    )
}