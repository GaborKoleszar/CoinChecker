package com.koleszar.coinchecker.data.remote.repository

import com.koleszar.coinchecker.data.remote.CoinPaprikaApi
import com.koleszar.coinchecker.data.remote.dto.CoinDetailDto
import com.koleszar.coinchecker.data.remote.dto.CoinDto
import com.koleszar.coinchecker.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api : CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}