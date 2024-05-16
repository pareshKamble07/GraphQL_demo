package com.example.graphqltest.repo

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class UserRepo @Inject constructor(
    private val remoteDataSource: GithubUserSource
) {


    suspend fun getUserData(): Flow<String> {
        return flow { emit(remoteDataSource.getUserData()) }.flowOn(Dispatchers.IO)
    }


}