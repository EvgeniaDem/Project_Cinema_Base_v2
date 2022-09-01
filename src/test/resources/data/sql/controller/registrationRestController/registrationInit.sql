INSERT INTO users(id, avatar_url, birthday, email, first_name, last_name, password)
VALUES (100, 'url', '2022-08-14', 'admin@mail.ru', 'Имя1', 'Фамилия1', '$2a$11$Ig/7qJn7s0gllAzuvFU9vuF.FBUJKiJtzJc4xJmlnUcXklbo1QVO.');

INSERT INTO roles(id, name)
VALUES (100, 'ADMIN');

INSERT INTO user_role(user_id, role_id)
VALUES (100, 100);