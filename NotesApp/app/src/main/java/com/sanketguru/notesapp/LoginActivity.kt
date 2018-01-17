package com.sanketguru.notesapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.sanketguru.notesapp.data.repo.UserRepositoryImpl
import com.sanketguru.notesapp.domain.presentation.Error
import com.sanketguru.notesapp.domain.presentation.LoginContract
import com.sanketguru.notesapp.domain.presentation.LoginPresenter
import com.sanketguru.notesapp.module.UserUIModel
import com.sanketguru.notesapp.presentation.utils.extensions.onClick
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.login.*
import timber.log.Timber


/**
 * Created by Bhavesh on 02-01-2018.
 */
class LoginActivity : AppCompatActivity(), LoginContract.View {


    val presenter = LoginPresenter(this, UserRepositoryImpl())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        buttonLogin.onClick {
            presenter.doLogin(UserUIModel(userName = etUserName.text.toString(), password = etPassword.text.toString()))
        }
//val dd=Listner(presenter.getError())
        presenter.getError()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Error> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(error: Error) {
                        Log.v("Say", "Got it qwe" + error.message)
                        // this@LoginActivity.runOnUiThread( java.lang.Runnable {
                        Toast.makeText(this@LoginActivity, "Hi ${error.message}", Toast.LENGTH_LONG).show();
                        //   })
                    }

                    override fun onError(e: Throwable) {

                    }

                    override fun onComplete() {

                    }
                })
        /*  presenter.getError().subscribe({
              print("HGfjhfhjvx "+it.message)
          }
          )*/
        // .subscribe( )

    }

    //region  LoginContract.View implementation


    override fun goToRegistration() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToMainPage(user: UserUIModel) {
        Timber.v("Vgot data : %s", user.userName)
        Toast.makeText(this, "Hi ${user.userName}", Toast.LENGTH_LONG).show();
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(type: Int, message: CharSequence) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    //endregion

}