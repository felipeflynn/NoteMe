package com.biotech.noteme.ui.main.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.biotech.noteme.domain.notes.model.Note
import com.biotech.noteme.ui.main.interaction.NoteEvent
import com.biotech.noteme.ui.theme.NoteMeTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AddNoteScreen(
    navHostController: NavHostController? = null,
    onEvent: (NoteEvent) -> Unit,
) {
    var title by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.surface) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = title,
                onValueChange = { newTitle -> title = newTitle },
                label = { Text("Title") },
            )
            Spacer(modifier = Modifier.height(15.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 150.dp, max = 300.dp),
                value = body,
                onValueChange = { newBody ->
                    body = newBody
                },
                label = { Text("Description") },
            )

            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button(
                    onClick = {
                        onEvent(NoteEvent.AddNote(note = Note(id = 0, title = title, body = body)))
                        keyboardController?.hide()
                        navHostController?.popBackStack()
                    },
                ) {
                    Icon(
                        Icons.Filled.Done,
                        contentDescription = "Done",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                    )
                    Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                    Text(text = "Save")
                }
            }
        }
    }
}

@Composable
fun FakeAddNoteScreen() {
    NoteMeTheme() {
        AddNoteScreen(null, {})
    }
}

@Preview
@Composable
fun PreviewFakeAddNoteScreen() {
    FakeAddNoteScreen()
}
