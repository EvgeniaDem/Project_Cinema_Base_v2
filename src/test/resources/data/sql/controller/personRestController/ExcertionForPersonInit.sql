delete from public.excertion;
delete from public.persons;
delete from public.movies;
delete from public.user_role;
delete from public.roles;
delete from public.users;

INSERT INTO users(id, avatar_url, birthday, email, first_name, last_name, login, password)
VALUES (1, 'url', '2022-08-14', 'user1@mail.ru', 'Имя1', 'Фамилия1', 'login1', '$2a$12$/FIhv2k1jeNx5YCr6bZLlujKpN5V8V3j7qD16WtMC9Ov/tVhyjUIW');

INSERT INTO roles(id, name)
VALUES (1, 'USER');

INSERT INTO user_role(user_id, role_id)
VALUES (1, 1);

INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (1, 'Slovakia', '1938-05-08', '1 test', 'PARENTAL_GUIDANCE_SUGGESTED', 'Иезавель', 'Jezebel', 'SIXTEEN_PLUS', 101);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (2, 'Albania', '1935-09-26', '2 test', 'PARENTS_STRONGLY_CAUTIONED', '47 ронинов', '47 Ronin', 'TWELVE_PLUS', 102);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (3, 'Venezuela', '1925-01-24', '3 test', 'PARENTAL_GUIDANCE_SUGGESTED', 'Исход', 'Exodus', 'SIX_PLUS', 103);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (4, 'Bosnia and Herzegovina', '2004-06-15', '4 test', 'PARENTAL_GUIDANCE_SUGGESTED', 'Братья Карамазовы', 'The Brothers Karamazov', 'ZERO_PLUS', 104);

INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (1, '2022-06-21' , 'test1Name', 166, 'test1LastName', 'test1', 'test1OrigLastName', 'test1origName', 'test1PhotoUrl');
INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (2, '2022-06-22' , 'test2Name', 177, 'test2LastName', 'test2', 'test2OrigLastName', 'test2origName', 'test2PhotoUrl');
INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (3, '2022-06-23' , 'test3Name', 184, 'test3LastName', 'test3', 'test3OrigLastName', 'test3origName', 'test3PhotoUrl');
INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (4, '2022-06-24' , 'test4Name', 166, 'test4LastName', 'test4', 'test4OrigLastName', 'test4origName', 'test4PhotoUrl');

INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (203, 'Test1', 1, null);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (204, 'Test2', null, 1);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (205, 'Test4', null, 2);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (206, 'Test6', null, 3);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (207, 'Test8', null, 4);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (208, 'Test10', null, 1);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (209, 'Test12', null, 1);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (210, 'Test14', null, 1);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (211, 'Test16', null, 1);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (212, 'Test18', null, 1);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (213, 'Test20', null, 1);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (214, 'Test3', 2, null);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (215, 'Test5', 3, null);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (216, 'Test7', 4, null);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (217, 'Test9', 1, null);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (218, 'Test11', 1, null);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (219, 'Test13', 1, null);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (220, 'Test15', 1, null);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (221, 'Test17', 1, null);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (222, 'Test19', 1, null);