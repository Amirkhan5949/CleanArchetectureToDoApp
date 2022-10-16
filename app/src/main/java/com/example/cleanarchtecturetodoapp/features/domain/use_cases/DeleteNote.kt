package com.example.cleanarchtecturetodoapp.features.domain.use_cases

import com.example.cleanarchtecturetodoapp.features.domain.model.Note
import com.example.cleanarchtecturetodoapp.features.domain.repository.NoteRepository

class DeleteNote(val repository: NoteRepository) {

    suspend operator fun  invoke(note: Note){
        repository.deleteNote(note)
    }


}