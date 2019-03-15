package com.softwarefactory.sdk.server

import com.android.volley.VolleyError

import org.json.JSONException
import org.json.JSONObject

class ServerError : VolleyError {
    var errorCode: Int = 0

    private var mErrorMessage: String? = null
    constructor() : super() {}
    constructor(code: Int, msg: String) : super() {
        errorCode = code
        mErrorMessage = msg
    }
    @Throws(JSONException::class)
    constructor(json: JSONObject) {
        errorCode = json.getInt("err_code")
        mErrorMessage = json.getString("err_msg")
    }

    fun getmessage(): String? {
        return mErrorMessage
    }

    fun setMessage(errorMessage: String) {
        mErrorMessage = errorMessage
    }

    override fun toString(): String {
        return ("ServerError (code=" + errorCode + ", msg=" + mErrorMessage
                + ")")
    }
    object Code {

        /**
         * Client request token is expired.
         */
        val TOKEN_EXPIRED = 10029

        val JSON_EXCEPTION = 1

        val NETWORK_ERROR = 2

        val NO_CURRENT_PLAN = 10066

        val LESSON_BOOKED_IN_PACKAGE = 10086

        val CLASS_ALREADY_BOOKED = 10086

        val BOOKING_DATE_NOT_AVAILABLE = 10087

        val TOPIC_ALREADY_BOOKED = 10090

        val HIGHER_TOPIC_LEVEL = 10091

        val HIGHER_PACKAGE_LEVEL = 10076

        val LESSON_CONTAINS_IN_PACKAGE = 10097

        val INSUFFICIENT_BALANCE = 10052

        val CHINESE_LEVEL_LOWER = 10076

        val NO_TUTOR_SCHEDULE = 10065

        val NO_OPERATOR_ONLINE = 10077

    }
    /**
     * Email address is already exist. Cannot use this email to register new
     * account.
     */// public static final int EMAIL_ALREADY_EXISTS = 10005;
}
