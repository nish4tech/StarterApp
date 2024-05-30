package com.ip.mobile.feature_home

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.ip.mobile.Target

@Composable
fun HomeNavHost() {
    val homeNavController = rememberNavController()
    NavHost(
        homeNavController,
        Target.ScreenHome
    ) {
        composable<Target.ScreenHome> {
            HomeScreen(
                onNextClick = {
                    homeNavController.navigate(Target.ScreenAccountDetails(10))
                }
            )
        }

        composable<Target.ScreenAccountDetails> {
            val args = it.toRoute<Target.ScreenAccountDetails>()
            AccountDetailsScreen(id = args.accountId)
        }
    }
}