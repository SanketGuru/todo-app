package com.sanketguru.notesapp

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.sanketguru.data.repo.UserRepository
import com.sanketguru.data.repo.UserRepositoryImpl

import com.sanketguru.domain.module.User
import com.sanketguru.notesapp.di.component.DaggerRepoComPonent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer

import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by Sanket Gurav on 1/8/2018.
 */
class LoginActivityViewModel : ViewModel(){
  var   userRepo : UserRepository = UserRepositoryImpl()
    @Inject lateinit var  ny : String
    public fun login(user : User){
        DaggerRepoComPonent.builder().build().inject("Hi")
Log.v("Say",ny)
        val subscribe = userRepo.login(user).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer { user -> Log.v("say", user.id) }, Consumer { err -> err.printStackTrace() })
    }

}