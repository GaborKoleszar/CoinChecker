package com.koleszar.coinchecker.data.remote.dto

import com.koleszar.coinchecker.domain.model.Coin

data class CoinDto(
    val symbol: String = "",
    val isActive: Boolean = false,
    val isNew: Boolean = false,
    val name: String = "",
    val rank: Int = 0,
    val id: String = "",
    val type: String = ""
)

fun CoinDto.toCoin(): Coin {

    return Coin(symbol = symbol, isActive = isActive, name = name, rank = rank, id = id)
}