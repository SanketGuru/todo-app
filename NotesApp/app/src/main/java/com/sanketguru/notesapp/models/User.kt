package com.sanketguru.notesapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Sanket Gurav on 1/2/2018.
 */

class User {
    @SerializedName("_id")
    @Expose
    var id = ""
    @SerializedName("userName")
    @Expose
    var userName = ""
    @SerializedName("password")
    @Expose
    var password = ""
    @SerializedName("accesstoken")
    @Expose
    var accesstoken=""
}
