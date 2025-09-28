package com.albin.instadev.ui.view.auth.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.albin.instadev.R
import com.albin.instadev.ui.view.core.components.InstaButton
import com.albin.instadev.ui.view.core.components.InstaButtonSecondary
import com.albin.instadev.ui.view.core.components.InstaText
import com.albin.instadev.ui.view.core.components.InstaTextField


@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    navigateRegister: () -> Unit) {

    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { padding ->
        Column(
            Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(horizontal = 24.dp)
                .fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            InstaText(
                text = stringResource(R.string.login_screen_header_text_spain),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(top = 12.dp),
                // style = MaterialTheme.typography.bodyLarge
            )
            Spacer(Modifier.weight(1f))
            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(R.drawable.instadev_logo),
                contentDescription = "InstaDev logo header"
            )
            Spacer(Modifier.weight(1f))
            InstaTextField(
                modifier = Modifier.fillMaxWidth(),

                value = uiState.email,
                label = stringResource(R.string.login_screen_textfield_email),
                onValueChange = { loginViewModel.onEmailChanged(it) })
            Spacer(Modifier.height(12.dp))
            InstaTextField(
                modifier = Modifier.fillMaxWidth(),

                value = uiState.password,
                label = stringResource(R.string.login_screen_textfield_password),
                onValueChange = { loginViewModel.onPasswordChanged(it) })
            Spacer(Modifier.height(10.dp))
            InstaButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.login_screen_button_login),
                onClick = { loginViewModel.onClickSelected() },
                enabled = uiState.isLoginEnabled,
                shape = MaterialTheme.shapes.extraLarge

            )
            TextButton(onClick = {}) {
                InstaText(
                    text = stringResource(R.string.login_screen_text_forgot_password),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    // style = MaterialTheme.typography.displayLarge
                )
            }
            Spacer(Modifier.weight(1.3f))
            InstaButtonSecondary(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navigateRegister() },
                title = stringResource(R.string.login_screen_button_register),
            )
            Icon(
                modifier = Modifier
                    .width(60.dp)
                    .padding(vertical = 22.dp),
                painter = painterResource(R.drawable.ic_meta),
                contentDescription = "meta logo",
                tint = MaterialTheme.colorScheme.onBackground
            )

        }

    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen {}
}