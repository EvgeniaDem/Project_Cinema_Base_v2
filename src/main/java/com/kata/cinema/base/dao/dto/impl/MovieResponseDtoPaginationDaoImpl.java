package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.MovieResponseDtoPaginationDao;
import com.kata.cinema.base.dao.entity.impl.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.response.MovieResponseDto;
import com.kata.cinema.base.models.entitys.FolderMovie;
import com.kata.cinema.base.models.enums.ShowType;
import com.kata.cinema.base.models.enums.SortMovieFolderType;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class MovieResponseDtoPaginationDaoImpl extends AbstractDaoImpl<Long, FolderMovie> implements MovieResponseDtoPaginationDao {
    @Override
    public List<MovieResponseDto> getItemsDto(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        return entityManager.createQuery("select " +
                                "new com.kata.cinema.base.models.dto.response.MovieResponseDto(m.id, m.name, m.originalName, m.time, m.dateRelease, m.countries) " +
                                "from FolderMovie fm join fm.movies m " +
                                sortingByScore((SortMovieFolderType) parameters.get("sortMovieFolderType")) +
                                "where fm.id = :id" +
                                sortingByShowType((ShowType) parameters.get("showType")) +
                                sortingBySortMovieFolderType((SortMovieFolderType) parameters.get("sortMovieFolderType"))
                        , MovieResponseDto.class)
                .setParameter("id", parameters.get("id"))
                .setFirstResult((currentPage - 1) * itemsOnPage)
                .setMaxResults(itemsOnPage)
                .getResultList();
    }

    @Override
    public Long getResultTotal(Map<String, Object> parameters) {
        TypedQuery<Long> query = entityManager
                .createQuery("select count(distinct m) from FolderMovie fm join fm.movies m where fm.id = :id" +
                        sortingByShowType((ShowType) parameters.get("showType")), Long.class)
                .setParameter("id", parameters.get("id"));
        return query.getSingleResult();
    }

    private String sortingBySortMovieFolderType(SortMovieFolderType sortMovieFolderType) {
        switch (sortMovieFolderType) {
            case NAME: {
                return " order by m.name";
            }
            case ORIGINAL_NAME: {
                return " order by m.originalName";
            }
            case RATING: {
                return " group by m.id order by sum(s.score)/count(s) desc";
            }
            case MY_SCORE: {
                return " order by s.score DESC NULLS LAST";
            }
            case COUNT_SCORE: {
                return " group by m.id order by count(distinct s) desc";
            }
            case YEAR: {
                return " order by m.dateRelease desc";
            }
            default: {
                return " order by m.id";
            }
        }
    }

    private String sortingByScore(SortMovieFolderType sortMovieFolderType) {
        switch (sortMovieFolderType) {
            case COUNT_SCORE: {
                return "left join Score s on m.id=s.movie.id ";
            }
            case RATING: {
                return "left join Score s on m.id=s.movie.id ";
            }
            case MY_SCORE: {
                return "left join Score s on m.id=s.movie.id and s.user.id = fm.user.id ";
            }
            default: {
                return "";
            }
        }
    }

    private String sortingByShowType(ShowType showType) {
        switch (showType) {
            case VIEWED: {
                return " and m.id in (select sm.id from FolderMovie sfm join sfm.movies sm where sfm.category = 'VIEWED_MOVIES')";
            }
            case NOT_VIEWED: {
                return " and m.id not in (select sm.id from FolderMovie sfm join sfm.movies sm where sfm.category = 'VIEWED_MOVIES')";
            }
            default: {
                return "";
            }
        }
    }
}
