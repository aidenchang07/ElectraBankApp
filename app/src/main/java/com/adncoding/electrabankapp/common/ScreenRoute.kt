package com.adncoding.electrabankapp.common

/**
 * Created by AidenChang 2024/04/06
 */
sealed class ScreenRoute(val route: String) {
    data object LoginScreen: ScreenRoute("login_screen")
    data object ForgetScreen: ScreenRoute("forget_screen")
    data object CreateAccount: ScreenRoute("create_screen")
}