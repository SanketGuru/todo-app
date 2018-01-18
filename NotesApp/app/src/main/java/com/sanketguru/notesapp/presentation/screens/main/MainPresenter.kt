package com.sanketguru.notesapp.presentation.screens.main

import com.sanketguru.notesapp.domain.module.TextNote
import com.sanketguru.notesapp.presentation.screens.BasePresenter

/**
 * Created by Sanket Gurav on 1/18/2018.
 */
class MainPresenter(val view: MainContract.View) : MainContract.Presenter {
    override fun createNote() {
        view openNote TextNote()

    }

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


