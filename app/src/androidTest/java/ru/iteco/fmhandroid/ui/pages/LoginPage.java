package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;

public class LoginPage {
    private final int loginId = R.id.login_text_input_layout;
    private final int passwordId = R.id.password_text_input_layout;
    private final int enterBtn = R.id.enter_button;
    private final String loginCell = "Login";
    private final String passwordCell = "Password";

    private final PagesHelper pagesHelper = new PagesHelper();

    public int getLoginId() {
        return loginId;
    }

    public void setValidLogin() {
        pagesHelper.checkOnView(loginId);
        onView(withHint(loginCell)).perform(typeText(DataHelper.getValidCreds().getLogin()), closeSoftKeyboard());
    }

    public void setValidPassword() {
        pagesHelper.checkOnView(passwordId);
        onView(withHint(passwordCell)).perform(typeText(DataHelper.getValidCreds().getPassword()), closeSoftKeyboard());
    }

    public void setEmptyLogin() {
        pagesHelper.checkOnView(loginId);
        onView(withHint(loginCell)).perform(typeText(DataHelper.getEmptyCreds().getLogin()), closeSoftKeyboard());
    }

    public void setEmptyPassword() {
        pagesHelper.checkOnView(passwordId);
        onView(withHint(passwordCell)).perform(typeText(DataHelper.getEmptyCreds().getPassword()), closeSoftKeyboard());
    }

    public void setInvalidLogin() {
        pagesHelper.checkOnView(loginId);
        onView(withHint(loginCell)).perform(typeText(DataHelper.getValidPasswordInvalidLogin().getLogin()), closeSoftKeyboard());
    }

    public void setInvalidPassword() {
        pagesHelper.checkOnView(passwordId);
        onView(withHint(passwordCell)).perform(typeText(DataHelper.getValidLoginInvalidPassword().getPassword()), closeSoftKeyboard());
    }

    public void enterBtnClick() {
        pagesHelper.checkOnView(enterBtn);
        onView(withId(enterBtn)).check(matches(isDisplayed())).perform(click());
    }

    public void validAuthentication() {
        setValidLogin();
        setValidPassword();
        enterBtnClick();
    }
}
