package com.example.launchpadx.utils

import android.app.Activity
import android.app.Application
import android.os.Bundle

fun Application.registerActivityLifecycleCallbacks(
    onActivityCreated: (Activity) -> Unit = {},
    onActivityDestroyed: (Activity) -> Unit = {},
    onActivitySaveInstanceState: (Activity) -> Unit = {},
    onActivityStarted: (Activity) -> Unit = {},
    onActivityStopped: (Activity) -> Unit = {},
    onActivityPaused: (Activity) -> Unit = {},
    onActivityResumed: (Activity) -> Unit = {}
) {

    registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
        override fun onActivityCreated(a: Activity, p1: Bundle?) = onActivityCreated(a)
        override fun onActivityDestroyed(a: Activity) = onActivityDestroyed(a)
        override fun onActivitySaveInstanceState(a: Activity, p1: Bundle) = onActivitySaveInstanceState(a)
        override fun onActivityStarted(a: Activity) = onActivityStarted(a)
        override fun onActivityStopped(a: Activity) = onActivityStopped(a)
        override fun onActivityPaused(a: Activity) = onActivityPaused(a)
        override fun onActivityResumed(a: Activity) = onActivityResumed(a)
    })
}
