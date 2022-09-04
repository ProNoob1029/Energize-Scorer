package com.phoenix.energizescorer.feature_editor.domain.repository

import com.phoenix.energizescorer.feature_editor.domain.model.Match
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getMatches(): Flow<List<Match>>

    fun getMatchByKey(key: String): Flow<Match?>

    suspend fun insertMatch(match: Match)

    suspend fun deleteMatch(match: Match)
}