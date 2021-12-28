package com.antonioleiva.architectcoderslite.data

import kotlinx.coroutines.delay

class LoginRepository {

    suspend fun tryLogin(user: String, pass: String): LoginResult {
        delay(2000)
        val userError = !user.contains('@')
        val passError = pass.length < 5

        return LoginResult(userError, passError)
    }
}

data class LoginResult(val userError: Boolean, val passError: Boolean)

val LoginResult.success get() = !userError && !passError