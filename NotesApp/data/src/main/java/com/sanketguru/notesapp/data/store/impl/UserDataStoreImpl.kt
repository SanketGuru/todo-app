package com.sanketguru.store.impl

import com.sanketguru.notesapp.apiservice.ApiResponse
import com.sanketguru.notesapp.apiservice.LoginService
import com.sanketguru.notesapp.models.User
import com.sanketguru.store.UserDataStore
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Sanket Gurav on 1/8/2018.
 */

class UserDataStoreImpl(var loginService: LoginService) : UserDataStore {


    //    override fun login(user: User) = loginService.login(user).subscribeOn(Schedulers.io())
    override fun login(user: User): Observable<ApiResponse<User>> = Observable.fromCallable {
        var ss = ApiResponse<User>()
        ss.payload = User("5", "raju", "12345", "tiuyt")
        ss
    }.subscribeOn(Schedulers.io())

}
