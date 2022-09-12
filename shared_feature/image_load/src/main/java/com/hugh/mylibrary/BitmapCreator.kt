package com.hugh.mylibrary

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

object BitmapCreator {
    suspend fun getImageSource(url: String): Bitmap? {
        return withContext(Dispatchers.IO) {
            var connection: HttpURLConnection? = null

            try {
                connection = URL(url).openConnection() as HttpURLConnection
                connection.doInput = true
                connection.connect()

                val input = connection.inputStream
                BitmapFactory.decodeStream(input)
            } catch (e: Exception) {
                Log.e("error", e.stackTraceToString())
                null
            } finally {
                connection?.disconnect()
            }
        }
    }
}