package com.example.robot.launchpad_item

import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.ViewInteraction
import com.example.launchpadx.R
import com.example.launchpadx.ui.launchpad_item.LaunchpadItemFragment
import com.example.robot.BaseRobot

fun launchpadItemFragment(func: LaunchpadItemRobot.() -> Unit) = LaunchpadItemRobot()
    .apply { func() }

class LaunchpadItemRobot : BaseRobot() {

    fun hasProperLayout(): ViewInteraction = isDisplayed(R.id.launchpadFragmentRoot)

    fun Fragment.setDefaultBackground() {}

    fun startWithDefaultBackground(): FragmentScenario<LaunchpadItemFragment> =
        launchFragmentInContainer<LaunchpadItemFragment>()
            .onFragment { fragment: Fragment ->
                fragment.setDefaultBackground()
            }
}
