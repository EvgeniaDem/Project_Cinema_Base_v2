delete from public.content;
delete from public.score;
delete from public.movies;
delete from public.collections;
delete from public.persons;
delete from public.user_role;
delete from public.roles;
delete from public.users;

INSERT INTO users(id, avatar_url, birthday, email, first_name, last_name, password)
VALUES (100, 'url', '2022-08-14', 'admin@mail.ru', 'Имя1', 'Фамилия1', '$2a$11$Ig/7qJn7s0gllAzuvFU9vuF.FBUJKiJtzJc4xJmlnUcXklbo1QVO.');

INSERT INTO roles(id, name)
VALUES (100, 'ADMIN');

INSERT INTO user_role(user_id, role_id)
VALUES (100, 100);

--Movies init
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, origin_name, rars, time)
VALUES (101, 'Rus', '2022-08-14', '1 test movie', 1, 'test1movie', '11', 1, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, origin_name, rars, time)
VALUES (102, 'Rus', '2022-08-15', '2 test movie', 2, 'test2movie', '22', 2, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, origin_name, rars, time)
VALUES (103, 'Eng', '2022-08-16', '3 test movie', 3, 'test3movie', '33', 3, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, origin_name, rars, time)
VALUES (104, 'Eng', '2022-08-15', '4 test movie', 4, 'test4movie', '44', 4, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, origin_name, rars, time)
VALUES (105, 'Gen', '2022-08-15', '5 test movie', 5, 'test5movie', '55', 5, 100);

-- Content init
INSERT INTO public.content (id, content_url, type, movie_id)
VALUES (101, '1 content', 'MOVIES', 101);
INSERT INTO public.content (id, content_url, type, movie_id)
VALUES (102, '2 content', 'MOVIES', 102);
INSERT INTO public.content (id, content_url, type, movie_id)
VALUES (103, '3 content', 'SERIALS', 103);
INSERT INTO public.content (id, content_url, type, movie_id)
VALUES (104, '4 content', 'MOVIES', 104);
INSERT INTO public.content (id, content_url, type, movie_id)
VALUES (105, '5 content', 'SERIALS', 105);

--Collection init

INSERT INTO public.collections (id, enable, name, preview_url)
VALUES (101, true, 'test1 collection', 'preview url test 1');
INSERT INTO public.collections (id, enable, name, preview_url)
VALUES (102, true, 'test2 collection', 'preview url test 2');
INSERT INTO public.collections (id, enable, name, preview_url)
VALUES (103, true, 'test3 collection', 'preview url test 3');
INSERT INTO public.collections (id, enable, name, preview_url)
VALUES (104, true, 'test4 collection', 'preview url test 4');
INSERT INTO public.collections (id, enable, name, preview_url)
VALUES (105, true, 'test5 collection', 'preview url test 5');

--Person init

INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (101, '2022-06-26 12:14:01.000000' , 'test1Name', 111, 'test1LastName', 'test', 'test1OrigLastName', 'test1origName', 'test1PhotoUrl');
INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (102, '2022-06-26 12:14:01.000000' , 'test2Name', 222, 'test2LastName', 'test', 'test2OrigLastName', 'test2origName', 'test2PhotoUrl');
INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (103, '2022-06-26 12:14:01.000000' , 'test3Name', 333, 'test3LastName', 'test', 'test3OrigLastName', 'test3origName', 'test3PhotoUrl');
INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (104, '2022-06-26 12:14:01.000000' , 'test4Name', 444, 'test4LastName', 'test', 'test4OrigLastName', 'test4origName', 'test4PhotoUrl');
INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (105, '2022-06-26 12:14:01.000000' , 'test5Name', 555, 'test5LastName', 'test', 'test5OrigLastName', 'test5origName', 'test5PhotoUrl');

--Score

insert into public.score (id, score, movie_id, user_id)
values (101, 5, 101, null);
insert into public.score (id, score, movie_id, user_id)
values (102, 3, 102, null);
insert into public.score (id, score, movie_id, user_id)
values (103, 1, 103, null);
insert into public.score (id, score, movie_id, user_id)
values (104, 5, 104, null);
insert into public.score (id, score, movie_id, user_id)
values (105, 6, 105, null);
insert into public.score (id, score, movie_id, user_id)
values (106, 2, 101, null);
insert into public.score (id, score, movie_id, user_id)
values (107, 4, 102, null);
insert into public.score (id, score, movie_id, user_id)
values (108, 7, 103, null);
insert into public.score (id, score, movie_id, user_id)
values (109, 1, 104, null);
insert into public.score (id, score, movie_id, user_id)
values (110, 4, 105, null);
insert into public.score (id, score, movie_id, user_id)
values (111, 2, 101, null);
insert into public.score (id, score, movie_id, user_id)
values (112, 4, 102, null);
insert into public.score (id, score, movie_id, user_id)
values (113, 1, 103, null);
insert into public.score (id, score, movie_id, user_id)
values (114, 6, 104, null);
insert into public.score (id, score, movie_id, user_id)
values (115, 8, 105, null);
insert into public.score (id, score, movie_id, user_id)
values (116, 4, 103, null);
insert into public.score (id, score, movie_id, user_id)
values (117, 7, 105, null);
insert into public.score (id, score, movie_id, user_id)
values (118, 9, 102, null);

