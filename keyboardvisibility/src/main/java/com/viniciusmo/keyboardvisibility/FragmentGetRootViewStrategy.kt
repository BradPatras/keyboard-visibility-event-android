package com.viniciusmo.keyboardvisibility

import android.view.View
import androidx.fragment.app.Fragment

internal class FragmentGetRootViewStrategy(val fragment: Fragment) : GetRootViewStrategy {

    override fun getRootView(): View {
        val rootView = fragment.view
        return rootView!!
    }

}