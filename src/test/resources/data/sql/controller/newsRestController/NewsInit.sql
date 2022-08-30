INSERT INTO users (id, avatar_url, birthday, email, first_name, last_name, password)
VALUES (100, null, '2022-08-14', '1', '1', '1', '1');
INSERT INTO users (id, avatar_url, birthday, email, first_name, last_name, password)
VALUES (101, null, '2022-07-14', '2', '2', '2', '2');
INSERT INTO users (id, avatar_url, birthday, email, first_name, last_name, password)
VALUES (102, null, '2022-06-14', '3', '3', '3', '3');

INSERT INTO news(id, rubric, date, title, html_body, user_id)
VALUES (100, 'NEWS', '2022-08-03', 'db test title 01', 'nytipobody', 100);
INSERT INTO news(id, rubric, date, title, html_body, user_id)
VALUES (101, 'NEWS', '2022-08-04', 'db test title 02', 'nytipobody', 101);
INSERT INTO news(id, rubric, date, title, html_body, user_id)
VALUES (102, 'TESTS', '2022-08-05', 'db test title 03', 'nytipobody', 102);

INSERT INTO comments(id, date, text, news_id, user_id)
VALUES (100, '2022-08-20 03:07:04.000000', 'test comment 01', 100, 100);
