package ru.iteco.fmhandroid.ui.pages;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class ReviewPage {

    private final int reviewPageId = R.id.our_mission_title_text_view;
    private final int reviewImageButton = R.id.our_mission_image_button;

    private final PagesHelper pagesHelper = new PagesHelper();

    public int getReviewPageId() {
        return reviewPageId;
    }


    public void goToReviewPage() {
        Allure.step("Переход на страницу отзывов");
        pagesHelper.checkOnView(reviewImageButton);
        pagesHelper.buttonClickWithId(reviewImageButton);
    }

    public void reviewPageIsDisplayed() {
        Allure.step("Проверка отображения страницы отзывов");
        pagesHelper.idIsDisplayed(reviewPageId);
    }
}
