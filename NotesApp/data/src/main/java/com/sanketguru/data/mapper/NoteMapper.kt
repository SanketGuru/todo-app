package com.sanketguru.data.mapper

/**
 * Created by Sanket Gurav on 1/8/2018.
 */
import com.sanketguru.domain.module.TextNoteModle
import com.sanketguru.notesapp.models.TextNote

class NoteMapper {
    /**
     * Converts Text note to TextNote module
     * */
    fun transform(note: TextNote): TextNoteModle {
        var noteModel = TextNoteModle(note.text)
        with(noteModel) {
            id = note.id
            onerid = note.onerid
            title = note.title
        }
        return noteModel
    }

    /**
     * Converts TextNote module to  Text note
     * */
    fun transform(textNoteModel: TextNoteModle): TextNote {
        var textNote = TextNote(textNoteModel.text)
        with(textNote) {
            id = textNoteModel.id
            onerid = textNoteModel.onerid
            title = textNoteModel.title
        }
        return textNote
    }

    /**
     * Converts  list of TextNote module to  list of  Text note
     * */

    fun transformTextNote(todos: List<TextNote>): List<TextNoteModle> {
        return todos.map { transform(it) }
    }

    /**
     * Converts  list of TextNote module to  list of  Text note
     * */

    fun transformTextNoteModle(todos: List<TextNoteModle>): List<TextNote> {
        return todos.map { transform(it) }
    }
}