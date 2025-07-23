package com.diseirang.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.diseirang.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeCard(
    imageResourceId: Int,
    descriptionResourceId: Int,
    labelResourceId: Int,
    onImageClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onImageClick,
            shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
        ) {
            Image(
                painter = painterResource(imageResourceId),
                contentDescription = stringResource(descriptionResourceId),
                modifier = Modifier
                    .width(dimensionResource(R.dimen.button_image_width))
                    .height(dimensionResource(R.dimen.button_image_height))
                    .padding(dimensionResource(R.dimen.button_interior_padding))
            )
        }
        Spacer(Modifier.height(dimensionResource(R.dimen.vertical_padding)))
        Text(stringResource(labelResourceId), style = MaterialTheme.typography.bodyLarge)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {
    var currentStep by remember { mutableIntStateOf(1) }
    var squeezeCount by remember { mutableIntStateOf(0) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Lemonade", fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            )
        }) { innerPadding ->
        Surface(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {

            when (currentStep) {
                1 -> LemonadeCard(
                    imageResourceId = R.drawable.lemon_tree,
                    descriptionResourceId = R.string.lemon_tree_description,
                    labelResourceId = R.string.lemon_select,
                    onImageClick = {
                        currentStep = 2
                        squeezeCount = (2..4).random()

                    })

                2 -> LemonadeCard(
                    imageResourceId = R.drawable.lemon_squeeze,
                    descriptionResourceId = R.string.lemon_select,
                    labelResourceId = R.string.lemon_squeeze,
                    onImageClick = {
                        squeezeCount--
                        if (squeezeCount == 0) {
                            currentStep = 3
                        }
                    })

                3 -> LemonadeCard(
                    imageResourceId = R.drawable.lemon_drink,
                    descriptionResourceId = R.string.lemon_glass_description,
                    labelResourceId = R.string.lemon_drink,
                    onImageClick = {
                        currentStep = 4
                    })

                4 -> LemonadeCard(
                    imageResourceId = R.drawable.lemon_restart,
                    descriptionResourceId = R.string.lemon_empty_description,
                    labelResourceId = R.string.lemon_empty,
                    onImageClick = {
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
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}