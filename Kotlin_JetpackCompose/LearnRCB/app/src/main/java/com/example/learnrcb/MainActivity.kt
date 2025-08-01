package com.example.learnrcb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnrcb.ui.theme.LearnRCBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnRCBTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                     color = Color.Green
                    ) {
                    LearnRowColumnBox()
                }
            }
        }
    }
}

@Composable
fun LearnRowColumnBox(){
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(18.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center,
//    ) {
//        Text(text = "Hello Column")
//        Text(text = "Hello Row")
//        Text(text = "Hello Box")
//    }
/*    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)
            .padding(horizontal = 18.dp, vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,

    ) {
        Text(text = "Hello Column")
        Text(text = "Hello Row")
        Text(text = "Hello Box")
    }
 */

    Box(
        modifier = Modifier.fillMaxSize().background(Color.Green),
        contentAlignment = Alignment.Center,
        ){
        Box(
            modifier = Modifier.height(300.dp)
                .width(300.dp)
                .background(Color.Blue),

        ){
            Text(
                text = "Hello Box",
                modifier = Modifier.align(Alignment.Center),
                color = Color.White,
                fontSize = 32.sp
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnRCBTheme {
        LearnRowColumnBox()
    }
}