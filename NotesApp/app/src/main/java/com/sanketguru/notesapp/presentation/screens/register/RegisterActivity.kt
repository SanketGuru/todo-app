package com.sanketguru.notesapp.presentation.screens.register

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sanketguru.notesapp.R
import com.sanketguru.notesapp.data.repo.RegisterRepositoryImpl
import com.sanketguru.notesapp.domain.module.Error
import com.sanketguru.notesapp.domain.module.RegisterUIModel
import com.sanketguru.notesapp.presentation.utils.extensions.onClick
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.login.*

/**
 * Created by Bhavesh on 08-01-2018.
 */
class RegisterActivity : AppCompatActivity(), RegisterContract.View {
    override fun finishPage() {
        finish()
    }

   private val presenter = RegistrationPresenter(this, RegisterRepositoryImpl(), AndroidSchedulers.mainThread())

    override fun showError(error: Error) {
         }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        buttonRegister.onClick {
           // buttonRegister.isEnabled = false
            presenter.doRegister(RegisterUIModel(userName = etUserName.text.toString(), password = etPassword.text.toString()))
        }
    }

}