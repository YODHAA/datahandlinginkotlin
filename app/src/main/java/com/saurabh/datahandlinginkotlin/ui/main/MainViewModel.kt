package com.saurabh.datahandlinginkotlin.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.saurabh.datahandlinginkotlin.constants.LOG_TAG
import com.saurabh.datahandlinginkotlin.data.Monster
import com.saurabh.datahandlinginkotlin.utilities.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import  com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


class MainViewModel(app:Application) : AndroidViewModel(app) {
    // class to have the data from json file

    private val listType = Types.newParameterizedType(
        List::class.java , Monster::class.java
    )

    init {
      //  val text = FileHelper.getTextFromResources(app, R.raw.monster_data)
        val text = FileHelper.getTextFromAssets(app, "monster_data.json")
        Log.i(LOG_TAG, text )
        parseText(text)
    }

    private fun parseText(text : String) {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val adapter : JsonAdapter<List<Monster>> = moshi.adapter(listType)
        val monsterData = adapter.fromJson(text)

        for (monster in monsterData ?: emptyList()) {
            Log.i(LOG_TAG,"${monster.name} (\$${monster.price})")
        }
    }







   // private var listType =
}