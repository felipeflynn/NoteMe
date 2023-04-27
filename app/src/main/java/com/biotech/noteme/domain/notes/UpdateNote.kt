package com.biotech.noteme.domain.notes

import com.biotech.noteme.data.notes.NoteRepository
import com.biotech.noteme.domain.notes.model.Note
import com.biotech.noteme.domain.notes.model.toNoteEntity
import javax.inject.Inject

class UpdateNote @Inject constructor(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) {
        noteRepository.updateNote(note.toNoteEntity())
    }
}
