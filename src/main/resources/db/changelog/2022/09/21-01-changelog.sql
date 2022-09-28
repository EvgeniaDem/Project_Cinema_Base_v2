-- liquibase formatted sql

-- changeset Admin:1663768538386-4
CREATE UNIQUE INDEX "IX_pk_movie_person" ON movie_person (person_id, movie_id, profession_id);

-- changeset Admin:1663768538386-5
ALTER TABLE reviews DROP CONSTRAINT fk87tlqya0rq8ijfjscldpvvdyq;

-- changeset Admin:1663768538386-6
ALTER TABLE reviews DROP CONSTRAINT fkcgy7qjc1r99dp117y9en6lxye;

-- changeset Admin:1663768538386-7
DROP TABLE reviews CASCADE;

-- changeset Admin:1663768538386-9
ALTER TABLE collections DROP COLUMN collection_url;

-- changeset Admin:1663768538386-10
DROP SEQUENCE gen_review CASCADE;

-- changeset Admin:1663768538386-1
ALTER TABLE movie_tickets DROP COLUMN end_show_date;

-- changeset Admin:1663768538386-2
ALTER TABLE movie_tickets
    ADD end_show_date date;

-- changeset Admin:1663768538386-3
ALTER TABLE movies
    ALTER COLUMN time SET NOT NULL;

