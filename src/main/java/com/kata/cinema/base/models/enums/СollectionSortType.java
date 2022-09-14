package com.kata.cinema.base.models.enums;

public enum СollectionSortType {
    ORDER("По порядку"),
    COUNT_SCORE("По количеству оценок"),
    RATING("По рейтингу"),
    RELEASE_DATE("По дате выхода"),
    NAME("По названию");

    private final String name;

    СollectionSortType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
