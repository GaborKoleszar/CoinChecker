package com.koleszar.coinchecker.di

import com.koleszar.coinchecker.common.Constants
import com.koleszar.coinchecker.data.remote.CoinPaprikaApi
import com.koleszar.coinchecker.data.remote.CoinPaprikaApiImpl
import com.koleszar.coinchecker.data.remote.repository.CoinRepositoryImpl
import com.koleszar.coinchecker.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideCoinPaprikaApi(): CoinPaprikaApiImpl {
        return CoinPaprikaApiImpl(
            client = HttpClient(Android) {
                install(Logging) {
                    level = LogLevel.ALL
                }
                install(JsonFeature) {
                    serializer = KotlinxSerializer()
                }
                install(HttpTimeout) {
                    requestTimeoutMillis = Constants.TIMEOUTMILLIS
                    connectTimeoutMillis = Constants.TIMEOUTMILLIS
                    socketTimeoutMillis = Constants.TIMEOUTMILLIS
                }
                defaultRequest {
                    if (this.method != HttpMethod.Get) contentType(ContentType.Application.Json)
                    accept(ContentType.Application.Json)
                }
            }
        )
    }

    @Provides
    @Singleton
    fun providesCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}