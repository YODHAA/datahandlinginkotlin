package com.saurabh.datahandlinginkotlin.data

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.saurabh.datahandlinginkotlin.utilities.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MonsterRepository(val app:Application) {

    val monsterData = MutableLiveData<List<Monster>>()

    private val listType = Types.newParameterizedType(
        List::class.java , Monster::class.java
    )
    init {
        getMonsterData()
    }

     fun getMonsterData() {
         val text = FileHelper.getTextFromAssets(app, "monster_data.json")
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val adapter : JsonAdapter<List<Monster>> = moshi.adapter(listType)
        monsterData.value =  adapter.fromJson(text)?: emptyList()
    }
}