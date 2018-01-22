package com.sanketguru.notesapp.presentation.screens.register

import com.sanketguru.notesapp.domain.module.RegisterError
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
        if (user.userName.equals("")) {
            view.showError(RegisterError(0, "UserName can,t empty"))
        }else if (user.password.equals("")) {
            view.showError(RegisterError(1, "Password can,t empty"))
        } else {
            val loginDisposible = userRepo.register(user).subscribeOn(Schedulers.io())
                    .observeOn(sheduler).subscribe(
                    { userData ->
                        view.showError(RegisterError(2, "Register Successfully"))
                        view.finishPage()
                        //  pubError.onNext(Error(9, userData.userName))

                    },
                    { err ->
                        err.printStackTrace()
                        view.showError(RegisterError(3, "Something went wrong"))
                    })
            disposible.add(loginDisposible)
        }
    }
}

interface RegisterContract {
    interface View {

        fun finishPage()
        fun showError(error: RegisterError)

    }

    interface Presenter : BasePresenter {
        /**
         * Login button Clicked Command
         * */
        fun doRegister(user: RegisterUIModel)


    }
}
