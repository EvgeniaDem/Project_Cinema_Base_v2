delete from public.movie_person;
delete from public.folders_movies_to_movies;
delete from public.movie_genre;
delete from public.persons_marriage;
delete from public.persons;
delete from public.score;
delete from public.user_role;
delete from public.collections_movies;
delete from public.movies;
delete from public.genres;
delete from public.roles;
delete from public.folders_movies;
delete from public.users;
delete from public.professions;

-- users init
INSERT INTO public.users (id, avatar_url, birthday, email, first_name, last_name, login, password)
VALUES (1, null, '2022-08-14', 'user1@mail.ru', 'user1', 'userovich1', 'login1', '$2a$12$LxXLdibZ7FKwP/ukWEJ3Me/uMmymL6V1igL9utV2tGL8CBw/ENfcC'); -- password == 101
INSERT INTO public.users (id, avatar_url, birthday, email, first_name, last_name, login, password)
VALUES (2, null, '2022-08-15', 'user2@mail.ru', 'user2', 'userovich2', 'login2', '$2a$12$eJQNiWAf01OGGrzY4dYMludZGSZG06myrpsjH0P3SzH7IRbO624h6'); -- password == 102
INSERT INTO public.users (id, avatar_url, birthday, email, first_name, last_name, login, password)
VALUES (3, null, '2022-08-11', 'user3@mail.ru', 'user3', 'userovich3', 'login3', '$2a$12$kxj107giVr0cwRRy6csu8OAgML4fiofnZ/YIR.C7P.kAHe2Cr2kru'); -- password == 103

-- roles init
INSERT INTO public.roles(id, name)
VALUES (1, 'USER');

-- user_role init
INSERT INTO public.user_role(user_id, role_id)
VALUES (1, 1);
INSERT INTO public.user_role(user_id, role_id)
VALUES (2, 1);
INSERT INTO public.user_role(user_id, role_id)
VALUES (3, 1);

-- folders_movies init
INSERT INTO public.folders_movies(id, category, description, name, privacy, user_id)
VALUES (1, 'VIEWED_MOVIES', '1 test', 'folder1', 'PUBLIC', 1);
INSERT INTO public.folders_movies(id, category, description, name, privacy, user_id)
VALUES (2, 'WAITING_MOVIES', '2 test', 'folder2', 'PUBLIC', 1);
INSERT INTO public.folders_movies(id, category, description, name, privacy, user_id)
VALUES (3, 'FAVORITE_MOVIES', '3 test', 'folder3', 'PUBLIC', 1);
INSERT INTO public.folders_movies(id, category, description, name, privacy, user_id)
VALUES (4, 'VIEWED_MOVIES', '4 test', 'folder4', 'PUBLIC', 2);
INSERT INTO public.folders_movies(id, category, description, name, privacy, user_id)
VALUES (5, 'WAITING_MOVIES', '5 test', 'folder5', 'PUBLIC', 3);

-- movies init
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (1, 'Slovakia', '1938-05-08', '1 test', 'PARENTAL_GUIDANCE_SUGGESTED', 'Иезавель', 'Jezebel', 'SIXTEEN_PLUS', 101);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (2, 'Albania', '1935-09-26', '2 test', 'PARENTS_STRONGLY_CAUTIONED', '47 ронинов', '47 Ronin', 'TWELVE_PLUS', 102);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (3, 'Venezuela', '1925-01-24', '3 test', 'PARENTAL_GUIDANCE_SUGGESTED', 'Исход', 'Exodus', 'SIX_PLUS', 103);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (4, 'Bosnia and Herzegovina', '2004-06-15', '4 test', 'PARENTAL_GUIDANCE_SUGGESTED', 'Братья Карамазовы', 'The Brothers Karamazov', 'ZERO_PLUS', 104);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (5, 'Guatemala', '2000-01-20', '5 test', 'NO_ONE_SEVENTEEN_AND_UNDER_ADMITTED', 'Три лица Евы', 'The Three Faces of Eve', 'EIGHTEEN_PLUS', 105);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (6, 'Pakistan', '1926-02-28', '6 test', 'PARENTS_STRONGLY_CAUTIONED', 'Человек в сером фланелевом костюме', 'The Man in the Gray Flannel Suit', 'TWELVE_PLUS', 106);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (7, 'French Guiana', '2000-07-30', '7 test', 'GENERAL_AUDIENCES', 'Левая рука Бога', 'The Left Hand of God', 'SIXTEEN_PLUS', 107);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (8, 'Guadeloupe', '1916-06-30', '8 test', 'PARENTS_STRONGLY_CAUTIONED', 'Весь город говорит', 'The Talk of the Town', 'SIXTEEN_PLUS', 108);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (9, 'Honduras', '1985-08-02', '9 test', 'GENERAL_AUDIENCES', 'Воровское шоссе', 'Thieves Highway', 'EIGHTEEN_PLUS', 109);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (10, 'Niue', '2012-12-24', '10 test', 'GENERAL_AUDIENCES', 'Бумеранг!', 'Boomerang', 'ZERO_PLUS', 110);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (11, 'Kyrgyzstan', '1922-01-28', '11 test', 'NO_ONE_SEVENTEEN_AND_UNDER_ADMITTED', 'Крик совы', 'The Cry of the Owl', 'SIX_PLUS', 111);

