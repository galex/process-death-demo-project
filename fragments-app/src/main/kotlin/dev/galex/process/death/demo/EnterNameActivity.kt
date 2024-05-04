package dev.galex.process.death.demo

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class EnterNameActivity : AppCompatActivity() {

    private var name: String? = null
    private lateinit var editTextName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // editText created dynamically
        editTextName = EditText(this).apply {
            hint = "Enter name"
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            // Setting the ID on the created View
            id = R.id.name_edit_text
        }

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addView(editTextName)
        }

        setContentView(layout)

        editTextName.addTextChangedListener { text ->
            name = text.toString()
        }
    }
}