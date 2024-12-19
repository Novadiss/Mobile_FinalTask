package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

import android.view.View;

import org.hamcrest.Matchers;

import java.util.Random;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.data.ViewActions;

public class EditingNewsPage {

    private final int createNewsPageView = R.id.container_custom_app_bar_include_on_fragment_create_edit_news;
    private final int editNewsBtn = R.id.edit_news_material_button;
    private final int addNewsBtn =    R.id.add_news_image_view;
    private final String editPageView = "Control panel";
    private final int categoryId = R.id.news_item_category_text_input_layout;
    private final int titleIdView = R.id.news_item_title_text_input_edit_text;
    private final int categoryInsertId = R.id.news_item_category_text_auto_complete_text_view;
    private final int descriptionId = R.id.news_item_description_text_input_edit_text;
    private final int newsDescriptionId = R.id.news_item_description_text_view;
    private final int dateId = R.id.news_item_publish_date_text_input_edit_text;
    private final int button1 = android.R.id.button1;
    private final int timeId = R.id.news_item_publish_time_text_input_edit_text;
    private final int saveBtn = R.id.save_button;
    private final int filterBtn = R.id.filter_news_material_button;
    private final int startFilterDate = R.id.news_item_publish_date_start_text_input_edit_text;
    private final int endFilterDate = R.id.news_item_publish_date_end_text_input_edit_text;
    private final int saveFilterBtn = R.id.filter_button;
    private final int recyclerNewsList = R.id.news_list_recycler_view;
    private final int newsItemView = R.id.news_item_material_card_view;
    private final int deleteNewsBtn = R.id.delete_news_item_image_view;
    private final int editChekingNewsBtn = R.id.edit_news_item_image_view;
    

    private final PagesHelper pagesHelper = new PagesHelper();
    private final NewsPage newsPage = new NewsPage();
    private final DataHelper dataHelper = new DataHelper();

    public String getEditNewsPageView() {
        return editPageView;
    }

    public int getCreateNewsPageView() {
        return createNewsPageView;
    }

    public int getAddNewsBtn() {
        return addNewsBtn;
    }

    public void goToEditNewsPage() {
        Allure.step("Переход на страницу редактирования новостей");
        newsPage.goToNewsPage();
        pagesHelper.checkOnView(editNewsBtn);
        pagesHelper.buttonClickWithId(editNewsBtn);
        pagesHelper.checkOnView(addNewsBtn);
        pagesHelper.textIsDisplayed(editPageView);
    }

    public void goToCreateNewsPageFromEditPage() {
        Allure.step("Переход на страницу создания новости");
        pagesHelper.buttonClickWithId(addNewsBtn);
        pagesHelper.idIsDisplayed(createNewsPageView);
    }

    public void selectPublicationDate(String date) {
        Allure.step("Ввод даты публикации");
        if (date.isEmpty()) {
            onView(withId(dateId)).perform(click());
            onView(withId(button1)).perform(click());
        } else {
            onView(withId(dateId))
                    .perform(longClick()).perform(replaceText(date), closeSoftKeyboard());
        }
    }

    public void selectPublicationTime(String time) {
        Allure.step("Ввод времени публикации");
        if (time.isEmpty()) {
            onView(withId(timeId)).perform(click());
            onView(withId(button1)).perform(click());
        } else {
            onView(withId(timeId))
                    .perform(longClick()).perform(replaceText(time), closeSoftKeyboard());
        }
    }

    public void selectStartFilterDate(String date) {
        Allure.step("Ввод даты начала диапазона фильтрации");
        if (date.isEmpty()) {
            onView(withId(startFilterDate)).perform(click());
            onView(withId(button1)).perform(click());
        } else {
            onView(withId(startFilterDate))
                    .perform(longClick()).perform(replaceText(date), closeSoftKeyboard());
        }
    }

    public void selectEndFilterDate(String date) {
        Allure.step("Ввод даты окончания диапазона фильтрации");
        if (date.isEmpty()) {
            onView(withId(endFilterDate)).perform(click());
            onView(withId(button1)).perform(click());
        } else {
            onView(withId(endFilterDate))
                    .perform(longClick()).perform(replaceText(date), closeSoftKeyboard());
        }
    }

