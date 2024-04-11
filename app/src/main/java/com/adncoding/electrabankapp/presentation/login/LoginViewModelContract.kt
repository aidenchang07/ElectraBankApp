package com.adncoding.electrabankapp.presentation.login

import androidx.compose.runtime.State

interface LoginViewModelContract {
    val state: State<LoginState>
    fun updateNationIdNoText(text: String)
    fun updateNationalIDNoVisible(visible: Boolean)
    fun updateUserAccountText(text: String)
    fun updateUserAccountVisible(visible: Boolean)
    fun updateUserPasswordText(text: String)
    fun updateUserPasswordVisible(visible: Boolean)
    fun updateNationalIDNoCheckBox(checked: Boolean)
}
