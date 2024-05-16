package com.example.graphqltest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.apollographql.apollo3.ApolloClient
import com.example.graphqltest.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var apolloClient : ApolloClient

    private var mainViewModel: UserViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        getUsers()
    }

    fun getUsers() {
        mainViewModel?.fetchDataResponse()

        mainViewModel?.response?.observe(this) { response ->

            Log.e("getUsersssssss", response.filter { it.isDigit() })
        }
}
}