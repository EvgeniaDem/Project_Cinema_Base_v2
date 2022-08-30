
-- users init
INSERT INTO users(id, avatar_url, birthday, email, first_name, last_name, password)
VALUES (100, 'url', '2022-08-14', 'user@mail.ru', '1', '1', '$2a$12$d0JwWidrGyG6UyRVTJ8OOeCdy6vdvrMgjxhlLFjI.0dVFB85.Gw0y');

INSERT INTO roles(id, name)
VALUES (100, 'USER');

INSERT INTO user_role(user_id, role_id)
VALUES (100, 100);

-- news init
INSERT INTO news(id, rubric, date, title, html_body, user_id)
VALUES (100, 'NEWS', '2022-08-03', 'db test title 01', 'nytipobody', 100);

-- comment init
INSERT INTO comments(id, date, text, news_id, user_id)
VALUES (100, '2022-08-20 03:07:04.000000', 'test comment 01', 100, 100);