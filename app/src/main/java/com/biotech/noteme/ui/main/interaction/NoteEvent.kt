package com.biotech.noteme.ui.main.interaction

import com.biotech.noteme.domain.notes.model.Note

sealed class NoteEvent {
    data class AddNote(val note: Note) : NoteEvent()
}
