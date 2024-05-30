package com.ip.mobile.feature_managefunds

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ip.mobile.Target

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