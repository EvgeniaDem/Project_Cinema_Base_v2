delete from public.collections_movies;
delete from public.folders_movies_to_movies;
delete from public.folders_movies;
delete from public.movies;
delete from public.collections;
delete from public.users;



INSERT into public.users(id, avatar_url, birthday, email, first_name, last_name, password)
values (1, 'test', '2022-08-04', 'test@mail.ru', 'test_firstname', 'test_lastname', '$2y$10$9eccPudsnqsR3/XOgzugreDmY5svycvzgxSrSXZHge/oTe.jlAjeC'  );
INSERT into public.folders_movies(id, category, description, name, privacy, user_id)
values (1, 'FAVORITE_MOVIES', 'movie test', 'test', 'PUBLIC', 1);
insert into public.movies(id, countries, date_release, description, mpaa, name, rars, time, origin_name)
values (1, 'test_countries', '2022-08-09', 'ACTION', 56, 'DOOM', 1 , 9600, 'doom');
insert into public.movies(id, countries, date_release, description, mpaa, name, rars, time, origin_name)
values (2, 'test_countries', '2022-08-09', 'ACTION', 56, 'wood', 1 , 9600, 'wood');
insert into public.movies(id, countries, date_release, description, mpaa, name, rars, time, origin_name)
values (3, 'test_countries', '2022-08-09', 'ACTION', 56, 'Boom', 1 , 8600, 'boom');
insert into public.movies(id, countries, date_release, description, mpaa, name, rars, time, origin_name)
values (4, 'test_countries', '2022-08-09', 'ACTION', 56, 'TEST1', 1 , 8600, 'boom');
insert into public.movies(id, countries, date_release, description, mpaa, name, rars, time, origin_name)
values (5, 'test_countries', '2022-08-09', 'ACTION', 56, 'TEST2', 1 , 8600, 'boom');
insert into public.movies(id, countries, date_release, description, mpaa, name, rars, time, origin_name)
values (6, 'test_countries', '2022-08-09', 'ACTION', 56, 'TEST3', 1 , 8600, 'boom');
INSERT INTO public.collections(id, enable, name, collection_type, collection_url)
values (1, true, 'myCollectionTest', 'MOVIES' , 'test_URL');
insert into public.folders_movies_to_movies(folders_id , movie_id)
values (1, 1);
insert into public.folders_movies_to_movies(folders_id , movie_id)
values (1, 2);
insert into public.folders_movies_to_movies(folders_id , movie_id)
values (1, 3);
INSERT INTO public.collections_movies(movies_id, collections_id)
values (1, 1);
INSERT INTO public.collections_movies(movies_id, collections_id)
values (2, 1);
