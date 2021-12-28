package com.antonioleiva.architectcoderslite.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antonioleiva.architectcoderslite.R
import com.antonioleiva.architectcoderslite.data.success
import com.antonioleiva.architectcoderslite.domain.TryLoginUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val tryLoginUseCase: TryLoginUseCase = TryLoginUseCase()
) : ViewModel() {

    private val _uiState = MutableLiveData(UiState())
    val uiState: LiveData<UiState> get() = _uiState

    fun onTryLogin(user: String, pass: String) {
        viewModelScope.launch {
            _uiState.value = UiState(loggingIn = true)
            val result = tryLoginUseCase(user, pass)
            _uiState.value = UiState(
                loggedIn = result.success,
                userError = if (result.userError) R.string.user_error else null,
                passError = if (result.passError) R.string.pass_error else null
            )
        }
    }

    data class UiState(
        val loggingIn: Boolean = false,
        val loggedIn: Boolean = false,
        val userError: Int? = null,
        val passError: Int? = null
    )
}