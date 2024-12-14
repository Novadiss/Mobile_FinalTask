package ru.iteco.fmhandroid.ui.tests;


import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.LoginPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.PagesHelper;

@RunWith(AllureAndroidJUnit4.class)
public class AuthTest {

    private final PagesHelper pagesHelper = new PagesHelper();
    private final LoginPage loginPage = new LoginPage();
    private final MainPage mainPage = new MainPage();
    private View decorView;

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void checkIsLogined() {
        mActivityScenarioRule.getScenario().onActivity(new ActivityScenario.ActivityAction<AppActivity>() {
            @Override
            public void perform(AppActivity activity) {
                decorView = activity.getWindow().getDecorView();
            }
        });

        if (!pagesHelper.checkPage(loginPage.getLoginId())) {
            pagesHelper.logoutButtonClick();
        }
    }

    @Test
    @DisplayName("Проверка авторизации с правильными учетными данными")
    public void testAuthWithValidCredentials() {
        loginPage.validAuthentication();
        mainPage.mainScreenPageIsDisplayed();
    }

    @Test
    @DisplayName("Проверка авторизации с неправильным логином")
    public void testAuthWithInvalidLogin() {
        loginPage.setInvalidLogin();
        loginPage.setValidPassword();
        loginPage.enterBtnClick();
        pagesHelper.checkPage(loginPage.getLoginId());
        loginPage.checkPopUpInvalidAuthMessage(decorView);
    }

    //Login and password cannot be empty
    @Test
    @DisplayName("Проверка авторизации с неправильным паролем")
    public void testAuthWithInvalidPassword() {
        loginPage.setValidLogin();
        loginPage.setInvalidPassword();
        loginPage.enterBtnClick();
        pagesHelper.checkPage(loginPage.getLoginId());
        loginPage.checkPopUpInvalidAuthMessage(decorView);
    }

    @Test
    @DisplayName("Проверка авторизации с пустым полем логина")
    public void testAuthWithEmptyLogin() {
        loginPage.setEmptyLogin();
        loginPage.setValidPassword();
        loginPage.enterBtnClick();
        pagesHelper.checkPage(loginPage.getLoginId());
        loginPage.checkPopUpEmptyAuthMessage(decorView);
    }

    @Test
    @DisplayName("Проверка авторизации с пустым полем пароля")
    public void testAuthWithEmptyPassword() {
        loginPage.setValidLogin();
        loginPage.setEmptyPassword();
        loginPage.enterBtnClick();
        pagesHelper.checkPage(loginPage.getLoginId());
        loginPage.checkPopUpEmptyAuthMessage(decorView);
    }
}

