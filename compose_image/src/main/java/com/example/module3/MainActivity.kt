package com.example.module3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.module3.ui.img.*
import com.example.module3.ui.theme.MyComposeTheme

var list = mutableStateListOf<Int>()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // A surface container using the 'background' color from the theme
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier.padding(16.dp),
//        verticalArrangement = Arrangement.SpaceAround,
//        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        GifSection()
        TwoButtons()
    }
}

@Composable
fun GifSection() {
//    Surface(
//        modifier = Modifier
//            .fillMaxHeight(0.95F)
//            .fillMaxWidth(),
//    )
//    {
//        val width = 1000
//        val height = 1000
//        val defaultId = 1025
//        if (list.isEmpty()) {
//            list.add(defaultId)
//        }
//
////        ImgTextStab("https://picsum.photos/id/${list.last()}/$width/$height")
//        ImgCoil("https://picsum.photos/id/${list.last()}/$width/$height")
//    }

    Box(Modifier.fillMaxSize(0.9f),contentAlignment = Alignment.Center){
        val width = 1000
        val height = 1000
        val defaultId = 1025
        if (list.isEmpty()) {
            list.add(defaultId)
        }
        ImgCoilExt("https://picsum.photos/id/${list.last()}/$width/$height")
    }

}


@Composable
fun TwoButtons() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp), elevation = 16.dp
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically

//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight()
        ) {
            BackBtn()
            NextBtn()
        }
    }
}

@Composable
fun NextBtn() {
    Button(
        onClick = { list.add(list.size) },
        modifier = Modifier.wrapContentSize()
    ) {
        Text(text = "Next")
    }
}

@Composable
fun BackBtn() {
    Button(
        onClick = {
            if (list.isNotEmpty())
                list.remove(list.last())
        },
        modifier = Modifier.wrapContentSize()
    ) {
        Text(text = "Back")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeTheme {
        MainScreen()
    }
}