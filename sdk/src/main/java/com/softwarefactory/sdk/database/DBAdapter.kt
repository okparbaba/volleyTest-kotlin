package com.softwarefactory.sdk.database

import android.content.Context
import com.softwarefactory.sdk.model.Post
import java.util.ArrayList

class DBAdapter(context: Context) {

    protected val TAG = DBAdapter::class.java.simpleName

    private lateinit var mDbHelper: DataBaseHelper

    fun DBAdapter(context: Context) {
        mDbHelper = DataBaseHelper(context)
    }

    fun getPost(): List<Post> {
        val posts = ArrayList<Post>()
        val db = mDbHelper.readableDatabase
        val sql = "SELECT * FROM post WHERE id > 0 ORDER BY title"
        val mCur = db.rawQuery(sql, null)
        try {
            if (mCur.moveToFirst()) {
                do {
                    val post = Post()

                    post.title=mCur.getString(mCur.getColumnIndex("code_id"))
                    post.body=mCur.getString(mCur.getColumnIndex("nice_name"))

                    posts.add(post)
                } while (mCur.moveToNext())

                return posts
            }
        } finally {
            mCur.close()
            db.close()
        }
        return posts
    }
}