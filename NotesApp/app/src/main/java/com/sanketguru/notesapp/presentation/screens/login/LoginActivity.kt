package com.sanketguru.notesapp.presentation.screens.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.sanketguru.notesapp.R
import com.sanketguru.notesapp.data.repo.UserRepositoryImpl
import com.sanketguru.notesapp.domain.module.Error
import com.sanketguru.notesapp.domain.module.UserUIModel
import com.sanketguru.notesapp.presentation.screens.main.MainActivity
import com.sanketguru.notesapp.presentation.utils.extensions.onClick
import com.sanketguru.notesapp.presentation.utils.extensions.start
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.login.*
import timber.log.Timber


/**
 * Created by Bhavesh on 02-01-2018.
 */
class LoginActivity : AppCompatActivity(), LoginContract.View {


    val presenter = LoginPresenter(this, UserRepositoryImpl(), AndroidSchedulers.mainThread())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        buttonLogin.onClick {
            presenter.doLogin(UserUIModel(userName = etUserName.text.toString(), password = etPassword.text.toString()))
        }



    }

    //region  LoginContract.View implementation


    override fun goToRegistration() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToMainPage(user: UserUIModel) {
        Timber.v("Vgot data : %s", user.userName)
        Toast.makeText(this, "Hi ${user.userName}", Toast.LENGTH_LONG).show()
           this.start<MainActivity>()
    }

    override fun showError(error: Error) {
        Timber.e("We have errror ${error.message}")
        when(error.type){
            Error.TOAST -> Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
        }


    }
    //endregion

}