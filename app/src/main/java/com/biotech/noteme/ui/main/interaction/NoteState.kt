package com.biotech.noteme.ui.main.interaction

import com.biotech.noteme.domain.notes.model.Note

data class NoteState(
    var notes: List<Note> = emptyList()
)
