package ru.iteco.fmhandroid.ui.tests;

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
public class EditingNewsPageValidTest {

    private final PagesHelper pagesHelper = new PagesHelper();
    private final EditingNewsPage editingNewsPage = new EditingNewsPage();
    private final LoginPage loginPage = new LoginPage();

    private final int category = 0;
    private final int modCategory = 1;

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
    @DisplayName("Проверка что отображается страница редактирования новостей")
    public void editNewsView() {
        editingNewsPage.getEditNewsPageView();
    }

    @Test
    @DisplayName("Проверка что отображается страница создания новости")
    public void createNewsPageView() {
        editingNewsPage.goToCreateNewsPageFromEditPage();
        editingNewsPage.getCreateNewsPageView();
    }

    @Test
    @DisplayName("Создание новости с валидными данными, последующей проверкой и удалением")
    public void createCheckAndDeleteValidNews() {
        editingNewsPage.goToCreateNewsPageFromEditPage();
        editingNewsPage.createNews(category);
        editingNewsPage.findCreatedNews(category);
        editingNewsPage.deleteValidNewsPublished();
    }

    @Test
    @DisplayName("Создание новости с валидными данными, последующим редактированием и удалением")
    public void modifyValidNews() {
        editingNewsPage.goToCreateNewsPageFromEditPage();
        editingNewsPage.createNews(category);
        editingNewsPage.findCreatedNews(category);
        editingNewsPage.modifyNews(modCategory);
        editingNewsPage.findCreatedNews(modCategory);
        editingNewsPage.deleteValidNewsPublished();
    }
}
