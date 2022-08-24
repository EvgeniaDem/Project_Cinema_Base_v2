delete from public.content;
delete from public.score;
delete from public.movie_genre;
delete from public.movies;
delete from public.genres;
delete from public.users;

--Movies init
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, origin_name, rars, time)
VALUES (1, 'Rus', '2022-08-14', '1 test', 1, '1', '11', 1, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, origin_name, rars, time)
VALUES (2, 'Rus', '2022-08-15', '2 test', 2, '2', '22', 2, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, origin_name, rars, time)
VALUES (3, 'Eng', '2022-08-16', '3 test', 3, '3', '33', 3, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, origin_name, rars, time)
VALUES (4, 'Eng', '2022-08-15', '4 test', 4, '4', '44', 4, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, origin_name, rars, time)
VALUES (5, 'Gen', '2022-08-15', '5 test', 5, '5', '55', 5, 100);
INSERT INTO public.movies (id, countries, date_release, description, mpaa, name, origin_name, rars, time)
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
VALUES (1, null, '2022-08-14', '1', '1', '1', '1');

-- score init
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (2, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (3, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (4, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (5, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (6, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (7, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (8, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (9, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (10, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (11, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (12, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (13, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (14, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (15, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (16, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (17, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (18, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (19, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (20, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (21, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (22, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (23, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (24, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (25, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (26, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (27, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (28, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (29, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (30, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (31, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (32, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (33, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (34, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (35, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (36, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (37, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (38, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (39, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (40, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (41, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (42, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (43, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (44, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (45, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (46, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (47, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (48, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (49, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (50, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (51, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (52, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (53, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (54, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (55, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (56, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (57, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (58, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (59, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (60, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (61, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (62, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (63, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (64, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (65, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (66, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (67, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (68, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (69, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (70, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (71, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (72, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (73, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (74, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (75, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (76, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (77, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (78, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (79, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (80, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (81, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (82, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (83, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (84, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (85, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (86, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (87, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (88, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (89, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (90, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (91, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (92, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (93, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (94, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (95, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (96, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (97, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (98, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (99, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (100, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (101, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (102, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (103, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (104, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (105, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (106, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (107, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (108, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (109, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (110, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (111, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (112, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (113, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (114, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (115, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (116, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (117, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (118, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (119, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (120, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (121, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (122, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (123, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (124, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (125, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (126, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (127, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (128, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (129, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (130, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (131, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (132, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (133, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (134, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (135, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (136, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (137, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (138, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (139, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (140, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (141, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (142, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (143, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (144, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (145, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (146, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (147, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (148, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (149, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (150, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (151, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (152, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (153, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (154, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (155, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (156, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (157, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (158, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (159, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (160, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (161, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (162, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (163, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (164, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (165, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (166, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (167, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (168, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (169, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (170, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (171, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (172, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (173, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (174, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (175, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (176, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (177, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (178, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (179, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (180, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (181, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (182, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (183, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (184, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (185, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (186, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (187, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (188, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (189, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (190, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (191, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (192, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (193, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (194, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (195, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (196, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (197, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (198, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (199, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (200, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (201, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (202, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (203, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (204, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (205, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (206, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (207, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (208, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (209, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (210, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (211, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (212, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (213, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (214, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (215, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (216, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (217, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (218, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (219, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (220, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (221, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (222, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (223, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (224, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (225, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (226, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (227, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (228, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (229, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (230, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (231, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (232, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (233, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (234, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (235, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (236, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (237, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (238, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (239, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (240, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (241, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (242, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (243, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (244, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (245, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (246, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (247, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (248, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (249, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (250, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (251, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (252, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (253, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (254, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (255, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (256, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (257, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (258, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (259, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (260, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (261, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (262, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (263, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (264, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (265, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (266, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (267, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (268, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (269, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (270, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (271, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (272, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (273, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (274, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (275, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (276, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (277, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (278, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (279, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (280, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (281, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (282, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (283, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (284, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (285, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (286, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (287, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (288, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (289, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (290, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (291, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (292, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (293, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (294, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (295, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (296, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (297, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (298, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (299, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (300, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (301, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (302, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (303, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (304, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (305, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (306, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (307, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (308, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (309, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (310, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (311, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (312, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (313, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (314, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (315, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (316, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (317, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (318, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (319, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (320, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (321, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (322, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (323, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (324, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (325, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (326, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (327, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (328, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (329, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (330, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (331, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (332, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (333, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (334, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (335, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (336, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (337, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (338, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (339, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (340, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (341, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (342, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (343, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (344, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (345, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (346, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (347, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (348, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (349, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (350, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (351, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (352, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (353, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (354, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (355, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (356, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (357, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (358, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (359, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (360, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (361, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (362, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (363, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (364, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (365, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (366, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (367, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (368, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (369, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (370, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (371, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (372, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (373, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (374, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (375, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (376, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (377, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (378, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (379, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (380, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (381, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (382, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (383, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (384, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (385, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (386, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (387, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (388, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (389, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (390, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (391, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (392, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (393, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (394, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (395, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (396, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (397, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (398, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (399, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (400, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (401, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (402, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (403, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (404, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (405, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (406, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (407, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (408, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (409, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (410, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (411, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (412, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (413, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (414, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (415, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (416, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (417, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (418, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (419, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (420, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (421, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (422, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (423, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (424, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (425, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (426, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (427, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (428, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (429, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (430, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (431, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (432, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (433, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (434, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (435, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (436, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (437, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (438, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (439, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (440, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (441, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (442, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (443, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (444, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (445, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (446, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (447, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (448, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (449, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (450, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (451, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (452, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (453, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (454, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (455, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (456, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (457, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (458, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (459, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (460, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (461, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (462, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (463, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (464, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (465, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (466, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (467, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (468, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (469, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (470, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (471, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (472, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (473, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (474, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (475, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (476, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (477, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (478, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (479, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (480, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (481, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (482, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (483, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (484, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (485, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (486, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (487, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (488, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (489, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (490, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (491, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (492, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (493, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (494, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (495, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (496, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (497, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (498, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (499, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (500, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (501, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (502, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (503, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (504, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (505, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (506, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (507, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (508, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (509, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (510, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (511, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (512, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (513, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (514, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (515, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (516, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (517, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (518, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (519, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (520, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (521, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (522, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (523, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (524, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (525, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (526, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (527, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (528, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (529, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (530, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (531, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (532, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (533, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (534, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (535, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (536, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (537, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (538, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (539, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (540, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (541, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (542, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (543, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (544, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (545, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (546, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (547, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (548, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (549, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (550, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (551, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (552, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (553, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (554, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (555, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (556, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (557, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (558, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (559, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (560, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (561, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (562, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (563, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (564, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (565, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (566, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (567, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (568, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (569, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (570, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (571, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (572, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (573, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (574, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (575, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (576, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (577, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (578, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (579, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (580, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (581, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (582, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (583, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (584, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (585, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (586, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (587, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (588, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (589, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (590, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (591, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (592, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (593, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (594, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (595, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (596, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (597, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (598, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (599, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (600, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (601, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (602, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (603, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (604, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (605, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (606, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (607, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (608, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (609, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (610, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (611, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (612, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (613, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (614, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (615, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (616, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (617, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (618, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (619, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (620, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (621, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (622, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (623, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (624, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (625, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (626, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (627, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (628, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (629, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (630, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (631, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (632, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (633, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (634, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (635, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (636, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (637, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (638, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (639, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (640, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (641, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (642, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (643, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (644, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (645, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (646, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (647, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (648, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (649, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (650, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (651, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (652, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (653, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (654, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (655, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (656, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (657, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (658, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (659, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (660, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (661, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (662, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (663, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (664, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (665, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (666, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (667, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (668, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (669, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (670, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (671, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (672, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (673, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (674, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (675, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (676, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (677, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (678, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (679, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (680, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (681, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (682, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (683, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (684, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (685, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (686, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (687, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (688, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (689, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (690, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (691, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (692, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (693, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (694, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (695, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (696, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (697, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (698, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (699, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (700, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (701, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (702, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (703, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (704, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (705, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (706, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (707, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (708, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (709, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (710, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (711, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (712, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (713, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (714, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (715, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (716, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (717, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (718, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (719, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (720, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (721, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (722, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (723, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (724, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (725, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (726, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (727, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (728, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (729, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (730, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (731, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (732, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (733, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (734, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (735, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (736, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (737, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (738, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (739, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (740, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (741, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (742, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (743, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (744, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (745, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (746, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (747, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (748, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (749, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (750, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (751, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (752, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (753, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (754, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (755, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (756, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (757, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (758, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (759, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (760, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (761, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (762, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (763, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (764, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (765, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (766, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (767, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (768, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (769, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (770, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (771, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (772, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (773, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (774, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (775, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (776, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (777, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (778, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (779, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (780, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (781, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (782, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (783, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (784, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (785, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (786, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (787, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (788, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (789, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (790, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (791, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (792, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (793, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (794, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (795, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (796, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (797, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (798, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (799, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (800, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (801, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (802, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (803, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (804, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (805, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (806, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (807, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (808, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (809, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (810, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (811, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (812, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (813, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (814, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (815, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (816, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (817, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (818, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (819, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (820, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (821, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (822, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (823, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (824, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (825, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (826, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (827, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (828, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (829, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (830, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (831, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (832, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (833, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (834, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (835, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (836, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (837, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (838, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (839, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (840, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (841, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (842, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (843, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (844, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (845, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (846, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (847, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (848, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (849, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (850, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (851, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (852, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (853, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (854, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (855, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (856, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (857, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (858, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (859, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (860, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (861, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (862, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (863, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (864, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (865, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (866, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (867, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (868, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (869, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (870, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (871, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (872, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (873, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (874, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (875, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (876, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (877, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (878, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (879, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (880, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (881, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (882, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (883, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (884, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (885, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (886, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (887, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (888, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (889, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (890, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (891, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (892, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (893, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (894, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (895, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (896, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (897, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (898, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (899, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (900, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (901, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (902, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (903, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (904, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (905, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (906, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (907, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (908, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (909, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (910, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (911, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (912, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (913, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (914, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (915, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (916, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (917, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (918, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (919, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (920, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (921, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (922, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (923, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (924, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (925, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (926, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (927, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (928, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (929, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (930, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (931, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (932, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (933, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (934, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (935, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (936, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (937, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (938, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (939, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (940, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (941, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (942, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (943, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (944, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (945, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (946, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (947, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (948, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (949, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (950, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (951, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (952, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (953, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (954, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (955, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (956, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (957, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (958, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (959, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (960, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (961, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (962, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (963, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (964, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (965, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (966, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (967, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (968, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (969, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (970, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (971, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (972, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (973, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (974, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (975, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (976, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (977, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (978, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (979, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (980, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (981, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (982, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (983, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (984, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (985, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (986, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (987, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (988, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (989, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (990, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (991, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (992, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (993, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (994, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (995, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (996, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (997, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (998, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (999, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1000, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1001, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1002, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1003, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1004, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1005, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1006, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1007, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1008, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1009, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1010, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1011, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1012, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1013, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1014, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1015, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1016, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1017, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1018, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1019, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1020, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1021, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1022, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1023, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1024, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1025, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1026, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1027, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1028, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1029, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1030, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1031, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1032, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1033, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1034, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1035, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1036, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1037, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1038, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1039, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1040, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1041, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1042, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1043, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1044, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1045, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1046, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1047, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1048, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1049, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1050, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1051, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1052, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1053, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1054, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1055, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1056, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1057, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1058, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1059, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1060, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1061, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1062, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1063, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1064, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1065, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1066, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1067, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1068, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1069, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1070, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1071, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1072, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1073, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1074, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1075, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1076, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1077, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1078, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1079, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1080, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1081, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1082, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1083, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1084, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1085, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1086, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1087, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1088, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1089, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1090, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1091, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1092, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1093, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1094, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1095, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1096, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1097, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1098, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1099, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1100, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1101, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1102, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1103, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1104, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1105, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1106, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1107, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1108, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1109, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1110, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1111, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1112, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1113, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1114, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1115, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1116, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1117, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1118, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1119, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1120, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1121, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1122, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1123, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1124, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1125, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1126, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1127, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1128, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1129, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1130, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1131, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1132, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1133, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1134, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1135, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1136, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1137, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1138, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1139, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1140, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1141, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1142, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1143, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1144, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1145, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1146, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1147, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1148, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1149, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1150, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1151, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1152, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1153, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1154, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1155, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1156, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1157, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1158, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1159, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1160, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1161, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1162, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1163, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1164, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1165, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1166, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1167, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1168, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1169, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1170, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1171, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1172, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1173, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1174, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1175, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1176, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1177, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1178, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1179, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1180, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1181, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1182, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1183, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1184, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1185, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1186, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1187, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1188, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1189, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1190, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1191, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1192, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1193, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1194, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1195, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1196, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1197, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1198, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1199, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1200, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1201, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1202, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1203, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1204, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1205, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1206, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1207, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1208, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1209, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1210, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1211, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1212, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1213, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1214, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1215, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1216, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1217, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1218, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1219, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1220, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1221, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1222, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1223, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1224, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1225, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1226, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1227, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1228, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1229, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1230, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1231, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1232, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1233, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1234, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1235, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1236, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1237, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1238, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1239, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1240, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1241, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1242, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1243, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1244, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1245, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1246, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1247, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1248, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1249, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1250, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1251, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1252, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1253, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1254, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1255, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1256, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1257, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1258, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1259, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1260, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1261, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1262, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1263, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1264, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1265, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1266, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1267, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1268, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1269, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1270, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1271, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1272, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1273, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1274, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1275, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1276, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1277, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1278, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1279, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1280, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1281, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1282, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1283, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1284, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1285, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1286, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1287, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1288, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1289, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1290, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1291, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1292, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1293, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1294, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1295, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1296, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1297, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1298, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1299, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1300, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1301, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1302, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1303, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1304, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1305, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1306, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1307, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1308, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1309, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1310, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1311, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1312, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1313, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1314, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1315, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1316, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1317, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1318, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1319, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1320, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1321, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1322, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1323, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1324, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1325, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1326, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1327, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1328, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1329, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1330, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1331, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1332, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1333, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1334, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1335, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1336, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1337, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1338, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1339, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1340, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1341, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1342, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1343, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1344, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1345, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1346, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1347, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1348, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1349, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1350, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1351, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1352, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1353, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1354, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1355, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1356, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1357, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1358, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1359, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1360, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1361, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1362, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1363, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1364, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1365, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1366, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1367, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1368, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1369, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1370, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1371, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1372, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1373, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1374, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1375, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1376, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1377, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1378, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1379, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1380, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1381, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1382, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1383, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1384, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1385, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1386, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1387, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1388, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1389, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1390, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1391, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1392, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1393, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1394, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1395, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1396, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1397, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1398, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1399, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1400, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1401, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1402, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1403, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1404, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1405, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1406, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1407, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1408, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1409, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1410, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1411, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1412, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1413, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1414, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1415, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1416, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1417, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1418, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1419, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1420, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1421, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1422, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1423, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1424, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1425, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1426, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1427, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1428, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1429, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1430, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1431, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1432, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1433, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1434, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1435, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1436, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1437, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1438, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1439, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1440, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1441, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1442, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1443, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1444, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1445, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1446, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1447, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1448, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1449, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1450, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1451, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1452, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1453, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1454, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1455, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1456, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1457, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1458, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1459, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1460, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1461, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1462, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1463, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1464, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1465, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1466, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1467, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1468, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1469, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1470, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1471, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1472, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1473, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1474, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1475, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1476, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1477, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1478, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1479, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1480, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1481, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1482, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1483, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1484, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1485, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1486, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1487, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1488, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1489, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1490, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1491, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1492, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1493, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1494, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1495, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1496, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1497, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1498, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1499, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1500, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1501, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1502, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1503, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1504, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1505, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1506, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1507, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1508, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1509, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1510, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1511, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1512, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1513, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1514, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1515, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1516, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1517, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1518, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1519, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1520, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1521, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1522, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1523, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1524, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1525, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1526, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1527, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1528, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1529, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1530, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1531, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1532, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1533, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1534, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1535, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1536, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1537, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1538, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1539, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1540, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1541, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1542, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1543, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1544, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1545, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1546, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1547, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1548, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1549, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1550, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1551, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1552, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1553, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1554, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1555, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1556, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1557, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1558, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1559, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1560, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1561, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1562, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1563, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1564, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1565, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1566, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1567, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1568, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1569, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1570, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1571, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1572, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1573, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1574, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1575, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1576, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1577, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1578, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1579, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1580, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1581, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1582, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1583, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1584, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1585, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1586, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1587, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1588, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1589, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1590, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1591, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1592, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1593, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1594, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1595, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1596, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1597, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1598, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1599, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1600, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1601, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1602, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1603, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1604, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1605, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1606, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1607, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1608, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1609, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1610, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1611, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1612, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1613, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1614, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1615, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1616, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1617, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1618, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1619, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1620, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1621, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1622, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1623, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1624, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1625, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1626, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1627, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1628, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1629, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1630, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1631, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1632, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1633, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1634, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1635, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1636, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1637, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1638, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1639, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1640, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1641, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1642, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1643, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1644, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1645, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1646, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1647, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1648, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1649, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1650, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1651, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1652, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1653, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1654, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1655, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1656, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1657, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1658, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1659, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1660, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1661, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1662, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1663, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1664, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1665, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1666, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1667, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1668, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1669, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1670, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1671, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1672, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1673, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1674, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1675, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1676, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1677, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1678, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1679, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1680, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1681, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1682, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1683, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1684, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1685, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1686, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1687, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1688, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1689, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1690, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1691, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1692, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1693, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1694, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1695, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1696, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1697, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1698, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1699, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1700, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1701, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1702, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1703, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1704, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1705, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1706, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1707, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1708, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1709, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1710, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1711, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1712, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1713, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1714, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1715, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1716, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1717, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1718, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1719, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1720, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1721, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1722, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1723, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1724, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1725, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1726, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1727, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1728, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1729, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1730, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1731, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1732, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1733, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1734, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1735, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1736, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1737, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1738, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1739, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1740, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1741, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1742, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1743, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1744, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1745, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1746, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1747, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1748, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1749, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1750, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1751, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1752, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1753, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1754, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1755, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1756, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1757, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1758, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1759, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1760, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1761, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1762, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1763, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1764, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1765, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1766, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1767, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1768, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1769, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1770, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1771, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1772, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1773, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1774, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1775, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1776, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1777, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1778, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1779, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1780, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1781, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1782, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1783, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1784, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1785, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1786, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1787, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1788, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1789, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1790, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1791, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1792, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1793, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1794, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1795, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1796, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1797, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1798, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1799, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1800, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1801, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1802, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1803, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1804, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1805, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1806, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1807, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1808, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1809, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1810, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1811, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1812, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1813, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1814, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1815, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1816, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1817, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1818, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1819, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1820, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1821, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1822, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1823, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1824, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1825, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1826, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1827, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1828, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1829, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1830, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1831, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1832, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1833, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1834, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1835, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1836, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1837, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1838, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1839, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1840, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1841, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1842, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1843, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1844, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1845, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1846, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1847, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1848, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1849, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1850, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1851, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1852, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1853, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1854, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1855, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1856, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1857, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1858, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1859, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1860, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1861, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1862, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1863, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1864, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1865, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1866, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1867, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1868, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1869, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1870, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1871, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1872, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1873, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1874, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1875, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1876, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1877, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1878, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1879, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1880, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1881, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1882, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1883, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1884, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1885, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1886, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1887, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1888, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1889, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1890, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1891, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1892, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1893, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1894, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1895, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1896, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1897, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1898, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1899, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1900, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1901, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1902, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1903, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1904, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1905, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1906, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1907, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1908, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1909, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1910, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1911, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1912, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1913, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1914, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1915, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1916, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1917, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1918, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1919, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1920, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1921, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1922, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1923, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1924, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1925, 3, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1926, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1927, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1928, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1929, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1930, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1931, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1932, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1933, 5, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1934, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1935, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1936, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1937, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1938, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1939, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1940, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1941, 5, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1942, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1943, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1944, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1945, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1946, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1947, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1948, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1949, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1950, 2, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1951, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1952, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1953, 4, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1954, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1955, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1956, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1957, 1, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1958, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1959, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1960, 1, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1961, 3, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1962, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1963, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1964, 1, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1965, 3, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1966, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1967, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1968, 4, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1969, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1970, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1971, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1972, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1973, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1974, 1, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1975, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1976, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1977, 5, 4, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1978, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1979, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1980, 2, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1981, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1982, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1983, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1984, 3, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1985, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1986, 5, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1987, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1988, 2, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1989, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1990, 5, 2, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1991, 1, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1992, 3, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1993, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1994, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1995, 4, 5, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1996, 2, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1997, 4, 1, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1998, 4, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (1999, 2, 3, 1);
INSERT INTO public.score (id, score, movie_id, user_id)
VALUES (2000, 2, 3, 1);