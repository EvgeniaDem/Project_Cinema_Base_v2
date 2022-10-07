delete from score;
delete from rating_comment;
delete from comments;
delete from news;
delete from user_role;
delete from roles;
delete from folders_movies_to_movies;
delete from folders_movies;
delete from users;

-- users init
INSERT INTO users(id, avatar_url, birthday, email, first_name, last_name, login, password)
VALUES (1, 'url', '2022-08-14', 'user@mail.ru', '1', '1', '1', '$2a$12$gxN6QptPxHp.ESn01yg60.OQTuVXCPuixlKtRJwtgN8bQwGLgwH9e');

INSERT INTO users(id, avatar_url, birthday, email, first_name, last_name, login, password)
VALUES (2, 'url', '2022-08-14', 'user2@mail.ru', '1', '1', '12', '$2a$12$gxN6QptPxHp.ESn01yg60.OQTuVXCPuixlKtRJwtgN8bQwGLgwH9e');

INSERT INTO roles(id, name)
VALUES (100, 'USER');

INSERT INTO user_role(user_id, role_id)
VALUES (1, 100);

-- news init
INSERT INTO news(id, rubric, date, title, html_body, user_id)
VALUES (100, 'NEWS', '2022-08-03', 'db test title 01', 'nytipobody', 1);

INSERT INTO news(id, rubric, date, title, html_body, user_id)
VALUES (200, 'NEWS', '2022-08-03', 'db test title 02', 'nytipobody 2', 2);

-- comment init
INSERT INTO comments(id, date, message, news_id, user_id)
VALUES (100, '2022-08-20 03:07:04.000000', 'test comment 01', 100, 1);

insert into comments(id, date, message, news_id, user_id, level, parent_id)
values (200, '2022-08-20 03:07:04.000000', 'test comment 02', 100, 1, 1, 1);

INSERT INTO comments(id, date, message, news_id, user_id)
VALUES (300, '2022-08-20 03:07:04.000000', 'test comment 03', 200, 1);

INSERT INTO rating_comment(id, rating, comment_id, user_id)
VALUES (100, 1, 100, 2);

INSERT INTO rating_comment(id, rating, comment_id, user_id)
VALUES (200, 1, 100, 2);

INSERT INTO rating_comment(id, rating, comment_id, user_id)
VALUES (300, 1, 200, 2);

INSERT INTO rating_comment(id, rating, comment_id, user_id)
VALUES (400, 1, 300, 2);

INSERT INTO rating_comment(id, rating, comment_id, user_id)
VALUES (500, 1, 300, 1);