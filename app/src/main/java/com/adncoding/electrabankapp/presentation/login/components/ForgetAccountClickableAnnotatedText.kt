package com.adncoding.electrabankapp.presentation.login.components

import android.util.Log
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
fun ForgetAccountClickableAnnotatedText(
    modifier: Modifier,
    navController: NavController
) {
    val tag = "forget_account"
    val annotatedString = buildAnnotatedString {
        pushStringAnnotation(
            tag = tag,
            annotation = ScreenRoute.ForgetScreen.route
        )
        withStyle(
            style = SpanStyle(
                color = green,
                fontWeight = FontWeight.Bold
            )
        ) {
            append("忘記代號、密碼")
        }
    }
    ClickableText(
        modifier = modifier,
        text = annotatedString
    ) { offset ->
        annotatedString.getStringAnnotations(tag = tag, start = offset, end = offset)
            .firstOrNull()?.let { annotation ->
                Log.v("forgetTest", "annotation.item: ${annotation.item}")
                navController.navigate(annotation.item)
            }
    }
}

@Preview(showBackground = true)
@Composable
private fun ForgetAccountClickableAnnotatedTextPreview() {
    ForgetAccountClickableAnnotatedText(
        modifier = Modifier,
        navController = rememberNavController()
    )
}