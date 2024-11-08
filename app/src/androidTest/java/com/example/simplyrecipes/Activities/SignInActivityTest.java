package com.example.simplyrecipes.Activities;


import android.content.Intent;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import com.example.simplyrecipes.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4ClassRunner.class)
public class SignInActivityTest {
    @Rule
    public IntentsTestRule<SignInActivity> mActivity =
            new IntentsTestRule<SignInActivity>(SignInActivity.class) {};

    @Test
    public void ensureTextChangesWork() {
        // Type text and then press the button.
        onView(withId(R.id.editTextTextEmailAddress)).perform(typeText("ishungry@gmail.com"),
                closeSoftKeyboard());
        onView(withId(R.id.editTextTextEmailAddress))
                .check(matches(withText("ishungry@gmail.com")));

        onView(withId(R.id.editTextTextPassword)).perform(typeText("ishungry"),
                closeSoftKeyboard());
        onView(withId(R.id.editTextTextPassword))
                .check(matches(withText("ishungry")));

        onView(withId(R.id.sign_in_button)).perform(click());
    }

    @Test
    public void changeText_newActivity() {
        onView(withId(R.id.sign_up_button)).perform(click());
        intended(hasComponent(SignUpActivity.class.getName()));
    }

}