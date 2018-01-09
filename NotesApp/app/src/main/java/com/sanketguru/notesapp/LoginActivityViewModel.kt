package com.sanketguru.notesapp

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.sanketguru.data.repo.UserRepositoryImpl
import com.sanketguru.domain.module.UserUIErrorModel
import com.sanketguru.domain.module.UserUIModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers


/**
 * Created by Sanket Gurav on 1/8/2018.
 */
class LoginActivityViewModel : ViewModel() {
    var userRepo = UserRepositoryImpl("")
    lateinit var listener: LoginListener

    init {
        listener = LoginActivity()
    }

    public fun login(userUIModel: UserUIModel) {
        if (userUIModel.userName.equals("")) {
            var ds = UserUIErrorModel()
            ds.userName = "raju"
            listener.validationCheck(ds)
        } else if (userUIModel.password.equals("")) {
            var ds = UserUIErrorModel()
            ds.password = "paaswordCan'tBlank"
            listener.validationCheck(ds)

        } else {
            val subscribe = userRepo.login(userUIModel).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(Consumer { user -> Log.v("say", user.id) }, Consumer { err -> err.printStackTrace() })
        }
    }

    public interface LoginListener {
        fun validationCheck(userUIModel: UserUIErrorModel)

    }

}