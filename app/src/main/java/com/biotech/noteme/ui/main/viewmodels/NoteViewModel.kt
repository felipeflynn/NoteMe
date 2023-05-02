package com.biotech.noteme.ui.main.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biotech.noteme.domain.notes.AddNote
import com.biotech.noteme.domain.notes.EraseNote
import com.biotech.noteme.domain.notes.GetNotes
import com.biotech.noteme.domain.notes.UpdateNote
import com.biotech.noteme.domain.notes.model.Note
import com.biotech.noteme.ui.main.interaction.NoteEvent
import com.biotech.noteme.ui.main.interaction.NoteState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getNotes: GetNotes,
    private val addNote: AddNote,
    private val updateNote: UpdateNote,
    private val deleteNote: EraseNote
) : ViewModel() {

    private val _state: MutableState<NoteState> = mutableStateOf(NoteState())
    val state: State<NoteState> get() = _state

    init {
        collectNotes()
    }

    fun onEvent(noteEvent: NoteEvent) {
        when (noteEvent) {
            is NoteEvent.AddNote -> onInsertNote(note = noteEvent.note)
            //is NoteEvent.Update -> updateNote.invoke(noteEvent.note)
            //is NoteEvent.Delete -> deleteNote.invoke(noteEvent.note)
        }
    }

    private fun collectNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            val fetchedNotes = getNotes.invoke()
            withContext(Dispatchers.Main) {
                _state.value = _state.value.copy(notes = fetchedNotes)
            }
        }
    }

    private fun onInsertNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            addNote.invoke(note)
            collectNotes()
        }
    }
}
