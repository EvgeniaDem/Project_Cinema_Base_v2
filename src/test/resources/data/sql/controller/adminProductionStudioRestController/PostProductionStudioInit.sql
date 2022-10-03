delete from public.production_studios;
delete from public.user_role;
delete from public.roles;
delete from public.users;

INSERT INTO users(id, avatar_url, birthday, email, first_name, last_name, login, password)
VALUES (1, 'url', '2022-08-14', 'admin@mail.ru', 'Имя1', 'Фамилия1', 'login1', '$2a$11$Ig/7qJn7s0gllAzuvFU9vuF.FBUJKiJtzJc4xJmlnUcXklbo1QVO.');

INSERT INTO roles(id, name)
VALUES (1, 'ADMIN');

INSERT INTO user_role(user_id, role_id)
VALUES (1, 1);