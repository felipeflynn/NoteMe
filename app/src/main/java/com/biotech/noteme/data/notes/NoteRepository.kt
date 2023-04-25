package com.biotech.noteme.data.notes

import com.biotech.noteme.data.notes.model.NoteEntity
import com.biotech.noteme.data.notes.model.local.NoteDao
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDao: NoteDao,
) {
    fun getAllNotes(): List<NoteEntity> = noteDao.getAll()

    fun insertNote(noteEntity: NoteEntity) = noteDao.insertAll(noteEntity = noteEntity)

    fun updateNote(noteEntity: NoteEntity) = noteDao.update(noteEntity = noteEntity)

    fun deleteNote(noteEntity: NoteEntity) = noteDao.delete(noteEntity = noteEntity)
}