    public void checkNewsPublishedToBe(int categoryNews) {
        Allure.step("Проверка что новость создана");
        onView(withId(recyclerNewsList)).perform(actionOnItemAtPosition(0, click()));
        onView(allOf(withId(newsDescriptionId),
                withParent(withParent(withId(newsItemView))),
                isDisplayed()))
                .check(matches(withText(DataHelper.getNewsData(categoryNews).getDescription())));
    }

    public void checkNewsPublishedNotToBe(int categoryNews) {
        Allure.step("Проверка что новости нет");
        onView(withId(recyclerNewsList)).perform(actionOnItemAtPosition(0, click()));
        onView(allOf(withId(newsDescriptionId),
                withParent(withParent(withId(newsItemView))),
                isDisplayed()))
                .check(matches(not(withText(DataHelper.getNewsData(categoryNews).getDescription()))));
    }

    public void checkPopUpEmptyNewsMessage( View decorView ) {
        Allure.step("Проверка наличи всплывающего сообщения что не все поля заполнены");
        onView(withText(DataHelper.getEmptyCreateNewsError()))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    public void deleteValidNewsPublished() {
        Allure.step("Удаление новости");
        onView(allOf(ViewActions.getElementFromMatchAtPosition(allOf(withId(deleteNewsBtn)), 0))).perform(click());
        pagesHelper.buttonClickWithId(button1);
    }

    public void createNews(int categoryNews) {
        Allure.step("Создание новости");
        pagesHelper.pageIsDisplayed(categoryId);
        pagesHelper.buttonClickWithId(categoryId);
        onView(withId(categoryInsertId)).perform(replaceText(DataHelper.getNewsData(categoryNews).getCategory()), closeSoftKeyboard());
        pagesHelper.insertNewsData(titleIdView, DataHelper.getNewsData(categoryNews).getTitle());
        pagesHelper.insertNewsData(descriptionId, DataHelper.getNewsData(categoryNews).getDescription());
        pagesHelper.pageIsDisplayed(dateId);
        selectPublicationDate(DataHelper.getDateToString(DataHelper.generateDate(1)));
        pagesHelper.pageIsDisplayed(timeId);
        selectPublicationTime(DataHelper.getTimeToString(DataHelper.getValidTime()));
        pagesHelper.pageIsDisplayed(saveBtn);
        pagesHelper.buttonClickWithId(saveBtn);
    }

    public void findCreatedNews(int categoryNews) {
        Allure.step("Проверка что созданная новость существует и доступна");
        pagesHelper.textIsDisplayed(editPageView);
        pagesHelper.pageIsDisplayed(filterBtn);
        pagesHelper.buttonClickWithId(filterBtn);
        onView(withId(categoryInsertId)).perform(replaceText(DataHelper.getNewsData(categoryNews).getCategory()), closeSoftKeyboard());
        pagesHelper.pageIsDisplayed(dateId);
        selectStartFilterDate(DataHelper.getDateToString(DataHelper.generateDate(1)));
        selectEndFilterDate(DataHelper.getDateToString(DataHelper.generateDate(1)));
        pagesHelper.pageIsDisplayed(saveFilterBtn);
        pagesHelper.buttonClickWithId(saveFilterBtn);
        checkNewsPublishedToBe(categoryNews);
    }

    public void modifyNews(int categoryNews) {
        Allure.step("Редактирование новости");
        onView(allOf(ViewActions.getElementFromMatchAtPosition(allOf(withId(editChekingNewsBtn)), 0))).perform(click());
        pagesHelper.pageIsDisplayed(categoryId);
        pagesHelper.buttonClickWithId(categoryId);
        onView(withId(categoryInsertId)).perform(replaceText(DataHelper.getNewsData(categoryNews).getCategory()), closeSoftKeyboard());
        pagesHelper.insertNewsData(titleIdView, DataHelper.getNewsData(categoryNews).getTitle());
        pagesHelper.insertNewsData(descriptionId, DataHelper.getNewsData(categoryNews).getDescription());
        pagesHelper.pageIsDisplayed(saveBtn);
        pagesHelper.buttonClickWithId(saveBtn);
    }

    public void createNewsWithEmptyCategory(int categoryNews) {
        Allure.step("Попытка создания новости без внесения данных в поле категория");
        pagesHelper.insertNewsData(titleIdView, DataHelper.getNewsData(categoryNews).getTitle());
        pagesHelper.insertNewsData(descriptionId, DataHelper.getNewsData(categoryNews).getDescription());
        pagesHelper.pageIsDisplayed(dateId);
        selectPublicationDate(DataHelper.getDateToString(DataHelper.generateDate(1)));
        pagesHelper.pageIsDisplayed(timeId);
        selectPublicationTime(DataHelper.getTimeToString(DataHelper.getValidTime()));
        pagesHelper.pageIsDisplayed(saveBtn);
        pagesHelper.buttonClickWithId(saveBtn);
    }

    public void createNewsWithEmptyTitle(int categoryNews) {
        Allure.step("Попытка создания новости без внесения данных в поле заголовок");
        pagesHelper.pageIsDisplayed(categoryId);
        pagesHelper.buttonClickWithId(categoryId);
        onView(withId(categoryInsertId)).perform(replaceText(DataHelper.getNewsData(categoryNews).getCategory()), closeSoftKeyboard());
        pagesHelper.insertNewsData(descriptionId, DataHelper.getNewsData(categoryNews).getDescription());
        pagesHelper.pageIsDisplayed(dateId);
        selectPublicationDate(DataHelper.getDateToString(DataHelper.generateDate(1)));
        pagesHelper.pageIsDisplayed(timeId);
        selectPublicationTime(DataHelper.getTimeToString(DataHelper.getValidTime()));
        pagesHelper.pageIsDisplayed(saveBtn);
        pagesHelper.buttonClickWithId(saveBtn);
    }

    public void createNewsWithEmptyDescriptions(int categoryNews) {
        Allure.step("Попытка создания новости без внесения данных в поле описание");
        pagesHelper.pageIsDisplayed(categoryId);
        pagesHelper.buttonClickWithId(categoryId);
        onView(withId(categoryInsertId)).perform(replaceText(DataHelper.getNewsData(categoryNews).getCategory()), closeSoftKeyboard());
        pagesHelper.insertNewsData(titleIdView, DataHelper.getNewsData(categoryNews).getTitle());
        pagesHelper.pageIsDisplayed(dateId);
        selectPublicationDate(DataHelper.getDateToString(DataHelper.generateDate(1)));
        pagesHelper.pageIsDisplayed(timeId);
        selectPublicationTime(DataHelper.getTimeToString(DataHelper.getValidTime()));
        pagesHelper.pageIsDisplayed(saveBtn);
        pagesHelper.buttonClickWithId(saveBtn);
    }

    public void createNewsWithEmptyDate(int categoryNews) {
        Allure.step("Попытка создания новости без внесения данных в поле дата");
        pagesHelper.pageIsDisplayed(categoryId);
        pagesHelper.buttonClickWithId(categoryId);
        onView(withId(categoryInsertId)).perform(replaceText(DataHelper.getNewsData(categoryNews).getCategory()), closeSoftKeyboard());
        pagesHelper.insertNewsData(titleIdView, DataHelper.getNewsData(categoryNews).getTitle());
        pagesHelper.insertNewsData(descriptionId, DataHelper.getNewsData(categoryNews).getDescription());
        pagesHelper.pageIsDisplayed(timeId);
        selectPublicationTime(DataHelper.getTimeToString(DataHelper.getValidTime()));
        pagesHelper.pageIsDisplayed(saveBtn);
        pagesHelper.buttonClickWithId(saveBtn);
    }

    public void createNewsWithEmptyTime(int categoryNews) {
        Allure.step("Попытка создания новости без внесения данных в поле время");
        pagesHelper.pageIsDisplayed(categoryId);
        pagesHelper.buttonClickWithId(categoryId);
        onView(withId(categoryInsertId)).perform(replaceText(DataHelper.getNewsData(categoryNews).getCategory()), closeSoftKeyboard());
        pagesHelper.insertNewsData(titleIdView, DataHelper.getNewsData(categoryNews).getTitle());
        pagesHelper.insertNewsData(descriptionId, DataHelper.getNewsData(categoryNews).getDescription());
        pagesHelper.pageIsDisplayed(dateId);
        selectPublicationDate(DataHelper.getDateToString(DataHelper.generateDate(1)));
        pagesHelper.pageIsDisplayed(saveBtn);
        pagesHelper.buttonClickWithId(saveBtn);
    }
}


