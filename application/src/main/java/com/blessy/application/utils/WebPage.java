package com.blessy.application.utils;

import lombok.Getter;

public enum WebPage {

    NOT_FOUND("404"),
    EXCEPTION("exception"),
    LOGIN("login"),
    REGISTER("register"),
    ACCESS_DENIED("error/403"),
    PROFILE("profile"),
    RESET_PASSWORD_FOR_USER("user/reset_password"),

    HOME("index"),

    /**
     * ADMIN PAGES
     */

    CONTINENTS("continents/continents"),
    CONTINENT_COUNTRIES("continents/continent_countries"),
    ADD_CONTINENT("continents/add_continent");

    @Getter
    private final String pageName;

    WebPage(String pageName) {
        this.pageName = pageName;
    }

    @Override
    public String toString() {
        return getPageName();
    }

}
