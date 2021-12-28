package com.antonioleiva.architectcoderslite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _uiState = MutableLiveData(UiState())
    val uiState: LiveData<UiState> get() = _uiState

    fun onTryLogin(user: String, pass: String) {
        viewModelScope.launch {
            _uiState.value = UiState(loggingIn = true)
            tryLogin(user, pass)
        }
    }

    private suspend fun tryLogin(user: String, pass: String) {
        delay(2000)
        val userError = if (!user.contains('@')) R.string.user_error else null
        val passError = if (pass.length < 5) R.string.pass_error else null

        _uiState.value = UiState(
            loggedIn = userError == null && passError == null,
            userError = userError,
            passError = passError
        )
    }

    data class UiState(
        val loggingIn: Boolean = false,
        val loggedIn: Boolean = false,
        val userError: Int? = null,
        val passError: Int? = null
    )
}