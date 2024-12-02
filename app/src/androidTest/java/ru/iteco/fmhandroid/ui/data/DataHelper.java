package ru.iteco.fmhandroid.ui.data;

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
}

