package com.example.cleanarchtecturetodoapp.features.presentation.notes

import com.example.cleanarchtecturetodoapp.features.domain.model.Note
import com.example.cleanarchtecturetodoapp.features.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder : NoteOrder): NotesEvent()
    data class Delete(val note: Note): NotesEvent()
    object RestoreNote : NotesEvent()
    object ToggleOrderSection : NotesEvent()
}