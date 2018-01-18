package com.sanketguru.notesapp.data.mapper

/**
 * Created by Sanket Gurav on 1/8/2018.
 */
import com.sanketguru.notesapp.models.TextNote
import com.sanketguru.notesapp.domain.module.TextNote as TextNoteModel

class NoteMapper {
    /**
     * Converts Text note to TextNote module
     * */
    fun transform(note: TextNote): TextNoteModel {
        var noteModel = com.sanketguru.notesapp.domain.module.TextNote(note.text)
        with(noteModel) {
            id = note.id
            ownerId = note.ownerId
            title = note.title
        }
        return noteModel
    }

    /**
     * Converts TextNote module to  Text note
     * */
    fun transform(textNoteModel: com.sanketguru.notesapp.domain.module.TextNote): TextNote {
        var textNote = TextNote(textNoteModel.text)
        with(textNote) {
            id = textNoteModel.id
            ownerId = textNoteModel.ownerId
            title = textNoteModel.title
        }
        return textNote
    }

    /**
     * Converts  list of TextNote module to  list of  Text note
     * */

    fun transformTextNote(todos: List<TextNote>): List<com.sanketguru.notesapp.domain.module.TextNote> {
        return todos.map { transform(it) }
    }

    /**
     * Converts  list of TextNote module to  list of  Text note
     * */

    fun transformTextNoteModle(todos: List<com.sanketguru.notesapp.domain.module.TextNote>): List<TextNote> {
        return todos.map { transform(it) }
    }
}