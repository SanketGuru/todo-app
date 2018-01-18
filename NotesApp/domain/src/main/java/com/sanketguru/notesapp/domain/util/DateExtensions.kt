package com.sanketguru.notesapp.domain.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Sanket Gurav on 1/18/2018.
 */
/**
 * Returns a string representation of Date with @param [format]
 * */
infix fun Date.stringRepresentation(format: String) = SimpleDateFormat(format).format(this)
//        : CharSequence {
//    var df =  SimpleDateFormat(format)
//    return df.format(this);
//}

/**
 * Returns a Date representation of string @param [format]
 * */
@Throws(ParseException::class)
infix fun CharSequence.dateRepresentation(format: String) = SimpleDateFormat(format).parse(this.toString())

