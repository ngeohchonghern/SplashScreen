package com.raymondyang.constraintlayouttesting

import android.content.Context

fun Context.getStatusBarHeight() : Int {
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        return resources.getDimensionPixelSize(resourceId)
    }
    return 0
}

// Convert units (dp, px)

/**
 * Convert dp to px
 */
fun Float.dpToPx(context : Context) = this * context.resources.displayMetrics.density + 0.5f