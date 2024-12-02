package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.LoginPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.pages.PagesHelper;
import ru.iteco.fmhandroid.ui.pages.ReviewPage;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ReviewPageTest {



    private final PagesHelper pagesHelper = new PagesHelper();
    private final ReviewPage reviewPage = new ReviewPage();
    private final LoginPage loginPage = new LoginPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void checkReviewPageIsDisplayed() {
        if (!reviewPage.reviewPageIsDisplayed()) {
            if (pagesHelper.checkPage(loginPage.getLoginId())) {
                loginPage.validAuthentication();
                reviewPage.goToReviewPage();
            } else {
                reviewPage.goToReviewPage();
            }
        } else {
            return;
        }
    }

    @Test
    public void reviewPageView() {
        pagesHelper.textIsDisplayed(reviewPage.getReviewPageTextIsDisplayed());
    }
}
