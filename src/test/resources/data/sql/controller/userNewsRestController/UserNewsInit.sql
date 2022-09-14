
-- users init
insert into users(id, avatar_url, birthday, email, first_name, last_name, password)
values (100, 'url', '2022-08-14', 'user@mail.ru', '1', '1', '$2a$12$P9SthnXDDRjoBRxvJ90Pa.YikT9.iUp4jphemPEScNGPyLJMJ4jHC');

insert into roles(id, name)
values (100, 'USER');

insert into user_role(user_id, role_id)
values (100, 100);

-- news init
insert into news(id, rubric, date, title, html_body, user_id)
values (100, 'NEWS', '2022-08-03', 'db test title 01', 'nytipobody', 100);

-- comment init
insert into comments(id, date, text, news_id, user_id)
values (100, '2022-08-20 03:07:04.000000', 'test comment 01', 100, 100);

-- folders_movies init
insert into folders_movies(id, category, description, name, privacy, user_id)
values (100, 'CUSTOM', 'test description', 'some test name', 'PUBLIC', 100);