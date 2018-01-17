package com.sanketguru.notesapp.domain.presentation

import com.sanketguru.notesapp.module.UserUIModel
import com.sanketguru.notesapp.todos.UserRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by Sanket Gurav on 1/17/2018.
 */
class LoginPresenter(val view : LoginContract.View, val userRepo: UserRepository) : LoginContract.Presenter {
    var disposible = CompositeDisposable()
    override fun start() {
        disposible = CompositeDisposable()
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        disposible.dispose()
    }

    override fun doLogin(user: UserUIModel) {

        val loginDisposible = userRepo.login(user).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io()).subscribe(
                Consumer { userData -> view.goToMainPage(user) },
                Consumer { err -> })
        disposible.add(loginDisposible)
    }
}

interface LoginContract {
    interface View {


        fun goToRegistration()
        fun goToMainPage(user : UserUIModel)
        fun showError(type :Int ,message :CharSequence )

    }

    interface Presenter : BasePresenter {
        fun doLogin(user: UserUIModel)
    }
}