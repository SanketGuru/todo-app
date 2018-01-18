package com.sanketguru.notesapp.presentation.utils.extensions

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.content.ContextCompat

/**
 * Created by Sanket on 19.09.2017.
 */
 inline fun <reified T> Activity.start(bundel : Bundle = Bundle()) {
    var intent=Intent(this, T::class.java)
    intent.putExtras(bundel)
    this.startActivity(intent)
}

fun Activity.isPortrait() = this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT

infix fun Activity.takeColor(colorId: Int) = ContextCompat.getColor(this, colorId)
