package com.sanketguru.notesapp

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.sanketguru.data.repo.UserRepositoryImpl
import com.sanketguru.domain.module.UserModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer

import io.reactivex.schedulers.Schedulers


/**
 * Created by Sanket Gurav on 1/8/2018.
 */
class LoginActivityViewModel : ViewModel() {
    var userRepo = UserRepositoryImpl("")

    public fun login(user :UserModel){
        val subscribe = userRepo.login(user).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer { user -> Log.v("say", user.id) }, Consumer { err -> err.printStackTrace() })
    }

}