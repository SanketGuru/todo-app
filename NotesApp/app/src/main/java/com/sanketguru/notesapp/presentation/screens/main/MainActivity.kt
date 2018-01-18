package com.sanketguru.notesapp.presentation.screens.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.sanketguru.notesapp.OnFragmentInteractionListener
import com.sanketguru.notesapp.R
import com.sanketguru.notesapp.domain.module.TextNote
import com.sanketguru.notesapp.presentation.screens.BasePresenter
import com.sanketguru.notesapp.presentation.screens.main.note.CreateFragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View, OnFragmentInteractionListener {


    val presenter: MainContract.Presenter = MainPresenter(this)
    // private var listaFragment: CreateFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
//region setup
        fab.setOnClickListener { presenter.createNote() }
        //endregion
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

    //region View contract impl
    override fun openNote(note: TextNote) {
        replaceFragmentToMain(CreateFragment.newInstance(note = note))
    }

    //end region

    //region Fragment Interaction
    override fun onFragmentInteraction(data: Any) {
        //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addFragmentToMain(fragment: Fragment, addToBackstack: Boolean) {
        //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun replaceFragmentToMain(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, fragment)
        supportFragmentManager.popBackStack()
        fragmentTransaction.commit()
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

interface MainContract {
    interface View {
        fun openNote(notesApp: TextNote)
    }

    interface Presenter : BasePresenter {
        fun createNote()
    }
}
