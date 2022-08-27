delete from public.content;
delete from public.movies;
delete from public.collections;
delete from public.persons;

--Movies init
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, origin_name, rars, time)
VALUES (1, 'Rus', '2022-08-14', '1 test movie', 1, 'test1movie', '11', 1, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, origin_name, rars, time)
VALUES (2, 'Rus', '2022-08-15', '2 test movie', 2, 'test2movie', '22', 2, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, origin_name, rars, time)
VALUES (3, 'Eng', '2022-08-16', '3 test movie', 3, 'test3movie', '33', 3, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, origin_name, rars, time)
VALUES (4, 'Eng', '2022-08-15', '4 test movie', 4, 'test4movie', '44', 4, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, origin_name, rars, time)
VALUES (5, 'Gen', '2022-08-15', '5 test movie', 5, 'test5movie', '55', 5, 100);

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

--Collection init

INSERT INTO public.collections (id, enable, name, preview_url)
VALUES (1, true, 'test1 collection', 'preview url test 1');
INSERT INTO public.collections (id, enable, name, preview_url)
VALUES (2, true, 'test2 collection', 'preview url test 2');
INSERT INTO public.collections (id, enable, name, preview_url)
VALUES (3, true, 'test3 collection', 'preview url test 3');
INSERT INTO public.collections (id, enable, name, preview_url)
VALUES (4, true, 'test4 collection', 'preview url test 4');
INSERT INTO public.collections (id, enable, name, preview_url)
VALUES (5, true, 'test5 collection', 'preview url test 5');

--Person init

INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (1, '2022-06-26 12:14:01.000000' , 'test1Name', 111, 'test1LastName', 'test', 'test1OrigLastName', 'test1origName', 'test1PhotoUrl');
INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (2, '2022-06-26 12:14:01.000000' , 'test2Name', 222, 'test2LastName', 'test', 'test2OrigLastName', 'test2origName', 'test2PhotoUrl');
INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (3, '2022-06-26 12:14:01.000000' , 'test3Name', 333, 'test3LastName', 'test', 'test3OrigLastName', 'test3origName', 'test3PhotoUrl');
INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (4, '2022-06-26 12:14:01.000000' , 'test4Name', 444, 'test4LastName', 'test', 'test4OrigLastName', 'test4origName', 'test4PhotoUrl');
INSERT INTO public.persons (id, birthday, first_name, height, last_name, place_birthday, original_last_name, original_name, photo_url)
VALUES (5, '2022-06-26 12:14:01.000000' , 'test5Name', 555, 'test5LastName', 'test', 'test5OrigLastName', 'test5origName', 'test5PhotoUrl');

