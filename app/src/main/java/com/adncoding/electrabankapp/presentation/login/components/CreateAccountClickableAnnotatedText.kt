package com.adncoding.electrabankapp.presentation.login.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.adncoding.electrabankapp.common.ScreenRoute
import com.adncoding.electrabankapp.ui.theme.green

/**
 * Created by AidenChang 2024/04/06
 */
@Composable
fun CreateAccountClickableAnnotatedText(
    modifier: Modifier,
    navController: NavController
) {
    val tag = "create_account"
    val annotatedString = buildAnnotatedString {
        pushStringAnnotation(
            tag = tag,
            annotation = ScreenRoute.CreateAccount.route
        )

        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Bold
            )
        ) {
            append("還不能登入？可以 ")
        }

        withStyle(
            style = SpanStyle(
                color = green,
                fontWeight = FontWeight.Bold
            )
        ) {
            append("開立帳戶、啟用App")
        }

        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Bold
            )
        ) {
            append(" 或 ")
        }

        withStyle(
            style = SpanStyle(
                color = green,
                fontWeight = FontWeight.Bold
            )
        ) {
            append("開卡")
        }
    }
    ClickableText(
        modifier = modifier,
        text = annotatedString
    ) { offset ->
        annotatedString.getStringAnnotations(tag = tag, start = offset, end = offset)
            .firstOrNull()?.let { annotation ->
                navController.navigate(annotation.item)
            }
    }
}

@Preview(showBackground = true)
@Composable
private fun CreateAccountClickableAnnotatedTextPreview() {
    CreateAccountClickableAnnotatedText(
        modifier = Modifier,
        navController = rememberNavController()
    )
}