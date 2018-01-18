package com.sanketguru.notesapp.presentation.screens.login

import com.sanketguru.notesapp.domain.module.Error
import com.sanketguru.notesapp.domain.module.UserUIModel
import com.sanketguru.notesapp.domain.repo.UserRepository
import com.sanketguru.notesapp.presentation.screens.BasePresenter
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by Sanket Gurav on 1/17/2018.
 */
class LoginPresenter(val view: LoginContract.View, val userRepo: UserRepository, val sheduler: Scheduler) : LoginContract.Presenter {
    //region  LoginContract.Presenter methods


    var disposible = CompositeDisposable()


    override fun start() {
        disposible = CompositeDisposable()
    }

    override fun stop() {
        disposible.clear()
    }


    override fun doLogin(user: UserUIModel) {
        //   pubError.onNext(Error(9,"my message"))

        val loginDisposible = userRepo.login(user).subscribeOn(Schedulers.io())
                .observeOn(sheduler).subscribe(
                Consumer { userData ->
                    view.goToMainPage(user)
                    //  pubError.onNext(Error(9, userData.userName))

                },
                Consumer { err ->
                    view.showError(Error(0, "Something went wrong"))
                })
        disposible.add(loginDisposible)
    }
    //endregion
}

interface LoginContract {
    interface View {

        fun goToRegistration()
        /**on Login go to main page*/
        fun goToMainPage(user: UserUIModel)

        fun showError(error: Error)

    }

    interface Presenter : BasePresenter {
        /**
         * Login button Clicked Command
         * */
        fun doLogin(user: UserUIModel)


    }
}
