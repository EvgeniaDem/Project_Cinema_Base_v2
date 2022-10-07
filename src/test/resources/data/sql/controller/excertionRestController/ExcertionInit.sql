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

INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (1, '2022-06-21' , 'test1Name', 166, 'test1LastName', 'test1', 'test1OrigLastName', 'test1origName', 'test1PhotoUrl');

INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (1, 16887, 1, null);
INSERT INTO public.excertion (id, description, movie_id, person_id)
VALUES (2, 16888, null, 1);
