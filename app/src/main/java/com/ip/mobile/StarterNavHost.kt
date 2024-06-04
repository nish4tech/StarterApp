package com.ip.mobile

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ip.mobile.common.navigateWithPopUp
import com.ip.mobile.onboarding.LoginScreen

@Composable
fun StarterNavHost() {

    val starterNavController = rememberNavController()
    NavHost(
        starterNavController,
        NavTarget.ScreenLogin
    ) {
        composable<NavTarget.ScreenLogin> {
            LoginScreen(
                onNextClick = {
                    starterNavController.navigateWithPopUp(
                        NavTarget.NavHostLauncher,
                        NavTarget.ScreenLogin
                    )
                }
            )
        }

        composable<NavTarget.NavHostLauncher> {
            LaunchNavHost()
        }
    }
}



