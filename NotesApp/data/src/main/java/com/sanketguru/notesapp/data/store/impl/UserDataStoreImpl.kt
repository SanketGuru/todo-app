package com.sanketguru.store.impl

import com.sanketguru.notesapp.apiservice.LoginService
import com.sanketguru.notesapp.models.User
import com.sanketguru.store.UserDataStore

/**
 * Created by Sanket Gurav on 1/8/2018.
 */

class UserDataStoreImpl(var loginService: LoginService) : UserDataStore {


    override fun login(user: User) = loginService.login(user)

}