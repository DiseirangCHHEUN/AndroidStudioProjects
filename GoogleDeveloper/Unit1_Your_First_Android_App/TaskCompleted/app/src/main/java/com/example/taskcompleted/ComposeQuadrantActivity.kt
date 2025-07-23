package com.example.taskcompleted

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ComposeQuadrantActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            Surface(
                Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                ComposableGrid()
            }
        }
    }
}

@Composable
fun ComposableGrid() {
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            ComposableCard(
                stringResource(R.string.first_title),
                stringResource(R.string.first_description),
                backgroundColor = Color(0xFFEADDFF),
                Modifier.weight(1f)
            )
            ComposableCard(
                stringResource(R.string.second_title),
                stringResource(R.string.second_description),
                backgroundColor = Color(0xFFD0BCFF),
                Modifier.weight(1f),
                titleColor = Color.White
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableCard(
                stringResource(R.string.third_title),
                stringResource(R.string.third_description),
                backgroundColor = Color(0xFFB69DF8),
                Modifier.weight(1f),
                titleColor = Color.White
            )
            ComposableCard(
                stringResource(R.string.fourth_title),
                stringResource(R.string.fourth_description),
                backgroundColor = Color(0xFFF6EDFF),
                Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ComposableCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    titleColor: Color = Color.Black
) {
    Box(
        modifier = modifier
            .background(backgroundColor)
            .padding(16.dp)
            .fillMaxSize(),
        Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp),
                color = titleColor
            )
            Text(
                description,
                textAlign = TextAlign.Justify,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposableGridPreview() {
    ComposableGrid()
}