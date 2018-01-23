package com.sanketguru.notesapp.presentation.screens.main.notelist

import com.sanketguru.notesapp.domain.module.NotePageModel
import com.sanketguru.notesapp.domain.repo.NoteRepository
import com.sanketguru.notesapp.presentation.screens.BasePresenter
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Sanket Gurav on 1/18/2018.
 */
class ListPresenterImpl(
        private val view: ListContract.View,
        private val noteRepo: NoteRepository,
        private val scheduler: Scheduler
) : ListContract.Presenter {
    private val compDisposable = CompositeDisposable()
    override fun start() { }

    override fun getPage(pageNo: Int) {
        val pageSubscription = noteRepo.getNotesPage(pageNo).subscribeOn(Schedulers.io()).observeOn(scheduler).subscribe(
                { page ->
                    view.isLoading=false
                    view.pageNumber = page.pageNumber
                    view.addNewPage(page)
                },
                { error ->
                    error.printStackTrace()
                    view.isLoading=false
                }
        )
        compDisposable.add(pageSubscription)
    }

    override fun stop() {
        compDisposable.clear()
    }
}

interface ListContract {
    interface View {
        var pageSize: Int
        var pageNumber: Int
        var totalCount: Int
        var isLastPage: Boolean
        var isLoading: Boolean
        /**
         * Will add new data set to list @param notePageModel[NotePageModel]
         * */
        fun addNewPage(notePageModel: NotePageModel)

    }

    interface Presenter : BasePresenter {
        fun getPage(pageNo: Int)
    }
}