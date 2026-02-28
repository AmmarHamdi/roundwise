package com.roundwise.domain.repository

import com.roundwise.domain.model.RoundingRule
import kotlinx.coroutines.flow.Flow

interface RoundingRuleRepository {
    fun observeActive(): Flow<RoundingRule?>
    fun observeAll(): Flow<List<RoundingRule>>
    suspend fun upsert(rule: RoundingRule)
    suspend fun setActive(id: Long)
}