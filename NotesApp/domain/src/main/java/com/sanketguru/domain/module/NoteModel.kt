package com.sanketguru.domain.module

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


}

data class TextNoteModle (    val text: String) : NoteModel()