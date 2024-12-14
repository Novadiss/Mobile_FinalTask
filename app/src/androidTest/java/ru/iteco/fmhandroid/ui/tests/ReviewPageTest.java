package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.LoginPage;
import ru.iteco.fmhandroid.ui.pages.PagesHelper;
import ru.iteco.fmhandroid.ui.pages.ReviewPage;

@RunWith(AllureAndroidJUnit4.class)
public class ReviewPageTest {

    private final PagesHelper pagesHelper = new PagesHelper();
    private final ReviewPage reviewPage = new ReviewPage();
    private final LoginPage loginPage = new LoginPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void checkReviewPageIsDisplayed() {
        if (!pagesHelper.checkPage(reviewPage.getReviewPageId())) {
            if (pagesHelper.checkPage(loginPage.getLoginId())) {
                loginPage.validAuthentication();
                reviewPage.goToReviewPage();
            } else {
                reviewPage.goToReviewPage();
            }
        }
    }

    @Test
    @DisplayName("Проверка что страница отзывов отображается")
    public void reviewPageView() {
        reviewPage.reviewPageIsDisplayed();
    }
}
