package com.viniciusmo.keyboardvisibility

import android.app.Activity
import androidx.fragment.app.Fragment

@DslMarker
annotation class KeyboardDsl

fun Activity.keyboard(listener: KeyboardVisibilityListenerBuilder.() -> Unit) {
    return KeyBoardVisibility.build(this).setListener(listener)
}

fun Fragment.keyboard(listener: KeyboardVisibilityListenerBuilder.() -> Unit) {
    return KeyBoardVisibility.build(this).setListener(listener)
}