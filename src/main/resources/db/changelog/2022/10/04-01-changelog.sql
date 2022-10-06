-- liquibase formatted sql

-- changeset Admin:1664877046304-4
CREATE SEQUENCE IF NOT EXISTS gen_person START WITH 1 INCREMENT BY 50;

-- changeset Admin:1664877046304-5
CREATE SEQUENCE IF NOT EXISTS gen_production_studios_movies START WITH 1 INCREMENT BY 50;

-- changeset Admin:1664877046304-6
CREATE SEQUENCE IF NOT EXISTS gen_productions_studios START WITH 1 INCREMENT BY 50;

-- changeset Admin:1664877046304-7
CREATE SEQUENCE IF NOT EXISTS gen_studios_performance START WITH 1 INCREMENT BY 50;

-- changeset Admin:1664877046304-8
CREATE TABLE production_studios
(
    id              BIGINT       NOT NULL,
    name            VARCHAR(255) NOT NULL,
    description     VARCHAR(255),
    date_foundation date         NOT NULL,
    CONSTRAINT pk_production_studios PRIMARY KEY (id)
);

-- changeset Admin:1664877046304-9
CREATE TABLE production_studios_movies
(
    id             BIGINT NOT NULL,
    movie_id       BIGINT NOT NULL,
    studio_id      BIGINT NOT NULL,
    performance_id BIGINT NOT NULL,
    CONSTRAINT pk_production_studios_movies PRIMARY KEY (id)
);

-- changeset Admin:1664877046304-10
CREATE TABLE studios_performance
(
    id   BIGINT       NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_studios_performance PRIMARY KEY (id)
);

-- changeset Admin:1664877046304-11
ALTER TABLE collections
    ADD description VARCHAR(255);

-- changeset Admin:1664877046304-12
ALTER TABLE production_studios_movies
    ADD CONSTRAINT uc_9d23f75211a07ffb84aa09cb1 UNIQUE (movie_id, studio_id);

-- changeset Admin:1664877046304-13
CREATE UNIQUE INDEX "IX_pk_movie_person" ON movie_person (person_id, movie_id, profession_id);

-- changeset Admin:1664877046304-14
ALTER TABLE production_studios_movies
    ADD CONSTRAINT FK_PRODUCTION_STUDIOS_MOVIES_ON_MOVIE FOREIGN KEY (movie_id) REFERENCES movies (id);

-- changeset Admin:1664877046304-15
ALTER TABLE production_studios_movies
    ADD CONSTRAINT FK_PRODUCTION_STUDIOS_MOVIES_ON_PERFORMANCE FOREIGN KEY (performance_id) REFERENCES studios_performance (id);

-- changeset Admin:1664877046304-16
ALTER TABLE production_studios_movies
    ADD CONSTRAINT FK_PRODUCTION_STUDIOS_MOVIES_ON_STUDIO FOREIGN KEY (studio_id) REFERENCES production_studios (id);

-- changeset Admin:1664877046304-18
DROP SEQUENCE person CASCADE;

-- changeset Admin:1664877046304-1
ALTER TABLE persons DROP COLUMN birthday;

-- changeset Admin:1664877046304-2
ALTER TABLE persons
    ADD birthday date;

-- changeset Admin:1664877046304-3
ALTER TABLE movies
    ALTER COLUMN time SET NOT NULL;

