package com.sanketguru.notesapp.presentation.screens.main.note

import com.sanketguru.notesapp.domain.module.TextNote
import com.sanketguru.notesapp.domain.repo.NoteRepository
import com.sanketguru.notesapp.presentation.screens.BasePresenter
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * Created by Sanket Gurav on 1/18/2018.
 */
class CreateAndEditPresenter(
        private val view: CreateAndEditContract.View,
        val noteRepo: NoteRepository,
        private val sheduler: Scheduler
) : CreateAndEditContract.Presenter {
    //region eateAndEditContract.Presenter
    private var textNote = TextNote()

    override var note: TextNote
        get() = textNote
        set(value) {
            textNote = value
            view.setUpNote(value)
        }

    override fun start() {
    }

    override fun stop() {
    }


    override fun saveNote(note: TextNote) {
        callApi(note).subscribeOn(Schedulers.io())
                .observeOn(sheduler)
    }

    //endregion
    /**
     * Call proper api Accordance with [TextNote.new] flag
     * */
    private fun callApi(note: TextNote) = if (note.new) noteRepo.putNewNote(note) else noteRepo.patchNote(note)
}

interface CreateAndEditContract {
    interface View {
        fun setUpNote(note: TextNote)

    }

    interface Presenter : BasePresenter {
        var note: TextNote
        fun saveNote(note: TextNote)
    }
}