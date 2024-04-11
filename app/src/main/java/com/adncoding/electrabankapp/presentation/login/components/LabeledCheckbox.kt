package com.adncoding.electrabankapp.presentation.login.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adncoding.electrabankapp.ui.theme.gray3
import com.adncoding.electrabankapp.ui.theme.green

/**
 * Created by AidenChang 2024/04/04
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabeledCheckbox(
    modifier: Modifier = Modifier,
    text: String = "",
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            modifier = modifier.offset(x = (-14).dp),
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(checkedColor = green)
        )
        Text(
            modifier = Modifier.offset(x = (-14).dp),
            text = text,
            color = gray3
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LabeledCheckboxPreview() {
    LabeledCheckbox(
        text = "記住我",
        onCheckedChange = {}
    )
}