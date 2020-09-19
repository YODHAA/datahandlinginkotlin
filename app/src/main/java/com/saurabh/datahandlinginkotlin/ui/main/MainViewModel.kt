package com.saurabh.datahandlinginkotlin.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.saurabh.datahandlinginkotlin.R
import com.saurabh.datahandlinginkotlin.constants.LOG_TAG
import com.saurabh.datahandlinginkotlin.utilities.FileHelper


class MainViewModel(app:Application) : AndroidViewModel(app) {

    // class to have the data from json file

    init {
      //  val text = FileHelper.getTextFromResources(app, R.raw.monster_data)
        val text = FileHelper.getTextFromAssets(app, "monster_data.json")
        Log.i(LOG_TAG, text )
    }

    



   // private var listType =
}