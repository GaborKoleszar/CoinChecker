package com.koleszar.coinchecker.domain.usecase

import com.koleszar.coinchecker.common.Resource
import com.koleszar.coinchecker.data.remote.dto.toCoinDetail
import com.koleszar.coinchecker.domain.model.CoinDetail
import com.koleszar.coinchecker.domain.repository.CoinRepository
import io.ktor.client.features.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: ResponseException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Network error, check internet connection"))
        }
    }
}