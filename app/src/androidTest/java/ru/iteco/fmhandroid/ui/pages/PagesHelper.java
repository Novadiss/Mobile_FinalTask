package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.ViewActions.waitView;

import android.view.View;

import androidx.test.espresso.ViewAssertion;

import java.util.regex.Matcher;

import ru.iteco.fmhandroid.R;

public class PagesHelper {
    private final int logoutBtnId = R.id.authorization_image_button;
    private final int allTitleId = android.R.id.title;
    private final String logoutText = "Log out";
    private final int mainMenuImageButton = R.id.main_menu_image_button;

    public int getMainMenuImageButton() {
        return mainMenuImageButton;
    }

    public void textIsDisplayed(String text) {
        onView(withText(text)).check(matches(isDisplayed()));
    }

    public void idIsDisplayed(int id) {
        onView(withText(id)).check(matches(isDisplayed()));
    }

    public void buttonClickWithText(String button) {
        onView(withText(button)).check(matches(isDisplayed())).perform(click());
    }

    public void buttonClickWithId(int button) {
        onView(withId(button)).check(matches(isDisplayed())).perform(click());
    }

    public void logoutButtonClick() {
        onView(isRoot()).perform(waitView(logoutBtnId, 3000));
        buttonClickWithId(logoutBtnId);
        textIsDisplayed(logoutText);
        buttonClickWithId(allTitleId);
    }

    public Boolean pageIsDisplayed(int pageId) {
        try {
            onView(isRoot()).perform(waitView(pageId, 5000));
            onView(withId(pageId)).check(matches(isDisplayed()));
            return true;
        } catch (Exception e) {
            return false; //(NoMatchingViewException)
        }
    }

    public boolean checkPage(int pageId) {
        return pageIsDisplayed(pageId);
    }


    public void checkOnView(int value) {
        onView(isRoot()).perform(waitView(value, 5000));
        onView(withId(value)).check(matches(isDisplayed()));
    }
}