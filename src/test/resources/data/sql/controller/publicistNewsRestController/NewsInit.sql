delete from public.news;
delete from news;
delete from folders_movies_to_movies;
delete from folders_movies;

delete from user_role;
delete from roles;
delete from users;

INSERT INTO users(id, avatar_url, birthday, email, first_name, last_name, login, password)
VALUES (300, 'url', '2022-08-14', 'publicist@mail.ru', 'Имя1', 'Фамилия1', 'login_1', '$2a$12$d0JwWidrGyG6UyRVTJ8OOeCdy6vdvrMgjxhlLFjI.0dVFB85.Gw0y');

INSERT INTO roles(id, name)
VALUES (300, 'PUBLICIST');

INSERT INTO user_role(user_id, role_id)
VALUES (300, 300);

INSERT INTO news(id, rubric, date, title, html_body, user_id)
VALUES (100, 'NEWS', '2022-08-03', 'db test title 01', 'nytipobody', null);
INSERT INTO news(id, rubric, date, title, html_body, user_id)
VALUES (200, 'NEWS', '2022-08-04', 'db test title 02', 'nytipobody', null);
INSERT INTO public.news(id, rubric, date, title, html_body, user_id)
VALUES (300, 'TESTS', '2022-08-05', 'db test title 03', 'nytipobody', null);


