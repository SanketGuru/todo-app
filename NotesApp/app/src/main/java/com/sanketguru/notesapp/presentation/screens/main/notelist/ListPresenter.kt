package com.sanketguru.notesapp.presentation.screens.main.notelist

import com.sanketguru.notesapp.presentation.screens.BasePresenter

/**
 * Created by Sanket Gurav on 1/18/2018.
 */
class ListPresenter : ListContract.Presenter{
    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
interface ListContract {
    interface View {}
    interface Presenter : BasePresenter {}
}