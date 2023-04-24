package com.biotech.noteme.data.notes

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 1)
internal abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
