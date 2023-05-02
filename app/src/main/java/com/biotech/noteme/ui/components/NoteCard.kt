package com.biotech.noteme.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.biotech.noteme.domain.notes.model.Note

@Composable
fun NoteCardComponent(
    modifier: Modifier = Modifier,
    note: Note,
    onSelectedNote: (note: Note) -> Unit,
) {
    Card(
        modifier = modifier.clickable { onSelectedNote(note) },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceTint,
        ),
        shape = CardDefaults.outlinedShape,
        elevation = CardDefaults.outlinedCardElevation(),
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
        ) {
            Text(
                text = note.title,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.size(15.dp))
            Text(
                text = note.body,
                fontWeight = FontWeight.Normal,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}
