package com.sanketguru.notesapp.data.repo

import com.sanketguru.notesapp.apiservice.RetrofitHelper
import com.sanketguru.notesapp.data.mapper.UserMapper
import com.sanketguru.notesapp.data.store.RegisterDataStore
import com.sanketguru.notesapp.data.store.impl.RegisterDataStoreImpl
import com.sanketguru.notesapp.domain.module.RegisterUIModel
import com.sanketguru.notesapp.domain.repo.RegisterRepository

/**
 * Created by Bhavesh on 18-01-2018.
 */
class RegisterRepositoryImpl : RegisterRepository {
    lateinit var registerStore: RegisterDataStore
    var userMapper = UserMapper()

    init {
        var retHelper = RetrofitHelper()
        registerStore = RegisterDataStoreImpl(retHelper.userWebService)
    }


    override fun register(registerUiModel: RegisterUIModel) = registerStore.register(userMapper.transformRegisterUITORegister(registerUiModel)).map {
        userMapper.transformRegisterToRegisterUI(it.payload!!)
    }
}