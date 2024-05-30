package com.ip.mobile

import kotlinx.serialization.Serializable

sealed class Target {
    @Serializable
    data object NavHostHome : Target() {
        override fun toString(): String {
            return "com.ip.mobile.Target.NavHostHome"
        }
    }

    @Serializable
    data object ScreenHome : Target()

    @Serializable
    data class ScreenAccountDetails(val accountId: Int) : Target()

    @Serializable
    data object NavHostSettings : Target() {
        override fun toString(): String {
            return "com.ip.mobile.Target.NavHostSettings"
        }
    }

    @Serializable
    data object ScreenSettings : Target()

    @Serializable
    data object ScreenSettingDetails : Target()

    @Serializable
    data object NavHostManageFunds : Target() {
        override fun toString(): String {
            return "com.ip.mobile.Target.NavHostManageFunds"
        }
    }

    @Serializable
    data object ScreenManageFunds : Target()

    @Serializable
    data object ScreenManageFundDetails : Target()
}