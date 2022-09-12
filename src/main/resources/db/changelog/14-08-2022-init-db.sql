create sequence gen_awards start 1 increment 50;
create sequence gen_awards_ceremony start 1 increment 50;
create sequence gen_awards_ceremony_result start 1 increment 50;
create sequence gen_collections start 1 increment 50;
create sequence gen_comment start 1 increment 50;
create sequence gen_content start 1 increment 50;
create sequence gen_folder_movies start 1 increment 50;
create sequence gen_folder_person start 1 increment 50;
create sequence gen_genres start 1 increment 50;
create sequence gen_movies start 1 increment 50;
create sequence gen_news start 1 increment 50;
create sequence gen_nomination start 1 increment 50;
create sequence gen_person_marriage start 1 increment 50;
create sequence gen_profession start 1 increment 50;
create sequence gen_role start 1 increment 50;
create sequence gen_score start 1 increment 50;
create sequence gen_user start 1 increment 50;
create sequence person start 1 increment 50;

-- changeset Daniil_Kulikov:1660458159432-18
CREATE TABLE awards
(
    id          BIGINT NOT NULL,
    name        VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_awards PRIMARY KEY (id)
);

-- changeset Daniil_Kulikov:1660458159432-19
CREATE TABLE awards_ceremony
(
    id          BIGINT NOT NULL,
    date_event  VARCHAR(255),
    place_event VARCHAR(255),
    awards_id   BIGINT,
    CONSTRAINT pk_awardsceremony PRIMARY KEY (id)
);

-- changeset Daniil_Kulikov:1660458159432-20
CREATE TABLE awards_ceremony_result
(
    id                 BIGINT NOT NULL,
    person_id          BIGINT,
    movie_id           BIGINT,
    nomination_id      BIGINT,
    awards_ceremony_id BIGINT,
    nomination_status  VARCHAR(255),
    CONSTRAINT pk_awardsceremonyresult PRIMARY KEY (id)
);

-- changeset Daniil_Kulikov:1660458159432-21
CREATE TABLE collections
(
    id     BIGINT NOT NULL,
    name   VARCHAR(255),
    enable VARCHAR(255),
    CONSTRAINT pk_collections PRIMARY KEY (id)
);

-- changeset Daniil_Kulikov:1660458159432-22
CREATE TABLE collections_movies
(
    collections_id BIGINT NOT NULL,
    movies_id      BIGINT NOT NULL,
    CONSTRAINT pk_collections_movies PRIMARY KEY (collections_id, movies_id)
);

-- changeset Daniil_Kulikov:1660458159432-23
CREATE TABLE content
(
    id          BIGINT NOT NULL,
    content_url VARCHAR(255),
    movie_id    BIGINT,
    type        VARCHAR(255),
    CONSTRAINT pk_content PRIMARY KEY (id)
);

-- changeset Daniil_Kulikov:1660458159432-24
CREATE TABLE folders_movies
(
    id          BIGINT NOT NULL,
    category    VARCHAR(255),
    user_id     BIGINT,
    privacy     VARCHAR(255),
    name        VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_folders_movies PRIMARY KEY (id)
);

-- changeset Daniil_Kulikov:1660458159432-25
CREATE TABLE folders_movies_to_movies
(
    folders_id BIGINT NOT NULL,
    movie_id   BIGINT NOT NULL,
    CONSTRAINT pk_folders_movies_to_movies PRIMARY KEY (folders_id, movie_id)
);

-- changeset Daniil_Kulikov:1660458159432-26
CREATE TABLE folders_persons
(
    id          BIGINT NOT NULL,
    favourites  BOOLEAN,
    user_id     BIGINT,
    privacy     VARCHAR(255),
    name        VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_folders_persons PRIMARY KEY (id)
);

-- changeset Daniil_Kulikov:1660458159432-27
CREATE TABLE genres
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_genres PRIMARY KEY (id)
);

-- changeset Daniil_Kulikov:1660458159432-28
CREATE TABLE movie_genre
(
    genre_id BIGINT NOT NULL,
    movie_id BIGINT NOT NULL,
    CONSTRAINT pk_movie_genre PRIMARY KEY (genre_id, movie_id)
);

-- changeset Daniil_Kulikov:1660458159432-29
CREATE TABLE movie_person
(
    person_id     BIGINT NOT NULL,
    movie_id      BIGINT NOT NULL,
    profession_id BIGINT NOT NULL,
    type_person   VARCHAR(255),
    name_role     VARCHAR(255),
    CONSTRAINT pk_movie_person PRIMARY KEY (person_id, movie_id, profession_id)
);

-- changeset Daniil_Kulikov:1660458159432-30
CREATE TABLE movies
(
    id           BIGINT  NOT NULL,
    name         VARCHAR(255),
    countries    VARCHAR(255),
    date_release date,
    rars         varchar(255),
    mpaa         varchar(255),
    time         INTEGER,
    description  VARCHAR(255),
    origin_name  VARCHAR(255),
    CONSTRAINT pk_movies PRIMARY KEY (id)
);

