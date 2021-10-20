package com.koleszar.coinchecker.domain.repository

import com.koleszar.coinchecker.data.remote.dto.CoinDetailDto
import com.koleszar.coinchecker.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto?
}