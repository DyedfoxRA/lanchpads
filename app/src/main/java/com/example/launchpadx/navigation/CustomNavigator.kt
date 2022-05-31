package com.example.launchpadx.navigation

import android.app.Activity
import android.app.Application
import com.example.launchpadx.utils.registerActivityLifecycleCallbacks
import java.lang.ref.WeakReference

class CustomNavigator(app: Application) : Navigator {

    private var currentActivity = WeakReference<Activity>(null)

    init {
        app.registerActivityLifecycleCallbacks(
            onActivityCreated = { activity ->
                currentActivity = WeakReference(activity)
            },
            onActivityResumed = { activity ->
                currentActivity = WeakReference(activity)
            },
            onActivityDestroyed = { activity ->
                currentActivity.let { weakReferenceActivity ->
                    if (weakReferenceActivity.get() == activity) {
                        weakReferenceActivity.clear()
                    }
                }
            }
        )
    }

    override fun execute(action: NavigationAction) {
        currentActivity.get()?.let { activity ->
            action.execute(activity)
        }
    }
}
