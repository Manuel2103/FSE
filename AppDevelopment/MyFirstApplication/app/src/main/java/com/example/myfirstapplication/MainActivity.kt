package com.example.myfirstapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstapplication.ui.theme.MyFirstApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstApplicationTheme {
                var name by remember {
                    mutableStateOf("")
                }
                var names by remember {
                    mutableStateOf(listOf<String>())
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = name,
                            onValueChange = { text ->
                                name = text
                            },
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(onClick = {
                            if (name.isNotBlank()) {
                                names = names + name
                                name = ""
                            }

                        }) {
                            Text(text = "Add")
                        }
                    }
                    NameList(names = names)


                }

                //Greeting("Android")
                /*
                var count by remember {
                    mutableStateOf(0)
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = count.toString(),
                        fontSize = 30.sp
                    )
                    Button(onClick = {
                        count++
                    }){
                        Text(text = "Click me!")
                    }
                    
                }*/
            }
        }
    }

    //Funktion für die List der Namen
    @Composable
    fun NameList(
        names: List<String>,
        modifier: Modifier = Modifier
    ) {
        LazyColumn(modifier) {
            items(names) { currenName ->
                Text(
                    text = currenName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                Divider()
            }
        }
    }
}


/*
@Composable
fun Greeting(name: String) {
    //Funktionen (Composeables) werden nacheinander ausgeführt
    //Neben einer Colum gibt es auch eine Row oder eine Box
    /*
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .size(400.dp)
    ) {
        Text(
            text = "Hello $name!",
            color = Color.Blue,
            fontSize = 30.sp,
            //Bei dem Modifier werden die Eigenschaft nacheinander ausgeführt
            /*modifier = Modifier
                .background(Color.Red)
                .padding(16.dp)
                .background(Color.Green)*/
        )
        Text(
            text = "Some other Text",
            color = Color.Blue,
            fontSize = 30.sp,
        )
    }
     */
    /*Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = null
    )*/
    /*
    Column {
        if (name.length > 5) {
            for (i in 1..10)
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
        }
    }
    */
    //Auch hier gibt es eine LazyRow
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(10){
            i->Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        }

    }



}
*/
/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstApplicationTheme {
        Greeting("Manuel")
    }
}*/