-- -- genres init
INSERT INTO public.genres (id, name)
VALUES (1, 'Драма');
INSERT INTO public.genres (id, name)
VALUES (2, 'Триллер');
INSERT INTO public.genres (id, name)
VALUES (3, 'Ужасы');
INSERT INTO public.genres (id, name)
VALUES (4, 'Фантастика');
INSERT INTO public.genres (id, name)
VALUES (5, 'Боевик');
INSERT INTO public.genres (id, name)
VALUES (6, 'Фэнтези');
INSERT INTO public.genres (id, name)
VALUES (7, 'Комедия');
INSERT INTO public.genres (id, name)
VALUES (8, 'Мелодрама');
INSERT INTO public.genres (id, name)
VALUES (9, 'Детектив');
INSERT INTO public.genres (id, name)
VALUES (10, 'Приключения');
INSERT INTO public.genres (id, name)
VALUES (11, 'Документальное');

-- professions init
INSERT INTO public.professions (id, name)
VALUES (1, 'режиссер');
INSERT INTO public.professions (id, name)
VALUES (2, 'редактор');
INSERT INTO public.professions (id, name)
VALUES (3, 'писатель');
INSERT INTO public.professions (id, name)
VALUES (4, 'актер');

--persons init
INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (1, '2022-06-21' , 'test1Name', 166, 'test1LastName', 'test1', 'test1OrigLastName', 'test1origName', 'test1PhotoUrl');
INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (2, '2022-06-22' , 'test2Name', 177, 'test2LastName', 'test1', 'test2OrigLastName', 'test2origName', 'test2PhotoUrl');
INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (3, '2022-06-23' , 'test3Name', 184, 'test3LastName', 'test1', 'test3OrigLastName', 'test3origName', 'test3PhotoUrl');
INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (4, '2022-06-24' , 'test4Name', 166, 'test4LastName', 'test1', 'test4OrigLastName', 'test4origName', 'test4PhotoUrl');
INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (5, '2022-06-25' , 'test5Name', 178, 'test5LastName', 'test1', 'test5OrigLastName', 'test5origName', 'test5PhotoUrl');

--movie_person init
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (1, 1, 1, 'role1', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (1, 2, 2, 'role2', 'MINOR_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (1, 3, 3, 'role3', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (2, 4, 1, 'role4', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (2, 5, 4, 'role5', 'MINOR_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (2, 1, 4, 'role6', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (3, 2, 1, 'role7', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (3, 3, 2, 'role8', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (3, 4, 3, 'role9', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (4, 5, 2, 'role10', 'MINOR_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (4, 1, 2, 'role11', 'MINOR_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (4, 2, 1, 'role12', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (5, 3, 4, 'role13', 'MINOR_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (5, 4, 1, 'role14', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (5, 5, 2, 'role15', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (6, 1, 1, 'role16', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (6, 2, 4, 'role17', 'MINOR_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (6, 3, 3, 'role18', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (7, 4, 2, 'role19', 'MINOR_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (7, 5, 1, 'role20', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (7, 1, 4, 'role21', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (8, 2, 2, 'role22', 'MINOR_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (8, 3, 4, 'role23', 'MINOR_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (8, 4, 1, 'role24', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (9, 5, 1, 'role25', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (9, 1, 4, 'role26', 'MINOR_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (9, 2, 2, 'role27', 'MINOR_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (10, 3, 1, 'role28', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (10, 4, 4, 'role29', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (10, 5, 3, 'role30', 'MINOR_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (11, 1, 1, 'role31', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (11, 2, 3, 'role32', 'MAIN_CHARACTER');
INSERT INTO public.movie_person (movie_id, person_id, profession_id, name_role, type_person)
VALUES (11, 3, 4, 'role33', 'MINOR_CHARACTER');

-- movie_genre init
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (1, 3);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (1, 1);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (1, 4);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (2, 7);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (2, 8);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (2, 9);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (3, 1);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (3, 2);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (3, 3);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (4, 4);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (4, 5);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (4, 6);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (5, 7);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (5, 8);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (5, 9);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (6, 10);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (6, 11);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (6, 5);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (7, 10);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (7, 4);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (7, 9);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (8, 7);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (8, 8);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (8, 5);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (9, 6);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (9, 4);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (9, 2);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (10, 7);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (10, 10);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (10, 11);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (11, 8);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (11, 6);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (11, 7);

-- folders_movies_to_movies init
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (1, 1);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (1, 4);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (1, 7);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (1, 9);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (2, 2);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (2, 3);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (2, 5);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (2, 6);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (2, 8);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (2, 10);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (2, 11);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (3, 1);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (3, 2);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (3, 3);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (3, 4);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (3, 5);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (3, 6);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (3, 7);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (3, 8);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (3, 9);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (3, 10);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (3, 11);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (4, 1);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (4, 3);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (4, 6);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (4, 7);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (4, 8);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (4, 10);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (4, 11);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (5, 1);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (5, 2);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (5, 3);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (5, 5);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (5, 6);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (5, 8);
INSERT INTO public.folders_movies_to_movies (folders_id, movie_id)
VALUES (5, 9);

-- score init
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (2, 6, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (3, 7, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (4, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (5, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (6, 9, 6, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (7, 7, 7, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (8, 8, 8, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (9, 4, 9, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (10, 1, 10, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (11, 3, 11, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (12, 7, 1, 2);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (13, 9, 2, 2);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (14, 8, 3, 2);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (15, 7, 4, 2);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (16, 6, 5, 2);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (17, 7, 6, 2);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (18, 1, 7, 2);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (19, 9, 8, 2);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (20, 7, 9, 2);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (21, 9, 10, 2);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (22, 3, 11, 2);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (23, 10, 1, 3);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (24, 4, 2, 3);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (25, 4, 3, 3);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (26, 5, 4, 3);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (27, 8, 5, 3);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (28, 7, 6, 3);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (29, 8, 7, 3);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (30, 9, 8, 3);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (31, 8, 9, 3);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (32, 5, 10, 3);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (33, 4, 11, 3);