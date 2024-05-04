package dev.galex.process.death.demo

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Space
import kotlinx.parcelize.Parcelize

class BottomBarView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private var icon1: ImageView
    private var icon2: ImageView
    private var icon3: ImageView
    private var selectedIconId: Int = R.id.home

    init {
        orientation = HORIZONTAL
        icon1 = ImageView(context).apply { id = R.id.home; setImageResource(R.drawable.ic_home) }.also { addView(it) }
        addView(Space(context).apply { weightSum = 1F })
        icon2 = ImageView(context).apply { id = R.id.account; setImageResource(R.drawable.ic_account) }.also { addView(it) }
        addView(Space(context).apply { weightSum = 1F })
        icon3 = ImageView(context).apply { id = R.id.settings; setImageResource(R.drawable.ic_settings) }.also { addView(it) }
    }

    // Other methods to handle user interaction and update the state of the icons...

    override fun onSaveInstanceState(): Parcelable? {
        val superState = super.onSaveInstanceState().apply {  }
        val savedState = superState?.let { SelectedSavedState(it) }
        savedState?.selectedIconId = selectedIconId
        return savedState
    }

    override fun onRestoreInstanceState(state: Parcelable) {
        if (state is SelectedSavedState) {
            super.onRestoreInstanceState(state.superState)
            selectedIconId = state.selectedIconId
            // Update the UI based on the restored state
        } else {
            super.onRestoreInstanceState(state)
        }
    }

    @Parcelize
    data class SelectedSavedState(val state: Parcelable?, var selectedIconId: Int = 0) : BaseSavedState(state)
}