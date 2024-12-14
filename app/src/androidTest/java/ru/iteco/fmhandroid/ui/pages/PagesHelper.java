package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.ViewActions.waitView;

import android.view.View;

import androidx.test.espresso.ViewAssertion;

import org.hamcrest.Matchers;

import java.util.regex.Matcher;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.data.ViewActions;

public class PagesHelper {
    private final int logoutBtnId = R.id.authorization_image_button;
    private final int allTitleId = android.R.id.title;
    private final String logoutText = "Log out";
    private final int mainMenuImageButton = R.id.main_menu_image_button;

    public int getMainMenuImageButton() {
        return mainMenuImageButton;
    }

    public void textIsDisplayed(String text) {
        Allure.step("Текст " + text + " отображается");
        onView(withText(text)).check(matches(isDisplayed()));
    }

    public void idIsDisplayed(int id) {
        Allure.step("Id " + id + " отображается");
        onView(withId(id)).check(matches(isDisplayed()));
    }

    public void buttonClickWithId(int button) {
        Allure.step("Клик на кнопку с Id" + button);
        onView(withId(button)).check(matches(isDisplayed())).perform(click());
    }

    public void logoutButtonClick() {
        Allure.step("Клик на кнопку с логаута");
        onView(isRoot()).perform(waitView(logoutBtnId, 3000));
        buttonClickWithId(logoutBtnId);
        textIsDisplayed(logoutText);
        buttonClickWithId(allTitleId);
    }

    public Boolean pageIsDisplayed(int pageId) {
        Allure.step("Страница с id " + pageId + " отображается");
        try {
            onView(isRoot()).perform(waitView(pageId, 5000));
            onView(withId(pageId)).check(matches(isDisplayed()));
            return true;
        } catch (Exception e) {
            return false; //(NoMatchingViewException)
        }
    }

    public boolean checkPage(int pageId) {
        Allure.step("Проверка отображения страницы с id " + pageId);
        return pageIsDisplayed(pageId);
    }


    public void checkOnView(int value) {
        Allure.step("Проверка что элемент с id " + value + " отображается");
        onView(isRoot()).perform(waitView(value, 5000));
        onView(withId(value)).check(matches(isDisplayed()));
    }

    public void insertNewsData(int value, String text){
        Allure.step("Ввод текста " + text + " в поле с id " + value);
        pageIsDisplayed(value);
        buttonClickWithId(value);
        onView(withId(value)).perform(replaceText(text), closeSoftKeyboard());
    }
}