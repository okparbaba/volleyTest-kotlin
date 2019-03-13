package com.softwarefactory.sdk.server

import android.content.Context
import android.util.Log
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class ServerRequestManager(var context: Context) {
    val TAG = ServerRequestManager::class.java.simpleName
    private  var mContext: Context = context
    private  var mRequestQueue: RequestQueue = Volley.newRequestQueue(mContext)

    fun getPost(id: String, listener: OnRequestFinishedListener) {
        val data = JSONObject()
        try {
            data.put("post_id", id)
        } catch (je: JSONException) {
            Log.e(TAG, "Cannot create data object.", je)
        }

        val request = ServerRequest(mContext, "MB_POST_GETTING", data,
            Response.Listener { response -> listener.onSuccess(response) },
            Response.ErrorListener { error ->
                listener.onError(error as ServerError)
                Log.i("Error getting Version", error.toString())
            })
        mRequestQueue.add(request)
    }

    fun getAllPosts(listener: OnRequestFinishedListener) {
        val data = JSONObject()
        try {
            data.put("1","Apple")
            data.put("2","Orange")
            data.put("3","Pineapple")
        } catch (je: JSONException) {
            Log.e(TAG, "Cannot create data object.", je)
        }

        val request = ServerRequest(mContext, "MB_POST_GETTING", data,
            Response.Listener { response -> listener.onSuccess(response) },
            Response.ErrorListener { error ->
                listener.onError(error as ServerError)
                Log.i("Error getting Version", error.toString())
            })
        mRequestQueue.add(request)
    }


    interface OnRequestFinishedListener {
        /**
         * Callback method for success case.
         *
         * @param response Response object.
         */
        fun onSuccess(response: ServerResponse){}

        /**
         * Callback method for error case.
         *
         * @param err Error object
         */
        fun onError(err: ServerError){}
    }
}