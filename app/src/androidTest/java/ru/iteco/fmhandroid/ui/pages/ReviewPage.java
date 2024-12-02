package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import ru.iteco.fmhandroid.R;

public class ReviewPage {

    private final int reviewPageId = R.id.our_mission_title_text_view;
    private final int reviewImageButton = R.id.our_mission_image_button;
    private final String reviewPageText = "About";

    private final PagesHelper pagesHelper = new PagesHelper();

    public int getReviewPageId() {
        return reviewPageId;
    }


    public void goToReviewPage() {
        pagesHelper.checkOnView(reviewImageButton);
        pagesHelper.buttonClickWithId(reviewImageButton);
    }

    public boolean reviewPageIsDisplayed() {
        pagesHelper.idIsDisplayed(reviewPageId);
        return true;
    }
}
