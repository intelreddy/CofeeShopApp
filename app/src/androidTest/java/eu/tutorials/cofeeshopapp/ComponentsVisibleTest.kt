package eu.tutorials.cofeeshopapp

import androidx.test.espresso.Espresso.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.rule.ActivityTestRule

@RunWith(AndroidJUnit4::class)
class ComponentsVisibleTest {

 @Rule
 @JvmField var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
 @Test
 fun isVisible(){
  onView(withId(R.id.btnPlus)).check(matches(isDisplayed()))
  onView(withId(R.id.qtySelected)).check(matches(isDisplayed()))
  onView(withId(R.id.btnCancel)).check(matches(isDisplayed()))
  onView(withId(R.id.btnOrder)).check(matches(isDisplayed()))
  onView(withId(R.id.btnMinus)).check(matches(isDisplayed()))
  onView(withId(R.id.thriller_checkbox)).check(matches(isDisplayed()))
  onView(withId(R.id.fantasy_checkbox)).check(matches(isDisplayed()))
 }
}

