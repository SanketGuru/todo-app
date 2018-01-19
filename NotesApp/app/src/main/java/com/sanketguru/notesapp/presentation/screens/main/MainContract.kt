package com.sanketguru.notesapp.presentation.screens.main

import com.sanketguru.notesapp.domain.module.TextNote
import com.sanketguru.notesapp.presentation.screens.BasePresenter

/**
 * Created by Sanket Gurav on 1/18/2018.
 */
interface MainContract {
    interface View {
        infix fun openNote(notesApp: TextNote)
    }

    interface Presenter : BasePresenter {
        fun createNote()
    }
}