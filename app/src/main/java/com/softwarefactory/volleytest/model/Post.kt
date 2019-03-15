package com.softwarefactory.volleytest.model

import org.json.JSONException
import org.json.JSONObject

data class Post(var id:String? = null,var title:String?=null,var body:String?=null){
    @Throws(JSONException::class)
    constructor(json: JSONObject) : this() {
        id = json.getString("id")
        title = json.getString("title")
        body = json.getString("body")

    }
}