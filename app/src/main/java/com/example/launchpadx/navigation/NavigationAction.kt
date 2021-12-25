package com.example.launchpadx.navigation

import android.app.Activity

interface NavigationAction {
    fun execute(activity: Activity)
}
