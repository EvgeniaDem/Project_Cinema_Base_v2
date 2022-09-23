delete from collections_movies;
delete from folders_movies_to_movies;
delete from folders_movies;
delete from movie_genre;
delete from movie_person;
delete from movies;
delete from collections;
delete from users;
delete from genres;
delete from professions;
delete from persons;
delete from score;



insert into movies(id, countries, date_release, description, mpaa, name, rars, time, original_name)
values (100, 'test_countries1', '2021-08-09', 'ACTION', 'PARENTAL_GUIDANCE_SUGGESTED', 'DOOM', 'SIXTEEN_PLUS', 9600, 'doom');
insert into movies(id, countries, date_release, description, mpaa, name, rars, time, original_name)
values (101, 'test_countries', '2022-08-09', 'ACTION', 'PARENTAL_GUIDANCE_SUGGESTED', 'wood', 'SIXTEEN_PLUS' , 9600, 'wood');



insert into collections(id, enable, name, description, collection_type, preview_url)
values (100, true, 'myCollectionTest', 'myDescription', 'MOVIES' , 'test_URL');


insert into collections_movies( collections_id, movies_id)
values (100, 100);
insert into collections_movies(collections_id, movies_id)
values (100, 101);


insert into public.genres (id, name)
values (1, 'genre 1');
insert into public.genres (id, name)
values (2, 'genre 2');
insert into public.genres (id, name)
values (3, 'genre 3');
insert into genres(id, "name")
values (100, 'genre 1');


insert into public.movie_genre (movie_id, genre_id)
values (101, 100);
insert into public.movie_genre (movie_id, genre_id)
values (100, 100);



insert into public.professions (id, name)
values (101, 'актер');
insert into professions(id,name)
values (100,'director_100');


insert into public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
values (1, '2022-06-21' , 'test1Name', 111, 'test1LastName', 'test', 'test1OrigLastName', 'test1origName', 'test1PhotoUrl');
insert into public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
values (2, '2022-06-21' , 'test1Name', 111, 'test1LastName', 'test', 'test1OrigLastName', 'test1origName', 'test1PhotoUrl');
insert into public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
values (3, '2022-06-22' , 'test2Name', 222, 'test2LastName', 'test', 'test2OrigLastName', 'test2origName', 'test2PhotoUrl');


insert into public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
values (100, 1, 100, 'role1', 'MAIN_CHARACTER');
insert into public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
values (101, 2, 101, 'role2', 'MINOR_CHARACTER');
insert into public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
values (100, 3, 100, 'role3', 'MAIN_CHARACTER');


insert into public.users (id, avatar_url, birthday, email, first_name, last_name, password)
values (1, null, '2022-08-14', 'user1@mail.ru', 'user1', 'userovich1', '$2a$12$/FIhv2k1jeNx5YCr6bZLlujKpN5V8V3j7qD16WtMC9Ov/tVhyjUIW'); -- password == 101

insert into public.score (id, score, movie_id, user_id)
values (1, 3, 100, 1);
insert into public.score (id, score, movie_id, user_id)
values (2, 4, 100, 1);
insert into public.score (id, score, movie_id, user_id)
values (3, 5, 100, 1);
insert into public.score (id, score, movie_id, user_id)
values (4, 5, 100, 1);

