package com.example.cleanarchtecturetodoapp.features.domain.use_cases

import android.provider.ContactsContract.CommonDataKinds.Note
import com.example.cleanarchtecturetodoapp.features.domain.repository.NoteRepository
import com.example.cleanarchtecturetodoapp.features.domain.util.NoteOrder
import com.example.cleanarchtecturetodoapp.features.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes (private val repository: NoteRepository) {
   operator fun invoke (noteOrder: NoteOrder = NoteOrder.Date(OrderType.Decending)
   ): Flow<List<com.example.cleanarchtecturetodoapp.features.domain.model.Note>>{
      return repository.getNotes().map {notes->
         when(noteOrder.orderType){
            is OrderType.Ascending ->{
               when(noteOrder){
                  is NoteOrder.Title-> notes.sortedBy { it.title.lowercase() }
                  is NoteOrder.Date-> notes.sortedBy { it.timestamp }
                  is NoteOrder.Color-> notes.sortedBy { it.color }
               }
            }
            is OrderType.Decending->{
               when(noteOrder){
                  is NoteOrder.Title-> notes.sortedByDescending { it.title.lowercase() }
                  is NoteOrder.Date-> notes.sortedByDescending { it.timestamp }
                  is NoteOrder.Color-> notes.sortedByDescending { it.color }
               }
            }
         }

      }
   }

}