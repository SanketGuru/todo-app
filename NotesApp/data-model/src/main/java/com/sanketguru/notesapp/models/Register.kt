package com.sanketguru.notesapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Bhavesh on 18-01-2018.
 */
data class Register(
                   @SerializedName("_id")
                    var id: String,

                    @SerializedName("userName")
                    @Expose var userName: String,

                    @SerializedName("password")
                    @Expose var password: String,

                    @SerializedName("accesstoken")
                    @Expose var accesstoken: String
)