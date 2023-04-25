package com.biotech.noteme.domain.notes.model

import com.biotech.noteme.data.notes.model.NoteEntity

data class Note(
    val id: Int,
    val title: String,
    val body: String,
)

fun Note.toNoteEntity(): NoteEntity = NoteEntity(id, title, body)
fun NoteEntity.toNote() = Note(id = uid, title = title, body = body)
