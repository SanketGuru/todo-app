package com.sanketguru.data.repo

import android.util.Log
import com.sanketguru.apiservice.RetrofitHelper
import com.sanketguru.data.mapper.UserMapper
import com.sanketguru.domain.module.UserModel
import com.sanketguru.store.UserDataStore
import com.sanketguru.store.impl.UserDataStoreImpl

/**
 * Created by Sanket Gurav on 1/8/2018.
 */
class UserRepositoryImpl (val id :String){
     lateinit var userStore :UserDataStore
    var userMapper = UserMapper()

    init {
        var retHelper = RetrofitHelper()

        userStore = UserDataStoreImpl(retHelper.userWebService)
    }

    public fun login(user: UserModel) = userStore.login(userMapper.transform(user)).map {
Log.v("Log",user.id)
        userMapper.transform(it.payload!!) }

}