package ru.iteco.fmhandroid.ui.data;

import android.icu.util.LocaleData;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class DataHelper {

    // Аутентификационные данные

    public static class Creds {
        private final String login;
        private final String password;

        private Creds(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return this.login;
        }

        public String getPassword() {
            return this.password;
        }
    }

    public static Creds getValidCreds() {
        return new Creds("login2", "password2");
    }

    public static Creds getInvalidCreds() {
        return new Creds("qwerty123", "qwerty123");
    }

    public static Creds getValidLoginInvalidPassword() {
        return new Creds("login2", "qwerty123");
    }

    public static Creds getValidPasswordInvalidLogin() {
        return new Creds("qwerty123", "password2");
    }

    public static Creds getEmptyCreds() {
        return new Creds("", "");
    }

    public static String getInvalidAuthError() {
        return "Something went wrong. Try again later.";
    }

    public static String getEmptyAuthError() {
        return "Login and password cannot be empty";
    }

    // Данные для форм редактирования и создания новостей

    public static final String[] newsCategory = {
            "Объявление",
            "День рождения",
            "Зарплата",
            "Профсоюз",
            "Праздник"
    };

    public static class NewsData {
        private final String category;
        private final String title;
        private final String description;


        private NewsData(String category, String title, String description) {
            this.category = category;
            this.title = title;
            this.description = description;
        }

        public String getCategory() {
            return this.category;
        }

        public String getTitle() {
            return this.title;
        }

        public String getDescription() {
            return this.description;
        }
    }

    public static LocalDateTime generateDate(int plusDays) {
        return LocalDateTime.now().plusDays(plusDays);
    }

    public static LocalTime generateTime(int start, int end) {
        int randomTime = ThreadLocalRandom.current().nextInt(start, end);
        return LocalTime.ofSecondOfDay(randomTime);
    }

    public static LocalTime getValidTime() {
        return generateTime(1, 86400);
    }

    public static NewsData getNewsData(int categoryIndex) {
        switch (categoryIndex) {
            case 1:
                return new NewsData(newsCategory[1],
                        "Modified News",
                        "Modified News");
            case 2:
                return new NewsData(newsCategory[2],
                        "",
                        "");
            default:
                return new NewsData(newsCategory[0],
                        "Random News",
                        "Random News");

        }
    }


    public static String getDateToString(LocalDateTime date) {
        String formatPattern = "dd.MM.yyyy";
        return date.format(DateTimeFormatter.ofPattern(formatPattern));
    }

    public static String getTimeToString(LocalTime date) {
        String formatPattern = "HH:mm";
        return date.format(DateTimeFormatter.ofPattern(formatPattern));
    }

    public static String getHourToString(LocalDateTime date) {
        String formatPattern = "HH";
        return date.format(DateTimeFormatter.ofPattern(formatPattern));
    }

    public static String getMinuteToString(LocalDateTime date) {
        String formatPattern = "mm";
        return date.format(DateTimeFormatter.ofPattern(formatPattern));
    }

    public static String getEmptyCreateNewsError() {
        return "Fill empty fields";
    }
}