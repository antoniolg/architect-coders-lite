package com.antonioleiva.architectcoderslite.domain

import com.antonioleiva.architectcoderslite.data.LoginRepository
import com.antonioleiva.architectcoderslite.data.LoginResult

class TryLoginUseCase(
    private val loginRepository: LoginRepository = LoginRepository()
) {

    suspend operator fun invoke(user: String, pass: String): LoginResult =
        loginRepository.tryLogin(user, pass)
}