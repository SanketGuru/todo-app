package com.sanketguru.notesapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by Sanket Gurav on 1/2/2018.
 */

open class Note {
    @SerializedName("_id")
    @Expose
    var id = ""
    @SerializedName("ownerId")
    @Expose
    var onerid = ""
    @SerializedName("title")
    @Expose
    var title = ""
    @SerializedName("type")
    @Expose
    var type = 0
    @SerializedName("status")
    @Expose
    var status = 0
    @SerializedName("sharedWith")
    @Expose
    var sharedWith: List<String> = ArrayList()
    @SerializedName("creationDate")
    @Expose
    var creationDate = Date()
    @SerializedName("doByDate")
    @Expose
    var doByDate = Date()
    @SerializedName("lastEdited")
    @Expose
    var lastEdited = Date()


}
data class TextNote (   @SerializedName("text") @Expose val text: String) : Note()
