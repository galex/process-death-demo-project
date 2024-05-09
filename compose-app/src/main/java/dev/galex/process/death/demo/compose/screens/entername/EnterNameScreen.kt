package dev.galex.process.death.demo.compose.screens.entername

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import dev.galex.process.death.demo.compose.data.DataHolder

@Composable
fun EnterNameScreen(
    modifier: Modifier = Modifier,
    onNextClick: () -> Unit
) {
    ConstraintLayout(
        modifier = modifier.fillMaxSize()
    ) {

        val (textField, button) = createRefs()

        var name by remember { mutableStateOf("") }

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter name") },
            modifier = Modifier
                .constrainAs(textField) {
                    top.linkTo(parent.top)
                    bottom.linkTo(button.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(16.dp)
        )

        Button(
            onClick = {
                DataHolder.name = name
                onNextClick()
            },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(textField.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text("Next")
        }
    }
}