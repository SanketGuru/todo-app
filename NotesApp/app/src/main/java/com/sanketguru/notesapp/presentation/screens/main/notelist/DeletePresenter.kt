package com.sanketguru.notesapp.presentation.screens.main.notelist

import com.sanketguru.notesapp.domain.module.DeleteModel
import com.sanketguru.notesapp.domain.module.Error
import com.sanketguru.notesapp.domain.repo.NoteRepository
import com.sanketguru.notesapp.presentation.screens.BasePresenter
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

/**
 * Created by Raju on 23-02-2018.
 */


class DeletePresenter(
        private val view: DeleteContract.View,
        private val userRepo: NoteRepository,
        private val scheduler: Scheduler
) : DeleteContract.Presenter {

    //region  LoginContract.Presenter methods


    private  var disposible = CompositeDisposable()


    override fun start() {
        disposible = CompositeDisposable()


    }

    override fun stop() {
        disposible.clear()
    }


    override fun delete(user: DeleteModel) {

        val loginDisposible =
                userRepo.deleteNote(user)
                      //  .filter { user -> user.userName != null && user.userName != "" }
                        .observeOn(scheduler)
                        .subscribe(
                                { userData ->


                                Timber.v("success %s",userData.toString())
                                },
                                { err ->
                                    err.printStackTrace()
                                    view showError Error(0, "Something went wrong")



                                })
        disposible.add(loginDisposible)
    }
    //endregion
}

interface DeleteContract {
    interface View {

        infix fun showError(error: Error)

    }


    interface Presenter : BasePresenter {
        /**
         * Login button Clicked Command
         * */
        infix fun delete(user: DeleteModel)


    }
}