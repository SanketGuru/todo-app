package com.sanketguru.notesapp.data.repo

import com.sanketguru.notesapp.apiservice.RetrofitHelper
import com.sanketguru.notesapp.data.mapper.UserMapper
import com.sanketguru.notesapp.module.UserUIModel
import com.sanketguru.notesapp.todos.UserRepository
import com.sanketguru.store.UserDataStore
import com.sanketguru.store.impl.UserDataStoreImpl

/**
 * Created by Sanket Gurav on 1/8/2018.
 */
class UserRepositoryImpl() : UserRepository {
    lateinit var userStore: UserDataStore
    var userMapper = UserMapper()

    init {
        var retHelper = RetrofitHelper()

        userStore = UserDataStoreImpl(retHelper.userWebService)
    }

    override fun login(userUIModel: UserUIModel) = userStore.login(userMapper.transform(userUIModel)).map<UserUIModel> {

        userMapper.transform(it!!.payload!!)
    }

}