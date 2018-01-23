package com.sanketguru.notesapp.presentation.screens

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.sanketguru.notesapp.R
import com.sanketguru.notesapp.data.repo.UserRepositoryImpl
import com.sanketguru.notesapp.domain.module.AccountDetails
import com.sanketguru.notesapp.domain.module.Error
import com.sanketguru.notesapp.domain.module.UserUIModel
import com.sanketguru.notesapp.presentation.common.Constants
import com.sanketguru.notesapp.presentation.screens.login.LoginActivity
import com.sanketguru.notesapp.presentation.screens.login.LoginContract
import com.sanketguru.notesapp.presentation.screens.login.LoginPresenter
import com.sanketguru.notesapp.presentation.screens.main.MainActivity
import com.sanketguru.notesapp.presentation.screens.register.RegisterActivity
import com.sanketguru.notesapp.presentation.utils.extensions.PreferenceHelper
import com.sanketguru.notesapp.presentation.utils.extensions.PreferenceHelper.get
import com.sanketguru.notesapp.presentation.utils.extensions.PreferenceHelper.set
import com.sanketguru.notesapp.presentation.utils.extensions.start
import io.reactivex.android.schedulers.AndroidSchedulers
import timber.log.Timber

/**
 * Created by Bhavesh on 23-01-2018.
 */
class SplashActivity : AppCompatActivity(), LoginContract.View {
    val presenter = LoginPresenter(this, UserRepositoryImpl(), AndroidSchedulers.mainThread())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        //get any value from prefs
        val prefs = PreferenceHelper.defaultPrefs(this)

        val userName: String? = prefs[Constants.USER_NAME]

        //get value from prefs (with default value)
        val password: String? = prefs[Constants.PASSWORD, "12345"]
        if ((userName != null && userName != "") && (password != null && password != "")) {
            presenter.doLogin(UserUIModel(userName = userName, password = password))
        } else {
            this.start<LoginActivity>()
            this.finish()
        }


    }

    //region  LoginContract.View implementation


    override fun goToRegistration() {
        start<RegisterActivity>()

    }


    override fun goToMainPage(user: UserUIModel) {
        val prefs = PreferenceHelper.defaultPrefs(this)

        //set any type of value in prefs
        prefs[Constants.USER_NAME] = AccountDetails.userName
        prefs[Constants.PASSWORD] = AccountDetails.password
        this.start<MainActivity>()
        this.finish()
    }

    override fun showError(error: Error) {
        Timber.e("We have errror %s", error.message)
        when (error.type) {
            Error.TOAST -> Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
            Error.ALERT -> {
            }
            Error.IN_LINE -> {
            }
        }


    }
    //endregion

}

