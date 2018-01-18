package com.sanketguru.notesapp.data.store.impl

import com.sanketguru.notesapp.apiservice.ApiResponse
import com.sanketguru.notesapp.apiservice.LoginService
import com.sanketguru.notesapp.data.store.RegisterDataStore
import com.sanketguru.notesapp.models.Register
import com.sanketguru.notesapp.models.User
import io.reactivex.Observable

/**
 * Created by Bhavesh on 18-01-2018.
 */
class RegisterDataStoreImpl(var registerService:LoginService):RegisterDataStore {

    override fun register(register: Register)=registerService.register(register)

}