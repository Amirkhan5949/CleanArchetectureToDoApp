package com.example.cleanarchtecturetodoapp.features.domain.use_cases

data class NoteUseCases(
    val getNotes : GetNotes,
    val getNote: GetNote,
    val deleteNote: DeleteNote
)