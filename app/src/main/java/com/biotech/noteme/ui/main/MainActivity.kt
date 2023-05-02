package com.biotech.noteme.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.biotech.noteme.ui.main.viewmodels.NoteViewModel
import com.biotech.noteme.ui.main.views.AddNoteScreen
import com.biotech.noteme.ui.main.views.HomeScreen
import com.biotech.noteme.ui.theme.NoteMeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteMeTheme {
                val navController = rememberNavController()
                val noteViewModel: NoteViewModel = hiltViewModel()
                NavHost(navController = navController, startDestination = MainDestinations.HomeScreen.route) {
                    composable(MainDestinations.HomeScreen.route) {
                        HomeScreen(
                            onNavigate = { screen ->
                                navigate(navHostController = navController, screen = screen)
                            },
                            noteState = noteViewModel.state.value
                        )
                    }
                    composable(MainDestinations.AddScreen.route) {
                        AddNoteScreen(navHostController = navController,
                            onEvent = { event ->
                                noteViewModel.onEvent(noteEvent = event)
                            }
                        )
                    }
                }
            }
        }
    }

    private fun navigate(navHostController: NavHostController, screen: MainDestinations) {
        navHostController.navigate(screen.route) {
            // Save the state of the screen
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }
            // The screen only have one instance
            launchSingleTop = true
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteMeTheme {
        Greeting("Android")
    }
}
