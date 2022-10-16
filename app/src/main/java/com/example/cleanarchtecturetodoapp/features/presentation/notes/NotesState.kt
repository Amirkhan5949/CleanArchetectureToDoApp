package com.example.cleanarchtecturetodoapp.features.presentation.notes

import com.example.cleanarchtecturetodoapp.features.domain.model.Note
import com.example.cleanarchtecturetodoapp.features.domain.util.NoteOrder
import com.example.cleanarchtecturetodoapp.features.domain.util.OrderType

data class NotesState(
    val notes : List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Decending),
    val isOrderSectionVisible : Boolean = false
)
