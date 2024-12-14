package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.pages.PageAbout;
import ru.iteco.fmhandroid.ui.pages.LoginPage;
import ru.iteco.fmhandroid.ui.pages.PagesHelper;


@RunWith(AllureAndroidJUnit4.class)
public class PageAboutTest {


    private final PagesHelper pagesHelper = new PagesHelper();
    private final PageAbout pageAbout = new PageAbout();
    private final LoginPage loginPage = new LoginPage();
    private final NewsPage newsPage = new NewsPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void checkAboutPageIsDisplayed() {
        if (!pagesHelper.checkPage((pageAbout.getAboutPageId()))) {
            if (pagesHelper.checkPage(loginPage.getLoginId())) {
                loginPage.validAuthentication();
            }
        }
    }

    @Test
    @DisplayName("Проверка что страница 'О приложении' отображается")
    public void aboutPageView() {
        pageAbout.goToAboutPage();
        pageAbout.pageAboutIsDisplayed();
    }

    @Test
    @DisplayName("Проверка что страница 'О приложении' отображается")
    public void goToPageAboutFromNews() {

        pageAbout.pageAboutIsDisplayed();
    }
}
