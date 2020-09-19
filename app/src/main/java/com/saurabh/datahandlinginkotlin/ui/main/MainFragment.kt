package com.saurabh.datahandlinginkotlin.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.saurabh.datahandlinginkotlin.R
import com.saurabh.datahandlinginkotlin.constants.LOG_TAG
import com.saurabh.datahandlinginkotlin.data.Monster

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val monster = Monster("Bob", "myfile", "a caption",
            "a description", .19, 3)
        Log.i(LOG_TAG, monster.toString())
        return inflater.inflate(R.layout.main_fragment,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }
}