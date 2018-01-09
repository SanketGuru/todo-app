package com.sanketguru.data.mapper

import com.sanketguru.domain.module.User as UserModel
import com.sanketguru.notesapp.models.User as  User

/**
 * Created by Sanket Gurav on 1/8/2018.
 */
class UserMapper {
   public fun transform(user : User)  = com.sanketguru.domain.module.User(user.id,user.userName,user.password,user?.accesstoken?: "")

    public  fun transform(user : com.sanketguru.domain.module.User) = User(user?.id,user?.userName,user?.password,user?.accesstoken)

}