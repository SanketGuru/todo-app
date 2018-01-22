package com.sanketguru.notesapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Bhavesh on 03-01-2018.
 */
data class CreateNote( @SerializedName("note") @Expose var note : TextNote)