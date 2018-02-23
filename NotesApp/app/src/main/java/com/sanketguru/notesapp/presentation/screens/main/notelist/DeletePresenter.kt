package com.sanketguru.notesapp.presentation.screens.main.notelist

import com.sanketguru.notesapp.domain.module.AccountDetails
import com.sanketguru.notesapp.domain.module.DeleteModel
import com.sanketguru.notesapp.domain.module.Error
import com.sanketguru.notesapp.domain.module.UserUIModel
import com.sanketguru.notesapp.domain.repo.DeleteRepository
import com.sanketguru.notesapp.domain.repo.UserRepository
import com.sanketguru.notesapp.presentation.screens.BasePresenter
import com.sanketguru.notesapp.presentation.screens.login.LoginContract
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Raju on 23-02-2018.
 */


class DeletePresenter(
        private val view: DeleteContract.View,
        private val userRepo: DeleteRepository,
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


    override fun doLogin(user: DeleteModel) {
        view.showLoading()
        val loginDisposible =
                userRepo.login(user)
                      //  .filter { user -> user.userName != null && user.userName != "" }
                        .observeOn(scheduler)
                        .subscribe(
                                { userData ->


                                    view.hideLoading()
                                },
                                { err ->
                                    err.printStackTrace()
                                    view showError Error(0, "Something went wrong")
                                    view.hideLoading()


                                })
        disposible.add(loginDisposible)
    }
    //endregion
}

interface DeleteContract {
    interface View {



        infix fun showError(error: Error)

        fun showLoading()

        fun hideLoading()


    }


    interface Presenter : BasePresenter {
        /**
         * Login button Clicked Command
         * */
        infix fun doLogin(user: DeleteModel)


    }
}