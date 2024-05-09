package dev.galex.process.death.demo.compose.screens.showinfo

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
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import dev.galex.process.death.demo.compose.data.DataHolder

@Composable
fun ShowInfoScreen() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {

        val (text, button) = createRefs()

        Text(
            text = "Name = ${DataHolder.name}",
            modifier = Modifier
                .constrainAs(text) {
                    top.linkTo(parent.top)
                    bottom.linkTo(button.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(16.dp)
        )

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(button) {
                top.linkTo(text.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text("Back")
        }
    }
}