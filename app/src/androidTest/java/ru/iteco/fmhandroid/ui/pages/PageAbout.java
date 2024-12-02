package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import ru.iteco.fmhandroid.R;

public class PageAbout {

    private final int pageAboutId = R.id.container_custom_app_bar_include_on_fragment_about;
    private final String toPageAboutText = "About";

    private final PagesHelper pagesHelper = new PagesHelper();

    public int getAboutPageId() {
        return pageAboutId;
    }

    public void goToAboutPage() {
        pagesHelper.checkOnView(pagesHelper.getMainMenuImageButton());
        pagesHelper.buttonClickWithId(pagesHelper.getMainMenuImageButton());
        onView(withText(toPageAboutText)).check(matches(isDisplayed())).perform(click());
    }

    public void pageAboutIsDisplayed() {
        pagesHelper.checkOnView(pageAboutId);
    }
}

