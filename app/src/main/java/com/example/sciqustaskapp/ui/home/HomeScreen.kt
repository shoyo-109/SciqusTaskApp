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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
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
    // We'll use a Row to place items side-by-side
    Row(
        modifier = Modifier
            .fillMaxWidth()
            // Give it a background and rounded corners to look like a card
            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp)) // Clip the contents (like the image)
            .padding(16.dp), // Padding inside the card
        verticalAlignment = Alignment.CenterVertically // Center items vertically
    ) {
        // 1. The Image
        Image(
            painter = painterResource(id = R.drawable.fireworks_1),
            contentDescription = "Static content",
            modifier = Modifier
                .size(80.dp) // Make the image a fixed size
                .clip(CircleShape) // Clip the image into a circle
        )

        // 2. Spacer to add room between image and text
        Spacer(modifier = Modifier.width(16.dp))

        // 3. Column to stack the text vertically
        Column(modifier = Modifier.weight(1f)) { // 'weight(1f)' makes it fill the rest
            Text(
                text = """The Festival of Lights — Beyond Celebration""",
                style = MaterialTheme.typography.titleMedium // Use a pre-defined style
            )
            Text(
                text = """Diwali, also known as the Festival of Lights, symbolizes the victory of light over darkness, knowledge over ignorance, and hope over despair.

Traditionally, homes are adorned with diyas and rangolis — each flame representing positivity, unity, and renewal.

In many ways, Diwali reflects the same spirit found in innovation: illuminating new ideas, removing the darkness of limitations, and inspiring growth through creativity.

Just as every diya contributes to the festival’s brilliance, every line of thoughtful code contributes to the brilliance of technology.""",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun Container5() {

    @Composable
    fun Container5() {
        // We use a Row to arrange items horizontally
        Row(
            modifier = Modifier.fillMaxWidth(),
            // This centers the buttons horizontally in the row
            horizontalArrangement = Arrangement.Center,
            // This ensures they are aligned vertically
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 1. Button A
            Button(onClick = { /* TODO: Add interaction */ }) {
                Text(text = "Button A")
            }

            // 2. A spacer to add 16dp of space between them
            Spacer(modifier = Modifier.width(16.dp))

            // 3. Button B
            Button(onClick = { /* TODO: Add interaction */ }) {
                Text(text = "Button B")
            }
        }
    }

}