delete from public.news;

INSERT INTO public.news(
    id, rubric, date, title, html_body, user_id)
VALUES (next value for public.gen_news, 'NEWS', '2022-08-03', 'db test title 01', 'nytipobody', null);
INSERT INTO public.news(
    id, rubric, date, title, html_body, user_id)
VALUES (next value for public.gen_news, 'NEWS', '2022-08-04', 'db test title 02', 'nytipobody', null);
INSERT INTO public.news(
    id, rubric, date, title, html_body, user_id)
VALUES (next value for public.gen_news, 'TESTS', '2022-08-05', 'db test title 03', 'nytipobody', null);

