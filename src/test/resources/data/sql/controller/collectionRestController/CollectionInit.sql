delete from collections_movies;
delete from folders_movies_to_movies;
delete from folders_movies;
delete from movies;
delete from collections;
delete from users;



INSERT into users(id, avatar_url, birthday, email, first_name, last_name, password)
values (100, 'test', '2022-08-04', 'test@mail.ru', 'test_firstname', 'test_lastname', '$2y$10$9eccPudsnqsR3/XOgzugreDmY5svycvzgxSrSXZHge/oTe.jlAjeC'  );
INSERT into folders_movies(id, category, description, name, privacy, user_id)
values (100, 'FAVORITE_MOVIES', 'movie test', 'test', 'PUBLIC', 100);
insert into movies(id, countries, date_release, description, mpaa, name, rars, time, origin_name)
values (100, 'test_countries', '2022-08-09', 'ACTION', 'PARENTAL_GUIDANCE_SUGGESTED', 'DOOM', 'SIXTEEN_PLUS', 9600, 'doom');
insert into movies(id, countries, date_release, description, mpaa, name, rars, time, origin_name)
values (101, 'test_countries', '2022-08-09', 'ACTION', 'PARENTAL_GUIDANCE_SUGGESTED', 'wood', 'SIXTEEN_PLUS' , 9600, 'wood');
insert into movies(id, countries, date_release, description, mpaa, name, rars, time, origin_name)
values (102, 'test_countries', '2022-08-09', 'ACTION', 'PARENTAL_GUIDANCE_SUGGESTED', 'Boom', 'TWELVE_PLUS' , 8600, 'boom');
insert into movies(id, countries, date_release, description, mpaa, name, rars, time, origin_name)
values (103, 'test_countries', '2022-08-09', 'ACTION', 'PARENTAL_GUIDANCE_SUGGESTED', 'TEST1', 'SIXTEEN_PLUS', 8600, 'boom');
insert into movies(id, countries, date_release, description, mpaa, name, rars, time, origin_name)
values (104, 'test_countries', '2022-08-09', 'ACTION', 'PARENTAL_GUIDANCE_SUGGESTED', 'TEST2', 'SIXTEEN_PLUS', 8600, 'boom');
insert into movies(id, countries, date_release, description, mpaa, name, rars, time, origin_name)
values (105, 'test_countries', '2022-08-09', 'ACTION', 'PARENTAL_GUIDANCE_SUGGESTED', 'TEST3', 'TWELVE_PLUS', 8600, 'boom');
INSERT INTO collections(id, enable, name, collection_type, collection_url)
values (100, true, 'myCollectionTest', 'MOVIES' , 'test_URL');
insert into folders_movies_to_movies(folders_id , movie_id)
values (100, 100);
insert into folders_movies_to_movies(folders_id , movie_id)
values (100, 101);
insert into folders_movies_to_movies(folders_id , movie_id)
values (100, 102);
INSERT INTO collections_movies(movies_id, collections_id)
values (100, 100);
INSERT INTO collections_movies(movies_id, collections_id)
values (101, 100);
