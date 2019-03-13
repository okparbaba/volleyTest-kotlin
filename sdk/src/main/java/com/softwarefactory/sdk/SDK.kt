package com.softwarefactory.sdk

import android.content.Context
import android.util.Log
import com.softwarefactory.sdk.constant.CommonConstant
import com.softwarefactory.sdk.database.DataBaseHelper
import com.softwarefactory.sdk.listener.StatusListener
import java.io.IOException

class SDK {
    private val TAG = SDK::class.java.simpleName

    fun initialize(mContext: Context, listener: StatusListener) {
        val mDbHelper = DataBaseHelper(mContext)
        try {
            mDbHelper.createDataBase()

            mDbHelper.close()

            listener.onSuccess()
        } catch (e: IOException) {
            Log.e(TAG, "Database create fail.", e)
            listener.onError(CommonConstant.DB_CREATE_FAIL)
        }

    }
}