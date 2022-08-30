INSERT INTO users(id, avatar_url, birthday, email, first_name, last_name, password)
VALUES (100, 'url', '2022-08-14', 'publicist@mail.ru', 'Имя1', 'Фамилия1', '$2a$12$d0JwWidrGyG6UyRVTJ8OOeCdy6vdvrMgjxhlLFjI.0dVFB85.Gw0y');

INSERT INTO roles(id, name)
VALUES (100, 'PUBLICIST');

INSERT INTO user_role(user_id, role_id)
VALUES (100, 100);

INSERT INTO news(id, rubric, date, title, html_body, user_id)
VALUES (100, 'NEWS', '2022-08-03', 'db test title 01', 'nytipobody', null);
INSERT INTO news(id, rubric, date, title, html_body, user_id)
VALUES (101, 'NEWS', '2022-08-04', 'db test title 02', 'nytipobody', null);
INSERT INTO public.news(id, rubric, date, title, html_body, user_id)
VALUES (102, 'TESTS', '2022-08-05', 'db test title 03', 'nytipobody', null);

