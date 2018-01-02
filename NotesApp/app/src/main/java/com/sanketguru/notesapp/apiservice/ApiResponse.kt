package com.sanketguru.notesapp.apiservice

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Sanket Gurav on 1/2/2018.
 */
/**Wrapper Class around Every response*/
class ApiResponse<E> {
    @SerializedName("status")
    @Expose
    var isSuccess = false
    @SerializedName("message")
    @Expose
    var errorMessage = ""
    @SerializedName("payload")
    @Expose
    var payload: E? = null
}