package com.ip.mobile

import kotlinx.serialization.Serializable

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