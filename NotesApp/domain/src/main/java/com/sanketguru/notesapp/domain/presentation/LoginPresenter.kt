package com.sanketguru.notesapp.domain.presentation

import com.sanketguru.notesapp.module.UserUIModel
import com.sanketguru.notesapp.todos.UserRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

/**
 * Created by Sanket Gurav on 1/17/2018.
 */
class LoginPresenter(val view: LoginContract.View, val userRepo: UserRepository) : LoginContract.Presenter {
    var disposible = CompositeDisposable()
    val pubError: PublishSubject<Error> = PublishSubject.create()
    val messageError: PublishSubject<Error> = PublishSubject.create()
    override fun start() {
        disposible = CompositeDisposable()
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        disposible.dispose()
    }

    override fun getError() = pubError
    override fun doLogin(user: UserUIModel) {
        //   pubError.onNext(Error(9,"my message"))

        val loginDisposible = userRepo.login(user).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io()).subscribe(
                Consumer { userData ->
                    //view.goToMainPage(user)
                    pubError.onNext(Error(9, userData.userName))

                },
                Consumer { err ->
                    pubError.onNext(Error(9, "my message"))

                })
        disposible.add(loginDisposible)
    }
}

interface LoginContract {
    interface View {


        fun goToRegistration()
        fun goToMainPage(user: UserUIModel)
        fun showError(type: Int, message: CharSequence)

    }

    interface Presenter : BasePresenter {
        fun doLogin(user: UserUIModel)
        fun getError(): PublishSubject<Error>
    }
}

data class Error(val type: Int, val message: CharSequence)