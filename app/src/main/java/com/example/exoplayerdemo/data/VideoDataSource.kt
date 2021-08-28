package com.example.exoplayerdemo.data

import android.content.Context
import com.google.gson.Gson
import java.io.IOException

class VideoDataSource {
    fun loadInformation(context: Context): VideoList? {
        val jsonString = loadFileFromAssets(context, "videos.json")
        return Gson().fromJson(jsonString, VideoList::class.java)
    }

    private fun loadFileFromAssets(context: Context, filename: String): String? {
        var json: String? = null
        try {
            val inputS = context.assets.open(filename)
            val size = inputS.available()
            val buffer = ByteArray(size)
            inputS.read(buffer)
            inputS.close()
            json = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return json
    }
}