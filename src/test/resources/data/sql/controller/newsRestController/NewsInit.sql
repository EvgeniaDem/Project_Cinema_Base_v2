delete
from public.users;

alter table news
    drop constraint fki09n75txtudw1kawj5o7i8xag cascade;

ALTER TABLE public.news
    ADD CONSTRAINT fki09n75txtudw1kawj5o7i8xag FOREIGN KEY (user_id)
        REFERENCES public.users (id) ON DELETE CASCADE;

delete
from public.news;

alter table public.comments
    drop constraint fk8omq0tc18jd43bu5tjh6jvraq cascade;

ALTER TABLE public.comments
    ADD CONSTRAINT fk8omq0tc18jd43bu5tjh6jvraq FOREIGN KEY (user_id)
        REFERENCES public.users (id) ON DELETE CASCADE;

alter table public.comments
    drop constraint fkqx89vg0vuof2ninmn5x5eqau2 cascade;

ALTER TABLE public.comments
    ADD CONSTRAINT fkqx89vg0vuof2ninmn5x5eqau2 FOREIGN KEY (news_id)
        REFERENCES public.users (id) ON DELETE CASCADE;

delete
from public.comments;

INSERT INTO public.users (id, avatar_url, birthday, email, first_name, last_name, password)
VALUES (1, null, '2022-08-14', '1', '1', '1', '1');
INSERT INTO public.users (id, avatar_url, birthday, email, first_name, last_name, password)
VALUES (2, null, '2022-07-14', '1', '1', '1', '1');
INSERT INTO public.users (id, avatar_url, birthday, email, first_name, last_name, password)
VALUES (3, null, '2022-06-14', '1', '1', '1', '1');

INSERT INTO public.news(id, rubric, date, title, html_body, user_id)
VALUES (1, 'NEWS', '2022-08-03', 'db test title 01', 'nytipobody', 1);
INSERT INTO public.news(id, rubric, date, title, html_body, user_id)
VALUES (2, 'NEWS', '2022-08-04', 'db test title 02', 'nytipobody', 2);
INSERT INTO public.news(id, rubric, date, title, html_body, user_id)
VALUES (3, 'TESTS', '2022-08-05', 'db test title 03', 'nytipobody', 3);

INSERT INTO public.comments(id, date, text, news_id, user_id)
VALUES (1, '2022-08-20 03:07:04.000000', 'test comment 01', 1, 1);
