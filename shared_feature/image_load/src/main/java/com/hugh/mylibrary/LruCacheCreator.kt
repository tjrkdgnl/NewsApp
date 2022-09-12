package com.hugh.mylibrary

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.collection.LruCache

object LruCacheCreator {

    private lateinit var lruCache: LruCache<String, Bitmap>

    fun getInstance(): LruCache<String, Bitmap> {
        if (!LruCacheCreator::lruCache.isInitialized) {
            val size = (Runtime.getRuntime().maxMemory() / 1024).toInt()
            val cacheSize = size / 8

            lruCache = object : LruCache<String, Bitmap>(cacheSize) {
                override fun sizeOf(key: String, bitmap: Bitmap): Int {
                    return bitmap.byteCount / 1024
                }
            }
        }

        return lruCache
    }

    private fun calculateInThumbNailsSize(
        options: BitmapFactory.Options,
        reqWidth: Int,
        reqHeight: Int
    ): Int {
        val (height, width) = options.run { outHeight to outWidth }
        var isThumbNailSize = 1

        if (height > reqHeight || width > reqWidth) {
            val halfHeight = height / 2
            val halfWidth = width / 2

            while (halfHeight / isThumbNailSize >= reqHeight && halfWidth / isThumbNailSize >= reqWidth) {
                isThumbNailSize *= 2
            }
        }

        return isThumbNailSize
    }

    fun decodeThumbNailBitmapFromResource(
        res: Resources,
        resId: Int,
        reqWidth: Int,
        reqHeight: Int
    ): Bitmap? {
        return try {
            BitmapFactory.Options().run {
                inJustDecodeBounds = true
                BitmapFactory.decodeResource(res, resId, this)

                inSampleSize = calculateInThumbNailsSize(this, reqWidth, reqHeight)

                inJustDecodeBounds = false

                BitmapFactory.decodeResource(res, resId, this)
            }
        } catch (e: Exception) {
            Log.e("calculateBitmap", e.stackTraceToString())
            null
        }
    }
}