package com.saurabh.datahandlinginkotlin.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.saurabh.datahandlinginkotlin.constants.LOG_TAG
import com.saurabh.datahandlinginkotlin.data.Monster
import com.saurabh.datahandlinginkotlin.data.MonsterRepository
import com.saurabh.datahandlinginkotlin.utilities.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import  com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


class MainViewModel(app:Application) : AndroidViewModel(app) {
    // class to have the data from json file
    private var dataRepo = MonsterRepository()

    init {
      //  val text = FileHelper.getTextFromResources(app, R.raw.monster_data)
        val monsterData = dataRepo.getMonsterData(app)
        for (monster in monsterData) {
            Log.i(LOG_TAG,"${monster.name} (\$${monster.price})")
        }
    }

}