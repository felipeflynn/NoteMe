package com.biotech.noteme.data.notes.model.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.biotech.noteme.data.notes.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
internal abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
