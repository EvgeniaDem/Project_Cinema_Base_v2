package com.kata.cinema.base.models.dto;


import lombok.Data;

import java.util.Date;

@Data
public class SearchPersonDto {

    private Long id;
    private String photoUrl;
    private String fullName;
    private String originalFullName;
    //TODO сменил LocalDate на Date т.к в Person private Date birthday;
    private Date birthday;
    private String firstName;
    private String lastName;
    private String originalName;
    private String originalLastName;

    //TODO добавил getters для полей т.к в запросе не удалось конкатинировать переменные
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getOriginalFullName() {
        return originalName + " " + originalLastName;
    }

    public SearchPersonDto(Long id, String firstName, String lastName, String originalName,String originalLastName, String photoUrl, Date birthday) {
        this.id = id;
        this.photoUrl = photoUrl;
        this.birthday = birthday;
        this.firstName = firstName;
        this.lastName = lastName;
        this.originalName = originalName;
        this.originalLastName = originalLastName;
    }
}
