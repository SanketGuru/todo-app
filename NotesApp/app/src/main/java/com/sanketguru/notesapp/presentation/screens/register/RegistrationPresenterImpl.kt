package com.sanketguru.notesapp.presentation.screens.register

import com.sanketguru.notesapp.presentation.screens.BasePresenter

/**
 * Created by sanket on 1/18/2018.
 */
class RegistrationPresenterImpl : RegistrationContract.Presenter {
    override fun start() {
    }

    override fun stop() {
    }
}

interface RegistrationContract {
    interface View
    interface Presenter : BasePresenter
}