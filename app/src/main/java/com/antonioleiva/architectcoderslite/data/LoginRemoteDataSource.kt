package com.antonioleiva.architectcoderslite.data

import kotlinx.coroutines.delay

interface LoginRemoteDataSource{
    suspend fun tryLogin(user: String, pass: String): LoginResult
}

class LoginRemoteDataSourceImpl : LoginRemoteDataSource {

    override suspend fun tryLogin(user: String, pass: String): LoginResult {
        delay(2000)
        val userError = !user.contains('@')
        val passError = pass.length < 5

        return LoginResult(userError, passError)
    }
}