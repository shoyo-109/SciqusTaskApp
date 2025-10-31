package com.example.sciqustaskapp.ui.home

//import android.graphics.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.sciqustaskapp.Greeting
import com.example.sciqustaskapp.R
import kotlinx.coroutines.launch


private val carouselImages1 = listOf(
    R.drawable.diya_1,
    R.drawable.diya_2,
    R.drawable.diya_3
)

private val carouselImages2 = listOf(
    R.drawable.fireworks_1,
    R.drawable.fireworks_2,
    R.drawable.fireworks_3,
    R.drawable.fireworks_4,
    R.drawable.fireworks_5,
    R.drawable.fireworks_6

)
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
                Container1()
            }

            item {
                Text(
                    text = """
                Warm wishes for a joyous and prosperous Diwali to everyone at SCIQUS Infotech.
                Honored to share my creative work with your team during this festive season of innovation and light.
            """.trimIndent(),

                    modifier = Modifier.fillMaxWidth(), // Take up full width
                    textAlign = TextAlign.Left // Center this block
                )

            }

            item {
                // Container 3
                Container3()
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
fun Container1() {
    val pagerState = rememberPagerState(pageCount = { carouselImages1.size })

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp), // Give the carousel a fixed height
        // This adds 16dp of space on the sides
        contentPadding = PaddingValues(horizontal = 16.dp),
        // This adds 8dp of space *between* each image
        pageSpacing = 8.dp
    ) { pageIndex ->
        // 'pageIndex' is the current page (0, 1, or 2)

        Image(
            painter = painterResource(id = carouselImages1[pageIndex]),
            contentDescription = "Carousel Image",

            contentScale = ContentScale.Crop,

            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(16.dp))
        )
    }

}

@OptIn(ExperimentalFoundationApi::class) // You'll need this import
@Composable
fun Container3() {
    // 1. Get the pager state, same as Container 1
    // We'll re-use the same image list
    val pagerState = rememberPagerState(pageCount = { carouselImages2.size })

    // 2. Get a coroutine scope to launch the scroll animations
    val scope = rememberCoroutineScope()

    // 3. We use a Column to stack the Pager *on top* of the controls
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally // Center the controls
    ) {
        // 4. The Pager itself (identical to Container 1)
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            pageSpacing = 8.dp
        ) { pageIndex ->
            Image(
                painter = painterResource(id = carouselImages2[pageIndex]),
                contentDescription = "Interactive Slider Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp))
            )
        }

        // 5. Add a little space between pager and controls
        Spacer(modifier = Modifier.height(8.dp))

        // 6. Row to hold the control buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 7. "Back" Button
            IconButton(onClick = {
                // 8. Launch an animation to scroll
                scope.launch {
                    // Calculate the previous page index, wrapping around
                    val newPage = if (pagerState.currentPage > 0) {
                        pagerState.currentPage - 1
                    } else {
                        carouselImages2.size - 1 // Go to the last page
                    }
                    pagerState.animateScrollToPage(newPage)
                }
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Previous"
                )
            }

            // 9. Page indicator text (e.g., "2 / 3")
            Text(
                text = "${pagerState.currentPage + 1} / ${carouselImages2.size}",
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            // 10. "Next" Button
            IconButton(onClick = {
                scope.launch {
                    // Calculate the next page index, wrapping around
                    val newPage = if (pagerState.currentPage < carouselImages2.size - 1) {
                        pagerState.currentPage + 1
                    } else {
                        0 // Go to the first page
                    }
                    pagerState.animateScrollToPage(newPage)
                }
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Next"
                )
            }
        }
    }
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