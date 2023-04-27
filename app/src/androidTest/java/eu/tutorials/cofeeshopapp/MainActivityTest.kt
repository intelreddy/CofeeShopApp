package eu.tutorials.cofeeshopapp

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.`is`
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class MainActivityTest {
    @Rule
    @JvmField
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
    var mainActivityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun displaysTitle() {
        val title = "Books Lending App"
        Espresso.onView(ViewMatchers.withText(title)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun orderFantasyBookTest(){
        Espresso.onView(withId(R.id.editTextName)).perform(ViewActions.typeText("Bhaskara Reddy"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(withId(R.id.fantasy_checkbox)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.btnPlus)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.btnPlus)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.btnOrder)).perform(ViewActions.click())
        Thread.sleep(10000)
        Espresso.onView(withId(R.id.bookPrice))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.bookPrice)).check(matches(withText("$20")))
    }

    @Test
    fun toastMessageTest(){
        Espresso.onView(withId(R.id.btnPlus)).perform(ViewActions.click())
        //Toast message displayed
//        Espresso.onView(ViewMatchers.withText("Please enter your name")).inRoot(
//            RootMatchers.withDecorView(
//                CoreMatchers.not(
//                    `is`(
//                        mainActivityRule.getActivity().getWindow().getDecorView()
//                    )
//                )
//            )
//        ).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
  //      Espresso.onView(withText("Please enter your name")).inRoot(withDecorView(not(activityRule.getActivity().getWindow().getDecorView()))).check(matches(ViewMatchers.isDisplayed()));
    }
}