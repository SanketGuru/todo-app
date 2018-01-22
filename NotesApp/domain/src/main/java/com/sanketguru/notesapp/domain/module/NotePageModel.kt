package com.sanketguru.notesapp.domain.module

/**
 * Created by Sanket Gurav on 1/22/2018.
 */
data class NotePageModel(
        val pageSize: Int,
        val pageNumber: Int,
        val totalCount: Int,
        val listTextNote: List<TextNote>
)