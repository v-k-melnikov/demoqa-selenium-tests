package com.demoqa.helpers;

public class UserBuilder {


    public  static User createUserWithMinimalCredentials() {
        return new User("a", "a", "89888888888", "a"
                , "a@a.com", "QWErty12");
    }

    public static User createUserWithMaximumCredentials() {
        return new User(getSimpleString(64), getSimpleString(64), "+79888888888"
                , getSimpleString(64), getSimpleString(58) + "@a.com"
                , getSimpleString(62) + "A" + 1);
    }

    public static User createSignUpUser() {
        return new User("a", "a", "89888888888", "a"
                , "a@a.com", "QWErty12");
    }

    private static String getSimpleString(int length) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            str.append("a");
        }
        return str.toString();
    }
}
