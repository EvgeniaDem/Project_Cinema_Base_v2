delete from rating_comment;
delete from news_movie;
delete from comments;
delete from news;
delete from users;
delete from movies;


INSERT INTO users (id, avatar_url, birthday, email, first_name, last_name, login, password)
VALUES (100, null, '2022-08-14', '1', '1', '1', '1', '1'),
       (200, null, '2022-07-14', '2', '2', '2', '2', '2'),
       (300, null, '2022-06-14', '3', '3', '3', '3', '3');

INSERT INTO news(id, rubric, date, title, html_body, user_id)
VALUES (100, 'NEWS', '2022-08-03', 'db test title 01', 'nytipobody', 100);
INSERT INTO news(id, rubric, date, title, html_body, user_id)
VALUES (200, 'NEWS', '2022-08-04', 'db test title 02', 'nytipobody', 200);
INSERT INTO news(id, rubric, date, title, html_body, user_id)
VALUES (300, 'TESTS', '2022-08-05', 'db test title 03', 'nytipobody', 300);

INSERT INTO comments(id, date, message, news_id, user_id, level, parent_id)
VALUES (100, '2022-08-20 03:07:04.000000', 'test comment 01', 100, 100, 10, 20),
       (200, '2022-08-20 03:07:04.000000', 'test comment 02', 100, 200, 11, 30);

INSERT INTO rating_comment(id, rating, comment_id, user_id)
VALUES (1, 0, 100, 200);

insert into movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (100, 'USA', '2020-09-19', 'description1', 'GENERAL_AUDIENCES', 'F&F', 'Fast And Furious', 'ZERO_PLUS', 120),
       (200, 'French', '2001-10-15', 'description2', 'GENERAL_AUDIENCES', 'Hobbit', 'Hobbit: The Smoug Eagle', 'ZERO_PLUS', 210),
       (300, 'Australia', '2010-02-14', 'description3', 'GENERAL_AUDIENCES', 'Fury', 'Fury', 'ZERO_PLUS', 100);

insert into news_movie (news_id, movie_id)
VALUES (100, 100),
       (200, 200),
       (300, 300),
       (100, 200),
       (300, 200);

