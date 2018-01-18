package com.sanketguru.notesapp.data.mapper

import com.sanketguru.notesapp.models.User
import com.sanketguru.notesapp.domain.module.UserUIModel as UserModel

/**
 * Created by Sanket Gurav on 1/8/2018.
 */
class UserMapper {
    fun transform(user: User) = UserModel(user.id, user.userName, user.password, user.accesstoken)

    fun transform(userUIModel: UserModel) = User(userUIModel.id, userUIModel.userName, userUIModel.password, userUIModel.accesstoken)

}