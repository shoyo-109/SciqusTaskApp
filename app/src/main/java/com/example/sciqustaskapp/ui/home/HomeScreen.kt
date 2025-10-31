package com.example.sciqustaskapp.ui.home


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.filled.Menu
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.animation.AnimatedContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.*
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward

import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var currentScreen by remember { mutableStateOf("home") }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // This is the content for the sidebar
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo), // Use your logo
                        contentDescription = "SCIQUS Logo",
                        modifier = Modifier.size(100.dp)
                    )
                }
                NavigationDrawerItem(
                    label = { Text(text = "Home") },
                    selected = true,
                    onClick = { scope.launch { drawerState.close() } } // Click to close
                )
                NavigationDrawerItem(
                    label = { Text(text = "Settings") },
                    selected = false,
                    onClick = { scope.launch { drawerState.close() } } // Click to close
                )
            }
        }
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = { Text("SCIQUS") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->


            AnimatedContent(
                targetState = currentScreen,
                modifier = Modifier.padding(innerPadding),
                label = "Screen Animation"
            ) { screenState ->

                when (screenState) {
                    "home" -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            item { Container1() }
                            item { Container2() }
                            item { Container3() }
                            item { Container4() }
                            item {
                                Container5(
                                    onButtonAClick = { currentScreen = "screenA" },
                                    onButtonBClick = { currentScreen = "screenB" }
                                )
                            }
                            item { Container6() }
                        }
                    }

                    "screenA" -> {
                        ScreenA(onBack = { currentScreen = "home" })
                    }

                    "screenB" -> {
                        ScreenB(onBack = { currentScreen = "home" })
                    }
                }
            }
        }
    }

}



    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun Container1() {
        val pagerState = rememberPagerState(pageCount = { carouselImages1.size })

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            pageSpacing = 8.dp
        ) { pageIndex ->

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

    @Composable
    fun Container2() {
        Text(
            text = """
                Warm wishes for a joyous and prosperous Diwali to everyone at SCIQUS Infotech.
                Honored to share my creative work with your team during this festive season of innovation and light.
            """.trimIndent(),

            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Left
        )
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun Container3() {
        val pagerState = rememberPagerState(pageCount = { carouselImages2.size })

        val scope = rememberCoroutineScope()

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

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

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    scope.launch {
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

                Text(
                    text = "${pagerState.currentPage + 1} / ${carouselImages2.size}",
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                IconButton(onClick = {
                    scope.launch {
                        val newPage = if (pagerState.currentPage < carouselImages2.size - 1) {
                            pagerState.currentPage + 1
                        } else {
                            0
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
                .background(MaterialTheme.colorScheme.onSecondary, RoundedCornerShape(8.dp))
                .clip(RoundedCornerShape(8.dp))
                .padding(16.dp), // Padding inside the card
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.fireworks_1),
                contentDescription = "Static content",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(16.dp))


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
    fun Container5(
        onButtonAClick: () -> Unit,
        onButtonBClick: () -> Unit
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = onButtonAClick) {
                Text(text = "Button A")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = onButtonBClick) {
                Text(text = "Button B")
            }
        }
    }



    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun Container6() {
        val pagerState = rememberPagerState(pageCount = { carouselImages2.size })

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            pageSpacing = 8.dp
        ) { pageIndex ->
            Image(
                painter = painterResource(id = carouselImages2[pageIndex]),
                contentDescription = "Carousel Image 6",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp))
            )
        }
    }

@Composable
fun ScreenA(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Welcome to Screen A", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onBack) {
            Text("Go Back")
        }
    }
}

@Composable
fun ScreenB(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("This is Screen B", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onBack) {
            Text("Go Back")
        }
    }
}