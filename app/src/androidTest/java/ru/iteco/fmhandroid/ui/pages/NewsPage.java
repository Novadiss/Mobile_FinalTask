package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class NewsPage {

    private final int newsPageId = R.id.container_custom_app_bar_include_on_fragment_news_list;
    private final String toNewsText = "News";

    private final PagesHelper pagesHelper = new PagesHelper();

    public int getNewsPageId() {
        return newsPageId;
    }

    public void goToNewsPage() {
        Allure.step("Переход на страницу новостей");
        pagesHelper.checkOnView(pagesHelper.getMainMenuImageButton());
        pagesHelper.buttonClickWithId(pagesHelper.getMainMenuImageButton());
        onView(withText(toNewsText)).check(matches(isDisplayed())).perform(click());
    }

    public void newsPageIsDisplayed() {
        Allure.step("Проверка отображения страницы новостей");
        pagesHelper.checkOnView(newsPageId);
    }
}
