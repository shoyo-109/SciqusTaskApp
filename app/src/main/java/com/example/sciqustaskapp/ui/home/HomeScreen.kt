package com.example.sciqustaskapp.ui.home

//import android.graphics.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sciqustaskapp.Greeting
import com.example.sciqustaskapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                //Container1
                Text(
                        "Yoo, this is Bhubhurv ... Thank you for having me.",
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(BorderStroke(1.dp, Color.Gray), RoundedCornerShape(8.dp))
                            .padding(16.dp)
                    )


            }

            item {
                Container2()
            }

            item {
                Text("Task 3 todo")
            }

            item {
                Container4()
            }

            item {
                Container5()
            }

            item {
                Text("Task 4 todo")
            }
        }
    }
}



@Composable
fun Container2() {
    Text(
        text = "THis goes for 2nd",
        modifier = Modifier.fillMaxSize().padding(16.dp)
    )

}

@Composable
fun Container4() {

    Column {
        //Image(R.drawable.image_1, contentDescription = "image_1)
    }

}

@Composable
fun Container5() {

}