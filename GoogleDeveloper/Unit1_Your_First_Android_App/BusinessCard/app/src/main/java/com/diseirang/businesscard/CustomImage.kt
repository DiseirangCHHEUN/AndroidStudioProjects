package com.diseirang.businesscard

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

@Composable
fun CImage(painter: Painter, contentScale: ContentScale, contentDescription: String? = null) {
    Image(
        painter = painter, contentScale = contentScale, contentDescription = contentDescription
    )
}