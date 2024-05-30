package com.ip.mobile

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ManageFundsNavHost() {
    val manageFundsNavController = rememberNavController()
    NavHost(
        manageFundsNavController,
        Target.ScreenManageFunds
    ) {
        composable<Target.ScreenManageFunds> {
            ManageFundsScreen(
                onNextClick = {
                    manageFundsNavController.navigate(Target.ScreenManageFundDetails)
                }
            )
        }

        composable<Target.ScreenManageFundDetails> {
            ManageFundsDetailsScreen()
        }
    }
}