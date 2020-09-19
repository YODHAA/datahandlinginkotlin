package com.saurabh.datahandlinginkotlin.utilities

import android.content.Context
import android.content.LocusId

class FileHelper {

    companion object {
        fun getTextFromResources(context: Context , resourceId: Int) : String {
            return context.resources.openRawResource(resourceId).use {
                it.bufferedReader().use {
                    it.readText()
                }
            }
        }

        fun getTextFromAssets(context: Context , fileName: String) : String {
            return context.assets.open(fileName).use {
                it.bufferedReader().use {
                    it.readText()
                }
            }
        }

    }


}