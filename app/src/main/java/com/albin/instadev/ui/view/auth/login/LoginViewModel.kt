package com.albin.instadev.ui.view.auth.login


import android.util.Log
import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albin.instadev.domain.usecase.Login
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor (val login: Login) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEmailChanged(email: String) {
        _uiState.update { state ->
            state.copy(email = email)

        }
        verifyLogin()
    }

    fun onPasswordChanged(password: String) {
        _uiState.update {
            it.copy(password = password)
        }
        verifyLogin()
    }

    fun onClickSelected() {
      //  loadingState(true)
        viewModelScope.launch(Dispatchers.IO) {
            val response = login(_uiState.value.email, _uiState.value.password)

            withContext(Dispatchers.Main) {
                if (response != null) {
             //       _uiState.update { it.copy(isUserLogged = true) }
                }else{
                    Log.i("LOGIN", "ERROR")
                }
              //  loadingState(false)
            }
        }
    }

    private fun verifyLogin() {
        val enableLogin: Boolean =
            isEmail(_uiState.value.email) && isPasswordValid(_uiState.value.password)
        _uiState.update {
            it.copy(isLoginEnabled = enableLogin)
        }
    }

    private fun isEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    private fun isPasswordValid(password: String): Boolean = password.length >= 6



}

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isLoginEnabled: Boolean = false
)