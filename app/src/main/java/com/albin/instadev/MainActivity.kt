package com.albin.instadev
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.albin.instadev.ui.theme.InstaDEvTheme
import com.albin.instadev.ui.view.core.navigation.NavigationWrapper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           InstaDEvTheme {
               NavigationWrapper()
           }
        }
    }
}

