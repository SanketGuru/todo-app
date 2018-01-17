package com.sanketguru.notesapp.module

import java.util.*

/**
 * Created by Sanket Gurav on 1/8/2018.
 */

open class NoteModel {

    var id = ""

    var onerid = ""

    var title = ""

    var type = 0

    var status = 0

    var sharedWith: List<String> = ArrayList()

    var creationDate = Date()

    var doByDate = Date()

    var lastEdited = Date()

    /**
     * @return id of note it uniquely identifies each Note
     * */
    override fun toString() = this.id

}

data class TextNote(val text: String) : NoteModel()