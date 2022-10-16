package com.example.cleanarchtecturetodoapp.features.domain.use_cases

import com.example.cleanarchtecturetodoapp.features.domain.model.InvalidNoteException
import com.example.cleanarchtecturetodoapp.features.domain.model.Note
import com.example.cleanarchtecturetodoapp.features.domain.repository.NoteRepository

class AddNote(val repository: NoteRepository)
{
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if (note.title.isEmpty()){
            throw InvalidNoteException("The Title should not be empty")
        }

        if (note.content.isEmpty()){
            throw InvalidNoteException("The Content should not be empty")
        }

        repository.insertNote(note)
}
}