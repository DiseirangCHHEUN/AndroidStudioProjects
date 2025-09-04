package com.diseirang.artspace

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.diseirang.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    Modifier.fillMaxSize()
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEFEFEF))
            .padding(16.dp),
//        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val padding = 20.dp

        var currentImageIndex by remember { mutableIntStateOf(0) }

        var currentImage = R.drawable.image_1
        var currentTitle = R.string.title_1
        var currentDescription = R.string.description_1

        when (currentImageIndex) {
            0 -> {
                currentImage = R.drawable.image_1
                currentTitle = R.string.title_1
                currentDescription = R.string.description_1
            }

            1 -> {
                currentImage = R.drawable.image_2
                currentTitle = R.string.title_2
                currentDescription = R.string.description_2
            }

            2 -> {
                currentImage = R.drawable.image_3
                currentTitle = R.string.title_3
                currentDescription = R.string.description_3
            }

            3 -> {
                currentImage = R.drawable.image_4
                currentTitle = R.string.title_4
                currentDescription = R.string.description_4
            }

            4 -> {
                currentImage = R.drawable.image_5
                currentTitle = R.string.title_5
                currentDescription = R.string.description_5
            }

            5 -> {
                currentImage = R.drawable.image_6
                currentTitle = R.string.title_6
                currentDescription = R.string.description_6
            }
        }

        ShadowedImageBox(imageRes = currentImage)
        Spacer(Modifier.size(padding))
        // Artwork Image Placeholder
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(top = padding, bottom = padding),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = stringResource(currentTitle),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(currentDescription),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(Modifier.size(padding))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CommonButton(
                onClick = {
                    if (currentImageIndex > 0) {
                        currentImageIndex--
                    }
                    else{
                        currentImageIndex =5
                    }
                },
                buttonText = "Previous"
            )
            CommonButton(
                onClick = {
                    if (currentImageIndex <= 4) {
                        currentImageIndex++
                    }
                    else{
                        currentImageIndex =0
                    }

                },
                buttonText = "Next"
            )
        }
    }
}

@Composable
fun CommonButton(

    onClick: () -> Unit,
    buttonText: String
) {
    androidx.compose.material3.Button(
        onClick = onClick, modifier = Modifier.width(150.dp)
    ) {
        Text(buttonText)
    }
}

@Composable
fun ShadowedImageBox(imageRes: Int) {
    Box(
        modifier = Modifier
            .padding(10.dp) // Padding from the screen edge
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(15.dp),
                clip = false
            )
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .padding(12.dp) // Inner padding inside the box
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Artwork",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .clip(RoundedCornerShape(9.dp))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}