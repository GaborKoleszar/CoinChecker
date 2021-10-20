package com.koleszar.coinchecker.data.remote

import com.koleszar.coinchecker.common.HttpRoutes
import com.koleszar.coinchecker.data.remote.dto.CoinDetailDto
import com.koleszar.coinchecker.data.remote.dto.CoinDto
import io.ktor.client.*
import io.ktor.client.request.*

class CoinPaprikaApiImpl(
    private val client: HttpClient
) : CoinPaprikaApi {
    override suspend fun getCoins(): List<CoinDto> {

        return try {
            client.get { url(HttpRoutes.ALL_COINS) }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getCoinById(id: String): CoinDetailDto? {

        return try {
            client.get { url("$HttpRoutes.ALL_COINS/$id") }
        } catch (e: Exception) {
            null
        }
    }
}