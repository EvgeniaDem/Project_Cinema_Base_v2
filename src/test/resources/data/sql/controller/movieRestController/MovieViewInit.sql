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
values (100, 'name1'),
       (200, 'name2'),
       (300, 'name3'),
       (400, 'name4'),
       (500, 'name5');

insert into public.persons (id, birthday, first_name, height, last_name, original_last_name, original_name, photo_url, place_birthday)
values (100, '2022-01-01', 'first1', 180, 'name1', 'origname1', 'origlast1', 'url1', 'place1'),
       (200, '2021-01-01', 'first2', 170, 'name2', 'origname2', 'origlast2', 'url2', 'place2'),
       (300, '2020-01-01', 'first3', 160, 'name3', 'origname3', 'origlast3', 'url3', 'place3'),
       (400, '2019-01-01', 'first4', 150, 'name4', 'origname4', 'origlast4', 'url4', 'place4');

insert into public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (100, 'country1', '2020-02-02', 'descrip descrip', 'GENERAL_AUDIENCES', 'name1', 'orig1', 'ZERO_PLUS', 101),
       (200, 'country2', '2019-02-02', 'descrip descrip', 'GENERAL_AUDIENCES', 'name2', 'orig2', 'ZERO_PLUS', 102),
       (300, 'country3', '2018-02-02', 'descrip descrip', 'GENERAL_AUDIENCES', 'name3', 'orig3', 'ZERO_PLUS', 103),
       (400, 'country4', '2017-02-02', 'descrip descrip', 'GENERAL_AUDIENCES', 'name4', 'orig4', 'ZERO_PLUS', 104),
       (500, 'country5', '2016-02-02', 'descrip descrip', 'GENERAL_AUDIENCES', 'name5', 'orig5', 'ZERO_PLUS', 105);

insert into public.genres (id, name)
VALUES (100, 'genre1'),
       (200, 'genre2'),
       (300, 'genre3'),
       (400, 'genre4'),
       (500, 'genre5');

insert into movie_genre (movie_id, genre_id)
VALUES (100, 100),
       (200, 200),
       (300, 300),
       (400, 400),
       (500, 500),
       (100, 200),
       (100, 300);

insert into public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (100, 100, 100, 'role1', 'MAIN_CHARACTER'),
       (200, 200, 200, 'role2', 'MINOR_CHARACTER');

insert into public.collections (id, collection_type, enable, name, preview_url)
VALUES (100, null, null, null, 'url1'),
       (200, null, null, null, 'url2'),
       (300, null, null, null, 'url3'),
       (400, null, null, null, 'url4'),
       (500, null, null, null, 'url5');

insert into public.collections_movies (collections_id, movies_id)
VALUES (100, 100),
       (200, 200),
       (300, 300),
       (400, 400),
       (500, 500),
       (100, 200),
       (100, 300);

insert into public.score (id, score, movie_id, user_id)
VALUES (100, 10, 100, null),
       (200, 1, 200, null),
       (300, 2, 300, null),
       (400, 4, 400, null),
       (500, 7, 500, null),
       (600, 9, 100, null),
       (700, 2, 200, null),
       (800, 10, 300, null),
       (900, 1, 400, null),
       (1000, 1, 500, null),
       (1100, 4, 100, null),
       (1200, 3, 200, null),
       (1300, 7, 300, null),
       (1400, 5, 400, null),
       (1500, 6, 500, null),
       (1600, 8, 100, null),
       (1700, 10, 200, null),
       (1800, 1, 300, null),
       (1900, 1, 400, null),
       (2000, 2, 500, null),
       (2100, 4, 100, null),
       (2200, 5, 200, null),
       (2300, 3, 300, null),
       (2400, 6, 400, null);




