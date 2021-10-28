package com.koleszar.coinchecker.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.koleszar.coinchecker.R
import com.koleszar.coinchecker.data.remote.CoinPaprikaApiImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var api: CoinPaprikaApiImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO Dummy call only - delete
        GlobalScope.launch { Log.d(TAG, "onCreate: " + api.getCoins()) }

        setContentView(R.layout.activity_main)
    }
}