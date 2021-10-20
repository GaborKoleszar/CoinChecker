package com.koleszar.coinchecker.data.remote

import com.koleszar.coinchecker.common.Constants
import com.koleszar.coinchecker.data.remote.dto.CoinDetailDto
import com.koleszar.coinchecker.data.remote.dto.CoinDto
import io.ktor.client.*
import io.ktor.client.request.*

class CoinPaprikaApiImpl(
    private val client: HttpClient
) : CoinPaprikaApi {

    override suspend fun getCoins(): List<CoinDto> {
        return client.get { url(Constants.ALL_COINS) }
    }

    override suspend fun getCoinById(id: String): CoinDetailDto {
        return client.get { url("${Constants}.ALL_COINS/$id") }
    }
}