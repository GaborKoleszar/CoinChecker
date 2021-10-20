package com.koleszar.coinchecker.domain.usecase

import com.koleszar.coinchecker.common.Resource
import com.koleszar.coinchecker.data.remote.dto.toCoin
import com.koleszar.coinchecker.domain.model.Coin
import com.koleszar.coinchecker.domain.repository.CoinRepository
import io.ktor.client.features.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: ResponseException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Network error, check internet connection"))
        }
    }
}