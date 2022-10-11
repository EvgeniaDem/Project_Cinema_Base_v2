-- liquibase formatted sql

-- changeset Евгения:1665487520647-5
CREATE UNIQUE INDEX "IX_pk_movie_person" ON movie_person (person_id, movie_id, profession_id);

-- changeset Евгения:1665487520647-1
ALTER TABLE excertion ALTER COLUMN description TYPE TEXT USING (description::TEXT);

-- changeset Евгения:1665487520647-2
ALTER TABLE score DROP COLUMN score;

-- changeset Евгения:1665487520647-3
ALTER TABLE score
    ADD score INTEGER;

-- changeset Евгения:1665487520647-4
ALTER TABLE movies
    ALTER COLUMN time SET NOT NULL;

