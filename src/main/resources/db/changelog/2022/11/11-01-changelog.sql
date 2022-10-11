-- liquibase formatted sql

-- changeset Евгения:1665486561500-3
ALTER TABLE score
    ADD date date;

-- changeset Евгения:1665486561500-4
CREATE UNIQUE INDEX "IX_pk_movie_person" ON movie_person (person_id, movie_id, profession_id);

-- changeset Евгения:1665486561500-1
ALTER TABLE excertion ALTER COLUMN description TYPE TEXT USING (description::TEXT);

-- changeset Евгения:1665486561500-2
ALTER TABLE movies
    ALTER COLUMN time SET NOT NULL;

