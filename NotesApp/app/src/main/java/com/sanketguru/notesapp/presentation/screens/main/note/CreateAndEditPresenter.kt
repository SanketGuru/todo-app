package com.sanketguru.notesapp.presentation.screens.main.note

import com.sanketguru.notesapp.domain.module.TextNote
import com.sanketguru.notesapp.domain.repo.NoteRepository
import com.sanketguru.notesapp.presentation.screens.BasePresenter
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*

/**
 * Created by Sanket Gurav on 1/18/2018.
 */
class CreateAndEditPresenter(
        private val view: CreateAndEditContract.View,
        val noteRepo: NoteRepository,
        private val sheduler: Scheduler
) : CreateAndEditContract.Presenter {
    //region eateAndEditContract.Presenter

    private val compDisposable = CompositeDisposable()
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
        compDisposable.clear()
    }


    override fun saveNote(note: TextNote) {
        var addNoteDisposable = callApi(note).subscribeOn(Schedulers.io()).observeOn(sheduler).subscribe({ view.goToListPage() }, { throwable -> throwable.printStackTrace() })
        compDisposable.add(addNoteDisposable)

    }

    //endregion
    /**
     * Call proper api Accordance with [TextNote.new] flag
     * */
    private fun callApi(note: TextNote) = if (note.new) noteRepo.putNewNote(note) else noteRepo.putNewNote(note)
}

interface CreateAndEditContract {
    interface View {
        fun setUpNote(note: TextNote)
        //Take User To List Page
        fun goToListPage()

        //region UI fields
        var title: String
        var text: String
        var status: Int
        var doByDate: Date

        //endregion
    }

    interface Presenter : BasePresenter {
        var note: TextNote
        fun saveNote(note: TextNote)
    }
}