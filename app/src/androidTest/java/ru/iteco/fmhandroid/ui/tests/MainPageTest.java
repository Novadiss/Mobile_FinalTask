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
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.PagesHelper;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainPageTest {


    private final PagesHelper pagesHelper = new PagesHelper();
    private final MainPage mainPage = new MainPage();
    private final LoginPage loginPage = new LoginPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void checkMainPageIsDisplayed() {
        if (!pagesHelper.checkPage(mainPage.getMainPageNewsId())) {
            if (pagesHelper.checkPage(loginPage.getLoginId())) {
                loginPage.validAuthentication();
            } else {
                mainPage.goToMainPage();
            }
        }
    }

    @Test
    public void mainPageView() {
        mainPage.mainScreenPageIsDisplayed();
    }

    @Test
    public void newsIsDisplayed(){

    }
}