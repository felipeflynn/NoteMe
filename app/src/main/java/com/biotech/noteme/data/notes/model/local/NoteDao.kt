package com.biotech.noteme.data.notes.model.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.biotech.noteme.data.notes.model.NoteEntity
import com.biotech.noteme.utils.Constants

@Dao
interface NoteDao {
    @Query("SELECT * FROM ${Constants.note_table_name}")
    fun getAll(): List<NoteEntity>

    @Insert
    fun insertAll(noteEntity: NoteEntity)

    @Delete
    fun delete(noteEntity: NoteEntity)

    @Update
    fun update(noteEntity: NoteEntity)
}
