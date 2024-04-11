package com.adncoding.electrabankapp.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adncoding.electrabankapp.common.ScreenRoute
import com.adncoding.electrabankapp.presentation.create_account.CreateScreen
import com.adncoding.electrabankapp.presentation.forget.ForgetScreen
import com.adncoding.electrabankapp.presentation.login.LoginScreen
import com.adncoding.electrabankapp.ui.theme.ElectraBankAppTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.state.value.isLoading
            }
        }
        setContent {
            val navController = rememberNavController()
            ElectraBankAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = ScreenRoute.LoginScreen.route
                    ) {
                        composable(
                            route = ScreenRoute.LoginScreen.route,
                            enterTransition = {
                                EnterTransition.None
                            },
                            exitTransition = {
                                ExitTransition.None
                            }
                        ) {
                            LoginScreen(navController = navController)
                        }
                        composable(
                            route = ScreenRoute.ForgetScreen.route,
                            enterTransition = {
                                slideIntoContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                    animationSpec = tween(300)
                                )
                            },
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                                    animationSpec = tween(300)
                                )
                                ExitTransition.None
                            }
                        ) {
                            ForgetScreen()
                        }
                        composable(
                            route = ScreenRoute.CreateAccount.route,
                            enterTransition = {
                                slideIntoContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                    animationSpec = tween(300)
                                )
                            },
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                                    animationSpec = tween(300)
                                )
                                ExitTransition.None
                            }
                        ) {
                            CreateScreen()
                        }
                    }
                }
            }
        }
    }
}