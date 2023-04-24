package com.biotech.noteme.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.biotech.noteme.data.notes.NoteDao
import com.biotech.noteme.data.notes.NoteDatabase
import com.biotech.noteme.data.notes.NoteEntity
import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class NoteDatabaseTests {
    private lateinit var noteDao: NoteDao
    private lateinit var db: NoteDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            NoteDatabase::class.java,
        ).build()
        noteDao = db.noteDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeNoteAndReadAllNotes() {
        // Create an instance of NoteEntity
        val noteEntity = NoteEntity(1, "title", "content")

        // Insert the NoteEntity into the database
        noteDao.insertAll(noteEntity = noteEntity)

        // Read all notes from the database
        val notes = noteDao.getAll()

        // Assert that note was successfully inserted
        assertEquals(1, notes.size)
        assertEquals(noteEntity.title, notes[0].title)
        assertEquals(noteEntity.body, notes[0].body)
    }
}
