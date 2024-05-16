package com.example.graphqltest.repo

import javax.inject.Inject

class GithubUserSource @Inject constructor(private val api: GraphQLApi) {

    suspend fun getUserData() = api.getUsers()
}