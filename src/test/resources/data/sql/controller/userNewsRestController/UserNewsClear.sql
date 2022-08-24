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