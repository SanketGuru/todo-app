package com.sanketguru.notesapp.presentation.screens.main.notelist

import com.sanketguru.notesapp.domain.repo.NoteRepository
import com.sanketguru.notesapp.presentation.screens.BasePresenter
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Sanket Gurav on 1/18/2018.
 */
class ListPresenterImpl(private val view : ListContract.View, private val noteRepo: NoteRepository ,private val scheduler: Scheduler) : ListContract.Presenter{
    var compDisposable =CompositeDisposable()
    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
fun getPage(pageNo: Int){noteRepo.getNotesPage(pageNo)}
    override fun stop() {
        compDisposable.clear()
    }
}
interface ListContract {
    interface View {
        var pageSize :Int
        var pageNumber: Int
        var totalCount: Int
        var isLastPage: Boolean
        var isLoading: Boolean


    }
    interface Presenter : BasePresenter {}
}