package com.sanketguru.data.repo

import com.sanketguru.apiservice.RetrofitHelper
import com.sanketguru.data.mapper.UserMapper
import com.sanketguru.domain.module.User
import com.sanketguru.store.UserDataStore
import com.sanketguru.store.impl.UserDataStoreImpl
import io.reactivex.Observable

/**
 * Created by Sanket Gurav on 1/8/2018.
 */
class UserRepositoryImpl : UserRepository{
     lateinit var userStore :UserDataStore
    var userMapper = UserMapper()

    init {
        var retHelper = RetrofitHelper()

        userStore = UserDataStoreImpl(retHelper.userWebService)
    }

    public override fun login(user: User) = userStore.login(userMapper.transform(user)).map { userMapper.transform(it!!.payload!!) }

}
interface UserRepository{
    fun login(user: User): Observable<User>
}