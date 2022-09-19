delete from public.content;
delete from public.movie_genre;
delete from public.movies;
delete from public.genres;

--Movies init
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (1, 'Rus', '2022-08-14', '1 test', 1, '1111', '11', 1, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (2, 'Rus', '2022-08-15', '2 test', 2, '1222', '22', 2, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (3, 'Eng', '2022-08-16', '3 test', 3, '3331', '33', 3, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (4, 'Eng', '2022-08-14', '4 test', 4, '4444', '44', 4, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (5, 'Gen', '2022-08-15', '5 test', 5, '5555', '55', 5, 100);

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
VALUES (6, '1 content frame', 'FRAME', 1);
INSERT INTO public.content (id, content_url, type, movie_id)
VALUES (7, '4 content frame', 'FRAME', 4);

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



