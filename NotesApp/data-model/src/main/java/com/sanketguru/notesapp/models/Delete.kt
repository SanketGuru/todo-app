package com.sanketguru.notesapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Raju on 23-02-2018.
 */
data  class Delete(
        @SerializedName("id") var id: List<String>

)