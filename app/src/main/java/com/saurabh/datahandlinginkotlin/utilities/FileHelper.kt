package com.saurabh.datahandlinginkotlin.utilities

import android.content.Context
import android.content.LocusId

class FileHelper {

    companion object {
        fun getTextFromResources(context: Context , resourceId: Int) {
            return context.resources.openRawResource(resourceId).use {
                it.bufferedReader().use {
                    it.readText()
                }
            }
        }
    }


}