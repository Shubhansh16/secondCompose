package com.example.secondcompose

import android.graphics.Paint.Align
import android.graphics.fonts.Font
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.secondcompose.ui.theme.SecondComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeArticleApp()
                }
            }
        }
    }
}


@Composable
fun ComposeArticleApp(){
    ArticleCard(
        title = stringResource(R.string.title),
        shortDescription = stringResource(R.string.shortDescription),
        longDescription= stringResource(R.string.longDescription),
        imagePainter = painterResource(R.drawable.bg_compose_background)
    )
}

@Composable
fun ArticleCard(title: String, shortDescription: String, longDescription:String, imagePainter:Painter, modifier: Modifier=Modifier) {
    Column(modifier=modifier) {
        Image(painter = imagePainter, contentDescription = null)
        Text(text = title,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = shortDescription,
            modifier=Modifier.padding(start=16.dp, end= 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text=longDescription,
            modifier=Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeArticleAppPreview() {
    SecondComposeTheme {
        ComposeArticleApp()
    }
}