package ru.iteco.fmhandroid.ui.tests;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pages.EditingNewsPage;
import ru.iteco.fmhandroid.ui.pages.LoginPage;
import ru.iteco.fmhandroid.ui.pages.PagesHelper;

@RunWith(AllureAndroidJUnit4.class)
public class EditingNewsPageInvalidTest {

    private final PagesHelper pagesHelper = new PagesHelper();
    private final EditingNewsPage editingNewsPage = new EditingNewsPage();
    private final LoginPage loginPage = new LoginPage();;
    private final int invalidCategory = 2;
    private View decorView;

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void checkNewsPageIsDisplayed() {
        if (!pagesHelper.checkPage((editingNewsPage.getAddNewsBtn()))) {
            if (pagesHelper.checkPage(loginPage.getLoginId())) {
                loginPage.validAuthentication();
                editingNewsPage.goToEditNewsPage();
            } else {
                editingNewsPage.goToEditNewsPage();
            }
        }
    }


    @Test
    @DisplayName("Проверка создания новости без выбора категории")
    public void createNewsWithEmptyCategory() {
        editingNewsPage.goToCreateNewsPageFromEditPage();
        editingNewsPage.createNewsWithEmptyCategory(invalidCategory);
        editingNewsPage.checkPopUpEmptyNewsMessage(decorView);
    }

    @Test
    @DisplayName("Проверка создания новости с пустым полем заголовка")
    public void createNewsWithEmptyTitle() {
        editingNewsPage.goToCreateNewsPageFromEditPage();
        editingNewsPage.createNewsWithEmptyTitle(invalidCategory);
        editingNewsPage.checkPopUpEmptyNewsMessage(decorView);
    }


    @Test
    @DisplayName("Проверка создания новости с пустым полем описания")
    public void CreateNewsWithEmptyDescription() {
        editingNewsPage.goToCreateNewsPageFromEditPage();
        editingNewsPage.createNewsWithEmptyDescriptions(invalidCategory);
        editingNewsPage.checkPopUpEmptyNewsMessage(decorView);
    }

    @Test
    @DisplayName("Проверка создания новости с пустым полем дата")
    public void CreateNewsWithEmptyDate() {
        editingNewsPage.goToCreateNewsPageFromEditPage();
        editingNewsPage.createNewsWithEmptyDate(invalidCategory);
        editingNewsPage.checkPopUpEmptyNewsMessage(decorView);
    }

    @Test
    @DisplayName("Проверка создания новости с пустым полем времени")
    public void CreateNewsWithEmptyTime() {
        editingNewsPage.goToCreateNewsPageFromEditPage();
        editingNewsPage.createNewsWithEmptyTime(invalidCategory);
        editingNewsPage.checkPopUpEmptyNewsMessage(decorView);
    }
}