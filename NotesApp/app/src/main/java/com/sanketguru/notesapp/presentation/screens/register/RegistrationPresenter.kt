package com.sanketguru.notesapp.presentation.screens.register

import com.sanketguru.notesapp.domain.module.Error
import com.sanketguru.notesapp.domain.module.RegisterUIModel
import com.sanketguru.notesapp.domain.repo.RegisterRepository
import com.sanketguru.notesapp.presentation.screens.BasePresenter
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by sanket on 1/18/2018.
 */
class RegistrationPresenter(val view: RegisterContract.View, val userRepo: RegisterRepository, val sheduler: Scheduler) : RegisterContract.Presenter {


    var disposible = CompositeDisposable()


    override fun start() {
        disposible = CompositeDisposable()
    }

    override fun stop() {
        disposible.clear()
    }

    override fun doRegister(user: RegisterUIModel) {
        val loginDisposible = userRepo.register(user).subscribeOn(Schedulers.io())
                .observeOn(sheduler).subscribe(
                { userData ->
                    view.finishPage()
                    //  pubError.onNext(Error(9, userData.userName))

                },
                { err ->
                    err.printStackTrace()
                    view.showError(Error(0, "Something went wrong"))
                })
        disposible.add(loginDisposible)
    }
}

interface RegisterContract {
    interface View {

        fun finishPage()
        fun showError(error: Error)

    }

    interface Presenter : BasePresenter {
        /**
         * Login button Clicked Command
         * */
        fun doRegister(user: RegisterUIModel)


    }
}