-- changeset Daniil_Kulikov:1660458159432-31
CREATE TABLE news
(
    id        BIGINT       NOT NULL,
    rubric    VARCHAR(255) NOT NULL,
    date      date         NOT NULL,
    title     VARCHAR(255) NOT NULL,
    html_body VARCHAR(255) NOT NULL,
    user_id   BIGINT,
    CONSTRAINT pk_news PRIMARY KEY (id)
);

-- changeset Daniil_Kulikov:1660458159432-32
CREATE TABLE news_movie
(
    movie_id BIGINT NOT NULL,
    news_id  BIGINT NOT NULL,
    CONSTRAINT pk_news_movie PRIMARY KEY (movie_id, news_id)
);

-- changeset Daniil_Kulikov:1660458159432-34
CREATE TABLE nomination
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_nomination PRIMARY KEY (id)
);

-- changeset Daniil_Kulikov:1660458159432-35
CREATE TABLE persons
(
    id             BIGINT       NOT NULL,
    first_name     VARCHAR(255) NOT NULL,
    last_name      VARCHAR(255),
    height         DOUBLE PRECISION,
    birthday       TIMESTAMP WITHOUT TIME ZONE,
    place_birthday VARCHAR(255),
    CONSTRAINT pk_persons PRIMARY KEY (id)
);

-- changeset Daniil_Kulikov:1660458159432-36
CREATE TABLE persons_marriage
(
    id              BIGINT NOT NULL,
    person_id       BIGINT,
    human_id        BIGINT,
    marriage_status VARCHAR(255),
    CONSTRAINT pk_persons_marriage PRIMARY KEY (id)
);

-- changeset Daniil_Kulikov:1660458159432-37
CREATE TABLE professions
(
    id   BIGINT       NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_professions PRIMARY KEY (id)
);

