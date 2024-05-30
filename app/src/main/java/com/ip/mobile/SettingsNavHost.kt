package com.ip.mobile

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SettingsNavHost() {
    val settingsNavController = rememberNavController()
    NavHost(
        settingsNavController,
        Target.ScreenSettings
    ) {
        composable<Target.ScreenSettings> {
            SettingsScreen(
                onNextClick = {
                    settingsNavController.navigate(Target.ScreenSettingDetails)
                }
            )
        }
        composable<Target.ScreenSettingDetails> {
            SettingsDetailsScreen()
        }
    }
}