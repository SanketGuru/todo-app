package com.sanketguru.notesapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.util.ArrayList

/**
 * Created by Bhavesh on 04-01-2018.
 */

class ListNotesResponse {

    //    "pageSize": 2,
    //            "pageNumber": 3,
    //            "totalCount": 7,
    //@SerializedName("text")
    //@Expose

    @SerializedName("pageSize")
    @Expose
    var pageSize = 0
    @SerializedName("pageNumber")
    @Expose
   var pageNumber = 0
    @SerializedName("totalCount")
    @Expose
     var totalCount = 0
    @SerializedName("list")
    @Expose
     var listTextNote= mutableListOf<TextNote>()

}