-- changeset Daniil_Kulikov:1660458159432-38
CREATE TABLE roles
(
    id   BIGINT       NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

-- changeset Daniil_Kulikov:1660458159432-39
CREATE TABLE score
(
    id       BIGINT NOT NULL,
    score    BIGINT,
    movie_id BIGINT,
    user_id  BIGINT,
    CONSTRAINT pk_score PRIMARY KEY (id)
);

-- changeset Daniil_Kulikov:1660458159432-40
CREATE TABLE user_role
(
    role_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT pk_user_role PRIMARY KEY (role_id, user_id)
);

-- changeset Daniil_Kulikov:1660458159432-41
CREATE TABLE users
(
    id         BIGINT       NOT NULL,
    email      VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255),
    password   VARCHAR(255) NOT NULL,
    birthday   date,
    avatar_url VARCHAR(255),
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE comments
(
    id BIGINT not null,
    date timestamp not null,
    text varchar(255),
    news_id int8 not null,
    user_id int8 not null,
    primary key (id)
);


-- changeset Daniil_Kulikov:1660458159432-42
ALTER TABLE persons_marriage
    ADD CONSTRAINT uc_28ef9ec715257f5c99f15ec0e UNIQUE (person_id, human_id);

-- changeset Daniil_Kulikov:1660458159432-43
ALTER TABLE professions
    ADD CONSTRAINT uc_professions_name UNIQUE (name);

-- changeset Daniil_Kulikov:1660458159432-44
ALTER TABLE roles
    ADD CONSTRAINT uc_roles_name UNIQUE (name);

-- changeset Daniil_Kulikov:1660458159432-45
ALTER TABLE awards_ceremony_result
    ADD CONSTRAINT FK_AWARDSCEREMONYRESULT_ON_AWARDS_CEREMONY FOREIGN KEY (awards_ceremony_id) REFERENCES awards_ceremony (id);

-- changeset Daniil_Kulikov:1660458159432-46
ALTER TABLE awards_ceremony_result
    ADD CONSTRAINT FK_AWARDSCEREMONYRESULT_ON_MOVIE FOREIGN KEY (movie_id) REFERENCES movies (id);

-- changeset Daniil_Kulikov:1660458159432-47
ALTER TABLE awards_ceremony_result
    ADD CONSTRAINT FK_AWARDSCEREMONYRESULT_ON_NOMINATION FOREIGN KEY (nomination_id) REFERENCES nomination (id);

-- changeset Daniil_Kulikov:1660458159432-48
ALTER TABLE awards_ceremony_result
    ADD CONSTRAINT FK_AWARDSCEREMONYRESULT_ON_PERSON FOREIGN KEY (person_id) REFERENCES persons (id);

-- changeset Daniil_Kulikov:1660458159432-49
ALTER TABLE awards_ceremony
    ADD CONSTRAINT FK_AWARDSCEREMONY_ON_AWARDS FOREIGN KEY (awards_id) REFERENCES awards (id);

-- changeset Daniil_Kulikov:1660458159432-50
ALTER TABLE content
    ADD CONSTRAINT FK_CONTENT_ON_MOVIE FOREIGN KEY (movie_id) REFERENCES movies (id);

-- changeset Daniil_Kulikov:1660458159432-51
ALTER TABLE folders_movies
    ADD CONSTRAINT FK_FOLDERS_MOVIES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

-- changeset Daniil_Kulikov:1660458159432-52
ALTER TABLE folders_persons
    ADD CONSTRAINT FK_FOLDERS_PERSONS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

-- changeset Daniil_Kulikov:1660458159432-53
ALTER TABLE movie_person
    ADD CONSTRAINT FK_MOVIE_PERSON_ON_MOVIE FOREIGN KEY (movie_id) REFERENCES movies (id);

-- changeset Daniil_Kulikov:1660458159432-54
ALTER TABLE movie_person
    ADD CONSTRAINT FK_MOVIE_PERSON_ON_PERSON FOREIGN KEY (person_id) REFERENCES persons (id);

-- changeset Daniil_Kulikov:1660458159432-55
ALTER TABLE movie_person
    ADD CONSTRAINT FK_MOVIE_PERSON_ON_PROFESSION FOREIGN KEY (profession_id) REFERENCES professions (id);

-- changeset Daniil_Kulikov:1660458159432-56
ALTER TABLE news
    ADD CONSTRAINT FK_NEWS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

-- changeset Daniil_Kulikov:1660458159432-57
ALTER TABLE persons_marriage
    ADD CONSTRAINT FK_PERSONS_MARRIAGE_ON_HUMAN FOREIGN KEY (human_id) REFERENCES persons (id);

-- changeset Daniil_Kulikov:1660458159432-58
ALTER TABLE persons_marriage
    ADD CONSTRAINT FK_PERSONS_MARRIAGE_ON_PERSON FOREIGN KEY (person_id) REFERENCES persons (id);

-- changeset Daniil_Kulikov:1660458159432-59
ALTER TABLE score
    ADD CONSTRAINT FK_SCORE_ON_MOVIE FOREIGN KEY (movie_id) REFERENCES movies (id);

-- changeset Daniil_Kulikov:1660458159432-60
ALTER TABLE score
    ADD CONSTRAINT FK_SCORE_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

-- changeset Daniil_Kulikov:1660458159432-61
ALTER TABLE collections_movies
    ADD CONSTRAINT fk_colmov_on_collections FOREIGN KEY (collections_id) REFERENCES collections (id);

-- changeset Daniil_Kulikov:1660458159432-62
ALTER TABLE collections_movies
    ADD CONSTRAINT fk_colmov_on_movies FOREIGN KEY (movies_id) REFERENCES movies (id);

-- changeset Daniil_Kulikov:1660458159432-63
ALTER TABLE folders_movies_to_movies
    ADD CONSTRAINT fk_folmovtomov_on_folder_movies FOREIGN KEY (folders_id) REFERENCES folders_movies (id);

-- changeset Daniil_Kulikov:1660458159432-64
ALTER TABLE folders_movies_to_movies
    ADD CONSTRAINT fk_folmovtomov_on_movies FOREIGN KEY (movie_id) REFERENCES movies (id);

-- changeset Daniil_Kulikov:1660458159432-65
ALTER TABLE movie_genre
    ADD CONSTRAINT fk_movgen_on_genres FOREIGN KEY (genre_id) REFERENCES genres (id);

-- changeset Daniil_Kulikov:1660458159432-66
ALTER TABLE movie_genre
    ADD CONSTRAINT fk_movgen_on_movies FOREIGN KEY (movie_id) REFERENCES movies (id);

-- changeset Daniil_Kulikov:1660458159432-67
ALTER TABLE news_movie
    ADD CONSTRAINT fk_newmov_on_movies FOREIGN KEY (movie_id) REFERENCES movies (id);

-- changeset Daniil_Kulikov:1660458159432-68
ALTER TABLE news_movie
    ADD CONSTRAINT fk_newmov_on_news FOREIGN KEY (news_id) REFERENCES news (id);

-- changeset Daniil_Kulikov:1660458159432-69
ALTER TABLE user_role
    ADD CONSTRAINT fk_user_role_on_role FOREIGN KEY (role_id) REFERENCES roles (id);

-- changeset Daniil_Kulikov:1660458159432-70
ALTER TABLE user_role
    ADD CONSTRAINT fk_user_role_on_user FOREIGN KEY (user_id) REFERENCES users (id);

alter table if exists comments
    add constraint FKqx89vg0vuof2ninmn5x5eqau2
    foreign key (news_id)
    references news;

alter table if exists comments
    add constraint FK8omq0tc18jd43bu5tjh6jvraq
    foreign key (user_id)
    references users;

