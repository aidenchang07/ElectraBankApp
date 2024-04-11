package com.adncoding.electrabankapp.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

/**
 * Created by AidenChang 2024/04/03
 */
class LoginViewModel : ViewModel(), LoginViewModelContract {
    private val _state = mutableStateOf(LoginState())
    override val state: State<LoginState> = _state

    override fun updateNationIdNoText(text: String) {
        _state.value = _state.value.copy(
            nationalIDNo = text
        )
    }

    override fun updateNationalIDNoVisible(visible: Boolean) {
        _state.value = _state.value.copy(
            nationalIDNoVisible = visible
        )
    }

    override fun updateUserAccountText(text: String) {
        _state.value = _state.value.copy(
            userAccount = text
        )
    }

    override fun updateUserAccountVisible(visible: Boolean) {
        _state.value = _state.value.copy(
            userAccountVisible = visible
        )
    }

    override fun updateUserPasswordText(text: String) {
        _state.value = _state.value.copy(
            userPassword = text
        )
    }

    override fun updateUserPasswordVisible(visible: Boolean) {
        _state.value = _state.value.copy(
            userPasswordVisible = visible
        )
    }

    override fun updateNationalIDNoCheckBox(checked: Boolean) {
        _state.value = _state.value.copy(
            nationalIDNoCheckBox = checked
        )
    }
}