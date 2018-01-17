package com.sanketguru.notesapp.data.mapper

import com.sanketguru.notesapp.module.UserUIModel as UserModel
import com.sanketguru.notesapp.models.User as  User

/**
 * Created by Sanket Gurav on 1/8/2018.
 */
class UserMapper {
   public fun transform(user : User)  = UserModel(user.id,user.userName,user.password,user.accesstoken?: "")

    public  fun transform(userUIModel : UserModel) = User(userUIModel?.id,userUIModel?.userName,userUIModel?.password,userUIModel?.accesstoken)

}