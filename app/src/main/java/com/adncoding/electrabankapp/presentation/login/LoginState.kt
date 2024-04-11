package com.adncoding.electrabankapp.presentation.login

import com.adncoding.electrabankapp.common.Language

/**
 * Created by AidenChang 2024/04/03
 */
data class LoginState(
    val nationalIDNo: String = "",
    var nationalIDNoCheckBox: Boolean = false,
    val nationalIDNoVisible: Boolean = false,
    val userAccount: String = "",
    val userAccountVisible: Boolean = false,
    val userPassword: String = "",
    val userPasswordVisible: Boolean = false,
    val language: String = Language.TW.code
)