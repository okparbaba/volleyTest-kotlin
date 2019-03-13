package com.softwarefactory.sdk.database

import android.content.ContentValues
import android.content.Context
import android.database.SQLException
import android.util.Log
import com.softwarefactory.sdk.model.Post
import java.util.ArrayList

class PostAdapter {
    protected val TAG = PostAdapter::class.java.simpleName

    private lateinit var mDbHelper: DataBaseHelper

    fun TutorAdapter(context: Context) {
        mDbHelper = DataBaseHelper(context)
    }

    fun insertTutors(posts: MutableList<Post>) {
        val db = mDbHelper.writableDatabase

        try {
            db.beginTransaction()

            db.delete("post", null, null)

            for (post in posts) {
                val values = ContentValues()
                values.put("title", post.title)
                values.put("body", post.body)

                db.insert("tutor", null, values)
            }

            db.setTransactionSuccessful()
        } catch (e: Exception) {
            Log.e(TAG, "Tutor information update fail.", e)
        } finally {
            db.endTransaction()
            db.close()
        }
    }

    fun getAllTutor(): MutableList<Post> {
        val posts = ArrayList<Post>()
        val db = mDbHelper.readableDatabase
        try {
            val sql = "SELECT * FROM post"

            val mCur = db.rawQuery(sql, null)
            if (mCur.moveToFirst()) {
                do {
                    val post = Post()
                    post.title=mCur.getString(mCur.getColumnIndex("account_id"))
                    post.body=mCur.getString(mCur.getColumnIndex("company_id"))

                    posts.add(post)
                } while (mCur.moveToNext())
            }

            mCur.close()
        } catch (mSQLException: SQLException) {
            Log.e(TAG, "getTestData >>$mSQLException")
        } finally {
            db.close()
        }
        return posts
    }
}