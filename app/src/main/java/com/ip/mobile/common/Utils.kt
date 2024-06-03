package com.ip.mobile.common

import androidx.navigation.NavHostController
import com.ip.mobile.NavTarget

fun NavHostController.navigateWithPopUp(
    toRoute: NavTarget,
    fromRoute: NavTarget
) {
    this.navigate(toRoute) {
        popUpTo(fromRoute) {
            inclusive = true
        }
    }
}