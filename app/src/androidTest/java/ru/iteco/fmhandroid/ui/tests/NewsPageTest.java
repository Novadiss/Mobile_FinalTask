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
import ru.iteco.fmhandroid.ui.pages.PageAbout;
import ru.iteco.fmhandroid.ui.pages.PagesHelper;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NewsPageTest {


    private final PagesHelper pagesHelper = new PagesHelper();
    private final NewsPage newsPage = new NewsPage();
    private final LoginPage loginPage = new LoginPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void checkNewsPageIsDisplayed() {
        if (!pagesHelper.checkPage((newsPage.getNewsPageId()))) {
            if (pagesHelper.checkPage(loginPage.getLoginId())) {
                loginPage.validAuthentication();
                newsPage.goToNewsPage();
            } else {
                newsPage.goToNewsPage();
            }
        }
    }

    @Test
    public void aboutPageView() {
        newsPage.newsPageIsDisplayed();
    }
}
