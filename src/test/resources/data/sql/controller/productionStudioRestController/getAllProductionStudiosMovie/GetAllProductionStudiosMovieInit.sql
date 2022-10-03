delete from public.production_studios_movies;
delete from public.production_studios;
delete from public.studios_performance;
delete from public.user_role;
delete from public.movies;
delete from public.roles;
delete from public.users;

-- users init
INSERT INTO public.users (id, avatar_url, birthday, email, first_name, last_name, login, password)
VALUES (1, null, '2022-08-14', 'user1@mail.ru', 'user1', 'userovich1', 'login1', '$2a$12$/FIhv2k1jeNx5YCr6bZLlujKpN5V8V3j7qD16WtMC9Ov/tVhyjUIW'); -- password == 101

-- roles init
INSERT INTO public.roles(id, name)
VALUES (1, 'USER');

-- user_role init
INSERT INTO public.user_role(user_id, role_id)
VALUES (1, 1);

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

-- studios_performance init
INSERT INTO public.studios_performance (id, name)
VALUES (1, 'montage');
INSERT INTO public.studios_performance (id, name)
VALUES (2, 'draw');
INSERT INTO public.studios_performance (id, name)
VALUES (3, 'producing');
INSERT INTO public.studios_performance (id, name)
VALUES (4, 'scenario');
INSERT INTO public.studios_performance (id, name)
VALUES (5, 'directing');

-- production_studios init
INSERT INTO public.production_studios (id, name, description, date_foundation)
VALUES (1, 'studio1', 'description1', '2022-08-14');
INSERT INTO public.production_studios (id, name, description, date_foundation)
VALUES (2, 'studio2', 'description2', '2022-08-13');
INSERT INTO public.production_studios (id, name, description, date_foundation)
VALUES (3, 'studio3', 'description3', '2022-08-12');
INSERT INTO public.production_studios (id, name, description, date_foundation)
VALUES (4, 'studio4', 'description4', '2022-08-11');
INSERT INTO public.production_studios (id, name, description, date_foundation)
VALUES (5, 'studio5', 'description5', '2022-08-15');
INSERT INTO public.production_studios (id, name, description, date_foundation)
VALUES (6, 'studio6', 'description6', '2022-08-16');
INSERT INTO public.production_studios (id, name, description, date_foundation)
VALUES (7, 'studio7', 'description7', '2022-08-17');
INSERT INTO public.production_studios (id, name, description, date_foundation)
VALUES (8, 'studio8', 'description8', '2022-08-18');
INSERT INTO public.production_studios (id, name, description, date_foundation)
VALUES (9, 'studio9', 'description9', '2022-08-19');
INSERT INTO public.production_studios (id, name, description, date_foundation)
VALUES (10, 'studio10', 'description10', '2022-08-20');

-- production_studios_movies init
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (1, 1, 1, 1);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (2, 1, 2, 2);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (3, 1, 3, 3);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (4, 1, 4, 4);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (5, 1, 5, 5);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (6, 1, 6, 5);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (7, 1, 7, 4);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (8, 1, 8, 3);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (9, 1, 9, 2);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (10, 1, 10, 1);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (11, 4, 1, 5);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (12, 4, 2, 3);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (13, 3, 3, 2);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (14, 4, 4, 4);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (15, 5, 5, 5);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (16, 6, 6, 1);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (17, 3, 7, 4);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (18, 6, 8, 3);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (19, 7, 9, 2);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (20, 7, 10, 2);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (21, 9, 1, 4);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (22, 8, 2, 5);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (23, 9, 3, 3);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (24, 8, 4, 1);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (25, 9, 5, 2);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (26, 9, 6, 3);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (27, 9, 7, 4);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (28, 10, 8, 2);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (29, 10, 9, 4);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (30, 10, 10, 3);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (31, 11, 3, 4);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (32, 11, 6, 3);
insert into public.production_studios_movies (id, movie_id, studio_id, performance_id)
VALUES (33, 11, 2, 1);