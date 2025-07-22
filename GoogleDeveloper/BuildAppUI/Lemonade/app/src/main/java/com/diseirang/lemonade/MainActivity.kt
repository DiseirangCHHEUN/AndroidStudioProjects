package com.diseirang.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.diseirang.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Lemonade()
            }
        }
    }
}

@Composable
fun LemonadeCard(
    modifier: Modifier = Modifier,
    imageResource: Painter,
    description: String,
    label: String,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = imageResource,
            contentDescription = description,
            modifier = Modifier
                .wrapContentSize()
                .clickable(onClick = onClick),
        )
        Spacer(Modifier.height(16.dp))
        Text(label)
    }
}

@Composable
fun Lemonade(modifier: Modifier = Modifier) {
    Surface(
        modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        var currentStep by remember { mutableIntStateOf(1) }

        when (currentStep) {
            1 -> LemonadeCard(
                modifier,
                painterResource(R.drawable.lemon_tree),
                description = stringResource(R.string.lemon_tree_description),
                label = stringResource(R.string.lemon_select),
                onClick = {
                    currentStep = 2
                })

            2 -> LemonadeCard(
                modifier,
                painterResource(R.drawable.lemon_squeeze),
                description = stringResource(R.string.lemon_select),
                label = stringResource(R.string.lemon_squeeze),
                onClick = {
                    currentStep = 3
                })

            3 -> LemonadeCard(
                modifier,
                painterResource(R.drawable.lemon_drink),
                description = stringResource(R.string.lemon_glass_description),
                label = stringResource(R.string.lemon_drink),
                onClick = {
                    currentStep = 4
                })

            4 -> LemonadeCard(
                modifier,
                painterResource(R.drawable.lemon_restart),
                description = stringResource(R.string.lemon_empty_description),
                label = stringResource(R.string.lemon_empty),
                onClick = {
                    currentStep = 1
                })

        }


//        val imageResource = when(currentStep){
//            1 -> R.drawable.lemon_tree
//            2 -> R.drawable.lemon_squeeze
//            3 -> R.drawable.lemon_drink
//            else -> R.drawable.lemon_restart
//        }
//        val label = when(currentStep){
//            1 -> R.string.lemon_select
//            2 -> R.string.lemon_squeeze
//            3 -> R.string.lemon_drink
//            else -> R.string.lemon_empty
//        }
//
//        val description = when(currentStep){
//            1 -> R.string.lemon_tree_description
//            2 -> R.string.lemon_description
//            3 -> R.string.lemon_glass_description
//            else -> R.string.lemon_empty_description
//        }
//        Column(
//            modifier = modifier,
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally) {
//            Image(
//                painter = painterResource(imageResource),
//                contentDescription = stringResource(description),
//                modifier = Modifier.wrapContentSize().clickable(onClick = {
//                    if(currentStep in 1..3){
//                        currentStep ++
//                    }else{
//                        currentStep = 1
//                    }
//                }),
//            )
//            Spacer(Modifier.height(16.dp))
//            Text( stringResource(label))
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        Lemonade(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}