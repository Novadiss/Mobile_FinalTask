package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;

import androidx.test.espresso.ViewAssertion;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class MainPage {

    private final int mainScreenPageId = R.id.container_custom_app_bar_include_on_fragment_main;
    private final int mainPageNewsId = R.id.container_list_news_include_on_fragment_main;
    private final String toMainMenu = "Main";

    private final PagesHelper pagesHelper = new PagesHelper();

    public int getMainPageNewsId() {
        return mainPageNewsId;
    }

    public void goToMainPage() {
        Allure.step("Переход на главную страницу");
        pagesHelper.checkOnView(pagesHelper.getMainMenuImageButton());
        pagesHelper.buttonClickWithId(pagesHelper.getMainMenuImageButton());
        onView(withHint(toMainMenu)).check((ViewAssertion) isDisplayed()).perform(click());
    }

    public void mainScreenPageIsDisplayed() {
        Allure.step("Проверка отображения главной страницы");
        pagesHelper.checkOnView(mainScreenPageId);
        pagesHelper.checkOnView(mainPageNewsId);
    }
}
