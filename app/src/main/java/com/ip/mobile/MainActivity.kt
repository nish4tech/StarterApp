package com.ip.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ip.mobile.feature_onboarding.LoginScreen
import com.ip.mobile.ui.theme.IpMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IpMobileTheme {
                if(false) {//todo it will come from db
                    LoginScreen()
                } else {
                    LaunchScreen()
                }
            }
        }
    }
}