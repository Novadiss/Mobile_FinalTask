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
public class AuthTest {

    private final PagesHelper pagesHelper = new PagesHelper();
    private final LoginPage loginPage = new LoginPage();
    private final MainPage mainPage = new MainPage();


    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void checkIsLogined() {
        if (!pagesHelper.checkPage(loginPage.getLoginId())) {
            pagesHelper.logoutButtonClick();
        }
    }

    @Test
    public void testAuthWithValidCredentials() {
        loginPage.validAuthentication();
        mainPage.mainScreenPageIsDisplayed();
    }

    @Test
    public void testAuthWithInvalidLogin() {
        loginPage.setInvalidLogin();
        loginPage.setValidPassword();
        loginPage.enterBtnClick();
        pagesHelper.checkPage(loginPage.getLoginId());
    }

    @Test
    public void testAuthWithInvalidPassword() {
        loginPage.setValidLogin();
        loginPage.setInvalidPassword();
        loginPage.enterBtnClick();
        pagesHelper.checkPage(loginPage.getLoginId());
    }

    @Test
    public void testAuthWithEmptyLogin() {
        loginPage.setEmptyLogin();
        loginPage.setValidPassword();
        loginPage.enterBtnClick();
        pagesHelper.checkPage(loginPage.getLoginId());
    }

    @Test
    public void testAuthWithEmptyPassword() {
        loginPage.setValidLogin();
        loginPage.setEmptyPassword();
        loginPage.enterBtnClick();
        pagesHelper.checkPage(loginPage.getLoginId());
    }
}

