package com.kata.cinema.base.dao.dto;

import java.util.List;
import java.util.Map;

public interface CollectionMoviesResponseDtoDao {

    Map<Long, List<String>> getAllCollections();

}
