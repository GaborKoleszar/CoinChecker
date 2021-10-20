package com.koleszar.coinchecker.data.remote.dto

import com.koleszar.coinchecker.domain.model.CoinDetail

data class CoinDetailDto(
    val symbol: String = "",
    val parent: Parent,
    val proofType: String = "",
    val description: String = "",
    val type: String = "",
    val contracts: List<ContractsItem>?,
    val platform: String = "",
    val lastDataAt: String = "",
    val whitepaper: Whitepaper,
    val orgStructure: String = "",
    val hardwareWallet: Boolean = false,
    val developmentStatus: String = "",
    val hashAlgorithm: String = "",
    val rank: Int = 0,
    val links: Links,
    val id: String = "",
    val isActive: Boolean = false,
    val isNew: Boolean = false,
    val contract: String = "",
    val firstDataAt: String = "",
    val team: List<TeamItem>,
    val linksExtended: List<LinksExtendedItem>?,
    val message: String = "",
    val tags: List<TagsItem>,
    val name: String = "",
    val startedAt: String = "",
    val openSource: Boolean = false
)

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}