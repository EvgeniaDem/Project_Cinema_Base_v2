INSERT INTO users(id, avatar_url, birthday, email, first_name, last_name, login,  password)
VALUES (200, 'url', '2022-08-14', 'admin@mail.ru', 'Имя1', 'Фамилия1', 'login_1', '$2a$11$Ig/7qJn7s0gllAzuvFU9vuF.FBUJKiJtzJc4xJmlnUcXklbo1QVO.');

INSERT INTO roles(id, name)
VALUES (200, 'ADMIN'),
       (100, 'USER');

INSERT INTO user_role(user_id, role_id)
VALUES (200, 200),
       (200, 100);
