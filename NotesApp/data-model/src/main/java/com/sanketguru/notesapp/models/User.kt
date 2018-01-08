package com.sanketguru.notesapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Sanket Gurav on 1/2/2018.
 */

 data  class User(
        @SerializedName("_id") var id: String,
        @SerializedName("userName") @Expose var userName: String,
        @SerializedName("password") @Expose var password: String,
        @SerializedName("accesstoken") @Expose var accesstoken: String
)
