

-- users init
INSERT INTO users (id, avatar_url, birthday, email, first_name, last_name, login, password)
VALUES (1, null, '2022-08-14', 'user1@mail.ru', 'user1', 'userovich1', 'login1', '$2a$12$/FIhv2k1jeNx5YCr6bZLlujKpN5V8V3j7qD16WtMC9Ov/tVhyjUIW'); -- password == 101
INSERT INTO users (id, avatar_url, birthday, email, first_name, last_name, login, password)
VALUES (2, null, '2022-08-15', 'user2@mail.ru', 'user2', 'userovich2', 'login2', '$2a$12$eJQNiWAf01OGGrzY4dYMludZGSZG06myrpsjH0P3SzH7IRbO624h6'); -- password == 102
INSERT INTO users (id, avatar_url, birthday, email, first_name, last_name, login, password)
VALUES (3, null, '2022-08-11', 'user3@mail.ru', 'user3', 'userovich3', 'login3', '$2a$12$kxj107giVr0cwRRy6csu8OAgML4fiofnZ/YIR.C7P.kAHe2Cr2kru'); -- password == 103


--Movies init
INSERT INTO movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (1, 'Rus', '2022-08-14', '1 test', 1, '1', '11', 1, 100);
INSERT INTO movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (2, 'Rus', '2022-08-15', '2 test', 2, '2', '22', 2, 100);
INSERT INTO movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (3, 'Eng', '2022-08-16', '3 test', 3, '3', '33', 3, 100);
INSERT INTO movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (4, 'Eng', '2022-08-15', '4 test', 4, '4', '44', 4, 100);
INSERT INTO movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (5, 'Gen', '2022-08-15', '5 test', 5, '5', '55', 5, 100);
INSERT INTO movies (id, countries, date_release, description, mpaa, name, original_name, rars, time)
VALUES (999, 'Gen', current_date+1, 'release test', 5, 'release', 'release', 5, 100); --Movie for release test

--Review init
insert into reviews(id, type_review, title, description, date, movie_id, user_id)
values (1,'POSITIVE','title1','description1', '2022-01-01', 1, 1);
insert into reviews(id, type_review, title, description, date, movie_id, user_id)
values (2,'NEGATIVE','title2','description2', '2022-01-02', 2, 2);
insert into reviews(id, type_review, title, description, date, movie_id, user_id)
values (3,'NEUTRAL','title3','description3', '2022-01-03', 3, 3);

--ReactionReview init
insert into reaction_review(id, rating, review_id, user_id)
values (1, 'LIKE', 1, 2);
insert into reaction_review(id, rating, review_id, user_id)
values (2, 'DISLIKE', 1, 2);
insert into reaction_review(id, rating, review_id, user_id)
values (3, 'LIKE', 1, 2);
