package com.example.cleanarchtecturetodoapp.features.domain.use_cases

import com.example.cleanarchtecturetodoapp.features.domain.model.Note
import com.example.cleanarchtecturetodoapp.features.domain.repository.NoteRepository

class GetNote (private val noteRepository: NoteRepository) {

   suspend fun  invoke(id : Int):Note?{
       return noteRepository.getNoteById(id)
    }
}