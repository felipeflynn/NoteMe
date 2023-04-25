package com.biotech.noteme.domain.notes

import com.biotech.noteme.data.notes.NoteRepository
import com.biotech.noteme.domain.notes.model.Note
import com.biotech.noteme.domain.notes.model.toNote
import javax.inject.Inject

class GetNotes @Inject constructor(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(): List<Note> {
        return noteRepository.getAllNotes().map {
            it.toNote()
        }
    }
}
