package com.example.cleanarchtecturetodoapp.features.domain.model

import android.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(Color.BLUE, Color.GRAY, Color.GREEN, Color.RED, Color.YELLOW)
    }
}

class InvalidNoteException(message: String) : Exception(message)