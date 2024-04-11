package com.adncoding.electrabankapp.presentation.login

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.adncoding.electrabankapp.R
import com.adncoding.electrabankapp.common.NoRippleInteractionSource
import com.adncoding.electrabankapp.presentation.login.components.CreateAccountClickableAnnotatedText
import com.adncoding.electrabankapp.presentation.login.components.ForgetAccountClickableAnnotatedText
import com.adncoding.electrabankapp.presentation.login.components.LabeledCheckbox
import com.adncoding.electrabankapp.ui.theme.blue
import com.adncoding.electrabankapp.ui.theme.gray1
import com.adncoding.electrabankapp.ui.theme.gray2
import com.adncoding.electrabankapp.ui.theme.green

/**
 * Created by AidenChang 2024/04/03
 */
@Composable
fun LoginScreen(
    navController: NavController
) {
    val loginViewModel: LoginViewModelContract =
        if (LocalInspectionMode.current) {
            MockLoginViewModel()
        } else {
            viewModel<LoginViewModel>()
        }
    val state by loginViewModel.state
    val focusManager = LocalFocusManager.current
    val modifierClearFocus = Modifier.clickable { focusManager.clearFocus() }
    val modifierTextFieldPadding = Modifier.padding(horizontal = 30.dp)

    Scaffold { paddingValues ->
        Column(
            modifier = modifierClearFocus
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .clickable(
                    onClick = { focusManager.clearFocus() },
                    indication = null,
                    interactionSource = remember { NoRippleInteractionSource() }
                )
                .padding(paddingValues = paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = modifierTextFieldPadding
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                text = stringResource(id = R.string.app_name),
                textAlign = TextAlign.Center
            )
            OutlinedTextField(
                modifier = modifierTextFieldPadding
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = gray1,
                    focusedBorderColor = green
                ),
                textStyle = TextStyle(color = gray2),
                value = state.nationalIDNo,
                label = { Text(
                    text = "身分證字號",
                    color = gray2
                ) },
                onValueChange = { newText ->
                    loginViewModel.updateNationIdNoText(newText)
                },
                singleLine = true,
                trailingIcon = {
                    val image = if (state.nationalIDNoVisible) {
                        Icons.Filled.Visibility
                    } else {
                        Icons.Filled.VisibilityOff
                    }
                    IconButton(
                        onClick = {
                            loginViewModel.updateNationalIDNoVisible(!state.nationalIDNoVisible)
                        }
                    ) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                }
            )
            LabeledCheckbox(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .align(Alignment.Start),
                text = "記住我",
                checked = state.nationalIDNoCheckBox,
                onCheckedChange = { newChecked ->
                    loginViewModel.updateNationalIDNoCheckBox(newChecked)
                }
            )
            OutlinedTextField(
                modifier = modifierTextFieldPadding
                    .fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = gray1,
                    focusedBorderColor = green
                ),
                textStyle = TextStyle(color = gray2),
                value = state.userAccount,
                label = { Text(
                    text = "用戶代號",
                    color = gray2
                ) },
                onValueChange = { newText ->
                    loginViewModel.updateUserAccountText(newText)
                },
                singleLine = true,
                trailingIcon = {
                    val image = if (state.userAccountVisible) {
                        Icons.Filled.Visibility
                    } else {
                        Icons.Filled.VisibilityOff
                    }
                    IconButton(
                        onClick = { loginViewModel.updateUserAccountVisible(!state.userAccountVisible) }
                    ) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                }
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                modifier = modifierTextFieldPadding
                    .align(Alignment.Start),
                text = "6 ~ 12 位英數字",
                color = gray2
            )
            Spacer(modifier = Modifier.height(14.dp))
            Row(
                modifier = modifierTextFieldPadding
            ) {
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = gray1,
                        focusedBorderColor = green
                    ),
                    textStyle = TextStyle(color = gray2),
                    value = state.userPassword,
                    label = { Text(
                        text = "網銀密碼",
                        color = gray2
                    ) },
                    onValueChange = { newText ->
                        loginViewModel.updateUserPasswordText(newText)
                    },
                    singleLine = true,
                    trailingIcon = {
                        val image = if (state.userPasswordVisible) {
                            Icons.Filled.Visibility
                        } else {
                            Icons.Filled.VisibilityOff
                        }
                        IconButton(
                            onClick = {
                                loginViewModel.updateUserPasswordVisible(!state.userPasswordVisible)
                            }
                        ) {
                            Icon(imageVector = image, contentDescription = null)
                        }
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(60.dp),
                    onClick = { Log.v("testButton", "NoRippleInteractionSource") },
                    colors = ButtonDefaults.buttonColors(containerColor = blue),
                    shape = MaterialTheme.shapes.small,
                    interactionSource = remember { NoRippleInteractionSource() }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        tint = Color.White,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                    )
                }
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                modifier = modifierTextFieldPadding.align(Alignment.Start),
                text = "6 ~ 12 位英數字",
                color = gray2
            )
            Spacer(modifier = Modifier.height(30.dp))
            ForgetAccountClickableAnnotatedText(
                modifier = modifierTextFieldPadding.align(Alignment.Start),
                navController = navController
            )
            Spacer(modifier = Modifier.height(12.dp))
            CreateAccountClickableAnnotatedText(
                modifier = modifierTextFieldPadding.align(Alignment.Start),
                navController = navController
            )
            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {
                    Log.v("testQRCode", "Already click QRCode")
                }
            ) {
                Text(text = "QR Code")
            }
            Spacer(modifier = Modifier.weight(1f, fill = true))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, top = 12.dp, bottom = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "建議您安裝安全防護軟體",
                    fontSize = 13.sp,
                    color = gray2
                )
                Text(
                    text = "1.0.0001",
                    fontSize = 13.sp,
                    color = gray2
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        navController = rememberNavController()
    )
}