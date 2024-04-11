package com.adncoding.electrabankapp.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

/**
 * Created by AidenChang 2024/04/03
 */
class MockLoginViewModel : LoginViewModelContract {
    override val state: State<LoginState>
        get() = mutableStateOf(
            LoginState()
        )

    override fun updateNationIdNoText(text: String) {}
    override fun updateNationalIDNoVisible(visible: Boolean) {}
    override fun updateUserAccountText(text: String) {}
    override fun updateUserAccountVisible(visible: Boolean) {}
    override fun updateUserPasswordText(text: String) {}
    override fun updateUserPasswordVisible(visible: Boolean) {}
    override fun updateNationalIDNoCheckBox(checked: Boolean) {}
}