package com.sanketguru.data.mapper

import com.sanketguru.domain.module.UserModel
import com.sanketguru.notesapp.models.User

/**
 * Created by Sanket Gurav on 1/8/2018.
 */
class UserMapper {
   public fun transform(user : User)  = UserModel(user.id,user.userName,user.password,user.accesstoken)

    public  fun transform(user : UserModel) = User(user?.id,user?.userName,user?.password,user?.accesstoken)

}