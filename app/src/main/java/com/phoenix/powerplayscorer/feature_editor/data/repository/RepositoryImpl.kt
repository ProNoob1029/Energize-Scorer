package com.phoenix.powerplayscorer.feature_editor.data.repository

import com.phoenix.powerplayscorer.feature_editor.data.data_source.MatchDao
import com.phoenix.powerplayscorer.feature_editor.domain.model.Match
import com.phoenix.powerplayscorer.feature_editor.domain.repository.Repository
import com.phoenix.powerplayscorer.feature_editor.domain.use_case.auth.AuthUseCases
import kotlinx.coroutines.flow.Flow

class RepositoryImpl (
    private val dao: MatchDao,
    private val authUseCases: AuthUseCases
): Repository {
    override fun getMatches(): Flow<List<Match>> {
        return dao.getMatches(authUseCases.getUserId())
    }

    override fun getMatchByKey(key: String): Flow<Match?> {
        return dao.getMatchByKey(key)
    }

    override suspend fun insertMatch(match: Match) {
        return dao.insertMatch(match)
    }

    override suspend fun insertMatches(matchList: List<Match>) {
        return dao.insertMatches(matchList)
    }

    override suspend fun deleteMatch(match: Match) {
        return dao.deleteMatch(match)
    }

    override suspend fun deleteMatchByKey(key: String) {
        return dao.deleteMatchByKey(key)
    }

    override suspend fun deleteMatchesByKeyList(keyList: List<String>) {
        return dao.deleteMatchListByKeys(keyList)
    }

    override suspend fun getMatchesByKeyList(keyList: List<String>): List<Match> {
        return dao.getMatchesByKeyList(keyList)
    }
}