package com.albin.instadev.ui.view.core.components


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import com.albin.instadev.R

@Composable
fun InstaTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    label:String =""

) {
    OutlinedTextField(
        modifier = modifier,
        shape = shape,
        value = value,
        label = {
            InstaText(
                label,

            )
        },
        onValueChange = { onValueChange(it) })
}