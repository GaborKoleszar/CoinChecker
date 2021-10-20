package com.koleszar.coinchecker.domain.model

import com.koleszar.coinchecker.data.remote.dto.TeamItem

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamItem>
)
