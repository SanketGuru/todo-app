package com.sanketguru.notesapp.presentation.screens.register

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.sanketguru.notesapp.R
import com.sanketguru.notesapp.data.repo.RegisterRepositoryImpl
import com.sanketguru.notesapp.domain.module.RegisterError
import com.sanketguru.notesapp.domain.module.RegisterUIModel
import com.sanketguru.notesapp.presentation.utils.extensions.get
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

    override fun showError(error: RegisterError) {

        val dd = this[R.string.abc_font_family_button_material]

        showSnackBar(error)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        buttonRegister.onClick {
            // buttonRegister.isEnabled = false
            presenter.doRegister(RegisterUIModel(userName = etUserName.text.toString(), password = etPassword.text.toString()))
        }
    }

    private fun showSnackBar(error: RegisterError) {
        when (error.type) {
            RegisterError.USER_NAME -> {
                etUserName.error = error.message
                etUserName.requestFocus()
            }
            RegisterError.PASSWORD -> {
                etPassword.error = error.message
                etPassword.requestFocus()
            }
            RegisterError.Success -> {
                Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
            }
            RegisterError.WebServerError -> {
                Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
            }

        }
        /*  val snackbar = Snackbar.make(findViewById(android.R.id.content),
                  error.message.toString(), Snackbar.LENGTH_SHORT)
          val sbView = snackbar.view
          val textView = sbView
                  .findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
          textView.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
          snackbar.show()
          }*/
    }

}