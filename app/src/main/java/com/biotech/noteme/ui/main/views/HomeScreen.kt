package com.biotech.noteme.ui.main.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.biotech.noteme.domain.notes.model.Note
import com.biotech.noteme.ui.components.NoteList
import com.biotech.noteme.ui.main.MainDestinations
import com.biotech.noteme.ui.main.interaction.NoteState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigate: (MainDestinations) -> Unit,
    noteState: NoteState
) {
    Scaffold(
        modifier = Modifier.fillMaxSize().padding(top = 25.dp),
        containerColor = MaterialTheme.colorScheme.background,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onNavigate(MainDestinations.AddScreen)
                },
                shape = FloatingActionButtonDefaults.shape,
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add",
                )
            }
        },
    ) {
        NoteList(modifier = Modifier.padding(it), notes = noteState.notes, onSelectedNote = {})
        Column(modifier = Modifier.padding(it)) {
        }
    }
}
