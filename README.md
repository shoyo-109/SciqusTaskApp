🤖 SCIQUS Android Task (Jetpack Compose)

This repository contains the native Android implementation for the SCIQUS Infotech mobile application task. This app is built 100% with Kotlin and Jetpack Compose, focusing on a clean, component-based architecture, modern state management, and smooth animations.

📱 App Demo


https://github.com/user-attachments/assets/ba27dd64-934a-42b6-9570-4087e621a0c3



✨ Key Features

🎨 True Black (OLED) Theme: The app features a pitch-black (#000000) background in dark mode for a stunning, battery-saving experience on OLED screens.

🧭 Navigation Drawer: A fully functional hamburger menu (☰) that toggles a ModalNavigationDrawer (sidebar) with a logo and navigation items.

🖼️ Container 1: Image Carousel: A HorizontalPager for swiping through a list of images.

✍️ Container 2: Custom Text Block: A formatted text block with a custom message, demonstrating text alignment and styling.

🎮 Container 3: Interactive Slider: An advanced HorizontalPager with external IconButton controls (⬅️ / ➡️) to navigate pages.

📇 Container 4: Static Content Card: A combination of an image and text in a card-like layout, demonstrating Row and Column composition.

🔘 Container 5: Interactive Buttons: Two buttons ("Button A" & "Button B") that demonstrate state management and navigation.

🎬 Screen Animations: Clicking the buttons in Container 5 triggers AnimatedContent to provide a smooth, cross-fade animation to two different "screens."

🖼️ Container 6: Second Image Carousel: Another HorizontalPager to demonstrate component reusability.

🛠 Tech Stack & Libraries

This project was built using a modern Android tech stack:

Language: 🔵 Kotlin

UI Toolkit: 🟢 Jetpack Compose (Android's modern, declarative UI framework)

Core Libraries:

🧱 Material 3: For all UI components (Scaffold, TopAppBar, Button, ModalNavigationDrawer, etc.).

↔️ Compose Foundation (Pager): Used to create the HorizontalPager for all image sliders.

✨ Compose Animation (AnimatedContent): Powers the smooth screen transitions.

Architecture: 🏠 Clean UI Separation (Single-Activity)

MainActivity acts only as the app's entry point.

All UI logic, state, and composables are encapsulated in the ui.home package.

Version Control: 🐙 Git & GitHub

🏗 Application Flow & Structure

The app's logic is designed to be simple, clean, and show a clear separation of concerns.

MainActivity.kt: The app's single Activity. Its only job is to set the SciqusTaskAppTheme and load the HomeScreen() composable.

ui/home/HomeScreen.kt: This single file contains the entire application UI and logic.

HomeScreen(): This is the main composable function. It holds the core state for the app:

drawerState: Manages the open/closed state of the ModalNavigationDrawer.

scope: A CoroutineScope used to launch the open/close animations for the drawer.

currentScreen: A mutableStateOf variable that tracks which "screen" to display ("home", "screenA", or "screenB").

The UI is built with a ModalNavigationDrawer at the root, which contains the Scaffold.

The Scaffold is given a TopAppBar, which holds the title and the navigationIcon (the hamburger menu ☰).

The Scaffold's content is an AnimatedContent composable. This composable observes the currentScreen state.

State-Driven UI:

When currentScreen == "home", the AnimatedContent block displays the LazyColumn containing all 6 containers.

When "Button A" is clicked, the currentScreen state is changed to "screenA".

AnimatedContent detects this state change and automatically cross-fades from the LazyColumn to the ScreenA() composable.

This pattern provides a powerful and clean way to handle navigation and animations simultaneously.

🚀 How to Run

To build and run this project:

Clone the repository:

git clone [https://github.com/](https://github.com/)shoyo-109/SciqusTaskApp.git


Open the project in a recent version of Android Studio (e.g., Iguana or Jellyfish).

Let Gradle sync all the project dependencies.

Run the app on an Android emulator or a physical device.

Designed and Created by Bhubhurv H. Bhatkar 🧑‍💻
