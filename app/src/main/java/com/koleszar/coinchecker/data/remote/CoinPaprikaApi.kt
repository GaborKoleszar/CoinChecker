package com.koleszar.coinchecker.data.remote

import com.koleszar.coinchecker.data.remote.dto.CoinDetailDto
import com.koleszar.coinchecker.data.remote.dto.CoinDto

interface CoinPaprikaApi {
    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(id : String) : CoinDetailDto?
}