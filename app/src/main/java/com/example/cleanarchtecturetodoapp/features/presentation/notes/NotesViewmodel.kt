package com.example.cleanarchtecturetodoapp.features.presentation.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchtecturetodoapp.features.domain.model.Note
import com.example.cleanarchtecturetodoapp.features.domain.use_cases.NoteUseCases
import com.example.cleanarchtecturetodoapp.features.domain.util.NoteOrder
import com.example.cleanarchtecturetodoapp.features.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewmodel @Inject constructor(val noteUseCases: NoteUseCases) : ViewModel() {

    private var recentlyDeleteNote: Note? = null
    private var getNoteJob: Job? = null
    private val _state = MutableLiveData<NotesState>()
    val state: LiveData<NotesState> = _state

    init {
        getNotes(NoteOrder.Date(OrderType.Decending))
    }

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.Order -> {
                if (state.value!!.noteOrder::class == event.noteOrder::class &&
                    state.value!!.noteOrder.orderType == event.noteOrder.orderType
                ) {
                    return
                }
                getNotes(event.noteOrder)
            }
            is NotesEvent.Delete -> {
                viewModelScope.launch {
                    noteUseCases.deleteNote(event.note)
                    recentlyDeleteNote = event.note
                }
            }
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCases.addNote(recentlyDeleteNote ?: return@launch)
                    recentlyDeleteNote = null
                }
            }
            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value?.copy(
                    isOrderSectionVisible = !state.value!!.isOrderSectionVisible
                )
            }
        }
    }


    private fun getNotes(noteOrder: NoteOrder) {
        getNoteJob?.cancel()
        getNoteJob = noteUseCases.getNotes(noteOrder)
            .onEach { notes ->
                _state.value = state.value?.copy(
                    notes = notes,
                    noteOrder = noteOrder
                )
            }.launchIn(viewModelScope)
    }
}