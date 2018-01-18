package com.sanketguru.store.impl

import com.sanketguru.notesapp.apiservice.ApiResponse
import com.sanketguru.notesapp.apiservice.LoginService
import com.sanketguru.notesapp.models.User
import com.sanketguru.store.UserDataStore
import io.reactivex.Observable

/**
 * Created by Sanket Gurav on 1/8/2018.
 */

class UserDataStoreImpl ( var loginService : LoginService ): UserDataStore {

    override fun login(user : User) :  Observable<ApiResponse<User>>{ return loginService.login(user)}

}
