package com.sanketguru.notesapp.presentation.screens.login

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.jakewharton.rxbinding2.view.RxView
import com.sanketguru.notesapp.R
import com.sanketguru.notesapp.data.repo.UserRepositoryImpl
import com.sanketguru.notesapp.domain.module.AccountDetails
import com.sanketguru.notesapp.domain.module.Error
import com.sanketguru.notesapp.domain.module.UserUIModel
import com.sanketguru.notesapp.presentation.common.CommonUtils
import com.sanketguru.notesapp.presentation.common.Constants.Companion.PASSWORD
import com.sanketguru.notesapp.presentation.common.Constants.Companion.USER_NAME
import com.sanketguru.notesapp.presentation.screens.main.MainActivity
import com.sanketguru.notesapp.presentation.screens.register.RegisterActivity
import com.sanketguru.notesapp.presentation.utils.extensions.PreferenceHelper
import com.sanketguru.notesapp.presentation.utils.extensions.PreferenceHelper.get
import com.sanketguru.notesapp.presentation.utils.extensions.PreferenceHelper.set
import com.sanketguru.notesapp.presentation.utils.extensions.onClick
import com.sanketguru.notesapp.presentation.utils.extensions.start
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.login.*
import timber.log.Timber


/**
 * Created by Bhavesh on 02-01-2018.
 */
class LoginActivity() : AppCompatActivity(), LoginContract.View {
    var mProgressDialog: ProgressDialog? = null
    override fun showLoading() {
        hideLoading()
        mProgressDialog = CommonUtils.showLoadingDialog(this)

    }
    override val login: Observable<UserUIModel> by lazy{
        RxView.clicks(buttonLogin).map { UserUIModel(userName = etUserName.text.toString(), password = etPassword.text.toString()) }
    }

    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing()) {
            mProgressDialog!!.cancel()
        }
    }


    val presenter = LoginPresenter(this, UserRepositoryImpl(), AndroidSchedulers.mainThread())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

       /* buttonLogin.onClick {
            buttonLogin.isEnabled = false
            presenter.doLogin(UserUIModel(userName = etUserName.text.toString(), password = etPassword.text.toString()))
        }*/
        presenter.start()
        buttonRegister.onClick {
            goToRegistration()
        }

    }

    //region  LoginContract.View implementation

    override fun onDestroy() {
        presenter.stop()
        super.onDestroy()
    }
    override fun goToRegistration() {
        start<RegisterActivity>()

    }


    override fun goToMainPage(user: UserUIModel) {
        //get default prefs
        val prefs = PreferenceHelper.defaultPrefs(this)

        //set any type of value in prefs
        prefs[USER_NAME] = AccountDetails.userName
        prefs[PASSWORD] = AccountDetails.password

        //get any value from prefs
        val userName: String? = prefs[USER_NAME]

        //get value from prefs (with default value)
        val password: String? = prefs[PASSWORD, "12345"]

        Log.d("UserNme", "name : $userName")
        Log.d("Password", " $password")
        Timber.v("we got data : %s", user.userName)
        Toast.makeText(this, "Hi ${user.userName}", Toast.LENGTH_LONG).show()
        this.start<MainActivity>()
        this.finish()
    }

    override fun showError(error: Error) {
        buttonLogin.isEnabled = true
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






