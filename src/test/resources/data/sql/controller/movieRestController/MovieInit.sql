delete from public.content;
delete from public.score;
delete from public.movie_genre;
delete from news_movie;
delete from comments;
delete from news;
delete from public.movies;
delete from public.genres;
delete from public.users;


--Movies init
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (1, 'Rus', '2022-08-14', '1 test', 1, '1', '11', 1, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (2, 'Rus', '2022-08-15', '2 test', 2, '2', '22', 2, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (3, 'Eng', '2022-08-16', '3 test', 3, '3', '33', 3, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (4, 'Eng', '2022-08-15', '4 test', 4, '4', '44', 4, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (5, 'Gen', '2022-08-15', '5 test', 5, '5', '55', 5, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (999, 'Gen', current_date+1, 'release test', 5, 'release', 'release', 5, 100); --Movie for release test


-- Content init
INSERT INTO public.content (id, content_url, type, movie_id)
VALUES (1, '1 content', 'MOVIES', 1);
INSERT INTO public.content (id, content_url, type, movie_id)
VALUES (2, '2 content', 'MOVIES', 2);
INSERT INTO public.content (id, content_url, type, movie_id)
VALUES (3, '3 content', 'SERIALS', 3);
INSERT INTO public.content (id, content_url, type, movie_id)
VALUES (4, '4 content', 'MOVIES', 4);
INSERT INTO public.content (id, content_url, type, movie_id)
VALUES (5, '5 content', 'SERIALS', 5);
INSERT INTO public.content (id, content_url, type, movie_id)
VALUES (6, '1 content PREVIEW', 'PREVIEW', 1);
INSERT INTO public.content (id, content_url, type, movie_id)
VALUES (7, '4 content PREVIEW', 'PREVIEW', 999);

-- Genres init
INSERT INTO public.genres (id, name)
VALUES (1, 'genre 1');
INSERT INTO public.genres (id, name)
VALUES (2, 'genre 2');
INSERT INTO public.genres (id, name)
VALUES (3, 'genre 3');

-- movie_genre init
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (1, 1);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (2, 1);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (3, 1);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (4, 1);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (5, 1);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (2, 2);
INSERT INTO public.movie_genre (movie_id, genre_id)
VALUES (3, 3);

-- users init
INSERT INTO public.users (id, avatar_url, birthday, email, first_name, last_name, password)
VALUES (1, null, '2022-08-14', '1', '1', '1', '1'),
       (2, null, '2022-08-24', '2', '2', '2', '2'),
       (3, null, '2022-08-10', '3', '3', '3', '3');

-- score init
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (2, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (3, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (6, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (11, 2, 4, 1);

INSERT INTO news(id, rubric, date, title, html_body, user_id)
VALUES (100, 'NEWS', '2022-08-03', 'db test title 01', 'nytipobody', 1);
INSERT INTO news(id, rubric, date, title, html_body, user_id)
VALUES (200, 'NEWS', '2022-08-04', 'db test title 02', 'nytipobody', 2);
INSERT INTO news(id, rubric, date, title, html_body, user_id)
VALUES (300, 'TESTS', '2022-08-05', 'db test title 03', 'nytipobody', 3);

INSERT INTO comments(id, date, message, news_id, user_id, level, parent_id)
VALUES (100, '2022-08-20 03:07:04.000000', 'test comment 01', 100, 1, 10, 20),
       (200, '2022-08-20 03:07:04.000000', 'test comment 02', 100, 2, 11, 30);

insert into news_movie (news_id, movie_id)
VALUES (100, 1),
       (200, 2),
       (300, 3),
       (100, 2),
       (300, 2);
