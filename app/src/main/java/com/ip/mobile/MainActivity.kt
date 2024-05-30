package com.ip.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.ip.mobile.ui.theme.IpMobileTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IpMobileTheme {
                val rootNavController = rememberNavController()
                val navBackStackEntry by rootNavController.currentBackStackEntryAsState()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background,
                    bottomBar = {
                        NavigationBar {
                            items.forEach { item ->
                                val isSelected = item.title.lowercase() ==
                                        navBackStackEntry?.destination?.route
                                NavigationBarItem(
                                    selected = isSelected,
                                    label = {
                                        Text(text = item.title)
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = if (isSelected) {
                                                item.selectedIcon
                                            } else item.unselectedIcon,
                                            contentDescription = item.title
                                        )
                                    },
                                    onClick = {
                                        rootNavController.navigate(item.target) {
                                            popUpTo(rootNavController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }
                                )


                            }

                        }
                    }
                ) { padding ->
                    NavHost(
                        rootNavController,
                        startDestination = Target.NavHostHome
                    ) {
                        composable<Target.NavHostHome> {
                            HomeNavHost()
                        }
                        composable<Target.NavHostSettings> {
                            SettingsNavHost()
                        }
                        composable<Target.NavHostManageFunds> {
                            ManageFundsNavHost()
                        }
                    }

                }

            }
        }
    }
}

@Composable
fun HomeNavHost() {
    val homeNavController = rememberNavController()
    NavHost(
        homeNavController,
        Target.ScreenHome
    ) {
        composable<Target.ScreenHome> {
            GenericScreen(
                text = "Home Screen",
                onNextClick = {
                    homeNavController.navigate(Target.ScreenAccountDetails(10))
                }
            )
        }
        composable<Target.ScreenAccountDetails> {
            val args = it.toRoute<Target.ScreenAccountDetails>()
            GenericScreen(
                text = "Account Details with id ${args.accountId}",
                onNextClick = {

                }
            )
        }
    }
}

@Composable
fun SettingsNavHost() {
    val settingsNavController = rememberNavController()
    NavHost(
        settingsNavController,
        Target.ScreenSettings
    ) {
        composable<Target.ScreenSettings> {
            GenericScreen(
                text = "Settings Screen",
                onNextClick = {
                    settingsNavController.navigate(Target.ScreenSettingDetails)
                }
            )
        }
        composable<Target.ScreenSettingDetails> {
            GenericScreen(
                text = "Settings Details",
                onNextClick = {

                }
            )
        }
    }
}

@Composable
fun ManageFundsNavHost() {
    val manageFundsNavController = rememberNavController()
    NavHost(
        manageFundsNavController,
        Target.ScreenManageFunds
    ) {
        composable<Target.ScreenManageFunds> {
            GenericScreen(
                text = "Manage Funds Screen",
                onNextClick = {
                    manageFundsNavController.navigate(Target.ScreenManageFundDetails)
                }
            )
        }
        composable<Target.ScreenManageFundDetails> {
            GenericScreen(
                text = "Manage Funds Details",
                onNextClick = {

                }
            )
        }
    }
}

sealed class Target {
    @Serializable
    data object NavHostHome : Target()

    @Serializable
    data object ScreenHome : Target()

    @Serializable
    data class ScreenAccountDetails(val accountId: Int) : Target()

    @Serializable
    data object NavHostSettings : Target()

    @Serializable
    data object ScreenSettings : Target()

    @Serializable
    data object ScreenSettingDetails : Target()

    @Serializable
    data object NavHostManageFunds : Target()

    @Serializable
    data object ScreenManageFunds : Target()

    @Serializable
    data object ScreenManageFundDetails : Target()
}

@Composable
fun GenericScreen(
    text: String,
    onNextClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = text)
        Spacer(Modifier.height(16.dp))
        Button(onClick = onNextClick) {
            Text("Next")
        }
    }
}

val items = listOf(
    BottomNavigationItem(
        title = "Home",
        target = Target.NavHostHome,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    ),
    BottomNavigationItem(
        title = "Settings",
        target = Target.NavHostSettings,
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings
    ),
    BottomNavigationItem(
        title = "Manage Funds",
        target = Target.NavHostManageFunds,
        selectedIcon = Icons.Filled.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart
    )
)

data class BottomNavigationItem(
    val title: String,
    val target: Target,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)