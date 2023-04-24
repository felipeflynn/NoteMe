package com.biotech.noteme.di

import android.content.Context
import androidx.room.Room
import com.biotech.noteme.data.notes.model.local.NoteDao
import com.biotech.noteme.data.notes.model.local.NoteDatabase
import com.biotech.noteme.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    internal fun providesNotesRoomDataBase(@ApplicationContext app: Context): NoteDatabase = Room.databaseBuilder(
        app,
        NoteDatabase::class.java,
        Constants.note_database,
    ).build()

    @Provides
    @Singleton
    internal fun providesNoteDao(noteDatabase: NoteDatabase): NoteDao = noteDatabase.noteDao()
}
