delete from public.movie_person;
delete from public.professions;
delete from public.persons;
delete from public.movie_genre;
delete from public.collections_movies;
delete from public.score;
delete from public.movies;
delete from public.genres;
delete from public.collections;

insert into public.professions (id, name)
values (1, 'name1'),
       (2, 'name2'),
       (3, 'name3'),
       (4, 'name4'),
       (5, 'name5');

insert into public.persons (id, birthday, first_name, height, last_name, original_last_name, original_name, photo_url, place_birthday)
values (1, '2022-01-01', 'first1', 180, 'name1', 'origname1', 'origlast1', 'url1', 'place1'),
       (2, '2021-01-01', 'first2', 170, 'name2', 'origname2', 'origlast2', 'url2', 'place2'),
       (3, '2020-01-01', 'first3', 160, 'name3', 'origname3', 'origlast3', 'url3', 'place3'),
       (4, '2019-01-01', 'first4', 150, 'name4', 'origname4', 'origlast4', 'url4', 'place4');

insert into public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (1, 'country1', '2020-02-02', 'descrip descrip', 'GENERAL_AUDIENCES', 'name1', 'orig1', 'ZERO_PLUS', 101),
       (2, 'country2', '2019-02-02', 'descrip descrip', 'GENERAL_AUDIENCES', 'name2', 'orig2', 'ZERO_PLUS', 102),
       (3, 'country3', '2018-02-02', 'descrip descrip', 'GENERAL_AUDIENCES', 'name3', 'orig3', 'ZERO_PLUS', 103),
       (4, 'country4', '2017-02-02', 'descrip descrip', 'GENERAL_AUDIENCES', 'name4', 'orig4', 'ZERO_PLUS', 104),
       (5, 'country5', '2016-02-02', 'descrip descrip', 'GENERAL_AUDIENCES', 'name5', 'orig5', 'ZERO_PLUS', 105);

insert into public.genres (id, name)
VALUES (1, 'genre1'),
       (2, 'genre2'),
       (3, 'genre3'),
       (4, 'genre4'),
       (5, 'genre5');

insert into movie_genre (movie_id, genre_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5),
       (1, 2),
       (1, 3);

insert into public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (1, 1, 1, 'role1', 'MAIN_CHARACTER'),
       (2, 2, 2, 'role2', 'MINOR_CHARACTER');

insert into public.collections (id, collection_type, enable, name, preview_url)
VALUES (1, null, null, null, 'url1'),
       (2, null, null, null, 'url2'),
       (3, null, null, null, 'url3'),
       (4, null, null, null, 'url4'),
       (5, null, null, null, 'url5');

insert into public.collections_movies (collections_id, movies_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5),
       (1, 2),
       (1, 3);

insert into public.score (id, score, movie_id, user_id)
VALUES (1, 10, 1, null),
       (2, 1, 2, null),
       (3, 2, 3, null),
       (4, 4, 4, null),
       (5, 7, 5, null),
       (6, 9, 1, null),
       (7, 2, 2, null),
       (8, 10, 3, null),
       (9, 1, 4, null),
       (10, 1, 5, null),
       (11, 4, 1, null),
       (12, 3, 2, null),
       (13, 7, 3, null),
       (14, 5, 4, null),
       (15, 6, 5, null),
       (16, 8, 1, null),
       (17, 10, 2, null),
       (18, 1, 3, null),
       (19, 1, 4, null),
       (20, 2, 5, null),
       (21, 4, 1, null),
       (22, 5, 2, null),
       (23, 3, 3, null),
       (24, 6, 4, null);




