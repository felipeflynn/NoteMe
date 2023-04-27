package com.biotech.noteme.ui.main

sealed class MainDestinations(val route: String) {
    object HomeScreen : MainDestinations("home")
    object AddScreen : MainDestinations("add")
}
