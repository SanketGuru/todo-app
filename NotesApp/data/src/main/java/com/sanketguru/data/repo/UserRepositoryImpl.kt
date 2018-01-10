package com.sanketguru.data.repo

import com.sanketguru.apiservice.RetrofitHelper
import com.sanketguru.data.mapper.UserMapper
import com.sanketguru.domain.module.UserUIModel
import com.sanketguru.store.UserDataStore
import com.sanketguru.store.impl.UserDataStoreImpl

/**
 * Created by Sanket Gurav on 1/8/2018.
 */
class UserRepositoryImpl (){
     lateinit var userStore :UserDataStore
    var userMapper = UserMapper()

    init {
        var retHelper = RetrofitHelper()

        userStore = UserDataStoreImpl(retHelper.userWebService)
    }

    public fun login(userUIModel: UserUIModel) = userStore.login(userMapper.transform(userUIModel)).map<UserUIModel> {

        userMapper.transform(it!!.payload!!)
    }

}