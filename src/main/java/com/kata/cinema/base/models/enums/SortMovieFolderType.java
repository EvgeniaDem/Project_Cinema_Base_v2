package com.kata.cinema.base.models.enums;

public enum SortMovieFolderType {
    ORDER("Очередь"),
    NAME("Название"),
    ORIGINAL_NAME("Оригинальное название"),
    RATING("Рейтинг"),
    MY_SCORE("Моя оценка"),
    COUNT_SCORE("Число оценок"),
    YEAR("Год");

    private final String name;

    SortMovieFolderType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
