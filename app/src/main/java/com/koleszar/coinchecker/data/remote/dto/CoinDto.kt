package com.koleszar.coinchecker.data.remote.dto

import com.koleszar.coinchecker.domain.model.Coin
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinDto(
    val symbol: String = "",
    @SerialName("is_active")
    val isActive: Boolean = false,
    @SerialName("is_new")
    val isNew: Boolean = false,
    val name: String = "",
    val rank: Int = 0,
    val id: String = "",
    val type: String = ""
)

fun CoinDto.toCoin(): Coin {

    return Coin(symbol = symbol, isActive = isActive, name = name, rank = rank, id = id)
}