
package com.sanketguru.notesapp.presentation.screens.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.sanketguru.notesapp.OnFragmentInteractionListener
import com.sanketguru.notesapp.R
import com.sanketguru.notesapp.presentation.screens.BasePresenter

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View, OnFragmentInteractionListener {

   // private var listaFragment: CreateFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val fragmentTransaction = fragmentManager
                    .beginTransaction()
          //  val postLoginFragment = CreateFragment()
        //    fragmentTransaction.replace(R.id.fragment, postLoginFragment)
            fragmentManager.popBackStack()
            fragmentTransaction.commit()
        }

        val fragmentTransaction = fragmentManager
                .beginTransaction()
//        val postLoginFragment = ListFragment()
//        fragmentTransaction.replace(R.id.fragment, postLoginFragment)
//        fragmentManager.popBackStack()
//        fragmentTransaction.commit()


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    //region Fragment Interaction
    override fun onFragmentInteraction(data: Any) {
        //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addFragmentToMain(fragment: Fragment, addToBackstack: Boolean) {
        //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setTitleHead(title: CharSequence) {
        //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideToolbar(hide: Boolean) {
        //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun lockDrawer(lock: Boolean) {
        //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    //endregion
}
interface MainContract{
    interface View{}
    interface Presenter : BasePresenter {}
}
