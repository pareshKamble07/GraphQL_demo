package com.example.graphqltest.repo

import com.apollographql.apollo3.ApolloClient
import com.example.graphqltest.CommReqListQuery
import javax.inject.Inject

class GraphQLApi @Inject constructor(
    private val apolloClient: ApolloClient
) {
    suspend fun getUsers() : String {
        val query = CommReqListQuery("736bcd55-6460-4594-81a9-51541f44f773",
            "https://fluentinhealth.com/FHIR/StructureDefinition/CommunicationRequestReminder")
        val response = apolloClient.query(query).execute().data.toString()
        return response
    }
}