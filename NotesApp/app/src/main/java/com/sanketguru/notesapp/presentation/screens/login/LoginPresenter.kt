package com.sanketguru.notesapp.presentation.screens.login

import com.sanketguru.notesapp.domain.module.AccountDetails
import com.sanketguru.notesapp.domain.module.Error
import com.sanketguru.notesapp.domain.module.UserUIModel
import com.sanketguru.notesapp.domain.repo.UserRepository
import com.sanketguru.notesapp.presentation.screens.BasePresenter
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Sanket Gurav on 1/17/2018.
 */
class LoginPresenter(
        private val view: LoginContract.View,
        private val userRepo: UserRepository,
        private val sheduler: Scheduler
) : LoginContract.Presenter {
    //region  LoginContract.Presenter methods


    var disposible = CompositeDisposable()


    override fun start() {
        disposible = CompositeDisposable()
    }

    override fun stop() {
        disposible.clear()
    }


    override fun doLogin(user: UserUIModel) {
        view.showLoading()
        val loginDisposible =
                userRepo.login(user)
                        .filter { user -> user.userName != null && user.userName != "" }
                        .subscribeOn(Schedulers.io())
                        .observeOn(sheduler)
                        .subscribe(
                                { userData ->

                                    AccountDetails.id = userData.id
                                    AccountDetails.userName = userData.userName
                                    AccountDetails.password = userData.password
                                    AccountDetails.accesstoken = userData.accesstoken
                                    view goToMainPage user
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

interface LoginContract {
    interface View {

        fun goToRegistration()
        /**on Login go to main page*/
        infix fun goToMainPage(user: UserUIModel)

        infix fun showError(error: Error)

        fun showLoading()

        fun hideLoading()

    }

    interface Presenter : BasePresenter {
        /**
         * Login button Clicked Command
         * */
        infix fun doLogin(user: UserUIModel)


    }
}

data class LoginError(val unameError: String)
