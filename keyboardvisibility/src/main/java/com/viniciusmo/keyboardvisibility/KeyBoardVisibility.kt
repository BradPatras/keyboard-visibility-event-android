package com.viniciusmo.keyboardvisibility

import android.app.Activity
import android.graphics.Rect
import android.os.Build
import android.view.View
import android.view.ViewTreeObserver
import androidx.fragment.app.Fragment

class KeyBoardVisibility private constructor(getRootViewStrategy: GetRootViewStrategy,
                                             private var screenDensity: Float) {

    companion object {

        private const val MAGIC_NUMBER = 50.0f

        private fun getDensityScreen(from: Activity): Float {
            return from.resources.displayMetrics.density
        }

        fun build(activity: Activity): KeyBoardVisibility {
            val keyBoardVisibility = KeyBoardVisibility(ActivityGetRootViewStrategy(activity), getDensityScreen(activity))
            return registerAutoDispose(activity, keyBoardVisibility)
        }

        fun build(fragment: Fragment): KeyBoardVisibility {
            val activity = fragment.activity!!
            val keyBoardVisibility = KeyBoardVisibility(FragmentGetRootViewStrategy(fragment), getDensityScreen(activity))
            return registerAutoDispose(activity, keyBoardVisibility)
        }

        private fun registerAutoDispose(activity: Activity, keyBoardVisibility: KeyBoardVisibility): KeyBoardVisibility {
            activity.application.registerActivityLifecycleCallbacks(object : WrapperActivityLifecycleCallback(activity) {
                override fun onTargetActivityDestroyed() {
                    keyBoardVisibility.dispose()
                }
            })
            return keyBoardVisibility
        }

    }

    private var previousState: Boolean = false
    private var visibilityListener: KeyboardVisibilityListener? = null
    private var rootView: View = getRootViewStrategy.getRootView()
    private var onGlobalLayoutListener: ViewTreeObserver.OnGlobalLayoutListener? = null

    init {
        onGlobalLayoutListener = ViewTreeObserver.OnGlobalLayoutListener {
            val rootViewArea = Rect()
            rootView.getWindowVisibleDisplayFrame(rootViewArea)
            val heightDiff = rootView.rootView.height - (rootViewArea.bottom - rootViewArea.top)
            val dp = heightDiff / screenDensity
            val isVisible = dp > MAGIC_NUMBER
            if (previousState != isVisible) {
                previousState = isVisible
                if (isVisible) {
                    this.visibilityListener?.onKeyboardOpened?.invoke()
                } else {
                    this.visibilityListener?.onKeyboardClose?.invoke()
                }
            }
        }
        rootView.viewTreeObserver?.addOnGlobalLayoutListener(onGlobalLayoutListener)
    }

    @Suppress("DEPRECATION")
    private fun dispose() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            rootView.viewTreeObserver?.removeOnGlobalLayoutListener { onGlobalLayoutListener }
        } else {
            rootView.viewTreeObserver?.removeGlobalOnLayoutListener { onGlobalLayoutListener }
        }
    }

    fun setListener(initBlock: KeyboardVisibilityListenerBuilder.() -> Unit) {
        this.visibilityListener = KeyboardVisibilityListenerBuilder().apply(initBlock).build()
    }
}