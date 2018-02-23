package com.sanketguru.notesapp.core

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager


/**
 * Created by sanket on 2/22/2018.
 */
open class LeanBaseFragment : Fragment() {
    open protected val layout = -1
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(layout, container, false)

    protected fun hideKeyboard(tv: View) {
        val imm = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (imm.isAcceptingText) {
            imm.hideSoftInputFromWindow(tv.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }
}

open class CommonFragment : LeanBaseFragment() {
    var previousFragment: CommonFragment? = null
    private val mContext: CommonActivity by lazy { super.getActivity() as CommonActivity }
    val backPressEnabled = true
    private val CONNECTED = true
    private val DISCONNECTED = false
    private var CURR_NETWORK_STATE = CONNECTED
    private lateinit var containerView: ViewGroup
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        containerView = view as ViewGroup

    }

    fun sendServiceRequest(): Unit {}
    /**
     * Shows the universal loading screen.
     */
    fun showProgress() = if (mContext != null) mContext.showProgress() else Unit


    /**
     * Hides the universal loading screen.
     */
    fun hideProgress() = if (mContext != null) mContext.hideProgress() else Unit

    fun alert(message: CharSequence) {
        hideProgress()
        // AlertDialogHelper.alertDialogOnly(context, getString(R.string.alert_dialog_title), message)
    }


}