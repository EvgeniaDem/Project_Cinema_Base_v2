delete from public.user_role;
delete from public.roles;
delete from public.rating_comment;
delete from public.comments;
delete from public.news;
delete from public.users;

INSERT INTO users(id, avatar_url, birthday, email, first_name, last_name, login, password)
VALUES (1, 'url1', '2022-08-14', 'admin@mail.ru', 'Имя1', 'Фамилия1', 'login1', '$2a$11$Ig/7qJn7s0gllAzuvFU9vuF.FBUJKiJtzJc4xJmlnUcXklbo1QVO.');

INSERT INTO roles(id, name)
VALUES (1, 'ADMIN');

INSERT INTO user_role(user_id, role_id)
VALUES (1, 1);

INSERT INTO news (id, rubric, date, title, html_body, user_id)
VALUES (1, 'NEWS', '2022-10-03', 'title1', 'html_body1', 1);

INSERT INTO comments (id, date, news_id, user_id, level, message, parent_id, is_moderate)
VALUES (1, '2022-10-03 18:01:02.000000', 1, 1, 101, 'test1', 101, false);
INSERT INTO comments (id, date, news_id, user_id, level, message, parent_id, is_moderate)
VALUES (2, '2021-10-03 18:02:02.000000', 1, 1, 101, 'test2', 101, false);
INSERT INTO comments (id, date, news_id, user_id, level, message, parent_id, is_moderate)
VALUES (3, '2020-10-03 18:03:02.000000', 1, 1, 101, 'test3', 101, false);
INSERT INTO comments (id, date, news_id, user_id, level, message, parent_id, is_moderate)
VALUES (4, '2019-10-03 18:04:02.000000', 1, 1, 101, 'test4', 101, false);
INSERT INTO comments (id, date, news_id, user_id, level, message, parent_id, is_moderate)
VALUES (5, '2018-10-03 18:05:02.000000', 1, 1, 101, 'test5', 101, false);
INSERT INTO comments (id, date, news_id, user_id, level, message, parent_id, is_moderate)
VALUES (6, '2017-10-03 18:06:02.000000', 1, 1, 101, 'test6', 101, false);
INSERT INTO comments (id, date, news_id, user_id, level, message, parent_id, is_moderate)
VALUES (7, '2016-10-03 18:07:02.000000', 1, 1, 101, 'test7', 101, false);
INSERT INTO comments (id, date, news_id, user_id, level, message, parent_id, is_moderate)
VALUES (8, '2015-10-03 18:07:02.000000', 1, 1, 101, 'test8', 101, true);

INSERT INTO rating_comment (id, rating, comment_id, user_id)
VALUES (1, 1, 1, 1);
INSERT INTO rating_comment (id, rating, comment_id, user_id)
VALUES (2, 1, 1, 1);
INSERT INTO rating_comment (id, rating, comment_id, user_id)
VALUES (3, -1, 1, 1);
INSERT INTO rating_comment (id, rating, comment_id, user_id)
VALUES (4, 1, 1, 1);
INSERT INTO rating_comment (id, rating, comment_id, user_id)
VALUES (5, 1, 1, 1);
INSERT INTO rating_comment (id, rating, comment_id, user_id)
VALUES (6, 1, 2, 1);
INSERT INTO rating_comment (id, rating, comment_id, user_id)
VALUES (7, 1, 2, 1);
INSERT INTO rating_comment (id, rating, comment_id, user_id)
VALUES (8, -1, 2, 1);
INSERT INTO rating_comment (id, rating, comment_id, user_id)
VALUES (9, 1, 3, 1);
INSERT INTO rating_comment (id, rating, comment_id, user_id)
VALUES (10, -1, 3, 1);
INSERT INTO rating_comment (id, rating, comment_id, user_id)
VALUES (11, 1, 4, 1);
INSERT INTO rating_comment (id, rating, comment_id, user_id)
VALUES (12, 1, 5, 1);
INSERT INTO rating_comment (id, rating, comment_id, user_id)
VALUES (13, -1, 5, 1);
INSERT INTO rating_comment (id, rating, comment_id, user_id)
VALUES (14, 1, 5, 1);
INSERT INTO rating_comment (id, rating, comment_id, user_id)
VALUES (15, 1, 5, 1);
INSERT INTO rating_comment (id, rating, comment_id, user_id)
VALUES (16, 1, 5, 1);
INSERT INTO rating_comment (id, rating, comment_id, user_id)
VALUES (17, -1, 6, 1);
INSERT INTO rating_comment (id, rating, comment_id, user_id)
VALUES (18, -1, 6, 1);
INSERT INTO rating_comment (id, rating, comment_id, user_id)
VALUES (19, -1, 6, 1);