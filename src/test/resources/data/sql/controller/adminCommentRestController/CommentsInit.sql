delete from public.user_role;
delete from public.roles;
delete from public.users;
delete from public.comments;
delete from public.news;

INSERT INTO users(id, avatar_url, birthday, email, first_name, last_name, login, password)
VALUES (1, 'url', '2022-08-14', 'admin@mail.ru', 'Имя1', 'Фамилия1', 'login1', '$2a$11$Ig/7qJn7s0gllAzuvFU9vuF.FBUJKiJtzJc4xJmlnUcXklbo1QVO.');

INSERT INTO roles(id, name)
VALUES (1, 'ADMIN');

INSERT INTO user_role(user_id, role_id)
VALUES (1, 1);

INSERT INTO news (id, rubric, date, title, html_body, user_id)
VALUES (1, 'NEWS', '2022-10-03', 'title1', 'html_body1', 1);

INSERT INTO comments (id, date, news_id, user_id, level, message, parent_id)
VALUES (1, '2022-10-03 18:18:02.000000', 1, 1, 101, 'test1', 101);