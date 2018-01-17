package com.sanketguru.notesapp.data.mapper

/**
 * Created by Sanket Gurav on 1/8/2018.
 */
import com.sanketguru.notesapp.models.TextNote as TextNote
import com.sanketguru.notesapp.module.TextNote as TextNoteModel
class NoteMapper {
    /**
     * Converts Text note to TextNote module
     * */
    fun transform(note: TextNote): TextNoteModel {
        var noteModel = com.sanketguru.notesapp.module.TextNote(note.text)
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
    fun transform(textNoteModel: com.sanketguru.notesapp.module.TextNote): TextNote {
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

    fun transformTextNote(todos: List<TextNote>): List<com.sanketguru.notesapp.module.TextNote> {
        return todos.map { transform(it) }
    }

    /**
     * Converts  list of TextNote module to  list of  Text note
     * */

    fun transformTextNoteModle(todos: List<com.sanketguru.notesapp.module.TextNote>): List<TextNote> {
        return todos.map { transform(it) }
    }
}